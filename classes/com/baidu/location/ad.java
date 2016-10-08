package com.baidu.location;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import java.io.File;
import java.io.RandomAccessFile;

class ad
  implements SensorEventListener, ax, b
{
  private static ad kg;
  private Runnable j6 = null;
  private Sensor j7;
  private final int j8 = 2;
  private boolean j9 = false;
  private boolean ka = false;
  private int kb = 0;
  private boolean kc = false;
  private Sensor kd;
  private boolean ke = false;
  private Handler kf;
  private boolean kh = false;
  private int ki = 0;
  private StringBuffer kj = null;
  private SensorManager kk;
  private StringBuffer kl = null;
  private Runnable km = null;
  private final int kn = 1;
  
  private ad()
  {
    try
    {
      this.kk = ((SensorManager)f.getServiceContext().getSystemService("sensor"));
      this.j7 = this.kk.getDefaultSensor(1);
      this.kd = this.kk.getDefaultSensor(2);
      this.kf = new Handler();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void cC()
  {
    if ((this.kk == null) || (this.kd == null)) {}
    while (this.j9) {
      return;
    }
    try
    {
      this.kk.registerListener(this, this.kd, 2, this.kf);
      this.j9 = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  private void cD()
  {
    if (this.j9) {}
    try
    {
      this.kk.unregisterListener(this, this.kd);
      this.j9 = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  private void cE()
  {
    if ((this.kk == null) || (this.j7 == null)) {}
    while (this.ka) {
      return;
    }
    try
    {
      this.kk.registerListener(this, this.j7, 2, this.kf);
      this.ka = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  private void cF()
  {
    if ((this.kc) || (this.ke)) {
      cE();
    }
    if (this.kc) {
      cC();
    }
  }
  
  private String cH()
  {
    int i = 0;
    String str1 = jdMethod_void(1);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "lmibaca.dat";
    arrayOfString[1] = "lmibacb.dat";
    int j = arrayOfString.length;
    while (i < j)
    {
      String str2 = arrayOfString[i];
      if (!new File(str1 + File.separator + str2).exists()) {
        return str1 + File.separator + str2;
      }
      i += 1;
    }
    return null;
  }
  
  private void cI()
  {
    if (this.ka) {}
    try
    {
      this.kk.unregisterListener(this, this.j7);
      this.ka = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  private void cJ()
  {
    this.kc = true;
    this.kj = new StringBuffer(8192);
    cF();
    this.km = new ad.3(this);
    this.kf.postDelayed(this.km, 60000L);
  }
  
  private void cL()
  {
    if (this.kc) {
      return;
    }
    if (this.ke)
    {
      cD();
      return;
    }
    cD();
    cI();
    this.ki = 0;
    this.kb = 0;
  }
  
  public static ad cM()
  {
    if (kg == null) {
      kg = new ad();
    }
    return kg;
  }
  
  private String cN()
  {
    int i = 0;
    String str1 = jdMethod_void(2);
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "lbaca.dat";
    arrayOfString[1] = "lbacb.dat";
    arrayOfString[2] = "lbacc.dat";
    arrayOfString[3] = "lbacd.dat";
    int j = arrayOfString.length;
    while (i < j)
    {
      String str2 = arrayOfString[i];
      if (!new File(str1 + File.separator + str2).exists()) {
        return str1 + File.separator + str2;
      }
      i += 1;
    }
    return null;
  }
  
  private boolean cQ()
  {
    Object localObject = cR();
    if (localObject == null) {
      return false;
    }
    try
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists())
      {
        ((File)localObject).createNewFile();
        localObject = new RandomAccessFile((File)localObject, "rw");
        jdMethod_if((RandomAccessFile)localObject, 0);
        ((RandomAccessFile)localObject).close();
        return true;
      }
      localObject = new RandomAccessFile((File)localObject, "rw");
      ((RandomAccessFile)localObject).seek(4L);
      long l = ((RandomAccessFile)localObject).readLong();
      int i = ((RandomAccessFile)localObject).readInt();
      if (((RandomAccessFile)localObject).readInt() == 3321)
      {
        l = System.currentTimeMillis() - l;
        if ((l < 0L) || (l > 86400000L))
        {
          ((RandomAccessFile)localObject).seek(4L);
          ((RandomAccessFile)localObject).writeLong(System.currentTimeMillis());
          ((RandomAccessFile)localObject).writeInt(0);
          ((RandomAccessFile)localObject).close();
          return true;
        }
        if (i > 96000)
        {
          ((RandomAccessFile)localObject).close();
          return false;
        }
        ((RandomAccessFile)localObject).close();
        return true;
      }
      jdMethod_if((RandomAccessFile)localObject, 0);
      ((RandomAccessFile)localObject).close();
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private String cR()
  {
    String str = jdMethod_void(1);
    if (str == null) {
      return null;
    }
    str = str + File.separator + "lscts.dat";
    Object localObject = new File(str);
    if (!((File)localObject).exists()) {}
    try
    {
      ((File)localObject).createNewFile();
      localObject = new RandomAccessFile((File)localObject, "rw");
      jdMethod_if((RandomAccessFile)localObject, 0);
      ((RandomAccessFile)localObject).close();
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private void d(int paramInt)
  {
    Object localObject = cR();
    if (localObject == null) {}
    for (;;)
    {
      return;
      try
      {
        localObject = new File((String)localObject);
        if (!((File)localObject).exists()) {
          continue;
        }
        localObject = new RandomAccessFile((File)localObject, "rw");
        ((RandomAccessFile)localObject).seek(0L);
        int i = ((RandomAccessFile)localObject).readInt();
        ((RandomAccessFile)localObject).readLong();
        int j = ((RandomAccessFile)localObject).readInt();
        if ((((RandomAccessFile)localObject).readInt() == 3321) && (i == 3321))
        {
          ((RandomAccessFile)localObject).seek(12L);
          ((RandomAccessFile)localObject).writeInt(j + paramInt);
        }
        for (;;)
        {
          ((RandomAccessFile)localObject).close();
          return;
          jdMethod_if((RandomAccessFile)localObject, 48000 + paramInt);
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  private void jdMethod_do(StringBuffer paramStringBuffer)
  {
    if ((!this.kc) || (this.kj == null)) {
      return;
    }
    jdMethod_if(this.kj, paramStringBuffer, e(2));
  }
  
  private String e(int paramInt)
  {
    String str = jdMethod_void(paramInt);
    if (str == null) {}
    do
    {
      return null;
      if (paramInt == 2) {
        return str + File.separator + "lbacz.dat";
      }
    } while (paramInt != 1);
    return str + File.separator + "lmibacz.dat";
  }
  
  private void jdMethod_if(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    try
    {
      paramRandomAccessFile.seek(0L);
      paramRandomAccessFile.writeInt(3321);
      paramRandomAccessFile.writeLong(System.currentTimeMillis());
      paramRandomAccessFile.writeInt(paramInt);
      paramRandomAccessFile.writeInt(3321);
      return;
    }
    catch (Exception paramRandomAccessFile) {}
  }
  
  private void jdMethod_if(StringBuffer paramStringBuffer)
  {
    if ((!this.ke) || (this.kl == null)) {
      return;
    }
    jdMethod_if(this.kl, paramStringBuffer, e(1));
  }
  
  /* Error */
  private void jdMethod_if(StringBuffer paramStringBuffer, File paramFile)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_2
    //   4: invokevirtual 157	java/io/File:exists	()Z
    //   7: ifne +4 -> 11
    //   10: return
    //   11: new 269	java/util/zip/GZIPOutputStream
    //   14: dup
    //   15: new 271	java/io/BufferedOutputStream
    //   18: dup
    //   19: new 273	java/io/FileOutputStream
    //   22: dup
    //   23: aload_2
    //   24: iconst_1
    //   25: invokespecial 276	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   28: invokespecial 279	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: invokespecial 280	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   34: astore_2
    //   35: iconst_0
    //   36: istore 4
    //   38: iload 4
    //   40: iconst_3
    //   41: if_icmpge +19 -> 60
    //   44: aload_2
    //   45: aload_1
    //   46: invokevirtual 281	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   49: invokevirtual 285	java/lang/String:getBytes	()[B
    //   52: invokevirtual 289	java/util/zip/GZIPOutputStream:write	([B)V
    //   55: iload 5
    //   57: ifeq +17 -> 74
    //   60: aload_2
    //   61: invokevirtual 290	java/util/zip/GZIPOutputStream:close	()V
    //   64: return
    //   65: astore_1
    //   66: return
    //   67: astore_3
    //   68: iconst_0
    //   69: istore 5
    //   71: goto -16 -> 55
    //   74: iload 4
    //   76: iconst_1
    //   77: iadd
    //   78: istore 4
    //   80: goto -42 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	ad
    //   0	83	1	paramStringBuffer	StringBuffer
    //   0	83	2	paramFile	File
    //   67	1	3	localException	Exception
    //   36	43	4	i	int
    //   1	69	5	j	int
    // Exception table:
    //   from	to	target	type
    //   11	35	65	java/lang/Exception
    //   60	64	65	java/lang/Exception
    //   44	55	67	java/lang/Exception
  }
  
  private void jdMethod_if(StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2, String paramString)
  {
    if (paramStringBuffer1.length() + paramStringBuffer2.length() < 8190)
    {
      paramStringBuffer1.append(paramStringBuffer2);
      return;
    }
    paramString = new File(paramString);
    d(paramStringBuffer1.length());
    jdMethod_if(paramStringBuffer1, paramString);
    this.kh = true;
    paramStringBuffer1.delete(0, paramStringBuffer1.length());
    paramStringBuffer1.append(paramStringBuffer2);
  }
  
  private boolean jdMethod_if(File paramFile)
  {
    try
    {
      paramFile.createNewFile();
      StringBuffer localStringBuffer = new StringBuffer(256);
      localStringBuffer.append("C");
      localStringBuffer.append("\t");
      localStringBuffer.append(Jni.i(az.cn().cl()));
      localStringBuffer.append("\n");
      jdMethod_if(localStringBuffer, paramFile);
      return true;
    }
    catch (Exception paramFile) {}
    return false;
  }
  
  private boolean jdMethod_if(File paramFile, int paramInt)
  {
    String str = null;
    if (paramInt == 2) {
      str = cN();
    }
    while (str == null)
    {
      return false;
      if (paramInt == 1) {
        str = cH();
      }
    }
    return paramFile.renameTo(new File(str));
  }
  
  private boolean jdMethod_long(int paramInt)
  {
    Object localObject = e(paramInt);
    if (localObject == null) {}
    label79:
    label81:
    do
    {
      File localFile;
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if (paramInt != 2) {
                break label81;
              }
              localFile = new File((String)localObject);
              if (!localFile.exists()) {
                break;
              }
              if (localFile.length() <= 30720L) {
                break label79;
              }
            } while (!jdMethod_if(localFile, paramInt));
            localObject = new File((String)localObject);
          } while (((File)localObject).exists());
          try
          {
            bool = jdMethod_if((File)localObject);
            return bool;
          }
          catch (Exception localException1)
          {
            boolean bool;
            return false;
          }
          return true;
        } while ((paramInt != 1) || (!cQ()));
        localFile = new File((String)localObject);
        if (!localFile.exists()) {
          break;
        }
        if (localFile.length() <= 30720L) {
          break label155;
        }
      } while (!jdMethod_if(localFile, paramInt));
      localObject = new File((String)localObject);
    } while (((File)localObject).exists());
    label155:
    try
    {
      bool = jdMethod_if((File)localObject);
      return bool;
    }
    catch (Exception localException2) {}
    return true;
    return false;
  }
  
  private String jdMethod_void(int paramInt)
  {
    String str1 = c.jdMethod_else();
    String str2;
    if (str1 == null)
    {
      str2 = null;
      return str2;
    }
    if (paramInt == 1) {}
    for (str1 = str1 + File.separator + "llmis1";; str1 = str1 + File.separator + "llmis2")
    {
      File localFile = new File(str1);
      str2 = str1;
      if (localFile.exists()) {
        break;
      }
      try
      {
        boolean bool = localFile.mkdirs();
        str2 = str1;
        if (bool) {
          break;
        }
        return null;
      }
      catch (Exception localException) {}
      if (paramInt != 2) {
        break label115;
      }
    }
    label115:
    return null;
    return null;
  }
  
  public String cG()
  {
    int i = 0;
    String str1 = jdMethod_void(1);
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "lmibaca.dat";
    arrayOfString[1] = "lmibacb.dat";
    arrayOfString[2] = "lmibacz.dat";
    for (;;)
    {
      try
      {
        int j = arrayOfString.length;
        if (i >= j) {
          break;
        }
        String str2 = arrayOfString[i];
        File localFile = new File(str1 + File.separator + str2);
        if (localFile.exists()) {
          if (localFile.length() > 92160L)
          {
            localFile.delete();
          }
          else if (localFile.length() >= 4096L)
          {
            if ((str2.equals("lmibacz.dat")) && (this.ke)) {
              return null;
            }
            str1 = str1 + File.separator + str2;
            return str1;
          }
        }
      }
      catch (Exception localException)
      {
        return null;
      }
      i += 1;
    }
    return null;
  }
  
  public void cK()
  {
    this.kf.post(new ad.2(this));
  }
  
  public void cO()
  {
    this.ke = false;
    if (((this.kl != null) && (this.kl.length() > 3800)) || (this.kh))
    {
      File localFile = new File(e(1));
      d(this.kl.length());
      jdMethod_if(this.kl, localFile);
      this.kh = false;
    }
    this.kl = null;
    cL();
  }
  
  public void cP()
  {
    this.kc = false;
    if ((this.kj != null) && (this.kj.length() > 3800))
    {
      File localFile = new File(e(2));
      jdMethod_if(this.kj, localFile);
    }
    this.kj = null;
    cL();
  }
  
  public void jdMethod_goto(int paramInt)
  {
    if (this.ke) {}
    while (!jdMethod_long(1)) {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer(128);
    this.ke = true;
    this.kl = new StringBuffer(8192);
    localStringBuffer.append("T1");
    localStringBuffer.append("\t");
    localStringBuffer.append(paramInt);
    localStringBuffer.append("\n");
    jdMethod_if(localStringBuffer);
    cF();
    this.j6 = new ad.1(this);
    this.kf.postDelayed(this.j6, 8000L);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i = paramSensorEvent.sensor.getType();
    StringBuffer localStringBuffer = new StringBuffer(256);
    if (i == 1)
    {
      this.ki += 1;
      localStringBuffer.append("A");
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.values[0]);
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.values[1]);
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.values[2]);
      if (this.ki == 1)
      {
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.timestamp);
      }
      if (this.ki >= 14) {
        this.ki = 0;
      }
      localStringBuffer.append("\n");
      jdMethod_do(localStringBuffer);
      jdMethod_if(localStringBuffer);
    }
    if (i == 2)
    {
      this.kb += 1;
      localStringBuffer.append("M");
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.values[0]);
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.values[1]);
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.values[2]);
      if (this.kb == 1)
      {
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.timestamp);
      }
      if (this.kb > 13) {
        this.kb = 0;
      }
      localStringBuffer.append("\n");
      jdMethod_do(localStringBuffer);
    }
  }
  
  class a
  {
    StringBuffer jdField_do = null;
    public boolean jdField_if = false;
    
    a() {}
    
    public void a() {}
    
    public void jdMethod_do() {}
    
    public void jdMethod_if() {}
  }
  
  class b
  {
    public b() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */