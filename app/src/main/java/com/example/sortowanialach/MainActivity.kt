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

        //DECLARATIONS
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

        //QUICK SORTING
        fun quicksort(items:List<Int>):List<Int>{
            if (items.count() < 2){
                return items
            }
            val pivot = items[items.count()/2]

            val equal = items.filter { it == pivot }

            val less = items.filter { it < pivot }

            val greater = items.filter { it > pivot }

            return quicksort(less) + equal + quicksort(greater)
        }

        //HEAP SORTING
        var heapSize = 0

        fun left(i: Int): Int {
            return 2 * i
        }

        fun right(i: Int): Int {
            return 2 * i + 1
        }

        fun swap(A: ArrayList<Int>, i: Int, j: Int) {
            var temp = A[i]
            A[i] = A[j]
            A[j] = temp
        }

        fun max_heapify(A: ArrayList<Int>, i: Int) {
            var l = left(i);
            var r = right(i);
            var largest: Int;

            if ((l <= heapSize - 1) && (A[l] > A[i])) {
                largest = l;
            } else
                largest = i

            if ((r <= heapSize - 1) && (A[r] > A[l])) {
                largest = r
            }

            if (largest != i) {
                swap(A, i, largest);
                max_heapify(A, largest);
            }
        }

        fun buildMaxheap(A: ArrayList<Int>) {
            heapSize = A.size
            for (i in heapSize / 2 downTo 0) {
                max_heapify(A, i)
            }
        }

        fun heapsort(A: ArrayList<Int>) {
            buildMaxheap(A)
            for (i in A.size - 1 downTo 1) {
                swap(A, i, 0)
                heapSize = heapSize - 1
                max_heapify(A, 0)

            }
        }




        //SORT BUTTON ACTION
        sortButton.setOnClickListener() {
            val numbers = ArrayList<Int>()

            //Creating array with random numbers
            for(i in 0..elements.text.toString().toInt())
            {
                numbers.add(Random.nextInt(0, 99))
            }

            //Insertion time counting
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

            //Bubble time counting
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

            //Quick time counting
            val quickTime= measureTimeMillis { //time counting
                for(i in 0..times.text.toString().toInt())
                {
                    quicksort(numbers.toList())
                    for (i in 0..elements.text.toString().toInt())
                    {
                        numbers[i] = (Random.nextInt(0, 99))
                    }
                }
            }

            //Heap time counting
            val heapTime= measureTimeMillis { //time counting
                for(i in 0..times.text.toString().toInt())
                {
                    heapsort(numbers)
                    for (i in 0..elements.text.toString().toInt())
                    {
                        numbers[i] = (Random.nextInt(0, 99))
                    }
                }
            }

            //Merge time counting
            val mergeTime= measureTimeMillis { //time counting
                for(i in 0..times.text.toString().toInt())
                {
                    mergesort(numbers)
                    for (i in 0..elements.text.toString().toInt())
                    {
                        numbers[i] = (Random.nextInt(0, 99))
                    }
                }
            }


            s1.text = insertionTime.toString() + " ms"
            s2.text = bubbleTime.toString() + " ms"
            s3.text = quickTime.toString() + " ms"
            s4.text = heapTime.toString() + " ms"
            s5.text = mergeTime.toString() + " ms"
        }
    }
}