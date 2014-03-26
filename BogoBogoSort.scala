object BogoBogoSort {
    def main(args: Array[String]) = {
        val myArr = Array(2,3,13,53,12,1,34,6,7,23,81,19,4)
        sort(myArr)
        println(myArr.mkString(" "))
    }

    def sort(arr: Array[Int]){
        def swap(i: Int, j: Int){
            val tmp = arr(i)
            arr(i) = arr(j)
            arr(j) = tmp
        }

        val rand = scala.util.Random

        def shuffle(s: Int,e: Int){
            for(num <- 0 until (e - s)){
                var a = rand.nextInt(e - s) + s
                var b = rand.nextInt(e - s) + s
                swap(a, b)
            }
        }


        def bogosort(s: Int, e: Int){
            var i: Int = s
            var flag = true
            //println("Shuffling ")
            shuffle(s, e)
            while (i < e){
                if (arr(i) > arr(i + 1))
                {
                    flag = false
                }
                i += 1
            }
            if( flag && e == arr.length)
            {
                println(arr.mkString(" "))
                println("Sorted!")
            }
            else if( flag )
            {
                println("Sorted: " + e)
                bogosort(s, e + 1)
            }
            else{
                //println("Restarting")
                bogosort(0, 1)
            }
        }
        println(arr.mkString(" "))
        bogosort(0, 1)
    }
}