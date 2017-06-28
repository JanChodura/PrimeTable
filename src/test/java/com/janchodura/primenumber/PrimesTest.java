package com.janchodura.primenumber;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.janchodura.primetable.prime.Primes;

public class PrimesTest {

   @Before
   public void initialize(){
      
   }
   
   
   @Test
   public void simpleTest(){
      
      //Arrange
      int start=0;
      int interval = 8;
      
      //Act
      List<Integer> primes = Primes.retrieve(start, interval);
      
      
      //Assert
      List<Integer> expectedList = Arrays.asList(new Integer[]{2,3,5,7});
      assertEquals(expectedList, primes);
   }
   
   @Test
   public void simpleBothSidesLimitedTest(){
      
      //Arrange
      int start=2;
      int interval = 6;
      
      //Act
      List<Integer> primes = Primes.retrieve(start, interval);
      
      
      //Assert
      List<Integer> expectedList = Arrays.asList(new Integer[]{2,3,5,7});
      assertEquals(expectedList, primes);
   }
   
   @Test
   public void fullSimpleTest(){
      
      //Arrange
      int start=0;
      int interval = 100;
      
      //Act
      List<Integer> primes = Primes.retrieve(start, interval);
      
      
      //Assert
      List<Integer> expectedList = Arrays.asList(new Integer[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97});
      assertEquals(expectedList, primes);
   }
   
   @Test(expected = StackOverflowError.class)
   public void tooBigStartNumberTest(){
      
      //Arrange
      int start=10001;
      int interval = 1;
      
      //Act
      List<Integer> primes = Primes.retrieve(start, interval);
      
      
      //Assert
      
   }
   
}
