package ui

import util.INPUT_WIDTH
import java.awt.FlowLayout
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JComboBox
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField

class InputFrame: JFrame("Paint your shape") {
    private val comboBoxContent = listOf("Sphere", "Ellipse")

    // INPUT FIELDS
    private val comboBox = JComboBox<String>()
    private val xInputField = JTextField()
    private val yInputField = JTextField()
    private val hInputField = JTextField()
    private val wInputField = JTextField()
    private val submitButton = JButton("Paint")

    // PANELS
    private val xPanel = JPanel()
    private val yPanel = JPanel()
    private val wPanel = JPanel()
    private val hPanel = JPanel()

    init {
        this.layout = GridLayout(0, 1)

        // SETUP CONTENT
        comboBoxContent.forEach { string ->
            comboBox.addItem(string)
        }
        xPanel.add(JLabel("X: "))
        xPanel.add(xInputField)
        yPanel.add(JLabel("Y: "))
        yPanel.add(yInputField)
        wPanel.add(JLabel("W: "))
        wPanel.add(wInputField)
        hPanel.add(JLabel("H: "))
        hPanel.add(hInputField)

        // ADD CONTENT IN FRAME
        this.add(comboBox)
        this.add(xPanel)
        this.add(yPanel)
        this.add(wPanel)
        this.add(hPanel)
        this.add(submitButton)

        // FRAME SETUP STUFF
        this.setSize(130,300)
        this.defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
        this.setLocationRelativeTo(null)
        this.isResizable = false
        this.isVisible = true
    }
}