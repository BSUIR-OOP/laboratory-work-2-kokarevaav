package ui

import entities.controller.ShapeController
import util.WINDOW_WIDTH
import util.WINDOW_HEIGHT
import util.getButton
import java.awt.BorderLayout
import java.awt.Color
import java.awt.ComponentOrientation
import java.awt.FlowLayout
import javax.swing.JFrame
import javax.swing.JPanel

class MainFrame(title: String, isResizable: Boolean): JFrame(title) {
    init {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT)
        this.setLocationRelativeTo(null)
        this.layout = BorderLayout()
        this.defaultCloseOperation = EXIT_ON_CLOSE
        this.componentOrientation = ComponentOrientation.LEFT_TO_RIGHT
        this.isResizable = isResizable

        addComponents()

        this.isVisible = true
    }

    private fun addComponents() {
        val buttonPanel = JPanel()
        val addShapeButton = getButton("Create Shape") {
            InputFrame()
        }
        val clearLastButton = getButton("Clear Last") {
            ShapeController.getInstance().clearLast()
        }
        val clearAllButton = getButton("Clear") {
            ShapeController.getInstance().clear()
        }

        val drawPanel = DrawPanel()

        buttonPanel.layout = FlowLayout(FlowLayout.LEFT)
        buttonPanel.background = Color.LIGHT_GRAY
        buttonPanel.add(addShapeButton)
        buttonPanel.add(clearLastButton)
        buttonPanel.add(clearAllButton)

        this.add(buttonPanel, BorderLayout.NORTH)
        this.add(drawPanel, BorderLayout.CENTER)
    }
}