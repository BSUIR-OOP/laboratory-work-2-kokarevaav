package entities.factory

import entities.*
import entities.abstraction.Shape
import kotlin.collections.HashMap

class ShapeFactory private constructor() {
    private val shapes = HashMap<String, (List<Double>) -> Shape>()

    companion object {
        private val instance = ShapeFactory()

        fun getInstance(): ShapeFactory {
            return instance
        }
    }

    init {
        shapes["Circle"] = { arr ->
            Circle(Point(arr[0], arr[1]), arr[2])
        }
        shapes["Ellipse"] = { arr ->
            Ellipse(Point(arr[0], arr[1]), arr[2], arr[3])
        }
        shapes["Triangle"] = { arr ->
            EquilateralTriangle(Point(arr[0], arr[1]), arr[2])
        }
        shapes["Line"] = { arr ->
            Line(Point(arr[0], arr[1]), Point(arr[2], arr[3]))
        }
        shapes["Rectangle"] = { arr ->
            Rectangle(Point(arr[0], arr[1]), arr[2], arr[3])
        }
        shapes["Square"] = { arr ->
            Square(Point(arr[0], arr[1]), arr[2])
        }
    }

    fun getNames(): MutableSet<String> {
        return shapes.keys
    }

    fun getShape(title: String, args: List<Double>): Shape {
        val result = shapes[title]
        if (result != null) {
            return result.invoke(args)
        }
        throw IllegalArgumentException()
    }
}