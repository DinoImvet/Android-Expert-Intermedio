package com.aristidevs.horoscapp.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LuckyModel (
    /*Las anotaciones @DrawableRes y @StringRes se utilizan para especificar que los valores a pesar de que son enteros, se asegure de que apunte a un Drawable o String respectivamente.
      Esto es para que el codigo sea solido y robusto y no crashee*/

    @DrawableRes val image : Int,
    @StringRes val text : Int
)