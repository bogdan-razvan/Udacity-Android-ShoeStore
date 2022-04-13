package com.udacity.shoestore.screens.shoelist

import android.graphics.Typeface
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoelistBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var binding: FragmentShoelistBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoelist, container, false)
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        viewModel.activityViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        observeLiveData()
        setupPlusButton()
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_logout, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        view?.findNavController()?.navigateUp()
        return super.onOptionsItemSelected(item)
//        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController().popBackStack()) || super.onOptionsItemSelected(item)
    }

    private fun observeLiveData() {
        viewModel.activityViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            binding.linearLayout.removeAllViews()

            shoeList.forEach {  shoe ->
                binding.linearLayout.addView(createShoeView(shoe))

            }
        })
    }

    private fun createShoeView(shoe: Shoe): View {
        val linearLayout = LinearLayout(context)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.setPadding(0, 30, 0, 30)

        val nameTextView = TextView(context)
        nameTextView.setTypeface(nameTextView.typeface, Typeface.BOLD)
        nameTextView.textSize = 20F
        nameTextView.text = shoe.name
        linearLayout.addView(nameTextView)


        val innerLinearLayout = LinearLayout(context)
        innerLinearLayout.orientation = LinearLayout.HORIZONTAL

        val companyTextView = TextView(context)
        companyTextView.textSize = 17F
        companyTextView.setPadding(0, 0, 30, 0)
        companyTextView.text = shoe.company
        innerLinearLayout.addView(companyTextView)

        val sizeTextView = TextView(context)
        sizeTextView.textSize = 17F
        sizeTextView.text = "Size: ${shoe.size}"
        innerLinearLayout.addView(sizeTextView)

        linearLayout.addView(innerLinearLayout)


        val descriptionTextView = TextView(context)
        descriptionTextView.setTypeface(descriptionTextView.typeface, Typeface.NORMAL)
        descriptionTextView.textSize = 17F
        descriptionTextView.text = shoe.description
        linearLayout.addView(descriptionTextView)
        return linearLayout
    }

    private fun setupPlusButton() {
       binding.plusButton.setOnClickListener {
           val action = ShoeListFragmentDirections.actionShoeListFragmentToAddShoeFragment()
           findNavController().navigate(action)
       }
    }

}