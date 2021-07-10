package com.nextlua.nextluacase.ui.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.nextlua.nextluacase.BR
import com.nextlua.nextluacase.R
import com.nextlua.nextluacase.listener.IListener
import com.nextlua.nextluacase.models.Result

class MovieAdapter(
    val data: List<Result>,
    private val myClickListener: IListener) :
    RecyclerView.Adapter<CategoryHolder>() {

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_movies, parent, false)
        return CategoryHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CategoryHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
        holder.itemView.setOnClickListener { myClickListener.onClick(position = position) }

    }

    override fun getItemCount(): Int = data.size
}

class CategoryHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Any) {
        binding.setVariable(BR.movie, data)
        binding.executePendingBindings()
    }
}