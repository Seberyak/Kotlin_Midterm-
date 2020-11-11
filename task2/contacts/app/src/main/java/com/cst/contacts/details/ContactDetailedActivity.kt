package com.cst.contacts.details

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cst.contacts.R


class ContactDetailedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contac_details_layout)

        val id = intent.getLongExtra("id", 1)
        val result = ContactDetailedFragment().getContactById(id)

        findViewById<TextView>(R.id.fistLetterImageId).apply {
            text = result?.name?.substring(0, 1)
        }
        findViewById<TextView>(R.id.usernameId).apply {
            text = result?.name
        }
        findViewById<TextView>(R.id.phoneNumberId).apply {
            text = result?.phoneNumbers?.get(0)?.number
        }

        findViewById<TextView>(R.id.emailId).apply {

            if (result?.emails?.isNotEmpty()!!) {
                text = result.emails[0].address
            }
        }

    }

    fun back(view: View) {
        onBackPressed()
    }

    fun call(view: View) {
        Toast.makeText(this, "Calling", Toast.LENGTH_SHORT).show()
    }

    fun message(view: View) {
        Toast.makeText(this, "Messaging", Toast.LENGTH_SHORT).show()
    }

    fun email(view: View) {
        Toast.makeText(this, "Emailing", Toast.LENGTH_SHORT).show()
    }

    fun videoCall(view: View) {
        Toast.makeText(this, "Video Calling", Toast.LENGTH_SHORT).show()
    }
}