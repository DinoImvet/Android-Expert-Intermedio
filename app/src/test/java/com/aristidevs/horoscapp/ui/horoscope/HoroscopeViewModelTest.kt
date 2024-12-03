package com.aristidevs.horoscapp.ui.horoscope

import com.aristidevs.horoscapp.data.providers.HoroscopeProvider
import com.aristidevs.horoscapp.motherobject.HoroscopeMotherObject.horoscopeInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HoroscopeViewModelTest {

    //El mockk es un objeto simulado que imita el comportamiento de una dependencia real
    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel

    @Before //Esto se utiliza cuando queremos ejecutar algo antes de cada test, esto se utiliza cuando tengamos logica compartida
    //Por ejemplo si queremos testear un ViewModel que se usara en todas partes podemos realizar lo siguiente:
    fun setUp() {
        //Vamos a hacer una configuracion de mockk antes de empezar los test
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when viewmodel is created then horoscopes are loaded`() {
        //NOTA: Con corrutinas es coEvery, sin corrutinas es every
        /*Given*/ every { horoscopeProvider.getHoroscope() } returns horoscopeInfoList
        //Este test lo que hace es cuando se cree este viewmodel se va tener automaticamente que recupere todos los horoscopos y mostrarlos
        viewModel = HoroscopeViewModel(horoscopeProvider)

        /*When*/ val horoscopes = viewModel.horoscope.value

        /*Then*/ assertTrue(horoscopes.isNotEmpty())

    }
}

