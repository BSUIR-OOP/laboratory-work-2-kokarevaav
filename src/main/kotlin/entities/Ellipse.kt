package entities

import entities.abstraction.Shape
import service.DrawService

data class Ellipse(override var point: Point,
                   override var width: Double,
                   override var height: Double): Shape(point, width, height) {

    override fun draw() {
        val drawService = DrawService.getInstance()

        drawService.drawEllipse(this)
    }
}