package org.ev3dev.kotlin

import ev3dev.actuators.Sound

//TODO At the moment, it is necessary to have a Main class to associate in the Manifest
class HelloWorld {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            print("Hello World")
            Sound.getInstance().beep()
        }

    }
}