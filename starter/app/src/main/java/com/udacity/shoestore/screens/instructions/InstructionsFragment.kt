package com.udacity.shoestore.screens.instructions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.screens.shoelist.ShoeListFragment
import com.udacity.shoestore.screens.welcome.WelcomeFragmentDirections

class InstructionsFragment : Fragment() {

    private lateinit var viewModel: InstructionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding: FragmentInstructionsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        viewModel = ViewModelProvider(this).get(InstructionsViewModel::class.java)
        binding.viewModel = viewModel

        setupEventListeners()
        return binding.root

    }

    private fun setupEventListeners() {
        viewModel.continueEvent.observe(this, Observer { value ->
            if (value) {
                val action = InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment()
                findNavController().navigate(action)
            }
        })
    }
}