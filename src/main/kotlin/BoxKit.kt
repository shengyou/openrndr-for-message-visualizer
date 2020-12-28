import boxes.SmallSizeBox
import data.Coordinate
import data.User
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
        title = "LayoutKit"
        unfocusBehaviour = UnfocusBehaviour.THROTTLE
        fullscreen = Fullscreen.DISABLED
        windowResizable = false
    }

    program {
        val user = User(
            id = 1,
            name = "Shengyou Fan",
            message = "a quick brown fox jumps over the lazy dog",
            profile = 1
        )
        val box = SmallSizeBox(user)

        extend {
            drawer.fill = ColorRGBa.BLACK

            // single box
            box.render(drawer, 20.0, 20.0)

            // box matrix
            for (i in 1..10) {
                box.render(drawer, 0.0, i*box.height)
            }
        }
    }
}
