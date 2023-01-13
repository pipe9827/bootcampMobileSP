package com.example.finalproyect2.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.finalproyect2.databinding.ActivityMainBinding
import com.example.finalproyect2.network.AuthApi
import com.example.finalproyect2.network.Resource
import com.example.finalproyect2.repository.AuthRepository
import com.example.finalproyect2.ui.base.BaseFragment
import com.example.finalproyect2.viewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding:ActivityMainBinding

    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

        authViewModel.loginResponse.observe(this, Observer {
            Toast.makeText(this,it.toString(),Toast.LENGTH_LONG).show()
            val intent:Intent = Intent(this, MenuScreen:: class.java)
            startActivity(intent)
        })

    binding.BtnSignIn.setOnClickListener{
    //val intent:Intent = Intent(this, MenuScreen:: class.java)
    //startActivity(intent)
        val email = binding.ETUser.text.toString().trim()
        val password = binding.ETPassword.text.toString().trim()

        authViewModel.login(email, password)
    }

    }

/**
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when (it){
                is Resource.Success ->{
                    Toast.makeText(requireContext(),it.toString(),Toast.LENGTH_LONG).show()
                }
                is Resource.Failure ->{
                    Toast.makeText(requireContext(), "Login Failure",Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.BtnSignIn.setOnClickListener {
            val email = binding.ETUser.text.toString().trim()
            val password = binding.ETPassword.text.toString().trim()

            viewModel.login(email, password)
        }

    }

    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= ActivityMainBinding.inflate(inflater,container,false)

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))
**/
}