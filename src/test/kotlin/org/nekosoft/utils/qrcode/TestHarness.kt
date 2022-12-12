package org.nekosoft.utils.qrcode

import org.nekosoft.utils.qrcode.style.DefaultDrawStyle
import org.nekosoft.utils.qrcode.style.RoundedDrawStyle
import org.nekosoft.utils.qrcode.style.postproc.*
import java.io.FileOutputStream

fun main() {
    FileOutputStream("qrcode.png").use {
        val result = QrCode("https://shlink.nekosoft.org")
            .render(QrCodeOptions(
                foreground = "#FFFFFFFF",
                background = "#00EEEEEE",
//                drawStyle = RoundedDrawStyle(25, true),
                drawStyle = DefaultDrawStyle,
                postProcessors = listOf(
                    LinearGradientPostProcessor(
                        "#00FF00",
                        "#0000FF",
                        gradientOnBackground = true,
                        direction = LinearGradientDirection.LEFT_RIGHT,
                    ),
                    RadialGradientPostProcessor(
                        "#FF0000",
                        "#0000FF",
                        gradientOnBackground = false,
                    ),
//                    IconPostProcessor(
//                        "/Users/fedmest/Downloads/QRCode_QA.png"
//                    ),
//                    FramePostProcessor(
//                        "MY QR CODE",
//                        insetColor = "#FFEEEEEE",
//                        frameColor = "BLACK",
//                    ),
                ),
            ))
        result.writeTo(it)
    }
}