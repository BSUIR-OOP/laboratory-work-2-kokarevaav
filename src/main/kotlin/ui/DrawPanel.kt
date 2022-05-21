package ui

import event.DrawManager
import event.Listener
import repository.ShapeRepo
import service.DrawService
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel

class DrawPanel: JPanel(), Listener {
    private val drawManager = DrawManager.getInstance()
    private val drawService = DrawService.getInstance()
    private val shapeRepo = ShapeRepo.getInstance()

    init {
        drawManager.subscribe(this)
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        drawService.setGraphics(g as Graphics2D)

        shapeRepo.getShapes().forEach { shape ->
            shape.draw()
        }
    }

    override fun update() {
        paintComponent(this.graphics)
    }
}