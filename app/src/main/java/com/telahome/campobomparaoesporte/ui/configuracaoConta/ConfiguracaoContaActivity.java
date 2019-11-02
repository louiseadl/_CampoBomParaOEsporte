package com.telahome.campobomparaoesporte.ui.configuracaoConta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.telahome.campobomparaoesporte.LoggedUsuario;
import com.telahome.campobomparaoesporte.MainActivity;
import com.telahome.campobomparaoesporte.Main_LoginMapsActivity;
import com.telahome.campobomparaoesporte.Models.Usuario;
import com.telahome.campobomparaoesporte.R;
import com.telahome.campobomparaoesporte.RetrofitCreator;
import com.telahome.campobomparaoesporte.Services.UsuarioServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ConfiguracaoContaActivity extends AppCompatActivity {

    private Button btMudarSenha;
    private Button btMudarNome;
    private Button btDeletar;
    private Button btVoltar;
    private CheckBox cbAncap;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao_conta);

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itMaps = new Intent(ConfiguracaoContaActivity.this, Main_LoginMapsActivity.class);
                startActivity(itMaps);
            }
        });

        btMudarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itSenha = new Intent(ConfiguracaoContaActivity.this, MudarSenhaActivity.class);
                startActivity(itSenha);
            }
        });

        btMudarNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itNome = new Intent(ConfiguracaoContaActivity.this, MudarNomeActivity.class);
                startActivity(itNome);
            }
        });

        btDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbAncap.isChecked()){
                    UsuarioServices service = retrofit.create(UsuarioServices.class);
                    service.deletar(LoggedUsuario.getUsuario().getId()).enqueue(new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                            if(response.isSuccessful()) {
                                LoggedUsuario.setUsuario(new Usuario());
                                Intent itVoltar = new Intent(ConfiguracaoContaActivity.this, MainActivity.class);
                                startActivity(itVoltar);
                                Toast.makeText(ConfiguracaoContaActivity.this, "Deletado com sucesso!", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(ConfiguracaoContaActivity.this, "Falha em deletar, tente novamente mais tarde!", Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {
                            Toast.makeText(ConfiguracaoContaActivity.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();
                        }
                    });
            }}
        });




    }



    private void start(){
        btDeletar = findViewById(R.id.bt_deletar_conta);
        btMudarNome = findViewById(R.id.bt_mudar_nome2);
        btMudarSenha = findViewById(R.id.bt_mudar_senhaa);
        btVoltar = findViewById(R.id.bt_voltar_cc);
        retrofit = RetrofitCreator.retrofit();
        cbAncap = findViewById(R.id.cb_confirmar_deletar);
    }
}
