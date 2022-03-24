package com.example.fourpay.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.fourpay.R;
import com.example.fourpay.activitys.animations.ProgressButton;
import com.example.fourpay.databinding.ActivityLoginBinding;
import com.example.fourpay.model.Conta;
import com.example.fourpay.network.ConfiguracaoFirebase;
import com.example.fourpay.retrofit.RetrofitMethods;
import com.example.fourpay.retrofit.RetrofitService;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding = null;

    private View myProgressButton;
    private ProgressButton progressButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initialWork();

        myProgressButton.setOnClickListener(view -> {

            if (!binding.txtEmail.getText().toString().isEmpty() && !binding.edtSenha.getText().toString().isEmpty()) {
                if (validadeEmailAddress(binding.txtEmail.getText().toString())) {

                    progressButton = new ProgressButton(this, view);
                    progressButton.buttonActivated();
                    logar();

                } else {
                    binding.txtEmail.setError("E-mail inválido");
                }
            }
        });

    }

    private void logar() {
        RetrofitMethods methods = RetrofitService.getRetrofitInstance().create(RetrofitMethods.class);
        Call<Conta> data = methods.contaLogin(binding.txtEmail.getText().toString(), binding.edtSenha.getText().toString());

        data.enqueue(new Callback<Conta>() {
            @Override
            public void onResponse(Call<Conta> call, Response<Conta> response) {
                if (response.isSuccessful()) {
                    progressButton.buttonFinishedSucess();
                    goToNextScreen(response.body().getId());
                } else {
                    Log.d("LoginActivity", response.message());
                }
            }

            @Override
            public void onFailure(Call<Conta> call, Throwable t) {

            }
        });
    }

    private void goToNextScreen(Long id) {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        intent.putExtra(HomeActivity.KEY_ID, id);
        startActivity(intent);
        finish();
    }

    private void initialWork() {
        myProgressButton = findViewById(R.id.btn_acessar);
    }

    public boolean validadeEmailAddress(String email) {
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return true;
        else
            return false;

    }

    public void voltar(View view) {
        finish();
    }
}