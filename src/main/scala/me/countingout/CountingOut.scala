package me.countingout

object CountingOut {

  val errorMsg = "Input should be in the format of two delimited integers: n k"

  def main(args: Array[String]) : Unit = {
    val result = args.length match {
      case 2 =>
        process(args)
      case _ => errorMsg
    }
    println(result)
  }

  def process(args: Array[String]) : String = {
    args.length match {
      case 2 =>
        val n = args(0).trim.replaceAll("[^A-Za-z0-9]", "")
        val k = args(1).trim.replaceAll("[^A-Za-z0-9]", "")
        parseInputToInt((n, k)).fold(
          parsed => countingOut(parsed._1, parsed._2).toString,
          error => error
        )
      case _ =>
        errorMsg
    }
  }

  def countingOut(n: Int, k: Int) : Int = {
    if (n == 1) {
      1
    }
    else if (k == 1) {
      0
    }
    else if (k == 2) {
      countingOutSkipTwo(n)
    }
    else {
      (countingOut(n-1, k) + k-1) % n+1
    }
  }

  private def countingOutSkipTwo(n: Int) : Int = {
    val valueOfL = n - Integer.highestOneBit(n)
    2 * valueOfL + 1
  }

  def parseInputToInt(inputs: (String, String)) : Either[(Int, Int), String] = {
    try {
      Left((inputs._1.toInt, inputs._2.toInt))
    } catch {
      case _: Exception => Right(errorMsg)
    }
  }

}
