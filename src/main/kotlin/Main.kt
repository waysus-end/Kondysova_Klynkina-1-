fun main()
{
    while (true)
    {
        println("╔═══════════════════════════════╗")
        println("║ МЕНЮ ПРОГРАММ                 ║")
        println("╠═══════════════════════════════╣")
        println("║ 1. Задача 1                   ║")
        println("║ 2. Задача 2                   ║")
        println("║ 3. Задача 3                   ║")
        println("║ 4. Задача 4                   ║")
        println("║ 5. Задача 5                   ║")
        println("║ 6. Задача 6                   ║")
        println("║ 0. Выход                      ║")
        println("╚═══════════════════════════════╝")
        print("Выберите программу (0-6): \n")
        val choice = readln().toIntOrNull()
        when (choice)
        {
            0 ->
            {
                println("Выход из программы.")
                return
            }
            1 -> program1()
            2 -> program2()
            3 -> program3()
            4 -> program4()
            5 -> program5()
            6 -> program6()
            else -> println("Ошибка: выберите число от 0 до 6")
        }
        println("\nНажмите Enter для продолжения...\n")
        readln()
    }
}
// Задача 1
fun program1()
{
    println ("Программа подсчитывает количество подряд идущих одинаковых символов. \n")
    println("Введите строку:")
    val input = readln()
    val result = StringBuilder() // класс для работы с изменяемыми строками
    var count = 1
    val length = input.length // определяет кол-во символов в этой строке
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
fun program2()
{
    println ("Приложение подсчитывает количество различных символов во введенной строке в алфавитном порядке. \n")
    println ("Введите строку: ")
    val input = readln()
    val charCnt = mutableMapOf <Char, Int>() //изменяемая карта, котороая позволяет добавлять, удалять и обновлять пары ключ-значения

    for (char in input)
    {
        if (charCnt.containsKey(char)) //проверяет существует ли в MAP определенный ключ
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
fun program3()
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

//Задача 4
fun program4()
{
    println("Приложение простого калькулятора.\n")
    println("Введите выражение в формате - ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ: ")
    val input = readln().trim() // удаляет пробелы
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
//Задача 5
fun program5()
{
    println("Приложение, с помощью которого пользователь, введя целое " +
            "число n и основание степени x узнает, существует ли целочисленный показатель " +
            "степени y для которого выполняется равенство xy = n. \n")
    println("Введите целое число n: ")
    val ninp = readln()
    val n= ninp.toIntOrNull()
    if (n==null)
    {
        println("Ошибка: введите корректное целое число")
        return
    }
    print("Введите основание степени x: ")
    val xinp = readln()
    val X=xinp.toIntOrNull()
    if (X == null)
    {
        println("Ошибка: введите корректное основание степени")
        return
    }
    if (X==0||X==1)
    {
        if (n==1)
        {
            println("Показатель степени y=0 ")
        }
        else if (X==0 && n==0)
        {
            println("Показатель степени y=1 ")
        }
        else
        {
            println("Целочисленного показателя не существует")
        }
        return
    }
    if (n==0)
    {
        println("Показатель степени y=0 ")
        return
    }
    if (n==0)
    {
        if (X==0)
        {
            println("Показатель степени y=1 ")
        }
        else
        {
            println("Целочисленного показателя не существует")
        }
        return
    }
    var y=0
    var power=1

    while (true)
    {
        if (power == n)
        {
            println ("Показатель степени y = $y")
            return
        }
        if (power > n || power < n && power == 0)
        {
            break
        }
        val nextPow = power * X
        if (nextPow / X!= power)
        {
            break
        }
        power = nextPow
        y++
    }
    println ("Целочисленного показателя не существует")
}
//Задача 6
fun program6()
{
    println("Приложение, в котором пользователь вводит две различных цифры. " +
                "На выходе приложение выдает, если это возможно, из введенных цифр, нечетное число. \n"
    )
    println("Введите первую цифру: ")
    val digit1 = readln().toIntOrNull()
    print("Введите вторую цифру: ")
    val digit2 = readln().toIntOrNull()
    if (digit1 == null || digit2 == null)
    {
        println("Ошибка: введите корректные цифры (0-9)")
        return
    }

    if (digit1 !in 0..9 || digit2 !in 0..9)
    {
        println("Ошибка: введите цифры от 0 до 9")
        return
    }

    if (digit1 == digit2)
    {
        println("Ошибка: цифры должны быть различны")
        return
    }

    val number1 = digit1 * 10 + digit2
    val number2 = digit2 * 10 + digit1

    val oddNumber = when
    {
        number1 % 2 != 0 -> number1
        number2 % 2 != 0 -> number2
        else -> null
    }


    if (oddNumber != null)
    {
        println("Нечетное число: $oddNumber")
    }
    else
    {
        println("Создать нечетное число невозможно")
    }}
