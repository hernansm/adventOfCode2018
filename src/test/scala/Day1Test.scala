import day1.Day1
import org.scalatest.FlatSpec

import scala.io.Source

class Day1Test extends FlatSpec {
  "A frequency checker" should "sum all values in a given file" in {
    val list = Source.fromResource("day1TestA.txt").getLines.toList

    val actualFreq = Day1.calibrateFrequency(list)
    val expectedFreq = 1
    assert(actualFreq.equals(expectedFreq))
    assert(actualFreq === expectedFreq)

  }
}