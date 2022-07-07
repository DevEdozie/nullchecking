package com.rsk.java.kotlin

class Human(val name: String, val age: Int) {

    lateinit var gender:String

    fun printName() {
        println("Name:$name")
    }

    fun printAge() {
        println("Age:$age")
    }


}

fun main(args: Array<String>) {
    var kevin: Human? = null
    kevin?.printName()
    kevin?.printAge()
    kevin?.gender = "Male"
    println("Gender: ${kevin?.gender}")
    printDetails(kevin)

    //promise to initialise
    lateinit var shola:Human




    var neverNull = Human("NeverNull",4)
    printDetailsNonNull(neverNull)





    val isnull: Human? = Human("Kevin", 20)
    //using safe call operator
    isnull?.printName()
    isnull?.printAge()
    printDetails(isnull)


    //used when passing nullable values to non-null values
    isnull?.let {
        printDetailsNonNull(isnull)
    }
    /*
    Equivalent to
    if(isnull != null){
       isnull.printName()
     }else{
       //do nothing
     }
     */

    //Elvis operator
    kevin = isnull ?: Human("New", 1)
    /*
    Equivalent to
    if(isnull != null){
        kevin = isnull
    }else{
        kevin = Human("New",1)
    }
     */
    kevin.printName()
    kevin.printAge()
    printDetails(kevin)
    kevin.let {
        printDetailsNonNull(kevin)
    }

    //lateinit
    shola = Human("Shola",25)
    printDetailsNonNull(shola)


    //not-null assertion "!!"
    /*
    Ensures that a null value is
    never accepted else the program
    crashes
     */
//    val neverNull: Human? = null
//    neverNull!!.printName()
//    neverNull!!.printAge()


}


fun printDetailsNonNull(human:Human){
    println("...Non Null...\nName:${human.name}")
    println("Age:${human.age}\n..........")
}

fun printDetails(human:Human?){
    println("......\nName:${human?.name}")
    println("Age:${human?.age}\n..........")
}
