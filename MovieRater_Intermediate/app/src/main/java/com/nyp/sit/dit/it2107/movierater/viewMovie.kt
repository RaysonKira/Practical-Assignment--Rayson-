package com.nyp.sit.dit.it2107.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.rate_movie.*
import kotlinx.android.synthetic.main.view_movie.*

class viewMovie: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_movie)
        registerForContextMenu(reviewTextView)

        //Passing in values
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
        if (movieObject.review == -1.0)
        {
            reviewTextView.visibility = View.VISIBLE
            reviewTextView.text = "No Review Yet." + "\n" + "Long press here too add your review"
        }
        if (movieObject.review != -1.0)
        {
            reviewTextView.visibility = View.VISIBLE
            reviewTextView.text = movieObject.reviewText
            ratingBar.visibility = View.VISIBLE
            ratingBar.rating = movieObject.review.toFloat()
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v?.id == R.id.reviewTextView) {
            menu?.add(1, 1001, 1, "Add Review")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == 1001){
            var intentView = Intent(this, rateMovie::class.java)
            startActivity(intentView)
        }
        return super.onContextItemSelected(item)
    }
}