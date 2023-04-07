package com.example.nutriscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}


/*
     val product = Product(
         name = "Petits pois",
         quantity = "450g (310g net egoutté)",
         country = listOf() ,
         barcode = "3083680085304",
         url = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
         ingredients = listOf(),
         allergenes = listOf(),
         additifs = listOf(),
         nutriscore = Nutriscore.A,


     )

     //Nom du produit
     findViewById<TextView>(R.id.product_name).text = product.name
     //Quantité contenu
     findViewById<TextView>(R.id.quantity).applyBoldText("Quantité", product.quantity)
     //Pays ou le produit est vendu
     findViewById<TextView>(R.id.country).applyBoldText(
         "Vendu en",
         product.country.joinToString { ", " })
     //Code bar
     findViewById<TextView>(R.id.barcode).applyBoldText("Code-barres", product.barcode)
     //Url de l'image du produit
     Glide.with(this).load(product.url)
         .placeholder(R.drawable.placeholder)
         .into(findViewById(R.id.product_image))
     //Nutriscore
     findViewById<ImageView>(R.id.nutriscore).setImageResource(resources.getIdentifier(
         "nutriscore_${product.nutriscore.letter.lowercase()}",
         "drawable",
         packageName,
     ))
     //Ingrédients
     findViewById<TextView>(R.id.ingredients).applyBoldText(
         "Ingrédients",
         product.ingredients.joinToString { ", " })
     //Allergènes
     findViewById<TextView>(R.id.allergenes).applyBoldText(
         "Allergènes",
         product.allergenes.joinToString { ", " })
     //Additifs
     findViewById<TextView>(R.id.additifs).applyBoldText(
         "Additifs",
         product.additifs.joinToString { ", " })



 }
}

data class Product(
 val name : String,
 val quantity: String,
 val country: List<String>,
 val barcode: String,
 val url: String,
 val ingredients: List<String>,
 val allergenes : List<String>,
 val additifs : List<String>,
 val nutriscore: Nutriscore
)

enum class Nutriscore(val letter: String) {
 A("A"), B("B"), C("C"), D("D"), E("E")
}

fun TextView.applyBoldText(prefix: String, value: String) {
 val text = "$prefix : $value"
 val builder = SpannableStringBuilder(text)
 builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(":") + 1, 0)
 setText(builder)
} */

