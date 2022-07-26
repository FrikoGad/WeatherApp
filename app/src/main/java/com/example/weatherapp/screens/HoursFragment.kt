package com.example.weatherapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.adapters.WeatherAdapter
import com.example.weatherapp.data.WeatherModel
import com.example.weatherapp.databinding.FragmentHoursBinding

class HoursFragment : Fragment() {

    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun initRcView() = with(binding) {
        rvHours.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter()
        rvHours.adapter = adapter
        // test
        val list = listOf (
            WeatherModel(
                "", "12:00",
                "Sunny", "", "25град",
                "", "", ""),
            WeatherModel(
                "", "13:00",
                "Sunny", "", "26град",
                "", "", ""),
            WeatherModel(
                "", "14:00",
                "Sunny", "", "27град",
                "", "", ""),
            WeatherModel(
                "", "15:00",
                "Sunny", "", "23град",
                "", "", ""),
            WeatherModel(
                "", "16:00",
                "Sunny", "", "24град",
                "", "", ""),
            WeatherModel(
                "", "17:00",
                "Sunny", "", "22град",
                "", "", "")
        )
        adapter.submitList(list)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HoursFragment()
    }
}