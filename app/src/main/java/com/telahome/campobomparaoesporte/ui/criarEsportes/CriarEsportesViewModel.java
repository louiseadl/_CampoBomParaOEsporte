package com.telahome.campobomparaoesporte.ui.criarEsportes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CriarEsportesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CriarEsportesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Criar esportes");
    }

    public LiveData<String> getText() {
        return mText;
    }
}