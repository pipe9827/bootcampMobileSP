package com.example.finalproyect2.responses

data class LoginResponse (
    val id  : String,
    val nombre  : String,
    val apellido  : String,
    val acceso: Boolean,
    val admin: Boolean
    )