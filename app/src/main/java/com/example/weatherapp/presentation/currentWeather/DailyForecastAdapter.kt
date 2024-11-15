package com.example.weatherapp.presentation.currentWeather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.WeeklyForecastItemBinding
import com.example.weatherapp.domain.entities.DailyWeatherDTO
import com.example.weatherapp.domain.enums.ConditionEnum

class DailyForecastAdapter :
    ListAdapter<DailyWeatherDTO, DailyForecastAdapter.DailyForecastViewHolder>(DailyWeatherDiffUtil) {

    inner class DailyForecastViewHolder(private val binding: WeeklyForecastItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DailyWeatherDTO) {
            with(binding) {
                tvDayName.text = item.day
                setWeatherIcon(item)
                tvMinTemp.text = item.minTemp.toString()
                tvMaxTemp.text = item.maxTemp.toString()
            }
        }

        private fun setWeatherIcon(item: DailyWeatherDTO) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyForecastViewHolder {
        return DailyForecastViewHolder(
            WeeklyForecastItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DailyForecastViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    object DailyWeatherDiffUtil : DiffUtil.ItemCallback<DailyWeatherDTO>() {
        override fun areItemsTheSame(oldItem: DailyWeatherDTO, newItem: DailyWeatherDTO): Boolean {
            return oldItem.day == newItem.day
        }

        override fun areContentsTheSame(
            oldItem: DailyWeatherDTO,
            newItem: DailyWeatherDTO
        ): Boolean {
            return oldItem == newItem
        }
    }
}