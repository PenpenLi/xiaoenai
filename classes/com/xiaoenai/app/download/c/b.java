package com.xiaoenai.app.download.c;

import android.os.Environment;
import android.os.StatFs;
import com.xiaoenai.app.utils.e;
import java.io.File;

public class b
{
  public static final String a = e.a;
  private static final String b = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
  
  public static boolean a()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static long b()
  {
    Object localObject = Environment.getExternalStorageDirectory().toString();
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getAvailableBlocks();
      int i = ((StatFs)localObject).getBlockSize();
      return i * l;
    }
    catch (RuntimeException localRuntimeException) {}
    return 0L;
  }
  
  public static boolean c()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\download\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */