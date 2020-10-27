package com.shipment;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {
  Main main = new Main();


  @Test
  public void testOptimiseZipCodes() throws Exception {
    try {
      ArrayList<ZipRangeDTO> result = main.optimiseZipCodes("/input.csv", "outputFile");
      Assert.assertNotNull(result);
    }catch (Exception e){

    }
  }

  @Test
  public void testMergeRange() throws Exception {
    List<ZipRangeDTO> expectedOutput = new ArrayList<>();
    expectedOutput.add(new ZipRangeDTO(94100,94139));
    expectedOutput.add(new ZipRangeDTO(94200,94299));
    expectedOutput.add(new ZipRangeDTO(94600,94789));
    List<ZipRangeDTO> input =
        Arrays.asList(new ZipRangeDTO(94133, 94133), new ZipRangeDTO(94200, 94299), new ZipRangeDTO(94600, 94699),
            new ZipRangeDTO(94700, 94789), new ZipRangeDTO(94100, 94132), new ZipRangeDTO(94299, 94200),
            new ZipRangeDTO(94133, 94139), new ZipRangeDTO(94600, 94699));

    List<ZipRangeDTO> result = main.mergeZipCodeRange(input);
    Assert.assertEquals(expectedOutput.size(), result.size());
    for(int i=0;i< expectedOutput.size();i++){
      Assert.assertEquals(expectedOutput.get(i).toString(), result.get(i).toString());
    }
  }
}
