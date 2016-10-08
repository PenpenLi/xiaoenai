package com.baidu.location;

import android.net.wifi.ScanResult;
import android.os.Environment;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class am
  implements ax, n
{
  private static am hE;
  private static String[] hF;
  private static final String hG = "loc_cache.dat";
  private static final String hH = ";";
  private static final String hJ = ",";
  private static final int hK = 5;
  private static final double hL = 121.314D;
  private String[] hI = null;
  
  private double bJ()
  {
    double d2 = 0.0D;
    double d1 = d2;
    if (this.hI != null)
    {
      d1 = d2;
      if (this.hI.length > 2) {
        d1 = Double.valueOf(this.hI[2]).doubleValue();
      }
    }
    return d1;
  }
  
  private double bK()
  {
    double d2 = 0.0D;
    double d1 = d2;
    if (this.hI != null)
    {
      d1 = d2;
      if (this.hI.length > 1) {
        d1 = Double.valueOf(this.hI[1]).doubleValue() - 121.314D;
      }
    }
    return d1;
  }
  
  private long bL()
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.hI != null)
    {
      l1 = l2;
      if (this.hI.length >= 3) {
        l1 = Long.valueOf(this.hI[3]).longValue();
      }
    }
    return l1;
  }
  
  private boolean bM()
  {
    boolean bool = true;
    Object localObject = t.an().ak();
    localObject = String.format("%s|%s|%s|%s", new Object[] { Integer.valueOf(((t.a)localObject).jdField_do), Integer.valueOf(((t.a)localObject).jdField_if), Integer.valueOf(((t.a)localObject).jdField_for), Integer.valueOf(((t.a)localObject).jdField_try) });
    String str = hF[1];
    if ((TextUtils.isEmpty(hF[1])) || (!str.equals(localObject))) {
      bool = false;
    }
    return bool;
  }
  
  private void bO()
  {
    if ((this.hI == null) && (hF != null))
    {
      String str = hF[0];
      if (!TextUtils.isEmpty(str)) {
        this.hI = str.split(",");
      }
    }
  }
  
  private double bP()
  {
    double d2 = 0.0D;
    double d1 = d2;
    if (this.hI != null)
    {
      d1 = d2;
      if (this.hI.length > 0) {
        d1 = Double.valueOf(this.hI[0]).doubleValue() - 121.314D;
      }
    }
    return d1;
  }
  
  public static am bQ()
  {
    if (hE == null) {
      hE = new am();
    }
    return hE;
  }
  
  public a bN()
  {
    FileInputStream localFileInputStream = null;
    Object localObject2 = null;
    Object localObject1 = localFileInputStream;
    Object localObject3;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      localObject3 = new File(I + File.separator + "loc_cache.dat");
      localObject1 = localFileInputStream;
      if (((File)localObject3).exists())
      {
        localObject1 = localObject2;
        try
        {
          localFileInputStream = new FileInputStream((File)localObject3);
          localObject1 = localObject2;
          byte[] arrayOfByte2 = new byte[''];
          localObject1 = localObject2;
          localObject3 = new ByteArrayOutputStream();
          for (;;)
          {
            localObject1 = localObject2;
            int i = localFileInputStream.read(arrayOfByte2);
            if (i == -1) {
              break;
            }
            localObject1 = localObject2;
            ((ByteArrayOutputStream)localObject3).write(arrayOfByte2, 0, i);
          }
          hF = new String((byte[])localObject1).split(";");
        }
        catch (Exception localException) {}
      }
    }
    for (;;)
    {
      bO();
      localObject1 = new a();
      ((a)localObject1).jdField_int = bP();
      ((a)localObject1).jdField_try = bK();
      ((a)localObject1).jdField_if = bJ();
      ((a)localObject1).jdField_for = bM();
      ((a)localObject1).jdField_do = bR();
      ((a)localObject1).jdField_new = bL();
      return (a)localObject1;
      localObject1 = localException;
      byte[] arrayOfByte1 = ((ByteArrayOutputStream)localObject3).toByteArray();
      localObject1 = arrayOfByte1;
      ((ByteArrayOutputStream)localObject3).close();
      localObject1 = arrayOfByte1;
      localFileInputStream.close();
      localObject1 = arrayOfByte1;
    }
  }
  
  public int bR()
  {
    int j = 0;
    if (hF[2] != null) {}
    for (String[] arrayOfString = hF[2].split(",");; arrayOfString = null)
    {
      Object localObject1 = ar.bW().bS();
      int i = j;
      int k;
      if (localObject1 != null)
      {
        localObject1 = ((ar.b)localObject1).jdField_for;
        i = j;
        if (localObject1 != null)
        {
          j = 0;
          i = 0;
          if (j < 5)
          {
            Object localObject2 = (ScanResult)((List)localObject1).get(j);
            if (localObject2 == null) {
              break label138;
            }
            localObject2 = ((ScanResult)localObject2).BSSID.replace(":", "");
            k = 0;
            label93:
            if (k >= arrayOfString.length) {
              break label138;
            }
            if (((String)localObject2).equals(arrayOfString[k])) {
              i += 1;
            }
          }
        }
      }
      label138:
      for (;;)
      {
        j += 1;
        break;
        k += 1;
        break label93;
        return i;
      }
    }
  }
  
  public void jdMethod_new(BDLocation paramBDLocation)
  {
    int i = 0;
    if (paramBDLocation.getLocType() != 161) {
      return;
    }
    String str = String.format("%s,%s,%s,%d", new Object[] { Double.valueOf(paramBDLocation.getLongitude() + 121.314D), Double.valueOf(paramBDLocation.getLatitude() + 121.314D), Float.valueOf(paramBDLocation.getRadius()), Long.valueOf(System.currentTimeMillis()) });
    paramBDLocation = t.an().ak();
    if (paramBDLocation.jdMethod_for()) {}
    for (paramBDLocation = String.format("%s|%s|%s|%s", new Object[] { Integer.valueOf(paramBDLocation.jdField_do), Integer.valueOf(paramBDLocation.jdField_if), Integer.valueOf(paramBDLocation.jdField_for), Integer.valueOf(paramBDLocation.jdField_try) });; paramBDLocation = null)
    {
      Object localObject2 = null;
      Object localObject3 = ar.bW().bS();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((ar.b)localObject3).jdField_for;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = new ArrayList();
          while (i < 5)
          {
            localObject2 = (ScanResult)((List)localObject3).get(i);
            if (localObject2 != null) {
              ((List)localObject1).add(((ScanResult)localObject2).BSSID.replace(":", ""));
            }
            i += 1;
          }
          localObject1 = TextUtils.join(",", (Iterable)localObject1);
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str).append(";").append(paramBDLocation).append(";").append((String)localObject1);
      paramBDLocation = ((StringBuilder)localObject2).toString();
      if (!"mounted".equals(Environment.getExternalStorageState())) {
        break;
      }
      localObject1 = new File(I + File.separator + "loc_cache.dat");
      localObject2 = ((File)localObject1).getParentFile();
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      try
      {
        localObject1 = new FileOutputStream((File)localObject1);
        ((FileOutputStream)localObject1).write(paramBDLocation.getBytes());
        ((FileOutputStream)localObject1).close();
        return;
      }
      catch (Exception paramBDLocation)
      {
        return;
      }
    }
  }
  
  public class a
  {
    public int jdField_do;
    public boolean jdField_for;
    public double jdField_if;
    public double jdField_int;
    public long jdField_new;
    public double jdField_try;
    
    public a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */