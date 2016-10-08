package com.baidu.location;

import java.io.File;
import java.io.RandomAccessFile;

class e
{
  static e jdField_if;
  int a = 20;
  int jdField_do = 0;
  int jdField_for = 3164;
  String jdField_int = "firll.dat";
  
  private long a(int paramInt)
  {
    Object localObject = c.jdMethod_goto();
    if (localObject == null) {}
    for (;;)
    {
      return -1L;
      localObject = (String)localObject + File.separator + this.jdField_int;
      try
      {
        localObject = new RandomAccessFile((String)localObject, "rw");
        ((RandomAccessFile)localObject).seek(paramInt);
        paramInt = ((RandomAccessFile)localObject).readInt();
        long l = ((RandomAccessFile)localObject).readLong();
        int i = ((RandomAccessFile)localObject).readInt();
        ((RandomAccessFile)localObject).close();
        if (paramInt == i) {
          return l;
        }
      }
      catch (Exception localException) {}
    }
    return -1L;
  }
  
  private void a(int paramInt, long paramLong)
  {
    Object localObject = c.jdMethod_goto();
    if (localObject == null) {
      return;
    }
    localObject = (String)localObject + File.separator + this.jdField_int;
    try
    {
      localObject = new RandomAccessFile((String)localObject, "rw");
      ((RandomAccessFile)localObject).seek(paramInt);
      ((RandomAccessFile)localObject).writeInt(this.jdField_for);
      ((RandomAccessFile)localObject).writeLong(paramLong);
      ((RandomAccessFile)localObject).writeInt(this.jdField_for);
      ((RandomAccessFile)localObject).close();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static e jdMethod_do()
  {
    if (if == null) {
      if = new e();
    }
    return if;
  }
  
  public long a()
  {
    return a(this.a);
  }
  
  public void a(long paramLong)
  {
    a(this.jdField_do, paramLong);
  }
  
  public long jdMethod_if()
  {
    return a(this.jdField_do);
  }
  
  public void jdMethod_if(long paramLong)
  {
    a(this.a, paramLong);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */