import org.openrndr.Fullscreen
import org.openrndr.UnfocusBehaviour
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadImage
import org.openrndr.math.IntVector2

fun main() = application {
    configure {
        width = 1024
        height = 768
        position = IntVector2(0, 0)
        title = "Image"
        unfocusBehaviour = UnfocusBehaviour.THROTTLE
        fullscreen = Fullscreen.DISABLED
        windowResizable = true
    }

    program {
        val image = loadImage("data/images/1.jpg")

        extend {
            drawer.image(image, width / 2.0, height / 2.0)
        }
    }
}
