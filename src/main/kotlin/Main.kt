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
} */

//Задача 2
fun main ()
{
    println ("Приложение подсчитывает количество различных символов во введенной строке в алфавитном порядке. \n")
    println ("Введите строку: ")
    val input = readln()
    val charCnt = mutableMapOf <Char, Int>()

    for (char in input)
    {
        if (charCnt.contrainsKey(char))
            {
            charCount[char] = charCnt[char]!! + 1
            }
    }
    val sortedKets = charCnt.key.sorted()

    println ("Результат: ")
    for (char in sortedKeys)
    {
        println ("#char-@{charCnt[char]}")
    }
}