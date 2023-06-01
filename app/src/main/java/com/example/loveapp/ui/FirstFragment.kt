package com.example.loveapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.loveapp.LoveViewModel
import com.example.loveapp.R
import com.example.loveapp.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val ViewModel: LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {

        with(binding) {
            btnCalc.setOnClickListener {
                ViewModel.getLiveLove(
                    etFirst.text.toString(),
                    etSecond.text.toString()
                ).observe(viewLifecycleOwner) {
                    Log.e("koko", "initClickers: $it")

                    findNavController().navigate(R.id.secondFragment, bundleOf("result" to it))
                }
//            Repository().getLoveMutableData( etFirst.text.toString(),
//                etSecond.text.toString())
//            btnCalc.setOnClickListener {
//                RetrofitService().api.getPercentage(
//                   etFirst.text.toString(),
//                     etSecond.text.toString(),
//                )
//                    .enqueue(object : Callback<LoveModel> {
//
//                        override fun onResponse(
//                            call: Call<LoveModel>,
//                            response: Response<LoveModel>
//                        ) {
//
//                            if (response.isSuccessful) {
//                                Log.e("koko", "onResponse: ${response.body()}")
//                                findNavController().navigate(
//                                    R.id.secondFragment,
//                                    bundleOf("result" to response.body())
//                                )
//
//
//                            }
//                        }
//
//                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
//                            Log.e("koko", "onFailure: ${t.message}")
//                        }
//
//
//                    })
            }
        }
    }


}


