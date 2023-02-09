package edu.temple.inclassuiacvitivity

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TextSizeAdapter(_context: Context, _textSizes: Array<Int>) : BaseAdapter() {

    val context = _context
    val textSizes = _textSizes

    //Returns the amount of views it can generate
    override fun getCount(): Int {
        return textSizes.size
    }

    //Gets the item in the index or position of the array
    override fun getItem(p0: Int): Any {
        return textSizes[p0]
    }

    //No need to implement this function since we do not need a unique id
    override fun getItemId(p0: Int) = p0.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        return (getDropDownView(p0, p1, p2) as TextView).apply {
            textSize = 22f
        }
    }
    override fun getDropDownView(p0: Int, p1: View?, parent: ViewGroup?): View {
        val textView: TextView

        if(p1 == null) {
            textView = TextView(context)
            textView.setPadding(10, 20, 0, 20)
        } else {
            textView = p1 as TextView
        }
        //Set the text sizes of the font
        textView.textSize = textSizes[p0].toFloat()
        textView.text = textSizes[p0].toString()

        return textView
    }

}