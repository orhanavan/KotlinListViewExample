package com.kotlin.kentlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detailed.*

class DetailedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val intent = intent
        val name = intent.getStringExtra("name")
        textView.text = name

        val chosen = Global.Chosen
        val selectedImage = chosen.returnImage()
        imageView.setImageBitmap(selectedImage)
    }
}
