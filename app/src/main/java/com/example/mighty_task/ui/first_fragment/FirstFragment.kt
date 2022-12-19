package com.example.mighty_task.ui.first_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mighty_task.R
import com.example.mighty_task.SharedViewModel
import com.example.mighty_task.databinding.FragmentFirstBinding
import com.example.mighty_task.model.User

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!


    private lateinit var viewModel: FirstViewModel
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]



        binding.submitButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val age = binding.ageEditText.text.toString()
            if (name.isNotEmpty() && age.isNotEmpty()) {
                val data = User(name, age.toInt())
                sharedViewModel.updateUser(data)
                binding.nameEditText.text.clear()
                binding.ageEditText.text.clear()
                findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            } else {
                Toast.makeText(requireContext(), "Please fill all the fields", Toast.LENGTH_SHORT)
                    .show()
            }
        }


    }

}