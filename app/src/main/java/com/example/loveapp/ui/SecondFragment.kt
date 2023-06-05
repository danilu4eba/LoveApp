package com.example.loveapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.loveapp.data.remote.LoveModel
import com.example.loveapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result()
        tryAgain()


    }

    private fun tryAgain() {
        binding.btnTryAgain.setOnClickListener {
            val bundle = Bundle().apply {
                putBoolean("clearEditText", true)
            }
            findNavController().navigateUp()
        }
    }


    fun result() {
        with(binding) {
            val result = arguments?.getSerializable("result") as LoveModel
            tvResult.text = result.result
            tvPercent.text = result.percentage

        }
    }
}
