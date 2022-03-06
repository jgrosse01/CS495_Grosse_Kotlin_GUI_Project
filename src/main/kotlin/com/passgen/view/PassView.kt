package com.passgen.view

import com.passgen.Styles
import javafx.geometry.Pos
import tornadofx.*
import com.passgen.generate.generatePassword
import javafx.scene.control.Slider

class PassView : View("Password Generator v1.0") {

    //instance variable for password (default of alphanumeric with caps enabled
    private var password = generatePassword(pwLen=8, num=true, sym=false, caps=true)
    private var passwordField = textfield()
    private var pwLength = slider()

    // change the base window to be the window that I want
    override val root = vbox {
        // make a form because its nice and easy to format
        form {
            // make a box for the window heading (title but in the window)
            vbox(alignment = Pos.TOP_CENTER) {
                label(title) {
                    // style from Styles file
                    addClass(Styles.label)
                }
            }

            // make a box where the password output goes
            vbox(alignment = Pos.TOP_CENTER) {
                hbox {
                    // password label that will show password
                    label("Generated Password: ") {
                        // style from Styles file
                        addClass(Styles.body)
                    }
                    // place the password can actually go
                    passwordField = textfield {
                        // vertically adjust the text-field itself
                        hboxConstraints {
                            marginTop = 7.5
                        }
                        this.isEditable = false
                        this.text = password
                    }
                }
            }

            // make a box where password length goes
            vbox {
                hbox {
                    label("PW Length? (8-24):    ") {
                        // style from Styles file
                        addClass(Styles.body)
                    }
                    // slider to select password length
                    pwLength = slider(8.0,24.0,1.0) {
                        // incrementation restrictions
                        this.blockIncrement = 1.0
                        this.majorTickUnit = 1.0

                        // show labels and snap to those and the numbers right in between (still major numbers)
                        this.isShowTickLabels = true
                        this.isSnapToTicks = true

                        // makes it so there are no sub-values between whole numbers of ticks
                        this.minorTickCount = 0

                        // match width to box above
                        this.prefWidth = 155.0
                    }
                }
            }

            // make horizontal check boxes for allowed character types
            vbox {

            }

            // make a box for the generate password button and copy password button
            vbox {

            }

        }
    }


    /**
     * Function to get password length from the slider in the window created.
     */
    fun getPWLength(): Int {
        return(this.pwLength.value.toInt())
    }
}
