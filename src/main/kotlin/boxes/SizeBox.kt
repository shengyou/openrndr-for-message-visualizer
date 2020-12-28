package boxes

import data.Coordinate
import data.User
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.shape.Circle

abstract class SizeBox(private val user: User) {
    var coordinate: Coordinate = Coordinate(0.0, 0.0)

    open val speed: Double = 1.0

    open val imageWidth: Double = 40.0
    open val imageHeight: Double = 40.0
    open val imageMargin: Double = 5.0

    open val charWidth: Double = 10.0
    open val charHeight: Double = 15.0

    val width: Double
        get() = imageWidth + imageMargin + charWidth * user.message.count()

    val height: Double
        get() = imageHeight + imageMargin

    open val usernameFont: FontImageMap
        get() = loadFont("data/fonts/default.otf", 20.0)

    open val messageFont: FontImageMap
        get() = loadFont("data/fonts/default.otf", 25.0)

    private val profileUrl: String
        get() = "${user.profile}.jpg"

    private val profileImage: ColorBuffer
        get() = loadImage("data/images/${profileUrl}")

    private val color: ColorRGBa
        get() = listOf(ColorRGBa.GREEN, ColorRGBa.PINK, ColorRGBa.RED).random()

    fun render(drawer: Drawer, x: Double = coordinate.x, y: Double = coordinate.y) {
        profileImage.filter(MinifyingFilter.LINEAR_MIPMAP_NEAREST, MagnifyingFilter.LINEAR)
        drawer.shadeStyle = shadeStyle {
            fragmentTransform = """
                        vec2 texCoord = c_boundsPosition.xy;
                        texCoord.y = 1.0 - texCoord.y;
                        vec2 size = textureSize(p_image, 0);
                        texCoord.x /= size.x/size.y;
                        x_fill = texture(p_image, texCoord);
                    """
            parameter("image", profileImage)
        }
        val shape = Circle(x + (imageWidth / 2), y + (imageHeight / 2), imageWidth / 2).shape
        drawer.shape(shape)

        drawer.shadeStyle = null
        drawer.fontMap = usernameFont
        drawer.fill = ColorRGBa.WHITE
        drawer.text(
            text = user.name,
            x = x + imageWidth + imageMargin,
            y = y + charHeight
        )

        drawer.fontMap = messageFont
        drawer.fill = ColorRGBa.WHITE
        drawer.text(
            text = user.message,
            x = x + imageWidth + imageMargin,
            y = y + (imageHeight / 2) + charHeight,
        )
    }
}
