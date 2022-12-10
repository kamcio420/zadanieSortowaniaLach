package com.example.sortowanialach

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import kotlin.random.Random
import kotlin.system.measureTimeMillis

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

        //INSERTION SORTING
        fun insertionSorting(arr:ArrayList<Int>){
            for (count in 1..arr.count() - 1){
                // println(items)
                val item = arr[count]
                var i = count
                while (i>0 && item < arr[i - 1]){
                    arr[i] = arr[i - 1]
                    i -= 1
                }
                arr[i] = item
            }
        }

        //BUBBLE SORTING
        fun bubbleSorting(arr:ArrayList<Int>)
        {
            var swap = true
            while(swap)
            {
                swap = false
                for(i in 0 until arr.size-1)
                {
                    if(arr[i] > arr[i+1])
                    {
                        val temp = arr[i]
                        arr[i] = arr[i+1]
                        arr[i + 1] = temp
                        swap = true
                    }
                }
            }
        }


        //SORT BUTTON ACTION
        sortButton.setOnClickListener() {
            val numbers = ArrayList<Int>()


            for(i in 0..elements.text.toString().toInt())
            {
                numbers.add(Random.nextInt(0, 99))
            }

            val bubbleTime= measureTimeMillis { //time counting
                for(i in 0..times.text.toString().toInt())
                {
                    bubbleSorting(numbers)
                    for (i in 0..elements.text.toString().toInt())
                    {
                        numbers[i] = (Random.nextInt(0, 99))
                    }
                }
            }

            val insertionTime= measureTimeMillis { //time counting
                for(i in 0..times.text.toString().toInt())
                {
                    insertionSorting(numbers)
                    for (i in 0..elements.text.toString().toInt())
                    {
                        numbers[i] = (Random.nextInt(0, 99))
                    }
                }
            }

            s1.text = insertionTime.toString() + " ms"
            s2.text = bubbleTime.toString() + " ms"
        }
    }
}