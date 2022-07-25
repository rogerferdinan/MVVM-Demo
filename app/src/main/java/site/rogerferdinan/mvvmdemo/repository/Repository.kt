package site.rogerferdinan.mvvmdemo.repository

import android.util.Log
import retrofit2.Response
import site.rogerferdinan.mvvmdemo.api.RetrofitInstance
import site.rogerferdinan.mvvmdemo.model.GetProduct

class Repository {
    suspend fun getProduct(barcode: String): Response<GetProduct> {
        return RetrofitInstance.api.getProduct(barcode)
    }
}