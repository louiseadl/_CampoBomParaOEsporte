package com.telahome.campobomparaoesporte.ui.criarEsportes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.telahome.campobomparaoesporte.Main_LoginMapsActivity;
import com.telahome.campobomparaoesporte.R;

public class EsportesMainActivity extends AppCompatActivity {

    private Button btVoltar;
    private Button btCriar;
    private Button btExcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esportes_main);
        start();

        //volta para tela anterior

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itVoltar = new Intent(EsportesMainActivity.this, Main_LoginMapsActivity.class);
                startActivity(itVoltar);
            }
        });

        //vai para tela de criar esporte

        btCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itCriar = new Intent(EsportesMainActivity.this, CriarEsporteActivity.class);
                startActivity(itCriar);
            }
        });

        //vai para tela de excluir esporte

        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itDeletar = new Intent(EsportesMainActivity.this, DeletarEsporte.class);
                startActivity(itDeletar);
            }
        });
    }

    private void start(){
        btCriar = findViewById(R.id.bt_cadastrar_esportee);
        btVoltar = findViewById(R.id.bt_voltar_esporte_main);
        btExcluir = findViewById(R.id.bt_deletar_esporte);
    }

}
