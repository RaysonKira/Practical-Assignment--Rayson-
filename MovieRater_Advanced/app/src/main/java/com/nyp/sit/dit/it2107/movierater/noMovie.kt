package com.nyp.sit.dit.it2107.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import com.nyp.sit.dit.it2107.movierater.Movie
import kotlinx.android.synthetic.main.no_movie.*

class noMovie: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.no_movie)

        var movieNameList = mutableListOf<String>()
        for (movie in movieArray)
        {
            movieNameList.add(movie.inputName)
        }
        // Adding into the listview
        val adapt = ArrayAdapter(this, android.R.layout.simple_list_item_1, movieNameList)
        listViewMovie.adapter = adapt
        registerForContextMenu(listViewMovie)

        listViewMovie.setOnItemClickListener { parent, view, position, id ->
            val sI = movieArray.get(position)
            movieObject = Movie(sI.radioButtonInput, sI.checkedOrNt, sI.inputName, sI.inputDesc, sI.releasedDate, sI.violence, sI.language, sI.review, sI.reviewText)
            val viewIntent = Intent(applicationContext, viewMovie::class.java)
            startActivity(viewIntent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.landing,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.mibuttonAdd)
        {
            var intentView = Intent(this, MainActivity::class.java)
            startActivity(intentView)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == 1001)
        {
            var itemPosition = ""
            for (i in movieArray)
            {
                if (movieArray.indexOf(i).toString() == menuIndex.toString())
                {
                    itemPosition = menuIndex.toString()
                    movieObject = Movie(i.radioButtonInput, i.checkedOrNt, i.inputName, i.inputDesc, i.releasedDate, i.violence, i.language, i.review, i.reviewText)
                }
            }

            var intentView = Intent(this, editMovie::class.java)
            intentView.putExtra("itemPosition", itemPosition)
            startActivity(intentView)
        }
        return super.onContextItemSelected(item)
    }

    var menuIndex = 0
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.listViewMovie)
        {
            val menuInformation = menuInfo as AdapterView.AdapterContextMenuInfo
            menuIndex = menuInformation.position
            var newObject = listViewMovie.getItemAtPosition(menuIndex)
            menu?.add(1,1001,1,"Edit")
        }
    }
}

