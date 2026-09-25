package com.example.myapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IMC extends AppCompatActivity {
    Button botaoVoltar, botaoAvancao;
    ImageView imageView;

    Integer[] imagens= new Integer[]{
            R.drawable.cachorro,
            R.drawable.gardem,
            R.drawable.happy,
            R.drawable.patinho,
            R.drawable.porquinho};
int posicao = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        botaoVoltar = findViewById(R.id.btnAnterior);
        botaoAvancao = findViewById(R.id.bntProximo);
        imageView = findViewById(R.id.imageView);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        botaoAvancao.setOnClickListener(view -> {
            if (posicao > imagens.length) posicao = 0;
            imageView.setImageResource(imagens[posicao]);
            posicao++;

        });

         botaoVoltar.setOnClickListener(view -> {
             imageView.setImageResource(imagens[posicao]);
             posicao++;
             if (posicao < 0) posicao = -1;
         });

    }}