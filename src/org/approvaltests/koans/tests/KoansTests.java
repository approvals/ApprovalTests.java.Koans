package org.approvaltests.koans.tests;

import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.approvaltests.koans.helpers.Koans;
import org.approvaltests.koans.lesson01.GettingStarted;
import org.junit.Test;

public class KoansTests
{
  @Test
  public void TestLesson1() throws Exception
  {
    assertKoan(new GettingStarted(), "NormalJunitAsserts", "Small String");
    assertKoan(new GettingStarted(), "ApprovalHidesTheExpectation", "This is in the approved file");
    assertKoan(new GettingStarted(), "ApprovalFileName", "GettingStarted.ApprovalFileName");
    assertKoan(new GettingStarted(), "ApprovalFileName", "GettingStarted.ApprovalFileName");
    assertKoanReady(new GettingStarted(), "___");
    assertKoan(new GettingStarted(), "FileNames", "GettingStarted");
    assertKoanReady(new GettingStarted(), "ChangingTheGoldenMaster");
    assertKoan(new GettingStarted(), "VerifyObjects", 150);
    assertKoan(new GettingStarted(), "SometimeYouNeedABetterToString", "smith");
  }
  private void assertKoanReady(Koans koan, String method)
  {
    assertState(koan, method, false);
  }
  public void assertKoan(Koans koan, String method, Object answer)
  {
    assertState(koan, method, false);
    setAnswers(koan, answer);
    assertState(koan, method, true);
  }
  private void setAnswers(Koans koan, Object answer)
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
  private void assertState(Koans koan, String method, boolean passDesired)
  {
    boolean failed = false;
    try
    {
      koan.getClass().getMethod(method, null).invoke(koan, null);
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
