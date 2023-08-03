package com.geektech.month5_hw2.ui.history.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geektech.month5_hw2.databinding.ItemHistoryBinding
import com.geektech.month5_hw2.model.LoveModel

class HistoryAdapter(
    var list: List<LoveModel>
): Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val listOfHistory = arrayListOf<LoveModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun addTasks(list: List<LoveModel>) {
        listOfHistory.addAll(list)
        listOfHistory.sortBy { it.firstName }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = listOfHistory.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.onBind(listOfHistory[position])
    }

    inner class HistoryViewHolder(private var binding: ItemHistoryBinding) :
        ViewHolder(binding.root) {
        fun onBind(loveModel: LoveModel) {
            with(binding) {
                tvFirstName.text = loveModel.firstName
                tvSecondName.text = loveModel.secondName
                tvPercentage.text = loveModel.percentage
            }
        }
    }
}