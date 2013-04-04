package org.approvaltests.koans.lesson04;

import java.io.File;

import org.approvaltests.ReporterFactory;
import org.approvaltests.core.ApprovalFailureReporter;
import org.approvaltests.koans.helpers.Koans;
import org.approvaltests.koans.helpers._____;
import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.FileLauncherReporter;
import org.approvaltests.reporters.ImageWebReporter;
import org.approvaltests.reporters.MultiReporter;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.approvaltests.reporters.windows.TortoiseImageDiffReporter;
import org.junit.Assert;
import org.junit.Test;

import com.spun.util.ClassUtils;

@UseReporter(QuietReporter.class)
public class UsingReporters extends Koans
{
  @Test
  @UseReporter(_____.class)
  public void ConfiguringTheFileLauncherReporter() throws Exception
  {
    ApprovalFailureReporter reporter = ReporterFactory.getFromAnnotation();
    Assert.assertTrue("Please fill in the blank", reporter instanceof FileLauncherReporter);
  }
  @Test
  public void ConfiguringAClassLevelDefault() throws Exception
  {
    ApprovalFailureReporter reporter = ReporterFactory.getFromAnnotation();
    Assert.assertTrue(reporter.getClass().getName(), reporter instanceof _____);
  }
  @Test
  @UseReporter({ClipboardReporter.class, ImageWebReporter.class, TortoiseImageDiffReporter.class})
  public void ConfiguringMultipleReporters() throws Exception
  {
    ApprovalFailureReporter reporter = ReporterFactory.getFromAnnotation();
    MultiReporter multi = (MultiReporter) reporter;
    ApprovalFailureReporter second = multi.getReporters()[1];
    Assert.assertTrue(second.getClass().getName(), second instanceof _____);
  }
  @Test
  @UseReporter(FileLauncherReporter.class)
  public void UsingTextReportersForInsight() throws Exception
  {
    if (!decode("=fikpKnf").equals(____))
    {
      ApprovalFailureReporter reporter = ReporterFactory.getFromAnnotation();
      reporter.report(
          ClassUtils.getSourceDirectory(getClass()).getAbsolutePath() + File.separator + "Insight.txt", "");
    }
  }
  @Test
  @UseReporter(FileLauncherReporter.class)
  public void UsingImageForInsight() throws Exception
  {
    String whatWasTheOldColor = ___;
    if (!decode("=fikpKnf").equals(____))
    {
      ApprovalFailureReporter reporter = ReporterFactory.getFromAnnotation();
      reporter.report("./Insight.txt", null);
    }
  }
  @Test
  public void testName() throws Exception
  {
    String encoded = push("blue", -9);
    System.out.println(encoded);
    System.out.println(decode(encoded));
  }
  private String decode(String string)
  {
    int offshift = 9;
    return push(string, offshift);
  }
  public String push(String string, int offshift)
  {
    StringBuffer b = new StringBuffer();
    for (char c : string.toCharArray())
    {
      b.append((char) ((int) c + (int) offshift));
    }
    return b.toString();
  }
}
