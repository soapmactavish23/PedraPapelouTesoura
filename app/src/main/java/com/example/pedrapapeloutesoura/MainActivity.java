package com.example.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txtRes;
    private ImageView imgRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionouPedra(View view){
        opcaoSelecionada("pedra");
    }

    public void selecionouPapel(View view){
        opcaoSelecionada("papel");
    }

    public void selecionouTesoura(View view){
        opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){
        imgRes = (ImageView) findViewById(R.id.imgRes);
        txtRes = (TextView) findViewById(R.id.txtRes);

        int num = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[num];

        switch (opcaoApp){
            case "pedra":
                imgRes.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgRes.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgRes.setImageResource(R.drawable.tesoura);
                break;
        }
        //App Ganhou
        if((opcaoApp == "tesoura" && escolhaUsuario == "papel")
                || (opcaoApp == "pedra" && escolhaUsuario == "tesoura")
                || (opcaoApp == "papel" && escolhaUsuario == "pedra")){
            txtRes.setText("Você Perdeu! :(");
        }else if((escolhaUsuario == "tesoura" && opcaoApp == "papel")
                || (escolhaUsuario == "pedra" && opcaoApp == "tesoura")
                || (escolhaUsuario == "papel" && opcaoApp == "pedra")){
            //Usuario Ganhou
            txtRes.setText("Você Venceu! :)");
        }else{
            //Empate
            txtRes.setText("Empatou! ");
        }


    }

}
