package com.example.myapp;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int contador=0;
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
        EditText edMin, edMax;
        edMin = findViewById(R.id.edMin);
        edMax = findViewById(R.id.edMax);

        TextView tv = findViewById(R.id.textView);
        Button b = findViewById(R.id.ButtonSortear);

        b.setOnClickListener( v -> {
            Random random = new Random();

            String smin = edMin.getText().toString();
            String smax = edMax.getText().toString();
            if (smin.trim().equals("")){
                edMin.setError("Informe um valor");
                edMin.requestFocus();
                return;
            }
            if (smax.trim().equals("")){
                edMax.setError("Informe um valor");
                edMax.requestFocus();
                return;
            }

            int min = Integer.parseInt(edMin.getText().toString());
            int max = Integer.parseInt(edMax.getText().toString());
            if (min>=max){
                edMax.setError("Valor máximo deve ser maior que o mínimo");
                return;
            }



            int r = (random.nextInt(max-min))+min;
            tv.setText(Integer.toString(r));
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);

            intent.putExtra("Valor", r);

            startActivity(intent);
        });
    };


}