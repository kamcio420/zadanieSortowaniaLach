package com.example.sortowanialach

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //DECRALATIONS
        val sortButton = findViewById<Button>(R.id.sortButton)
        val times = findViewById<TextInputEditText>(R.id.timesCount)
        val elements = findViewById<TextInputEditText>(R.id.elementsCount)
        val s1 = findViewById<TextView>(R.id.wstawianieTime)
        val s2 = findViewById<TextView>(R.id.babelkoweTime)
        val s3 = findViewById<TextView>(R.id.szybkieTime)
        val s4 = findViewById<TextView>(R.id.heapsortTIme)
        val s5 = findViewById<TextView>(R.id.scalanieTime)
        val sortResultOutput = findViewById<TextView>(R.id.sortResult)

    }
}