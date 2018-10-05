package com.holamundo.tallercarrosclase;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Random;

public class AgregarCarros extends AppCompatActivity {
    private EditText txtPlaca, txtColor, txtPrecio;
    private Spinner cmbMarca;
    private ArrayAdapter<String> adapter;
    private String opc[];
    private ArrayList<Integer> fotos;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_carros);

        txtPlaca = findViewById(R.id.txtPlaca);
        txtColor = findViewById(R.id.txtColor);
        txtPrecio = findViewById(R.id.txtPrecio);
        cmbMarca = findViewById(R.id.cmbMarca);
        foto = findViewById(R.id.foto);

        fotos = new ArrayList<>();
        fotos.add(R.drawable.imagen1);
        fotos.add(R.drawable.imagen2);
        fotos.add(R.drawable.imagen3);
        fotos.add(R.drawable.imagen4);
        fotos.add(R.drawable.imagen5);

        opc = getResources().getStringArray(R.array.marca);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,opc);
        cmbMarca.setAdapter(adapter);
    }

    public int fotoAleatoria(){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(this.fotos.size());
        return fotos.get(fotoSeleccionada);
    }
    public void guardar(View v){
        String pla, col ;
        int foto, marca,pre;
        foto = this.fotoAleatoria();
        pla = txtPlaca.getText().toString();
        col = txtColor.getText().toString();
        pre = Integer.parseInt(txtPrecio.getText().toString());
        marca = cmbMarca.getSelectedItemPosition();
        Carros c = new Carros(foto,pla,col,pre,marca);
        c.guardar();
        limpiar();
        Snackbar.make(v,getResources().getString(R.string.guardado_exitoso),Snackbar.LENGTH_SHORT)
                .show();

    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(AgregarCarros.this,Principal.class);
        startActivity(i);
    }

    public void limpiar(){
        txtPlaca.setText("");
        txtColor.setText("");
        txtPrecio.setText("");
        cmbMarca.setSelection(0);
        txtPlaca.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void limpiar(View v){
        limpiar();
    }
}
