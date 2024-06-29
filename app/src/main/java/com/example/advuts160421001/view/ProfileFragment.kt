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

class ProfileFragment : Fragment() {
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

//        Log.d("apakahid", HomeMainActivity.activeIdUser)
//
//        val q = Volley.newRequestQueue(requireContext())
//        val url = "http://10.0.2.2/anmp/uts/getUserDetail.php"
//
//        var stringRequest = object : StringRequest(
//            Request.Method.POST, url,
//            {
//                val userDetail = Gson().fromJson(it, User::class.java)
//                Log.d("apiresult", userDetail.toString())
//
//                binding.txtProfileUsername.text = "Username: @" + userDetail.username
//                binding.txtProfileEmail.text = "Email: " + userDetail.email
//                binding.txtInputProfileNamaDpn.setText(userDetail.nama_depan)
//                binding.txtInputProfileNamaBlkg.setText(userDetail.nama_belakang)
//                binding.txtInputProfilePassword.setText(userDetail.password)
//            },
//            Response.ErrorListener {
//                Log.e("apiresult", it.message.toString())
//            })
//        {
//            override fun getParams(): MutableMap<String, String>{
//                val params = HashMap<String, String>()
//                params["id"] = HomeMainActivity.activeIdUser
//
//                return params
//            }
//        }
//        q.add(stringRequest)
//
//        binding.btnUpdate.setOnClickListener{
//            if (binding.txtInputProfileNamaDpn.text.toString().trim().isEmpty()){
//                binding.txtInputProfileNamaDpn.error = "First Name cannot be empty"
//            }
//            else if (binding.txtInputProfileNamaBlkg.text.toString().trim().isEmpty()){
//                binding.txtInputProfileNamaBlkg.error = "Last Name cannot be empty"
//            }
//            else if (binding.txtInputProfilePassword.text.toString().trim().isEmpty()){
//                binding.txtInputProfilePassword.error = "Password cannot be empty"
//            }
//            else {
//                val url = "http://10.0.2.2/anmp/uts/updateUser.php"
//
//                var stringRequest = object : StringRequest(
//                    Request.Method.POST, url,
//                    {
//                        val cekUpdateUser = Gson().fromJson(it, CekUpdateUser::class.java)
//                        Log.d("apiresult", cekUpdateUser.toString())
//
//                        if(cekUpdateUser.result == "success"){
//                            Toast.makeText(requireContext(), "Update Success", Toast.LENGTH_LONG).show()
//                        }
//                    },
//                    Response.ErrorListener {
//                        Log.e("apiresult", it.message.toString())
//                    }) {
//                    override fun getParams(): MutableMap<String, String> {
//                        val params = HashMap<String, String>()
//                        params["id"] = HomeMainActivity.activeIdUser
//                        params["nama_depan"] = binding.txtInputProfileNamaDpn.text.toString()
//                        params["nama_belakang"] = binding.txtInputProfileNamaBlkg.text.toString()
//                        params["password"] = binding.txtInputProfilePassword.text.toString()
//
//                        return params
//                    }
//                }
//                q.add(stringRequest)
//            }
//        }
//
//        binding.btnLogout.setOnClickListener {
//            val intent = Intent(requireContext(), MainActivity::class.java)
//            startActivity(intent)
//            requireActivity().finish()
//        }
    }
}