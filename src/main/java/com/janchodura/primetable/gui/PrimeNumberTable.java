package com.janchodura.primetable.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.janchodura.primetable.prime.NumberPrime;
import com.janchodura.primetable.prime.NumberPrime.Builder;
import com.janchodura.primetable.prime.PrimeChecker;

/**
 * Table of integers with styles for prime numbers.
 * 
 * @author jach
 *
 */
public class PrimeNumberTable {

   public static int TABLE_DIMESION = 10;

   private JTable table;
   private DefaultTableModel model;
   private List<NumberPrime> numberPrimes;

   private PrimeNumberTable() {

   }

   public static PrimeNumberTable inflate() {

      PrimeNumberTable inflater = new PrimeNumberTable();
      inflater.buildTableModel();
      inflater.table = new JTable(inflater.model);
      inflater.numberPrimes = new ArrayList<NumberPrime>();
      
      return inflater;
   }

   private void buildTableModel() {

      Vector<String> columnNames = new Vector<String>();
      Vector<Vector<Object>> data = new Vector<Vector<Object>>();
      for (int column = 1; column <= TABLE_DIMESION; column++) {
         columnNames.add(("" + column));
      }

      for (int row = 1; row <= TABLE_DIMESION; row++) {

         Vector<Object> vector = new Vector<Object>();

         for (int column = 1; column <= TABLE_DIMESION; column++) {

            vector.add("");
         }

         data.add(vector);
      }

      model = new DefaultTableModel(data, columnNames){

         @Override
         public boolean isCellEditable(int row, int column) {

            return false;
         }
      };

   }

   public void fillNumbers(int start) {

      addCellRenderer();

      int number = start;
      for (int row = 0; row < TABLE_DIMESION; row++) {

         for (int column = 0; column < TABLE_DIMESION; column++) {

            model.setValueAt(number, row, column);
            number++;

         }
      }

   }

   private void addCellRenderer() {

      TableCellRenderer renderer = new TableCellRenderer();

      for (int column = 0; column < TABLE_DIMESION; column++) {

         TableColumn tm = table.getColumnModel().getColumn(column);
         tm.setCellRenderer(renderer);
      }
   }

   public JTable getTable() {

      return table;
   }

   
   public List<NumberPrime> getNumberPrimes() {
   
      return numberPrimes;
   }

   private class TableCellRenderer extends DefaultTableCellRenderer {

      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

         JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

         Integer number = (Integer) value;
         Builder numberPrimeBuilder = new NumberPrime.Builder().value(number);
         
         if (PrimeChecker.isPrime(number)) {
            
            numberPrimeBuilder.isPrime(true);
            renderPrimeCell(cell);
         } else {

            renderNonPrimeCell(cell);
         }
         
         NumberPrime numberPrime = numberPrimeBuilder.build();
         numberPrimes.add(numberPrime);
         
         return cell;
      }

      private void renderPrimeCell(JLabel cell) {

         Font cellFont = cell.getFont();
         cell.setForeground(Color.RED);
         cell.setFont(cellFont.deriveFont(Font.BOLD));
      }

      private void renderNonPrimeCell(JLabel cell) {

         Font cellFont = cell.getFont();
         cell.setForeground(Color.BLACK);
         cell.setFont(cellFont.deriveFont(Font.PLAIN));
      }

   }
}