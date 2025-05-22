package com.zomato.sushi.compose.sample

import android.app.Application
import com.zomato.sushi.compose.sample.utils.Logger

class SushiApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Logger.init(true)
    }
}