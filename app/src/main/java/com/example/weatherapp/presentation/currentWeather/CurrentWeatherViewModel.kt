package com.example.weatherapp.presentation.currentWeather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.entities.CurrentWeatherDTO
import com.example.weatherapp.domain.enums.ConditionEnum
import com.example.weatherapp.domain.useCases.currentWeather.GetCurrentWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(private val useCase: GetCurrentWeatherUseCase) :
    ViewModel() {

    private val _currentWeather: MutableStateFlow<CurrentWeatherDTO> = MutableStateFlow(
        CurrentWeatherDTO()
    )
    val currentWeather: StateFlow<CurrentWeatherDTO> = _currentWeather

    private val _condition: MutableStateFlow<ConditionEnum?> = MutableStateFlow(ConditionEnum.Night)
    val condition: StateFlow<ConditionEnum?> = _condition

    fun getWeatherForCountry(country: String) {
        viewModelScope.launch {
            useCase.invoke(country).let {
                _currentWeather.value = it
            }
            setCondition()
        }
    }

    private fun setCondition(){
        currentWeather.value.let {
            _condition.value = currentWeather.value.condition
        }
    }
}