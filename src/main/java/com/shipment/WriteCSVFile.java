package com.shipment;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class WriteCSVFile {
  public static void writeOutputToCSV(ArrayList<ZipRangeDTO> mergedRangeList, String outputFile) {
    FileWriter writer = null;
    //
    try {
      OutputStream os =
          new FileOutputStream("D:\\work\\paysafe\\workspace\\OptimiseZipRanges\\src\\main\\resources\\" + outputFile);

      writer = new FileWriter("src\\main\\resources\\" + outputFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (mergedRangeList.size() > 0) {
      for (ZipRangeDTO range : mergedRangeList) {
        try {
          writer.write(range.toString() + "\n");
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    try {
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
