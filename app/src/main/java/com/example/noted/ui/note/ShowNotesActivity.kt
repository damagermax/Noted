package com.example.noted.ui.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.noted.NoteList
import com.example.noted.R
import com.example.noted.adapter.NoteAdapter
import com.example.noted.ui.NewBottomSheet
import com.example.noted.viewmodel.ToDoViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShowNotesActivity : AppCompatActivity() {


    private lateinit var viewModel: ToDoViewModel
    private lateinit var noteAdapter: NoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_notes)
        val actionBar=supportActionBar
        actionBar!!.title="Notes"
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)


        viewModel = ViewModelProvider(this).get(ToDoViewModel::class.java)


        /*--------------- move to add note screen -----------------*/
        findViewById<FloatingActionButton>(R.id.button_add_note).setOnClickListener {
            val intent= Intent(this,AddNoteActivity::class.java)
            startActivity(intent)
        }




        hookDataToRecyclerVView()
    }

    private fun hookDataToRecyclerVView() {

        val noteRecyclerView: RecyclerView = findViewById(R.id.note_recyclerView)
        noteAdapter = NoteAdapter()
        noteAdapter.setNote(NoteList.not)
        noteRecyclerView.setHasFixedSize(true)
        noteRecyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        noteRecyclerView.adapter = noteAdapter
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}