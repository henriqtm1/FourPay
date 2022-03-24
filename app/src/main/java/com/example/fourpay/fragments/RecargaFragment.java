package com.example.fourpay.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fourpay.R;
import com.example.fourpay.activitys.RecargaValidacaoActivity;
import com.example.fourpay.databinding.FragmentRecargaBinding;
import com.example.fourpay.model.viewmodel.HomeViewModel;

public class RecargaFragment extends Fragment {

    private FragmentRecargaBinding binding = null;
    private HomeViewModel viewModel = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRecargaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        binding.btnAcessar.setOnClickListener(view1 -> {

            String recargaSelect = binding.recarga.getSelectedItem().toString();
            String pagamentoSelect = binding.pagamento.getSelectedItem().toString();
            String operadoraSelect = binding.operadora.getSelectedItem().toString();
            String numCelular = binding.txtTelefone.getText().toString();


            if (!recargaSelect.isEmpty() && !pagamentoSelect.isEmpty() && !operadoraSelect.isEmpty() && !numCelular.isEmpty() && Patterns.PHONE.matcher(numCelular).matches()) {
                Bundle args = new Bundle();

                Intent intent = new Intent();
                intent.putExtra(RecargaValidacaoActivity.KEY_NUMERO, numCelular);
                intent.putExtra(RecargaValidacaoActivity.KEY_PAGAMENTO, pagamentoSelect);
                intent.putExtra(RecargaValidacaoActivity.KEY_OPERADORA, operadoraSelect);
                intent.putExtra(RecargaValidacaoActivity.KEY_VALOR, recargaSelect);
                startActivity(intent);
            } else {
                if (numCelular.isEmpty()) {
                    binding.txtTelefone.setError("Preencha o campo");
                }
                if (!Patterns.PHONE.matcher(numCelular).matches()) {
                    binding.txtTelefone.setError("Preencha o campo corretamente");
                }
                if (recargaSelect.isEmpty()) {
                    ((TextView) binding.recarga.getSelectedView()).setError("Selecione um dos campos");
                }
                if (pagamentoSelect.isEmpty()) {
                    ((TextView) binding.pagamento.getSelectedView()).setError("Selecione um dos campos");
                }
                if (operadoraSelect.isEmpty()) {
                    ((TextView) binding.operadora.getSelectedView()).setError("Selecione um dos campos");
                }

            }
        });
    }
}