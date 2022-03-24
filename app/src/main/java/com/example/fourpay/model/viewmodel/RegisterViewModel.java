package com.example.fourpay.model.viewmodel;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fourpay.model.Conta;
import com.example.fourpay.retrofit.RetrofitMethods;
import com.example.fourpay.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterViewModel extends ViewModel {

    //Fragment 1
    private MutableLiveData<String> _nomeCompleto = new MutableLiveData<>();
    public LiveData<String> nomeCompleto = _nomeCompleto;

    private MutableLiveData<String> _cpf  = new MutableLiveData<>();
    public LiveData<String> cpf = _cpf;

    private MutableLiveData<String> _email  = new MutableLiveData<>();
    public LiveData<String> email = _email;

    private MutableLiveData<String> _celular  = new MutableLiveData<>();
    public LiveData<String> celular = _celular;

    private MutableLiveData<String> _dataNascimento  = new MutableLiveData<>();
    public LiveData<String> dataNascimento = _dataNascimento;

    //Fragment 2
    private MutableLiveData<String> _cep  = new MutableLiveData<>();
    public LiveData<String> cep = _cep;

    private MutableLiveData<String> _logradouro  = new MutableLiveData<>();
    public LiveData<String> logradouro = _logradouro;

    private MutableLiveData<String> _numero  = new MutableLiveData<>();
    public LiveData<String> numero = _numero;

    private MutableLiveData<String> _bairro  = new MutableLiveData<>();
    public LiveData<String> bairro = _bairro;

    private MutableLiveData<String> _cidade  = new MutableLiveData<>();
    public LiveData<String> cidade = _cidade;

    private MutableLiveData<String> _estado  = new MutableLiveData<>();
    public LiveData<String> estado = _estado;

    //Fragment 4
    private MutableLiveData<String> _senha = new MutableLiveData<>();
    public LiveData<String> senha = _senha;

    private Conta conta = new Conta();

    public void setNomeCompleto(String nomeCompleto) {
        this._nomeCompleto.setValue(nomeCompleto);
        conta.getCliente().setNome(nomeCompleto);
    }

    public void setCpf(String cpf) {
        this._cpf.setValue(cpf);
        conta.getCliente().setCpf(cpf);
    }

    public void setEmail(String email) {
        this._email.setValue(email);
        conta.getCliente().setEmail(email);
    }

    public void setCelular(String celular) {
        this._celular.setValue(celular);
        conta.getCliente().setTelefone(celular);
    }

    public void setDataNascimento(String dataNascimento) {
        this._dataNascimento.setValue(dataNascimento);
        conta.getCliente().setDataDeNascimento(dataNascimento);
    }

    public void setCep(String cep) {
        this._cep.setValue(cep);
        conta.getCliente().getEndereco().setCep(cep);
    }

    public void setLogradouro(String logradouro) {
        this._logradouro.setValue(logradouro);
        conta.getCliente().getEndereco().setLogradouro(logradouro);
    }

    public void setNumero(String numero) {
        this._numero.setValue(numero);
        conta.getCliente().getEndereco().setNumero(numero);
    }

    public void setBairro(String bairro) {
        this._bairro.setValue(bairro);
        conta.getCliente().getEndereco().setBairro(bairro);
    }

    public void setCidade(String cidade) {
        this._cidade.setValue(cidade);
        conta.getCliente().getEndereco().setCidade(cidade);
    }

    public void setEstado(String estado) {
        this._estado.setValue(estado);
        conta.getCliente().getEndereco().setEstado(estado);
    }

    public void setSenha(String senha) {
        this._senha.setValue(senha);
        conta.setSenha(senha);
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Conta getConta() {
        return conta;
    }

}
