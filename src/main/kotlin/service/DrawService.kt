package service

import entities.*
import entities.abstraction.Shape
import java.awt.Color
import java.awt.Graphics2D
import java.awt.geom.Ellipse2D
import java.awt.geom.Rectangle2D

class DrawService private constructor() {
    companion object {
        private val instance = DrawService()

        fun getInstance(): DrawService {
            return instance
        }
    }

    private lateinit var graphics: Graphics2D
    private val brushColor: Color = Color.BLACK

    fun setGraphics(graphics: Graphics2D) {
        this.graphics = graphics
        this.graphics.color = brushColor
    }

    fun drawEllipse(shape: Shape) {
        val ellipse = Ellipse2D.Double(shape.point.x, shape.point.y, shape.width, shape.height)
        graphics.draw(ellipse)
    }

    fun drawLine(line: Line) {
        val firstPoint = line.p1
        val secondPoint = line.p2
        graphics.drawLine(firstPoint.x.toInt(), firstPoint.y.toInt(),
            secondPoint.x.toInt(), secondPoint.y.toInt())
    }

    fun drawRectangle(shape: Shape) {
        val rectangle = Rectangle2D.Double(shape.point.x, shape.point.y, shape.width, shape.height)
        graphics.draw(rectangle)
    }

}