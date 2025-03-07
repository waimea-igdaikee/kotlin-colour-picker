/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*
import javax.swing.event.ChangeEvent
import javax.swing.event.ChangeListener


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ChangeListener {

    // Fields to hold the UI elements
    private lateinit var colourLabel: JLabel
    private lateinit var hexText: JTextField
    private lateinit var redLabel: JLabel
    private lateinit var redSpinner: JSpinner
    private lateinit var greenLabel: JLabel
    private lateinit var greenSpinner: JSpinner
    private lateinit var blueLabel: JLabel
    private lateinit var blueSpinner: JSpinner


    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(380, 250)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 30)
        val colourLabelFont = Font(Font.SANS_SERIF, Font.PLAIN, 40)

        colourLabel = JLabel("TEMPORARY")
        colourLabel.bounds = Rectangle(30,30,150,120)
        add(colourLabel)

        hexText = JTextField("#FFFFFF")
        hexText.bounds = Rectangle(30,170,150,50)
        hexText.font = defaultFont
        add(hexText)

        redLabel = JLabel("R")
        redLabel.bounds = Rectangle(200,30,40,50)
        redLabel.font = colourLabelFont
        add(redLabel)

        greenLabel = JLabel("G")
        greenLabel.bounds = Rectangle(200,100,40,50)
        greenLabel.font = colourLabelFont
        add(greenLabel)

        blueLabel = JLabel("B")
        blueLabel.bounds = Rectangle(200,170,40,50)
        blueLabel.font = colourLabelFont
        add(blueLabel)

        val redSpinnerSettings = SpinnerNumberModel(255, 0, 255, 1)
        redSpinner = JSpinner(redSpinnerSettings)
        redSpinner.bounds = Rectangle(240, 30, 100, 50)
        redSpinner.addChangeListener(this)
        add(redSpinner)

        val greenSpinnerSettings = SpinnerNumberModel(255, 0, 255, 1)
        greenSpinner = JSpinner(greenSpinnerSettings)
        greenSpinner.bounds = Rectangle(240, 100, 100, 50)
        greenSpinner.addChangeListener(this)
        add(greenSpinner)

        val blueSpinnerSettings = SpinnerNumberModel(255, 0, 255, 1)
        blueSpinner = JSpinner(blueSpinnerSettings)
        blueSpinner.bounds = Rectangle(240, 170, 100, 50)
        blueSpinner.addChangeListener(this)
        add(blueSpinner)


    }


    /**
     * Handle any UI events (e.g. button clicks)
     */

    override fun stateChanged(e: ChangeEvent?) {
        colourLabel.background = Colour(redSpinner.value, greenSpinner.value, blueSpinner.value)
    }

}

