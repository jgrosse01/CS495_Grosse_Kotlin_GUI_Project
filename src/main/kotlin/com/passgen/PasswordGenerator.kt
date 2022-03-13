package com.passgen

// import JavaFX and TornadoFX stage modules
import com.passgen.view.PassView
import javafx.scene.image.Image
import javafx.stage.Stage
import tornadofx.App


/**
 * A class made to hold the view pane for the password generator application.
 */
class PasswordGenerator: App(PassView::class, Styles::class) {
    // override the JavaFX Application start method
    override fun start(stage: Stage) {
        // make JavaFX Application
        super.start(stage)
        // set width and height
        stage.width = 350.0
        stage.height = 300.0
        // disable resizing so it always looks nice
        stage.isResizable = false
        // set window icon and taskbar icon at the same time!
        // ShowPassword by icons8 https://icons8.com/icon/24453/show-password
        stage.icons.add(Image("file:./src/main/resources/icon.png"))
    }
}