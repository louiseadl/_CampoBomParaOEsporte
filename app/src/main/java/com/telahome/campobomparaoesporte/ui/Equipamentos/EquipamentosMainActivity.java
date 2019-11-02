package com.telahome.campobomparaoesporte.ui.Equipamentos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.telahome.campobomparaoesporte.Main_LoginMapsActivity;
import com.telahome.campobomparaoesporte.R;
import com.telahome.campobomparaoesporte.ui.criarEsportes.CriarEsporteActivity;
import com.telahome.campobomparaoesporte.ui.criarEsportes.DeletarEsporte;

public class EquipamentosMainActivity extends AppCompatActivity {

    private Button btVoltar;
    private Button btCriar;
    private Button btDeletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_equipamento);
        start();

        //volta para tela anterior

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itVoltar = new Intent(EquipamentosMainActivity.this, Main_LoginMapsActivity.class);
                startActivity(itVoltar);
            }
        });

        //vai para tela de criar equipamento

        btCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itCriar = new Intent(EquipamentosMainActivity.this, CriarEsporteActivity.class);
                startActivity(itCriar);
            }
        });

        //vai para tela de deletar equipamento

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itDeletar = new Intent(EquipamentosMainActivity.this, DeletarEsporte.class);
                startActivity(itDeletar);
            }
        });
    }

    private void start() {
        btVoltar = findViewById(R.id.bt_voltar_equipamentos_main);
        btCriar = findViewById(R.id.bt_criar_equipamento_main);
        btDeletar = findViewById(R.id.bt_excluir_equipamento);
    }
}
