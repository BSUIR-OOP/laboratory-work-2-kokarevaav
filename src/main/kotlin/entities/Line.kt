package entities

import entities.abstraction.Shape
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D

data class Line(var p1: Point,
                var p2: Point): Shape(p1, p2.x, p2.y) {

    override fun draw(g: Graphics) {
        val g2d = g as Graphics2D

        g2d.color = Color.BLACK
        g2d.drawLine(p1.x.toInt(), p1.y.toInt(),
                    p2.x.toInt(), p2.y.toInt())
    }
}