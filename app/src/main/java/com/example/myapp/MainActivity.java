package com.example.myapp;


import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

String nomes[] = new String[]{"Docinho52","Robson", "João", "Julia", "Kiara",
        "Brian", "Marcelo", "Boos", "Benica"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView listanomes = findViewById(R.id.listView);
        ArrayAdapter<String> usb = new ArrayAdapter<>(getApplicationContext(),
                R.layout.listaitens, R.id.textView, nomes);
        listanomes.setAdapter(usb);
        listanomes.setOnItemClickListener((adapterView, view, position, id) -> {
            Toast.makeText(getApplicationContext(),nomes[position], Toast.LENGTH_LONG).show();
        });

    }
}