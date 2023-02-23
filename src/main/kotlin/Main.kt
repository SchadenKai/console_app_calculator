import kotlin.system.exitProcess

class Calculator {
    fun addition(input1: Double, input2: Double): Double {
        return input1 + input2
    }
    fun subtract(input1: Double, input2: Double): Double {
        return input1 - input2
    }
    fun multiplication(input1: Double, input2: Double): Double {
        return input1 * input2
    }
    fun division(input1: Double, input2: Double): Double {
        return input1 / input2
    }
    fun factorial(input: Int): Int {
        if(input == 1) {
            return input
        } else {
            return input * factorial(input-1)
        }
    }
    fun exponent(base: Double, raised: Int):Double {
        if(raised == 1) {
            return base
        }
        if(raised == 0) {
            return 1.00
        }
        return base * exponent(base, raised-1)
    }
}

fun validateInput(input: List<String>): Boolean {
    val firstInput = input[0].toDoubleOrNull()
    val secondInput = input[2].toDoubleOrNull()
    if(input[0].isBlank()) {
        println("Don't enter a blank input...")
        return false
    }
    if(firstInput == null || secondInput == null) {
        println("Please enter a valid input...")
        return false
    }
    if(!(input[1].contains(Regex("""[+,\-,*,/]+""")))) {
        println("Please enter a valid input...")
        return false
    }
    return true
}

fun main() {
    println("Calculator \n")
    println("Instructions: ")
    println("[1] Separate each function with space    ex. format: 12 + 12 ")
    println("[2] Type \"exit\" to exit the program")

    val calculator = Calculator()

    while(true) {
        print("\nInput: ")
        val input = readlnOrNull()!!.split(" ")

        if(input[0] == "exit") {
            println("Exiting Calculator...")
            exitProcess(0)
        }
        if(input.size == 1 && input[0].contains(Regex("""([0-9]+)(!)"""))) {
            val newInput = input[0].replace("!", "").toInt()
            println(calculator.factorial(newInput))
            continue
        }
        if(input.size == 1 && input[0].contains(Regex("""([0-9]+)(\^)([0-9]+)"""))) {
            val newInput = input[0].split("^")
            println(calculator.exponent(newInput[0].toDouble(), newInput[1].toInt()))
            continue
        }

        if(input.size == 3 && validateInput(input) && input.isNotEmpty()) {
            val firstInput = input[0].toDouble()
            val operation = input[1]
            val secondInput = input[2].toDouble()

            when(operation) {
                "+" -> println(calculator.addition(firstInput, secondInput))
                "-" -> println(calculator.subtract(firstInput, secondInput))
                "*" -> println(calculator.multiplication(firstInput, secondInput))
                "/" -> println(calculator.division(firstInput, secondInput))
            }
        }
        else {
            println("Please enter a valid input.")
        }
    }
}