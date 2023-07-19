package com.geektech.month5_hw2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.geektech.month5_hw2.databinding.FragmentCalculateBinding
import com.geektech.month5_hw2.databinding.FragmentResultBinding
import com.geektech.month5_hw2.model.LoveModel

class ResultFragment : Fragment() {
    lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initImages()
        initClickers()
        getResult()


    }

    private fun initImages() {
        Glide.with(binding.ivLoveResult)
            .load("https://is2-ssl.mzstatic.com/image/thumb/Purple128/v4/b8/88/27/b88827d7-936f-ffe3-9aae-291a16f46121/AppIcon-1x_U007emarketing-85-220-3.png/512x512bb.jpg")
            .into(binding.ivLoveResult)
    }

    @SuppressLint("SetTextI18n")
    private fun getResult() {
        if (arguments != null) {
            val result = arguments?.getSerializable(CalculateFragment.LOVE_MODEL) as LoveModel
            binding.tvFirstName.text = result.firsName
            binding.tvSecondName.text = result.secondName
            binding.tvPercentage.text = result.percentage + "%"
            binding.tvResult.text = result.result
        }
    }

    private fun initClickers() {
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigate(R.id.calculateFragment)
        }
    }

}