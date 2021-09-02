package com.example.noted.ui.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noted.R

class AddNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        val actionBar=supportActionBar
        actionBar!!.title="Add Note"
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}