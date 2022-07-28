package org.approvaltests.koans.helpers;

import com.spun.util.ObjectUtils;
import com.spun.util.io.FileUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileAssert
{
  public static void verifyContentsIsEqual(String fileContainingExpected, String actual)
  {
    try
    {
      StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
      Class<?> clazz = Class.forName(caller.getClassName());
      String expected = FileUtils.readFromClassPath(clazz, fileContainingExpected).trim();
      assertEquals(expected, actual);
    }
    catch (Exception e)
    {
      throw ObjectUtils.throwAsError(e);
    }
  }
}
