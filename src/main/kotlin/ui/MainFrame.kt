package ui

import util.WINDOW_WIDTH
import util.WINDOW_HEIGHT
import java.awt.BorderLayout
import java.awt.ComponentOrientation
import javax.swing.JFrame

class MainFrame(title: String): JFrame(title) {
    init {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT)
        this.setLocationRelativeTo(null)
        this.layout = BorderLayout()
        this.defaultCloseOperation = EXIT_ON_CLOSE
        this.componentOrientation = ComponentOrientation.LEFT_TO_RIGHT
        this.isResizable = false

        this.isVisible = true
    }
}