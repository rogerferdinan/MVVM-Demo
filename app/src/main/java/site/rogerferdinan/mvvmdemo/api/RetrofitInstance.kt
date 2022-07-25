package site.rogerferdinan.mvvmdemo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import site.rogerferdinan.mvvmdemo.util.Constants.Companion.BASE_URL

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: TokoDbApi by lazy {
        retrofit.create(TokoDbApi::class.java)
    }
}