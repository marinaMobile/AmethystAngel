package com.disc.white

import android.content.Intent
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.media.ExifInterface
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.disc.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_game.*
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class Game : AppCompatActivity() {
    var score: Int = 0
    var scr: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        randPos(diamond_one, 400)

        randPos(but_one, 100)


        diamond_one.setOnClickListener{
            score += 2
            scr++
            point_jew.text = scr.toString()
            scoretext.text = score.toString()
        }

        but_one.setOnClickListener {
            score++
            scr++
            point_but.text = scr.toString()
            scoretext.text = score.toString()
        }



        val s : Long = "30".toLong() * 1000

        object : CountDownTimer( s , 1000) {

            override fun onTick(millisUntilFinished: Long) {
                running.text = "${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                timeRan.text = "Time's Up!"
                val scrscr:String = score.toString()

                val intent = Intent(this@Game, Finally::class.java)
                intent.putExtra("key", scrscr)
                startActivity(intent)
            }
        }.start()


    }
    private fun randPos(Btn: ImageView, Time:Long) {
        val time: Long = Time
        val btn: ImageView = Btn
        val screenWidth = this.resources.displayMetrics.widthPixels
        val screenHeight = this.resources.displayMetrics.heightPixels
        Timer().schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val rand = Random()
                    val dx: Float = rand.nextFloat() * (screenWidth -diamond_one.width)
                    val dy: Float = rand.nextFloat() * (screenHeight -diamond_one.height)
                    btn.animate()
                        .x(dx)
                        .y(dy)
                        .setDuration(100)
                        .start()
                }
            }
        }, 0, time)
    }





}