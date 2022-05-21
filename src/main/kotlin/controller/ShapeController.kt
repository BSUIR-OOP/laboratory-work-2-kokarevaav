package controller

import entities.Line
import entities.abstraction.SymmetricShape
import entities.factory.ShapeFactory
import repository.ShapeRepo
import ui.InputFrame

class ShapeController private constructor() {
    companion object {
        private val instance = ShapeController()

        fun getInstance(): ShapeController {
            return instance
        }
    }

    fun getPanelType(shapeName: String): InputFrame.PanelType {
        when (ShapeFactory.getInstance().getShape(shapeName, listOf(0.0, 0.0, 0.0, 0.0))) {
            is SymmetricShape -> return InputFrame.PanelType.SYMMETRIC
            is Line -> return InputFrame.PanelType.TWO_POINTS
        }
        return InputFrame.PanelType.REGULAR
    }

    fun paintShape(shapeName: String, args: List<Double>) {
        val shape = ShapeFactory.getInstance().getShape(shapeName, args)
        ShapeRepo.getInstance().addShape(shape)
    }

    fun clear() {
        ShapeRepo.getInstance().clear()
    }

    fun clearLast() {
        ShapeRepo.getInstance().clearLast()
    }
}