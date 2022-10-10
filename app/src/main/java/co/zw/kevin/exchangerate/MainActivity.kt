package co.zw.kevin.exchangerate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import co.zw.kevin.exchangerate.data.CurrencyData
import co.zw.kevin.exchangerate.data.DataManager
import co.zw.kevin.exchangerate.network.ApiClient
import co.zw.kevin.exchangerate.network.CurrencyRate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapterCurrency = ArrayAdapter<CurrencyData>(this,
            android.R.layout.simple_spinner_item,
            DataManager.currencies.values.toList())
        adapterCurrency.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinnerTo: Spinner = findViewById(R.id.to)
        val spinnerFrom: Spinner = findViewById(R.id.from)
        val amount: EditText = findViewById(R.id.amount)
        var exchangeRate: TextView = findViewById(R.id.result)
        spinnerTo.adapter = adapterCurrency
        spinnerFrom.adapter = adapterCurrency


        val button: Button = findViewById(R.id.button)
        button.setOnClickListener{

            var to: CurrencyData? = DataManager.currencies[spinnerTo.selectedItem.toString()]
            var from: CurrencyData? = DataManager.currencies[spinnerFrom.selectedItem.toString()]
            var amt: String = amount.text.toString()





            val client = ApiClient.apiService.fetchCurrency(to?.code.toString(),from?.code.toString(),amt)
            client.enqueue(object:Callback<CurrencyRate>{
                override fun onResponse(
                    call: Call<CurrencyRate>,
                    response: Response<CurrencyRate>
                ){
                    if(response.isSuccessful){
                        Log.d("success",""+response.body())
//                    val result = response.body()?.response
                        val rate = response.body()?.result
                        exchangeRate.text = String.format("%.2f",rate)

                    }
                }
                override fun onFailure(call: Call<CurrencyRate>, t:Throwable){
                    Log.e("failed",""+t.message)
                }
            })
        }





   }

}