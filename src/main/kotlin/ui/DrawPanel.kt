package ui

import event.DrawManager
import event.Listener
import repository.ShapeRepo
import java.awt.Graphics
import javax.swing.JPanel

class DrawPanel: JPanel(), Listener {
    private val drawManager = DrawManager.getInstance()
    private val shapeRepo = ShapeRepo.getInstance()

    init {
        drawManager.subscribe(this)
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        shapeRepo.getShapes().forEach { shape ->
            shape.draw(g)
        }
    }

    override fun update() {
        paintComponent(this.graphics)
    }
}