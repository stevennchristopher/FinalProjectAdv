package com.example.advuts160421001.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.advuts160421001.R
import com.example.advuts160421001.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {
    private lateinit var binding:FragmentSignInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtSignUp.setOnClickListener() {
            val action = SignInFragmentDirections.actionSignUpDirections()
            Navigation.findNavController(it).navigate(action)
        }

        binding.btnSign.setOnClickListener() {
            val intent = Intent(requireContext(), HomeMainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }
}