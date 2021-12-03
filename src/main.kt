import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

private val Vertices = mutableListOf<Point>()
fun main(){

    print("Enter number of vertices: ")
    val scanner = Scanner(System.`in`)
    val numberOfVertices: Int = scanner.nextInt()
    println("Enter the vertices in order: designation(char) x(int) y(int): ")
    for(i in 0 until numberOfVertices){
        var designation = scanner.next().single()
        var x: Int = scanner.nextInt()
        var y: Int = scanner.nextInt()
        Vertices.add(Point(designation, x, y))
    }
    for (i in 0 until numberOfVertices){
        
    }
}
fun euklidesFormula (x1: Int, x2: Int, y1: Int, y2: Int): Double {
    return sqrt((x2 - x1).toDouble().pow(2) - (y2 - y1).toDouble().pow(2))
}

class Point(var designation: Char,var x: Int,var y: Int)

