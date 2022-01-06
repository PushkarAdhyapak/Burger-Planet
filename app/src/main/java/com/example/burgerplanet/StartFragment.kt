package com.example.burgerplanet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.burgerplanet.databinding.FragmentStartBinding
import com.example.burgerplanet.model.OrderViewModel


class StartFragment : Fragment() {


    private var binding: FragmentStartBinding? = null


    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.startFragment = this
    }

    /**
     * Start an order with the desired quantity of burgers and navigate to the next screen.
     */
    fun orderBurger(quantity: Int) {

        sharedViewModel.setQuantity(quantity)


        if (sharedViewModel.hasNoMenuSet()) {
            sharedViewModel.setMenu(getString(R.string.vegBurger))
        }


        findNavController().navigate(R.id.action_startFragment_to_menuFragment)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}