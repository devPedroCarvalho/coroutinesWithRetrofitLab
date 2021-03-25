package app.devPedroCarvalho.coroutineswithretrofit.network.response

import com.google.gson.annotations.SerializedName

data class CountryResponse(
    @SerializedName("name")
    val countryName:String?,

    @SerializedName("capital")
    val capital:String?,

    @SerializedName("flagPNG")
    val flag:String?
)
