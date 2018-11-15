package com.nyp.sit.dit.it2107.movierater

import org.intellij.lang.annotations.Language

class Movie (radioButtonInput: String, checkedOrNt: String, inputName: String, inputDesc: String, releasedDate: String, violence:String, language: String)
{
    var radioButtonInput: String
    var checkedOrNt: String
    var inputName: String
    var inputDesc: String
    var releasedDate: String
    var violence: String
    var language: String

    init {
        this.radioButtonInput = radioButtonInput
        this.checkedOrNt = checkedOrNt
        this.inputName = inputName
        this.inputDesc = inputDesc
        this.releasedDate = releasedDate
        this.violence = violence
        this.language = language
    }
}

var movieObject = Movie("", "", "","","", "","")