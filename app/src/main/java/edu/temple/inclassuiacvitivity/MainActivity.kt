package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* Step 1: Populate this array */
        //val numberArray = Array Of Numbers
        val arr = Array(50) { (it+1) * 2 }

        /* Step 2: Create adapter to display items from array in Spinner */
        //spinner.adapter = ArrayAdapter...
        //spinner.adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, arr)
        spinner.adapter = TextSizeAdapter(this, arr)

        // Step 3: Change TextView's text size to the number selected in the Spinner */
        //spinner.onItemSelectedListener = object: ...
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                parent?.run{
                    displayTextView.textSize = getItemAtPosition(position).toString().toFloat()
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}