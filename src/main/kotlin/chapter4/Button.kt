package chapter4

class Button: View {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    class ButtonState: State {}
}

//class Button: Clickable, Focusable {
//    override fun click() = println("I was clicked")
//    override fun showOff() {
//        super<Clickable>.showOff()
//        super<Focusable>.showOff()
//    }
//}