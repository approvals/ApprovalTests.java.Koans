package org.approvaltests.koans.helpers;

import java.io.File;

import com.spun.util.ClassUtils;
import org.approvaltests.ReporterFactory;
import org.approvaltests.core.ApprovalFailureReporter;
import org.approvaltests.reporters.AlwaysWorkingReporter;
import org.approvaltests.reporters.FirstWorkingReporter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Koans
{
  public String ___  = "Please fill in the blank";
  public int    ____ = 0;
  
  public String decode(String string)
  {
    int offshift = 9;
    return push(string, offshift);
  }
  
  public String push(String string, int offshift)
  {
    StringBuffer b = new StringBuffer();
    for (char c : string.toCharArray())
    {
      b.append((char) (c + offshift));
    }
    return b.toString();
  }
  
  public String getPath(String file)
  {
    return ClassUtils.getSourceDirectory(getClass()).getAbsolutePath() + File.separator + file;
  }
  public static ApprovalFailureReporter getReporter() {
    FirstWorkingReporter first = (FirstWorkingReporter) ReporterFactory.get();
    ApprovalFailureReporter reporter = first.getReporters()[1];
    if (reporter instanceof AlwaysWorkingReporter){
      reporter = ((AlwaysWorkingReporter) reporter).getWrapped();
    }
    return reporter;

  }
  public static  void assertReporter(ApprovalFailureReporter actual, Class<?> expected)
  {
    assertEquals(expected.getName(), actual.getClass().getName());
  }
}
