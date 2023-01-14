package com.example.finalproyect2.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproyect2.databinding.DocumentItemBinding
import com.example.finalproyect2.responses.DocumentResponse
import com.example.finalproyect2.responses.Documents


class DocumentAdapter (private val documentList: List<Documents>)
    :RecyclerView.Adapter<DocumentAdapter.DocumentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentViewHolder {
        val binding = DocumentItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return DocumentViewHolder(binding)
    }

    override fun getItemCount() = documentList.size

    override fun onBindViewHolder(holder: DocumentViewHolder, position: Int) {
        with(holder) {
            with(documentList[position]) {
                binding.TVDate.text = Fecha
                binding.tvTypeDocument.text = TipoAdjunto
                binding.tvName.text = Nombre
            }
        }
    }

    inner class DocumentViewHolder(val binding: DocumentItemBinding)
        :RecyclerView.ViewHolder(binding.root)

}