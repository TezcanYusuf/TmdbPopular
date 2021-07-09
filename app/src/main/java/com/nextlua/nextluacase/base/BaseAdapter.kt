package com.nextlua.nextluacase.base

import android.content.Context
import android.widget.BaseAdapter

abstract class BaseAdapter<T>(
    private val context: Context,
    private var dataSource: List<T>,
) : BaseAdapter() {

    var selectedPosition = -1
    fun setPosition(position: Int) {
        selectedPosition = position
        notifyDataSetChanged()
    }

    fun getPosition(): Int {
        return selectedPosition
    }

    override fun getItem(position: Int): T = dataSource[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getCount(): Int = dataSource.size
    fun getDataSource() = dataSource
}
