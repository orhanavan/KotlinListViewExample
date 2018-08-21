package com.kotlin.kentlist

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cityNames = ArrayList<String>()
        cityNames.add("Pisa")
        cityNames.add("Colosseum")
        cityNames.add("Eiffel")
        cityNames.add("London Bridge")

        val colosseum = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.colosseum)
        val eiffel = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.eiffel)
        val londonBridge = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.londonbridge)
        val pisa = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.pisa)

        val cityImages = ArrayList<Bitmap>()
        cityImages.add(pisa)
        cityImages.add(colosseum)
        cityImages.add(eiffel)
        cityImages.add(londonBridge)


        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cityNames)
        listView.adapter = arrayAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("name", cityNames[position])

        /*
           Image'lar büyük verilerdir. Aktivite geçişleri arasında bu büyük veriyi aktarmak sorunlara yol açabilir.
           Bu sebeple Image'ları statik yaparak her yerden erişmeye açık hale getirebiliriz.
           Tabi kotlinde statik yok. Bunun için companion object kullanırız. Global.kt dosyasını inceleyebilirsin.
        */

            val bitmap = cityImages[position] // -> seçilen index'teki resim
            val chosen = Global.Chosen // -> yeni Chosen objesi oluşturuldu
            chosen.chosenImage = bitmap

            startActivity(intent)
        }



    }
}
