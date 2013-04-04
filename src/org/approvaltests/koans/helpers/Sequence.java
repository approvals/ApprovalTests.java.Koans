package org.approvaltests.koans.helpers;

import java.text.MessageFormat;

import org.lambda.functions.Function1;

public class Sequence implements Function1<Integer, String>
{
  @Override
  public String call(Integer i)
  {
    int n1 = 1;
    int n2 = 1;
    for (int j = 2; j <= i; j++)
    {
      int n3 = n1 + n2;
      n1 = n2;
      n2 = n3;
    }
    return MessageFormat.format("#{0} => {1}", i, n2);
  }
}
