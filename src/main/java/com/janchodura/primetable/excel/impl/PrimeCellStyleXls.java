package com.janchodura.primetable.excel.impl;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Style of cell with prime number.
 * 
 * @author jach
 *
 */
public class PrimeCellStyleXls {
   
   public static CellStyle instanceOf(Workbook workbook){
      
      CellStyle style = workbook.createCellStyle();
      Font font = workbook.createFont();
      font.setColor(IndexedColors.RED.getIndex());
      style.setFont(font);
      
      return style;
   }
}
