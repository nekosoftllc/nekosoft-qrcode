package org.nekosoft.utils.qrcode.style.postproc

import org.nekosoft.utils.qrcode.QrCodeOptions
import java.awt.Color
import java.awt.GradientPaint
import java.awt.Paint

class LinearGradientPostProcessor(
    val color1: String,
    val color2: String,
    gradientOnBackground: Boolean = false,
    val direction: LinearGradientDirection = LinearGradientDirection.DIAGONAL_DOWN,
) : GradientPostProcessor(gradientOnBackground) {

    override fun getGradientPaint(width: Int, height: Int): Paint {
        val (x1, y1, x2, y2) = when (direction) {
            LinearGradientDirection.DIAGONAL_DOWN -> listOf(0f, 0f, width.toFloat(), height.toFloat())
            LinearGradientDirection.DIAGONAL_UP -> listOf(0f, height.toFloat(), width.toFloat(), 0f)
            LinearGradientDirection.TOP_BOTTOM -> listOf(0f, 0f, 0f, height.toFloat())
            LinearGradientDirection.LEFT_RIGHT -> listOf(0f, 0f, width.toFloat(), 0f)
        }
        return GradientPaint(
            x1, y1, Color(QrCodeOptions.parseColorString(color1), true),
            x2, y2, Color(QrCodeOptions.parseColorString(color2), true)
        )
    }

}

enum class LinearGradientDirection {
    DIAGONAL_DOWN, DIAGONAL_UP, TOP_BOTTOM, LEFT_RIGHT
}
