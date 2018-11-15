package com.nyp.sit.dit.it2107.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import com.nyp.sit.dit.it2107.movierater.Movie
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkBoxM18.setOnClickListener(View.OnClickListener {
            if (checkBoxM18.isChecked) {
                checkBoxLanguage.visibility = View.VISIBLE
                checkBoxViolence.visibility = View.VISIBLE
            }
            else {
                checkBoxLanguage.visibility = View.INVISIBLE
                checkBoxViolence.visibility = View.INVISIBLE
            }
        })

//        radioGroupLanguage.setOnCheckedChangeListener( // see for the group
//            RadioGroup.OnCheckedChangeListener{ group, checkedId ->
//                val radio: RadioButton = findViewById(checkedId)
//            }) // check for radio group in the inbuild controls
    }

    fun buttonAdd (v: View) {
        var radioButtonInput = ""
        var checkedOrNt = ""
        var inputName = editTextName.text
        var inputDesc = editTextDesc.text
        var releasedDate = editTextDate.text

        // Radio Button
        if (radioButtonChinese.isChecked)
        {
            radioButtonInput = "Chinese"
        }
        else if (radioButtonEng.isChecked)
        {
            radioButtonInput = "English"
        }
        else if (radioButtonMalay.isChecked)
        {
            radioButtonInput = "Malay"
        }
        else if (radioButtonTamil.isChecked)
        {
            radioButtonInput = "Tamil"
        }
        else
        {
            textView8.setError("Please check a Radio Button!")
        }

        // CheckBox
        if (checkBoxLanguage.isChecked)
        {
            checkedOrNt = "True"
        }
        else
        {
            checkedOrNt = "false"
        }

        var violence = ""
        var language = ""
        if (checkBoxViolence.isChecked || checkBoxLanguage.isChecked)
        {
            if (checkBoxViolence.isChecked) {
                violence = "Violence"
            }
            if (checkBoxLanguage.isChecked) {
                language = "Language"
            }
        }
        else
        {
            textView9.setError("Please Check A CheckBox!")
        }
        //Validate
        if (editTextName.text.toString() == "")
        {
            editTextName.setError("Field Empty")
        }
        if (editTextDate.text.toString() == "")
        {
            editTextDate.setError("Field Empty")
        }
        if (editTextDesc.text.toString() == "")
        {
            editTextDesc.setError("Field Empty")
        }
        else
        {
            var message:String = "Title: " + inputName + "\n" + "Overview: " + inputDesc + "\n" +"Released Date: " + releasedDate + "\n" +"Language: " + radioButtonInput + "\n" +"Suitable for all age: " + checkedOrNt + "\n" + "Reasons:" + "\n" + violence + "\n" + language
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

        movieObject.inputName= inputName.toString()
        movieObject.releasedDate = releasedDate.toString()
        movieObject.inputDesc = inputDesc.toString()
        movieObject.checkedOrNt = checkedOrNt
        movieObject.radioButtonInput = radioButtonInput
        movieObject.violence = violence
        movieObject.language = language
        //Print out details
//        textView.setText(radioButtonInput + inputName + inputDesc + releasedDate)
    }

    fun buttonView(v:View)
    {
        var intentView = Intent(this, viewMovie::class.java)
        startActivity(intentView)
    }
}
