package com.baidu.location;

import android.location.Location;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;

public class w
  implements ax, n
{
  private static final int e0 = 1000;
  private static final int e2 = 100;
  private static int e4 = 0;
  private static w e5 = null;
  private static long e6 = 0L;
  private static final int eI = 12;
  private static StringBuffer eJ;
  private static final int eK = 5;
  private static File eL;
  private static final int eM = 3600;
  private static int eN = 0;
  private static long eO = 0L;
  private static long eP = 0L;
  private static boolean eQ = false;
  private static final int eR = 1024;
  private static int eS = 0;
  private static double eT = 0.0D;
  private static double eU = 0.0D;
  private static String eV = "Temp_in.dat";
  private static int eW = 0;
  private static int eX = 0;
  private static final int eY = 5;
  private static final int eZ = 750;
  private String e1 = null;
  private boolean e3 = true;
  
  static
  {
    eL = new File(I, eV);
    eJ = null;
    eQ = true;
    eW = 0;
    e4 = 0;
    eP = 0L;
    eO = 0L;
    e6 = 0L;
    eT = 0.0D;
    eU = 0.0D;
  }
  
  private w(String paramString)
  {
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() <= 100) {}
    }
    for (String str = paramString.substring(0, 100);; str = "")
    {
      this.e1 = str;
      return;
    }
  }
  
  private static boolean aH()
  {
    if (eL.exists()) {
      eL.delete();
    }
    if (!eL.getParentFile().exists()) {
      eL.getParentFile().mkdirs();
    }
    try
    {
      eL.createNewFile();
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(eL, "rw");
      localRandomAccessFile.seek(0L);
      localRandomAccessFile.writeInt(0);
      localRandomAccessFile.writeInt(0);
      localRandomAccessFile.writeInt(1);
      localRandomAccessFile.close();
      aJ();
      return eL.exists();
    }
    catch (IOException localIOException) {}
    return false;
  }
  
  private void aI()
  {
    if ((eJ != null) && (eJ.length() >= 100)) {
      h(eJ.toString());
    }
    aJ();
  }
  
  private static void aJ()
  {
    eQ = true;
    eJ = null;
    eW = 0;
    e4 = 0;
    eP = 0L;
    eO = 0L;
    e6 = 0L;
    eT = 0.0D;
    eU = 0.0D;
    eN = 0;
    eS = 0;
    eX = 0;
  }
  
  public static w aK()
  {
    if (e5 == null) {
      e5 = new w(az.cn().cj());
    }
    return e5;
  }
  
  private void aL() {}
  
  public static String aM()
  {
    if (eL == null) {
      return null;
    }
    if (!eL.exists()) {
      return null;
    }
    for (;;)
    {
      int j;
      try
      {
        localRandomAccessFile = new RandomAccessFile(eL, "rw");
        localRandomAccessFile.seek(0L);
        k = localRandomAccessFile.readInt();
        j = localRandomAccessFile.readInt();
        i = localRandomAccessFile.readInt();
        if (jdMethod_if(k, j, i)) {
          break label206;
        }
        localRandomAccessFile.close();
        aH();
        return null;
      }
      catch (IOException localIOException)
      {
        RandomAccessFile localRandomAccessFile;
        int k;
        long l;
        int m;
        Object localObject;
        return null;
      }
      localRandomAccessFile.close();
      return null;
      l = 0L + ((j - 1) * 1024 + 12);
      localRandomAccessFile.seek(l);
      m = localRandomAccessFile.readInt();
      localObject = new byte[m];
      localRandomAccessFile.seek(l + 4L);
      int i = 0;
      if (i < m)
      {
        localObject[i] = localRandomAccessFile.readByte();
        i += 1;
      }
      else
      {
        localObject = new String((byte[])localObject);
        if (k < c.ay)
        {
          i = j + 1;
          localRandomAccessFile.seek(4L);
          localRandomAccessFile.writeInt(i);
          localRandomAccessFile.close();
          return (String)localObject;
        }
        i = c.ay;
        if (j == i)
        {
          i = 1;
        }
        else
        {
          i = j + 1;
          continue;
          label206:
          if (j != 0) {
            if (j != i) {}
          }
        }
      }
    }
  }
  
  private boolean aN()
  {
    if (eL.exists()) {
      eL.delete();
    }
    aJ();
    return !eL.exists();
  }
  
  private String jdMethod_for(int paramInt)
  {
    if (!eL.exists()) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = new RandomAccessFile(eL, "rw");
        ((RandomAccessFile)localObject).seek(0L);
        i = ((RandomAccessFile)localObject).readInt();
        if (jdMethod_if(i, ((RandomAccessFile)localObject).readInt(), ((RandomAccessFile)localObject).readInt())) {
          break label150;
        }
        ((RandomAccessFile)localObject).close();
        aH();
        return null;
      }
      catch (IOException localIOException)
      {
        Object localObject;
        long l;
        byte[] arrayOfByte;
        return null;
      }
      ((RandomAccessFile)localObject).close();
      return null;
      l = 12L + 0L + (paramInt - 1) * 1024;
      ((RandomAccessFile)localObject).seek(l);
      int i = ((RandomAccessFile)localObject).readInt();
      arrayOfByte = new byte[i];
      ((RandomAccessFile)localObject).seek(l + 4L);
      paramInt = 0;
      if (paramInt < i)
      {
        arrayOfByte[paramInt] = ((RandomAccessFile)localObject).readByte();
        paramInt += 1;
      }
      else
      {
        ((RandomAccessFile)localObject).close();
        localObject = new String(arrayOfByte);
        return (String)localObject;
        label150:
        if (paramInt != 0) {
          if (paramInt != i + 1) {}
        }
      }
    }
  }
  
  private boolean h(String paramString)
  {
    if ((paramString == null) || (!paramString.startsWith("&nr"))) {}
    while ((!eL.exists()) && (!aH())) {
      return false;
    }
    for (;;)
    {
      int m;
      try
      {
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(eL, "rw");
        localRandomAccessFile.seek(0L);
        int k = localRandomAccessFile.readInt();
        j = localRandomAccessFile.readInt();
        m = localRandomAccessFile.readInt();
        if (!jdMethod_if(k, j, m))
        {
          localRandomAccessFile.close();
          aH();
          return false;
        }
        if (c.aZ) {
          if (k != c.ay)
          {
            if ((m > 1) && (paramString.equals(jdMethod_for(m - 1))))
            {
              localRandomAccessFile.close();
              return false;
            }
          }
          else
          {
            if (m != 1) {
              break label470;
            }
            i = c.ay;
            if (paramString.equals(jdMethod_for(i)))
            {
              localRandomAccessFile.close();
              return false;
            }
          }
        }
        localRandomAccessFile.seek((m - 1) * 1024 + 12 + 0L);
        if (paramString.length() > 750)
        {
          localRandomAccessFile.close();
          return false;
        }
        paramString = Jni.i(paramString);
        i = paramString.length();
        if (i > 1020)
        {
          localRandomAccessFile.close();
          return false;
        }
        localRandomAccessFile.writeInt(i);
        localRandomAccessFile.writeBytes(paramString);
        if (k == 0)
        {
          localRandomAccessFile.seek(0L);
          localRandomAccessFile.writeInt(1);
          localRandomAccessFile.writeInt(1);
          localRandomAccessFile.writeInt(2);
          localRandomAccessFile.close();
          return true;
        }
        if (k < c.ay - 1)
        {
          localRandomAccessFile.seek(0L);
          localRandomAccessFile.writeInt(k + 1);
          localRandomAccessFile.seek(8L);
          localRandomAccessFile.writeInt(k + 2);
          continue;
        }
        if (k == c.ay - 1)
        {
          localRandomAccessFile.seek(0L);
          localRandomAccessFile.writeInt(c.ay);
          if ((j == 0) || (j == 1)) {
            localRandomAccessFile.writeInt(2);
          }
          localRandomAccessFile.seek(8L);
          localRandomAccessFile.writeInt(1);
          continue;
        }
        if (m == j)
        {
          if (m != c.ay) {
            break label478;
          }
          i = 1;
          if (i != c.ay) {
            break label486;
          }
          j = 1;
          localRandomAccessFile.seek(4L);
          localRandomAccessFile.writeInt(j);
          localRandomAccessFile.writeInt(i);
          continue;
        }
        if (m == c.ay)
        {
          i = 1;
          if (i == j)
          {
            if (i == c.ay)
            {
              j = 1;
              localRandomAccessFile.seek(4L);
              localRandomAccessFile.writeInt(j);
            }
          }
          else
          {
            localRandomAccessFile.seek(8L);
            localRandomAccessFile.writeInt(i);
          }
        }
        else
        {
          i = m + 1;
          continue;
        }
        j = i + 1;
        continue;
        i = m - 1;
      }
      catch (IOException paramString)
      {
        return false;
      }
      label470:
      continue;
      label478:
      int i = m + 1;
      continue;
      label486:
      int j = i + 1;
    }
  }
  
  private static boolean jdMethod_if(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if ((paramInt1 < 0) || (paramInt1 > c.ay)) {
      bool = false;
    }
    do
    {
      return bool;
      if ((paramInt2 < 0) || (paramInt2 > paramInt1 + 1)) {
        return false;
      }
    } while ((paramInt3 >= 1) && (paramInt3 <= paramInt1 + 1) && (paramInt3 <= c.ay));
    return false;
  }
  
  private boolean jdMethod_if(Location paramLocation, int paramInt1, int paramInt2)
  {
    if ((paramLocation == null) || (!c.az) || (!this.e3) || (!y.f8)) {
      return false;
    }
    if (c.av < 5)
    {
      c.av = 5;
      if (c.as >= 5) {
        break label224;
      }
      c.as = 5;
    }
    double d1;
    double d2;
    long l1;
    for (;;)
    {
      d1 = paramLocation.getLongitude();
      d2 = paramLocation.getLatitude();
      l1 = paramLocation.getTime() / 1000L;
      if (!eQ) {
        break label242;
      }
      eW = 1;
      eJ = new StringBuffer("");
      eJ.append(String.format(Locale.CHINA, "&nr=%s&traj=%d,%.5f,%.5f|", new Object[] { this.e1, Long.valueOf(l1), Double.valueOf(d1), Double.valueOf(d2) }));
      e4 = eJ.length();
      eP = l1;
      eT = d1;
      eU = d2;
      eO = Math.floor(d1 * 100000.0D + 0.5D);
      e6 = Math.floor(d2 * 100000.0D + 0.5D);
      eQ = false;
      return true;
      if (c.av <= 1000) {
        break;
      }
      c.av = 1000;
      break;
      label224:
      if (c.as > 3600) {
        c.as = 3600;
      }
    }
    label242:
    paramLocation = new float[1];
    Location.distanceBetween(d2, d1, eU, eT, paramLocation);
    long l2 = eP;
    if ((paramLocation[0] >= c.av) || (l1 - l2 >= c.as))
    {
      if (eJ == null)
      {
        eW += 1;
        e4 = 0;
        eJ = new StringBuffer("");
        eJ.append(String.format(Locale.CHINA, "&nr=%s&traj=%d,%.5f,%.5f|", new Object[] { this.e1, Long.valueOf(l1), Double.valueOf(d1), Double.valueOf(d2) }));
        e4 = eJ.length();
        eP = l1;
        eT = d1;
        eU = d2;
        eO = Math.floor(d1 * 100000.0D + 0.5D);
      }
      long l3;
      for (e6 = Math.floor(d2 * 100000.0D + 0.5D);; e6 = l3)
      {
        if (e4 + 15 > 750)
        {
          h(eJ.toString());
          eJ = null;
        }
        if (eW >= c.ay) {
          this.e3 = false;
        }
        return true;
        eT = d1;
        eU = d2;
        l2 = Math.floor(d1 * 100000.0D + 0.5D);
        l3 = Math.floor(d2 * 100000.0D + 0.5D);
        eN = (int)(l1 - eP);
        eS = (int)(l2 - eO);
        eX = (int)(l3 - e6);
        eJ.append(String.format(Locale.CHINA, "%d,%d,%d|", new Object[] { Integer.valueOf(eN), Integer.valueOf(eS), Integer.valueOf(eX) }));
        e4 = eJ.length();
        eP = l1;
        eO = l2;
      }
    }
    return false;
  }
  
  public void aO()
  {
    aI();
  }
  
  public boolean jdMethod_do(Location paramLocation)
  {
    return jdMethod_if(paramLocation, c.av, c.as);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */