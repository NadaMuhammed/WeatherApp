package com.example.weatherapp.presentation.currentWeather

import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity.TELEPHONY_SERVICE
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.weatherapp.databinding.FragmentCurrentWeatherBinding
import com.example.weatherapp.domain.enums.ConditionEnum
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.Locale


@AndroidEntryPoint
class CurrentWeatherFragment : Fragment() {
    private val viewModel: CurrentWeatherViewModel by viewModels()
    lateinit var binding: FragmentCurrentWeatherBinding

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
        setBackground()
    }

    private fun getCountry(): String {
        return Locale(
            "",
            (context?.getSystemService(TELEPHONY_SERVICE) as TelephonyManager).simCountryIso
        ).displayCountry
    }

    private fun setBackground() {
        lifecycleScope.launch {
            viewModel.condition.collect {
                when (it) {
                    ConditionEnum.Night -> binding.root.background =
                        ContextCompat.getDrawable(requireContext(), com.example.ui.R.drawable.night_bg)

                    ConditionEnum.Sunny -> binding.root.background =
                        ContextCompat.getDrawable(requireContext(), com.example.ui.R.drawable.sunny_bg)

                    else -> binding.root.background =
                        ContextCompat.getDrawable(requireContext(), com.example.ui.R.drawable.cloudy_bg)
                }
            }
        }
    }
}