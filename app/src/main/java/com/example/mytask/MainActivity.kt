package com.example.mytask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView

class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val itemList = arrayListOf<String>()
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, itemList)
        val editText = findViewById<EditText>(R.id.editText)
        val listView = findViewById<ListView>(R.id.listView)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val addButton = findViewById<Button>(R.id.btnadd)
        val clear = findViewById<Button>(R.id.clear)
        var deleteButton = findViewById<Button>(R.id.delete)
        val position: SparseBooleanArray = listView.checkedItemPositions
        val count = listView.count
        var item = count - 1

        adapter.also { it.also { recyclerView.adapter } }
        addButton.setOnClickListener {
            itemList.add(editText.text.toString())
            listView.adapter = adapter
            adapter.notifyDataSetChanged()
            editText.text.clear()


            adapter.also { it.also { recyclerView.adapter } }
            clear.setOnClickListener {
                itemList.clear()
                adapter.notifyDataSetChanged()
            }
            listView.setOnItemClickListener { adapterView, view, i, l ->
                android.widget.Toast.makeText(
                    this,
                    "You Selected the item --> " + itemList.get(i),
                    android.widget.Toast.LENGTH_SHORT
                ).show()
            }


            deleteButton.setOnClickListener {

                while (item >= 0) {
                    if (position.get(item)) {
                        adapter.remove(itemList.get(item))
                    }
                    item--
                }
                position.clear()
                adapter.notifyDataSetChanged()
            }

        }
    }
}

