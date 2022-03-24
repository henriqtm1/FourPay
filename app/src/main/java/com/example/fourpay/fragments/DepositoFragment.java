package com.example.fourpay.fragments;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fourpay.R;
import com.example.fourpay.databinding.FragmentDepositoBinding;
import com.example.fourpay.model.viewmodel.HomeViewModel;

public class DepositoFragment extends Fragment {

    private FragmentDepositoBinding binding = null;
    private HomeViewModel viewModel = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDepositoBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        binding.btnGerarBoleto.setOnClickListener(view2 -> {
            if (!binding.edtValorDeposito.getText().toString().isEmpty() && Double.parseDouble(binding.edtValorDeposito.getText().toString()) >= 20d) {
                Double valorDeposito = Double.parseDouble(binding.edtValorDeposito.getText().toString());
                viewModel.getConta().setSaldo(viewModel.getConta().getSaldo() + valorDeposito);
                viewModel.updateUser();
                navigateToConfirmacao();
            } else {
                if (!binding.edtValorDeposito.getText().toString().isEmpty())
                    binding.edtValorDeposito.setError("Valor inválido");
                else
                    binding.edtValorDeposito.setError("Campo obrigatório");
            }
        });
    }

    private void navigateToConfirmacao() {
        Bundle args = new Bundle();
        args.putString(PagamentoConfirmacaoFragment.KEY_TIPO, "Boleto de depósito enviado para seu e-mail!");
        NavHostFragment.findNavController(this).navigate(R.id.action_depositoFragment_to_pagamentoConfirmacaoFragment, args);
    }
}