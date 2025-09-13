/*
// Задача 1
fun main()
{
    println ("Программа подсчитывает количество подряд идущих одинаковых символов. \n")
    println("Введите строку:")
    val input = readln()
    val result = StringBuilder()
    var count = 1
    val length = input.length
    for (i in 1 until length)
    {
        if (input[i] == input[i - 1])
        {
            count++
        }
        else
        {
            result.append(input[i - 1])
            if (count > 1)
            {
                result.append(count)
            }
            count = 1
        }
    }
    result.append(input[length - 1])
    if (count > 1)
    {
        result.append(count)
    }
    println("Вывод результата: $result")
}
//Задача 2
fun main ()
{
    println ("Приложение подсчитывает количество различных символов во введенной строке в алфавитном порядке. \n")
    println ("Введите строку: ")
    val input = readln()
    val charCnt = mutableMapOf <Char, Int>()

    for (char in input)
    {
        if (charCnt.containsKey(char))
            {
                charCnt[char] = charCnt[char]!! + 1
            }
        else
        {
            charCnt[char]=1
        }
    }
    val sortedKeys = charCnt.keys.sorted()
    println ("Результат: ")
    for (char in sortedKeys)
    {
        println ("$char-${charCnt[char]}")
    }
}

//Задача 3
fun main ()
{
    println("Приложение, которое преобразует введенное пользователем натуральное число из 10-ичной системы в двоичную.\n")
    println("Введите натуральное число из 10-ичной системы счисления: ")
    val input = readln()
    if (input.all { it.isDigit() }&& input.isNotEmpty())
    {
        val num = input.toInt()
        if (num == 0)
        {
            println("Результат: 0")
        }
        else {
            val numb = num.toString(2)
            println("Результат преобразования: ")
            println("Десятичное число: $num")
            println("Двоичное число: $numb")
        }
    }
    else
    {
        println("Число введено не корректно! \n Введите корректное число!")
    }
}
*/
//Задача 4
fun main()
{
    println("Приложение простого калькулятора.\n")
    println("Введите выражение в формате - ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ: ")
    val input = readln().trim()
    val parts = input.split(" ")
    if (parts.size != 3)
    {
        println("Ошибка: введите выражение в формате ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ")
        return
    }
    val number1 = parts[0].toDoubleOrNull()
    val number2 = parts[1].toDoubleOrNull()
    val operation = parts[2]
    if (number1 == null || number2 == null)
    {
        println("Ошибка: введите корректные числа")
        return
    }
    when (operation)
    {
        "+" ->
        {
            val result = number1 + number2
            println("Результат: $number1 + $number2 = $result")
        }
        "-" ->
        {
            val result = number1 - number2
            println("Результат: $number1 - $number2 = $result")
        }
        "*" ->
        {
            val result = number1 * number2
            println("Результат: $number1 * $number2 = $result")
        }
        "/" ->
        {
            if (number2 == 0.0)
            {
                println("Ошибка: деление на ноль невозможно")
            } else
            {
                val result = number1 / number2
                println("Результат: $number1 / $number2 = $result")
            }
        }
        else ->
        {
            println("Ошибка: неизвестная операция '$operation'. Доступные операции: + - * /")
        }
    }
}
