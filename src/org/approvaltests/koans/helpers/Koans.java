package org.approvaltests.koans.helpers;

import java.io.File;

import com.spun.util.ClassUtils;

public class Koans
{
  public String ___  = "Please fill in the blank";
  public int    ____ = 0;
  
  public String decode(String string)
  {
    int offshift = 9;
    return push(string, offshift);
  }
  
  public String push(String string, int offshift)
  {
    StringBuffer b = new StringBuffer();
    for (char c : string.toCharArray())
    {
      b.append((char) (c + offshift));
    }
    return b.toString();
  }
  
  public String getPath(String file)
  {
    return ClassUtils.getSourceDirectory(getClass()).getAbsolutePath() + File.separator + file;
  }
}
