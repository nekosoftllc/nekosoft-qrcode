package org.nekosoft.utils.qrcode.style.postproc

import io.github.g0dkar.qrcode.render.QRCodeGraphics
import org.nekosoft.utils.qrcode.QrCodeOptions
import org.nekosoft.utils.qrcode.QrCodePostProcessor
import java.awt.AlphaComposite
import java.awt.Color
import java.awt.Paint
import java.awt.image.BufferedImage

abstract class GradientPostProcessor(
    val gradientOnBackground: Boolean = false,
) : QrCodePostProcessor {
    override fun validate(options: QrCodeOptions): Boolean =
        (options.backgroundColor.toLong() and 0xFF000000) == 0L && (options.foregroundColor.toLong() and 0xFF000000) == 0xFF000000

    protected abstract fun getGradientPaint(width: Int, height: Int): Paint

    override fun process(qrcodeImage: QRCodeGraphics, options: QrCodeOptions): QRCodeGraphics? {
        val width = qrcodeImage.width
        val height = qrcodeImage.height
        val gradient = getGradientPaint(width, height)
        val g = (qrcodeImage.nativeImage() as BufferedImage).createGraphics()
        g.paint = gradient
        if (gradientOnBackground) {
            val composite = AlphaComposite.getInstance(AlphaComposite.DST_OVER)
            g.composite = composite
            g.fillRect(0, 0, width, height)
        } else {
            val composite = AlphaComposite.getInstance(AlphaComposite.SRC_IN)
            g.composite = composite
            g.fillRect(0, 0, width, height)
            val composite1 = AlphaComposite.getInstance(AlphaComposite.DST_OVER)
            g.composite = composite1
            g.color = Color(options.backgroundColor, false)
            g.fillRect(0, 0, width, height)
        }
        g.dispose()
        return null
    }
}