package app.devPedroCarvalho.coroutineswithretrofit.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.devPedroCarvalho.coroutineswithretrofit.network.ApiService
import app.devPedroCarvalho.coroutineswithretrofit.network.response.CountryResponse
import kotlinx.coroutines.*

class MainActivityViewModel:ViewModel() {

    var job: Job? = null

    val loadingLiveData = MutableLiveData<Boolean>()
    var loadingErrorLiveData = MutableLiveData<String?>()
    val countriesListLiveData = MutableLiveData<List<CountryResponse>>()

    var serviceViewModel = ApiService.service


    private val exception = CoroutineExceptionHandler{ coroutineContext, throwable ->
        onError("Execption: ${throwable.localizedMessage}")
    }


     fun getCountries(){
        loadingLiveData.value = true

        job = CoroutineScope(Dispatchers.IO + exception).launch {
            val response = serviceViewModel.getCountries()
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    countriesListLiveData.value = response.body()
                    loadingLiveData.value = false
                    loadingErrorLiveData.value = ""

                }else{
                    loadingErrorLiveData.value = response.message()
                }
            }
        }

    }

    private fun onError(errorText: String){
        loadingErrorLiveData.value = errorText
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}