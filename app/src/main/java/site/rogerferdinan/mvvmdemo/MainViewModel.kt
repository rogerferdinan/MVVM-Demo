package site.rogerferdinan.mvvmdemo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import site.rogerferdinan.mvvmdemo.model.GetProduct
import site.rogerferdinan.mvvmdemo.repository.Repository

class MainViewModel(private val repository: Repository): ViewModel() {
    val myResponse: MutableLiveData<Response<GetProduct>> = MutableLiveData()
    fun getProduct(barcode: String) {
        viewModelScope.launch {
            val response = repository.getProduct(barcode)
            myResponse.value = response
        }
    }
}