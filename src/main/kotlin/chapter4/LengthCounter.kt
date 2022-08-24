package chapter4

class LengthCounter {
    var counter: Int = 0
    private set

    fun addWord(word: String) {
        counter += word.length
    }
}