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
            println("Please enter a valid input...")
        }
    }
}