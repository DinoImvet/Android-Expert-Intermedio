package com.aristidevs.horoscapp.data.core.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val tokenManager: TokenManager):Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        /*En esta variable tenemos enganchada la peticion que se esta realizando, luego de esto podemos modificar la peticion,
        por ejemplo agregar un header o un token y asi modificar la peticion
        */
        val request = chain.request()
            .newBuilder()
            .header("Authorization" , tokenManager.getToken())
            .build()

        return chain.proceed(request)
    }

}

class TokenManager @Inject constructor() {
    fun getToken():String = "I7g86R785DCFv8768897F87v"

}