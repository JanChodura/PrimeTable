package com.janchodura.primetable.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.janchodura.primetable.excel.Export;
import com.janchodura.primetable.excel.impl.ExportXls;

import net.miginfocom.swing.MigLayout;

public class PrimeNumberFrame {

   private static final String PRIME_TABLE_NAME = "PrimeTable";
   private static final String LABEL_EXPORT = "Export";
   private static final String LABEL_START = "Čísla od:";
   private static final String BUTTON_EXIT_NAME = "Konec";

   private static int MAX_VALUE = 10000;

   private JPanel panel;
   private PrimeNumberTable tableInflater;

   public void init() {

      JFrame frame = new JFrame(PRIME_TABLE_NAME);

      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      MigLayout layout = new MigLayout();
      panel = new JPanel(layout);
      
      addElements();
      frame.add(panel);

      frame.pack();
      frame.setVisible(true);
   }

   private void addElements() {

      addLabelForTextField();
      addTextField();
      addExcelButton();
      addExitButton();
      addTable();
   }

   private void addLabelForTextField() {

      JLabel label = new JLabel(LABEL_START);
      panel.add(label);
   }

   private JTextField addTextField() {

      int width = 5;
      JTextField startNumberElement = new JTextField(width);
      startNumberElement.addActionListener(new ActionListener(){

         public void actionPerformed(ActionEvent e) {

            int start = Integer.valueOf(startNumberElement.getText());
            if (Integer.valueOf(start) > MAX_VALUE) {

               startNumberElement.setForeground(Color.RED);
            } else {

               startNumberElement.setForeground(Color.BLACK);
               tableInflater.fillNumbers(start);
            }
         }

      });

      panel.add(startNumberElement);

      return startNumberElement;
   }

   private void addExcelButton() {

      JButton excelButton = new JButton(LABEL_EXPORT);

      excelButton.addActionListener((ActionEvent event) -> {

         JFileChooser c = new JFileChooser();
         int dialog = c.showSaveDialog(PrimeNumberFrame.this.panel);

         if (dialog == JFileChooser.APPROVE_OPTION) {

            String fileName = c.getSelectedFile().getName();
            String dir = c.getCurrentDirectory().toString() + File.separator;
            Path path = Paths.get(dir + fileName);

            try {

               Export export = new ExportXls(tableInflater.getNumberPrimes(), path);
               export.write();

            } catch (FileNotFoundException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }

      });

      panel.add(excelButton);
   }

   private void addExitButton() {

      JButton quitButton = new JButton(BUTTON_EXIT_NAME);

      quitButton.addActionListener((ActionEvent event) -> {
         System.exit(0);
      });
      panel.add(quitButton, "wrap");
   }

   private void addTable() {

      tableInflater = PrimeNumberTable.inflate();
      panel.add(new JScrollPane(tableInflater.getTable()), "span, grow");
   }
}
