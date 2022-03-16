package entities

import entities.abstraction.SymmetricShape
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.geom.Rectangle2D

data class Square(override var point: Point,
                  var side: Double): SymmetricShape(point, side) {

    override fun draw(g: Graphics) {
        val g2d = g as Graphics2D
        val rec = Rectangle2D.Double(point.x, point.y, side, side)

        g2d.color = Color.BLACK
        g2d.fill(rec)
    }
}
