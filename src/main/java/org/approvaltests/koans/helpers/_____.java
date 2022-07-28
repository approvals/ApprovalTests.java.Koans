package org.approvaltests.koans.helpers;

import org.approvaltests.core.ApprovalFailureReporter;

import static org.junit.jupiter.api.Assertions.fail;

public class _____ implements ApprovalFailureReporter
{
  @Override
  public void report(String received, String approved) 
  {
    fail("You need to fill in the blank");
  }
}
