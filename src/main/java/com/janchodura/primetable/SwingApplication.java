package com.janchodura.primetable;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.janchodura.primetable.gui.PrimeNumberFrame;

/**
 * Main app class. 
 * @author jach
 *
 */
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
   
   /**
    * Creates frame with elements and behaviour.
    */
   private void initUI() {

      PrimeNumberFrame frame = new PrimeNumberFrame();
      frame.init();
   }

}
