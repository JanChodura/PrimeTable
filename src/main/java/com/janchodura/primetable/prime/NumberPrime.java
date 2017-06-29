package com.janchodura.primetable.prime;

/**
 * Number with isPrime flag.
 * 
 * @author jach
 * 
 *@see PrimeChecker
 */
public class NumberPrime {

   private int value;
   private boolean isPrime;

   public static class Builder {

      private int value;
      private boolean isPrime = false;

      public Builder value(int value) {

         this.value = value;
         return this;
      }

      public Builder isPrime(boolean isPrime) {

         this.isPrime = isPrime;
         return this;
      }

      public NumberPrime build() {

         return new NumberPrime(this);
      }
   }

   private NumberPrime(Builder builder) {

      value = builder.value;
      isPrime = builder.isPrime;
   }

   public int getValue() {

      return value;
   }

   public boolean isPrime() {

      return isPrime;
   }

   @Override
   public String toString() {

      return "[" + value + ":" + isPrime + "]";
   }

   @Override
   public boolean equals(Object object) {

      if (object == null)
         return false;
      if ((object instanceof NumberPrime) == false)
         return false;

      NumberPrime numberPrime = (NumberPrime) object;
      return (this.value == numberPrime.getValue()) && (this.isPrime == numberPrime.isPrime());
   }
   

   @Override
   public int hashCode(){
      
      int result = 17;
      result = 31*result + value;
      result = 31*result + (isPrime? 0 : 1);
      
      return result;
   }
}
