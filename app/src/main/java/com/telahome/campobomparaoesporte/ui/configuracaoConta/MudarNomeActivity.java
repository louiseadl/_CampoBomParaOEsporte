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

public class MudarNomeActivity extends AppCompatActivity {
    private EditText etNome;
    private CheckBox cbConfirmar;
    private Button btVoltar;
    private Button btNome;
    private Retrofit retrofit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mudar_nome);

        start();
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itVoltar = new Intent(MudarNomeActivity.this, ConfiguracaoContaActivity.class);
                startActivity(itVoltar);
            }
        });

        btNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioServices service = retrofit.create(UsuarioServices.class);
                Usuario usuario = LoggedUsuario.getUsuario();
                usuario.setNome(etNome.getText().toString());
                service.atualizar(usuario).enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if(response.isSuccessful()) {
                            Toast.makeText(MudarNomeActivity.this, "Nome mudado com sucesso!", Toast.LENGTH_LONG).show();
                            Usuario usuario = response.body();
                            if(usuario.getId() != 0){
                                LoggedUsuario.setUsuario(usuario);
                                Intent itVoltar = new Intent(MudarNomeActivity.this, ConfiguracaoContaActivity.class);
                                startActivity(itVoltar);
                            }else {
                                Toast.makeText(MudarNomeActivity.this, "Falha em mudar o nome, tente novamente mais tarde!", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(MudarNomeActivity.this, "Falha em mudar o nome, tente novamente mais tarde!", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(MudarNomeActivity.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }



    private void start(){
        etNome = findViewById(R.id.et_novo_nome);
        cbConfirmar = findViewById(R.id.cb_confirmar_nome);
        btNome = findViewById(R.id.bt_mudar_nome_tela);
        btVoltar = findViewById(R.id.bt_voltar_nome);
        retrofit =RetrofitCreator.retrofit();

    }
}
