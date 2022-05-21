package entities

import entities.abstraction.SymmetricShape
import service.DrawService

data class Square(override var point: Point,
                  var side: Double): SymmetricShape(point, side) {

    override fun draw() {
        val drawService = DrawService.getInstance()

        drawService.drawRectangle(this)
    }
}
