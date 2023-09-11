package com.example.quizapp

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {

    private lateinit var name: String
    private var score: Int = 0

    private var currentPosition: Int = 1
    private var questionList: ArrayList<QuestionData> = SetData.getQuestion()
    private var selectedOption: Int = 0

    private lateinit var binding: ActivityQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        name = intent.getStringExtra(SetData.name).toString()

        setQuestion()

        binding.opt1.setOnClickListener { selectedOptionStyle(binding.opt1, 1) }

        binding.opt2.setOnClickListener { selectedOptionStyle(binding.opt2, 2) }

        binding.opt3.setOnClickListener { selectedOptionStyle(binding.opt3, 3) }

        binding.opt4.setOnClickListener { selectedOptionStyle(binding.opt4, 4) }

        binding.submit.setOnClickListener {

            if (selectedOption != 0) {

                val question = questionList[currentPosition - 1]

                if (selectedOption != question.correctAns) {
                    setColor(selectedOption, R.drawable.wrong_question_option)
                } else {
                    score++
                }

                setColor(question.correctAns, R.drawable.correct_question_option)

                // Changing the submit button based on the currentPosition of Question
                if (currentPosition == questionList.size) {
                    binding.submit.text = resources.getString(R.string.finish)
                } else {
                    binding.submit.text = resources.getString(R.string.go_to_next)
                }

            } else {

                currentPosition++

                when {

                    // keep on setting questions and showing them to the user
                    currentPosition <= questionList.size -> setQuestion()

                    else -> {

                        // move to ResultActivity
                        val intent = Intent(this, Result::class.java)

                        intent.putExtra(SetData.name, name)
                        intent.putExtra(SetData.score, score.toString())
                        intent.putExtra("total size", questionList.size.toString())

                        startActivity(intent)
                        finish()
                    }
                }
            }

            selectedOption = 0
        }

    }

    // Based on selected option the background of the options are set
    private fun setColor(opt: Int, color: Int) {

        when (opt) {
            1 -> {
                binding.opt1.background = ContextCompat.getDrawable(this, color)
            }

            2 -> {
                binding.opt2.background = ContextCompat.getDrawable(this, color)
            }

            3 -> {
                binding.opt3.background = ContextCompat.getDrawable(this, color)
            }

            4 -> {
                binding.opt4.background = ContextCompat.getDrawable(this, color)
            }

        }
    }

    // Setting the question, progress bar and all the four options text
    private fun setQuestion() {

        // Setting Question
        val question = questionList[currentPosition - 1]
        binding.questionText.text = question.question

        // Setting the progress based on Current Question
        binding.progressBar.progress = currentPosition
        binding.progressBar.max = questionList.size
        binding.progressText.text = "$currentPosition" + "/" + "${questionList.size}"

        setOptionStyle()

        binding.opt1.text = question.optionOne
        binding.opt2.text = question.optionTwo
        binding.opt3.text = question.optionThree
        binding.opt4.text = question.optionFour
    }

    // Settings the options and their background
    private fun setOptionStyle() {

        val optionList: ArrayList<TextView> = arrayListOf()

        optionList.add(binding.opt1)
        optionList.add(binding.opt2)
        optionList.add(binding.opt3)
        optionList.add(binding.opt4)

        for (op in optionList) {
            op.setTextColor(resources.getColor(R.color.optionUnselectedColor))
            op.background = ContextCompat.getDrawable(this, R.drawable.ques_option)
            op.typeface = Typeface.DEFAULT
        }
    }

    // Setting a style to the selected option
    private fun selectedOptionStyle(view: TextView, opt: Int) {
        setOptionStyle()

        selectedOption = opt

        view.background = ContextCompat.getDrawable(this, R.drawable.selected_question_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(resources.getColor(R.color.black))

    }
}