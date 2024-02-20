package com.example.wordle

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wordle.databinding.ActivityMainBinding
import com.example.wordle.R


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var textViews: List<List<TextView>>
    private var currentRow: Int = 0
    private var currentColumn: Int = 0
    private var numLettersInWord: Int = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setLetterClickListener(binding.buttonA)
        setLetterClickListener(binding.buttonB)
        setLetterClickListener(binding.buttonC)
        setLetterClickListener(binding.buttonD)
        setLetterClickListener(binding.buttonE)
        setLetterClickListener(binding.buttonF)
        setLetterClickListener(binding.buttonG)
        setLetterClickListener(binding.buttonH)
        setLetterClickListener(binding.buttonI)
        setLetterClickListener(binding.buttonJ)
        setLetterClickListener(binding.buttonK)
        setLetterClickListener(binding.buttonL)
        setLetterClickListener(binding.buttonM)
        setLetterClickListener(binding.buttonN)
        setLetterClickListener(binding.buttonO)
        setLetterClickListener(binding.buttonP)
        setLetterClickListener(binding.buttonQ)
        setLetterClickListener(binding.buttonR)
        setLetterClickListener(binding.buttonS)
        setLetterClickListener(binding.buttonT)
        setLetterClickListener(binding.buttonU)
        setLetterClickListener(binding.buttonV)
        setLetterClickListener(binding.buttonW)
        setLetterClickListener(binding.buttonX)
        setLetterClickListener(binding.buttonY)
        setLetterClickListener(binding.buttonZ)

        setBackClickListener(binding.buttonBack)


        textViews = listOf(
            listOf(
                binding.tv11,
                binding.tv12,
                binding.tv13,
                binding.tv14,
                binding.tv15
            ),
            listOf(
                binding.tv21,
                binding.tv22,
                binding.tv23,
                binding.tv24,
                binding.tv25
            ),
            listOf(
                binding.tv31,
                binding.tv32,
                binding.tv33,
                binding.tv34,
                binding.tv35
            ),
            listOf(
                binding.tv41,
                binding.tv42,
                binding.tv43,
                binding.tv44,
                binding.tv45
            ),
            listOf(
                binding.tv51,
                binding.tv52,
                binding.tv53,
                binding.tv54,
                binding.tv55
            ),
            listOf(
                binding.tv61,
                binding.tv62,
                binding.tv63,
                binding.tv64,
                binding.tv65
            )
        )

        setEnterClickListener(binding.buttonEnter, textViews)
//        updateBorder()
    }

    private fun setLetterClickListener(textView: TextView) {
        textView.setOnClickListener {
            if (currentColumn < numLettersInWord) {
                val text = textView.text.toString()
                textViews[currentRow][currentColumn].text = text
                currentColumn ++
//                updateBorder()
            }
        }
    }
    
    private fun setBackClickListener(textView: TextView) {
        textView.setOnClickListener {
            if (currentColumn > 0) {
                currentColumn -= 1
                textViews[currentRow][currentColumn].text = ""
//                if (currentTV.text.toString().isEmpty()) {
//                    Toast.makeText(applicationContext, "Already empty", Toast.LENGTH_LONG).show();
//                } else {
//                    textViews[currentColumn].text = ""
//                }
            }
        }
    }

    private fun setEnterClickListener(buttonTextView: TextView, userSubmittedLetters: List<List<TextView>>) {
        buttonTextView.setOnClickListener {
            if (currentColumn == 5) {
                val userSubmittedWord = userSubmittedLetters[currentRow].joinToString("") { it.text.toString() }
                Toast.makeText(applicationContext, userSubmittedWord, Toast.LENGTH_LONG).show()
            }
        }
    }



//    private fun updateBorder() {
//        for ((index, textView) in textViews.withIndex()) {
//            val drawable: Drawable? = if (index == currentColumn) {
//                resources.getDrawable(R.drawable.bg_tv_red_border)
//            } else {
//                resources.getDrawable(R.drawable.bg_tv)
//            }
//            textView.background = drawable
//        }
//    }
}