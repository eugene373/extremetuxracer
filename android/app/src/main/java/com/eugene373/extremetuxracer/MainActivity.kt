package com.eugene373.extremetuxracer

import android.app.NativeActivity
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.view.Display
import android.view.View

class MainActivity : NativeActivity() {
    protected var width = 0
    protected var height = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        getNativeResolution()
        setImmersiveSticky()
        window.decorView.setOnSystemUiVisibilityChangeListener { setImmersiveSticky() }
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        setImmersiveSticky()
        super.onResume()
    }

    protected fun getNativeResolution() {
        val display: Display = windowManager.defaultDisplay
        val size = Point()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            display.getRealSize(size)
        } else {
            display.getSize(size)
        }
        width = size.x
        height = size.y
    }

    private fun setImmersiveSticky() {
        var flags = View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            flags = flags or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
        window.decorView.systemUiVisibility = flags
    }
}
