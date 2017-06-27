package org.ev3dev.kotlin

import ev3dev.actuators.Sound

fun main(args: Array<String>) {
    print("Hello World")
    Sound.getInstance().beep()
}