package com.cst.googlemaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uninstallButton = findViewById<Button>(R.id.uninstallId)
        val openButton = findViewById<Button>(R.id.openId)
        val travelAndLocal = findViewById<ImageView>(R.id.travelId)
        val similar = findViewById<ImageView>(R.id.similarId)

        uninstallButton.setOnClickListener {
            Snackbar.make(it, R.string.uninstallSnackBar, Snackbar.LENGTH_LONG)
        }

        openButton.setOnClickListener {
            Snackbar.make(it, "Opened", Snackbar.LENGTH_LONG).show()
        }
        travelAndLocal.setOnClickListener {
            Snackbar.make(it, "Travel & Local", Snackbar.LENGTH_LONG).show()
        }

        similar.setOnClickListener {
            Snackbar.make(it, "Similar", Snackbar.LENGTH_LONG).show()
        }
    }


}