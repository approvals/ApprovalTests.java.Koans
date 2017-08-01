package org.approvaltests.koans.tests;

import org.approvaltests.koans.lesson01.GettingStarted;
import org.approvaltests.koans.lesson02.Collections;
import org.approvaltests.koans.lesson04.UsingReporters;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;

public class KoansTests
{
  @Test
  @UseReporter(QuietReporter.class)
  public void testLesson1()
  {
    assertLesson1("normalJunitAsserts", "Small String");
    assertLesson1("assertAgainstFileContents", "Small String");
    assertLesson1("usingAutomaticFileNames", "Prefer Convention over Configuration");
    assertLesson1("automaticallyGeneratedNames", "GettingStarted.automaticallyGeneratedNames");
    assertLesson1("verifyBiggerText", 189);
    assertLesson1("approvalsUsesThisFileNameConvention", "This is in the approved file");
    assertLesson1("fileNames", "GettingStarted");
    assertLesson1("verifyObjects", 150);
    assertLesson1("sometimeYouNeedABetterToString", "cobb");
    // KoanUtils.assertKoan(new GettingStarted(), "seeingFilesSideBySide", "This file is called");
    KoanUtils.assertKoanReady(new GettingStarted(), "___");
    KoanUtils.assertKoanReady(new GettingStarted(), "changingTheGoldenMaster");
  }
  private void assertLesson1(String name, Object answer)
  {
    KoanUtils.assertKoan(new GettingStarted(), name, answer);
  }
  @Test
  @UseReporter(QuietReporter.class)
  public void testLesson2()
  {
    assertLesson2("simpleArrays", "Java");
    assertLesson2("listsWorkTheSameAsArrays", "Collections");
    assertLesson2("mapsAreSortedBeforeDisplay", "L");
    assertLesson2("theUseOfTheLabel", "TV Show");
    assertLesson2("approvalHelpShowWhenThingsHaveBeenRemoved", "Mr. Green");
    KoanUtils.assertKoanReady(new Collections(), "approvalHelpShowWhenThingsHaveBeenAdded");
    assertLesson2("headersHelpExplainTheContextWhenThingsAreConfusing", "Numbers in the Fibonacci sequence");
    assertLesson2("transformingArraysManually", 5);
    KoanUtils.assertKoanReady(new Collections(), "transformingArraysWithFunctions");
    KoanUtils.assertKoanReady(new Collections(), "transformingArraysWithLambdas");
  }
  private void assertLesson2(String name, Object answer)
  {
    KoanUtils.assertKoan(new Collections(), name, answer);
  }
  @Test
  @UseReporter(QuietReporter.class)
  public void testLesson3()
  {
    // unsure how to test this yet
  }
  @Test
  @UseReporter(QuietReporter.class)
  public void testLesson4()
  {
    KoanUtils.assertKoanReady(new UsingReporters(), "ConfiguringTheFileLauncherReporter");
    // unsure how to test this yet
  }
}
