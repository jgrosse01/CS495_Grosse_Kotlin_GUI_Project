package com.passgen.generate

import kotlin.random.Random

// char lists to pull chars from
private val alphaSet = ('a'..'z').toList() // need to cast here to get list instead of CharRange object
private val alphaNumSet = ('a'..'z') + ('0'..'9')
private val alphaNumSymSet = ('a'..'z') + ('0'..'9') + ('!'..'-')

/**
 * A function that generates a password.
 *
 * @param pwLen The length of the password that is desired.
 * @param num Whether to include numbers in the password.
 * @param sym Whether to include symbols in the password.
 * @param caps Whether to include capital letters in the password.
 */
fun generatePassword(pwLen: Int, num: Boolean, sym: Boolean, caps: Boolean): String {
    // if specified to use numbers
    if (num) {
        // and use symbols
        if (sym) {
            // return password with alpha, num, and symbols
            return(generatePassword(pwLen, alphaNumSymSet, caps))
        }
        // otherwise, just with alpha and num
        return(generatePassword(pwLen, alphaNumSet, caps))
    }
    // if no numbers or symbols, just return password with alpha
    return(generatePassword(pwLen, alphaSet, caps))
}

// helper method to generate a random password given the passed character set, the length,
// and the boolean for capital letters
private fun generatePassword(pwLen: Int, charList: List<Char>, caps: Boolean): String {
    // empty password string and empty character string to be used in loop
    var pw = ""
    var character: Char
    // for the range of pwLen argument
    for (i in 0 until pwLen) {
        // get a random character from the given character set
        character = charList.random()
        // if we can have capital letters
        if (caps) {
            // check if the character selected is a letter
            if (character in alphaSet) {
                // give a 30% chance for it to be upper case
                if (Random.nextDouble() < 0.3) {
                    // if it hits that chance, then make it upper case
                    character = character.toString().uppercase().toCharArray().first()
                }
            }
        }
        // add the character to the password string
        pw += character
    }
    // when done return the password
    return(pw)
}