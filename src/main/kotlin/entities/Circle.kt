package entities

import entities.abstraction.SymmetricShape
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.geom.Ellipse2D

data class Circle(override var point: Point,
                  var side: Double): SymmetricShape(point, side) {

    override fun draw(g: Graphics) {
        val g2d = g as Graphics2D
        val circle = Ellipse2D.Double(point.x, point.y, side, side)

        g2d.color = Color.BLACK
        g2d.draw(circle)
    }
}