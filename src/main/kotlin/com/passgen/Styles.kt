package com.passgen

// import javafx fontweight for bolding
import javafx.scene.text.FontWeight
// import tornadofx stylesheet since that is actually what this is
import tornadofx.Stylesheet
// import stylesheet elements and necessities
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

/**
 * Creates Styles for Window Elements Used in PassView class
 */
class Styles : Stylesheet() {
    // makes an object alongside this class which stores the styles
    companion object {
        val heading by cssclass()
        val label by cssclass()
        val body by cssclass()
    }

    // initialize styles statically
    init {
        // heading style
        heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
            underline = false
        }

        // label style
        label {
            padding = box(10.px)
            fontSize = 26.5.px
            underline = true
        }

        // body style
        body {
            startMargin = 100.px
            padding = box(10.px)
            fontSize = 14.px
            underline = false
        }
    }
}