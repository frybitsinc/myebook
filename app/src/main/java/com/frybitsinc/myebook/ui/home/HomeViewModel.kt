package com.frybitsinc.myebook.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    private val _subtitle = MutableLiveData<String>().apply {
        value = "Subtitle"
    }

    val text: LiveData<String> = _text
    val subtitle: LiveData<String> = _subtitle
}