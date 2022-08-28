package chapter7

class Point(val x: Int, val y: Int) {
    operator fun component1() = x
    operator fun component2() = y
//    operator fun plus(other: Point): Point {
//        return Point(x + other.x, y + other.y)
//    }
    override fun equals(obj: Any?): Boolean {
        if (obj === this) return true
        if (obj !is Point) return false
        return obj.x == x && obj.y == y
    }
}
