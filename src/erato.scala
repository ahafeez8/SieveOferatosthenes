
object erato {
  def  main(args: Array[String]){
    val n = 60
    val p = 2
   val li = List.range(p, n + 1);
    val updatedList = SieveErato(li, n, p)
    updatedList.foreach(println)

  }
  
 def SieveErato(li:List[Int], n:Int, p:Int):List[Int]=
 {
   val upperboundsqrt = math.sqrt(n)
   if(p > upperboundsqrt)
      li
    else {
      val primes = getprimes(li, n, p, 2);
      SieveErato(primes, n, primes(primes.indexOf(p)+1));
    }
  }
  def getprimes(li:List[Int], n:Int, p:Int, it:Int):List[Int]=
  {
    if(it > n/p)
      li
    else {
      val primes = li.filter(_ != it * p);
      getprimes(primes, n, p, it+1);
    }
  }
}
