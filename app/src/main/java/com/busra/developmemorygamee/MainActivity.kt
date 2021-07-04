package com.busra.developmemorygamee

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {
    private lateinit var tvp1: TextView
    private lateinit var tvp2: TextView
    private lateinit var iv11: ImageView
    private lateinit var iv12: ImageView
    private lateinit var iv13: ImageView
    private lateinit var iv14: ImageView
    private lateinit var iv21: ImageView
    private lateinit var iv22: ImageView
    private lateinit var iv23: ImageView
    private lateinit var iv24: ImageView
    private lateinit var iv31: ImageView
    private lateinit var iv32: ImageView
    private lateinit var iv33: ImageView
    private lateinit var iv34: ImageView

    //array for the images
    private var cardsArray = mutableListOf(101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206)

    private var image101 by Delegates.notNull<Int>()
    private var image102 by Delegates.notNull<Int>()
    private var image103 by Delegates.notNull<Int>()
    private var image104 by Delegates.notNull<Int>()
    private var image105 by Delegates.notNull<Int>()
    private var image106 by Delegates.notNull<Int>()
    private var image201 by Delegates.notNull<Int>()
    private var image202 by Delegates.notNull<Int>()
    private var image203 by Delegates.notNull<Int>()
    private var image204 by Delegates.notNull<Int>()
    private var image205 by Delegates.notNull<Int>()
    private var image206 by Delegates.notNull<Int>()

    private var firstCard by Delegates.notNull<Int>()
    private var secondCard by Delegates.notNull<Int>()
    private var clickedFirst by Delegates.notNull<Int>()
    private var clickedSecond by Delegates.notNull<Int>()
    private var cardNumber = 1

    private var turn = 1
    private var playerPoints = 0
    private var cpuPoint = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvp1 = findViewById(R.id.tv_p1)
        tvp2 = findViewById(R.id.tv_p2)

        iv11 = findViewById(R.id.iv_11)
        iv12 = findViewById(R.id.iv_12)
        iv13 = findViewById(R.id.iv_13)
        iv14 = findViewById(R.id.iv_14)
        iv21 = findViewById(R.id.iv_21)
        iv22 = findViewById(R.id.iv_22)
        iv23 = findViewById(R.id.iv_23)
        iv24 = findViewById(R.id.iv_24)
        iv31 = findViewById(R.id.iv_31)
        iv32 = findViewById(R.id.iv_32)
        iv33 = findViewById(R.id.iv_33)
        iv34 = findViewById(R.id.iv_34)


        iv11.tag = 0
        iv12.tag = 1
        iv13.tag = 2
        iv14.tag = 3
        iv21.tag = 4
        iv22.tag = 5
        iv23.tag = 6
        iv24.tag = 7
        iv31.tag = 8
        iv32.tag = 9
        iv33.tag = 10
        iv34.tag = 11

        //load the card images
        frontOfCardsResources()

        //suffle the images
        cardsArray.shuffle()

        //changing the color the second player (inactive)
        tvp2.setTextColor(Color.GRAY)

        iv11.setOnClickListener { v ->
            val theCard: Int = v.tag.toString().toInt()
            doStuff(iv11, theCard)
        }
        iv12.setOnClickListener { v ->
            val theCard: Int = v.tag.toString().toInt()
            doStuff(iv12, theCard)
        }
        iv13.setOnClickListener { v ->
            val theCard: Int = v.tag.toString().toInt()
            doStuff(iv13, theCard)
        }
        iv14.setOnClickListener { v ->
            val theCard: Int = v.tag.toString().toInt()
            doStuff(iv14, theCard)
        }
        iv21.setOnClickListener { v ->
            val theCard: Int = v.tag.toString().toInt()
            doStuff(iv21, theCard)
        }
        iv22.setOnClickListener { v ->
            val theCard: Int = v.tag.toString().toInt()
            doStuff(iv22, theCard)
        }
        iv23.setOnClickListener { v ->
            val theCard: Int = v.tag.toString().toInt()
            doStuff(iv23, theCard)
        }
        iv24.setOnClickListener { v ->
            val theCard: Int = v.tag.toString().toInt()
            doStuff(iv24, theCard)
        }
        iv31.setOnClickListener { v ->
            val theCard: Int = v.tag.toString().toInt()
            doStuff(iv31, theCard)
        }
        iv32.setOnClickListener { v ->
            val theCard: Int = v.tag.toString().toInt()
            doStuff(iv32, theCard)
        }
        iv33.setOnClickListener { v ->
            val theCard: Int = v.tag.toString().toInt()
            doStuff(iv33, theCard)
        }
        iv34.setOnClickListener { v ->
            val theCard: Int = v.tag.toString().toInt()
            doStuff(iv34, theCard)
        }


    }

    private fun doStuff(iv: ImageView, card: Int) {
        //set the correct image to the imageview
        when {
            cardsArray[card] == 101 -> iv.setImageResource(image101)
            cardsArray[card] == 102 -> iv.setImageResource(image102)
            cardsArray[card] == 103 -> iv.setImageResource(image103)
            cardsArray[card] == 104 -> iv.setImageResource(image104)
            cardsArray[card] == 105 -> iv.setImageResource(image105)
            cardsArray[card] == 106 -> iv.setImageResource(image106)

            cardsArray[card] == 201 -> iv.setImageResource(image201)
            cardsArray[card] == 202 -> iv.setImageResource(image202)
            cardsArray[card] == 203 -> iv.setImageResource(image203)
            cardsArray[card] == 204 -> iv.setImageResource(image204)
            cardsArray[card] == 205 -> iv.setImageResource(image205)
            cardsArray[card] == 206 -> iv.setImageResource(image206)
        }

        //check which image is selected and save it to temporary variable
        if (cardNumber == 1) {
            firstCard = cardsArray[card]
            if (firstCard > 200) {
                firstCard -= 100
            }
            cardNumber = 2
            clickedFirst = card

            iv.isEnabled = false
        } else if (cardNumber == 2) {
            secondCard = cardsArray[card]
            if (secondCard > 200) {
                secondCard -= 100
            }
            cardNumber = 1
            clickedSecond = card

            iv11.isEnabled = false
            iv12.isEnabled = false
            iv13.isEnabled = false
            iv14.isEnabled = false
            iv21.isEnabled = false
            iv22.isEnabled = false
            iv23.isEnabled = false
            iv24.isEnabled = false
            iv31.isEnabled = false
            iv32.isEnabled = false
            iv33.isEnabled = false
            iv34.isEnabled = false

            /*Handler().postDelayed({
                //check if the selected images are equal
                calculate()
            }, 1000) // 3000 is the delayed time in milliseconds.*/
            object : CountDownTimer(1500, 3000) {
                override fun onFinish() {
                    //check if the selected images are equal
                    calculate()
                }

                override fun onTick(p0: Long) {
                    Log.d("SplashActivity", p0.toString())
                }
            }.start()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calculate() {
        //if images are equal remove tgem and add point
        if (firstCard == secondCard) {
            when (clickedFirst) {
                0 -> iv11.visibility = View.INVISIBLE
                1 -> iv12.visibility = View.INVISIBLE
                2 -> iv13.visibility = View.INVISIBLE
                3 -> iv14.visibility = View.INVISIBLE
                4 -> iv21.visibility = View.INVISIBLE
                5 -> iv22.visibility = View.INVISIBLE
                6 -> iv23.visibility = View.INVISIBLE
                7 -> iv24.visibility = View.INVISIBLE
                8 -> iv31.visibility = View.INVISIBLE
                9 -> iv32.visibility = View.INVISIBLE
                10 -> iv33.visibility = View.INVISIBLE
                11 -> iv34.visibility = View.INVISIBLE
            }

            when (clickedSecond) {
                0 -> iv11.visibility = View.INVISIBLE
                1 -> iv12.visibility = View.INVISIBLE
                2 -> iv13.visibility = View.INVISIBLE
                3 -> iv14.visibility = View.INVISIBLE
                4 -> iv21.visibility = View.INVISIBLE
                5 -> iv22.visibility = View.INVISIBLE
                6 -> iv23.visibility = View.INVISIBLE
                7 -> iv24.visibility = View.INVISIBLE
                8 -> iv31.visibility = View.INVISIBLE
                9 -> iv32.visibility = View.INVISIBLE
                10 -> iv33.visibility = View.INVISIBLE
                11 -> iv34.visibility = View.INVISIBLE
            }

            //add points to the corrent player
            if (turn == 1) {
                playerPoints++
                tvp1.text = "P1: $playerPoints"
            } else {
                if (turn == 2) {
                    cpuPoint++
                    tvp2.text = "P2: $cpuPoint"
                }
            }
        } else {
            iv11.setImageResource(R.drawable.ic_back)
            iv12.setImageResource(R.drawable.ic_back)
            iv13.setImageResource(R.drawable.ic_back)
            iv14.setImageResource(R.drawable.ic_back)
            iv21.setImageResource(R.drawable.ic_back)
            iv22.setImageResource(R.drawable.ic_back)
            iv23.setImageResource(R.drawable.ic_back)
            iv24.setImageResource(R.drawable.ic_back)
            iv31.setImageResource(R.drawable.ic_back)
            iv32.setImageResource(R.drawable.ic_back)
            iv33.setImageResource(R.drawable.ic_back)
            iv34.setImageResource(R.drawable.ic_back)

            //change the player turn
            if (turn == 1) {
                turn = 2
                tvp1.setTextColor(Color.GRAY)
                tvp2.setTextColor(Color.BLACK)
            } else if (turn == 2) {
                turn = 1
                tvp2.setTextColor(Color.GRAY)
                tvp1.setTextColor(Color.BLACK)
            }
        }

        iv11.isEnabled = true
        iv12.isEnabled = true
        iv13.isEnabled = true
        iv14.isEnabled = true
        iv21.isEnabled = true
        iv22.isEnabled = true
        iv23.isEnabled = true
        iv24.isEnabled = true
        iv31.isEnabled = true
        iv32.isEnabled = true
        iv33.isEnabled = true
        iv34.isEnabled = true

        //check if the game is over
        checkEnd()
    }

    private fun checkEnd() {
        if (iv11.visibility == View.INVISIBLE && iv12.visibility == View.INVISIBLE && iv13.visibility == View.INVISIBLE && iv14.visibility == View.INVISIBLE &&
            iv21.visibility == View.INVISIBLE && iv22.visibility == View.INVISIBLE && iv23.visibility == View.INVISIBLE && iv24.visibility == View.INVISIBLE &&
            iv31.visibility == View.INVISIBLE && iv32.visibility == View.INVISIBLE && iv33.visibility == View.INVISIBLE && iv34.visibility == View.INVISIBLE) {
            val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
            alertDialogBuilder
                .setMessage("GAME OVER!\nP1: $playerPoints\nP2: $cpuPoint")
                .setCancelable(false)
                .setPositiveButton("NEW") { _, _ ->
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("EXIT") { _, _ -> finish() }
            val alertDialog: AlertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }

    private fun frontOfCardsResources() {
        image101 = R.drawable.ic_image101
        image102 = R.drawable.ic_image102
        image103 = R.drawable.ic_image103
        image104 = R.drawable.ic_image104
        image105 = R.drawable.ic_image105
        image106 = R.drawable.ic_image106
        image201 = R.drawable.ic_image201
        image202 = R.drawable.ic_image202
        image203 = R.drawable.ic_image203
        image204 = R.drawable.ic_image204
        image205 = R.drawable.ic_image205
        image206 = R.drawable.ic_image206
    }
}