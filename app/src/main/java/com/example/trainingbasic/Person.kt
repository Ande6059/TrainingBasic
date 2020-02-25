package com.example.trainingbasic

import java.io.Serializable
import java.util.*

data class Person(
    val firstname: String,
    val lastname: String,
    val age: Int,
    val birthdate: Date = Date()):Serializable