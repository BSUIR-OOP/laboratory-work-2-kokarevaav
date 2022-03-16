package entities

import entities.abstraction.SymmetricShape
import java.awt.Graphics

data class EquilateralTriangle(override var point: Point,
                               var side: Double): SymmetricShape(point, side) {

    override fun draw(g: Graphics) {
        val point2 = Point(point.x + side, point.y)
        val point3 = Point(point.x + (side / 2), point.y + side)

        Line(point, point2).draw(g)
        Line(point2, point3).draw(g)
        Line(point3, point).draw(g)
    }
}