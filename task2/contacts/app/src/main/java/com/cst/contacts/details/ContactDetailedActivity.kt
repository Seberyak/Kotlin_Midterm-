package com.cst.contacts.details

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.cst.contacts.R


class ContactDetailedActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contac_details_layout)

        val id = intent.getLongExtra("id", 1)
        val shapeColor = intent.getIntExtra("shapeColor", Color.BLUE)
        val result = ContactDetailedFragment().getContactById(id)

        val shapeImage: ImageView = findViewById(R.id.shapeImageId)
        shapeImage.setColorFilter(shapeColor)


        findViewById<TextView>(R.id.fistLetterImageId).text = result?.name?.substring(0, 1)


        findViewById<TextView>(R.id.usernameId).text = result?.name

        findViewById<TextView>(R.id.phoneNumberId).text = result?.phoneNumbers?.get(0)?.number


    }

}