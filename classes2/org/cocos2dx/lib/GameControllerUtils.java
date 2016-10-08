package org.cocos2dx.lib;

import java.io.File;
import java.io.FileInputStream;

public class GameControllerUtils
{
  public static void ensureDirectoryExist(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public static String readJsonFile(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return null;
    }
    try
    {
      paramString = new FileInputStream(paramString);
      byte[] arrayOfByte = new byte[paramString.available()];
      paramString.read(arrayOfByte);
      paramString.close();
      paramString = new String(arrayOfByte, "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\GameControllerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */