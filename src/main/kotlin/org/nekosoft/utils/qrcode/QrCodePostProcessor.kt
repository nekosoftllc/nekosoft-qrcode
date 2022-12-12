package org.nekosoft.utils.qrcode

import io.github.g0dkar.qrcode.render.QRCodeGraphics

interface QrCodePostProcessor {

    /**
     * @return true if the given options are compatible with the design and configuration of the
     * current processor, false otherwise.
     */
    fun validate(options: QrCodeOptions): Boolean

    /**
     * @return null if the original graphics object is to be used, otherwise the new graphics object
     * to be used for the QRCode - note that when returning null, if you modify the original graphics
     * object, these changes will be applied to the same object in the previous call stacks, so there
     * is usual no need to return a new graphics object unless you are changing the actual canvas, as
     * in the FramePostProcessor.
     */
    fun process(qrcodeImage: QRCodeGraphics, options: QrCodeOptions): QRCodeGraphics?
}