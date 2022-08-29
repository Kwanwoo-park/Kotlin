package chapter8

data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

enum class OS {WINDOWS, LINUS, MAC, IOS, ANDROID}

val log = listOf(
    SiteVisit("/", 34.0, OS.WINDOWS),
    SiteVisit("/", 22.0, OS.MAC),
    SiteVisit("/login", 12.0, OS.WINDOWS),
    SiteVisit("/signup", 8.0, OS.IOS),
    SiteVisit("/", 16.3, OS.ANDROID)
)
