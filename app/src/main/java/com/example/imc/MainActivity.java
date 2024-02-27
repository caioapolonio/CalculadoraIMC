package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText peso = findViewById(R.id.peso);
        EditText altura = findViewById(R.id.altura);
        Button botao = findViewById(R.id.btnCalc);
        TextView resultado = findViewById(R.id.resultado);
        TextView mensagem = findViewById(R.id.mensagem);


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float inputPeso = Float.parseFloat(String.valueOf(peso.getText()));
                float inputAltura = Float.parseFloat(String.valueOf(altura.getText()));
                float imc = inputPeso/(inputAltura * inputAltura);
                String formattedImc = String.format("%.1f", imc);
                resultado.setText(formattedImc);
                float imcFormatado = Float.parseFloat(formattedImc);
                if (imcFormatado < 18.5) {
                    mensagem.setText("Seu IMC está abaixo do peso normal. É importante manter uma dieta equilibrada e procurar orientação médica para garantir uma saúde adequada.");
                } else if (imcFormatado >= 18.5 && imcFormatado <= 24.9) {
                    mensagem.setText("Parabéns! Seu IMC está dentro da faixa considerada saudável. Continue mantendo um estilo de vida ativo e uma alimentação equilibrada.");
                } else if (imcFormatado >= 25.0 && imcFormatado <= 29.9) {
                    mensagem.setText("Você está na faixa de sobrepeso. Considere adotar hábitos mais saudáveis, como uma dieta balanceada e exercícios físicos regulares, para melhorar sua saúde geral.");
                } else if (imcFormatado >= 30.0 && imcFormatado <= 34.9) {
                    mensagem.setText("Você está na faixa de obesidade Grau I. Consulte um profissional de saúde para criar um plano personalizado de alimentação e exercícios.");
                }else if (imcFormatado >= 35.0 && imcFormatado <= 39.9) {
                    mensagem.setText("A sua obesidade é classificada como Grau II. É crucial buscar orientação médica para abordar questões relacionadas à saúde associadas ao excesso de peso.");
                } else {
                    mensagem.setText("Sua obesidade está na categoria mórbida. Procure ajuda profissional urgente para implementar mudanças significativas em sua dieta e estilo de vida.");
                }
            }
        });




    }
}