package org.approvaltests.koans.tests;

import static org.junit.Assert.assertTrue;
import org.junit.Assert;

import org.approvaltests.koans.helpers.Koans;

public class KoanUtils
{
  public static void assertKoanReady(Koans koan, String method)
  {
    assertState(koan, method, false);
  }
  
  public static void assertKoan(Koans koan, String method, Object answer)
  {
    assertState(koan, method, false);
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
  private static void assertState(Koans koan, String method, boolean passDesired)
  {
    boolean failed = false;
    try
    {
      koan.getClass().getMethod(method).invoke(koan);
    }
    catch (Throwable e)
    {
      failed = true;
    }
    if (passDesired)
    {
      Assert.assertFalse(String.format("The Method '%s' will not solve", method), failed);
    }
    else
    {
      assertTrue(String.format("The Method '%s' is alread passing", method), failed);
    }
  }
}
