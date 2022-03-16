package ui

import util.*

import java.awt.GridLayout
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel

class InputFrame: JFrame("Choose") {
    private val comboBoxContent = listOf("Sphere", "Ellipse")

    private val comboBox = getComboBox(comboBoxContent) { println("chosen ${it.item}") }
    private val xInputField = getTextField()
    private val yInputField = getTextField()
    private val hInputField = getTextField()
    private val wInputField = getTextField()
    private val submitButton = getButton("Paint") { println("button pressed") }

    private val contentPanel = JPanel()
    private val xPanel = JPanel()
    private val yPanel = JPanel()
    private val wPanel = JPanel()
    private val hPanel = JPanel()

    init {
        contentPanel.layout = GridLayout(0, 1)

        initComponents()

        fillContentPanel()

        this.add(contentPanel)

        this.setSize(INPUT_WIDTH, INPUT_HEIGHT)
        this.defaultCloseOperation = DISPOSE_ON_CLOSE
        this.setLocationRelativeTo(null)
        this.isResizable = false
        this.isVisible = true
    }

    private fun initComponents() {
        xPanel.add(JLabel("X:"))
        xPanel.add(xInputField)
        yPanel.add(JLabel("Y:"))
        yPanel.add(yInputField)
        wPanel.add(JLabel("W:"))
        wPanel.add(wInputField)
        hPanel.add(JLabel("H:"))
        hPanel.add(hInputField)
    }

    private fun fillContentPanel() {
        contentPanel.add(getWrapper(comboBox))
        contentPanel.add(xPanel)
        contentPanel.add(yPanel)
        contentPanel.add(wPanel)
        contentPanel.add(hPanel)
        contentPanel.add(getWrapper(submitButton))
    }
}