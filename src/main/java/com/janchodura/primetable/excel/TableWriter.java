package com.janchodura.primetable.excel;

import com.janchodura.primetable.prime.NumberPrime;

public interface TableWriter {

   void setCell(int rows, int cols, NumberPrime numberPrime);

}