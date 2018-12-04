package com.nyp.stud172077B.pracmocktestq1
import org.intellij.lang.annotations.Language

class User (gender: String, name: String, phoneNumber: String)
{
    var gender: String
    var name: String
    var phoneNumber: String

    init {
        this.gender = gender
        this.name = name
        this.phoneNumber = phoneNumber
    }
}

var userDetails = User("","","")