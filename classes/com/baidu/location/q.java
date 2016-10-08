package com.baidu.location;

import android.location.Location;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;

class q
  implements ax, n
{
  private static Location b9;
  private static double cA = 0.0D;
  private static int cB = 0;
  private static final String cC;
  private static Location cD;
  private static ArrayList cE;
  private static final int cG = 2048;
  private static final String cH;
  private static final String cI;
  private static int cJ = 0;
  private static int cK = 0;
  private static ArrayList cL;
  private static q cM = null;
  private static String cN;
  private static final int ca = 2048;
  private static final int cb = 2048;
  private static double cc = 0.0D;
  private static double cd = 0.0D;
  private static int ce = 0;
  private static int cf = 0;
  private static int cg = 0;
  private static int ch = 0;
  private static File ci;
  private static final int cj = 128;
  private static ArrayList ck;
  private static double cl = 0.0D;
  private static int cm = 0;
  private static int co = 0;
  private static final int cp = 1040;
  private static Location cq;
  private static final int cr = 32;
  private static ar.b cs;
  private static ArrayList ct = new ArrayList();
  private static int cu;
  private static ArrayList cv;
  private static final String cw;
  private static int cx;
  private static ArrayList cz;
  long cF = 0L;
  private int cn = 0;
  private b cy = null;
  
  static
  {
    ck = new ArrayList();
    cz = new ArrayList();
    cL = new ArrayList();
    cv = new ArrayList();
    cE = new ArrayList();
    cN = I + "/yo.dat";
    cI = I + "/yoh.dat";
    cH = I + "/yom.dat";
    cw = I + "/yol.dat";
    cC = I + "/yor.dat";
    ci = null;
    cg = 1024;
    cK = 512;
    cf = 8;
    cu = 5;
    cm = 8;
    ce = 16;
    cB = 1024;
    cx = 256;
    cd = 0.0D;
    cA = 0.1D;
    cl = 30.0D;
    cc = 100.0D;
    co = 0;
    ch = 64;
    cJ = 128;
    cq = null;
    cD = null;
    b9 = null;
    cs = null;
  }
  
  public static String B()
  {
    return D();
  }
  
  public static void C() {}
  
  public static String D()
  {
    String str1 = null;
    int i = 1;
    String str2;
    if (i < 5)
    {
      str1 = jdMethod_if(i);
      if (str1 != null) {
        str2 = str1;
      }
    }
    do
    {
      do
      {
        do
        {
          return str2;
          i += 1;
          break;
          jdMethod_if(cE, ch);
          if (cE.size() > 0)
          {
            str1 = (String)cE.get(0);
            cE.remove(0);
          }
          str2 = str1;
        } while (str1 != null);
        jdMethod_if(cE, co);
        if (cE.size() > 0)
        {
          str1 = (String)cE.get(0);
          cE.remove(0);
        }
        str2 = str1;
      } while (str1 != null);
      jdMethod_if(cE, cJ);
      str2 = str1;
    } while (cE.size() <= 0);
    str1 = (String)cE.get(0);
    cE.remove(0);
    return str1;
  }
  
  public static void F() {}
  
  public static void jdMethod_case(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      if (!localFile.exists())
      {
        paramString = new File(I);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        paramString = localFile;
        if (!localFile.createNewFile()) {
          paramString = null;
        }
        paramString = new RandomAccessFile(paramString, "rw");
        paramString.seek(0L);
        paramString.writeInt(32);
        paramString.writeInt(2048);
        paramString.writeInt(1040);
        paramString.writeInt(0);
        paramString.writeInt(0);
        paramString.writeInt(0);
        paramString.close();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void jdMethod_char(String paramString)
  {
    int i = c.aM;
    ArrayList localArrayList;
    if (i == 1)
    {
      localArrayList = cL;
      if (localArrayList != null) {
        break label42;
      }
    }
    for (;;)
    {
      return;
      if (i == 2)
      {
        localArrayList = cv;
        break;
      }
      if (i == 3)
      {
        localArrayList = cE;
        break;
        label42:
        if (localArrayList.size() <= ce) {
          localArrayList.add(paramString);
        }
        if (localArrayList.size() >= ce) {
          jdMethod_if(i, false);
        }
        while (localArrayList.size() > ce) {
          localArrayList.remove(0);
        }
      }
    }
  }
  
  public static void jdMethod_do(t.a parama, ar.b paramb, Location paramLocation, String paramString)
  {
    ar.b localb = null;
    Object localObject = null;
    if (!y.f6) {}
    label12:
    do
    {
      do
      {
        break label12;
        break label12;
        break label12;
        break label12;
        do
        {
          return;
        } while ((c.ak == 3) && (!jdMethod_if(paramLocation, paramb)) && (!jdMethod_if(paramLocation, false)));
        if ((parama == null) || (!parama.jdMethod_do())) {
          break;
        }
        localb = paramb;
        if (!jdMethod_if(paramLocation, paramb)) {
          localb = null;
        }
        parama = c.jdMethod_if(parama, localb, paramLocation, paramString, 1);
      } while (parama == null);
      jdMethod_goto(Jni.i(parama));
      cD = paramLocation;
      cq = paramLocation;
    } while (localb == null);
    cs = localb;
    return;
    if ((paramb != null) && (paramb.jdMethod_if()) && (jdMethod_if(paramLocation, paramb)))
    {
      if (jdMethod_if(paramLocation)) {
        break label231;
      }
      parama = (t.a)localObject;
    }
    label229:
    label231:
    for (;;)
    {
      parama = c.jdMethod_if(parama, paramb, paramLocation, paramString, 2);
      if (parama == null) {
        break;
      }
      jdMethod_else(Jni.i(parama));
      b9 = paramLocation;
      cq = paramLocation;
      if (paramb == null) {
        break;
      }
      cs = paramb;
      return;
      if (!jdMethod_if(paramLocation)) {
        parama = null;
      }
      if (!jdMethod_if(paramLocation, paramb)) {
        paramb = localb;
      }
      for (;;)
      {
        if ((parama == null) && (paramb == null)) {
          break label229;
        }
        parama = c.jdMethod_if(parama, paramb, paramLocation, paramString, 3);
        if (parama == null) {
          break;
        }
        jdMethod_void(Jni.i(parama));
        cq = paramLocation;
        if (paramb == null) {
          break;
        }
        cs = paramb;
        return;
      }
      break label12;
    }
  }
  
  private static void jdMethod_else(String paramString)
  {
    jdMethod_char(paramString);
  }
  
  private static void jdMethod_goto(String paramString)
  {
    jdMethod_char(paramString);
  }
  
  private static int jdMethod_if(List paramList, int paramInt)
  {
    if ((paramList == null) || (paramInt > 256) || (paramInt < 0)) {
      return -1;
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        if (ci == null)
        {
          ci = new File(cN);
          if (!ci.exists())
          {
            ci = null;
            return -2;
          }
        }
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(ci, "rw");
        if (localRandomAccessFile.length() < 1L)
        {
          localRandomAccessFile.close();
          return -3;
        }
        localRandomAccessFile.seek(paramInt);
        int k = localRandomAccessFile.readInt();
        j = localRandomAccessFile.readInt();
        int m = localRandomAccessFile.readInt();
        int n = localRandomAccessFile.readInt();
        long l = localRandomAccessFile.readLong();
        if ((!jdMethod_if(k, j, m, n, l)) || (j < 1))
        {
          localRandomAccessFile.close();
          return -4;
        }
        byte[] arrayOfByte = new byte[cB];
        i = cf;
        if ((i > 0) && (j > 0))
        {
          localRandomAccessFile.seek((k + j - 1) % m * n + l);
          int i1 = localRandomAccessFile.readInt();
          if ((i1 > 0) && (i1 < n))
          {
            localRandomAccessFile.read(arrayOfByte, 0, i1);
            if (arrayOfByte[(i1 - 1)] == 0) {
              paramList.add(new String(arrayOfByte, 0, i1 - 1));
            }
          }
        }
        else
        {
          localRandomAccessFile.seek(paramInt);
          localRandomAccessFile.writeInt(k);
          localRandomAccessFile.writeInt(j);
          localRandomAccessFile.writeInt(m);
          localRandomAccessFile.writeInt(n);
          localRandomAccessFile.writeLong(l);
          localRandomAccessFile.close();
          paramInt = cf;
          return paramInt - i;
        }
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return -5;
      }
      i -= 1;
      j -= 1;
    }
  }
  
  public static String jdMethod_if(int paramInt)
  {
    Object localObject3 = null;
    Object localObject2;
    ArrayList localArrayList;
    if (paramInt == 1)
    {
      localObject2 = cI;
      localArrayList = cL;
    }
    while (localArrayList == null)
    {
      do
      {
        return null;
        if (paramInt == 2)
        {
          localObject2 = cH;
          localArrayList = cv;
          break;
        }
        if (paramInt == 3)
        {
          localObject2 = cw;
          localArrayList = cE;
          break;
        }
      } while (paramInt != 4);
      localObject2 = cC;
      localArrayList = cE;
    }
    if (localArrayList.size() < 1) {
      jdMethod_if((String)localObject2, localArrayList);
    }
    try
    {
      paramInt = localArrayList.size();
      localObject2 = localObject3;
      if (paramInt > 0)
      {
        localObject2 = (String)localArrayList.get(paramInt - 1);
        localArrayList.remove(paramInt - 1);
      }
      return (String)localObject2;
    }
    finally {}
  }
  
  public static String jdMethod_if(t.a parama, ar.b paramb, Location paramLocation, String paramString1, String paramString2)
  {
    if (!y.f6) {
      return null;
    }
    return c.jdMethod_if(parama, paramb, paramLocation, paramString1) + paramString2;
  }
  
  public static void jdMethod_if(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    if (paramDouble1 > 0.0D)
    {
      cd = paramDouble1;
      cA = paramDouble2;
      if (paramDouble3 <= 20.0D) {
        break label41;
      }
    }
    for (;;)
    {
      cl = paramDouble3;
      cc = paramDouble4;
      return;
      paramDouble1 = cd;
      break;
      label41:
      paramDouble3 = cl;
    }
  }
  
  public static void jdMethod_if(int paramInt1, int paramInt2) {}
  
  public static void jdMethod_if(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public static void jdMethod_if(int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    ArrayList localArrayList;
    label18:
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = cI;
      if (paramBoolean) {
        return;
      }
      localArrayList = cL;
      localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        jdMethod_case((String)localObject1);
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new RandomAccessFile((File)localObject2, "rw");
        ((RandomAccessFile)localObject1).seek(4L);
        int i1 = ((RandomAccessFile)localObject1).readInt();
        int i2 = ((RandomAccessFile)localObject1).readInt();
        j = ((RandomAccessFile)localObject1).readInt();
        k = ((RandomAccessFile)localObject1).readInt();
        i = ((RandomAccessFile)localObject1).readInt();
        m = localArrayList.size();
        if (m <= cm) {
          break label460;
        }
        if (!paramBoolean) {
          break label457;
        }
        i += 1;
        if (j < i1)
        {
          ((RandomAccessFile)localObject1).seek(i2 * j + 128);
          localObject2 = ((String)localArrayList.get(0) + '\000').getBytes();
          ((RandomAccessFile)localObject1).writeInt(localObject2.length);
          ((RandomAccessFile)localObject1).write((byte[])localObject2, 0, localObject2.length);
          localArrayList.remove(0);
          n = j + 1;
          j = k;
          k = n;
          n = m - 1;
          m = k;
          k = j;
          j = m;
          m = n;
          continue;
          if (paramInt == 2)
          {
            localObject1 = cH;
            if (paramBoolean)
            {
              localArrayList = cL;
              break label18;
            }
            localArrayList = cv;
            break label18;
          }
          if (paramInt == 3)
          {
            localObject1 = cw;
            if (paramBoolean)
            {
              localArrayList = cv;
              break label18;
            }
            localArrayList = cE;
            break label18;
          }
          if (paramInt != 4) {
            break;
          }
          localObject1 = cC;
          if (!paramBoolean) {
            break;
          }
          localArrayList = cE;
          break label18;
        }
        if (!paramBoolean) {
          break label481;
        }
        long l = k * i2 + 128;
        ((RandomAccessFile)localObject1).seek(l);
        localObject2 = ((String)localArrayList.get(0) + '\000').getBytes();
        ((RandomAccessFile)localObject1).writeInt(localObject2.length);
        ((RandomAccessFile)localObject1).write((byte[])localObject2, 0, localObject2.length);
        localArrayList.remove(0);
        n = k + 1;
        k = n;
        if (n <= j) {
          break label466;
        }
        k = 0;
      }
      catch (Exception localException)
      {
        int i;
        return;
      }
      ((RandomAccessFile)localObject1).seek(12L);
      ((RandomAccessFile)localObject1).writeInt(j);
      ((RandomAccessFile)localObject1).writeInt(k);
      ((RandomAccessFile)localObject1).writeInt(i);
      ((RandomAccessFile)localObject1).close();
      if ((m == 0) || (paramInt >= 4)) {
        break;
      }
      jdMethod_if(paramInt + 1, true);
      return;
      label457:
      continue;
      label460:
      int m = 0;
      continue;
      label466:
      int n = j;
      int j = k;
      int k = n;
      continue;
      label481:
      m = 1;
    }
  }
  
  public static void jdMethod_if(String paramString, int paramInt) {}
  
  public static void jdMethod_if(String paramString, int paramInt, boolean paramBoolean) {}
  
  private static boolean jdMethod_if(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    if ((paramInt1 < 0) || (paramInt1 >= paramInt3)) {}
    while ((paramInt2 < 0) || (paramInt2 > paramInt3) || (paramInt3 < 0) || (paramInt3 > 1024) || (paramInt4 < 128) || (paramInt4 > 1024)) {
      return false;
    }
    return true;
  }
  
  private static boolean jdMethod_if(Location paramLocation)
  {
    boolean bool = true;
    if (paramLocation == null) {
      bool = false;
    }
    double d1;
    double d2;
    double d3;
    double d4;
    do
    {
      return bool;
      if ((cD == null) || (cq == null))
      {
        cD = paramLocation;
        return true;
      }
      d1 = paramLocation.distanceTo(cD);
      d2 = c.bd;
      d3 = c.ba;
      d4 = c.a8;
    } while (paramLocation.distanceTo(cq) > d1 * d3 + d2 * d1 * d1 + d4);
    return false;
  }
  
  private static boolean jdMethod_if(Location paramLocation, ar.b paramb)
  {
    if ((paramLocation == null) || (paramb == null) || (paramb.jdField_for == null) || (paramb.jdField_for.isEmpty())) {}
    while (paramb.jdMethod_do(cs)) {
      return false;
    }
    if (b9 == null)
    {
      b9 = paramLocation;
      return true;
    }
    return true;
  }
  
  public static boolean jdMethod_if(Location paramLocation, boolean paramBoolean)
  {
    return x.jdMethod_if(cq, paramLocation, paramBoolean);
  }
  
  public static boolean jdMethod_if(String paramString, List paramList)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return false;
    }
    for (;;)
    {
      int i;
      int j;
      int k;
      boolean bool2;
      try
      {
        paramString = new RandomAccessFile(paramString, "rw");
        paramString.seek(8L);
        int n = paramString.readInt();
        i = paramString.readInt();
        m = paramString.readInt();
        byte[] arrayOfByte = new byte[cB];
        j = cm;
        j += 1;
        bool1 = false;
        long l;
        if ((j > 0) && (i > 0))
        {
          k = m;
          if (i < m) {
            k = 0;
          }
          l = (i - 1) * n + 128;
        }
        try
        {
          paramString.seek(l);
          m = paramString.readInt();
          bool2 = bool1;
          if (m <= 0) {
            break label220;
          }
          bool2 = bool1;
          if (m >= n) {
            break label220;
          }
          paramString.read(arrayOfByte, 0, m);
          bool2 = bool1;
          if (arrayOfByte[(m - 1)] != 0) {
            break label220;
          }
          paramList.add(0, new String(arrayOfByte, 0, m - 1));
          bool2 = true;
        }
        catch (Exception paramString)
        {
          return bool1;
        }
        paramString.seek(12L);
        paramString.writeInt(i);
        paramString.writeInt(m);
        paramString.close();
        return bool1;
      }
      catch (Exception paramString)
      {
        return false;
      }
      label220:
      j -= 1;
      i -= 1;
      boolean bool1 = bool2;
      int m = k;
    }
  }
  
  private static void jdMethod_void(String paramString)
  {
    jdMethod_char(paramString);
  }
  
  public static void w()
  {
    cm = 0;
    jdMethod_if(1, false);
    jdMethod_if(2, false);
    jdMethod_if(3, false);
    cm = 8;
  }
  
  public static q x()
  {
    if (cM == null) {
      cM = new q();
    }
    return cM;
  }
  
  public static String y()
  {
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject6 = new File(cH);
    Object localObject1 = localObject3;
    if (((File)localObject6).exists()) {
      localObject1 = localObject5;
    }
    try
    {
      localObject6 = new RandomAccessFile((File)localObject6, "rw");
      localObject1 = localObject5;
      ((RandomAccessFile)localObject6).seek(20L);
      localObject1 = localObject5;
      i = ((RandomAccessFile)localObject6).readInt();
      if (i > 128)
      {
        localObject1 = localObject5;
        localObject3 = "&p1=" + i;
        localObject1 = localObject3;
        ((RandomAccessFile)localObject6).seek(20L);
        localObject1 = localObject3;
        ((RandomAccessFile)localObject6).writeInt(0);
        localObject1 = localObject3;
        ((RandomAccessFile)localObject6).close();
        return (String)localObject3;
      }
      localObject1 = localObject5;
      ((RandomAccessFile)localObject6).close();
      localObject1 = localObject3;
    }
    catch (Exception localException3)
    {
      int i;
      Object localObject2;
      Object localObject4;
      for (;;) {}
      return localException3;
    }
    localObject5 = new File(cw);
    localObject3 = localObject1;
    if (((File)localObject5).exists())
    {
      localObject3 = localObject1;
      try
      {
        localObject5 = new RandomAccessFile((File)localObject5, "rw");
        localObject3 = localObject1;
        ((RandomAccessFile)localObject5).seek(20L);
        localObject3 = localObject1;
        i = ((RandomAccessFile)localObject5).readInt();
        if (i > 256)
        {
          localObject3 = localObject1;
          localObject1 = "&p2=" + i;
          localObject3 = localObject1;
          ((RandomAccessFile)localObject5).seek(20L);
          localObject3 = localObject1;
          ((RandomAccessFile)localObject5).writeInt(0);
          localObject3 = localObject1;
          ((RandomAccessFile)localObject5).close();
          return (String)localObject1;
        }
      }
      catch (Exception localException1) {}
    }
    for (;;)
    {
      localObject5 = new File(cC);
      if (!((File)localObject5).exists()) {
        return localObject3;
      }
      localObject2 = localObject3;
      try
      {
        localObject5 = new RandomAccessFile((File)localObject5, "rw");
        localObject2 = localObject3;
        ((RandomAccessFile)localObject5).seek(20L);
        localObject2 = localObject3;
        i = ((RandomAccessFile)localObject5).readInt();
        if (i <= 512) {
          break;
        }
        localObject2 = localObject3;
        localObject3 = "&p3=" + i;
        localObject2 = localObject3;
        ((RandomAccessFile)localObject5).seek(20L);
        localObject2 = localObject3;
        ((RandomAccessFile)localObject5).writeInt(0);
        localObject2 = localObject3;
        ((RandomAccessFile)localObject5).close();
        return (String)localObject3;
      }
      catch (Exception localException2)
      {
        return (String)localObject2;
      }
      localObject4 = localObject2;
      ((RandomAccessFile)localObject5).close();
      localObject4 = localObject2;
    }
    localObject2 = localObject4;
    ((RandomAccessFile)localObject5).close();
    return (String)localObject4;
  }
  
  public void A()
  {
    this.cF = System.currentTimeMillis();
    if (o.ac().ab()) {}
    do
    {
      return;
      this.cn += 1;
    } while (this.cn <= 1);
    this.cn = 0;
    E();
  }
  
  public void E()
  {
    if (!ar.bU()) {
      return;
    }
    this.cy.af();
  }
  
  public void jdMethod_long(String paramString)
  {
    new a(paramString).ae();
  }
  
  public void z()
  {
    if ((!aw.jdMethod_do().jdMethod_int()) || (this.cF == 0L)) {}
    while (System.currentTimeMillis() - this.cF <= 1200000L) {
      return;
    }
    A();
  }
  
  private class a
    extends s
  {
    private String dl;
    
    public a(String paramString)
    {
      this.dl = paramString;
      this.cT = new ArrayList();
    }
    
    void T()
    {
      this.cR = c.jdMethod_for();
      this.cT.add(new BasicNameValuePair("cldc[0]", this.dl));
    }
    
    public void ae()
    {
      N();
    }
    
    void jdMethod_do(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.cS != null)) {}
    }
  }
  
  private class b
    extends s
  {
    boolean dn = false;
    private ArrayList dp = null;
    int dq = 0;
    int dr = 0;
    
    public b()
    {
      this.cT = new ArrayList();
    }
    
    void T()
    {
      this.cR = c.jdMethod_for();
      this.c0 = 2;
      if (this.dp != null)
      {
        int i = 0;
        if (i < this.dp.size())
        {
          if (this.dr == 1) {
            this.cT.add(new BasicNameValuePair("cldc[" + i + "]", (String)this.dp.get(i)));
          }
          for (;;)
          {
            i += 1;
            break;
            this.cT.add(new BasicNameValuePair("cltr[" + i + "]", (String)this.dp.get(i)));
          }
        }
        String str = String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        this.cT.add(new BasicNameValuePair("trtm", str));
      }
    }
    
    public void af()
    {
      if (this.dn) {
        return;
      }
      if ((cY > 4) && (this.dq < cY))
      {
        this.dq += 1;
        return;
      }
      this.dq = 0;
      this.dn = true;
      this.dr = 0;
      int i;
      if ((this.dp == null) || (this.dp.size() < 1))
      {
        if (this.dp == null) {
          this.dp = new ArrayList();
        }
        this.dr = 0;
        i = 0;
        if (this.dr >= 2) {
          break label250;
        }
      }
      label143:
      label176:
      Object localObject2;
      label214:
      label245:
      label250:
      for (Object localObject1 = q.B();; localObject2 = null)
      {
        if ((localObject1 == null) && (this.dr != 1))
        {
          this.dr = 2;
          try
          {
            if (c.aV != 0) {
              break label176;
            }
            str = l.s();
            localObject1 = str;
            if (str == null) {
              localObject1 = w.aM();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              String str;
              localObject2 = null;
            }
          }
          if (localObject1 != null) {
            break label214;
          }
        }
        for (;;)
        {
          if ((this.dp != null) && (this.dp.size() >= 1)) {
            break label245;
          }
          this.dp = null;
          this.dn = false;
          return;
          if (c.aV != 1) {
            break label143;
          }
          str = w.aM();
          localObject1 = str;
          if (str != null) {
            break label143;
          }
          localObject1 = l.s();
          break label143;
          this.dr = 1;
          break label143;
          this.dp.add(localObject2);
          int j = i + ((String)localObject2).length();
          i = j;
          if (j < 5120) {
            break;
          }
        }
        N();
        return;
      }
    }
    
    void jdMethod_do(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.cS != null) && (this.dp != null)) {
        this.dp.clear();
      }
      if (this.cT != null) {
        this.cT.clear();
      }
      this.dn = false;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */