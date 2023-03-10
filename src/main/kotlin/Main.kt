import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.system.exitProcess

fun validateInput(input: List<String>): Boolean {
    val firstInput = input[0].toDoubleOrNull()
    val secondInput = input[2].toDoubleOrNull()
    if(input.isEmpty() ||
        firstInput == null ||
        secondInput == null ||
        !(input[1].contains(Regex("""[+,\-,*,/]+"""))))
    {
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
    val sort = Sort()

    while(true) {
        print("\nInput: ")
        val input = readlnOrNull()!!.split(" ")

        if(input[0] == "exit") {
            println("Exiting Calculator...")
            exitProcess(0)
        }
        if(input.size == 1) {
            if(input[0].contains(Regex("""([0-9]+)(!)"""))) {
                val newInput = input[0].removeSuffix("!").toInt()
                println(calculator.factorial(newInput))
                continue
            }
            if(input[0].contains(Regex("""([0-9]+).([0-9]*)(\^)([0-9]+)"""))) {
                val newInput = input[0].split("^")
                println(calculator.exponent(newInput[0].toDouble(), newInput[1].toInt()))
                continue
            }
            if(input[0].contains(Regex("""(√)([0-9]+)"""))) {
                val newInput = input[0].removePrefix("√")
                println(sqrt(newInput.toDouble()))
                continue
            }
            if(input[0].contains(Regex("""([0-9]+).([0-9]*)(%)"""))) {
                val newInput = input[0].removeSuffix("%").toDouble()
                println(calculator.percentage(newInput))
                continue
            }
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