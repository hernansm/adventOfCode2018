import day2.Day2
import org.scalatest.FlatSpec

class Day2Test extends FlatSpec {
  "A checksum" should "equal 12 for singles" in {
    val list = List[String]("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab")
    val actualChecksum = Day2.findChecksum(list)

    assert(12 == actualChecksum)

  }

}