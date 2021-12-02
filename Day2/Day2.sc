import scala.io.Source

def readFile(path: String): List[String] = {
  val buffer = Source.fromFile(path)
  val lines = buffer.getLines().toList

  buffer.close()

  lines
}

val directions = readFile("Day2.txt")
val horizontal = directions.map(_.split(" ")).collect { case Array("forward", n) => n.toInt case _ => 0 }
val aim = directions.map(_.split(" ")).collect { case Array("up", n) => -n.toInt case Array("down", n) => n.toInt case _ => 0 }

val solution1 = horizontal.sum * aim.sum

println(s"Part one solution: $solution1")

val depth = horizontal.zip(aim.scanLeft(0)(_+_).tail).map({ case (h,a) => h * a })

val solution2 = horizontal.sum * depth.sum

println(s"Part two solution: $solution2")
