import org.openrndr.Fullscreen
import org.openrndr.UnfocusBehaviour
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.math.IntVector2

fun main() = application {
    configure {
        width = 1024
        height = 768
        position = IntVector2(0, 0)
        title = "Drawer"
        unfocusBehaviour = UnfocusBehaviour.THROTTLE
        fullscreen = Fullscreen.DISABLED
        windowResizable = true
    }

    program {

        extend {
            drawer.clear(ColorRGBa.PINK)

            drawer.fill = ColorRGBa.WHITE
            drawer.circle(width / 2.0, height / 2.0, width / 4.0)
        }
    }
}
