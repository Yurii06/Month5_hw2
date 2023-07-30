package com.geektech.month5_hw2.ui.onboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.geektech.month5_hw2.databinding.ItemOnboardBinding
import com.geektech.month5_hw2.model.OnBoard

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val list = arrayListOf(
        OnBoard(
            "https://w7.pngwing.com/pngs/221/349/png-transparent-love-test-calculator-love-calculator-android-android-thumbnail.png",
            "Вы одиноки?",
            "Может, вас кто-то ждет?"
        ),
        OnBoard(
            "https://surveysparrow.com/wp-content/uploads/2021/10/employee-onboarding-survey-questions.png",
            "Наша цель!",
            "Сделать вас хоть немного счастливее"
        ),
        OnBoard(
            "https://w7.pngwing.com/pngs/103/373/png-transparent-love-test-calculator-love-calculator-love-tester-deluxe-love-tester-machine-android-love-game-heart-thumbnail.png",
            "Хорошо проведите время",
            "Узнайте может быть кто то вам идеально подходит"
        ),
        OnBoard(
            "https://w7.pngwing.com/pngs/349/138/png-transparent-love-calculator-computer-icons-valentine-s-day-valentine-s-day-love-purple-text-thumbnail.png",
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
                ivOnboard.load(onBoard.image)
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