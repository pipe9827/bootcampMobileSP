package com.example.finalproyect2.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.finalproyect2.Model.DocumentRequest
import com.example.finalproyect2.databinding.ActivitySendDocumentsBinding
import com.example.finalproyect2.viewModel.AuthViewModel
import com.example.finalproyect2.viewModel.DocumentsViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SendDocuments : AppCompatActivity() {
    private lateinit var binding: ActivitySendDocumentsBinding

    private val documentViewModel: DocumentsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendDocumentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.MBBack.setOnClickListener{
            val intent: Intent = Intent(this, MenuScreen:: class.java)
            startActivity(intent)
        }

        binding.MBSend.setOnClickListener{
            val TipoId = binding.SPTypeDocument.selectedItem.toString()
            val Id = binding.ETDocumentNumber.text.toString().trim()
            val Name = binding.ETNames.text.toString().trim()
            val Apellido = binding.ETLastNames.text.toString().trim()
            val city = binding.SPCities.selectedItem.toString()
            val email = binding.ETEmail.text.toString().trim()
            val typeAttatch = binding.ETTypeAttach.text.toString().trim()

            val documentRequest = DocumentRequest(
                TipoId = TipoId,
                Identificacion = Id,
                Nombre = Name,
                Apellido = Apellido,
                Ciudad = city,
                Correo = email,
                TipoAdjunto = typeAttatch
            )

         documentViewModel.saveDocument(documentRequest)

            Toast.makeText(this,"Send Success",Toast.LENGTH_LONG).show()

        }
    }
}