package entities

import entities.abstraction.Shape
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.geom.Rectangle2D

data class Rectangle(override var point: Point,
                     override var width: Double,
                     override var height: Double): Shape(point, width, height) {

    override fun draw(g: Graphics) {
        val g2d = g as Graphics2D
        val rec = Rectangle2D.Double(point.x, point.y, width, height)

        g2d.color = Color.BLACK
        g2d.draw(rec)
    }
}