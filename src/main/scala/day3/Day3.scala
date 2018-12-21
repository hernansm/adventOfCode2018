/**
  * Day3: No Matter How You Slice It
  * https://adventofcode.com/2018/day/3
  *
  * How many square inches of fabric are within two or more claims?
  *
  * #1 @ 817,273: 26x26
  * #2 @ 974,796: 18x19
  * #3 @ 207,456: 14x29
  *
  *   - grid size is NOT specified so can't create a grid..
  *   - Must create a list of all the cells with the "use count" --> https://www.reddit.com/r/adventofcode/comments/a2qohl/day_3_part_1_help_needed_i_understand_the/
  *     - use map (cell coordinate -> use count)
  *     - add cellCoord to Set once "use count" gets to 2
  *     - return Set size
  *
  */

/*
   claims:
     #1 @ 1,3: 4x4
     #2 @ 3,1: 4x4
     #3 @ 5,5: 2x2

   visually:
     ........ 1
     ...2222. 2
     ...2222. 3
     .11XX22. 4
     .11XX22. 5
     .111133. 6
     .111133. 7
     ........ 8

     12345678
    */


package day3

import scala.io.Source

object Day3 extends App {
  val file: List[String] = Source.fromResource("problems/day3.txt").getLines.toList
  val claimedFabric = fabricOverlapCounter(file)
  println("claimed: " + claimedFabric)


  /**
    * create a map - this will hold all used cells
    * for each claim:
    *     find the starting coordinate
    *     loop through the height and width of claim
    *     check if coord is in map.
    *         if so check claim value. if >=1 increment claimCount
    *        if not. add coord to map with claim value of 1
    * return claimCount
    *
    * @param claims list of claims
    * @return total square inches of fabric with 2+ claims
    */
  def fabricOverlapCounter(claims: List[String]): Int = {
    // map of fabricCoordinate -> claimedAmt
    var usedFabricMap = Map[(Int, Int),Int]()
    var claimCount = 0

    var seenCoordinates: Set[(Int, Int)] = Set()
    var overlappingCoordinates: Set[(Int, Int)] = Set()
    val checker = 0

    parseClaims(claims)

    claims.foreach( claim => {
      val parsedClaim = claim.replace(":", "")split(Array(' ', ',', 'x'))
      val leftEdge = parsedClaim(2).toInt
      val topEdge = parsedClaim(3).toInt
      val width = parsedClaim(4).toInt
      val height = parsedClaim(5).toInt

   //   println("\nclaim: " + claim)
//      println("leftEdge: " + leftEdge)
//      println("topEdge: " + topEdge)
//      println("width: " + width)
//      println("height: " + height + "\n")

      var yCoor = topEdge + 1
      for(i <- 1 to height) {
        for (inch <- 1 to width) {
          val xCoor = inch + leftEdge
          val claimedFabricSquareInch = (xCoor, yCoor)

          if (seenCoordinates(claimedFabricSquareInch)) {
            overlappingCoordinates += claimedFabricSquareInch

          } else {
            seenCoordinates += claimedFabricSquareInch
          }

          // println(claimedFabricSquareInch)
          if (usedFabricMap.contains(claimedFabricSquareInch)) {
            val claimedValue = usedFabricMap(claimedFabricSquareInch) + 1
            // println("inch: " + claimedFabricSquareInch + " claim value: " + claimedValue)
            if (claimedValue == 2) {
              claimCount += 1
            }
            usedFabricMap + (claimedFabricSquareInch -> claimedValue)
          } else {
            usedFabricMap += (claimedFabricSquareInch -> 1)
            // println("adding claimed inch: " + claimedFabricSquareInch)
          }
        }
        yCoor += 1
      }

    })

   // println("claimedFabric: " + claimCount)

    println("seen coordinates: " + seenCoordinates.size)
    println("overlapping coordinates: " + overlappingCoordinates.size)

    overlappingCoordinates.size
  }

  def parseClaims(claims: List[String]): List[Claim]  = {
    claims.map(claim => {
      val parsedClaim = claim.replace(":", "").replace("#", "") split (Array(' ', ',', 'x'))
      val claimId = parsedClaim(0)
      val leftEdge = parsedClaim(2).toInt
      val topEdge = parsedClaim(3).toInt
      val width = parsedClaim(4).toInt
      val height = parsedClaim(5).toInt

      val test = Claim(claimId, leftEdge, topEdge, width, height)
      println("claim: " + test)
      test
    })
  }
}

case class Claim(id: String, leftEdge: Int, topEdge: Int, width: Int, height: Int)
