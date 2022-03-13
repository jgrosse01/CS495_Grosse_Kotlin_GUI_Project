package com.passgen.view

// import the styles file included in this program
import com.passgen.Styles

// gui elements import
import tornadofx.*
// import method from my own code
import com.passgen.generate.generatePassword
// gui locations
import javafx.geometry.Pos
// passable boolean property for checkboxes
import javafx.beans.property.SimpleBooleanProperty

// clipboard tools
import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.StringSelection


/**
 * Class to extend JavaFX View. Overrides elements of the superclass to make the PasswordGenerator GUI window.
 */
class PassView : View("Password Generator v1.0") {

    // instance variable for password (default of alphanumeric with caps enabled
    private var password = generatePassword(pwLen = 8, num = true, sym = false, caps = true)

    // initialize password field
    private var passwordField = textfield()

    // initialize slider (since it is used by instance and not just locally in a method we must initialize here)
    private var pwLength = slider()

    // properties bound to the GUI checkboxes as instance variables
    private val capsProperty = SimpleBooleanProperty()
    private val numProperty = SimpleBooleanProperty()
    private val specialProperty = SimpleBooleanProperty()

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
                    passwordField = textfield() {
                        // vertically adjust the text-field itself
                        hboxConstraints {
                            marginTop = 7.5
                        }
                        // locks password field so it cannot be manually edited
                        this.isEditable = false
                        // sets text to default password
                        this.text = password
                    }
                }
            }

            // make a box where password length goes
            vbox {
                hbox {
                    // label for password length slider
                    label("PW Length? (8-24):    ") {
                        // style from Styles file
                        addClass(Styles.body)
                    }
                    // slider to select password length
                    pwLength = slider(8.0, 24.0, 1.0) {
                        // incrementation restrictions and label restrictions for slider
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

            // make check boxes for allowed character types
            vbox {
                // caps checkbox
                hbox {
                    checkbox("Include Capital Letters", capsProperty) {
                        // default is true
                        this.isSelected = true
                        // left indent of checkboxes
                        hboxConstraints {
                            marginLeft = 15.0
                        }
                    }
                }
                // numbers checkbox
                hbox {
                    checkbox("Include Numbers", numProperty) {
                        // default is true
                        this.isSelected = true
                        // left indent of checkboxes
                        hboxConstraints {
                            marginLeft = 15.0
                        }
                    }
                }
                // special characters checkbox
                hbox {
                    checkbox("Include Special Characters", specialProperty) {
                        // left indent of checkboxes
                        hboxConstraints {
                            marginLeft = 15.0
                        }
                    }
                }
            }

            // make a box for the generate password button and copy password button
            vbox {
                // container for buttons
                hbox {
                    vboxConstraints {
                        marginTop = 15.0
                    }
                    // generate password button
                    button("Generate Password") {
                        // left indent of checkboxes
                        hboxConstraints {
                            marginLeft = 48.0
                        }
                        // generate button action
                        action {
                            // set the password to a new password with the given specifications
                            password = generatePassword(
                                getPWLength(),
                                numProperty.value,
                                specialProperty.value,
                                capsProperty.value
                            )
                            // update the text field to the password value
                            passwordField.text = password
                        }
                    }
                    //copy password button
                    button("Copy Password") {
                        // copy button action
                        action {
                            //select a string equivalent to the password
                            val copyString = StringSelection(password)
                            //get the clipboard of the current operating system
                            val clipboard: Clipboard = Toolkit.getDefaultToolkit().systemClipboard
                            //set contents of the clipboard to the copyString value and set the owner to that object
                            //so that it may always be accessed by that object
                            clipboard.setContents(copyString, copyString)
                        }
                    }
                }
            }
        }
    }


    //Function to get password length from the slider in the window created.
    private fun getPWLength(): Int {
        return (this.pwLength.value.toInt())
    }
}
