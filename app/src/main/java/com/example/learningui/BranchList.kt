package com.example.learningui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class BranchList : AppCompatActivity() {

    private lateinit var list: ListView

    var branch = arrayOf("South Africa", "Lorem", "Ipsum", "Hello", "World", "consolidate", "pan", "instruction", "orange", "outlook")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_branch_list)

        list = findViewById(R.id.listView_list)
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch)
        list.adapter = adapter

        list.setOnItemClickListener { _, _, i, _ ->
            var str = list.adapter.getItem(i).toString()
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.putExtra("name", str)
            startActivity(intent)
            Toast.makeText(this, "Item Sekected ${branch[i]}", Toast.LENGTH_SHORT).show()
        }


    }
}