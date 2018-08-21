package com.kotlin.kentlist

import android.graphics.Bitmap

class Global {

    // tüm aktivitelerden buraya ulaşılabilir
    companion object Chosen {
        var chosenImage : Bitmap? = null

        fun returnImage(): Bitmap {
            return chosenImage!!
        }
    }
}