package boxes

import data.Coordinate
import data.User
import org.openrndr.draw.FontImageMap
import org.openrndr.draw.loadFont

class MiddleSizeBox(user: User) : SizeBox(user) {
    override val speed: Double = 5.0

    override val imageWidth: Double = 80.0
    override val imageHeight: Double = 80.0
    override val imageMargin: Double = 6.0

    override val charWidth: Double = 22.0
    override val charHeight: Double = 33.0

    override val usernameFont: FontImageMap
        get() = loadFont("data/fonts/default.otf", 35.0)

    override val messageFont: FontImageMap
        get() = loadFont("data/fonts/default.otf", 50.0)
}
