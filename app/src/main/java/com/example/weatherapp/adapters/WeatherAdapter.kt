package com.example.weatherapp.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.data.WeatherModel
import com.example.weatherapp.databinding.ListItemBinding

class WeatherAdapter : ListAdapter<WeatherModel, WeatherAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ListItemBinding.bind(view)
        fun bind(item: WeatherModel) = with(binding) {
            tvDate.text = item.time
            tvCondition.text = item.condition
            tvTemp.text = item.currentTemp

        }
    }

}