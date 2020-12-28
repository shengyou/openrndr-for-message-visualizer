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
        title = "Starter"
        unfocusBehaviour = UnfocusBehaviour.THROTTLE
        fullscreen = Fullscreen.DISABLED
        windowResizable = true
    }

    program {

        extend {
            drawer.clear(ColorRGBa.PINK)
            drawer.fill = ColorRGBa.WHITE
            drawer.circle(mouse.position, 100.0)
        }
    }
}
