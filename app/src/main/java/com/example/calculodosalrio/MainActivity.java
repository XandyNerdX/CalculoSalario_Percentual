package com.example.calculodosalrio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox_40, checkBox_45, checkBox_50;
    private EditText Salario;
    private TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Salario = findViewById(R.id.Salario);
        checkBox_40 = findViewById(R.id.Percentual_40);
        checkBox_45 = findViewById(R.id.Percentual_45);
        checkBox_50 = findViewById(R.id.Percentual_50);
        Resultado = findViewById(R.id.Resultado); // Adicione esta linha

        checkBox_40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTotal();
            }
        });

        checkBox_45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTotal();
            }
        });

        checkBox_50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTotal();
            }
        });
    }

    private void calcularTotal() {
        // Obter o valor do EditText Salario
        String salarioText = Salario.getText().toString();

        // Verificar se o campo de salário está vazio
        if (salarioText.isEmpty()) {
            Toast.makeText(this, "Por favor, insira um valor de salário.", Toast.LENGTH_SHORT).show();
            Resultado.setTextColor(getResources().getColor(R.color.red));
            Resultado.setVisibility(View.VISIBLE); // Tornar o TextView visível
            Resultado.setText("Por favor, insira um valor de salário.");
            return;
        }

        // Converter o valor do EditText para double
        double salario = Double.parseDouble(salarioText);
        double saldo = 0.0;

        // Implemente aqui o cálculo do saldo com base nos CheckBoxes selecionados
        if (checkBox_40.isChecked()) {
            // Aplicar a lógica para 40%
            saldo = salario * 0.4;
        }
        if (checkBox_45.isChecked()) {
            // Aplicar a lógica para 45%
            saldo = salario * 0.45;
        }
        if (checkBox_50.isChecked()) {
            // Aplicar a lógica para 50%
            saldo = salario * 0.5;
        }

        // Exibir o saldo calculado
        Resultado.setTextColor(getResources().getColor(R.color.black));
        Resultado.setVisibility(View.VISIBLE); // Tornar o TextView visível
        Resultado.setText("R$ " + saldo); // Corrija aqui para exibir o saldo calculado
        Toast.makeText(this, "Saldo calculado: " + saldo, Toast.LENGTH_SHORT).show();
    }
}
