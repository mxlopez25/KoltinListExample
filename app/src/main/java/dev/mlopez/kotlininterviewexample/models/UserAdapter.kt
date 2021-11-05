package dev.mlopez.kotlininterviewexample.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.mlopez.kotlininterviewexample.R

class UserAdapter(private val context: Context?, private val users: MutableList<User>?) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.user_list_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users?.get(position)
        holder.tvName?.text = user?.name
        holder.tvDate?.text = user?.date.toString()
        holder.tvPhone?.text = user?.phone
    }

    override fun getItemCount() = users!!.size

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val tvName = itemView?.findViewById<TextView>(R.id.tvName)
        val tvPhone = itemView?.findViewById<TextView>(R.id.tvPhone)
        val tvDate = itemView?.findViewById<TextView>(R.id.tvDate)
    }
}