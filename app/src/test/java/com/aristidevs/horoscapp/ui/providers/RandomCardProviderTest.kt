package com.aristidevs.horoscapp.ui.providers

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class RandomCardProviderTest{
    @Test
    fun `getRandomCard should return a random card`(){
        //Given
        val randomCard = RandomCardProvider() //Aqui lo que hace es Dale a randomCard esta clase RandomCardProvider

        //When
        val card = randomCard.getLucky() // Cuando yo llame al getLucky()

        //Then
        assertNotNull(card)//Entonces asegurate que esto no sea nulo

    // NOTA: El assertNotNull es una condicion que dice que no sea nulo

    }
}