package com.passgen

import com.passgen.view.PassView
import javafx.scene.image.Image
import javafx.stage.Stage
import tornadofx.App


/**
 * A class made to hold the view pane for the password generator application.
 */
class PasswordGenerator: App(PassView::class, Styles::class) {
    override fun start(stage: Stage) {
        super.start(stage)
        stage.width = 350.0
        stage.height = 400.0
        stage.isResizable = false
        // ShowPassword by icons8 https://icons8.com/icon/24453/show-password
        stage.icons.add(Image("file:./src/main/resources/icon.png"))
    }
}