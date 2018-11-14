package com.nyp.sit.dit.it2107.movierater

class Movie (radioButtonInput: String, checkedOrNt: String, inputName: String, inputDesc: String, releasedDate: String)
{
    var radioButtonInput: String
    var checkedOrNt: String
    var inputName: String
    var inputDesc: String
    var releasedDate: String

    init {
        this.radioButtonInput = radioButtonInput
        this.checkedOrNt = checkedOrNt
        this.inputName = inputName
        this.inputDesc = inputDesc
        this.releasedDate = releasedDate
    }
}
