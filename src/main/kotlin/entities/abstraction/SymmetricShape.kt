package entities.abstraction

import entities.Point

abstract class SymmetricShape(override var point: Point,
                              side: Double): Shape(point, side, side)