package com.baidu.location;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class y
  implements ax, n
{
  public static boolean f0 = false;
  public static boolean f1 = false;
  private static final String f2;
  public static int f4 = -1;
  public static boolean f5 = false;
  public static boolean f6 = false;
  private static final int f7 = 128;
  public static boolean f8;
  private static y f9 = null;
  public static boolean gb;
  public static int gc;
  public static int gd = 0;
  private a f3 = null;
  private long ga = 0L;
  
  static
  {
    f6 = true;
    f8 = true;
    gb = false;
    f0 = true;
    f1 = true;
    f5 = true;
    f2 = I + "/conlts.dat";
    gc = -1;
  }
  
  public static void a5()
  {
    Object localObject1 = I + "/config.dat";
    if (c.az) {}
    for (int i = 1;; i = 0)
    {
      if (c.aZ) {}
      for (int j = 1;; j = 0)
      {
        byte[] arrayOfByte = String.format(Locale.CHINA, "{\"ver\":\"%d\",\"gps\":\"%.1f|%.1f|%.1f|%.1f|%d|%d|%d|%d|%d|%d|%d\",\"up\":\"%.1f|%.1f|%.1f|%.1f\",\"wf\":\"%d|%.1f|%d|%.1f\",\"ab\":\"%.2f|%.2f|%d|%d\",\"gpc\":\"%d|%d|%d|%d|%d|%d\",\"zxd\":\"%.1f|%.1f|%d|%d|%d\",\"shak\":\"%d|%d|%.1f\",\"dmx\":%d}", new Object[] { Integer.valueOf(c.ai), Float.valueOf(c.ae), Float.valueOf(c.aR), Float.valueOf(c.ag), Float.valueOf(c.aT), Integer.valueOf(c.aI), Integer.valueOf(c.W), Integer.valueOf(c.aJ), Integer.valueOf(c.X), Integer.valueOf(c.aa), Integer.valueOf(c.ax), Integer.valueOf(c.a4), Float.valueOf(c.be), Float.valueOf(c.bb), Float.valueOf(c.ap), Float.valueOf(c.a0), Integer.valueOf(c.aX), Float.valueOf(c.ab), Integer.valueOf(c.at), Float.valueOf(c.aU), Float.valueOf(c.bd), Float.valueOf(c.ba), Integer.valueOf(c.a8), Integer.valueOf(c.a6), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(c.av), Integer.valueOf(c.ay), Long.valueOf(c.aS), Integer.valueOf(c.aV), Float.valueOf(c.af), Float.valueOf(c.Z), Integer.valueOf(c.aq), Integer.valueOf(c.aF), Integer.valueOf(c.au), Integer.valueOf(c.aW), Integer.valueOf(c.aO), Float.valueOf(c.a2), Integer.valueOf(c.a5) }).getBytes();
        try
        {
          localObject1 = new File((String)localObject1);
          if (!((File)localObject1).exists())
          {
            Object localObject2 = new File(I);
            if (!((File)localObject2).exists()) {
              ((File)localObject2).mkdirs();
            }
            if (((File)localObject1).createNewFile())
            {
              localObject2 = new RandomAccessFile((File)localObject1, "rw");
              ((RandomAccessFile)localObject2).seek(0L);
              ((RandomAccessFile)localObject2).writeBoolean(false);
              ((RandomAccessFile)localObject2).writeBoolean(false);
              ((RandomAccessFile)localObject2).close();
            }
          }
          else
          {
            localObject1 = new RandomAccessFile((File)localObject1, "rw");
            ((RandomAccessFile)localObject1).seek(0L);
            ((RandomAccessFile)localObject1).writeBoolean(true);
            ((RandomAccessFile)localObject1).seek(2L);
            ((RandomAccessFile)localObject1).writeInt(arrayOfByte.length);
            ((RandomAccessFile)localObject1).write(arrayOfByte);
            ((RandomAccessFile)localObject1).close();
          }
          return;
        }
        catch (Exception localException)
        {
          return;
        }
      }
    }
  }
  
  public static void a6()
  {
    try
    {
      File localFile = new File(f2);
      if (!localFile.exists())
      {
        Object localObject = new File(I);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = localFile;
        if (!localFile.createNewFile()) {
          localObject = null;
        }
        localObject = new RandomAccessFile((File)localObject, "rw");
        ((RandomAccessFile)localObject).seek(0L);
        ((RandomAccessFile)localObject).writeInt(0);
        ((RandomAccessFile)localObject).writeInt(128);
        ((RandomAccessFile)localObject).writeInt(0);
        ((RandomAccessFile)localObject).close();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static y a7()
  {
    if (f9 == null) {
      f9 = new y();
    }
    return f9;
  }
  
  private void ba()
  {
    String str = "&ver=" + c.ai + "&usr=" + az.cn().ck() + "&app=" + az.iH + "&prod=" + az.iM;
    this.f3.jdMethod_if(str, false);
  }
  
  public static void bb()
  {
    Object localObject1 = I + "/config.dat";
    try
    {
      localObject1 = new File((String)localObject1);
      if (!((File)localObject1).exists())
      {
        Object localObject2 = new File(I);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        if (((File)localObject1).createNewFile())
        {
          localObject2 = new RandomAccessFile((File)localObject1, "rw");
          ((RandomAccessFile)localObject2).seek(0L);
          ((RandomAccessFile)localObject2).writeBoolean(false);
          ((RandomAccessFile)localObject2).writeBoolean(false);
          ((RandomAccessFile)localObject2).close();
        }
      }
      else
      {
        localObject1 = new RandomAccessFile((File)localObject1, "rw");
        ((RandomAccessFile)localObject1).seek(1L);
        ((RandomAccessFile)localObject1).writeBoolean(true);
        ((RandomAccessFile)localObject1).seek(1024L);
        ((RandomAccessFile)localObject1).writeDouble(c.aH);
        ((RandomAccessFile)localObject1).writeDouble(c.ac);
        ((RandomAccessFile)localObject1).writeBoolean(c.ar);
        if ((c.ar) && (c.aB != null)) {
          ((RandomAccessFile)localObject1).write(c.aB);
        }
        ((RandomAccessFile)localObject1).close();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void bc()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        Object localObject = new File(f2);
        if (!((File)localObject).exists()) {
          break;
        }
        localObject = new RandomAccessFile((File)localObject, "rw");
        ((RandomAccessFile)localObject).seek(4L);
        int j = ((RandomAccessFile)localObject).readInt();
        if (j > 3000)
        {
          ((RandomAccessFile)localObject).close();
          gd = 0;
          a6();
          return;
        }
        int k = ((RandomAccessFile)localObject).readInt();
        ((RandomAccessFile)localObject).seek(128L);
        byte[] arrayOfByte = new byte[j];
        if (i < k)
        {
          ((RandomAccessFile)localObject).seek(j * i + 128);
          int m = ((RandomAccessFile)localObject).readInt();
          if ((m > 0) && (m < j))
          {
            ((RandomAccessFile)localObject).read(arrayOfByte, 0, m);
            if (arrayOfByte[(m - 1)] == 0)
            {
              String str = new String(arrayOfByte, 0, m - 1);
              az.cn();
              if (str.equals(az.iH))
              {
                gc = ((RandomAccessFile)localObject).readInt();
                gd = i;
              }
            }
          }
        }
        else
        {
          if (i == k) {
            gd = k;
          }
          ((RandomAccessFile)localObject).close();
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      i += 1;
    }
  }
  
  /* Error */
  private void jdMethod_do(HttpEntity paramHttpEntity)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iconst_m1
    //   3: putstatic 72	com/baidu/location/y:f4	I
    //   6: aload_1
    //   7: ifnull +62 -> 69
    //   10: aload_1
    //   11: ldc_w 365
    //   14: invokestatic 370	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_1
    //   18: aload_1
    //   19: astore_3
    //   20: aload_1
    //   21: astore_2
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 374	com/baidu/location/y:o	(Ljava/lang/String;)Z
    //   27: ifeq +10 -> 37
    //   30: aload_1
    //   31: astore_2
    //   32: invokestatic 376	com/baidu/location/y:a5	()V
    //   35: aload_1
    //   36: astore_3
    //   37: new 378	org/json/JSONObject
    //   40: dup
    //   41: aload_3
    //   42: invokespecial 379	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore_1
    //   46: aload_1
    //   47: ldc_w 381
    //   50: invokevirtual 384	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   53: ifeq +16 -> 69
    //   56: aload_1
    //   57: ldc_w 381
    //   60: invokevirtual 388	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: invokestatic 392	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   66: putstatic 72	com/baidu/location/y:f4	I
    //   69: invokestatic 394	com/baidu/location/y:bc	()V
    //   72: getstatic 72	com/baidu/location/y:f4	I
    //   75: iconst_m1
    //   76: if_icmpeq +40 -> 116
    //   79: getstatic 72	com/baidu/location/y:f4	I
    //   82: istore 4
    //   84: getstatic 72	com/baidu/location/y:f4	I
    //   87: invokestatic 397	com/baidu/location/y:new	(I)V
    //   90: iload 4
    //   92: iconst_m1
    //   93: if_icmpeq +8 -> 101
    //   96: iload 4
    //   98: invokestatic 400	com/baidu/location/y:try	(I)V
    //   101: invokestatic 406	com/baidu/location/r:H	()Lcom/baidu/location/r;
    //   104: invokevirtual 409	com/baidu/location/r:I	()Landroid/os/Handler;
    //   107: bipush 92
    //   109: invokevirtual 415	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   112: invokevirtual 420	android/os/Message:sendToTarget	()V
    //   115: return
    //   116: getstatic 70	com/baidu/location/y:gc	I
    //   119: iconst_m1
    //   120: if_icmpeq +23 -> 143
    //   123: getstatic 70	com/baidu/location/y:gc	I
    //   126: istore 4
    //   128: goto -38 -> 90
    //   131: astore_1
    //   132: return
    //   133: astore_1
    //   134: goto -65 -> 69
    //   137: astore_1
    //   138: aload_2
    //   139: astore_3
    //   140: goto -103 -> 37
    //   143: iconst_m1
    //   144: istore 4
    //   146: goto -56 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	y
    //   0	149	1	paramHttpEntity	HttpEntity
    //   1	138	2	localHttpEntity1	HttpEntity
    //   19	121	3	localHttpEntity2	HttpEntity
    //   82	63	4	i	int
    // Exception table:
    //   from	to	target	type
    //   69	90	131	java/lang/Exception
    //   96	101	131	java/lang/Exception
    //   101	115	131	java/lang/Exception
    //   116	128	131	java/lang/Exception
    //   37	69	133	java/lang/Exception
    //   10	18	137	java/lang/Exception
    //   22	30	137	java/lang/Exception
    //   32	35	137	java/lang/Exception
  }
  
  private void jdMethod_if(HttpEntity paramHttpEntity)
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      try
      {
        paramHttpEntity = EntityUtils.toByteArray(paramHttpEntity);
        if (paramHttpEntity == null)
        {
          if (i == 0) {
            break;
          }
          bb();
          return;
        }
        if (paramHttpEntity.length < 640)
        {
          c.ar = false;
          c.ac = c.an + 0.025D;
          c.aH = c.a9 - 0.025D;
          i = 1;
        }
        else
        {
          c.ar = true;
          c.aH = Double.longBitsToDouble(Long.valueOf((paramHttpEntity[7] & 0xFF) << 56 | (paramHttpEntity[6] & 0xFF) << 48 | (paramHttpEntity[5] & 0xFF) << 40 | (paramHttpEntity[4] & 0xFF) << 32 | (paramHttpEntity[3] & 0xFF) << 24 | (paramHttpEntity[2] & 0xFF) << 16 | (paramHttpEntity[1] & 0xFF) << 8 | paramHttpEntity[0] & 0xFF).longValue());
          c.ac = Double.longBitsToDouble(Long.valueOf((paramHttpEntity[15] & 0xFF) << 56 | (paramHttpEntity[14] & 0xFF) << 48 | (paramHttpEntity[13] & 0xFF) << 40 | (paramHttpEntity[12] & 0xFF) << 32 | (paramHttpEntity[11] & 0xFF) << 24 | (paramHttpEntity[10] & 0xFF) << 16 | (paramHttpEntity[9] & 0xFF) << 8 | paramHttpEntity[8] & 0xFF).longValue());
          c.aB = new byte['ɱ'];
          i = j;
          if (i < 625)
          {
            c.aB[i] = paramHttpEntity[(i + 16)];
            i += 1;
          }
          else
          {
            i = 1;
          }
        }
      }
      catch (Exception paramHttpEntity)
      {
        return;
      }
    }
  }
  
  public static void jdMethod_new(int paramInt)
  {
    Object localObject = new File(f2);
    if (!((File)localObject).exists()) {
      a6();
    }
    try
    {
      localObject = new RandomAccessFile((File)localObject, "rw");
      ((RandomAccessFile)localObject).seek(4L);
      int i = ((RandomAccessFile)localObject).readInt();
      int j = ((RandomAccessFile)localObject).readInt();
      ((RandomAccessFile)localObject).seek(i * gd + 128);
      byte[] arrayOfByte = (az.iH + '\000').getBytes();
      ((RandomAccessFile)localObject).writeInt(arrayOfByte.length);
      ((RandomAccessFile)localObject).write(arrayOfByte, 0, arrayOfByte.length);
      ((RandomAccessFile)localObject).writeInt(paramInt);
      if (j == gd)
      {
        ((RandomAccessFile)localObject).seek(8L);
        ((RandomAccessFile)localObject).writeInt(j + 1);
      }
      ((RandomAccessFile)localObject).close();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void jdMethod_try(int paramInt)
  {
    boolean bool2 = true;
    if ((paramInt & 0x1) == 1)
    {
      bool1 = true;
      f6 = bool1;
      if ((paramInt & 0x2) != 2) {
        break label96;
      }
      bool1 = true;
      label24:
      f8 = bool1;
      if ((paramInt & 0x4) != 4) {
        break label101;
      }
      bool1 = true;
      label37:
      gb = bool1;
      if ((paramInt & 0x8) != 8) {
        break label106;
      }
      bool1 = true;
      label52:
      f0 = bool1;
      if ((paramInt & 0x10000) != 65536) {
        break label111;
      }
      bool1 = true;
      label69:
      f1 = bool1;
      if ((paramInt & 0x20000) != 131072) {
        break label116;
      }
    }
    label96:
    label101:
    label106:
    label111:
    label116:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      f5 = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label24;
      bool1 = false;
      break label37;
      bool1 = false;
      break label52;
      bool1 = false;
      break label69;
    }
  }
  
  public void a8()
  {
    Object localObject = I + "/config.dat";
    try
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists())
      {
        localObject = new RandomAccessFile((File)localObject, "rw");
        if (((RandomAccessFile)localObject).readBoolean())
        {
          ((RandomAccessFile)localObject).seek(2L);
          int i = ((RandomAccessFile)localObject).readInt();
          byte[] arrayOfByte = new byte[i];
          ((RandomAccessFile)localObject).read(arrayOfByte, 0, i);
          o(new String(arrayOfByte));
        }
        ((RandomAccessFile)localObject).seek(1L);
        if (((RandomAccessFile)localObject).readBoolean())
        {
          ((RandomAccessFile)localObject).seek(1024L);
          c.aH = ((RandomAccessFile)localObject).readDouble();
          c.ac = ((RandomAccessFile)localObject).readDouble();
          c.ar = ((RandomAccessFile)localObject).readBoolean();
          if (c.ar)
          {
            c.aB = new byte['ɱ'];
            ((RandomAccessFile)localObject).read(c.aB, 0, 625);
          }
        }
        ((RandomAccessFile)localObject).close();
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    jdMethod_do(null);
  }
  
  public void a9()
  {
    if (System.currentTimeMillis() - this.ga > 72000000L)
    {
      this.ga = System.currentTimeMillis();
      ba();
    }
  }
  
  public void n(String paramString)
  {
    this.f3.jdMethod_if(paramString, true);
  }
  
  public boolean o(String paramString)
  {
    boolean bool2 = true;
    if (paramString != null) {}
    try
    {
      paramString = new JSONObject(paramString);
      int i = Integer.parseInt(paramString.getString("ver"));
      if (i > c.ai)
      {
        c.ai = i;
        String[] arrayOfString;
        if (paramString.has("gps"))
        {
          arrayOfString = paramString.getString("gps").split("\\|");
          if (arrayOfString.length > 10)
          {
            if ((arrayOfString[0] != null) && (!arrayOfString[0].equals(""))) {
              c.ae = Float.parseFloat(arrayOfString[0]);
            }
            if ((arrayOfString[1] != null) && (!arrayOfString[1].equals(""))) {
              c.aR = Float.parseFloat(arrayOfString[1]);
            }
            if ((arrayOfString[2] != null) && (!arrayOfString[2].equals(""))) {
              c.ag = Float.parseFloat(arrayOfString[2]);
            }
            if ((arrayOfString[3] != null) && (!arrayOfString[3].equals(""))) {
              c.aT = Float.parseFloat(arrayOfString[3]);
            }
            if ((arrayOfString[4] != null) && (!arrayOfString[4].equals(""))) {
              c.aI = Integer.parseInt(arrayOfString[4]);
            }
            if ((arrayOfString[5] != null) && (!arrayOfString[5].equals(""))) {
              c.W = Integer.parseInt(arrayOfString[5]);
            }
            if ((arrayOfString[6] != null) && (!arrayOfString[6].equals(""))) {
              c.aJ = Integer.parseInt(arrayOfString[6]);
            }
            if ((arrayOfString[7] != null) && (!arrayOfString[7].equals(""))) {
              c.X = Integer.parseInt(arrayOfString[7]);
            }
            if ((arrayOfString[8] != null) && (!arrayOfString[8].equals(""))) {
              c.aa = Integer.parseInt(arrayOfString[8]);
            }
            if ((arrayOfString[9] != null) && (!arrayOfString[9].equals(""))) {
              c.ax = Integer.parseInt(arrayOfString[9]);
            }
            if ((arrayOfString[10] != null) && (!arrayOfString[10].equals(""))) {
              c.a4 = Integer.parseInt(arrayOfString[10]);
            }
          }
        }
        if (paramString.has("up"))
        {
          arrayOfString = paramString.getString("up").split("\\|");
          if (arrayOfString.length > 3)
          {
            if ((arrayOfString[0] != null) && (!arrayOfString[0].equals(""))) {
              c.be = Float.parseFloat(arrayOfString[0]);
            }
            if ((arrayOfString[1] != null) && (!arrayOfString[1].equals(""))) {
              c.bb = Float.parseFloat(arrayOfString[1]);
            }
            if ((arrayOfString[2] != null) && (!arrayOfString[2].equals(""))) {
              c.ap = Float.parseFloat(arrayOfString[2]);
            }
            if ((arrayOfString[3] != null) && (!arrayOfString[3].equals(""))) {
              c.a0 = Float.parseFloat(arrayOfString[3]);
            }
          }
        }
        if (paramString.has("wf"))
        {
          arrayOfString = paramString.getString("wf").split("\\|");
          if (arrayOfString.length > 3)
          {
            if ((arrayOfString[0] != null) && (!arrayOfString[0].equals(""))) {
              c.aX = Integer.parseInt(arrayOfString[0]);
            }
            if ((arrayOfString[1] != null) && (!arrayOfString[1].equals(""))) {
              c.ab = Float.parseFloat(arrayOfString[1]);
            }
            if ((arrayOfString[2] != null) && (!arrayOfString[2].equals(""))) {
              c.at = Integer.parseInt(arrayOfString[2]);
            }
            if ((arrayOfString[3] != null) && (!arrayOfString[3].equals(""))) {
              c.aU = Float.parseFloat(arrayOfString[3]);
            }
          }
        }
        if (paramString.has("ab"))
        {
          arrayOfString = paramString.getString("ab").split("\\|");
          if (arrayOfString.length > 3)
          {
            if ((arrayOfString[0] != null) && (!arrayOfString[0].equals(""))) {
              c.bd = Float.parseFloat(arrayOfString[0]);
            }
            if ((arrayOfString[1] != null) && (!arrayOfString[1].equals(""))) {
              c.ba = Float.parseFloat(arrayOfString[1]);
            }
            if ((arrayOfString[2] != null) && (!arrayOfString[2].equals(""))) {
              c.a8 = Integer.parseInt(arrayOfString[2]);
            }
            if ((arrayOfString[3] != null) && (!arrayOfString[3].equals(""))) {
              c.a6 = Integer.parseInt(arrayOfString[3]);
            }
          }
        }
        if (paramString.has("zxd"))
        {
          arrayOfString = paramString.getString("zxd").split("\\|");
          if (arrayOfString.length > 4)
          {
            if ((arrayOfString[0] != null) && (!arrayOfString[0].equals(""))) {
              c.af = Float.parseFloat(arrayOfString[0]);
            }
            if ((arrayOfString[1] != null) && (!arrayOfString[1].equals(""))) {
              c.Z = Float.parseFloat(arrayOfString[1]);
            }
            if ((arrayOfString[2] != null) && (!arrayOfString[2].equals(""))) {
              c.aq = Integer.parseInt(arrayOfString[2]);
            }
            if ((arrayOfString[3] != null) && (!arrayOfString[3].equals(""))) {
              c.aF = Integer.parseInt(arrayOfString[3]);
            }
            if ((arrayOfString[4] != null) && (!arrayOfString[4].equals(""))) {
              c.au = Integer.parseInt(arrayOfString[4]);
            }
          }
        }
        if (paramString.has("gpc"))
        {
          arrayOfString = paramString.getString("gpc").split("\\|");
          if (arrayOfString.length > 5)
          {
            if ((arrayOfString[0] != null) && (!arrayOfString[0].equals("")))
            {
              if (Integer.parseInt(arrayOfString[0]) <= 0) {
                break label1331;
              }
              c.az = true;
            }
            if ((arrayOfString[1] != null) && (!arrayOfString[1].equals("")))
            {
              if (Integer.parseInt(arrayOfString[1]) <= 0) {
                break label1338;
              }
              c.aZ = true;
            }
            label1052:
            if ((arrayOfString[2] != null) && (!arrayOfString[2].equals(""))) {
              c.av = Integer.parseInt(arrayOfString[2]);
            }
            if ((arrayOfString[3] != null) && (!arrayOfString[3].equals(""))) {
              c.ay = Integer.parseInt(arrayOfString[3]);
            }
            if ((arrayOfString[4] != null) && (!arrayOfString[4].equals("")))
            {
              i = Integer.parseInt(arrayOfString[4]);
              if (i <= 0) {
                break label1345;
              }
              c.aS = i;
              c.aQ = c.aS * 1000L * 60L;
              c.aD = c.aQ >> 2;
            }
          }
        }
        for (;;)
        {
          if ((arrayOfString[5] != null) && (!arrayOfString[5].equals(""))) {
            c.aV = Integer.parseInt(arrayOfString[5]);
          }
          if (paramString.has("shak"))
          {
            arrayOfString = paramString.getString("shak").split("\\|");
            if (arrayOfString.length > 2)
            {
              if ((arrayOfString[0] != null) && (!arrayOfString[0].equals(""))) {
                c.aW = Integer.parseInt(arrayOfString[0]);
              }
              if ((arrayOfString[1] != null) && (!arrayOfString[1].equals(""))) {
                c.aO = Integer.parseInt(arrayOfString[1]);
              }
              if ((arrayOfString[2] != null) && (!arrayOfString[2].equals(""))) {
                c.a2 = Float.parseFloat(arrayOfString[2]);
              }
            }
          }
          bool1 = bool2;
          if (!paramString.has("dmx")) {
            break label1355;
          }
          c.a5 = paramString.getInt("dmx");
          bool1 = bool2;
          break label1355;
          label1331:
          c.az = false;
          break;
          label1338:
          c.aZ = false;
          break label1052;
          label1345:
          c.a7 = false;
        }
      }
      boolean bool1 = false;
      label1355:
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  class a
    extends s
  {
    boolean dt = false;
    String du = null;
    boolean dv = false;
    
    public a()
    {
      this.cT = new ArrayList();
    }
    
    void T()
    {
      this.cR = c.jdMethod_for();
      this.c0 = 2;
      String str = Jni.i(this.du);
      this.du = null;
      if (this.dt) {
        this.cT.add(new BasicNameValuePair("qt", "grid"));
      }
      for (;;)
      {
        this.cT.add(new BasicNameValuePair("req", str));
        return;
        this.cT.add(new BasicNameValuePair("qt", "conf"));
      }
    }
    
    void jdMethod_do(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.cS != null)) {
        if (this.dt) {
          y.jdMethod_if(y.this, this.cS);
        }
      }
      for (;;)
      {
        if (this.cT != null) {
          this.cT.clear();
        }
        this.dv = false;
        return;
        y.jdMethod_do(y.this, this.cS);
        continue;
        y.jdMethod_do(y.this, null);
      }
    }
    
    public void jdMethod_if(String paramString, boolean paramBoolean)
    {
      if (this.dv) {
        return;
      }
      this.dv = true;
      this.du = paramString;
      this.dt = paramBoolean;
      N();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */