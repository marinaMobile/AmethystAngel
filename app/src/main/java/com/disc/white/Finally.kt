package com.disc.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.disc.R
import kotlinx.android.synthetic.main.activity_finally.*

class Finally : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finally)
        scores.text = getIntent().getStringExtra("key")
        btn_again.setOnClickListener{
            startActivity(Intent(this, Game::class.java))
        }
    }
}