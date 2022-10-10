package co.zw.kevin.exchangerate.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

import retrofit2.http.Headers
import retrofit2.http.Query

object ApiClient {
    private val BASE_URL = "https://api.apilayer.com/exchangerates_data/"

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val retrofit: Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
    val apiService: ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}

interface ApiService{
    @Headers("apikey:F5wM8sDMmxHSMLJBhrPFg81iYcJGrN7j")
    @GET("convert")
    fun fetchCurrency(
        @Query("to")
        to: String,
        @Query("from")
        from: String,
        @Query("amount")
        amount:String,
    ):Call<CurrencyRate>

}