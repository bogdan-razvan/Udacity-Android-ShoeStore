package com.udacity.shoestore.screens.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    private val _continueEvent = MutableLiveData<Boolean>()
    val continueEvent : LiveData<Boolean>
        get() = _continueEvent

    fun onContinue() {
        _continueEvent.value = true
    }

}