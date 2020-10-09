package com.infrontofthenet.f20lesson4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // read the name key from the extras object and display in our 2nd TextView
        val name = intent.getStringExtra("name")
        messageTextView.text = "Welcome $name"

        browseButton.setOnClickListener {
            // if we have a url entered, use an implicit intent to load that url in the browser
            if (urlEditText.text.toString().isNotEmpty()) {
                val url = urlEditText.text.toString()

                // create a new intent and specify it's action is to View
                val i = Intent(Intent.ACTION_VIEW)

                // add data to the intent - the url we want to open
                i.data = Uri.parse(url)

                // launch the intent - startActivity() is used for both implicit & explicit intents
                startActivity(i)
            }
        }

        //from Linh Duong Phung to everyone
        smsButton.setOnClickListener{
            if (phoneEditText.text.toString().isNotEmpty() && messageEditText.text.toString().isNotEmpty()){
                val phone = phoneEditText.text.toString()
                val message = messageEditText.text.toString()
                val uri = Uri.parse("smsto:$phone");
                val intent = Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", message);
                startActivity(intent);
            }
        }
    }
}