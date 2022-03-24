package com.example.fourpay.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fourpay.R;
import com.example.fourpay.databinding.FragmentSecondRegisterBinding;
import com.example.fourpay.model.viewmodel.RegisterViewModel;

public class SecondRegisterFragment extends Fragment {

    private FragmentSecondRegisterBinding binding = null;
    private RegisterViewModel sharedViewModel = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(RegisterViewModel.class);
        binding.setViewModel(sharedViewModel);

        binding.imgVoltar.setOnClickListener(view1 -> {
            backToFirstFragment();
        });

        binding.btnContinuar.setOnClickListener(view1 -> {
            String cep = binding.edtCep.getText().toString();
            String endereco = binding.edtEndereco.getText().toString();
            String bairro = binding.edtBairro.getText().toString();
            String cidade = binding.edtCidade.getText().toString();
            String estado = binding.edtEstado.getText().toString();
            String numero = binding.edtNumeroCasa.getText().toString();

            if (!cep.isEmpty() &&
                    !endereco.isEmpty() &&
                    !bairro.isEmpty() &&
                    !cidade.isEmpty() &&
                    !estado.isEmpty() &&
                    !numero.isEmpty()) {

                sharedViewModel.setCep(cep);
                sharedViewModel.setEstado(endereco);
                sharedViewModel.setBairro(bairro);
                sharedViewModel.setLogradouro(endereco);
                sharedViewModel.setCidade(cidade);
                sharedViewModel.setEstado(estado);
                sharedViewModel.setNumero(numero);

                goToNextScreen();

            } else {

                if (cep.isEmpty()) {
                    binding.edtCep.setError("Cambo obrigatório");
                }
                if (endereco.isEmpty()) {
                    binding.edtEndereco.setError("Cambo obrigatório");
                }
                if (bairro.isEmpty()) {
                    binding.edtBairro.setError("Cambo obrigatório");
                }
                if (cidade.isEmpty()) {
                    binding.edtCidade.setError("Cambo obrigatório");
                }
                if (estado.isEmpty()) {
                    binding.edtEstado.setError("Cambo obrigatório");
                }
                if (numero.isEmpty()) {
                    binding.edtNumeroCasa.setError("Cambo obrigatório");
                }
            }
        });


    }

    private void backToFirstFragment() {
        NavHostFragment.findNavController(SecondRegisterFragment.this).navigate(R.id.action_secondRegisterFragment_to_firstRegisterFragment);
    }

    private void goToNextScreen() {
        NavHostFragment.findNavController(SecondRegisterFragment.this).navigate(R.id.action_secondRegisterFragment_to_thirdSecondRegister);
    }
}