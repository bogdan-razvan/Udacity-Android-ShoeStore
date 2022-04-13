package com.udacity.shoestore.screens.addshoe

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.models.Shoe

class AddShoeViewModel : ViewModel() {

    val name = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val size = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    private val _saveEvent = MutableLiveData<Boolean>()
    val saveEvent : LiveData<Boolean>
        get() = _saveEvent

    private val _cancelEvent = MutableLiveData<Boolean>()
    val cancelEvent : LiveData<Boolean>
        get() = _cancelEvent

    private lateinit var activityViewModel: MainViewModel

    fun onSave() {
        val name = this.name.value ?: return
        val company = this.company.value ?: return
        val size = this.size.value?.toDoubleOrNull() ?: return
        val description = this.description.value ?: return

        val shoe = Shoe(name = name, size = size, company =  company, description =  description, images = emptyList())
        activityViewModel.shoeList.value?.add(shoe)
        _saveEvent.value = true

    }

    fun onCancel() {
        _cancelEvent.value = true
    }

    fun setActivityViewModel(activityViewModel: MainViewModel) {
        this.activityViewModel = activityViewModel
    }
}