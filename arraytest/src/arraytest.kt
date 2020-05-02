import java.util.Random
val random = Random()
fun rand(from: Int, to: Int) : Int {
    return random.nextInt(to - from) + from
}
fun randomized(array: Array<Int>): Array<Int>{
    var result:Array<Int> = arrayOf()
    for (i in 0 until array.size){
        //put a random item into the result array
        result[i]=array[rand(i,array.size)]
    }
    return result
}
val randomArray= arrayOf(1,2,3,4,5)
val newArray2=randomized(randomArray)
println(newArray2.joinToString())