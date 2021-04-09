package com.example.dadoschave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static String KEY_NOME = "minha.key.nome";
    private static String KEY_PONTOS = "minha.key.pontos";
    private static String FILE_NAME = "br.com.aplicacao.file.key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void salvarChave(View view) {
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_NOME, ((EditText) findViewById(R.id.key1)).getText().toString());
        editor.putInt(KEY_PONTOS, Integer.parseInt(((EditText) findViewById(R.id.value1)).getText().toString()));
        editor.commit();
    }

    public void lerChave(View view) {
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        String nome = preferences.getString(KEY_NOME, "PADRÃO");
        int pontos = preferences.getInt(KEY_PONTOS, 0);

        ((EditText) findViewById(R.id.key1)).setText(nome);
        ((EditText) findViewById(R.id.value1)).setText(String.valueOf(pontos));

    }

    public void salvarChaveArquivo(View view) {
        SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_NOME, ((EditText) findViewById(R.id.key2)).getText().toString());
        editor.putInt(KEY_PONTOS, Integer.parseInt(((EditText) findViewById(R.id.value2)).getText().toString()));
        editor.commit();

    }

    public void lerChaveArquivo(View view) {
        SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        String nome = preferences.getString(KEY_NOME, "PADRÃO");
        int pontos = preferences.getInt(KEY_PONTOS, 0);

        ((EditText) findViewById(R.id.key2)).setText(nome);
        ((EditText) findViewById(R.id.value2)).setText(String.valueOf(pontos));
    }

}