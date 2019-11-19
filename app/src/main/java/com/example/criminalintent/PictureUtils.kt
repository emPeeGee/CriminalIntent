package com.example.criminalintent

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Point
import android.util.Log

private const val T = "aaa"

fun getScaledBitmap(path: String, destWidth: Int, destHeight: Int): Bitmap {
    var options = BitmapFactory.Options()
    options.inJustDecodeBounds = true
    BitmapFactory.decodeFile(path, options)

    val srcWidth = options.outWidth.toFloat()
    val srcHeigth = options.outHeight.toFloat()
    Log.d(T, "srcWidth = $srcWidth| scrHeight = $srcHeigth")
    Log.d(T, "destWidth = $destWidth| destHeight = $destHeight")


    var inSampleSize = 1

    if (srcHeigth > destHeight || srcWidth > destWidth) {
        val heightScale = srcHeigth / destHeight
        val widthScale = srcWidth / destWidth

        Log.d(T, "widthScale = $widthScale| heightScale = $heightScale")


        val sampleScale = if (heightScale > widthScale) {
            heightScale
        } else {
            widthScale
        }

        inSampleSize = Math.round(sampleScale)
        Log.d(T, "inSampleSize = $inSampleSize")
    }

    options = BitmapFactory.Options()
    options.inSampleSize = inSampleSize

    return BitmapFactory.decodeFile(path, options)
}

fun getScaledBitmap(path: String, activity: Activity): Bitmap {
    val size = Point()

    activity.windowManager.defaultDisplay.getSize(size)

    return getScaledBitmap(path, size.x, size.y)
}