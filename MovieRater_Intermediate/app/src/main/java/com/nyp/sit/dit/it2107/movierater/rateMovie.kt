package com.nyp.sit.dit.it2107.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import com.nyp.sit.dit.it2107.movierater.Movie
import kotlinx.android.synthetic.main.rate_movie.*

class rateMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rate_movie)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.rate,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.miSave)
        {
            var reviewStars = rateBar.rating
            movieObject.review = reviewStars.toDouble()
            var reviewText = shareViewEditText.text
            movieObject.reviewText = reviewText.toString()
            var intentView = Intent(this, viewMovie::class.java)
            startActivity(intentView)
        }
        return super.onOptionsItemSelected(item)
    }
}