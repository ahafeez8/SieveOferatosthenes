
object erato {
  def  main(args: Array[String]){
    val n = 60
    val p = 2
    //create a list of p till n
   val li = List.range(p, n + 1);
    //call SieveErato to get primes
    val updatedList = SieveErato(li, n, p)
    //print the updated list with primes in range
    updatedList.foreach(println)

  }
  
 def SieveErato(li:List[Int], n:Int, p:Int):List[Int]=
 {
   //check if initial p is greater than squareroot of n
   val upperboundsqrt = math.sqrt(n)
   //if so, return list as is
   if(p > upperboundsqrt)
      li
    //if not
    else {
      //iterate over the multiples of p by counting
      //to n from 2p in increments of p
      val primes = getprimes(li, n, p, 2);
      //iterate over for next p if any number is greater than present p
      SieveErato(primes, n, primes(primes.indexOf(p)+1));
    }
  }
  def getprimes(li:List[Int], n:Int, p:Int, it:Int):List[Int]=
  {
    //check if iterator is greater than n / p
    if(it > n/p)
      li
    else {
      //filter for iterator * p
      val primes = li.filter(_ != it * p);
      getprimes(primes, n, p, it+1);
    }
  }
}
