package org.nekosoft.utils.qrcode.style.postproc

import org.nekosoft.utils.qrcode.QrCodeOptions
import java.awt.*

class RadialGradientPostProcessor(
    val color1: String,
    val color2: String,
    gradientOnBackground: Boolean = false,
) : GradientPostProcessor(gradientOnBackground) {

    override fun getGradientPaint(width: Int, height: Int): Paint {
        return RadialGradientPaint(
            width / 2F, height / 2F, width / 2F,
            floatArrayOf(0F, 1F),
            arrayOf(
                Color(QrCodeOptions.parseColorString(color1), true),
                Color(QrCodeOptions.parseColorString(color2), true),
            )
        )
    }

}
