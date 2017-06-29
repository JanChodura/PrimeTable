package com.janchodura.primetable.gui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class PrimeNumberFrame {
   
   private static final String PRIME_TABLE_NAME = "PrimeTable";
   private static final String LABEL_EXPORT = "Export";
   private static final String LABEL_START = "Čísla od:";
   private static final String BUTTON_EXIT_NAME = "Konec";

   JPanel panel;
   
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
   
   private void addElements(){
      
      addLabelForTextField();
      JTextField startNumberElement = addTextField();
      addExcelButton();
      addExitButton();
      addTable(startNumberElement);
   }

   private void addLabelForTextField() {

      JLabel label = new JLabel(LABEL_START);
      panel.add(label);
   }

   private JTextField addTextField() {

      JTextField startNumberElement = new JTextField();
      panel.add(startNumberElement);
      
      return startNumberElement;
   }

   private void addExcelButton() {

      JButton excelButton = new JButton(LABEL_EXPORT);
      
      excelButton.addActionListener((ActionEvent event) -> {
         System.exit(0);
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

   private void addTable(JTextField startNumberElement) {

      final PrimeNumberTable tableInflater = PrimeNumberTable.inflate();
      panel.add(new JScrollPane(tableInflater.getTable()),  "span, grow");

      startNumberElement.addActionListener((ActionEvent event) -> {
         
         int start = Integer.valueOf(startNumberElement.getText());
         tableInflater.fill(start);
      });
   }
}
