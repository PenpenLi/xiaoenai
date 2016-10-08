package com.baidu.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ar
  implements ax, n
{
  private static final int hN = 15;
  private static ar hW = null;
  private a h0 = null;
  private final long hM = 3000L;
  private boolean hO = true;
  private long hP = 0L;
  private b hQ = null;
  private Object hR = null;
  private final long hS = 3000L;
  private long hT = 0L;
  private final long hU = 5000L;
  private WifiManager hV = null;
  private Method hX = null;
  private boolean hY = false;
  private long hZ = 0L;
  
  public static boolean bU()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)f.getServiceContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        int i = localNetworkInfo.getType();
        if (i == 1) {
          return true;
        }
      }
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private void bV()
  {
    if (this.hV == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = this.hV.getScanResults();
        localObject = new b((List)localObject, this.hT);
        this.hT = 0L;
        if ((this.hQ == null) || (!((b)localObject).jdMethod_if(this.hQ)))
        {
          this.hQ = ((b)localObject);
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public static ar bW()
  {
    if (hW == null) {
      hW = new ar();
    }
    return hW;
  }
  
  public static double jdMethod_if(b paramb1, b paramb2)
  {
    double d2 = 1.0D;
    double d1;
    if ((paramb1 == null) || (paramb2 == null)) {
      d1 = 0.0D;
    }
    int m;
    int n;
    float f;
    do
    {
      do
      {
        return d1;
        paramb1 = paramb1.jdField_for;
        paramb2 = paramb2.jdField_for;
        d1 = d2;
      } while (paramb1 == paramb2);
      if ((paramb1 == null) || (paramb2 == null)) {
        return 0.0D;
      }
      m = paramb1.size();
      n = paramb2.size();
      f = m + n;
      if (m != 0) {
        break;
      }
      d1 = d2;
    } while (n == 0);
    if ((m == 0) || (n == 0)) {
      return 0.0D;
    }
    int j = 0;
    int i = 0;
    String str;
    if (j < m)
    {
      str = ((ScanResult)paramb1.get(j)).BSSID;
      if (str != null) {}
    }
    for (;;)
    {
      j += 1;
      break;
      int k = 0;
      for (;;)
      {
        if (k < n)
        {
          if (str.equals(((ScanResult)paramb2.get(k)).BSSID))
          {
            i += 1;
            break;
          }
          k += 1;
          continue;
          if (f <= 0.0F) {
            return 0.0D;
          }
          return i / f;
        }
      }
    }
  }
  
  public static boolean jdMethod_if(b paramb1, b paramb2, float paramFloat)
  {
    if ((paramb1 == null) || (paramb2 == null)) {
      return false;
    }
    paramb1 = paramb1.jdField_for;
    paramb2 = paramb2.jdField_for;
    if (paramb1 == paramb2) {
      return true;
    }
    if ((paramb1 == null) || (paramb2 == null)) {
      return false;
    }
    int m = paramb1.size();
    int n = paramb2.size();
    float f = m + n;
    if ((m == 0) && (n == 0)) {
      return true;
    }
    if ((m == 0) || (n == 0)) {
      return false;
    }
    int j = 0;
    int i = 0;
    String str;
    if (j < m)
    {
      str = ((ScanResult)paramb1.get(j)).BSSID;
      if (str != null) {}
    }
    for (;;)
    {
      j += 1;
      break;
      int k = 0;
      for (;;)
      {
        if (k < n)
        {
          if (str.equals(((ScanResult)paramb2.get(k)).BSSID))
          {
            i += 1;
            break;
          }
          k += 1;
          continue;
          return i * 2 >= f * paramFloat;
        }
      }
    }
  }
  
  private boolean q(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("wpa|wep", 2).matcher(paramString).find();
  }
  
  public String b0()
  {
    String str = null;
    try
    {
      WifiInfo localWifiInfo = this.hV.getConnectionInfo();
      if (localWifiInfo != null) {
        str = localWifiInfo.getMacAddress();
      }
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public b b1()
  {
    if ((this.hQ == null) || (!this.hQ.jdMethod_new())) {
      return bY();
    }
    return this.hQ;
  }
  
  /* Error */
  public void b2()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	com/baidu/location/ar:hY	Z
    //   6: istore_2
    //   7: iload_2
    //   8: iconst_1
    //   9: if_icmpne +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: getstatic 212	com/baidu/location/ab:gv	Z
    //   18: ifeq -6 -> 12
    //   21: aload_0
    //   22: invokestatic 89	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   25: ldc -42
    //   27: invokevirtual 97	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   30: checkcast 112	android/net/wifi/WifiManager
    //   33: putfield 61	com/baidu/location/ar:hV	Landroid/net/wifi/WifiManager;
    //   36: aload_0
    //   37: new 12	com/baidu/location/ar$a
    //   40: dup
    //   41: aload_0
    //   42: aconst_null
    //   43: invokespecial 217	com/baidu/location/ar$a:<init>	(Lcom/baidu/location/ar;Lcom/baidu/location/ar$1;)V
    //   46: putfield 63	com/baidu/location/ar:h0	Lcom/baidu/location/ar$a;
    //   49: invokestatic 89	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   52: aload_0
    //   53: getfield 63	com/baidu/location/ar:h0	Lcom/baidu/location/ar$a;
    //   56: new 219	android/content/IntentFilter
    //   59: dup
    //   60: ldc -35
    //   62: invokespecial 224	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   65: invokevirtual 228	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   68: pop
    //   69: aload_0
    //   70: iconst_1
    //   71: putfield 71	com/baidu/location/ar:hY	Z
    //   74: ldc -26
    //   76: invokestatic 236	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   79: ldc -18
    //   81: invokevirtual 242	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   84: astore_1
    //   85: aload_1
    //   86: ifnull -74 -> 12
    //   89: aload_1
    //   90: iconst_1
    //   91: invokevirtual 248	java/lang/reflect/Field:setAccessible	(Z)V
    //   94: aload_0
    //   95: aload_1
    //   96: aload_0
    //   97: getfield 61	com/baidu/location/ar:hV	Landroid/net/wifi/WifiManager;
    //   100: invokevirtual 251	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: putfield 73	com/baidu/location/ar:hR	Ljava/lang/Object;
    //   106: aload_0
    //   107: aload_0
    //   108: getfield 73	com/baidu/location/ar:hR	Ljava/lang/Object;
    //   111: invokevirtual 255	java/lang/Object:getClass	()Ljava/lang/Class;
    //   114: ldc_w 257
    //   117: iconst_1
    //   118: anewarray 232	java/lang/Class
    //   121: dup
    //   122: iconst_0
    //   123: getstatic 263	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   126: aastore
    //   127: invokevirtual 267	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   130: putfield 75	com/baidu/location/ar:hX	Ljava/lang/reflect/Method;
    //   133: aload_0
    //   134: getfield 75	com/baidu/location/ar:hX	Ljava/lang/reflect/Method;
    //   137: ifnull -125 -> 12
    //   140: aload_0
    //   141: getfield 75	com/baidu/location/ar:hX	Ljava/lang/reflect/Method;
    //   144: iconst_1
    //   145: invokevirtual 270	java/lang/reflect/Method:setAccessible	(Z)V
    //   148: goto -136 -> 12
    //   151: astore_1
    //   152: goto -140 -> 12
    //   155: astore_1
    //   156: aload_0
    //   157: monitorexit
    //   158: aload_1
    //   159: athrow
    //   160: astore_1
    //   161: goto -92 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	ar
    //   84	12	1	localField	java.lang.reflect.Field
    //   151	1	1	localException1	Exception
    //   155	4	1	localObject	Object
    //   160	1	1	localException2	Exception
    //   6	4	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   74	85	151	java/lang/Exception
    //   89	148	151	java/lang/Exception
    //   2	7	155	finally
    //   15	49	155	finally
    //   49	69	155	finally
    //   69	74	155	finally
    //   74	85	155	finally
    //   89	148	155	finally
    //   49	69	160	java/lang/Exception
  }
  
  public boolean b3()
  {
    long l = System.currentTimeMillis();
    if (l - this.hZ <= 10000L) {
      return false;
    }
    this.hZ = l;
    return bX();
  }
  
  public String b4()
  {
    Object localObject1 = this.hV.getConnectionInfo();
    if (localObject1 == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject1 = ((WifiInfo)localObject1).getBSSID();
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).replace(":", "");
          if ("000000000000".equals(localObject1)) {
            break;
          }
          boolean bool = "".equals(localObject1);
          if (bool) {
            break;
          }
          return (String)localObject1;
        }
      }
      catch (Exception localException)
      {
        return null;
      }
      Object localObject2 = null;
    }
  }
  
  public boolean b5()
  {
    try
    {
      if (this.hV.isWifiEnabled())
      {
        if (this.hX != null)
        {
          Object localObject = this.hR;
          if (localObject == null) {}
        }
        for (;;)
        {
          try
          {
            this.hX.invoke(this.hR, new Object[] { Boolean.valueOf(this.hO) });
            this.hT = System.currentTimeMillis();
            return true;
          }
          catch (Exception localException1)
          {
            this.hV.startScan();
            continue;
          }
          this.hV.startScan();
        }
      }
      this.hT = 0L;
      return false;
    }
    catch (Exception localException2) {}
    return false;
  }
  
  public b bS()
  {
    if ((this.hQ == null) || (!this.hQ.jdMethod_for())) {
      return bY();
    }
    return this.hQ;
  }
  
  /* Error */
  public void bT()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	com/baidu/location/ar:hY	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 89	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   17: aload_0
    //   18: getfield 63	com/baidu/location/ar:h0	Lcom/baidu/location/ar$a;
    //   21: invokevirtual 318	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   24: aload_0
    //   25: lconst_0
    //   26: putfield 79	com/baidu/location/ar:hP	J
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 63	com/baidu/location/ar:h0	Lcom/baidu/location/ar$a;
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 61	com/baidu/location/ar:hV	Landroid/net/wifi/WifiManager;
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 71	com/baidu/location/ar:hY	Z
    //   44: goto -33 -> 11
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    //   52: astore_1
    //   53: goto -24 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	ar
    //   47	4	1	localObject	Object
    //   52	1	1	localException	Exception
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   14	29	47	finally
    //   29	44	47	finally
    //   14	29	52	java/lang/Exception
  }
  
  public boolean bX()
  {
    if (this.hV == null) {}
    while (System.currentTimeMillis() - this.hT <= 3000L) {
      return false;
    }
    return b5();
  }
  
  public b bY()
  {
    if (this.hV != null) {
      try
      {
        b localb = new b(this.hV.getScanResults(), 0L);
        return localb;
      }
      catch (Exception localException) {}
    }
    return new b(null, 0L);
  }
  
  public boolean bZ()
  {
    return (this.hV.isWifiEnabled()) && (3 == this.hV.getWifiState());
  }
  
  private class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramContext == null) {}
      do
      {
        do
        {
          return;
        } while (!paramIntent.getAction().equals("android.net.wifi.SCAN_RESULTS"));
        ar.jdMethod_if(ar.this, System.currentTimeMillis() / 1000L);
        ar.jdMethod_if(ar.this);
        ab.bj().obtainMessage(41).sendToTarget();
      } while (!ae.bp().bs());
      ae.bp().g1.obtainMessage(41).sendToTarget();
    }
  }
  
  protected class b
  {
    private boolean jdField_do = false;
    public List jdField_for = null;
    private long jdField_if = 0L;
    private long jdField_int = 0L;
    private boolean jdField_new;
    
    public b(b paramb)
    {
      if (paramb != null)
      {
        this.jdField_for = paramb.jdField_for;
        this.jdField_if = paramb.jdField_if;
        this.jdField_int = paramb.jdField_int;
        this.jdField_do = paramb.jdField_do;
      }
    }
    
    public b(List paramList, long paramLong)
    {
      this.jdField_if = paramLong;
      this.jdField_for = paramList;
      this.jdField_int = System.currentTimeMillis();
      a();
      c.jdMethod_if("baidu_location_service", jdMethod_int());
    }
    
    private void a()
    {
      if (jdMethod_try() < 1) {
        return;
      }
      int j = this.jdField_for.size() - 1;
      int i = 1;
      label23:
      int k;
      if ((j >= 1) && (i != 0))
      {
        k = 0;
        i = 0;
        label37:
        if (k < j)
        {
          if (((ScanResult)this.jdField_for.get(k)).level >= ((ScanResult)this.jdField_for.get(k + 1)).level) {
            break label155;
          }
          ScanResult localScanResult = (ScanResult)this.jdField_for.get(k + 1);
          this.jdField_for.set(k + 1, this.jdField_for.get(k));
          this.jdField_for.set(k, localScanResult);
          i = 1;
        }
      }
      label155:
      for (;;)
      {
        k += 1;
        break label37;
        j -= 1;
        break label23;
        break;
      }
    }
    
    public String a(int paramInt)
    {
      if (jdMethod_try() < 1) {
        return null;
      }
      int m = 0;
      Random localRandom = new Random();
      StringBuffer localStringBuffer = new StringBuffer(512);
      String str1 = ar.this.b4();
      int k = 0;
      int i = 0;
      int n = this.jdField_for.size();
      int j = 1;
      if (n > paramInt) {
        n = paramInt;
      }
      for (;;)
      {
        int i1 = 0;
        paramInt = m;
        label155:
        int i2;
        for (;;)
        {
          if (i1 < n) {
            if (((ScanResult)this.jdField_for.get(i1)).level == 0)
            {
              m = j;
              j = paramInt;
              paramInt = i;
              i = m;
              i1 += 1;
              m = paramInt;
              paramInt = j;
              j = i;
              i = m;
            }
            else if (j != 0)
            {
              j = 0;
              localStringBuffer.append("&wf=");
              String str2 = ((ScanResult)this.jdField_for.get(i1)).BSSID.replace(":", "");
              localStringBuffer.append(str2);
              i2 = ((ScanResult)this.jdField_for.get(i1)).level;
              m = i2;
              if (i2 < 0) {
                m = -i2;
              }
              localStringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[] { Integer.valueOf(m) }));
              m = k + 1;
              k = i;
              if (str1 != null)
              {
                k = i;
                if (str1.equals(str2))
                {
                  this.jdField_new = ar.jdMethod_if(ar.this, ((ScanResult)this.jdField_for.get(i1)).capabilities);
                  k = m;
                }
              }
              if (paramInt != 0) {
                break label421;
              }
            }
          }
        }
        label421:
        label645:
        label652:
        for (;;)
        {
          try
          {
            if ((localRandom.nextInt(10) != 2) || (((ScanResult)this.jdField_for.get(i1)).SSID == null) || (((ScanResult)this.jdField_for.get(i1)).SSID.length() >= 30)) {
              break label652;
            }
            localStringBuffer.append(((ScanResult)this.jdField_for.get(i1)).SSID);
            paramInt = 1;
            i2 = paramInt;
            i = j;
            paramInt = k;
            k = m;
            j = i2;
          }
          catch (Exception localException)
          {
            i = j;
            j = paramInt;
            paramInt = k;
            k = m;
          }
          localStringBuffer.append("|");
          break label155;
          if ((paramInt == 1) && (localRandom.nextInt(20) == 1) && (((ScanResult)this.jdField_for.get(i1)).SSID != null) && (((ScanResult)this.jdField_for.get(i1)).SSID.length() < 30))
          {
            localStringBuffer.append(((ScanResult)this.jdField_for.get(i1)).SSID);
            paramInt = 2;
            continue;
            break;
            if (j == 0)
            {
              localStringBuffer.append("&wf_n=" + i);
              localStringBuffer.append("&wf_st=");
              localStringBuffer.append(this.jdField_if);
              localStringBuffer.append("&wf_et=");
              localStringBuffer.append(this.jdField_int);
              localStringBuffer.append("&wf_vt=");
              localStringBuffer.append(ar.jdMethod_do(ar.this));
              if (i > 0)
              {
                this.jdField_do = true;
                localStringBuffer.append("&wf_en=");
                if (!this.jdField_new) {
                  break label645;
                }
              }
              for (paramInt = 1;; paramInt = 0)
              {
                localStringBuffer.append(paramInt);
                return localStringBuffer.toString();
              }
            }
            return null;
          }
        }
      }
    }
    
    public boolean a(b paramb)
    {
      return ar.jdMethod_if(paramb, this, c.aU);
    }
    
    public String jdMethod_byte()
    {
      try
      {
        String str = a(15);
        return str;
      }
      catch (Exception localException) {}
      return null;
    }
    
    public boolean jdMethod_case()
    {
      return this.jdField_do;
    }
    
    public String jdMethod_char()
    {
      try
      {
        String str = a(c.aX);
        return str;
      }
      catch (Exception localException) {}
      return null;
    }
    
    public int jdMethod_do()
    {
      int k = 0;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < jdMethod_try())
        {
          j = -((ScanResult)this.jdField_for.get(i)).level;
          if (j <= 0) {}
        }
        else
        {
          return j;
        }
        i += 1;
      }
    }
    
    public boolean jdMethod_do(b paramb)
    {
      if ((this.jdField_for != null) && (paramb != null) && (paramb.jdField_for != null))
      {
        int i;
        int j;
        if (this.jdField_for.size() < paramb.jdField_for.size())
        {
          i = this.jdField_for.size();
          j = 0;
        }
        for (;;)
        {
          if (j >= i) {
            break label174;
          }
          String str1 = ((ScanResult)this.jdField_for.get(j)).BSSID;
          int k = ((ScanResult)this.jdField_for.get(j)).level;
          String str2 = ((ScanResult)paramb.jdField_for.get(j)).BSSID;
          int m = ((ScanResult)paramb.jdField_for.get(j)).level;
          if ((!str1.equals(str2)) || (k != m))
          {
            return false;
            i = paramb.jdField_for.size();
            break;
          }
          j += 1;
        }
        label174:
        return true;
      }
      return false;
    }
    
    public String jdMethod_else()
    {
      StringBuffer localStringBuffer = new StringBuffer(512);
      localStringBuffer.append("wifi info:");
      if (jdMethod_try() < 1) {
        return localStringBuffer.toString();
      }
      int i = this.jdField_for.size();
      int j = i;
      if (i > 10) {
        j = 10;
      }
      int k = 0;
      i = 1;
      if (k < j)
      {
        if (((ScanResult)this.jdField_for.get(k)).level == 0) {}
        for (;;)
        {
          k += 1;
          break;
          if (i != 0)
          {
            localStringBuffer.append("wifi=");
            localStringBuffer.append(((ScanResult)this.jdField_for.get(k)).BSSID.replace(":", ""));
            i = ((ScanResult)this.jdField_for.get(k)).level;
            localStringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[] { Integer.valueOf(i) }));
            i = 0;
          }
          else
          {
            localStringBuffer.append(";");
            localStringBuffer.append(((ScanResult)this.jdField_for.get(k)).BSSID.replace(":", ""));
            int m = ((ScanResult)this.jdField_for.get(k)).level;
            localStringBuffer.append(String.format(Locale.CHINA, ",%d;", new Object[] { Integer.valueOf(m) }));
          }
        }
      }
      return localStringBuffer.toString();
    }
    
    public boolean jdMethod_for()
    {
      return System.currentTimeMillis() - this.jdField_int < 3000L;
    }
    
    public String jdMethod_if(int paramInt)
    {
      if ((paramInt == 0) || (jdMethod_try() < 1)) {
        return null;
      }
      StringBuffer localStringBuffer = new StringBuffer(256);
      if (this.jdField_for.size() > c.aX) {
        i = c.aX;
      }
      int k = 0;
      int i = 1;
      int j = 0;
      if (j < c.aX)
      {
        int m = k;
        if ((i & paramInt) != 0)
        {
          if (k != 0) {
            break label156;
          }
          localStringBuffer.append("&ssid=");
        }
        for (;;)
        {
          localStringBuffer.append(((ScanResult)this.jdField_for.get(j)).BSSID);
          localStringBuffer.append(";");
          localStringBuffer.append(((ScanResult)this.jdField_for.get(j)).SSID);
          m = k + 1;
          i <<= 1;
          j += 1;
          k = m;
          break;
          label156:
          localStringBuffer.append("|");
        }
      }
      return localStringBuffer.toString();
    }
    
    public boolean jdMethod_if()
    {
      return System.currentTimeMillis() - this.jdField_if < 3000L;
    }
    
    public boolean jdMethod_if(b paramb)
    {
      if ((this.jdField_for != null) && (paramb != null) && (paramb.jdField_for != null))
      {
        int i;
        int j;
        if (this.jdField_for.size() < paramb.jdField_for.size())
        {
          i = this.jdField_for.size();
          j = 0;
        }
        for (;;)
        {
          if (j >= i) {
            break label116;
          }
          if (!((ScanResult)this.jdField_for.get(j)).BSSID.equals(((ScanResult)paramb.jdField_for.get(j)).BSSID))
          {
            return false;
            i = paramb.jdField_for.size();
            break;
          }
          j += 1;
        }
        label116:
        return true;
      }
      return false;
    }
    
    public String jdMethod_int()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("wifi=");
      if (this.jdField_for == null) {
        return localStringBuilder.toString();
      }
      int i = 0;
      while (i < this.jdField_for.size())
      {
        int j = ((ScanResult)this.jdField_for.get(i)).level;
        localStringBuilder.append(((ScanResult)this.jdField_for.get(i)).BSSID.replace(":", ""));
        localStringBuilder.append(String.format(Locale.CHINA, ",%d;", new Object[] { Integer.valueOf(j) }));
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    public boolean jdMethod_new()
    {
      return System.currentTimeMillis() - this.jdField_int < 5000L;
    }
    
    public int jdMethod_try()
    {
      if (this.jdField_for == null) {
        return 0;
      }
      return this.jdField_for.size();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */