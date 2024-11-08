package com.example.weatherapp.features.currentWeather.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.features.currentWeather.domain.entities.CurrentWeatherDTO
import com.example.weatherapp.features.currentWeather.domain.enums.DayOrNightEnum
import com.example.weatherapp.features.currentWeather.domain.useCases.GetCurrentWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(private val useCase: GetCurrentWeatherUseCase) :
    ViewModel() {

    private val _country: MutableStateFlow<String> = MutableStateFlow("Egypt")
    val country: StateFlow<String> = _country

    private val _currentWeather: MutableStateFlow<CurrentWeatherDTO> = MutableStateFlow(CurrentWeatherDTO(isDayOrNight = DayOrNightEnum.Day))
    val currentWeather: StateFlow<CurrentWeatherDTO> = _currentWeather

    fun setCountry(country: String) {
        _country.value = country
        getCurrentWeather()
    }

    private fun getCurrentWeather() {
        viewModelScope.launch {
            useCase.invoke(country.value).let {
                _currentWeather.value = it
            }
        }
    }
}