package eu.tutorials.kotlinbasics

fun main(){

    // Integer Types :
    val myByte: Byte = 13   // 8bits ; range : -128 ~ 127
    val myShort: Short = 13 // 16 bits
    val myInt: Int = 13     // 32 bits (Default)
    val myLong: Long = 13   // 64 bits

    // Float Types :
    var myFloat: Float = 13.37F   // 32 bits
    val myDouble: Double = 13.37 // 64 bits (Default)

    // Booleans
    var isSunny: Boolean = true
    isSunny = false

    // String & Characters
    val letterString = "Aasd"  // "" for string
    val digitChar = '$'      // '' for char (single character)
    var firstChar =  letterString[0]
    print("First char of the string is : " + firstChar)
    print("First char of the string is : ${firstChar}")
    print(". Length of the string is : " +letterString.length)

    var a = 5.0
    var b = 3
    print(a/b)

    val x : Any = 13.37
    //assign when to a variable
    val result =  when(x) {
    //let condition for each block be only a string
        is Int -> "is an Int"
        !is Double -> "is not Double"
        is String -> "is a String"
        else -> "is none of the above"
    }
    //then print x with the result
    print("Hello $result")

    for(i in 10 downTo 1)
    {
        print("\n$i")
    }

    for (i in 0..10000){
        if (i == 9001){
            print("Over 9000!\n")
        }
    }

    var initHumidLevel = 80
    var humidity = "humid"

    while(humidity == "humid"){

        initHumidLevel -= 5
        print("$initHumidLevel\n")
        print("humidity decrease\n")

        if(initHumidLevel < 60){
            print("comfy now\n")
            humidity = "comfy"
        }
    }

    var test = avg(3.0,9.0)
    print("$test\n")


    val nullableName4: String? = null

    print("111\n")
    nullableName4?.let { println(it.toLowerCase()) }
    print("11\n")
    nullableName4?.let { println(it.length) }
    print("1\n")

}

fun avg(a: Double, b: Double): Double {
    return  (a + b)/2
}
