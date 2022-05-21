package entities

import entities.abstraction.Shape
import service.DrawService

data class Line(var p1: Point,
                var p2: Point): Shape(p1, p2.x, p2.y) {

    override fun draw() {
        val drawService = DrawService.getInstance()

        drawService.drawLine(this)
    }
}