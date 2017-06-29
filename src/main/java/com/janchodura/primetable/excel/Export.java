package com.janchodura.primetable.excel;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Export {
   
   public void write() throws FileNotFoundException, IOException;
}
