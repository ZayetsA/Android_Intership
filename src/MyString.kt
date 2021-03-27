import java.lang.IllegalArgumentException
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

class MyString {
    private var characters: CharArray = charArrayOf()
    private var length = 0
    private var DEFAULT_STORAGE_SIZE = 10

    constructor() {
        length = DEFAULT_STORAGE_SIZE
        characters = CharArray(length)
    }

    constructor(char: Char) {
        length = DEFAULT_STORAGE_SIZE
        characters = CharArray(length)
        characters[0] = char
    }

    constructor(charArray: CharArray) {
        length = charArray.size
        characters = CharArray(length)
        for (i in 0 until length) characters[i] = charArray[i]
    }

    constructor(MyString: MyString) {
        length = MyString.myLength()
        characters = CharArray(length)
        for (i in 0 until length) characters[i] = MyString.myCharAt(i)
    }

    fun myStrConcat(otherString: MyString): MyString {
        val length = this.characters.size + otherString.characters.size
        val temp = CharArray(length)
        for (i in this.characters.indices) temp[i] = this.characters[i]
        for (i in otherString.characters.indices) temp[this.characters.size + i] = otherString.characters[i]
        return MyString(temp)
    }

    fun myStringDisplay() {
        for (i in this.characters.indices) {
            if (characters[i] == '\n') break
            else System.out.format("%c", characters[i])
        }
        println("")
    }

    fun myStrIndexOf(char: Char): Int {
        val fromIndex = 0
        for (i in fromIndex until length) {
            if (characters[i] == char) return i
        }
        return -1
    }

    fun mySetAt(index: Int, char: Char) {
        if (index < 0) throw StringIndexOutOfBoundsException(index)
        if (index > length) throw  StringIndexOutOfBoundsException(index)
        characters[index] = char
    }

    fun mySubStr(start: Int, end: Int): MyString {
        if (start < 0) throw StringIndexOutOfBoundsException(start)
        if (end > length) throw  StringIndexOutOfBoundsException(end)
        if (start > end) throw StringIndexOutOfBoundsException(end - start)
        val result = MyString()
        result.length = end - start + 1
        result.characters = CharArray(result.length)
        for (i in 0 until result.length) result.characters[i] = this.characters[start + i]
        return result
    }

    fun myIntToStr(value: Int): MyString {
        try {
            var temp: Int
            var negativeFlag = false
            val arrayOfNumbers = ArrayList<Int>()
            val charBuffer = ArrayList<Char>()

            if (value < 0) {
                temp = abs(value)
                negativeFlag = true
            } else temp = value

            do {
                arrayOfNumbers.add(temp % 10)
                temp /= 10
            } while (temp > 0)
            for (i in 0 until arrayOfNumbers.size) charBuffer.add('0' + arrayOfNumbers[i])
            if (negativeFlag) charBuffer.add('-')
            charBuffer.reverse()
            return MyString(charBuffer.toCharArray())
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
        return MyString()
    }

    fun myStrContains(otherString: MyString): Boolean {
        var lastIndex = 0
        var result: MutableList<Int> = ArrayList()

        while (lastIndex != -1) {
            lastIndex = this.myIndexOf(otherString, lastIndex)
            if (lastIndex != -1) {
                result.add(lastIndex)
                lastIndex += 1
            }
        }
        if (result.size != 0) return true
        return false
    }

    private fun myIndexOf(otherString: MyString, lastIndex: Int): Int {
        return myIndexOf(
            characters,
            0,
            characters.size,
            otherString.characters,
            0,
            otherString.characters.size,
            lastIndex
        )
    }

    private fun myIndexOf(
        source: CharArray,
        sourceOffset: Int,
        sourceCount: Int,
        target: CharArray,
        targetOffset: Int,
        targetCount: Int,
        fromIndex: Int
    ): Int {
        var firstIndex = fromIndex
        if (firstIndex >= sourceCount) return if (targetCount == 0) sourceCount else -1
        if (firstIndex < 0) firstIndex = 0
        if (targetCount == 0) return firstIndex
        target[targetOffset]
        val max = sourceOffset + (sourceCount - targetCount)
        var i = sourceOffset + firstIndex
        while (i <= max) {
            if (i <= max) {
                var j = i + 1
                val end = j + targetCount - 1
                var k = targetOffset + 1
                while (j < end && source[j] == target[k]) {
                    j++
                    k++
                }
                if (j == end) return i - sourceOffset
            }
            i++
        }
        return -1
    }

    fun myStrToFloat(): Float {
        val array = this.myToCharArr()
        val sb = StringBuilder()
        sb.append(array)
        return sb.toString().toFloat()
    }


    fun myValueOf(data: CharArray): MyString {
        return MyString(data)
    }

    fun myToString(): MyString {
        return this
    }

    fun myToCharArr(): CharArray {
        return characters
    }


    private fun myCharAt(i: Int): Char {
        if ((i < 0) || i > characters.size) throw StringIndexOutOfBoundsException(i)
        return characters[i]
    }

    private fun myLength(): Int {
        return length;
    }

}