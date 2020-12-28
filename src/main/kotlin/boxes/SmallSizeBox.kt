package boxes

import data.Coordinate
import data.User
import org.openrndr.draw.FontImageMap
import org.openrndr.draw.loadFont

class SmallSizeBox(user: User) : SizeBox(user) {
    override val speed: Double = 7.0

    override val imageWidth: Double = 40.0
    override val imageHeight: Double = 40.0
    override val imageMargin: Double = 5.0

    override val charWidth: Double = 10.0
    override val charHeight: Double = 15.0

    override val usernameFont: FontImageMap
        get() = loadFont("data/fonts/default.otf", 20.0)

    override val messageFont: FontImageMap
        get() = loadFont("data/fonts/default.otf", 25.0)
}