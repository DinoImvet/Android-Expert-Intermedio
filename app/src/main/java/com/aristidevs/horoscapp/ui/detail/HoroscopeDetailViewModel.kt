package com.aristidevs.horoscapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aristidevs.horoscapp.domain.model.HoroscopeModel
import com.aristidevs.horoscapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

///////////////////////////2.- LUEGO ALMACENAMOS LA CLASE DEL ESTADO EN UNA VARIABLE

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) :
    ViewModel() {

    private var _horoscopeState =
        MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)

    val horoscopeState: StateFlow<HoroscopeDetailState> = _horoscopeState

    lateinit var horoscope: HoroscopeModel

    fun getHoroscope(sign: HoroscopeModel) {
        horoscope = sign
        viewModelScope.launch {
            //Hilo principal
            _horoscopeState.value = HoroscopeDetailState.Loading

            val result = withContext(Dispatchers.IO) {//Hilo secundario
                getPredictionUseCase(sign.name) //Hilo Secundario
            }

            if (result!=null){
                _horoscopeState.value = HoroscopeDetailState.Success(result.horoscope, result.sign, horoscope)
            } else {
                _horoscopeState.value = HoroscopeDetailState.Error("Ha ocurrido un error")
            }

            //Hilo principal

        }
    }
}