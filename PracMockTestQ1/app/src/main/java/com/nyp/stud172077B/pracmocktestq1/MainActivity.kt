package com.nyp.stud172077B.pracmocktestq1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import com.nyp.stud172077B.pracmocktestq1.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Getting informations
        var inputName = enterName
        var inputPhoneNumber = enterPhoneNumber
        var gender = ""

        if (radioButtonMale.isChecked)
        {
            gender = "Male"
        }
        if (radioButtonFemale.isChecked)
        {
            gender = "Female"
        }

        //Displaying toast
        var message:String = "Name: " + inputName + "\n" + "Gender: " + gender + "\n" + "Phone Number: " + inputPhoneNumber
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
`
        //Putting into class
        userDetails.gender = gender
        userDetails.name = inputName.toString()
        userDetails.phoneNumber = inputPhoneNumber.toString()
    }
}
