import org.openrndr.Fullscreen
import org.openrndr.UnfocusBehaviour
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.math.IntVector2

fun main() = application {
    configure {
        width = 1024
        height = 768
        position = IntVector2(0, 0)
        title = "Text"
        unfocusBehaviour = UnfocusBehaviour.THROTTLE
        fullscreen = Fullscreen.DISABLED
        windowResizable = true
    }

    program {
        val font = loadFont("data/fonts/default.otf", 55.0)

        extend {
            drawer.clear(ColorRGBa.PINK)

            drawer.fontMap = font
            drawer.fill = ColorRGBa.WHITE
            drawer.text(
                "Hello, World",
                width / 2.0,
                height / 2.0
            )
        }
    }
}
