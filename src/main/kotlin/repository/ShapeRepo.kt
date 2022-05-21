package repository

import entities.abstraction.Shape
import event.DrawManager


class ShapeRepo private constructor() {
    private var shapesToDraw = ArrayList<Shape>()

    companion object {
        private val instance = ShapeRepo()

        fun getInstance(): ShapeRepo {
            return instance
        }
    }

    fun addShape(shape: Shape) {
        shapesToDraw.add(shape)
        notifyListeners()
    }

    fun clearLast() {
        shapesToDraw.removeAt(shapesToDraw.lastIndex)
        notifyListeners()
    }

    fun clear() {
        shapesToDraw = ArrayList()
        notifyListeners()
    }

    private fun notifyListeners() {
        DrawManager.getInstance().notifyListeners()
    }

    fun getShapes(): ArrayList<Shape> {
        return shapesToDraw
    }
}