package com.telahome.campobomparaoesporte.ui.configuracaoConta;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("TELA DE CONFIGURACAO");
    }

    public LiveData<String> getText() {
        return mText;
    }
}