package com.janchodura.primetable.excel.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.janchodura.primetable.excel.Export;
import com.janchodura.primetable.excel.TableWriter;
import com.janchodura.primetable.gui.PrimeNumberTable;
import com.janchodura.primetable.prime.NumberPrime;

public class ExportXls implements Export{
   
   private List<NumberPrime> numberPrimes;
   private Path path;
   
   public ExportXls(final List<NumberPrime> numberPrimes, final Path path){
      
      this.numberPrimes = numberPrimes;
      this.path = path;
   }
   
   public void write() throws FileNotFoundException, IOException {

      Workbook workbook = createWorkbook();
      workbook.write(new FileOutputStream(path.toString()));
   }

   
   private Workbook createWorkbook() {

      Workbook workbook = new XSSFWorkbook();
      Sheet sheet = workbook.createSheet();
      
      TableWriter tableInflater = new TableWriterXls(sheet);
      
      Iterator<NumberPrime> iter = numberPrimes.iterator();
      for (int rows = 0; rows < PrimeNumberTable.TABLE_DIMESION; rows++) { 
         for (int cols = 0; cols < PrimeNumberTable.TABLE_DIMESION; cols++) { 
            
            NumberPrime numberPrime = iter.next();
            tableInflater.setCell(rows, cols, numberPrime);
         }
      }
      
      return workbook;
   }

}
