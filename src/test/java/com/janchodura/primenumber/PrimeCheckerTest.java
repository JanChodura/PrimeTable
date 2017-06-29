package com.janchodura.primenumber;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.janchodura.primetable.prime.PrimeChecker;

@RunWith(Parameterized.class)
public class PrimeCheckerTest {

   private Integer inputNumber;
   private Boolean expectedResult;
   
   public PrimeCheckerTest(Integer inputNumber, Boolean expectedResult){
      
      this.inputNumber = inputNumber;
      this.expectedResult = expectedResult;
   }
   
   /**
    * Tested values are in parameters. Better for testing more values.
    * @return
    */
   @Parameterized.Parameters
   public static Collection<Object[]> primeNumbers() {
      return Arrays.asList(new Object[][] {
         { 1, false },
         { 2, true },
         { 6, false },
         { 19, true },
         { 22, false },
         { 23, true },
         { 37, true },
         { 97, true },
         { 103, true },
         { 111, false },
         { 10001, false },
         { 10007, true }
      });
   }
   
   
   
   
   @Test
   public void testPrimeNumberChecker(){
      
      //Act
      boolean isPrime = PrimeChecker.isPrime(inputNumber);
      
      //Assert
      assertEquals(expectedResult, isPrime);
   }
      
}
