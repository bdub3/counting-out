package me.countingout

import org.scalatest.{FlatSpec, FunSuite}

class CountingOutTest extends FunSuite {

  val errorMsg = "Input should be in the format of two delimited integers: n k"

  test("error message for incorrect command line args") {
    assert(CountingOut.process(Array("one", "two")) == errorMsg)
    assert(CountingOut.process(Array("one", "2")) == errorMsg)
    assert(CountingOut.process(Array("1", "two")) == errorMsg)
  }

  test("command line args with special characters") {
    assert(CountingOut.process(Array("1,", "0")) == "1")
    assert(CountingOut.process(Array("1,", "0 ")) == "1")
  }

  test("more or less than 2 command line args") {
    assert(CountingOut.process(Array("one", "two", "three")) == errorMsg)
    assert(CountingOut.process(Array("one")) == errorMsg)
  }

  test("n == 1 returns 1 for any value k") {
    assert(CountingOut.countingOut(1, 0) == 1)
    assert(CountingOut.countingOut(1, 1) == 1)
    assert(CountingOut.countingOut(1, 2) == 1)
    assert(CountingOut.countingOut(1, Math.random().toInt) == 1)
    assert(CountingOut.countingOut(1, Math.random().toInt) == 1)
  }

  test("for k==1, always return 0") {
    assert(CountingOut.countingOut(2, 1) == 0)
    assert(CountingOut.countingOut(8, 1) == 0)
    assert(CountingOut.countingOut(Math.random().toInt, 1) == 0)
  }

  test("special case of k=2") {
    assert(CountingOut.countingOut(2, 2) == 1)
    assert(CountingOut.countingOut(4, 2) == 1)
    assert(CountingOut.countingOut(3, 2) == 3)
    assert(CountingOut.countingOut(5, 2) == 3)
  }

  test("cases where n = n") {
    assert(CountingOut.countingOut(3, 3) == 2)
    assert(CountingOut.countingOut(4, 4) == 2)
    assert(CountingOut.countingOut(5, 5) == 2)
    assert(CountingOut.countingOut(6, 6) == 4)
    assert(CountingOut.countingOut(7, 7) == 5)
    assert(CountingOut.countingOut(8, 8) == 4)
    assert(CountingOut.countingOut(9, 9) == 8)
    assert(CountingOut.countingOut(10, 10) == 8)
    assert(CountingOut.countingOut(11, 11) == 7)
    assert(CountingOut.countingOut(12, 12) == 11)
  }

  test("test for various values of n and k") {
    assert(CountingOut.countingOut(2, 3) == 2)
    assert(CountingOut.countingOut(5, 8) == 1)
    assert(CountingOut.countingOut(7, 3) == 4)
  }

}
