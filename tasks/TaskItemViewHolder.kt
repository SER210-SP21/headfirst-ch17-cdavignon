package edu.quinnipiac.ser210.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.quinnipiac.ser210.guessinggame.R

class TaskItemViewHolder(val rootView: TextView) : RecyclerView.ViewHolder(rootView) {

    companion object {
        fun inflateFrom(parent: ViewGroup) : TaskItemViewHolder{
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.task_item, parent, false) as TextView
            return TaskItemViewHolder(view)
        }
    }

    fun bind(item: Task){
        rootView.text = item.taskName
    }
}