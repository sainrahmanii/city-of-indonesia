package com.sainrahmani.cityofindonesia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.sainrahmani.cityofindonesia.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvNameCity.text = intent.getStringExtra("name")
        binding.tvCityDescription.text = intent.getStringExtra("desc")
        binding.imgCity.setImageResource(intent.getIntExtra("poto", 0))

    }
}