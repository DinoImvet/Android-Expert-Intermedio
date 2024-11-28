package com.aristidevs.horoscapp.ui.detail

import com.aristidevs.horoscapp.domain.model.HoroscopeModel

///////////////////////////1.- PRIMERO CREAMOS LOS ESTADOS
sealed class HoroscopeDetailState {
    //Es data object porque no tiene nada que guardar
    data object Loading : HoroscopeDetailState()

    //Son data classes porque tienen que guardar información
    data class Error (val error: String): HoroscopeDetailState()

    data class Success (val prediction: String, val sign: String, val horoscopeModel: HoroscopeModel): HoroscopeDetailState()


}