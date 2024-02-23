import java.util.*

fun main(args: Array<String>) {
//    println("hello word")
//    var tutu = Alien()
//    tutu.name="kaveesh"
//    println("Name is : "+Alien().name+" "+tutu.name)
//    println("Name is : ${tutu.name}")

    var num1: Int = 10
    var num2: Int = 12

    var result = num1 + num2

    println("The addition of $num1 and $num2 is $result.")

    var kaveesh = Alien()
    kaveesh.name = "kaizz"
    println("Alien name is ${kaveesh.name}")

    var number: Int = 0

    number = if (num1 > num2)
        num1
    else
        num2

    println(number)

    var nam1: String? = null

    var ali: Alien? = Alien()
    ali = null
    println(ali?.name)


    var numbs = listOf(1, 2, 3, 4)
    for (n in numbs) {
        println(n)

    }

    for ((i, e) in numbs.withIndex()) {
        println("$i : $e")

    }

    var numbers = TreeMap<String, Int>()
    numbers["one"] = 1
    numbers["two"] = 2

    for ((number, value) in numbers) {
        println("$number : $value")

    }

    var tot = add(2, 4)
    println(tot)

    var max = max(50, 45)
    println(max)

    var finalAmount = calAmount(70)
    println("Final Amount : $finalAmount")

    var str: String = "4"
    var num: Int = str.toInt()
    println("Integer num :$num")

    var str1: String = "4a"
    var number1: Int = try {
        str1.toInt()

    } catch (e: NumberFormatException) {
        0

    }
    println(number1)

    var a1 = Alien()
    a1.skills = "Java"
    a1.show()

    var a2 = Alien()
    a2.skills = "Kotlin"
    a2.show()

    //  var a3 = a1.plus(a2)
//    var a3 = a1 plus a2
//
//    a3.show()

    var a4 = a1 + a2
    a4.show()

    var h1 = Human()
    h1.think()

    var s1 = Student(20, "kaizz")
    s1.think()

    var nimal: Human = Men("kaizz")
    println(nimal.name)
    nimal.think()

    var newDog = Dog()
    newDog.behaviour()

    var c1 = C()
    c1.show()
    c1.display()
    c1.open()

    var l1 = Laptop("Dell",2000)
    var l2 = Laptop("Dell",2000)

    var l3 = l2.copy(price = 2200)

    println(l1.equals(l2))
    println(l3)

    var rectangle:Shape = object :Shape{
        override fun draw() {
            println("rectangle is created")
        }

    }
    rectangle.draw()

    StaticA.talk()

    var fact = Factory.create()
    fact.show()

    System.`in`

//    print("Input a number: ")
//    var inNum= readln()
//    println("The input number is $inNum")

    var numArray = intArrayOf(10,20,30)
    var strArray = DoubleArray(3)
    var nullArray = arrayOfNulls<Int>(3)

    var subjects : List<Subject> = listOf<Subject>(Subject("English",20),Subject("Maths",30))
    for (subject in subjects)
        println(subject.name)

    subjects.forEach(::println)

    var values = listOf<Int>(1,2,3,4)
//    values.forEach({ println(it) })
//    values.forEach({n-> println(n) })
    values.forEach(::println)

    println("final values: ")
    var finalVal = values.filter { it%2==0 }
        .map { it*2 }
    finalVal.forEach({ println(it) })



}
data class Subject(var name:String, var points:Int)
/////////////////////////////////////main

fun `in`():String{
  return ("Escape this in")

}

class Factory{
    companion object {
        fun create():Factory=Factory()
    }
    fun show(){
        println("Factory is showing")
    }
}

class StaticA{
    companion object{
        @JvmStatic
        fun talk(){
            println("Static is talking....")

        }
    }
}


interface Shape{

    fun draw()
}


data class Laptop (val brand:String,val price:Int){

}

interface A {
    fun show()
    fun open() {
        println("A is open")
    }

}

interface B {
    fun display()
    fun open() {
        println("B is open")
    }

}

class C : A, B {
    override fun show() {
        println("show Implements")

    }

    override fun display() {
        println("display Implements")

    }

    override fun open() {
        println("C is open")
        println(super<A>.open())
        println(super<B>.open())
    }

}

abstract class Animal {
    abstract fun behaviour()

}

class Dog : Animal() {
    override fun behaviour() {
        println("This is a dog, Baww..Baww..")
    }

}


class Men(name: String) : Human(name) {
    init {
        println(name + " " + "init")
    }

    override fun think() {
        println("Men Thinking.. $name")

    }
}

open class Human(n: String = "demo") {
    var name: String = n


    open fun think() {
        println("Kotlin is awesome $name")
    }

}

class Student(n: String) {
    var name: String = n
    var age: Int = 0

    constructor(age: Int, name: String) : this(name) {
        this.age = age

    }

    fun think() {
        println("Kotlin is perfect $name : $age")
    }
}
//fun Alien.plus(a:Alien) :Alien{
//    var newAlien=  Alien()
//    newAlien.skills=this.skills+" "+a.skills
//    return newAlien
//
//}

//infix fun Alien.plus(a:Alien):Alien{
//    var new = Alien()
//    new.skills=this.skills+" "+a.skills
//    return new
//
//}
operator fun Alien.plus(a: Alien): Alien {
    var new = Alien()
    new.skills = this.skills + " " + a.skills
    return new

}

//fun add(a : Int,b :Int) : Int{
//   return (a+b)
//
//
//}

fun add(a: Int, b: Int): Int = a + b
fun max(a: Int, b: Int): Int = if (a > b) a else b


fun calAmount(amt: Int, interest: Double = 0.1): Int {
    return (amt + (amt * interest).toInt())

}