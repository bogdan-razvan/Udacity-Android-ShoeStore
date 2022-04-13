package com.udacity.shoestore.screens.addshoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentAddshoeBinding
import com.udacity.shoestore.screens.welcome.WelcomeFragmentDirections

class AddShoeFragment : Fragment() {

    private lateinit var viewModel: AddShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding: FragmentAddshoeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_addshoe, container, false)
        viewModel = ViewModelProvider(this).get(AddShoeViewModel::class.java)
        viewModel.setActivityViewModel(ViewModelProvider(requireActivity()).get(MainViewModel::class.java))
        binding.viewModel = viewModel

        setupEventListeners()
        return binding.root
    }

    private fun setupEventListeners() {
        viewModel.saveEvent.observe(this, Observer { value ->
            if (value) {
                Toast.makeText(context, "Shoe added!", Toast.LENGTH_LONG).show()
                activity?.supportFragmentManager?.popBackStack()
            }
        })

        viewModel.cancelEvent.observe(this, Observer { value ->
            if (value) {
                activity?.supportFragmentManager?.popBackStack()
            }
        })
    }

}