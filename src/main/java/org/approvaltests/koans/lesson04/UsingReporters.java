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
  public void configuringTheFileLauncherReporter() throws Exception
  {
    ApprovalFailureReporter reporter = getReporter();
    assertReporter(reporter, FileLauncherReporter.class);
  }



  @Test
  public void configuringAClassLevelDefault() throws Exception
  {
    ApprovalFailureReporter reporter = getReporter();
    assertReporter(reporter, _____.class);
  }
  @Test
  @UseReporter({ClipboardReporter.class, ImageWebReporter.class, TortoiseImageDiffReporter.class})
  public void configuringMultipleReporters() throws Exception
  {
    MultiReporter multi = (MultiReporter) getReporter();
    ApprovalFailureReporter second = multi.getReporters()[1];
    assertReporter(second, _____.class);
  }
  @Test
  @UseReporter(FileLauncherReporter.class)
  public void usingTextReportersForInsight() throws Exception
  {
    if (!decode("=fikpKnf").equals(___))
    {
      ApprovalFailureReporter reporter = ReporterFactory.get();
      reporter.report(getPath("Insight.txt"), "");
      fail("Please fill in the blank");
    }
  }
  @Test
  @UseReporter(ImageWebReporter.class)
  public void usingImageForInsight() throws Exception
  {
    String whatWasTheOldColor = ___;
    if (!decode("Ycl\\").equals(whatWasTheOldColor.toLowerCase()))
    {
      ApprovalFailureReporter reporter = ReporterFactory.get();
      reporter.report(getPath("NewImage.png"), getPath("OldImage.png"));
      fail("Please fill in the blank");
    }
  }


}
