package chapter4

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}