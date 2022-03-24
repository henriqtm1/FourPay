package com.example.fourpay.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.fourpay.R;
import com.example.fourpay.databinding.FragmentConfiguracaoBinding;
import com.example.fourpay.databinding.FragmentPagamentoConfirmacaoBinding;


public class PagamentoConfirmacaoFragment extends Fragment {

    public static final String KEY_TIPO = "TIPO";

    private FragmentPagamentoConfirmacaoBinding binding = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPagamentoConfirmacaoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();

        if(bundle != null) {
            String text = bundle.getString(KEY_TIPO);
            binding.txtResultadoPagamento.setText(text);
            Animation anim = AnimationUtils.loadAnimation(requireContext(), R.anim.anim_from_pagamento);
            binding.img.setImageResource(R.drawable.sucesso_transferencia);
            binding.btnComprovante.setVisibility(View.VISIBLE);
            binding.img.setAnimation(anim);
        }

        binding.btnVoltar.setOnClickListener(view1 -> {
            voltarParaHome();
        });

    }

    private void voltarParaHome() {
        NavHostFragment.findNavController(this).navigate(R.id.action_pagamentoConfirmacaoFragment_to_homeFragment);
    }
}