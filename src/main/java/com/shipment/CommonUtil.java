package com.shipment;

import java.util.Collections;
import java.util.List;

public class CommonUtil {
  public static boolean validateZip(String zipCode) {
    try {
      int i = Integer.parseInt(zipCode);
      if (zipCode.length() == 5 && i <= 99999) {
        return true;
      }
    } catch (Exception e) {
      return false;
    }
    return false;
  }

  public static void sortZipCodeRangeList(List<ZipRangeDTO> rangeList) {
    Collections.sort(rangeList, (range1, range2) -> {
      String r1 = "" + range1.getStart();
      String r2 = "" + range2.getStart();
      int comp = r1.compareTo(r2);
      if (comp != 0) {
        return comp;
      } else {
        String x1 = "" + range1.getEnd();
        String x2 = "" + range2.getEnd();
        return x1.compareTo(x2);
      }
    });
  }
}
