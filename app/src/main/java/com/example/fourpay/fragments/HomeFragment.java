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
import android.widget.Toast;

import com.example.fourpay.R;
import com.example.fourpay.activitys.ScanCodigoActivity;
import com.example.fourpay.databinding.FragmentHomeBinding;
import com.example.fourpay.model.viewmodel.HomeViewModel;

public class HomeFragment extends Fragment {

    public static final String KEY_ID = "ID";

    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        binding.setHomeViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        Bundle args = getArguments();

        if (args != null) {
            Long id = args.getLong(KEY_ID);
            viewModel.getCurrentUser(id);
        }


        binding.setaEsquerdaHome.setOnClickListener(view1 -> {
            abrirConfiguracao();
        });

        binding.cardDeposito.setOnClickListener(view1 -> {
            abrirDeposito();
        });

        binding.cardPagar.setOnClickListener(view1 -> {
            abrirPagamento();
        });
    }

    private void abrirPagamento() {
        startActivity(new Intent(requireActivity(), ScanCodigoActivity.class));
    }

    private void abrirDeposito() {
        NavHostFragment.findNavController(this).navigate(R.id.action_homeFragment_to_depositoFragment);
    }

    private void abrirConfiguracao() {
        NavHostFragment.findNavController(this).navigate(R.id.action_homeFragment_to_configuracaoFragment);
    }
}