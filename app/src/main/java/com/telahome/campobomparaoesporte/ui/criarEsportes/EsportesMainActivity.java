package com.telahome.campobomparaoesporte.ui.criarEsportes;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.telahome.campobomparaoesporte.R;

public class EsportesMainActivity extends AppCompatActivity {

    private Button btVoltar;
    private Button btCriar;
    private Button btExcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esportes_main);
    }

    private void start(){
        btCriar = findViewById(R.id.bt_cadastrar_esportee);
        btVoltar = findViewById(R.id.bt_voltar_esporte_main);
        btExcluir = findViewById(R.id.bt_deletar_esporte);
    }

}
