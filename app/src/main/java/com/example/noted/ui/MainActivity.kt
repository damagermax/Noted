package com.example.noted.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.noted.NoteList
import com.example.noted.R
import com.example.noted.adapter.NoteAdapter
import com.example.noted.db.roomdatabase.todos.ToDoEntity
import com.example.noted.ui.note.ShowNotesActivity
import com.example.noted.ui.todo.ShowTodoActivity

import com.example.noted.viewmodel.ToDoViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navigationView: NavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val newBottomSheet = NewBottomSheet()
        findViewById<FloatingActionButton>(R.id.button_new).setOnClickListener {
            newBottomSheet.show(supportFragmentManager, "fnf")
        }


        setUpNavigationViewOnItemSelectListener()
        setUpDrawerLayOutWithActionBar()


    }




    private fun setUpNavigationViewOnItemSelectListener() {

        navigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.home -> {

                }
                R.id.checklist -> Toast.makeText(applicationContext, "fhf", Toast.LENGTH_SHORT).show()
                R.id.notes -> {
                    val intent = Intent(this,ShowNotesActivity::class.java)
                    startActivity(intent)
                }
                R.id.todos -> {
                    val intent = Intent(this, ShowTodoActivity::class.java)
                    startActivity(intent)
                }

            }


            drawerLayout.closeDrawer(GravityCompat.START)
            true


        }
        navigationView.setCheckedItem(R.id.home) // default selected item


    }

    private fun setUpDrawerLayOutWithActionBar() {
        /* --------------------------- setup drawer layout with action bar -----------------------*/
        drawerLayout = findViewById(R.id.drawerLayout)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        /*-------------------------------------------END-------------------------------------------*/
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        else super.onBackPressed()
    }
}