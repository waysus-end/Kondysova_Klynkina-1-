fun main()
{
    println ("Программа подсчитывает количество подряд идущих одинаковых символов. \n")
    println("Введите строку:")
    val input = readLine() ?: ""
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