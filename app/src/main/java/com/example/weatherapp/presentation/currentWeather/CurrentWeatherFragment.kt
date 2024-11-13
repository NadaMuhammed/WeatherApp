package com.example.weatherapp.presentation.currentWeather

import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity.TELEPHONY_SERVICE
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.ui.BackgroundUtils.fadeInBackgroundImage
import com.example.ui.R
import com.example.weatherapp.databinding.FragmentCurrentWeatherBinding
import com.example.weatherapp.domain.enums.ConditionEnum
import com.example.weatherapp.domain.enums.DayOrNightEnum
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.launch
import java.util.Locale


@AndroidEntryPoint
class CurrentWeatherFragment : Fragment() {
    private val viewModel: CurrentWeatherViewModel by viewModels()
    private lateinit var binding: FragmentCurrentWeatherBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getWeatherForCountry(getCountry())
        setUpUI()
    }

    private fun getCountry(): String {
        return Locale(
            "",
            (context?.getSystemService(TELEPHONY_SERVICE) as TelephonyManager).simCountryIso
        ).displayCountry
    }

    private fun setUpUI() {
        setBackground()
        setCurrentWeatherUi()
    }

    private fun setCurrentWeatherUi() {
        lifecycleScope.launch {
            viewModel.currentWeather.drop(1).collect {
                with(binding) {
                    setWeatherIcon(it.condition)
                    tvCityName.text = it.region
                    tvTemperature.text = getString(R.string.temperatureInCelsius, it.temperature.toString())
                    tvWeatherCondition.text = it.conditionText
                }
            }
        }
    }

    private fun setWeatherIcon(condition: ConditionEnum?) {
        with(binding.icCurrentWeather){
            when(condition){
                ConditionEnum.Rainy -> setImageResource(R.drawable.ic_rainy)
                ConditionEnum.Cloudy -> setImageResource(R.drawable.ic_cloudy)
                ConditionEnum.Sunny -> setImageResource(R.drawable.ic_sunny)
                ConditionEnum.ClearNight -> setImageResource(R.drawable.ic_night)
                ConditionEnum.Snowy -> setImageResource(R.drawable.ic_snow)
                else -> isVisible = false
            }
        }
    }

    private fun setBackground() {
        lifecycleScope.launch {
            viewModel.isDayOrNight.drop(1).collect {
                when (it) {
                    DayOrNightEnum.Night -> {
                        binding.root.fadeInBackgroundImage(R.drawable.night_bg)
                        binding.tvWeatherCondition.setTextColor(ContextCompat.getColor(requireContext(), R.color.light_grey))
                    }

                    else -> {
                        binding.root.fadeInBackgroundImage(R.drawable.sunny_bg)
                        binding.tvWeatherCondition.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_grey))
                    }
                }
            }
        }
    }
}