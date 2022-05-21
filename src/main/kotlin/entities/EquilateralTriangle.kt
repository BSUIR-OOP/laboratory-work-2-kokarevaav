package entities

import entities.abstraction.SymmetricShape
import service.DrawService

data class EquilateralTriangle(override var point: Point,
                               var side: Double): SymmetricShape(point, side) {

    override fun draw() {
        val drawService = DrawService.getInstance()

        val point2 = Point(point.x + side, point.y)
        val point3 = Point(point.x + (side / 2), point.y + side)

        val firstLine = Line(point, point2)
        val secondLine = Line(point2, point3)
        val thirdLine = Line(point3, point)

        drawService.drawLine(firstLine)
        drawService.drawLine(secondLine)
        drawService.drawLine(thirdLine)
    }
}