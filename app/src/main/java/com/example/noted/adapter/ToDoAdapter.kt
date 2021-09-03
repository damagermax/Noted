package com.example.noted.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noted.R
import com.example.noted.db.roomdatabase.todos.ToDoEntity
import com.google.android.material.chip.Chip

class ToDoAdapter :RecyclerView.Adapter<ToDoAdapter.ToDoViewHolDer>() {

    private var toDoList= emptyList<ToDoEntity>()

    inner class ToDoViewHolDer(view: View):RecyclerView.ViewHolder(view){

        val toDoCheck:CheckBox=view.findViewById(R.id.rowRadioTask)
        val toDoDueDate:Chip=view.findViewById(R.id.rowDueDateChip)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolDer {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.to_do_row_item,parent,false)
        return ToDoViewHolDer(view)
    }

    override fun onBindViewHolder(holder: ToDoViewHolDer, position: Int) {
        val currentToDo=toDoList[position]

        holder.toDoDueDate.text=currentToDo.dueDate
        holder.toDoCheck.text=currentToDo.taskTitle
        holder.toDoCheck.setOnClickListener {
            val checked =holder.toDoCheck.isChecked
            if (checked){

            }
        }


    }

    override fun getItemCount(): Int {
      return toDoList.size
    }
    fun setData(toDoEntity: List<ToDoEntity>){
        toDoList=toDoEntity
       notifyDataSetChanged()
    }
}