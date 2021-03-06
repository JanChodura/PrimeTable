package com.janchodura.primetable.prime;

public class PrimeChecker {

   /**
    * Checks if number is prime or not.
    * 
    * @param n
    * @return
    */
   public static boolean isPrime(int n) {

      if (n < 2) {
         return false;
      }

      if (n == 2 || n == 3) {
         return true;
      }

      if (n % 2 == 0 || n % 3 == 0) {
         return false;
      }

      long sqrtN = (long) Math.sqrt(n) + 1;

      for (int i = 6; i <= sqrtN; i += 6) {

         if (n % (i - 1) == 0 || n % (i + 1) == 0) {

            return false;
         }
      }

      return true;
   }

}
