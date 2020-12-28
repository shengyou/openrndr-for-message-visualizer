import org.openrndr.Fullscreen
import org.openrndr.UnfocusBehaviour
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.ffmpeg.VideoPlayerFFMPEG
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
        val videoPlayer = VideoPlayerFFMPEG.fromFile("data/video/streaming-by-gem.mp4")
        videoPlayer.play()

        extend {
            videoPlayer.draw(drawer)
        }
    }
}
