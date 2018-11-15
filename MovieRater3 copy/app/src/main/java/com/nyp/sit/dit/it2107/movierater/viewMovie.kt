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

        titleTextView.text = movieObject.inputName
        overviewTextView.text = movieObject.inputDesc
        languageTextView.text = movieObject.radioButtonInput
        dateTextView.text = movieObject.releasedDate
        var checked =  movieObject.violence + "\n" + movieObject.language
        m18TextView.text = checked
    }
}