import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

private val Vertices = mutableListOf<Point>()
private val weights = mutableListOf<PointCalculated>()
private val weights2 = mutableListOf<PointCalculated>()
private val routePoints = mutableSetOf<String>()
fun main(){

    print("Enter number of vertices: ")
    val scanner = Scanner(System.`in`)
    val numberOfVertices: Int = scanner.nextInt()
    println("Enter the vertices in order: designation(char) x(int) y(int): ")
    for(i in 0 until numberOfVertices){
        val designation = scanner.next().single()
        val x: Int = scanner.nextInt()
        val y: Int = scanner.nextInt()
        Vertices.add(Point(designation.toString(), x, y))
    }
    println("Enter starting Point: ")
    val startingPoint = scanner.next().single().toString()
    var route = 0.0
    var nextPoint: String
    var x=0
    for(i in 0 until numberOfVertices){
        weights.clear()
        if(x<1){
            x++  //x==1
            nextPoint = startingPoint
            routePoints.add(startingPoint)
        }
        else{
            nextPoint = routePoints.elementAt(x)
            x++
        }
            for(j in 0 until numberOfVertices){
                if(nextPoint != Vertices[j].mark) {
                    if(!routePoints.contains(Vertices[j].mark)){
                    val section = nextPoint.plus("-${Vertices[j].mark}")
                    var fd = 0
                    for (f in 0 until numberOfVertices) {
                        if (nextPoint == Vertices[f].mark) {
                            fd = f
                            break
                        }
                    }
                    val weightCalculated = euklidesFormula(Vertices[fd].x, Vertices[j].x, Vertices[fd].y, Vertices[j].y)
                    weights.add(PointCalculated(section, weightCalculated))
                }
                }
            }
                    weights.sortBy { it.weight }
                    val setsize1 = routePoints.size
                    var setsize2 = routePoints.size
                    if(routePoints.size == numberOfVertices){
                        break
                    }
                    while(setsize1 == setsize2){
                            routePoints.add(weights[0].section.substring(2))
                            setsize2 = routePoints.size
                        }
                        route += weights[0].weight
    }
    var lastRoute1 =0
    var lastRoute2 =0
    for(i in 0 until numberOfVertices){
        if(routePoints.elementAt(routePoints.size-1) == Vertices[i].mark){
            lastRoute1 = i
        }
        if(startingPoint == Vertices[i].mark){
            lastRoute2 = i
        }
    }
    val lastRouteWeight = euklidesFormula(Vertices[lastRoute1].x, Vertices[lastRoute2].x, Vertices[lastRoute1].y, Vertices[lastRoute2].y)
    route += lastRouteWeight


    println("Łączna trasa wynosi: ${route.round(2)}")
    for(i in 0 until routePoints.size){
        print("${routePoints.elementAt(i)} -> ")
    }
    print(startingPoint)

}
fun euklidesFormula (x1: Int, x2: Int, y1: Int, y2: Int): Double {
    val firstBracket: Double = (x2-x1).toDouble().pow(2)
    val secondBracket: Double = (y2-y1).toDouble().pow(2)
    val wholeBracket: Double = firstBracket + secondBracket
    return sqrt(wholeBracket)
}
fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return kotlin.math.round(this * multiplier) / multiplier
}

class Point(var mark: String, var x: Int, var y: Int)
class PointCalculated(var section: String, var weight: Double)

/*
a 1 3
b 2 2
c 4 3
d 5 6
e 2 1

a 1 2
b 3 1
c 3 6
d 6 7
e 5 2
*/

