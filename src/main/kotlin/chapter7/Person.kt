package chapter7

import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class ObservableProperty(
    var propValue: Int, val changeSupport: PropertyChangeSupport
) {
    operator fun getValue(p: Person, prop: KProperty<*>): Int = propValue
    operator fun setValue(p: Person, prop: KProperty<*>, newvalue: Int) {
        val oldValue = propValue
        propValue = newvalue
        changeSupport.firePropertyChange(prop.name, oldValue, newvalue)
    }
}

//class ObservableProperty (val propName: String, var propValue: Int, val changeSupport: PropertyChangeSupport) {
//    fun getValue(): Int = propValue
//    fun setValue(newValue: Int) {
//        val oldValue = propValue
//        propValue = newValue
//        changeSupport.firePropertyChange(propName, oldValue, newValue)
//    }
//}

class Person (val name: String, age: Int, salary: Int): PropertyChangeAware() {
    private val observer = {
        prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
//    val _age = ObservableProperty("age", age, changeSupport)
//    var age: Int
//        get() = _age.getValue()
//        set(value) {_age.setValue(value)}
//
//    val _salary = ObservableProperty("salary", salary, changeSupport)
//    var salary: Int
//        get() = _salary.getValue()
//        set(value) {_salary.setValue(value)}
//    var age: Int = age
//        set(newValue) {
//            val oldValue = field
//            field = newValue
//            changeSupport.firePropertyChange(
//                "age", oldValue, newValue
//            )
//        }
//
//    var salary: Int = salary
//        set(newValue) {
//            val oldValue = field
//            field = newValue
//            changeSupport.firePropertyChange(
//                "salary", oldValue, newValue
//            )
//        }
}

//class Person (val name: String) {
//    val emails by lazy { loadEmails(this) }
////    private var _emails: List<Email>? = null
////    val emails: List<Email>
////    get() {
////        if (_emails == null) {
////            _emails = loadEmails(this)
////        }
////
////        return _emails!!
////    }
//}

//class Person (val firstName: String, val lastName: String): Comparable<Person> {
//    override fun compareTo(other: Person): Int {
//        return compareValuesBy(this, other,
//        Person::lastName, Person::firstName)
//    }
//}