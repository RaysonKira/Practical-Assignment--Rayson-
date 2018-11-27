package com.nyp.sit.dit.it2107.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_movie.*

class viewMovie: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_movie)

        var suitable = ""

        titleTextView.text = movieObject.inputName
        overviewTextView.text = movieObject.inputDesc
        languageTextView.text = movieObject.radioButtonInput
        dateTextView.text = movieObject.releasedDate
        if (movieObject.violence != "" || movieObject.language != "")
        {
            suitable = "No"
        }
        else
        {
            suitable = "Yes"
        }
        m18TextView.text = suitable

        //Check if there is any review
        if (movieObject.review == -1)
        {
            reviewTextView.text = "No Review Yet." + "\n" + "Long press here too add your review"
        }
    }
}