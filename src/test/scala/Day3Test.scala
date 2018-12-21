import day3.Day3
import org.scalatest.FlatSpec

class Day3Test extends FlatSpec {
  "A FabricSlicer" should "find # of square inches of fabric within 2+ claims" in {
    val claims = List[String]("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")

    /*
    claims:
      #1 @ 1,3: 4x4
      #2 @ 3,1: 4x4
      #3 @ 5,5: 2x2

    visually:
      ........
      ...2222.
      ...2222.
      .11XX22.
      .11XX22.
      .111133.
      .111133.
      ........

     */

    val actualOverlappedClaims = Day3.fabricOverlapCounter(claims)
    val expectedOverlappedClaims = 4

     assert(expectedOverlappedClaims == actualOverlappedClaims)
  }

}