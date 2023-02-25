package com.example.m1

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(val context:Context):ViewModel() {
  private var quoteList:Array<quotes> = emptyArray()
    private var index=0
    init {
        quoteList=loadQuoteFromAssets()
    }

    private fun loadQuoteFromAssets(): Array<quotes> {
        val inputStream =context.assets.open("quotes.json")
        val size:Int=inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json= String(buffer,Charsets.UTF_8)
        val gson=Gson()
       return gson.fromJson(json,Array<quotes>::class.java)

    }

    fun getQuote()=quoteList[index]
    fun nextQuote()=quoteList[++index]
    fun prevQuote()=quoteList[--index]


}