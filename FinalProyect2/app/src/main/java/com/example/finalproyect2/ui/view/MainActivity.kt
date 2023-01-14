package com.example.finalproyect2.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.finalproyect2.Model.PersonalInfo
import com.example.finalproyect2.databinding.ActivityMainBinding
import com.example.finalproyect2.viewModel.AuthViewModel
import com.example.finalproyect2.viewModel.DocumentsViewModel
import com.example.finalproyect2.viewModel.OfficesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

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
            intent.putExtra("email",binding.ETUser.text.toString().trim())
            startActivity(intent)
        })



    binding.BtnSignIn.setOnClickListener{
        val email = binding.ETUser.text.toString().trim()
        PersonalInfo.Email = email
        val password = binding.ETPassword.text.toString().trim()

        authViewModel.login(email, password)
    }


    }



}