package com.example.weatherapp.presentation.currentWeather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.entities.CurrentWeatherDTO
import com.example.weatherapp.domain.entities.ForecastDTO
import com.example.weatherapp.domain.enums.DayOrNightEnum
import com.example.weatherapp.domain.useCases.currentWeather.GetCurrentWeatherUseCase
import com.example.weatherapp.domain.useCases.forecast.GetForecastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getForecastUseCase: GetForecastUseCase
) :
    ViewModel() {

    private val _currentWeather: MutableStateFlow<CurrentWeatherDTO> = MutableStateFlow(
        CurrentWeatherDTO()
    )
    val currentWeather: StateFlow<CurrentWeatherDTO> = _currentWeather

    private val _isDayOrNight: MutableStateFlow<DayOrNightEnum?> = MutableStateFlow(null)
    val isDayOrNight: StateFlow<DayOrNightEnum?> = _isDayOrNight

    private val _forecast: MutableStateFlow<ForecastDTO?> = MutableStateFlow(null)
    val forecast: StateFlow<ForecastDTO?> = _forecast

    fun setCountry(country: String){
        getWeatherForCountry(country)
        getForecast(country, 7)
    }

    private fun getWeatherForCountry(country: String) {
        viewModelScope.launch {
            getCurrentWeatherUseCase.invoke(country).let {
                _currentWeather.value = it
                _isDayOrNight.value = it.isDayOrNight
            }
        }
    }

    private fun getForecast(country: String, days: Int) {
        viewModelScope.launch {
            getForecastUseCase.invoke(country, days).let {
                _forecast.value = it
            }
        }
    }
}