package com.example.nugas

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat



class activity_menu : AppCompatActivity() {
    var quantity = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun increment(view: View?) { //perintah tombol tambah
        if (quantity == 100) {
            Toast.makeText(this, "pesanan maximal 100", Toast.LENGTH_SHORT).show()
            return
        }
        quantity = quantity + 1
        display(quantity)
    }

    fun decrement(view: View?) { //perintah tombol tambah
        if (quantity == 1) {
            Toast.makeText(this, "pesanan minimal 1", Toast.LENGTH_SHORT).show()
            return
        }
        quantity = quantity - 1
        display(quantity)
    }

    fun Submitorder(view: View?) {
        val nameEditText = findViewById<View>(R.id.edt_name) as EditText
        val name = nameEditText.text.toString()
        Log.v("MainActivity", "Nama:$name")
        val hakauChekBox =
            findViewById<View>(R.id.Hakau_checkbox) as CheckBox
        val hashakau =
            hakauChekBox.isChecked //mengidentifikasi check
        Log.v("MainActivity", "has hakau:$hashakau")
        val udangChekBox =
            findViewById<View>(R.id.Udang_checkbox) as CheckBox
        val hasudang = udangChekBox.isChecked //mengidentifikasi check
        Log.v("MainActivity", "has udang:$hasudang")
        val ayamCheckBox=
            findViewById<View>(R.id.ayam_checkbox) as CheckBox
        val hasayam= ayamCheckBox.isChecked
        Log.v("MainActivity", "has ayam:$hasayam")
        val kepitingCheckBox=
            findViewById<View>(R.id.kepiting_checkbox) as CheckBox
        val haskepiting=kepitingCheckBox.isChecked
        Log.v("MainActivity", "has kepiting:$haskepiting")
        val price =
            calculateprice(hashakau, hasudang,hasayam,haskepiting) //memanggil method jumlah harga
        val pricemessage =
            createOrderSummary(price, name, hashakau, hasudang,hasayam,haskepiting)
        displayMessage(pricemessage)
    }

    private fun calculateprice(
        addhakau: Boolean,
        addudang: Boolean,
        addayam: Boolean,
        addkepiting: Boolean

    ): Int { //jumlah pesanan * harga
        var harga = 5000
        if (addhakau) {
            harga = harga //harga
        }
        if (addudang) {
            harga = harga
        }
        if (addayam) {
            harga = harga
        }
        if (addkepiting) {
            harga = harga
        }
        return quantity * harga
    }

    private fun createOrderSummary(
        price: Int,
        name: String,
        addhakau: Boolean,
        addudang: Boolean,
        addayam: Boolean,
        addkepiting: Boolean
    ): String { //hasil pemesanan
        var pricemessage = " Nama =$name"
        pricemessage += "\n add hakau?$addhakau"
        pricemessage += "\n add udang?$addudang"
        pricemessage += "\n add ayam?$addayam"
        pricemessage += "\n add kepiting?$addkepiting"
        pricemessage += "\n quantity$quantity"
        pricemessage += "\n Total Rp$price"
        pricemessage += "\n Terima kasih,silahkan tunggu pesanan anda"
        return pricemessage
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private fun displayMessage(message: String) {
        val priceTextView =
            findViewById<View>(R.id.price_textview) as TextView
        priceTextView.text = message
    }

    private fun display(number: Int) {
        val quantityTextView =
            findViewById<View>(R.id.quantity_textview) as TextView
        quantityTextView.text = "" + number
    }

    private fun displayPrice(number: Int) {
        val priceTextView =
            findViewById<View>(R.id.price_textview) as TextView
        priceTextView.text = NumberFormat.getCurrencyInstance().format(number.toLong())
    }
}