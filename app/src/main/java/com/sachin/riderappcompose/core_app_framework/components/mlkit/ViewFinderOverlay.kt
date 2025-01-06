package com.apnamart.apnarider.core_app_framework.components.mlkit

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class ViewFinderOverlay(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val boxPaint: Paint = Paint().apply {
        color = Color.parseColor("#3e9bc8")
        style = Paint.Style.STROKE
        strokeWidth = 8f
    }

    private val scrimPaint: Paint = Paint().apply {
        color = Color.parseColor("#aa000000")
    }

    private val eraserPaint: Paint = Paint().apply {
        strokeWidth = boxPaint.strokeWidth
        xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }

    private val boxCornerRadius: Float = 16f

    var erase = true

    var boxRect: RectF? = null

    fun setViewFinder(erase: Boolean) {
        val overlayWidth = width.toFloat()
        val overlayHeight = height.toFloat()
        val boxWidth = overlayWidth * 60 / 100
        val cx = overlayWidth / 2
        val cy = overlayHeight / 2
        boxRect = RectF(cx - boxWidth / 2, cy - boxWidth / 2, cx + boxWidth / 2, cy + boxWidth / 2)
        this.erase = erase
        invalidate()
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        boxRect?.let {
            // Draws the dark background scrim and leaves the box area clear.
            canvas.drawRect(0f, 0f, canvas.width.toFloat(), canvas.height.toFloat(), scrimPaint)
            // As the stroke is always centered, so erase twice with FILL and STROKE respectively to clear
            // all area that the box rect would occupy.
            if (erase) {
                eraserPaint.style = Paint.Style.FILL
                canvas.drawRoundRect(it, boxCornerRadius, boxCornerRadius, eraserPaint)
                eraserPaint.style = Paint.Style.STROKE
                canvas.drawRoundRect(it, boxCornerRadius, boxCornerRadius, eraserPaint)
            }
            // Draws the box.
//            canvas.drawRoundRect(it, boxCornerRadius, boxCornerRadius, boxPaint)
        }
    }

}