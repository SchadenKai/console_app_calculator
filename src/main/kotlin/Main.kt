import kotlin.system.exitProcess

class Calculator {

    fun main(operation: String, input1: Double, input2: Double) {
        if (operation == "+") {
            println("= " + addition(input1, input2))
        }
        if (operation == "-") {
            println("= " + subtract(input1, input2))
        }
        if (operation == "*") {
            println("= " + multiplication(input1, input2))
        }
        if (operation == "/") {
            println("= " + division(input1, input2))
        }
    }
    private fun addition(input1: Double, input2: Double): Double {
        return input1 + input2
    }
    private fun subtract(input1: Double, input2: Double): Double {
        return input1 - input2
    }
    private fun multiplication(input1: Double, input2: Double): Double {
        return input1 * input2
    }
    private fun division(input1: Double, input2: Double): Double {
        return input1 / input2
    }
}


fun main(args: Array<String>) {
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
        if(input[0].isBlank() || input.size < 3 || input.size > 3) {
            println("Please enter a valid input in the calculator...")
            continue
        }
        if(input[0].contains(Regex("""[0-9]+""")) &&
            input[1].contains(Regex("""[+,\-,*,/]+""")) &&
            input[2].contains(Regex("""[0-9]+"""))
        ) {
            println("Executing...")
            val firstInput = input[0].toDouble()
            val operation = input[1]
            val secondInput = input[2].toDouble()
            calculator.main(operation = operation,input1 = firstInput, input2 = secondInput)
        } else {
            println("Please enter a valid input...")
        }
    }
}