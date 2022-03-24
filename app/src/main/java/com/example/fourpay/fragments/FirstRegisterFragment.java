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
import com.example.fourpay.databinding.FragmentFirstRegisterBinding;
import com.example.fourpay.model.viewmodel.RegisterViewModel;

public class FirstRegisterFragment extends Fragment {

    private FragmentFirstRegisterBinding binding = null;
    private RegisterViewModel sharedViewModel = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFirstRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(RegisterViewModel.class);
        binding.setViewModel(sharedViewModel);

        binding.imgVoltar.setOnClickListener(view1 -> {
            backToMain();
        });

        binding.btnContinuar.setOnClickListener(view1 -> {
            String nome = binding.txtNome.getText().toString();
            String dataNascimento = binding.edtDataNascimento.getText().toString();
            String cpf = binding.tilCpf.getText().toString();
            String email = binding.txtEmail.getText().toString();
            String telefone = binding.txtNumero.getText().toString();

            if (!nome.isEmpty() &&
                    !dataNascimento.isEmpty() &&
                    !cpf.isEmpty() &&
                    !email.isEmpty() &&
                    !telefone.isEmpty()) {

                    sharedViewModel.setNomeCompleto(nome);
                    sharedViewModel.setDataNascimento(dataNascimento);
                    sharedViewModel.setCpf(cpf);
                    sharedViewModel.setEmail(email);
                    sharedViewModel.setCelular(telefone);

                goToNextScreen();

            } else {
                if (nome.isEmpty()) {
                    binding.txtNome.setError("Nome obrigatório");
                }
                if (dataNascimento.isEmpty()) {
                    binding.edtDataNascimento.setError("Data de nascimento obrigatório");
                }
                if (cpf.isEmpty()) {
                    binding.tilCpf.setError("CPF obrigatório");
                }
                if (email.isEmpty()) {
                    binding.txtEmail.setError("E-mail obrigatório");
                }
                if (telefone.isEmpty()) {
                    binding.txtNumero.setError("Celular obrigatório");
                }
            }
        });
    }

    public void goToNextScreen() {
        NavHostFragment.findNavController(FirstRegisterFragment.this).navigate(R.id.action_firstRegisterFragment_to_secondRegisterFragment);
    }

    public void backToMain() {
        requireActivity().finish();
    }

}