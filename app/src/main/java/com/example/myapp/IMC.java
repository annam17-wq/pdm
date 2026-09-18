package com.example.myapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
int posicao = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.IMC.java);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Integer[] imagens= new Integer[]{ R.drawable.cachorro, R.drawable.gardem, R.drawable.happy, R.drawable.patinho, R.drawable.porquinho};
        Button botaoVoltar, botaoAvancao;
        botaoVoltar = findViewById(R.id.btnAnterior);
        botaoAvancao = findViewById(R.id.bntProximo);
        ImageView imageView=findViewById(R.id.imageView);

        botaoAvancao.setOnClickListener(view -> {
            posicao++;
            imageView.setImageResourse(imagens[posicao]);

        });



    }}