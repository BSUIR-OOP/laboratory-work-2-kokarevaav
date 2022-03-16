package util

import java.awt.Component
import java.awt.event.ActionEvent
import java.awt.event.ItemEvent
import javax.swing.JButton
import javax.swing.JComboBox
import javax.swing.JPanel
import javax.swing.JTextField

fun getTextField(): JTextField {
    val tf = JTextField()
    tf.preferredSize = TEXT_FIELD_SIZE
    return tf
}

fun getButton(title: String, callback: (ActionEvent) -> Unit): JButton {
    val bt = JButton(title)
    bt.preferredSize = BUTTON_SIZE
    bt.addActionListener(callback)
    return bt
}

fun getComboBox(content: List<String>, callBack: (ItemEvent) -> Unit): JComboBox<String> {
    val cb = JComboBox<String>()
    cb.preferredSize = COMBO_BOX_SIZE
    cb.addItemListener(callBack)
    content.forEach { item ->
        cb.addItem(item)
    }
    return cb
}

fun getWrapper(component: Component): JPanel {
    val wrapper = JPanel()
    wrapper.add(component)
    return wrapper
}