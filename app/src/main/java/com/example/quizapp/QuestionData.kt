package com.example.quizapp

data class QuestionData(
    var question: String,
    var id: Int,
    var optionOne: String,
    var optionTwo: String,
    var optionThree: String,
    var optionFour: String,
    var correctAns: Int
)
