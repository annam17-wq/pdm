package com.example.myapp;


import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util .ArrayList;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kotlin.collections.UArraySortingKt;

public class MainActivity extends AppCompatActivity {

List<String> nomes ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        nomes= new ArrayList<>();
        ListView listanomes = findViewById(R.id.listView);
        ArrayAdapter<String> usb = new ArrayAdapter<>(getApplicationContext(),
                R.layout.listaitens, R.id.textView, nomes);
        listanomes.setAdapter(usb);
        listanomes.setOnItemClickListener((adapterView, view, position, id) -> {
            Toast.makeText(getApplicationContext(),nomes.get(position), Toast.LENGTH_LONG).show();
        });

        Button  b= findViewById(R.id.b);

        b.setOnClickListener(view -> {
            EditText ed=findViewById(R.id.ed);
            String nome = ed.getText().toString();
            nomes.add(nome);
            usb.notifyDataSetChanged();
        });

    }
}