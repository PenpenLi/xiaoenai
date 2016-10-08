package com.baidu.location;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.GpsStatus.NmeaListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

class x
  implements ax, n
{
  private static int fB = 0;
  private static final int fC = 1;
  private static String fE;
  private static final int fH = 3;
  private static final int fJ = 10000;
  private static final int fM = 5;
  private static x fN = null;
  private static File fO = new File(I, fY);
  private static final int fV = 290000;
  private static String fY;
  private static StringBuilder fp;
  private static final double fq = 1.0E-5D;
  private static final int fs = 3000;
  private static String fu;
  private long fA = 0L;
  private final long fD = 1000L;
  private final int fF = 3;
  private Location fG;
  private boolean fI = false;
  private long fK;
  private b fL = null;
  private boolean fP = false;
  private c fQ = null;
  private String fR = null;
  private Location fS;
  private final int fT = 1;
  private long fU = 0L;
  private long fW;
  private int fX;
  private long fZ;
  private GpsStatus fg;
  private int fh;
  private Handler fi = null;
  private final int fj = 2;
  private LocationManager fk = null;
  private boolean fl = false;
  private Location fm;
  private a fn = null;
  private final int fo = 4;
  private HashMap fr;
  private long ft = 0L;
  private Location fv;
  private long fw = 0L;
  private long fx;
  private Location fy;
  private Context fz;
  
  static
  {
    fB = 0;
    fE = null;
    fY = "Temp_in.dat";
  }
  
  public static x a4()
  {
    if (fN == null) {
      fN = new x();
    }
    return fN;
  }
  
  private boolean aQ()
  {
    return false;
  }
  
  private static String aX()
  {
    if (fp != null)
    {
      if (!TextUtils.isEmpty(fp.toString())) {
        fp.insert(0, "&snls=");
      }
      if (!TextUtils.isEmpty(fu)) {
        fp.append("&pogr=").append(fu);
      }
      return fp.toString();
    }
    return null;
  }
  
  public static String jdMethod_byte(Location paramLocation)
  {
    String str = jdMethod_case(paramLocation);
    paramLocation = str;
    if (str != null) {
      paramLocation = str + "&g_tp=0";
    }
    return paramLocation;
  }
  
  public static String jdMethod_case(Location paramLocation)
  {
    float f3 = -1.0F;
    if (paramLocation == null) {
      return null;
    }
    float f1 = (float)(paramLocation.getSpeed() * 3.6D);
    if (!paramLocation.hasSpeed()) {
      f1 = -1.0F;
    }
    float f2;
    int i;
    if (paramLocation.hasAccuracy())
    {
      f2 = paramLocation.getAccuracy();
      i = (int)f2;
      if (!paramLocation.hasAltitude()) {
        break label174;
      }
    }
    label174:
    for (double d = paramLocation.getAltitude();; d = 555.0D)
    {
      f2 = f3;
      if (paramLocation.hasBearing()) {
        f2 = paramLocation.getBearing();
      }
      return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d", new Object[] { Double.valueOf(paramLocation.getLongitude()), Double.valueOf(paramLocation.getLatitude()), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(fB), Double.valueOf(d), Long.valueOf(paramLocation.getTime() / 1000L) });
      f2 = -1.0F;
      break;
    }
  }
  
  private double[] jdMethod_do(double paramDouble1, double paramDouble2)
  {
    return new double[] { Math.sin(Math.toRadians(paramDouble2)) * paramDouble1, Math.cos(Math.toRadians(paramDouble2)) * paramDouble1 };
  }
  
  private void jdMethod_for(Location paramLocation)
  {
    this.fS = paramLocation;
    if (this.fS == null) {
      this.fR = null;
    }
    try
    {
      w.aK().jdMethod_do(this.fS);
      if (aR())
      {
        k.p().jdMethod_byte(aP());
        if ((fB > 2) && (q.jdMethod_if(this.fS, true)))
        {
          ar.bW().b3();
          q.jdMethod_do(t.an().ak(), ar.bW().bS(), this.fS, k.p().o());
        }
      }
      return;
      l = System.currentTimeMillis();
      this.fS.setTime(l);
      f = (float)(this.fS.getSpeed() * 3.6D);
      if (!this.fS.hasSpeed()) {
        f = -1.0F;
      }
      j = fB;
      i = j;
      if (j != 0) {}
    }
    catch (Exception paramLocation)
    {
      try
      {
        for (;;)
        {
          long l;
          float f;
          i = this.fS.getExtras().getInt("satellites");
          this.fR = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", new Object[] { Double.valueOf(this.fS.getLongitude()), Double.valueOf(this.fS.getLatitude()), Float.valueOf(f), Float.valueOf(this.fS.getBearing()), Integer.valueOf(i), Long.valueOf(l) });
          jdMethod_if(this.fS.getLongitude(), this.fS.getLatitude(), f);
        }
        paramLocation = paramLocation;
      }
      catch (Exception paramLocation)
      {
        for (;;)
        {
          int j;
          int i = j;
        }
      }
    }
  }
  
  private double[] jdMethod_for(double paramDouble1, double paramDouble2)
  {
    double d = 0.0D;
    if (paramDouble2 == 0.0D) {
      if (paramDouble1 > 0.0D) {
        d = 90.0D;
      }
    }
    for (;;)
    {
      return new double[] { Math.sqrt(paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2), d };
      if (paramDouble1 < 0.0D)
      {
        d = 270.0D;
        continue;
        d = Math.toDegrees(Math.atan(paramDouble1 / paramDouble2));
      }
    }
  }
  
  private int jdMethod_if(at paramat, int paramInt)
  {
    if (fB >= c.W) {}
    do
    {
      double d;
      do
      {
        do
        {
          return 1;
          if (fB <= c.aI) {
            return 4;
          }
          d = paramat.cT();
        } while (d <= c.ae);
        if (d >= c.aR) {
          return 4;
        }
        d = paramat.cW();
      } while (d <= c.ag);
      if (d >= c.aT) {
        return 4;
      }
    } while (paramInt >= c.X);
    if (paramInt <= c.aJ) {
      return 4;
    }
    if (this.fr != null) {
      return jdMethod_if(this.fr);
    }
    return 3;
  }
  
  private int jdMethod_if(HashMap paramHashMap)
  {
    Object localObject1;
    ArrayList localArrayList;
    int i;
    Object localObject2;
    int j;
    if (this.fX > 4)
    {
      localObject1 = new ArrayList();
      localArrayList = new ArrayList();
      paramHashMap = paramHashMap.entrySet().iterator();
      i = 0;
      if (paramHashMap.hasNext())
      {
        localObject2 = (List)((Map.Entry)paramHashMap.next()).getValue();
        if (localObject2 == null) {
          break label371;
        }
        localObject2 = jdMethod_if((List)localObject2);
        if (localObject2 == null) {
          break label371;
        }
        ((List)localObject1).add(localObject2);
        j = i + 1;
        localArrayList.add(Integer.valueOf(i));
        i = j;
      }
    }
    label371:
    for (;;)
    {
      break;
      if (!((List)localObject1).isEmpty())
      {
        paramHashMap = new double[2];
        j = ((List)localObject1).size();
        i = 0;
        while (i < j)
        {
          localObject2 = (double[])((List)localObject1).get(i);
          int k = ((Integer)localArrayList.get(i)).intValue();
          localObject2[0] *= k;
          localObject2[1] *= k;
          paramHashMap[0] += localObject2[0];
          paramHashMap[1] += localObject2[1];
          i += 1;
        }
        paramHashMap[0] /= j;
        paramHashMap[1] /= j;
        localObject1 = jdMethod_for(paramHashMap[0], paramHashMap[1]);
        fu = String.format(Locale.CHINA, "%d,%d,%d,%d", new Object[] { Long.valueOf(Math.round(paramHashMap[0] * 100.0D)), Long.valueOf(Math.round(paramHashMap[1] * 100.0D)), Long.valueOf(Math.round(localObject1[0] * 100.0D)), Long.valueOf(Math.round(localObject1[1] * 100.0D)) });
        if (localObject1[0] <= c.ax) {
          return 1;
        }
        if (localObject1[0] >= c.a4) {
          return 4;
        }
      }
      return 3;
    }
  }
  
  private String jdMethod_if(GpsSatellite paramGpsSatellite, HashMap paramHashMap)
  {
    int k = (int)Math.floor(paramGpsSatellite.getAzimuth() / 30.0F);
    float f1 = paramGpsSatellite.getElevation();
    int j = (int)Math.floor(f1 / 15.0F);
    float f2 = paramGpsSatellite.getSnr();
    int m = Math.round(f2 / 5.0F);
    if ((f2 >= 10.0F) && (f1 >= 1.0F))
    {
      List localList = (List)paramHashMap.get(Integer.valueOf(m));
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      ((List)localObject).add(paramGpsSatellite);
      paramHashMap.put(Integer.valueOf(m), localObject);
      this.fX += 1;
    }
    int i = k;
    if (k >= 12) {
      i = 11;
    }
    if (j >= 6) {
      j = 5;
    }
    for (;;)
    {
      return String.format(Locale.CHINA, "%02d%d", new Object[] { Integer.valueOf(j + i * 6 + 1), Integer.valueOf(m) });
    }
  }
  
  private void jdMethod_if(double paramDouble1, double paramDouble2, float paramFloat)
  {
    int j = 0;
    if (!y.f1) {}
    for (;;)
    {
      return;
      int i = j;
      if (paramDouble1 >= 73.146973D)
      {
        i = j;
        if (paramDouble1 <= 135.252686D)
        {
          i = j;
          if (paramDouble2 <= 54.258807D)
          {
            i = j;
            if (paramDouble2 >= 14.604847D)
            {
              if (paramFloat <= 18.0F) {
                break label85;
              }
              i = j;
            }
          }
        }
      }
      while (c.ak != i)
      {
        c.ak = i;
        return;
        label85:
        double d1 = c.aH;
        double d2 = c.ac;
        i = (int)((paramDouble1 - d1) * 1000.0D);
        int k = (int)((d2 - paramDouble2) * 1000.0D);
        if ((i > 0) && (i < 50) && (k > 0) && (k < 50))
        {
          k = i + k * 50;
          i = j;
          if (c.ar) {
            i = c.aB[(k >> 2)] >> (k & 0x3) * 2 & 0x3;
          }
        }
        else
        {
          String str = String.format(Locale.CHINA, "&ll=%.5f|%.5f", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
          str = str + "&im=" + az.cn().ck();
          c.a9 = paramDouble1;
          c.an = paramDouble2;
          y.a7().n(str);
          i = j;
        }
      }
    }
  }
  
  private void jdMethod_if(String paramString, Location paramLocation)
  {
    paramString = paramString + k.p().o();
    q.jdMethod_do(t.an().ak(), ar.bW().bS(), paramLocation, paramString);
  }
  
  public static boolean jdMethod_if(Location paramLocation1, Location paramLocation2, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramLocation1 == paramLocation2) {
      bool1 = false;
    }
    float f2;
    do
    {
      do
      {
        float f1;
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool2;
              } while (paramLocation1 == null);
              bool1 = bool2;
            } while (paramLocation2 == null);
            f1 = paramLocation2.getSpeed();
            if ((!paramBoolean) || (c.ak != 3)) {
              break;
            }
            bool1 = bool2;
          } while (f1 < 5.0F);
          f2 = paramLocation2.distanceTo(paramLocation1);
          if (f1 <= c.bb) {
            break;
          }
          bool1 = bool2;
        } while (f2 > c.a0);
        return false;
        if (f1 <= c.be) {
          break;
        }
        bool1 = bool2;
      } while (f2 > c.ap);
      return false;
      bool1 = bool2;
    } while (f2 > 5.0F);
    return false;
  }
  
  private double[] jdMethod_if(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    double[] arrayOfDouble = new double[2];
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (GpsSatellite)localIterator.next();
      if (localObject != null)
      {
        localObject = jdMethod_do(90.0F - ((GpsSatellite)localObject).getElevation(), ((GpsSatellite)localObject).getAzimuth());
        arrayOfDouble[0] += localObject[0];
        arrayOfDouble[1] += localObject[1];
      }
    }
    int i = paramList.size();
    arrayOfDouble[0] /= i;
    arrayOfDouble[1] /= i;
    return arrayOfDouble;
  }
  
  private void jdMethod_int(Location paramLocation)
  {
    paramLocation = this.fi.obtainMessage(1, paramLocation);
    this.fi.sendMessage(paramLocation);
  }
  
  public static String jdMethod_new(Location paramLocation)
  {
    Object localObject = jdMethod_case(paramLocation);
    paramLocation = (Location)localObject;
    if (localObject != null) {
      paramLocation = (String)localObject + fE;
    }
    String str = aX();
    localObject = paramLocation;
    if (!TextUtils.isEmpty(str)) {
      localObject = paramLocation + str;
    }
    return (String)localObject;
  }
  
  private void jdMethod_new(boolean paramBoolean)
  {
    this.fP = paramBoolean;
    if ((paramBoolean) && (!aR())) {}
  }
  
  private void jdMethod_try(Location paramLocation)
  {
    long l = System.currentTimeMillis();
    this.fG = paramLocation;
    this.fW = l;
    if ((this.fK == 0L) || (l - this.fK >= 290000L) || (this.fy == null))
    {
      if (this.fm != null) {
        break label82;
      }
      this.fm = paramLocation;
      this.fv = this.fm;
      this.fK = l;
      this.fZ = this.fK;
      this.fy = null;
    }
    label82:
    while (l - this.fK < 10000L) {
      return;
    }
    this.fy = paramLocation;
    String str = String.format("&dt=%.6f|%.6f|%s|%s|%s", new Object[] { Double.valueOf(this.fy.getLongitude() - this.fm.getLongitude()), Double.valueOf(this.fy.getLatitude() - this.fm.getLatitude()), Float.valueOf(this.fy.getSpeed()), Float.valueOf(this.fy.getBearing()), Long.valueOf(l - this.fK) });
    paramLocation = q.jdMethod_if(t.an().ak(), ar.bW().bS(), paramLocation, k.p().o(), str);
    if (!TextUtils.isEmpty(paramLocation))
    {
      paramLocation = Jni.i(paramLocation);
      q.x().jdMethod_long(paramLocation);
    }
    this.fm = null;
  }
  
  public void a0()
  {
    try
    {
      if ((this.fG != null) || (this.fv != null))
      {
        String str = String.format(Locale.CHINA, "&dt=%.6f|%.6f|%s|%s|%s", new Object[] { Double.valueOf(this.fG.getLongitude() - this.fv.getLongitude()), Double.valueOf(this.fG.getLatitude() - this.fv.getLatitude()), Float.valueOf(this.fG.getSpeed()), Float.valueOf(this.fG.getBearing()), Long.valueOf(this.fW - this.fZ) });
        str = q.jdMethod_if(t.an().ak(), ar.bW().bS(), this.fG, k.p().o(), str);
        if (!TextUtils.isEmpty(str))
        {
          str = Jni.i(str);
          q.x().jdMethod_long(str);
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean a1()
  {
    if (this.fk != null) {
      return this.fk.isProviderEnabled("gps");
    }
    return false;
  }
  
  public void a2()
  {
    if (this.fI) {
      return;
    }
    try
    {
      this.fL = new b(null);
      this.fk.requestLocationUpdates("gps", 1000L, 0.0F, this.fL);
      this.fk.addNmeaListener(this.fn);
      this.fI = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a3()
  {
    if (!this.fI) {
      return;
    }
    if (this.fk != null) {}
    try
    {
      if (this.fL != null) {
        this.fk.removeUpdates(this.fL);
      }
      if (this.fn != null) {
        this.fk.removeNmeaListener(this.fn);
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    c.al = 0;
    c.ak = 0;
    this.fL = null;
    this.fI = false;
    jdMethod_new(false);
  }
  
  public String aP()
  {
    String str = null;
    if (this.fS != null)
    {
      str = "{\"result\":{\"time\":\"" + c.jdMethod_new() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\"," + "\"s\":\"%f\",\"n\":\"%d\"}}";
      if (!this.fS.hasAccuracy()) {
        break label213;
      }
    }
    label213:
    for (float f = this.fS.getAccuracy();; f = 10.0F)
    {
      int i = (int)f;
      f = (float)(this.fS.getSpeed() * 3.6D);
      double[] arrayOfDouble = Jni.jdMethod_if(this.fS.getLongitude(), this.fS.getLatitude(), "gps2gcj");
      if ((arrayOfDouble[0] <= 0.0D) && (arrayOfDouble[1] <= 0.0D))
      {
        arrayOfDouble[0] = this.fS.getLongitude();
        arrayOfDouble[1] = this.fS.getLatitude();
      }
      str = String.format(Locale.CHINA, str, new Object[] { Double.valueOf(arrayOfDouble[0]), Double.valueOf(arrayOfDouble[1]), Integer.valueOf(i), Float.valueOf(this.fS.getBearing()), Float.valueOf(f), Integer.valueOf(fB) });
      return str;
    }
  }
  
  public boolean aR()
  {
    if (!aT()) {}
    while (System.currentTimeMillis() - this.fA > 10000L) {
      return false;
    }
    long l = System.currentTimeMillis();
    if ((this.fl) && (l - this.ft < 3000L)) {
      return true;
    }
    return this.fP;
  }
  
  public Location aS()
  {
    return this.fS;
  }
  
  public boolean aT()
  {
    return (this.fS != null) && (this.fS.getLatitude() != 0.0D) && (this.fS.getLongitude() != 0.0D);
  }
  
  /* Error */
  public void aU()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 765	com/baidu/location/ab:gv	Z
    //   5: istore_2
    //   6: iload_2
    //   7: ifne +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: invokestatic 771	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   17: putfield 773	com/baidu/location/x:fz	Landroid/content/Context;
    //   20: aload_0
    //   21: aload_0
    //   22: getfield 773	com/baidu/location/x:fz	Landroid/content/Context;
    //   25: ldc_w 775
    //   28: invokevirtual 781	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   31: checkcast 710	android/location/LocationManager
    //   34: putfield 120	com/baidu/location/x:fk	Landroid/location/LocationManager;
    //   37: aload_0
    //   38: new 10	com/baidu/location/x$a
    //   41: dup
    //   42: aload_0
    //   43: aconst_null
    //   44: invokespecial 782	com/baidu/location/x$a:<init>	(Lcom/baidu/location/x;Lcom/baidu/location/x$1;)V
    //   47: putfield 126	com/baidu/location/x:fn	Lcom/baidu/location/x$a;
    //   50: aload_0
    //   51: getfield 120	com/baidu/location/x:fk	Landroid/location/LocationManager;
    //   54: aload_0
    //   55: getfield 126	com/baidu/location/x:fn	Lcom/baidu/location/x$a;
    //   58: invokevirtual 786	android/location/LocationManager:addGpsStatusListener	(Landroid/location/GpsStatus$Listener;)Z
    //   61: pop
    //   62: aload_0
    //   63: new 16	com/baidu/location/x$c
    //   66: dup
    //   67: aload_0
    //   68: aconst_null
    //   69: invokespecial 787	com/baidu/location/x$c:<init>	(Lcom/baidu/location/x;Lcom/baidu/location/x$1;)V
    //   72: putfield 124	com/baidu/location/x:fQ	Lcom/baidu/location/x$c;
    //   75: aload_0
    //   76: getfield 120	com/baidu/location/x:fk	Landroid/location/LocationManager;
    //   79: ldc_w 789
    //   82: ldc2_w 115
    //   85: fconst_0
    //   86: aload_0
    //   87: getfield 124	com/baidu/location/x:fQ	Lcom/baidu/location/x$c;
    //   90: invokevirtual 722	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;)V
    //   93: aload_0
    //   94: new 791	com/baidu/location/x$1
    //   97: dup
    //   98: aload_0
    //   99: invokespecial 794	com/baidu/location/x$1:<init>	(Lcom/baidu/location/x;)V
    //   102: putfield 144	com/baidu/location/x:fi	Landroid/os/Handler;
    //   105: goto -95 -> 10
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    //   113: astore_1
    //   114: goto -21 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	x
    //   108	4	1	localObject	Object
    //   113	1	1	localException	Exception
    //   5	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	6	108	finally
    //   13	20	108	finally
    //   20	93	108	finally
    //   93	105	108	finally
    //   20	93	113	java/lang/Exception
  }
  
  public String aV()
  {
    return this.fR;
  }
  
  public void aW()
  {
    for (;;)
    {
      try
      {
        a3();
        LocationManager localLocationManager = this.fk;
        if (localLocationManager == null) {
          return;
        }
      }
      finally {}
      try
      {
        if (this.fn != null) {
          this.fk.removeGpsStatusListener(this.fn);
        }
        this.fk.removeUpdates(this.fQ);
      }
      catch (Exception localException)
      {
        continue;
      }
      this.fn = null;
      this.fk = null;
    }
  }
  
  public String aY()
  {
    if ((aR()) && (this.fS != null)) {
      return jdMethod_case(this.fS);
    }
    return null;
  }
  
  public void jdMethod_int(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a2();
      return;
    }
    a3();
  }
  
  private class a
    implements GpsStatus.Listener, GpsStatus.NmeaListener
  {
    private long a = 0L;
    private boolean jdField_byte = false;
    private List jdField_case = new ArrayList();
    private final int jdField_char = 400;
    private String jdField_do = null;
    private String jdField_for = null;
    long jdField_if = 0L;
    private String jdField_new = null;
    private boolean jdField_try = true;
    
    private a() {}
    
    public void a(String paramString)
    {
      if ((System.currentTimeMillis() - this.a > 400L) && (this.jdField_byte) && (this.jdField_case.size() > 0)) {}
      try
      {
        at localat = new at(this.jdField_case, this.jdField_for, this.jdField_new, this.jdField_do);
        if (localat.cV())
        {
          c.al = x.jdMethod_if(x.this, localat, x.jdMethod_try(x.this));
          if (c.al > 0) {
            x.m(String.format(Locale.CHINA, "&nmea=%.1f|%.1f&g_tp=%d", new Object[] { Double.valueOf(localat.cT()), Double.valueOf(localat.cW()), Integer.valueOf(c.al) }));
          }
        }
        for (;;)
        {
          this.jdField_case.clear();
          this.jdField_do = null;
          this.jdField_new = null;
          this.jdField_for = null;
          this.jdField_byte = false;
          if (!paramString.startsWith("$GPGGA")) {
            break;
          }
          this.jdField_byte = true;
          this.jdField_for = paramString.trim();
          this.a = System.currentTimeMillis();
          return;
          c.al = 0;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          c.al = 0;
          continue;
          if (paramString.startsWith("$GPGSV")) {
            this.jdField_case.add(paramString.trim());
          } else if (paramString.startsWith("$GPGSA")) {
            this.jdField_do = paramString.trim();
          }
        }
      }
    }
    
    public void onGpsStatusChanged(int paramInt)
    {
      if (x.jdMethod_if(x.this) == null) {}
      long l;
      do
      {
        do
        {
          int k;
          int i;
          do
          {
            do
            {
              return;
              switch (paramInt)
              {
              case 3: 
              default: 
                return;
              case 2: 
                x.jdMethod_if(x.this, null);
                x.jdMethod_if(x.this, false);
                x.jdMethod_int(0);
                return;
              }
            } while ((!x.jdMethod_case(x.this)) && (System.currentTimeMillis() - this.jdField_if < 10000L));
            if (x.jdMethod_do(x.this) == null) {
              x.jdMethod_if(x.this, x.jdMethod_if(x.this).getGpsStatus(null));
            }
            for (;;)
            {
              localObject = x.jdMethod_do(x.this).getSatellites().iterator();
              x.jdMethod_if(new StringBuilder());
              x.jdMethod_do(x.this, 0);
              x.jdMethod_if(x.this, 0);
              x.jdMethod_do(x.this, new HashMap());
              paramInt = 0;
              k = 0;
              int j;
              for (i = 0; ((Iterator)localObject).hasNext(); i = j)
              {
                GpsSatellite localGpsSatellite = (GpsSatellite)((Iterator)localObject).next();
                k += 1;
                j = i;
                if (localGpsSatellite.usedInFix()) {
                  j = i + 1;
                }
                i = paramInt;
                if (localGpsSatellite.getSnr() > 0.0F) {
                  i = paramInt + 1;
                }
                if (localGpsSatellite.getSnr() >= c.aa) {
                  x.jdMethod_int(x.this);
                }
                x.aZ().append(x.jdMethod_if(x.this, localGpsSatellite, x.jdMethod_new(x.this)));
                paramInt = i;
              }
              x.jdMethod_if(x.this).getGpsStatus(x.jdMethod_do(x.this));
            }
            x.jdMethod_int(paramInt);
            x.jdMethod_if(x.this, x.jdMethod_new(x.this));
          } while ((x.jdMethod_case(x.this)) || (System.currentTimeMillis() - x.jdMethod_char(x.this) < 60000L) || ((i <= 3) && (k <= 15)));
          localObject = x.jdMethod_if(x.this).getLastKnownLocation("gps");
        } while (localObject == null);
        this.jdField_if = System.currentTimeMillis();
        l = System.currentTimeMillis() + g.e().bp - ((Location)localObject).getTime();
      } while ((l >= 3500L) || (l <= -200L) || (!q.jdMethod_if((Location)localObject, false)));
      Object localObject = x.jdMethod_byte(x.this).obtainMessage(3, localObject);
      x.jdMethod_byte(x.this).sendMessage((Message)localObject);
    }
    
    public void onNmeaReceived(long paramLong, String paramString)
    {
      if (!x.jdMethod_case(x.this)) {}
      do
      {
        return;
        if (!y.f5)
        {
          c.al = 0;
          return;
        }
      } while ((paramString == null) || (paramString.equals("")) || (paramString.length() < 9) || (paramString.length() > 150) || (!x.this.aR()));
      x.jdMethod_byte(x.this).sendMessage(x.jdMethod_byte(x.this).obtainMessage(2, paramString));
    }
  }
  
  private class b
    implements LocationListener
  {
    private b() {}
    
    public void onLocationChanged(Location paramLocation)
    {
      x.jdMethod_do(x.this, System.currentTimeMillis());
      x.jdMethod_if(x.this, true);
      x.jdMethod_if(x.this, paramLocation);
      x.jdMethod_do(x.this, false);
    }
    
    public void onProviderDisabled(String paramString)
    {
      x.jdMethod_if(x.this, null);
      x.jdMethod_if(x.this, false);
    }
    
    public void onProviderEnabled(String paramString) {}
    
    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        x.jdMethod_if(x.this, null);
        x.jdMethod_if(x.this, false);
        return;
      case 1: 
        x.jdMethod_if(x.this, System.currentTimeMillis());
        x.jdMethod_do(x.this, true);
        x.jdMethod_if(x.this, false);
        return;
      }
      x.jdMethod_do(x.this, false);
    }
  }
  
  private class c
    implements LocationListener
  {
    private long jdField_if = 0L;
    
    private c() {}
    
    public void onLocationChanged(Location paramLocation)
    {
      if (x.jdMethod_case(x.this)) {}
      do
      {
        do
        {
          return;
        } while ((paramLocation == null) || (paramLocation.getProvider() != "gps"));
        x.jdMethod_for(x.this, System.currentTimeMillis());
      } while ((System.currentTimeMillis() - this.jdField_if < 10000L) || (!q.jdMethod_if(paramLocation, false)));
      this.jdField_if = System.currentTimeMillis();
      paramLocation = x.jdMethod_byte(x.this).obtainMessage(4, paramLocation);
      x.jdMethod_byte(x.this).sendMessage(paramLocation);
    }
    
    public void onProviderDisabled(String paramString) {}
    
    public void onProviderEnabled(String paramString) {}
    
    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */