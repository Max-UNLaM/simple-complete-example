package com.example.myapplication.ui

import android.R.layout
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val kittiesViewModel: KittiesViewModel by viewModel()
    private lateinit var kittyImage: ImageView
    private lateinit var kittyId: TextView
    private lateinit var toast: Toast

    private val kittyIdObserver = Observer<String> { newId ->
        kittyId.text = newId
    }

    private val kittyUrlObserver = Observer<Uri> { newURI ->
        Picasso.get().load(newURI).into(kittyImage)
    }

    private val errorMessageObserver = Observer<String> { status ->
        toast.setText(status)
        toast.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        kittyId = findViewById(R.id.kittyId)
        kittyImage = findViewById(R.id.kittyImage)
        toast = Toast.makeText(applicationContext, "Error", 100)

        kittiesViewModel.kittyId.observe(this, kittyIdObserver)
        kittiesViewModel.kittyImageUrl.observe(this, kittyUrlObserver)
        kittiesViewModel.errorMessage.observe(this, errorMessageObserver)
        lifecycleScope.launch {
            kittyImage.setOnClickListener {
                kittiesViewModel.randomize()
            }
        }

    }

}
