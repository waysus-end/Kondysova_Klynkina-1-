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
        print("Выберите программу (0-6): ")

        val choice = readln().toIntOrNull()

        when (choice)
        {
            0 -> {
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
        println("\nНажмите Enter для продолжения...")
        readln()
    }
}



fun program1()
{
    println ("Программа подсчитывает количество подряд идущих одинаковых символов. \n")
    println("Введите строку:")
    val s = readln()
    var result = ""
    var count = 1
    for (i in 1 until s.length)
    {
        if (s[i] == s[i - 1])
            count++
        else
        {
            result += s[i - 1]

            if (count > 1)
                result += "$count"
                count = 1
        }
    }
    if (s.isNotEmpty())
    {
        result += s.last()

        if (count > 1)
            result += "$count"
    }
    println("Результат: $result")
}


fun program2()
{
    println ("Приложение подсчитывает количество различных символов во введенной строке в алфавитном порядке. \n")
    println("Введите строку:")
    val s = readln()
    val countMap = mutableMapOf<Char, Int>()
    for (c in s)
        countMap[c] = (countMap[c] ?: 0) + 1
    val keys = countMap.keys.sorted()
    for (k in keys)
        println("$k - ${countMap[k]}")
}



fun program3()
{
    println("Приложение, которое преобразует введенное пользователем натуральное число из 10-ичной системы в двоичную.\n")
    println("Введите число:")
    val num = readln().toIntOrNull()
    if (num == null || num < 0)
    {
        println("Ошибка: введите натуральное число.")
        return
    }
    println("Десятичное: $num")
    println("Двоичное: ${Integer.toBinaryString(num)}")
}



fun program4()
{
    println("Приложение простого калькулятора.\n")
    println("Введите выражение (число1 число2 операция):")
    val parts = readln().split(" ")

    if (parts.size != 3)
    {
        println("Ошибка: неверный формат.")
        return
    }

    val n1 = parts[0].toIntOrNull()
    val n2 = parts[1].toIntOrNull()
    val op = parts[2]

    if (n1 == null || n2 == null)
    {
        println("Ошибка: введены не числа.")
        return
    }
    when (op)
    {
        "+" -> println("$n1 + $n2 = ${n1 + n2}")
        "-" -> println("$n1 - $n2 = ${n1 - n2}")
        "*" -> println("$n1 * $n2 = ${n1 * n2}")
        "/" -> if (n2 == 0)
            println("Ошибка: деление на ноль.")
        else
            println("$n1 / $n2 = ${n1 / n2}")

        else -> println("Ошибка: неизвестная операция.")
    }
}



fun program5()
{
    println("Приложение, с помощью которого пользователь, введя целое " +
            "число n и основание степени x узнает, существует ли целочисленный показатель " +
            "степени y для которого выполняется равенство xy = n. \n")
    println("Введите число n:")
    val n = readln().toIntOrNull()
    println("Введите основание x:")
    val x = readln().toIntOrNull()
    if (n == null || x == null)
    {
        println("Ошибка ввода.")
        return
    }
    if (x == 0 || x == 1)
    {
        if (n == 1)
            println("y = 0")
        else
            println("Целочисленного показателя не существует")
        return
    }
    var power = 1
    var y = 0
    while (power < n)
    {
        power *= x
        y++
    }
    if (power == n)
        println("y = $y")
    else
        println("Целочисленного показателя нет")
}



fun program6()
{
    println("Приложение, в котором пользователь вводит две различных цифры. " +
            "На выходе приложение выдает, если это возможно, из введенных цифр, нечетное число. \n")
    print("Введите первую цифру: ")
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
    }
}
