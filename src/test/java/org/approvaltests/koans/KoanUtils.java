package org.approvaltests.koans;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.spun.util.logger.SimpleLogger;
import org.approvaltests.koans.helpers.Koans;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.UseReporter;

public class KoanUtils
{
  public static void assertKoanReady(Koans koan, String method)
  {
    assertState(koan, method, false);
  }
  
  public static void assertKoan(Koans koan, String method, Object answer)
  {
    assertState(koan, method, false);
    assertKoanPassing(koan, method, answer);
  }

  public static void assertKoanPassing(Koans koan, String method, Object answer) {
    setAnswers(koan, answer);
    assertState(koan, method, true);
  }

  private static void setAnswers(Koans koan, Object answer)
  {
    if (answer instanceof String)
    {
      koan.___ = (String) answer;
    }
    if (answer instanceof Integer)
    {
      koan.____ = (Integer) answer;
    }
  }
  
  @UseReporter(JunitReporter.class)
  private static void assertState(Koans koan, String method, boolean passDesired)
  {
    boolean failed = false;
    Throwable throwable = null;
    try
    {
      koan.getClass().getMethod(method).invoke(koan);
    }
    catch (Throwable e)
    {
      failed = true;
      throwable = e.getCause();
    }
    if (passDesired)
    {
      if (failed) {
        SimpleLogger.warning(throwable.toString());
      }
      assertFalse(failed, String.format("The Method '%s' will not solve", method));
    }
    else
    {
      assertTrue(failed, String.format("The Method '%s' is already passing", method));
    }
  }
}
