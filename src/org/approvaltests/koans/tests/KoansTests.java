package org.approvaltests.koans.tests;

import org.approvaltests.koans.lesson01.GettingStarted;
import org.junit.Test;

public class KoansTests
{
  @Test
  public void TestLesson1() throws Exception
  {
    KoanUtils.assertKoan(new GettingStarted(), "NormalJunitAsserts", "Small String");
    KoanUtils.assertKoan(new GettingStarted(), "ApprovalHidesTheExpectation", "This is in the approved file");
    KoanUtils.assertKoan(new GettingStarted(), "ApprovalFileName", "GettingStarted.ApprovalFileName");
    KoanUtils.assertKoan(new GettingStarted(), "ApprovalFileName", "GettingStarted.ApprovalFileName");
    KoanUtils.assertKoanReady(new GettingStarted(), "___");
    KoanUtils.assertKoan(new GettingStarted(), "FileNames", "GettingStarted");
    KoanUtils.assertKoanReady(new GettingStarted(), "ChangingTheGoldenMaster");
    KoanUtils.assertKoan(new GettingStarted(), "VerifyObjects", 150);
    KoanUtils.assertKoan(new GettingStarted(), "SometimeYouNeedABetterToString", "smith");
  }
}
