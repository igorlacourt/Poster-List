package com.example.posterlist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.posterlist.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //TODO save this recyclerview in a lib an make a class as an interface with method to call and instantiate the recyclerview from the main activity.
    }
}
