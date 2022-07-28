package org.approvaltests.koans.lesson04;

import org.approvaltests.ReporterFactory;
import org.approvaltests.core.ApprovalFailureReporter;
import org.approvaltests.koans.helpers.Koans;
import org.approvaltests.koans.helpers._____;
import org.approvaltests.reporters.AlwaysWorkingReporter;
import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.FileLauncherReporter;
import org.approvaltests.reporters.FirstWorkingReporter;
import org.approvaltests.reporters.ImageWebReporter;
import org.approvaltests.reporters.MultiReporter;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.approvaltests.reporters.windows.TortoiseImageDiffReporter;
import org.junit.jupiter.api.Test;

import static com.spun.util.Asserts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * How to do Koans:
 * Step 1: Press the Run Button (Place cursor on the Method name to run a single method)
 * PC: Ctrl+F11
 * Mac: Command+fn+F11
 * Step 2: Read the name of the Method that Failed
 * Step 3: Fill in the blank (___) to make it pass
 * Step 4: Repeat Until Enlightenment
 * Do not change anything except the blank (___)
 */
@UseReporter(QuietReporter.class)
public class UsingReporters extends Koans
{
  @Test
  @UseReporter(_____.class)
  public void ConfiguringTheFileLauncherReporter() throws Exception
  {
    ApprovalFailureReporter reporter = ReporterFactory.get();
    assertReport(reporter, FileLauncherReporter.class);
  }
  @Test
  public void ConfiguringAClassLevelDefault() throws Exception
  {
    ApprovalFailureReporter reporter = ReporterFactory.get();
    assertReport(reporter, _____.class);
  }
  @Test
  @UseReporter({ClipboardReporter.class, ImageWebReporter.class, TortoiseImageDiffReporter.class})
  public void ConfiguringMultipleReporters() throws Exception
  {
    ApprovalFailureReporter reporter = ReporterFactory.get();
    MultiReporter multi = (MultiReporter) reporter;
    ApprovalFailureReporter second = multi.getReporters()[1];
    assertTrue(second.getClass().getName(), second instanceof _____);
  }
  @Test
  @UseReporter(FileLauncherReporter.class)
  public void UsingTextReportersForInsight() throws Exception
  {
    if (!decode("=fikpKnf").equals(____))
    {
      ApprovalFailureReporter reporter = ReporterFactory.get();
      reporter.report(getPath("Insight.txt"), "");
      fail("Please fill in the blank");
    }
  }
  @Test
  @UseReporter(ImageWebReporter.class)
  public void UsingImageForInsight() throws Exception
  {
    String whatWasTheOldColor = ___;
    if (!decode("Ycl\\").equals(whatWasTheOldColor.toLowerCase()))
    {
      ApprovalFailureReporter reporter = ReporterFactory.get();
      reporter.report(getPath("NewImage.png"), getPath("OldImage.png"));
      fail("Please fill in the blank");
    }
  }
  private void assertReport(ApprovalFailureReporter reporter, Class<?> expected)
  {
    FirstWorkingReporter first = (FirstWorkingReporter) reporter;
    AlwaysWorkingReporter actual = (AlwaysWorkingReporter) first.getReporters()[1];
    assertEquals("Please Fill In the Blank ____", expected.getName(),
        actual.getWrapped().getClass().getName());
  }
}
