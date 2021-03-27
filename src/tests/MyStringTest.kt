package tests

import MyString
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MyStringTest {

    private lateinit var string1: MyString
    private lateinit var string2: MyString
    lateinit var string3: MyString

    @Before
    fun setUp() {
        string1 = MyString(charArrayOf('H', 'e', 'l', 'l', 'o', ','))
        string2 = MyString(charArrayOf('w', 'o', 'r', 'l', 'd', '!'))
        string3 = MyString()
    }

    @Test
    fun myStrConcat() {
        val res1 = charArrayOf('H', 'e', 'l', 'l', 'o', ',', 'w', 'o', 'r', 'l', 'd', '!')
        assertArrayEquals(res1, string1.myStrConcat(string2).myToCharArr())
    }

    @Test
    fun myStrIndexOf() {
        val res = 4
        val incorrectRes = -1
        assertEquals(res, string1.myStrIndexOf('o'))
        assertEquals(incorrectRes, string1.myStrIndexOf('8'))
    }

    @Test
    fun mySetAt() {
        string1.mySetAt(1, '3')
        assertEquals(string1.myStrIndexOf('3'), 1)

        string1.mySetAt(4, 'g')
        assertEquals(string1.myStrIndexOf('g'), 4)
    }

    @Test
    fun mySubStr() {
        val expectedRes1 = charArrayOf('e', 'l', 'l', 'o')
        assertArrayEquals(expectedRes1, string1.mySubStr(1, 4).myToCharArr())

        val expectedRes2 = charArrayOf('H', 'e', 'l', 'l')
        assertArrayEquals(expectedRes2, string1.mySubStr(0, 3).myToCharArr())

    }

    @Test
    fun myIntToStr() {
        val expectedRes1 = charArrayOf('1', '0', '2', '3')
        val testString = MyString()
        assertArrayEquals(expectedRes1, testString.myIntToStr(1023).myToCharArr())

        val expectedRes2 = charArrayOf('0')
        assertArrayEquals(expectedRes2, testString.myIntToStr(0).myToCharArr())

        val expectedRes3 = charArrayOf('-', '1', '4', '8', '8')
        assertArrayEquals(expectedRes3, testString.myIntToStr(-1488).myToCharArr())
    }

    @Test
    fun myStrContains() {
        val testString = MyString(charArrayOf('H', 'e', 'l', 'l', 'o', ',', 'w', 'o', 'r', 'l', 'd', '!'))

        val partOfStr1 = MyString(charArrayOf('H', 'e', 'l', 'l'))
        assertEquals(true, testString.myStrContains(partOfStr1))

        val partOfStr2 = MyString(charArrayOf('H', 'e', 'l', 'l', 'a'))
        assertEquals(false, testString.myStrContains(partOfStr2))

        val partOfStr3 = MyString()
        assertEquals(false, testString.myStrContains(partOfStr3))
    }

    @Test
    fun myStrToFloat() {
        val expected = 1490.2
        val arrFloatNum = MyString(charArrayOf('1', '4', '8', '8', '.', '2'))
        val res = arrFloatNum.myStrToFloat() + 2
        assertEquals(expected, res.toDouble(), .2)

        val expected2 = -1486.2
        val arrFloatNum2 = MyString(charArrayOf('-', '1', '4', '8', '8', '.', '2'))
        val res2 = arrFloatNum2.myStrToFloat() + 2
        assertEquals(expected2, res2.toDouble(), .2)

        val expected3 = 2.0
        val arrFloatNum3 = MyString(charArrayOf('0'))
        val res3 = arrFloatNum3.myStrToFloat() + 2
        assertEquals(expected3, res3.toDouble(), .2)
    }
}