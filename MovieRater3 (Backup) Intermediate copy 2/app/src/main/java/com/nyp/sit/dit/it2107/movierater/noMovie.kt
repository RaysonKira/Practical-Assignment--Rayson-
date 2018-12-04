package com.nyp.sit.dit.it2107.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import com.nyp.sit.dit.it2107.movierater.Movie
import kotlinx.android.synthetic.main.no_movie.*

class noMovie: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.no_movie)
        registerForContextMenu(words)

    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v?.id == R.id.words) {
            menu?.add(1, 1001, 1, "Add")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == 1001){
            var intentView = Intent(this, MainActivity::class.java)
            startActivity(intentView)
        }
        return super.onContextItemSelected(item)
    }
}

