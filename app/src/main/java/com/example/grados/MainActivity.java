package com.example.grados;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView txt,resul;
    private Button cel, fah;
    private EditText edit;
    private int valor1,resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //textview
        txt = findViewById(R.id.text);
        resul = findViewById(R.id.resultado);
        //botones
        cel = findViewById(R.id.celsius);
        fah = findViewById(R.id.fahrenheit);
        //editable
        edit = findViewById(R.id.num);
        cel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor1 = Integer.parseInt(edit.getText().toString());

                resultado = (valor1 - 32) * 5 / 9 ;
                resul.setText(valor1+" Fahrenheit son "+resultado+" celsius" );
            }

        });
        fah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor1 = Integer.parseInt(edit.getText().toString());
                resultado = (valor1 * 9 / 5) + 32;
                resul.setText(valor1+" celsius son "+resultado+" Fahrenheit" );
            }

        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}