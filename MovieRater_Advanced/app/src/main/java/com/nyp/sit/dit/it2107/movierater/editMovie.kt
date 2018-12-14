package com.nyp.sit.dit.it2107.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import com.nyp.sit.dit.it2107.movierater.Movie
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.EditText



class editMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName.setText(movieObject.inputName)
        editTextDate.setText(movieObject.releasedDate)
        editTextDesc.setText(movieObject.inputDesc)
        if (movieObject.radioButtonInput == "Malay")
        {
            radioButtonMalay.isChecked = true
        }
        if (movieObject.radioButtonInput == "Chinese")
        {
            radioButtonMalay.isChecked = true
        }
        if (movieObject.radioButtonInput == "English")
        {
            radioButtonMalay.isChecked = true
        }
        if (movieObject.radioButtonInput == "Tamil")
        {
            radioButtonMalay.isChecked = true
        }

        if (movieObject.checkedOrNt == "True")
        {
            checkBoxM18.isChecked = true
            if (movieObject.violence == "Violence")
            {
                checkBoxViolence.isChecked = true
            }
            if (movieObject.language == "Language")
            {
                checkBoxLanguage.isChecked = true
            }
        }
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


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.home)
        {
            super.onBackPressed()
            return true
        }

        if (item?.itemId == R.id.mibuttonSave)
        {
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

                val itemPos:Int = intent.getStringExtra("itemPosition").toInt()
                val selectedItem = movieArray.get(itemPos)
                selectedItem.inputName = inputName.toString()
                selectedItem.releasedDate = releasedDate.toString()
                selectedItem.inputDesc = releasedDate.toString()
                selectedItem.checkedOrNt = checkedOrNt
                selectedItem.language = language
                selectedItem.radioButtonInput = radioButtonInput
                selectedItem.violence = violence
                selectedItem.reviewText = movieObject.reviewText
                movieObject = Movie(radioButtonInput, checkedOrNt, inputName.toString(), inputDesc.toString(), releasedDate.toString(), violence, language, movieObject.review, movieObject.reviewText)

                var intentView = Intent(this, viewMovie::class.java)
                startActivity(intentView)
            }
        }
        if (item?.itemId == R.id.miCancel)
        {
            var intentView = Intent(this, viewMovie::class.java)
            startActivity(intentView)
        }
        return super.onOptionsItemSelected(item)
    }
}
