package com.example.noted.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noted.Note
import com.example.noted.R

class NoteAdapter ():RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){
    private var noteList= emptyList<Note>()

    inner class NoteViewHolder(view:View):RecyclerView.ViewHolder(view){
        val noteTitle:TextView=view.findViewById(R.id.noteTitle)
        val noteBody:TextView=view.findViewById(R.id.noteBody)
        val noteTagColor:View=view.findViewById(R.id.tagColorIndicator)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.note_row_item,parent,false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        // get position of each list item
        val currentNote=noteList[position]

        // set values
        holder.noteBody.text = currentNote.noteBody
        holder.noteTitle.text = currentNote.noteTitle

    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun setNote(note:List<Note>){
        noteList=note

    }
}