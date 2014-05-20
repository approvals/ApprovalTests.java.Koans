package org.approvaltests.koans.helpers;

import org.junit.Assert;

import com.spun.util.ObjectUtils;
import com.spun.util.io.FileUtils;

public class FileAssert
{
  public static void verifyContentsIsEqual(String fileContainingExpected, String actual)
  {
    try
    {
      StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
      Class<?> clazz = Class.forName(caller.getClassName());
      String expected = FileUtils.readFromClassPath(clazz, fileContainingExpected).trim();
      Assert.assertEquals(expected, actual);
    }
    catch (Exception e)
    {
      throw ObjectUtils.throwAsError(e);
    }
  }
}
