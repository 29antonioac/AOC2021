import scala.io.Source

def readFile(path: String): List[Int] = {
  val buffer = Source.fromFile(path)
  val lines = buffer.getLines().map(_.toInt).toList

  buffer.close()

  lines
}

def countIncreases(s: List[Int]): Int = {
  s.sliding(2).count(w => w.head < w.last)
}

val numbers = readFile("Day1.txt")
val increases = countIncreases(numbers)

println(s"Part one solution: $increases")

val numbersWindow = numbers.sliding(3).map(_.sum).toList
val increasesWindow = countIncreases(numbersWindow)

println(s"Part two solution: $increasesWindow")