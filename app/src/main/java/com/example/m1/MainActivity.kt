package com.example.m1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.TextView

import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {
      lateinit var mainViewModel:MainViewModel
      lateinit var author:TextView
      lateinit var content:TextView
      lateinit var preButton: Button
      lateinit var nextButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     author=findViewById(R.id.author)
        content=findViewById(R.id.content)
        preButton=findViewById(R.id.preButton)
        nextButton=findViewById(R.id.nextButton)
       mainViewModel=ViewModelProvider(this,MainViewModelFactory(application))[MainViewModel::class.java]

       setQuote(mainViewModel.getQuote())

      nextButton.setOnClickListener {
          setQuote(mainViewModel.nextQuote())
      }
        preButton.setOnClickListener {
            setQuote(mainViewModel.prevQuote())
        }
    }
   fun setQuote(quote:quotes){
       author.text=quote.text
       content.text=quote.author
   }

}


