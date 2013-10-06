package org.approvaltests.koans.tests;

import org.approvaltests.koans.lesson01.GettingStarted;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;

public class KoansTests
{
  @Test
  @UseReporter(QuietReporter.class)
  public void TestLesson1() throws Exception
  {
    KoanUtils.assertKoan(new GettingStarted(), "normalJunitAsserts", "Small String");
    KoanUtils.assertKoan(new GettingStarted(), "approvalHidesTheExpectation", "This is in the approved file");
    KoanUtils.assertKoan(new GettingStarted(), "approvalFileName", "GettingStarted.approvalFileName");
    KoanUtils.assertKoan(new GettingStarted(), "approvalFileName", "GettingStarted.approvalFileName");
    KoanUtils.assertKoanReady(new GettingStarted(), "___");
    KoanUtils.assertKoan(new GettingStarted(), "fileNames", "GettingStarted");
    KoanUtils.assertKoan(new GettingStarted(), "seeingFilesSideBySide", "This file is called");
    KoanUtils.assertKoanReady(new GettingStarted(), "changingTheGoldenMaster");
    KoanUtils.assertKoan(new GettingStarted(), "verifyObjects", 150);
    KoanUtils.assertKoan(new GettingStarted(), "sometimeYouNeedABetterToString", "smith");
  }
  @Test
  @UseReporter(QuietReporter.class)
  public void TestLesson2() throws Exception
  {
  }
}
