package com.example.livedata1

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

typealias QuestionClickHandler = (Question) -> Unit

class QuestionAdapter(var onShowQuestionClick : QuestionClickHandler ) :
    ListAdapter<Question, QuestionAdapter.ViewHolder>(QuestionDiffCallback) {

    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val tvDescr = view.findViewById<TextView>(R.id.tvDescr)
        val tvNumber = view.findViewById<TextView>(R.id.tvNum)
        val tvAnswer = view.findViewById<TextView>(R.id.tvAnswer)
        val btnShow = view.findViewById<Button>(R.id.btnShowQuestion)

        fun bind(question: Question , onShowQuestionClick: QuestionClickHandler? ){
            tvNumber.text = question.number.toString()
            tvAnswer.text = question.answer.toString()
            tvDescr.text = question.descr

            btnShow.setOnClickListener {
                    onShowQuestionClick?.invoke(question)
            }
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): QuestionAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.question_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position) , onShowQuestionClick)
    }

    object QuestionDiffCallback : DiffUtil.ItemCallback<Question>() {
        override fun areItemsTheSame(oldItem: Question, newItem: Question): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Question, newItem: Question): Boolean {
            return oldItem == newItem
        }
    }

}