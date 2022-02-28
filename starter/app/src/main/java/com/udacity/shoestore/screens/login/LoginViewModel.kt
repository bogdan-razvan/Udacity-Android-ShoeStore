package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _loginEvent = MutableLiveData<Boolean>()
    val loginEvent : LiveData<Boolean>
        get() = _loginEvent

    private val _signupEvent = MutableLiveData<Boolean>()
    val signupEvent : LiveData<Boolean>
        get() = _signupEvent

    fun onLogin() {
        //TODO: validate email and password
        _loginEvent.value = true
    }

    fun onSignup() {
        //TODO: validate email and password
        _signupEvent.value = true
    }
}