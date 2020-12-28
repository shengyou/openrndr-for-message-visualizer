package utils

import boxes.SizeBox
import org.openrndr.draw.Drawer

class BoxRenderer {

    fun render(drawer: Drawer, seconds: Double, boxes: List<SizeBox>) {
        boxes.forEach { box ->
            box.coordinate.x -= box.speed
            box.render(drawer)
        }
    }
}
