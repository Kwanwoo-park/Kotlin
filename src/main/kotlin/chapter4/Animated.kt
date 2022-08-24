package chapter4

abstract class Animated {
    abstract fun animate()
    open fun stopAnimating() {}
    fun animateTwice() {}
}