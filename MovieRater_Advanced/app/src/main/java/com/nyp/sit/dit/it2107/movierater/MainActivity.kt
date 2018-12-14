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



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


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
        menuInflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.home)
        {
            super.onBackPressed()
            return true
        }
        if (item?.itemId == R.id.mibuttonAdd)
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

                movieObject = Movie(radioButtonInput, checkedOrNt, inputName.toString(), inputDesc.toString(), releasedDate.toString(), violence, language, -1.0, "")

                var intentView = Intent(this, viewMovie::class.java)
                startActivity(intentView)
            }
            movieArray.add(movieObject)

        }
        if (item?.itemId == R.id.miClear)
        {
            editTextName.setText("")
            editTextDate.setText("")
            editTextDesc.setText("")
            checkBoxM18.isChecked = false
            checkBoxLanguage.isChecked = false
            checkBoxViolence.isChecked = false
            radioButtonChinese.isChecked = false
            radioButtonEng.isChecked = false
            radioButtonMalay.isChecked = false
            radioButtonTamil.isChecked = false
        }
        return super.onOptionsItemSelected(item)
    }
}
