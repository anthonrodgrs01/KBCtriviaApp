package com.example.kbctriviaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.kbctriviaapp.databinding.FragmentGameBinding


class GameFragment : Fragment() {

    data class Question(
        val text:String,
        val answers: List<String>
        )

    private val questions : MutableList<Question> = mutableListOf(
        Question(text ="Who is the Prime Minister of India",
                 answers = listOf("Narendra Modi","Virat Kohli","Manmohan Singh","Rahul Gandhi")),
        Question(text = "Who is the best batsmen in cricket",
            answers = listOf("Virat Kohli","Babar Azam","Steve Smith","Ben Stokes")),
        Question(text = "When is republic day celebrated in India",
        answers = listOf("15th August","26th January","14th August","26th November")),
        Question(text = "Where is Pune located",
        answers = listOf("Maharashtra", "Punjab", "Wuhan" , "New Zealand"))

    )

    lateinit var currentQuestion : Question
    lateinit var answers : MutableList<String>
    private var questionIndex = 0
    private var numQuestion = Math.min((questions.size + 1) / 2 , 3)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding : FragmentGameBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game,container,false)
        randomizeQuestions()
        return binding.root
    }

    private fun randomizeQuestions(){
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion(){
        currentQuestion = questions[questionIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
    }
















    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GameFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GameFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}