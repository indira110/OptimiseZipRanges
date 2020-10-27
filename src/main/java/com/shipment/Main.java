package com.shipment;

import static com.shipment.CommonConstants.INPUT_FILE_NAME;
import static com.shipment.CommonConstants.OUTPUT_FILE_NAME;
import static com.shipment.CommonUtil.sortZipCodeRangeList;
import static com.shipment.WriteCSVFile.writeOutputToCSV;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String ar[]) {
    Main main = new Main();
    ArrayList<ZipRangeDTO> result = main.optimiseZipCodes(INPUT_FILE_NAME, OUTPUT_FILE_NAME);
  }


  public ArrayList<ZipRangeDTO> optimiseZipCodes(String inputFile, String outputFile) {
    ArrayList<ZipRangeDTO> mergedRangeList = new ArrayList<ZipRangeDTO>();

    // Reading input Zip Code Range from the file.
    System.out.println("************* Reading from input file *****" + inputFile);
    ArrayList<ZipRangeDTO> rangeList = ReadCSVFile.readCSVFile(inputFile);
    System.out.println("************* Reading from input file completed, output is " + rangeList);
    // Sort and Merge the input as per the given requirement.
    mergedRangeList = mergeZipCodeRange(rangeList);

    System.out.println("Writing to file " + outputFile);
    writeOutputToCSV(mergedRangeList, outputFile);

    System.out.println("task Completed.");

    return mergedRangeList;
  }

  public ArrayList<ZipRangeDTO> mergeZipCodeRange(List<ZipRangeDTO> rangeList) {
    int rangeListSize = rangeList.size();
    ArrayList<ZipRangeDTO> mergedRangeList = new ArrayList<ZipRangeDTO>();
    if (rangeListSize > 0) {
      //Sort the input
      sortZipCodeRangeList(rangeList);

      ZipRangeDTO tmp = rangeList.get(0);


      for (int i = 0; i < rangeListSize; i++) {
        if (tmp.getEnd() + 1 == rangeList.get(i).getStart()
            || tmp.getEnd() >= rangeList.get(i).getStart()) {


          if (tmp.getEnd() < rangeList.get(i).getEnd()
              && tmp.getStart() != rangeList.get(i).getStart()) {
            tmp.setEnd(rangeList.get(i).getEnd());
          }

        } else {
          mergedRangeList.add(tmp);
          tmp = rangeList.get(i);
        }
      }
      mergedRangeList.add(tmp);
    }
    return mergedRangeList;
  }
}
