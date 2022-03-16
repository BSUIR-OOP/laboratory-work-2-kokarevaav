package repository

import entities.abstraction.Shape


class ShapesRepo private constructor() {
    private val shapesToDraw = ArrayList<Shape>()

    companion object {
        private val instance = ShapesRepo()

        fun getInstance(): ShapesRepo {
            return instance
        }
    }

    fun addShape(shape: Shape) {
        shapesToDraw.add(shape)
    }

    fun getShapes(): ArrayList<Shape> {
        return shapesToDraw
    }
}