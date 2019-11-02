package com.telahome.campobomparaoesporte.ui.configuracaoConta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.telahome.campobomparaoesporte.LoggedUsuario;
import com.telahome.campobomparaoesporte.Models.Usuario;
import com.telahome.campobomparaoesporte.R;
import com.telahome.campobomparaoesporte.RetrofitCreator;
import com.telahome.campobomparaoesporte.Services.UsuarioServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MudarSenhaActivity extends AppCompatActivity {

    private Button btVoltar;
    private Button btvai;
    private CheckBox cbConfirma;
    private EditText etNovo;
    private EditText etVelho;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mudar_senha_activity);
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itVoltar = new Intent(MudarSenhaActivity.this, ConfiguracaoContaActivity.class);
                startActivity(itVoltar);
            }
        });
        btvai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioServices service = retrofit.create(UsuarioServices.class);
                Usuario usuario = LoggedUsuario.getUsuario();
                if(etVelho.equals(LoggedUsuario.getUsuario().getSenha())){
                    usuario.setSenha(etNovo.getText().toString());
                    service.atualizar(usuario).enqueue(new Callback<Usuario>() {
                        @Override
                        public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                            if(response.isSuccessful()) {
                                Toast.makeText(MudarSenhaActivity.this, "senha mudada com sucesso!", Toast.LENGTH_LONG).show();
                                Usuario usuario = response.body();
                                if(usuario.getId() != 0){
                                    LoggedUsuario.setUsuario(usuario);
                                    Intent itVoltar = new Intent(MudarSenhaActivity.this, ConfiguracaoContaActivity.class);
                                    startActivity(itVoltar);
                                }else {
                                    Toast.makeText(MudarSenhaActivity.this, "Falha em mudar a senha, tente novamente mais tarde!", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Toast.makeText(MudarSenhaActivity.this, "Falha em mudar a senha, tente novamente mais tarde!", Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<Usuario> call, Throwable t) {
                            Toast.makeText(MudarSenhaActivity.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();
                        }
                });
            }else{
                    Toast.makeText(MudarSenhaActivity.this, "Senha antiga errada!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void start(){
        btVoltar = findViewById(R.id.bt_voltar_senha);
        btvai = findViewById(R.id.bt_mudar_senha);
        cbConfirma = findViewById(R.id.bt_confirmar_senha);
        etNovo = findViewById(R.id.et_senha_nova);
        etVelho = findViewById(R.id.et_senha_velha);
        retrofit = RetrofitCreator.retrofit();
    }
}

