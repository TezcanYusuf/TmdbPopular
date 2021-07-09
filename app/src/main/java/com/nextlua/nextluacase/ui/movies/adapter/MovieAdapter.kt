package com.nextlua.nextluacase.ui.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.nextlua.nextluacase.BR
import com.nextlua.nextluacase.R
import com.nextlua.nextluacase.models.Result

class MovieAdapter(val data: List<Result>) : RecyclerView.Adapter<WeatherViewHolder>() {
    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_movies, parent, false)
        return WeatherViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size
}

class WeatherViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Any) {
        binding.setVariable(BR.movie, data)
        binding.executePendingBindings()
    }
}