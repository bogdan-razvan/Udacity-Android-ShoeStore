package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewModel : ViewModel() {

    val shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf(
        Shoe(name = "Ultra Boost", size = 41.5, company = "Adidas", description = "Available now!", images = emptyList()),
        Shoe(name = "Air", size = 44.0, company = "Nike", description = "Preorder now!", images = emptyList()),
        Shoe(name = "Name 3", size = 44.0, company = "Company 3", description = "Description 3 ", images = emptyList()),
        Shoe(name = "Name 4", size = 42.5, company = "Company 4", description = "Description 4 ", images = emptyList()),
        Shoe(name = "Name 5", size = 43.0, company = "Company 5", description = "Description 5 ", images = emptyList()),
        Shoe(name = "Name 6", size = 41.0, company = "Company 6", description = "Description 6 ", images = emptyList()),
        Shoe(name = "Name 7", size = 42.5, company = "Company 7", description = "Description 7 ", images = emptyList()),
        Shoe(name = "Name 8", size = 44.5, company = "Company 8", description = "Description 8 ", images = emptyList())
    ))

}