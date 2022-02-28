package com.udacity.shoestore.screens.instructions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionsViewModel : ViewModel() {

    private val _continueEvent = MutableLiveData<Boolean>()
    val continueEvent : LiveData<Boolean>
        get() = _continueEvent

    fun onContinue() {
        _continueEvent.value = true
    }

}