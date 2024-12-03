package com.aristidevs.horoscapp.data.network.response

import com.aristidevs.horoscapp.motherobject.HoroscopeMotherObject
import com.aristidevs.horoscapp.motherobject.HoroscopeMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class PredictionResponseTest{

    //El nombre de los test tienen que ser muy descriptivos
    @Test
    fun `toDomain should return a correct PredictionModel`(){
        //Hay que dividir el test en tres partes

        //Given -> DAS la informacion necesaria para el test
        //Esto es un objeto de prueba en el cual el .copy lo que hace es reescribir el objeto y cambiar el valor de sign
        //val horoscopeResponse = anyResponse.copy(sign = "libra")
        val horoscopeResponse = anyResponse

        //When -> CUANDO se ejecuta o pase una accion o cuando algo ocurra
        val predictionModel = horoscopeResponse.toDomain()

        //Then -> ENTONCES se verifica que ha pasado algo
        predictionModel.sign shouldBe horoscopeResponse.sign
        predictionModel.horoscope shouldBe horoscopeResponse.horoscope

    }
}