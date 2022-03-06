package com.passgen

import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val label by cssclass()
        val body by cssclass()
    }

    init {
        heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
            underline = false
        }

        label {
            padding = box(10.px)
            fontSize = 26.5.px
            underline = true
        }

        body {
            startMargin = 100.px
            padding = box(10.px)
            fontSize = 14.px
            underline = false
        }
    }
}