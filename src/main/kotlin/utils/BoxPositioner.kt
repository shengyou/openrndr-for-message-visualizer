package utils

import boxes.SizeBox
import data.Coordinate
import kotlin.random.Random

class BoxPositioner {
    fun positionize(width: Int, height: Int, boxes: List<SizeBox>) {
        var x = 0.0 //width.toDouble()
        var y = 0.0
        var run = 1
        var itemIndex = 0

        boxes.forEachIndexed { index, box ->
            if (run == 1) {
                if (index != 0) {
                    x = boxes[index - 1].coordinate.x + Random.nextDouble(20.0, 200.0)
                }

                if (index != 0) {
                    y = boxes[index - 1].coordinate.y + boxes[index - 1].height
                }
            } else {
                x = boxes[index - (itemIndex + 1)].coordinate.x + boxes[index - (itemIndex + 1)].width
                y = boxes[index - (itemIndex + 1)].coordinate.y + boxes[index - (itemIndex + 1)].height
            }

            //println("$index: $x, $y")

            box.coordinate = Coordinate(x + width, y)

            if (y >= height) {
                itemIndex = index
                run++
            }
        }
    }
}