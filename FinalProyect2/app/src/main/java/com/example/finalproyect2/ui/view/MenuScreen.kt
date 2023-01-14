package com.example.finalproyect2.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import com.example.finalproyect2.Model.PersonalInfo
import com.example.finalproyect2.R
import com.example.finalproyect2.databinding.ActivityMenuScreenBinding

class MenuScreen : AppCompatActivity() {
    private lateinit var binding: ActivityMenuScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // val email = intent.extras?.getString("email")



        binding.BTNSendDocument.setOnClickListener{
            val intent: Intent = Intent(this, SendDocuments:: class.java)
            startActivity(intent)
        }
        binding.BTNSeeDocument.setOnClickListener{
            val intent: Intent = Intent(this, ViewDocuments:: class.java)
            startActivity(intent)
        }
        binding.BTNLocation.setOnClickListener{
            val intent: Intent = Intent(this, Offices:: class.java)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
            val inflater: MenuInflater = menuInflater
            inflater.inflate(R.menu.nav_menu, menu)
            return super.onCreateOptionsMenu(menu)
        }
}