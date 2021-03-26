package app.devPedroCarvalho.coroutineswithretrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private fun initRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    var service: CountriesApi = initRetrofit().create(CountriesApi::class.java)
}

