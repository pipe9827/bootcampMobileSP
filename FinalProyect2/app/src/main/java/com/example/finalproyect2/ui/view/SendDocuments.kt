package com.example.finalproyect2.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finalproyect2.databinding.ActivitySendDocumentsBinding

class SendDocuments : AppCompatActivity() {
    private lateinit var binding: ActivitySendDocumentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendDocumentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.MBBack.setOnClickListener{
            val intent: Intent = Intent(this, MenuScreen:: class.java)
            startActivity(intent)
        }
    }
}