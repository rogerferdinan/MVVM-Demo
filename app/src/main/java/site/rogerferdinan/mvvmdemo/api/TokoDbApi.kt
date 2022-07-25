package site.rogerferdinan.mvvmdemo.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import site.rogerferdinan.mvvmdemo.model.GetProduct

interface TokoDbApi {
    @GET("api/product/{barcode}")
    suspend fun getProduct(@Path("barcode") barcode: String): Response<GetProduct>
}