package com.example.quiz

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Secure.getString
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val slideText = AnimationUtils.loadAnimation(this, R.anim.text_slide)
        val answer_one = findViewById<CheckBox>(R.id.ques1_op1)
        val answer_two = findViewById<CheckBox>(R.id.ques1_op2)
        val answer_three = findViewById<CheckBox>(R.id.ques1_op3)

        val question = findViewById<TextView>(R.id.ques_Box)

        val submit = findViewById<Button>(R.id.submit_btn)
        val next = findViewById<Button>(R.id.next_btn)
        val Result = findViewById<TextView>(R.id.result_tv)

        fun showWrongAns() {
            Result.setText("WRONG ANSWER!")
            answer_one.setTextColor(Color.GREEN)
            answer_two.setTextColor(Color.RED)
            answer_three.setTextColor(Color.RED)
        }

        fun showValidation() {
            Result.setText("Please Check At Least One Option!")
            answer_one.setTextColor(Color.BLACK)
            answer_two.setTextColor(Color.BLACK)
            answer_three.setTextColor(Color.BLACK)

        }

        fun showValidation2() {
            Result.setText("Please Check Only One Option!")
            answer_one.setTextColor(Color.BLACK)
            answer_two.setTextColor(Color.BLACK)
            answer_three.setTextColor(Color.BLACK)
        }


        fun showRightAnswer() {
            Result.setText("RIGHT ANSWER!")
            answer_one.setTextColor(Color.GREEN)
            answer_two.setTextColor(Color.BLACK)
            answer_three.setTextColor(Color.BLACK)
        }


        question.startAnimation(slideText)


        submit.setOnClickListener {

            if (!answer_one.isChecked && !answer_two.isChecked && !answer_three.isChecked) {
                showValidation()
            }

            else if ((answer_one.isChecked && answer_two.isChecked && answer_three.isChecked) ||
                (answer_one.isChecked && answer_two.isChecked) ||
                (answer_two.isChecked && answer_three.isChecked) ||
                (answer_one.isChecked && answer_three.isChecked)) {
                showValidation2()
            }

            else {
                if (answer_one.isChecked) {
                    showRightAnswer()
                } else {
                    showWrongAns()
                }

            }

//            we can use this feature to stop getting multiple submission
//            submit.setEnabled(false)
        }



        next.setOnClickListener {

            if (!answer_one.isChecked && !answer_two.isChecked && !answer_three.isChecked ) {
                showValidation()
            }
            else {
                question.text = getString(R.string.ques_2)
                answer_one.text = getString(R.string.op_1)
                answer_two.text = getString(R.string.op_2)
                answer_three.text = getString(R.string.op_3)
                question.startAnimation(slideText)
                next.setEnabled(false)
            }

//            submit.setEnabled(true)

            answer_one.setTextColor(Color.BLACK)
            answer_two.setTextColor(Color.BLACK)
            answer_three.setTextColor(Color.BLACK)

            answer_one.setChecked(false)
            answer_two.setChecked(false)
            answer_three.setChecked(false)


            submit.setOnClickListener {

                if (!answer_one.isChecked && !answer_two.isChecked && !answer_three.isChecked) {
                    showValidation()
                }

                else if ((answer_one.isChecked && answer_two.isChecked && answer_three.isChecked) ||
                    (answer_one.isChecked && answer_two.isChecked) ||
                    (answer_two.isChecked && answer_three.isChecked) ||
                    (answer_one.isChecked && answer_three.isChecked)) {
                    showValidation2()}

                else {
                    if (answer_one.isChecked)
                    {
                        showRightAnswer()
                    }
                    else
                    {
                        showWrongAns()
                    }
                }
            }
        }
    }
}
