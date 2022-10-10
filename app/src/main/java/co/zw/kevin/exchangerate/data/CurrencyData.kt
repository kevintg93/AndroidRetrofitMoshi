package co.zw.kevin.exchangerate.data

data class CurrencyData(val country: String, val currency:String, val code:String) {
    override fun  toString(): String{
        return currency
    }
}