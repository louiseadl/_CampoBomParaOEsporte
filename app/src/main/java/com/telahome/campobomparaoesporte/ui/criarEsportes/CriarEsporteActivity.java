package com.telahome.campobomparaoesporte.ui.criarEsportes;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.telahome.campobomparaoesporte.R;

public class CriarEsporteActivity extends AppCompatActivity {

    private Button btCadastar;
    private Button btVoltar;
    private EditText etNome;
    private EditText etDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_esporte);
    }
}
