package com.shipment;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CommonUtilTest {

  @Test
  public void testValidateInput_negative() throws Exception {
    boolean result = CommonUtil.validateZip("zipCode");
    Assert.assertEquals(false, result);
  }

  @Test
  public void testValidateInput_possitive() throws Exception {
    boolean result = CommonUtil.validateZip("52334");
    Assert.assertEquals(true, result);
  }

  @Test
  public void testSortRange() throws Exception {
    List<ZipRangeDTO> input =
        Arrays.asList(new ZipRangeDTO(94133,94133), new ZipRangeDTO(94200,94299), new ZipRangeDTO(94600,94699), new ZipRangeDTO(94700,94789), new ZipRangeDTO(94100,94132), new ZipRangeDTO(94299,94200), new ZipRangeDTO(94133,94139), new ZipRangeDTO(94600,94699));
    List<ZipRangeDTO> output = input;
    CommonUtil.sortZipCodeRangeList(output);
    Assert.assertEquals(input, output);
  }
}
