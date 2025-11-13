package com.talk.sphere.core.presentation

import platform.Foundation.NSLog

actual object Logger {
    actual fun d(tag: String, message: String) = NSLog("D/%s: %s", tag, message)
    actual fun i(tag: String, message: String) = NSLog("I/%s: %s", tag, message)
    actual fun w(tag: String, message: String) = NSLog("W/%s: %s", tag, message)
    actual fun e(tag: String, message: String, throwable: Throwable?) {
        if (throwable != null) {
            NSLog("E/%s: %s — %s", tag, message, throwable.toString())
        } else {
            NSLog("E/%s: %s", tag, message)
        }
    }
}