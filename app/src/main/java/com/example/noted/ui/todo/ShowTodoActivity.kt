package com.example.noted.ui.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.noted.R
import com.example.noted.adapter.ToDoAdapter
import com.example.noted.db.roomdatabase.todos.ToDoEntity
import com.example.noted.ui.NewBottomSheet
import com.example.noted.viewmodel.ToDoViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShowTodoActivity : AppCompatActivity() {

    private lateinit var toDoAdapter: ToDoAdapter
    private lateinit var toDoViewModel: ToDoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_todo)
        val actionBar = supportActionBar
        actionBar!!.title = "To Dos"
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)




        hookDataToRecyclerView()



    }

    private fun hookDataToRecyclerView() {


        val dummy = arrayListOf<ToDoEntity>(
            ToDoEntity(5, "bkbsk", "fjhuw", "jfhf", true),
            ToDoEntity(5, "bkbsk", "fjhuw", "jfhf", true),
            ToDoEntity(5, "bkbsk", "fjhuw", "jfhf", true),
            ToDoEntity(5, "bkbsk", "fjhuw", "jfhf", true),
            ToDoEntity(5, "bkbsk", "fjhuw", "jfhf", true),
            ToDoEntity(5, "bkbsk", "fjhuw", "jfhf", true)
        )

        toDoAdapter = ToDoAdapter()
        toDoViewModel = ViewModelProvider(this).get(ToDoViewModel::class.java)
        toDoViewModel.readAllToDo().observe(this, {

        })
        toDoAdapter.setData(dummy)

        val taskRecyclerView: RecyclerView = findViewById(R.id.toDoRecyclerView)
        taskRecyclerView.setHasFixedSize(true)
        taskRecyclerView.adapter = toDoAdapter


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}