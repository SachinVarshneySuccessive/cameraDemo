package com.capturesignature

import android.graphics.Bitmap

interface OnSignedCaptureListener {
    fun onSignatureCaptured(bitmap: Bitmap, fileUri: String)
}