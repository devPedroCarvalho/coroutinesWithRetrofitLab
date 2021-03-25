package app.devPedroCarvalho.coroutineswithretrofit.network

import app.devPedroCarvalho.coroutineswithretrofit.network.response.CountryResponse
import retrofit2.Response
import retrofit2.http.GET

interface CountriesApi {

    @GET("DevTides/countries/master/countriesV2.json")
    suspend fun getCountries(): Response<List<CountryResponse>>
}