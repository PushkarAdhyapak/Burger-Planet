package com.example.burgerplanet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.burgerplanet.databinding.FragmentMenuBinding
//import com.example.burgerplanet.databinding.FragmentFlavorBinding
import com.example.burgerplanet.model.OrderViewModel


class MenuFragment : Fragment() {


    private var binding: FragmentMenuBinding? = null


    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentMenuBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {

            lifecycleOwner = viewLifecycleOwner


            viewModel = sharedViewModel


            itemFragment = this@MenuFragment
        }
    }

    /**
     * Navigate to the next screen
     */
    fun goToNextScreen() {
        findNavController().navigate(R.id.action_menuFragment_to_pickupFragment)
    }

    /**
     * Cancel the order and start over.
     */
    fun cancelOrder() {

        sharedViewModel.resetOrder()


        findNavController().navigate(R.id.action_menuFragment_to_startFragment)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}