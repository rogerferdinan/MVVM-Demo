package site.rogerferdinan.mvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import site.rogerferdinan.mvvmdemo.repository.Repository
import kotlin.reflect.typeOf

private const val TAG = "Retrofit Activity"
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getProduct("020000000213")
        viewModel.myResponse.observe(this, { response ->
            if(response.isSuccessful) {
                Log.d(TAG, response.body()!!.message[0].barcode)
            }
        })
    }
}