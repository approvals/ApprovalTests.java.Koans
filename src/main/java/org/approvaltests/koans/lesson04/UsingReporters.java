package org.approvaltests.koans.lesson04;

import org.approvaltests.ReporterFactory;
import org.approvaltests.core.ApprovalFailureReporter;
import org.approvaltests.koans.helpers.Koans;
import org.approvaltests.koans.helpers._____;
import org.approvaltests.reporters.*;
import org.approvaltests.reporters.windows.TortoiseImageDiffReporter;
import org.junit.jupiter.api.Test;

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
    ApprovalFailureReporter reporter = getReporter();
    assertReporter(reporter, FileLauncherReporter.class);
  }



  @Test
  public void ConfiguringAClassLevelDefault() throws Exception
  {
    ApprovalFailureReporter reporter = getReporter();
    assertReporter(reporter, _____.class);
  }
  @Test
  @UseReporter({ClipboardReporter.class, ImageWebReporter.class, TortoiseImageDiffReporter.class})
  public void ConfiguringMultipleReporters() throws Exception
  {
    MultiReporter multi = (MultiReporter) getReporter();
    ApprovalFailureReporter second = multi.getReporters()[1];
    assertReporter(second, _____.class);
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

  private ApprovalFailureReporter getReporter() {
    FirstWorkingReporter first = (FirstWorkingReporter) ReporterFactory.get();
    ApprovalFailureReporter reporter = first.getReporters()[1];
    if (reporter instanceof AlwaysWorkingReporter){
      reporter = ((AlwaysWorkingReporter) reporter).getWrapped();
    }
    return reporter;

  }
  private void assertReporter(ApprovalFailureReporter actual, Class<?> expected)
  {
     assertEquals(expected.getName(), actual.getClass().getName());
  }
}
