package com.janchodura.primetable;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.janchodura.primetable.gui.PrimeNumberFrame;
import com.janchodura.primetable.gui.PrimeNumberTable;

import net.miginfocom.swing.MigLayout;

public class SwingApplication {
   
   public SwingApplication(){
      
      setLookAndFeel();
   }
   
   public static void main(String[] args) {

      // Schedule a job for the event-dispatching thread:
      // creating and showing this application's GUI.
      javax.swing.SwingUtilities.invokeLater(new Runnable(){

         public void run() {
            
            SwingApplication application = new SwingApplication();
            application.initUI();
         }
      });

   }
   

   private static void setLookAndFeel() {

      try {

         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (UnsupportedLookAndFeelException e) {

         // handle exception
      } catch (ClassNotFoundException e) {
         // handle exception
      } catch (InstantiationException e) {
         // handle exception
      } catch (IllegalAccessException e) {
         // handle exception
      }
   }

   private void initUI() {

      PrimeNumberFrame frame = new PrimeNumberFrame();
      frame.init();
   }

}
