//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.livedata1.Question
//import com.example.livedata1.R
//
//class QuestionAdapter : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {
//    var onItemClick: ((Question) -> Unit)? = null
//    var questionList: List<Question> = emptyList()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.question_row_item, parent, false)
//
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val question = questionList[position]
//        holder.text = question.descr
//    }
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val descr: TextView = itemView.findViewById()
//
//        init {
//            itemView.setOnClickListener { onItemClick?.invoke(questionList[adapterPosition]) }
//        }
//    }
//}
