package com.example.weatherapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.data.retrofit.response.WeatherDaysResponse
import com.example.weatherapp.utils.MAIN
import kotlinx.android.synthetic.main.list_item.view.*

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.ItemViewHolder>() {

    var listWeatherItem = emptyList<WeatherDaysResponse>()

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.item_date.text = listWeatherItem[position].forecast.forecastday[position].hour[position].time
        holder.itemView.item_temp.text = listWeatherItem[position].forecast.forecastday[position].hour[position].temp_c.toString()
        holder.itemView.item_condition.text = listWeatherItem[position].forecast.forecastday[position].hour[position].condition.text

        Glide.with(MAIN)
            .load(listWeatherItem[position].forecast.forecastday[position].hour[position].condition.icon)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.itemView.item_iv_condition)
    }

    override fun getItemCount(): Int {
        return listWeatherItem.size
    }

}