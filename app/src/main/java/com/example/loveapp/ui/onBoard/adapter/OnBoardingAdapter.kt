package com.example.loveapp.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import coil.load
import com.example.loveapp.databinding.ItemOnboardBinding
import com.example.loveapp.ui.onBoard.OnBoardModel

class OnBoardingAdapter(private val onClick: (OnBoardModel) -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoardModel(
            title = "Title 1",
            desc = "Description 1",
            image = "https://cdn0.iconfinder.com/data/icons/urban-tribes-people-rounded/110/Geek-512.png"

        ),
        OnBoardModel(
            title = "Title 2",
            desc = "Description 2",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-hvfPNnkZrEU2dLqNcez61LI5svOZhAJVGw&usqp=CAU"

        ),
        OnBoardModel(
            title = "Title 3",
            desc = "Description 3",
            image = "https://img.freepik.com/premium-vector/geek-logo-icon-vector-design-illustration_487414-1224.jpg?w=2000"

        ),
        OnBoardModel(
            title = "Title 2",
            desc = "Description 2",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-hvfPNnkZrEU2dLqNcez61LI5svOZhAJVGw&usqp=CAU"

        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoard: OnBoardModel) {
            binding.btnStart.setOnClickListener {
                onClick(onBoard)
            }
            with(binding) {
                tvTitle.text = onBoard.title
                tvDesc.text = onBoard.desc
                ivBoard.load(onBoard.image)
            }


        }
    }
}