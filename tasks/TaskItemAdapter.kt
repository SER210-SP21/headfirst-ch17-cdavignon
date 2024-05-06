package edu.quinnipiac.ser210.tasks

import android.graphics.drawable.DrawableContainer
import android.os.Bundle
import android.view.AbsSavedState
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.ListAdapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import edu.quinnipiac.ser210.guessinggame.databinding.TaskItemBinding
import edu.quinnipiac.ser210.tasks.TaskItemAdapter.*

class TaskItemAdapter(val clickListener: (taskId: Long) -> Unit) : ListAdapter<Task, edu.quinnipiac.ser210.tasks.TaskItemAdapter.TaskItemViewHolder>(TaskDiffItemCallback()) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) : View? {
        val adapter = TaskItemAdapter { taskId ->
            Toast.makeText(context, "Clicked task $taskId", Toast.LENGTH_SHORT).show()
        }
        binding.tasksList.adapter = adapter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder:TaskItemViewHolder, position: Int){
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    private fun getItem(position: Int): Task {
        TODO()
    }

    class TaskItemViewHolder(val binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root) {


        companion object {
            fun inflateFrom(parent: ViewGroup) : TaskItemViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TaskItemBinding.inflate(layoutInflater, parent, false)
                return TaskItemViewHolder(binding)
            }
        }

        fun bind(item: Task, clickListener: (taskId: Long) -> Unit){
            binding.task = item
            binding.root.setOnClickListener{
                Toast.makeText(binding.root.context, "Clicked task ${item.taskId}", Toast.LENGTH_SHORT).show()
            }
        }
    }

}