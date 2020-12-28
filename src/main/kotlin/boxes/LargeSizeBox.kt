package boxes

import data.Coordinate
import data.User
import org.openrndr.draw.FontImageMap
import org.openrndr.draw.loadFont

class LargeSizeBox(user: User) : SizeBox(user) {
    override val speed: Double = 2.0

    override val imageWidth: Double = 120.0
    override val imageHeight: Double = 120.0
    override val imageMargin: Double = 7.0

    override val charWidth: Double = 32.0
    override val charHeight: Double = 48.0

    override val usernameFont: FontImageMap
        get() = loadFont("data/fonts/default.otf", 55.0)

    override val messageFont: FontImageMap
        get() = loadFont("data/fonts/default.otf", 75.0)
}
