package com.example.quizapp

object SetData {

    const val name: String = "name"
    const val score: String = "score"

     fun getQuestion():ArrayList<QuestionData>{

         val que: ArrayList<QuestionData> = arrayListOf()

         val question1 = QuestionData(
             "What is the capital of India ?",
             1,
             "Mumbai",
             "Chennai",
             "Delhi",
             "Kolkata",
             3
         )

         val question2 = QuestionData(
             "Who is the first Prime Minister of India ?",
             2,
             "Narendra Modi",
             "Rajiv Gandhi",
             "Indira Gandhi",
             "Jawahar Lal Nehru",
             4
         )

         val question3 = QuestionData(
             "What is the name of Sholay' s iconic villain ?",
             3,
             "Kaalia",
             "Thakur",
             "Sudaama",
             "Gabbar Singh",
             4
         )

         val question4 = QuestionData(
             "Which of the following is not a junk food ?",
             4,
             "Pizza",
             "Burger",
             "Dal-Roti",
             "Momos",
             3
         )

         val question5 = QuestionData(
             "How many days do we have in a week ?",
             5,
             "Seven",
             "Ten",
             "Thirty",
             "Six",
             1
         )

         que.add(question1)
         que.add(question2)
         que.add(question3)
         que.add(question4)
         que.add(question5)

         return que
     }
}