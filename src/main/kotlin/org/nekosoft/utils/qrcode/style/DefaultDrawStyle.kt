package org.nekosoft.utils.qrcode.style

import io.github.g0dkar.qrcode.internals.QRCodeSquare
import io.github.g0dkar.qrcode.render.QRCodeGraphics
import org.nekosoft.utils.qrcode.QrCodeDrawStyle
import org.nekosoft.utils.qrcode.QrCodeOptions

/**
 * Just a placeholder class for the default render method in the original QRCode library.
 */
object DefaultDrawStyle : QrCodeDrawStyle {
    override fun validate(options: QrCodeOptions): Boolean = true
    override fun render(cellData: QRCodeSquare, canvas: QRCodeGraphics, rawData: Array<Array<QRCodeSquare?>>, options: QrCodeOptions) {}
}