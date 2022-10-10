package co.zw.kevin.exchangerate.data

object DataManager {
    val currencies = HashMap<String,CurrencyData>()

    init{
        initializeCurrency()
    }

    private fun initializeCurrency(){
        var currencyInfo = CurrencyData("Afghanistan","Afghan Afghani","AFN")
        currencies[currencyInfo.currency] = currencyInfo

         currencyInfo = CurrencyData("Albania","Albanian Lek","ALL")
        currencies[currencyInfo.currency] = currencyInfo

        currencyInfo = CurrencyData("Algeria","Algerian Dinar","DZD")
        currencies[currencyInfo.currency] = currencyInfo

        currencyInfo = CurrencyData("American Samoa","US Dollar","USD")
        currencies[currencyInfo.currency] = currencyInfo

        currencyInfo = CurrencyData("Andorra","Euro","EUR")
        currencies[currencyInfo.currency] = currencyInfo

        currencyInfo = CurrencyData("Angola","Angolan Kwanza","AOA")
        currencies[currencyInfo.currency] = currencyInfo

        currencyInfo = CurrencyData("Anguilla","East Caribbean Dollar","XCD")
        currencies[currencyInfo.currency] = currencyInfo

        currencyInfo = CurrencyData("South Africa","Rand","ZAR")
        currencies[currencyInfo.currency] = currencyInfo

        currencyInfo = CurrencyData("Zimbabwe","Zimbabwe Dollar","ZWD")
        currencies[currencyInfo.currency] = currencyInfo



    }
}