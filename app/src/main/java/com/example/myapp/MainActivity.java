package com.example.myapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private List<Nota> listaNotas;
    private ArrayAdapter<Nota> adapter;
    private ListView listView;
    private EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        listaNotas = dbHelper.obterTodasNotas();

        listView = findViewById(R.id.listView);
        ed = findViewById(R.id.ed);
        Button btnAdicionar = findViewById(R.id.b);

        adapter = new ArrayAdapter<>(this, R.layout.listaitens, R.id.textView, listaNotas);
        listView.setAdapter(adapter);

        btnAdicionar.setOnClickListener(view -> {
            String textoDigitado = ed.getText().toString().trim();
            if (!textoDigitado.isEmpty()) {
                String titulo = "Nota " + (listaNotas.size() + 1);
                long result = dbHelper.inserirNota(titulo, textoDigitado);
                if (result != -1) {
                    atualizarLista();
                    ed.setText("");
                    Toast.makeText(getApplicationContext(), "Nota inserida com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Erro ao inserir nota", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Digite o texto da nota", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void atualizarLista() {
        listaNotas.clear();
        listaNotas.addAll(dbHelper.obterTodasNotas());
        adapter.notifyDataSetChanged();
    }
}
