package com.example.finalproyect2.Model

data class DocumentRequest(
    val TipoId: String,
    val Identificacion:String,
    val Nombre: String,
    val Apellido: String,
    val Ciudad: String,
    val Correo : String,
    val TipoAdjunto: String,
    val Adjunto: String = "Imagen no Definida"
    ){
}