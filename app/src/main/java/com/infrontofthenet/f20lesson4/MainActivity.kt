package com.infrontofthenet.f20lesson4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // event handler for Details button -> load Details activity using an explicit intent
        detailButton.setOnClickListener {
            // only invoke intent if the Edit Text has a value entered
            if (nameEditText.text.toString().isNotEmpty()) {
                // create a new intent using our app's context, and the Detail activities java class object
                val i = Intent(applicationContext, DetailActivity::class.java)

                // use an extra to pass the text entered in the TextView to the Detail activity
                i.putExtra("name", nameEditText.text.toString())

                // launch the new activity using the intent
                startActivity(i)
            }
            else {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            }
        }
    }
}