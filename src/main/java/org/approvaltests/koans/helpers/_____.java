package org.approvaltests.koans.helpers;

import org.junit.Assert;

import org.approvaltests.core.ApprovalFailureReporter;

public class _____ implements ApprovalFailureReporter
{
  @Override
  public void report(String received, String approved) throws Exception
  {
    Assert.fail("You need to fill in the blank");
  }
}
