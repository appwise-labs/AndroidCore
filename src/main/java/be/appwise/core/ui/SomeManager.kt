package be.appwise.core.ui


object SomeManager {
    interface Listener {
        fun onViewModelError(th: Throwable)
    }

    var listener: Listener? = null
}