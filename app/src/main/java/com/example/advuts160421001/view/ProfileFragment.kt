package com.example.advuts160421001.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.advuts160421001.R
import com.example.advuts160421001.databinding.FragmentProfileBinding
import com.example.advuts160421001.databinding.FragmentSignInBinding
//import com.example.advuts160421001.model.CekUpdateUser
import com.example.advuts160421001.model.User
import com.google.gson.Gson

class ProfileFragment : Fragment(), ReadButtonClick {
    private lateinit var databinding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        databinding = DataBindingUtil.inflate<FragmentProfileBinding>(inflater, R.layout.fragment_profile, container, false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onReadButtonClick(v: View) {
        //button ini buat save profile baru
    }
}