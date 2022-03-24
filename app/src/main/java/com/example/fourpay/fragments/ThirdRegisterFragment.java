package com.example.fourpay.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fourpay.R;
import com.example.fourpay.activitys.FotoActivity;
import com.example.fourpay.activitys.HomeActivity;
import com.example.fourpay.activitys.animations.LoadingDialog;
import com.example.fourpay.databinding.FragmentThirdRegisterBinding;
import com.example.fourpay.model.Conta;
import com.example.fourpay.model.viewmodel.RegisterViewModel;
import com.example.fourpay.retrofit.RetrofitMethods;
import com.example.fourpay.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThirdRegisterFragment extends Fragment {

    private FragmentThirdRegisterBinding binding;
    private RegisterViewModel sharedViewModel;
    private LoadingDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThirdRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dialog = new LoadingDialog(requireActivity());

        sharedViewModel = new ViewModelProvider(requireActivity()).get(RegisterViewModel.class);
        binding.setViewModel(sharedViewModel);

        binding.imgVoltar.setOnClickListener(view1 -> {
            backToSecondFragment();
        });

        binding.btnContinuar.setOnClickListener(view1 -> {

            String senha1 = binding.tilSenha.getText().toString();
            String senha2 = binding.edtConfirmarSenha.getText().toString();

            if (!senha1.isEmpty() && !senha2.isEmpty()) {
                if (senha1.equals(senha2)) {
                    sharedViewModel.setSenha(senha1);

                    dialog.startLoadingDialog();
                    registerUser();

                } else {
                    binding.edtConfirmarSenha.setError("As senhas precisam ser identicas");
                }
            } else {
                if (binding.tilSenha.getText().toString().isEmpty()) {
                    binding.tilSenha.setError("Preencha a senha");
                }
                if (binding.edtConfirmarSenha.getText().toString().isEmpty()) {
                    binding.edtConfirmarSenha.setError("Preencha a senha");
                }
            }
        });
    }

    private void backToSecondFragment() {
        NavHostFragment.findNavController(ThirdRegisterFragment.this).navigate(R.id.action_thirdSecondRegister_to_secondRegisterFragment);
    }

    public void goToNextScreen(Long id) {
        Intent intent = new Intent(requireActivity(), FotoActivity.class);
        intent.putExtra(HomeActivity.KEY_ID, id);
        startActivity(intent);
        requireActivity().finish();
    }

    public void registerUser() {
        RetrofitMethods methods = RetrofitService.getRetrofitInstance().create(RetrofitMethods.class);
        Call<Conta> data = methods.contaPost(sharedViewModel.getConta());
        data.enqueue(new Callback<Conta>() {
            @Override
            public void onResponse(Call<Conta> call, Response<Conta> response) {
                if(response.isSuccessful()) {
                    sharedViewModel.setConta(response.body());
                    dialog.dismissDialog();
                    goToNextScreen(sharedViewModel.getConta().getId());
                } else {
                    Log.d("RegisterViewModel", response.message());
                }
            }

            @Override
            public void onFailure(Call<Conta> call, Throwable t) {
                Log.d("RegisterViewModel", t.getMessage());
            }
        });
    }
}