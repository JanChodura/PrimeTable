package com.janchodura.primetable.prime;

import java.util.ArrayList;
import java.util.List;

public class Primes {

   private static int maxStart = 10000;

   public static List<Integer> retrieve(int start, int interval) {

      if (start > maxStart) {
         throw new StackOverflowError("start=" + start + " is higher than " + maxStart);
      }

      List<Integer> primeNumbers = new ArrayList<Integer>();
      int lastNumber = start + interval - 1;

      for (int i = start; i <= lastNumber; i++) {
         if (Primes.isPrime(i)) {

            primeNumbers.add(i);
         }
      }

      return primeNumbers;
   }

   private static boolean isPrime(int n) {

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
