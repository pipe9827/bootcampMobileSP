package com.example.finalproyect2.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.finalproyect2.Model.PersonalInfo
import com.example.finalproyect2.databinding.ActivityViewDocumentsBinding
import com.example.finalproyect2.viewModel.DocumentsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewDocuments : AppCompatActivity() {

    private lateinit var binding: ActivityViewDocumentsBinding

    private val documentViewModel: DocumentsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewDocumentsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        documentViewModel.getDocument(PersonalInfo.Email?:"")
        documentViewModel.documentResponse.observe(this, Observer {
            val adapter = DocumentAdapter(it.documents)
            binding.rvList.adapter = adapter
        })




        binding.MBBack.setOnClickListener{
            val intent: Intent = Intent(this, MenuScreen:: class.java)
            startActivity(intent)
        }
    }
}