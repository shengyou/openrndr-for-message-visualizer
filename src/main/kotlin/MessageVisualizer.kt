import org.openrndr.Fullscreen
import org.openrndr.UnfocusBehaviour
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.Screenshots
import org.openrndr.ffmpeg.VideoPlayerFFMPEG
import org.openrndr.math.IntVector2
import utils.BoxGenerator
import utils.BoxPositioner
import utils.BoxRenderer
import utils.UserGenerator

fun main() = application {
    configure {
        width = 1440
        height = 900
        position = IntVector2(0, 0)
        title = "Message Visualizer"
        unfocusBehaviour = UnfocusBehaviour.THROTTLE
        fullscreen = Fullscreen.SET_DISPLAY_MODE
        windowResizable = false
    }

    program {

        extend(Screenshots())

        val videoPlayer = VideoPlayerFFMPEG.fromFile("data/video/background.mp4")
        val users = UserGenerator().generate(30)
        val boxes = BoxGenerator().generate(users)
        BoxPositioner().positionize(width, height, boxes)

        videoPlayer.play()

        extend {
            videoPlayer.draw(drawer)

            drawer.fill = ColorRGBa.BLACK

            val renderedBoxes = boxes.filter {
                it.coordinate.x > (it.width + 300) * -1
            }

            //println("Render Count: ${renderedBoxes.count()}")

            BoxRenderer().render(drawer, seconds, renderedBoxes)
        }
    }
}
