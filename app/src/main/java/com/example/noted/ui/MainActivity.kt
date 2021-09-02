package com.example.noted.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.noted.NoteList
import com.example.noted.R
import com.example.noted.adapter.NoteAdapter
import com.example.noted.viewmodel.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navigationView: NavigationView
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var viewModel: NoteViewModel
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)


        /* --------------------------- setup drawer layout with action bar -----------------------*/
        drawerLayout = findViewById(R.id.drawerLayout)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        /*--------------- show new bottomSheet when float action button is clicked -----------------*/
        val newBottomSheet = NewBottomSheet()
        findViewById<FloatingActionButton>(R.id.button_add).setOnClickListener {

            newBottomSheet.show(supportFragmentManager, "fnf")

        }


        /*------------------ setup navigation view and item selected callback -----------------------*/
        navigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.home -> Toast.makeText(applicationContext, "fhf", Toast.LENGTH_SHORT).show()
                R.id.checklist -> Toast.makeText(applicationContext, "fhf", Toast.LENGTH_SHORT)
                    .show()
                R.id.notes -> Toast.makeText(applicationContext, "fhf", Toast.LENGTH_SHORT).show()

            }
            true
        }
        navigationView.setCheckedItem(R.id.home) // default selected item


        // setup recyclerView
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


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}