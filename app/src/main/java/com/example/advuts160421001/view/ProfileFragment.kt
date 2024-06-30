package com.example.advuts160421001.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.advuts160421001.R
import com.example.advuts160421001.databinding.FragmentProfileBinding
import com.example.advuts160421001.databinding.FragmentSignInBinding
//import com.example.advuts160421001.model.CekUpdateUser
import com.example.advuts160421001.model.User
import com.example.advuts160421001.viewmodel.BeritaListViewModel
import com.example.advuts160421001.viewmodel.UserViewModel
import com.google.gson.Gson

class ProfileFragment : Fragment(), UpdateButtonClick, ReadButtonClick {
    private lateinit var databinding: FragmentProfileBinding
    private lateinit var viewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        databinding = DataBindingUtil.inflate<FragmentProfileBinding>(inflater, R.layout.fragment_profile, container, false)
        databinding.listener = this
        databinding.savelistener = this
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.fetchUser(HomeMainActivity.activeIdUser.toInt())

        observeViewModel()
    }
    fun observeViewModel() {
        viewModel.userLD.observe(viewLifecycleOwner, Observer {
            databinding.user=it
        })
    }
    override fun onUpdateButtonClick(v: View, obj:User) {
        //button ini buat save profile baru
        viewModel.updateUser(obj.username.toString(), obj.email.toString(), obj.password.toString(), obj.id)
        Toast.makeText(v.context, "User Updated", Toast.LENGTH_SHORT).show()
    }
    override fun onReadButtonClick(v: View) {
        //logout
        val intent = Intent(requireContext(), MainActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
}