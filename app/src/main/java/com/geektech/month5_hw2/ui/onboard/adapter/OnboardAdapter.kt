package com.geektech.month5_hw2.ui.onboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.geektech.month5_hw2.R
import com.geektech.month5_hw2.databinding.ItemOnboardBinding
import com.geektech.month5_hw2.model.OnBoard

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val list = arrayListOf(
        OnBoard(
            R.raw.animation_onboard1,
            "Вы одиноки?",
            "Может, вас кто-то ждет?"
        ),
        OnBoard(
            R.raw.animation_onboard2,
            "Наша цель!",
            "Сделать вас хоть немного счастливее"
        ),
        OnBoard(
            R.raw.animation_onboard3,
            "Хорошо проведите время",
            "Узнайте может быть кто то вам идеально подходит"
        ),
        OnBoard(
            R.raw.animation_onboard4,
            "Найдите свою пару",
            "Используйте наше приложение , мы посчитаем за вас"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardBinding) :
        ViewHolder(binding.root) {

        fun onBind(onBoard: OnBoard) {
            with(binding) {
                lottieAnimationView.setAnimation(onBoard.animation)
                tvTitle.text = onBoard.title
                tvDesc.text = onBoard.desc
                binding.btnStart.isVisible = adapterPosition == list.lastIndex
                binding.btnStart.setOnClickListener {
                    onClick()
                }
            }
        }

    }
}