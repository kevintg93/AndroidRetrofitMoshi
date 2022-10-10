package co.zw.kevin.exchangerate.network

import com.squareup.moshi.Json

data class Currency(
    @Json(name="from")
    val from: String,
    @Json(name="to")
    val to:String,
    @Json(name="amount")
    val amount:String,


)

data class CurrencyRate(
    @Json(name="query")
    val response: Currency,
    @Json(name="result")
    val result: Double

)