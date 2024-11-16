package com.example.weatherapp.presentation.currentWeather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.HourlyForecastItemBinding
import com.example.weatherapp.domain.entities.HourlyWeatherDTO
import com.example.weatherapp.domain.enums.ConditionEnum

class HourlyForecastAdapter :
    ListAdapter<HourlyWeatherDTO, HourlyForecastAdapter.HourlyForecastViewHolder>(
        HourlyWeatherDiffUtil
    ) {

    inner class HourlyForecastViewHolder(val binding: HourlyForecastItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HourlyWeatherDTO) {
            with(binding) {
                tvHour.text = item.hour
                setWeatherIcon(item)
                tvWeather.text = item.temperature.toString()
            }
        }

        private fun setWeatherIcon(item: HourlyWeatherDTO) {
            when (item.condition) {
                ConditionEnum.Cloudy -> binding.icWeatherCondition.setImageResource(com.example.ui.R.drawable.ic_cloudy)
                ConditionEnum.ClearNight -> binding.icWeatherCondition.setImageResource(com.example.ui.R.drawable.ic_night)
                ConditionEnum.Rainy -> binding.icWeatherCondition.setImageResource(com.example.ui.R.drawable.ic_rainy)
                ConditionEnum.Snowy -> binding.icWeatherCondition.setImageResource(com.example.ui.R.drawable.ic_snow)
                ConditionEnum.Sunny -> binding.icWeatherCondition.setImageResource(com.example.ui.R.drawable.ic_sunny)
                else -> binding.icWeatherCondition.isVisible = false
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyForecastViewHolder {
        return HourlyForecastViewHolder(
            HourlyForecastItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HourlyForecastViewHolder, position: Int) {
        return holder.bind(currentList[position])
    }

    object HourlyWeatherDiffUtil : DiffUtil.ItemCallback<HourlyWeatherDTO>() {
        override fun areItemsTheSame(
            oldItem: HourlyWeatherDTO,
            newItem: HourlyWeatherDTO
        ): Boolean {
            return oldItem.hour == newItem.hour
        }

        override fun areContentsTheSame(
            oldItem: HourlyWeatherDTO,
            newItem: HourlyWeatherDTO
        ): Boolean {
            return oldItem == newItem
        }
    }
}