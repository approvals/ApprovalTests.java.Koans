package org.approvaltests.koans.lesson01;

import java.awt.Rectangle;

import junit.framework.Assert;

import org.approvaltests.Approvals;
import org.approvaltests.koans.helpers.Koans;
import org.approvaltests.koans.helpers.Person;
import org.approvaltests.namer.ApprovalNamer;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;

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
@UseReporter(JunitReporter.class)
public class GettingStarted extends Koans
{
  @Test
  public void normalJunitAsserts()
  {
    Assert.assertEquals("Small String", ___);
  }
  @Test
  public void approvalHidesTheExpectation() throws Exception
  {
    Approvals.verify(___);
    // Hint: If you double click the 1st line of the Failure Trace a diff tool will open
  }
  @Test
  public void approvalFileName() throws Exception
  {
    ApprovalNamer namer = Approvals.createApprovalNamer();
    Assert.assertEquals(namer.getApprovalName(), ___);
  }
  @Test
  public void ___() throws Exception
  {
    ApprovalNamer namer = Approvals.createApprovalNamer();
    Assert.assertEquals("GettingStarted.UsesMethodName", namer.getApprovalName());
  }
  @Test
  public void fileNames() throws Exception
  {
    ApprovalNamer namer = Approvals.createApprovalNamer();
    String className = ___;
    String methodName = "fileNames";
    String approvalName = className + "." + methodName;
    Assert.assertEquals(namer.getApprovalName(), approvalName);
  }
  @Test
  @UseReporter(DiffReporter.class)
  public void seeingFilesSideBySide() throws Exception
  {
    ApprovalNamer namer = Approvals.createApprovalNamer();
    Approvals.verify(___ + "\r\n" + namer.getApprovalName());
  }
  @Test
  public void changingTheGoldenMaster() throws Exception
  {
    Approvals.verify("This is the golden master");
  }
  @Test
  public void verifyObjects() throws Exception
  {
    Rectangle r = new Rectangle();
    r.width = 40;
    r.height = 100;
    r.x = ____;
    r.y = 200;
    Approvals.verify(r);
  }
  @Test
  public void sometimeYouNeedABetterToString() throws Exception
  {
    Person p = new Person("jane", "smith", true, 38);
    String format = "Person\n  FirstName:%s\n  LastName:%s\n  Sex:%s\n  Age:%s\n";
    String custom = String.format(format, p.getFirstName(), ___, p.isMale() ? "Male" : "Female", p.getAge());
    Approvals.verify(custom);
  }
}
