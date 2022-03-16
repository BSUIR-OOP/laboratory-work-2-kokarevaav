package entities.abstraction

import entities.Point
import java.awt.Graphics

abstract class Shape(open var point: Point, open var width: Double, open var height: Double) {
    abstract fun draw(g: Graphics)
}
