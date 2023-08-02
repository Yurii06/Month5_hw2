package com.geektech.month5_hw2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.geektech.month5_hw2.App
import com.geektech.month5_hw2.LoveViewModel
import com.geektech.month5_hw2.R
import com.geektech.month5_hw2.data.Pref
import com.geektech.month5_hw2.databinding.FragmentCalculateBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoveCalculatorFragment : Fragment() {

    private var _binding: FragmentCalculateBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!pref.isOnBoardSeen()) {
            findNavController().navigate(R.id.onBoardFragment)
        }

        initImage()
        initClickers()

    }

    private fun initImage() {
        Glide.with(binding.ivLove)
            .load("https://play-lh.googleusercontent.com/NHyKKNlIbkI4f1nFKFChZLqDWfDwn4joKhqB8tDfNlg01RWwlvo_JEytcRrayXUAq-k")
            .into(binding.ivLove)
    }

    private fun initClickers() {
        binding.btnHistory.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
        binding.btnCalculate.setOnClickListener {
            if (binding.etFirstName.text.isNotEmpty() && binding.etSecondName.text.isNotEmpty()) {
                viewModel.getLiveData(
                    binding.etFirstName.text.toString(),
                    binding.etSecondName.text.toString()
                )
                    .observe(requireActivity()) {
                        if (it.error != null) {
                            Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            findNavController().navigate(
                                R.id.resultFragment,
                                bundleOf(LOVEMODEL_KEY to it)
                            )
                        }
                    }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val LOVEMODEL_KEY = "LoveModel.key"
    }
}