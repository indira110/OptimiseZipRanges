package com.shipment;

import static com.shipment.CommonUtil.validateZip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadCSVFile {
  public static ArrayList<ZipRangeDTO> readCSVFile(String inputFile) {
    ArrayList<ZipRangeDTO> rangeList = new ArrayList<ZipRangeDTO>();
    BufferedReader br = null;

    String currentLine;
    try {
      br = new BufferedReader(new InputStreamReader(ReadCSVFile.class.getResourceAsStream(inputFile)));
      int start, end = 0;
      try {
        while ((currentLine = br.readLine()) != null) {
          String[] zipCodes = currentLine.split(CommonConstants.CSV_SEPARATOR);
          if (validateZip(zipCodes[0]) && validateZip(zipCodes[1])) {
            start = Integer.parseInt(zipCodes[0]);
            end = Integer.parseInt(zipCodes[1]);
            ZipRangeDTO range = new ZipRangeDTO();

            if ( start<= end)
              range = new ZipRangeDTO(start, end);
            else
              range = new ZipRangeDTO(start, end);

            rangeList.add(range);
          }
        }
        br.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return rangeList;
  }
}
