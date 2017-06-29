package com.janchodura.primetable.excel.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.janchodura.primetable.excel.TableWriter;
import com.janchodura.primetable.prime.NumberPrime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Writes list of numbers into excel table 
 * @author jach
 *
 */
public class TableWriterXls implements TableWriter {

   private final Logger slf4jLogger = LoggerFactory.getLogger(TableWriterXls.class);

   private Sheet sheet;
   private CellStyle primeStyle;

   public TableWriterXls(Sheet sheet) {

      this.sheet = sheet;
      sheet.createRow(2);
      primeStyle = PrimeCellStyleXls.instanceOf(sheet.getWorkbook());
   }

   /* (non-Javadoc)
    * @see com.janchodura.primetable.excel.impl.TableWriter#setCell(int, int, com.janchodura.primetable.prime.NumberPrime)
    */
   @Override
   public void setCell(int rows, int cols, NumberPrime numberPrime) {

      Row row;
      if (cols == 0) {
         row = sheet.createRow(rows);
      } else {
         row = sheet.getRow(rows);
      }

      Cell cell = row.createCell(cols);

      cell.setCellValue(numberPrime.getValue());
      slf4jLogger.info("coordinates {},{} with value:{}", rows, cols, numberPrime.getValue());

      boolean isPrime = numberPrime.isPrime();
      if (isPrime) {

         cell.setCellStyle(primeStyle);
      }
   }
}
