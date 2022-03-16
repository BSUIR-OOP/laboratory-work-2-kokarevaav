package entities

import entities.abstraction.Shape
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.geom.Ellipse2D

data class Ellipse(override var point: Point,
                   override var width: Double,
                   override var height: Double): Shape(point, width, height) {

    override fun draw(g: Graphics) {
        fun draw(g: Graphics) {
            val g2d: Graphics2D = g as Graphics2D
            val rectangle: Ellipse2D = Ellipse2D.Double(point.x, point.y, width, height)

            g2d.color = Color.BLACK
            g2d.fill(rectangle)
        }
    }
}