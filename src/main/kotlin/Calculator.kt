open class Calculator {
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
        return if(input == 1) {
            input
        } else {
            input * factorial(input-1)
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
    fun percentage(base: Double): Double {
        return base * 0.01
    }
}