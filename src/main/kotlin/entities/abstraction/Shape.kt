package entities.abstraction

import entities.Point

abstract class Shape(open var point: Point,
                     open var width: Double,
                     open var height: Double) {

    abstract fun draw()
}
