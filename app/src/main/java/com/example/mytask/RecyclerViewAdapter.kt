package com.example.mytask


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Array.get
import java.nio.file.Paths.get


class RecyclerViewAdapter(private var todolist: MutableList<String>) : RecyclerView.Adapter<RecyclerViewAdapter.TaskViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.textView.text= todolist[position]
    }

    override fun getItemCount(): Int {
        return todolist.size
    }

    inner class TaskViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.editText)

    }

}