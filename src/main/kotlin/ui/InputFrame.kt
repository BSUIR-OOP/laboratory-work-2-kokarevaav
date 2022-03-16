package ui

import controller.ShapeController
import entities.factory.ShapeFactory
import util.*

import java.awt.GridLayout
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.JPanel

class InputFrame: JFrame("Choose") {
    private val comboBoxContent = ShapeFactory.getInstance().getNames()

    private val xLabel = JLabel("X:")
    private val yLabel = JLabel("Y:")
    private val wLabel = JLabel("W:")
    private val hLabel = JLabel("H:")

    private val xInputField = getTextField()
    private val yInputField = getTextField()
    private val wInputField = getTextField()
    private val hInputField = getTextField()

    private val comboBox = getComboBox(comboBoxContent) { element ->
        changeInputFields(element.item as String)
    }
    private val submitButton = getButton("Paint") {
        processUserInput()
    }

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

    private fun processUserInput() {
        try {
            val userInputs = getUserInput()

            ShapeController.getInstance().paintShape(comboBox.selectedItem as String, userInputs)
            this.dispose()
        } catch (e: NumberFormatException) {
            JOptionPane.showMessageDialog(this, "Некорректно введены данные")
            clearInputs()
        }
    }

    private fun getUserInput(): List<Double> {
        return listOf(
            xInputField.text.toDouble(),
            yInputField.text.toDouble(),
            wInputField.text.toDouble(),
            hInputField.text.toDouble()
        )
    }

    private fun initComponents() {
        xPanel.add(xLabel)
        xPanel.add(xInputField)
        yPanel.add(yLabel)
        yPanel.add(yInputField)
        wPanel.add(wLabel)
        wPanel.add(wInputField)
        hPanel.add(hLabel)
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

    private fun clearInputs() {
        xInputField.text = ""
        yInputField.text = ""
        wInputField.text = ""
        hInputField.text = ""
    }

    private fun changeInputFields(currentShape: String) {
        when (ShapeController.getInstance().getPanelType(currentShape)) {
            PanelType.TWO_POINTS -> {
                changeToTwoPoints()
                return
            }
            PanelType.SYMMETRIC -> {
                changeToSymmetric()
                return
            }
            else -> changeToRegular()
        }
    }

    private fun changeToRegular() {
        xLabel.text = "X:"
        yLabel.text = "Y:"
        wLabel.text = "W:"
        hLabel.text = "H:"

        hInputField.isVisible = true
        hLabel.isVisible = true
    }

    private fun changeToSymmetric() {
        xLabel.text = "X:"
        yLabel.text = "Y:"
        wLabel.text = "S:"
        hLabel.text = "H:"

        hInputField.text = "0.0"

        hInputField.isVisible = false
        hLabel.isVisible = false
    }

    private fun changeToTwoPoints() {
        xLabel.text = "X1:"
        yLabel.text = "Y1:"
        wLabel.text = "X2:"
        hLabel.text = "Y2:"

        hInputField.isVisible = true
        hLabel.isVisible = true
    }

    enum class PanelType {
        REGULAR,
        SYMMETRIC,
        TWO_POINTS
    }
}
