package com.telahome.campobomparaoesporte.ui.criacao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


public class CriacaoViewModel  extends CriacaoFragment  {

    private MutableLiveData<String> mText;

    public CriacaoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is criacao fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}