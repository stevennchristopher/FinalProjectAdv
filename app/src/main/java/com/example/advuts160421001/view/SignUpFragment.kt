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
import androidx.navigation.Navigation
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.advuts160421001.R
import com.example.advuts160421001.databinding.FragmentSignInBinding
import com.example.advuts160421001.databinding.FragmentSignUpBinding
//import com.example.advuts160421001.model.CekRegister
//import com.example.advuts160421001.model.CekUser
//import com.example.advuts160421001.model.CekUsername
import com.example.advuts160421001.model.User
import com.example.todoapp.util.buildDb
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUpFragment : Fragment(), SignUpButtonClick {
    private lateinit var dataBinding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentSignUpBinding>(inflater, R.layout.fragment_sign_up, container, false)
        dataBinding.listener = this
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.txtSignIn.setOnClickListener {
//            val action = SignUpFragmentDirections.actionSignInDirections()
//            Navigation.findNavController(it).navigate(action)
//        }
//
//        binding.btnRegister.setOnClickListener {
//            if (binding.txtInputRegUsername.text.toString().trim().isEmpty()){
//                binding.txtInputRegUsername.error = "Username cannot be empty"
//            }
//            else if(binding.txtInputRegNamaDepan.text.toString().trim().isEmpty()){
//                binding.txtInputRegNamaDepan.error = "First Name cannot be empty"
//            }
//            else if(binding.txtInputRegNamaBlkg.text.toString().trim().isEmpty()){
//                binding.txtInputRegNamaBlkg.error = "Last Name cannot be empty"
//            }
//            else if(binding.txtInputRegEmail.text.toString().trim().isEmpty()){
//                binding.txtInputRegNamaBlkg.error = "Email cannot be empty"
//            }
//            else if(binding.txtInputRegPassword.text.toString().trim().isEmpty()){
//                binding.txtInputRegPassword.error = "Password cannot be empty"
//            }
//            else if(binding.txtInputRegRePassword.text.toString().trim().isEmpty()){
//                binding.txtInputRegRePassword.error = "Re-type Password cannot be empty"
//            }
//            else{
//                if(binding.txtInputRegPassword.text.toString() != binding.txtInputRegRePassword.text.toString()){
//                    Toast.makeText(requireContext(), "Password and Re-type Password has to be same", Toast.LENGTH_LONG).show()
//                }
//                else{
//                    val q = Volley.newRequestQueue(requireContext())
//                    val url = "http://10.0.2.2/anmp/uts/cekusername.php"
//
//                    var stringRequest = object : StringRequest(
//                        Request.Method.POST, url,
//                        {
//                            val cekUsername = Gson().fromJson(it, CekUsername::class.java)
//                            Log.d("apiresult", cekUsername.toString())
//
//                            if (cekUsername.result.toString() == "taken")
//                            {//username taken
//                                Toast.makeText(requireContext(), "Username has been taken, please change it", Toast.LENGTH_LONG).show()
//                            }
//                            else if(cekUsername.result.toString() == "available")
//                            {//username available, create account
//                                val urlRegister = "http://10.0.2.2/anmp/uts/register.php"
//                                var stringRequest = object : StringRequest(
//                                    Request.Method.POST, urlRegister,
//                                    {
//                                        val cekRegister = Gson().fromJson(it, CekRegister::class.java)
//                                        Log.d("apiresult", cekRegister.toString())
//
//                                        if(cekRegister.result.toString() == "success"){
//                                            Toast.makeText(requireContext(), "Create Account Success", Toast.LENGTH_LONG).show()
//
//                                            binding.txtInputRegUsername.setText("")
//                                            binding.txtInputRegNamaDepan.setText("")
//                                            binding.txtInputRegNamaBlkg.setText("")
//                                            binding.txtInputRegEmail.setText("")
//                                            binding.txtInputRegPassword.setText("")
//                                            binding.txtInputRegRePassword.setText("")
//                                        }
//                                    },
//                                Response.ErrorListener {
//                                    Log.e("apiresult", it.message.toString())
//                                })
//                                {
//                                    override fun getParams(): MutableMap<String, String>{
//                                        val params = HashMap<String, String>()
//                                        params["username"] = binding.txtInputRegUsername.text.toString()
//                                        params["nama_depan"] = binding.txtInputRegNamaDepan.text.toString()
//                                        params["nama_belakang"] = binding.txtInputRegNamaBlkg.text.toString()
//                                        params["email"] = binding.txtInputRegEmail.text.toString()
//                                        params["password"] = binding.txtInputRegPassword.text.toString()
//
//                                        return params
//                                    }
//                                }
//                                q.add(stringRequest)
//                            }
//                        },
//                        Response.ErrorListener {
//                            Log.e("apiresult", it.message.toString())
//                        })
//                    {
//                        override fun getParams(): MutableMap<String, String>{
//                            val params = HashMap<String, String>()
//                            params["username"] = binding.txtInputRegUsername.text.toString()
//
//                            return params
//                        }
//                    }
//                    q.add(stringRequest)
//                }
//            }
//        }
    }

    override fun onRegisterButtonClick(v: View) {
        if (dataBinding.txtInputRegUsername.text.toString().trim().isEmpty()){
            dataBinding.txtInputRegUsername.error = "Username cannot be empty"
        }
        else if(dataBinding.txtInputRegEmail.text.toString().trim().isEmpty()){
            dataBinding.txtInputRegEmail.error = "Email cannot be empty"
        }
        else if(dataBinding.txtInputRegPassword.text.toString().trim().isEmpty()){
            dataBinding.txtInputRegPassword.error = "Password cannot be empty"
        }
        else if(dataBinding.txtInputRegRePassword.text.toString().trim().isEmpty()){
            dataBinding.txtInputRegRePassword.error = "Re-type Password cannot be empty"
        }
        else{
            if(dataBinding.txtInputRegPassword.text.toString() != dataBinding.txtInputRegRePassword.text.toString()){
                Toast.makeText(requireContext(), "Password and Re-type Password has to be same", Toast.LENGTH_LONG).show()
            }
            else{
                val username = dataBinding.txtInputRegUsername.text.toString()
                val email = dataBinding.txtInputRegEmail.text.toString()
                val password = dataBinding.txtInputRegPassword.text.toString()

                CoroutineScope(Dispatchers.IO).launch {
                    val db = buildDb(requireContext())
                    val cekUser = db.userDao().cekUsername(username)

                    withContext(Dispatchers.Main) {
                        if (cekUser == null) {
                            val newUser = User(username=username, email = email, password = password)
                            db.userDao().insertAll(newUser)

                            Toast.makeText(requireContext(), "Create Account Success", Toast.LENGTH_LONG).show()

                            dataBinding.txtInputRegUsername.setText("")
                            dataBinding.txtInputRegEmail.setText("")
                            dataBinding.txtInputRegPassword.setText("")
                            dataBinding.txtInputRegRePassword.setText("")

                        } else {
                            Toast.makeText(requireContext(), "Username has been taken, please change it", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }

    override fun toSignInButtonClick(v: View) {
        val action = SignUpFragmentDirections.actionSignInDirections()
        Navigation.findNavController(v).navigate(action)
    }
}