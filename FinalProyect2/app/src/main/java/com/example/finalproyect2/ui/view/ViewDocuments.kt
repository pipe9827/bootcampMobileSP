package com.example.finalproyect2.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finalproyect2.databinding.ActivityViewDocumentsBinding

class ViewDocuments : AppCompatActivity() {

    private lateinit var binding: ActivityViewDocumentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewDocumentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.MBBack.setOnClickListener{
            val intent: Intent = Intent(this, MenuScreen:: class.java)
            startActivity(intent)
        }
    }
}