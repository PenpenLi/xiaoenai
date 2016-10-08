package com.baidu.location;

import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

class t
  implements ax, n
{
  private static t d2 = null;
  private static String d4 = null;
  private static Method d5;
  private static boolean d6 = false;
  private static Method d8 = null;
  private static long d9;
  private static Method dZ;
  private static int eb;
  private static Class ec;
  private b d0 = null;
  private List d1 = null;
  private TelephonyManager d3 = null;
  private int d7 = 0;
  private a dX = new a();
  private int dY = 0;
  private boolean ea = false;
  
  static
  {
    d5 = null;
    dZ = null;
    ec = null;
    d9 = 3000L;
    eb = 3;
  }
  
  private boolean al()
  {
    if ((d4 == null) || (d4.length() < 10)) {}
    for (;;)
    {
      return false;
      try
      {
        char[] arrayOfChar = d4.toCharArray();
        int i = 0;
        for (;;)
        {
          if (i >= 10) {
            break label59;
          }
          if (arrayOfChar[i] > '9') {
            break;
          }
          int j = arrayOfChar[i];
          if (j < 48) {
            break;
          }
          i += 1;
        }
        label59:
        return true;
      }
      catch (Exception localException) {}
    }
    return false;
  }
  
  public static t an()
  {
    if (d2 == null) {
      d2 = new t();
    }
    return d2;
  }
  
  private void jdMethod_if(CellLocation paramCellLocation)
  {
    if ((paramCellLocation == null) || (this.d3 == null)) {
      return;
    }
    if (!d6)
    {
      d4 = this.d3.getDeviceId();
      d6 = al();
    }
    a locala = new a();
    locala.jdField_byte = System.currentTimeMillis();
    for (;;)
    {
      int i;
      try
      {
        String str = this.d3.getNetworkOperator();
        if ((str != null) && (str.length() > 0))
        {
          if (str.length() >= 3)
          {
            j = Integer.valueOf(str.substring(0, 3)).intValue();
            i = j;
            if (j < 0) {
              i = this.dX.jdField_do;
            }
            locala.jdField_do = i;
          }
          str = str.substring(3);
          if (str == null) {
            break label672;
          }
          char[] arrayOfChar = str.toCharArray();
          i = 0;
          j = i;
          if (i < arrayOfChar.length)
          {
            if (Character.isDigit(arrayOfChar[i])) {
              continue;
            }
            j = i;
          }
          j = Integer.valueOf(str.substring(0, j)).intValue();
          i = j;
          if (j < 0) {
            i = this.dX.jdField_if;
          }
          locala.jdField_if = i;
        }
        this.d7 = this.d3.getSimState();
      }
      catch (Exception localException)
      {
        this.dY = 1;
        continue;
        if (!(paramCellLocation instanceof CdmaCellLocation)) {
          continue;
        }
        locala.jdField_new = 'c';
      }
      if ((paramCellLocation instanceof GsmCellLocation))
      {
        locala.jdField_for = ((GsmCellLocation)paramCellLocation).getLac();
        locala.jdField_try = ((GsmCellLocation)paramCellLocation).getCid();
        locala.jdField_new = 'g';
        if ((!locala.jdMethod_for()) || ((this.dX != null) && (this.dX.a(locala)))) {
          break;
        }
        this.dX = locala;
        if (!locala.jdMethod_for()) {
          break label655;
        }
        if (this.d1 == null) {
          this.d1 = new LinkedList();
        }
        i = this.d1.size();
        if (i != 0) {
          break label635;
        }
        paramCellLocation = null;
        if ((paramCellLocation != null) && (paramCellLocation.jdField_try == this.dX.jdField_try) && (paramCellLocation.jdField_for == this.dX.jdField_for)) {
          break label653;
        }
        if (paramCellLocation != null) {
          paramCellLocation.jdField_byte = (this.dX.jdField_byte - paramCellLocation.jdField_byte);
        }
        this.d1.add(this.dX);
        if (this.d1.size() <= eb) {
          break;
        }
        this.d1.remove(0);
        return;
        i += 1;
        continue;
      }
      if (Integer.parseInt(Build.VERSION.SDK) < 5) {
        break;
      }
      if (ec == null) {}
      try
      {
        ec = Class.forName("android.telephony.cdma.CdmaCellLocation");
        d8 = ec.getMethod("getBaseStationId", new Class[0]);
        d5 = ec.getMethod("getNetworkId", new Class[0]);
        dZ = ec.getMethod("getSystemId", new Class[0]);
        if ((ec == null) || (!ec.isInstance(paramCellLocation))) {
          continue;
        }
        try
        {
          j = ((Integer)dZ.invoke(paramCellLocation, new Object[0])).intValue();
          i = j;
          if (j < 0) {
            i = this.dX.jdField_if;
          }
          locala.jdField_if = i;
          locala.jdField_try = ((Integer)d8.invoke(paramCellLocation, new Object[0])).intValue();
          locala.jdField_for = ((Integer)d5.invoke(paramCellLocation, new Object[0])).intValue();
        }
        catch (Exception paramCellLocation)
        {
          this.dY = 3;
          return;
        }
        paramCellLocation = (a)this.d1.get(i - 1);
      }
      catch (Exception paramCellLocation)
      {
        ec = null;
        this.dY = 2;
        return;
      }
      label635:
      continue;
      label653:
      break;
      label655:
      if (this.d1 == null) {
        break;
      }
      this.d1.clear();
      return;
      label672:
      int j = 0;
    }
  }
  
  public a ak()
  {
    if (((this.dX == null) || (!this.dX.jdMethod_do()) || (!this.dX.jdMethod_for())) && (this.d3 != null)) {}
    try
    {
      jdMethod_if(this.d3.getCellLocation());
      return this.dX;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public void am()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/baidu/location/t:ea	Z
    //   6: istore_2
    //   7: iload_2
    //   8: iconst_1
    //   9: if_icmpne +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: getstatic 260	com/baidu/location/ab:gv	Z
    //   18: ifeq -6 -> 12
    //   21: aload_0
    //   22: invokestatic 266	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   25: ldc_w 268
    //   28: invokevirtual 274	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   31: checkcast 113	android/telephony/TelephonyManager
    //   34: putfield 69	com/baidu/location/t:d3	Landroid/telephony/TelephonyManager;
    //   37: aload_0
    //   38: new 183	java/util/LinkedList
    //   41: dup
    //   42: invokespecial 184	java/util/LinkedList:<init>	()V
    //   45: putfield 76	com/baidu/location/t:d1	Ljava/util/List;
    //   48: aload_0
    //   49: new 13	com/baidu/location/t$b
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 275	com/baidu/location/t$b:<init>	(Lcom/baidu/location/t;)V
    //   57: putfield 78	com/baidu/location/t:d0	Lcom/baidu/location/t$b;
    //   60: aload_0
    //   61: getfield 69	com/baidu/location/t:d3	Landroid/telephony/TelephonyManager;
    //   64: ifnull -52 -> 12
    //   67: aload_0
    //   68: getfield 78	com/baidu/location/t:d0	Lcom/baidu/location/t$b;
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull -61 -> 12
    //   76: aload_0
    //   77: getfield 69	com/baidu/location/t:d3	Landroid/telephony/TelephonyManager;
    //   80: aload_0
    //   81: getfield 78	com/baidu/location/t:d0	Lcom/baidu/location/t$b;
    //   84: sipush 272
    //   87: invokevirtual 279	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   90: aload_0
    //   91: invokespecial 119	com/baidu/location/t:al	()Z
    //   94: putstatic 63	com/baidu/location/t:d6	Z
    //   97: ldc_w 281
    //   100: new 283	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 286
    //   110: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: getstatic 47	com/baidu/location/t:d4	Ljava/lang/String;
    //   116: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 298	com/baidu/location/c:if	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_0
    //   126: iconst_1
    //   127: putfield 80	com/baidu/location/t:ea	Z
    //   130: goto -118 -> 12
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: goto -49 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	t
    //   71	2	1	localb	b
    //   133	4	1	localObject	Object
    //   138	1	1	localException	Exception
    //   6	4	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	133	finally
    //   15	72	133	finally
    //   76	90	133	finally
    //   90	130	133	finally
    //   76	90	138	java/lang/Exception
  }
  
  public String ao()
  {
    return d4;
  }
  
  public int ap()
  {
    if (this.d3 == null) {
      return 0;
    }
    return this.d3.getNetworkType();
  }
  
  public int aq()
  {
    String str = ((TelephonyManager)f.getServiceContext().getSystemService("phone")).getSubscriberId();
    if (str != null)
    {
      if ((str.startsWith("46000")) || (str.startsWith("46002")) || (str.startsWith("46007"))) {
        return 1;
      }
      if (str.startsWith("46001")) {
        return 2;
      }
      if (str.startsWith("46003")) {
        return 3;
      }
    }
    return 0;
  }
  
  /* Error */
  public void as()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/baidu/location/t:ea	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 78	com/baidu/location/t:d0	Lcom/baidu/location/t$b;
    //   18: ifnull +22 -> 40
    //   21: aload_0
    //   22: getfield 69	com/baidu/location/t:d3	Landroid/telephony/TelephonyManager;
    //   25: ifnull +15 -> 40
    //   28: aload_0
    //   29: getfield 69	com/baidu/location/t:d3	Landroid/telephony/TelephonyManager;
    //   32: aload_0
    //   33: getfield 78	com/baidu/location/t:d0	Lcom/baidu/location/t$b;
    //   36: iconst_0
    //   37: invokevirtual 279	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 78	com/baidu/location/t:d0	Lcom/baidu/location/t$b;
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 69	com/baidu/location/t:d3	Landroid/telephony/TelephonyManager;
    //   50: aload_0
    //   51: getfield 76	com/baidu/location/t:d1	Ljava/util/List;
    //   54: invokeinterface 241 1 0
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 76	com/baidu/location/t:d1	Ljava/util/List;
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield 80	com/baidu/location/t:ea	Z
    //   69: goto -58 -> 11
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	t
    //   72	4	1	localObject	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	72	finally
    //   14	40	72	finally
    //   40	69	72	finally
  }
  
  public class a
  {
    public long jdField_byte = 0L;
    public int jdField_do = -1;
    public int jdField_for = -1;
    public int jdField_if = -1;
    public int jdField_int = -1;
    public char jdField_new = '\000';
    public int jdField_try = -1;
    
    public a()
    {
      this.jdField_byte = System.currentTimeMillis();
    }
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, char paramChar)
    {
      this.jdField_for = paramInt1;
      this.jdField_try = paramInt2;
      this.jdField_do = paramInt3;
      this.jdField_if = paramInt4;
      this.jdField_new = paramChar;
      this.jdField_byte = (System.currentTimeMillis() / 1000L);
    }
    
    public String a()
    {
      StringBuffer localStringBuffer = new StringBuffer(128);
      localStringBuffer.append(this.jdField_try + 23);
      localStringBuffer.append("H");
      localStringBuffer.append(this.jdField_for + 45);
      localStringBuffer.append("K");
      localStringBuffer.append(this.jdField_if + 54);
      localStringBuffer.append("Q");
      localStringBuffer.append(this.jdField_do + 203);
      return localStringBuffer.toString();
    }
    
    public boolean a(a parama)
    {
      return (this.jdField_for == parama.jdField_for) && (this.jdField_try == parama.jdField_try) && (this.jdField_if == parama.jdField_if);
    }
    
    public boolean jdMethod_do()
    {
      return System.currentTimeMillis() - this.jdField_byte < t.ar();
    }
    
    public boolean jdMethod_for()
    {
      return (this.jdField_for > -1) && (this.jdField_try > 0);
    }
    
    public String jdMethod_if()
    {
      StringBuffer localStringBuffer = new StringBuffer(64);
      localStringBuffer.append(String.format(Locale.CHINA, "cell=%d|%d|%d|%d:%d", new Object[] { Integer.valueOf(this.jdField_do), Integer.valueOf(this.jdField_if), Integer.valueOf(this.jdField_for), Integer.valueOf(this.jdField_try), Integer.valueOf(this.jdField_int) }));
      return localStringBuffer.toString();
    }
    
    public String jdMethod_int()
    {
      for (;;)
      {
        int i;
        try
        {
          Object localObject = t.jdMethod_int(t.this).getNeighboringCellInfo();
          if ((localObject == null) || (((List)localObject).isEmpty())) {
            break label287;
          }
          String str = "&nc=";
          localObject = ((List)localObject).iterator();
          i = 0;
          if (((Iterator)localObject).hasNext())
          {
            NeighboringCellInfo localNeighboringCellInfo = (NeighboringCellInfo)((Iterator)localObject).next();
            if (i == 0)
            {
              if (localNeighboringCellInfo.getLac() != this.jdField_for) {
                str = str + localNeighboringCellInfo.getLac() + "|" + localNeighboringCellInfo.getCid() + "|" + localNeighboringCellInfo.getRssi();
              } else {
                str = str + "|" + localNeighboringCellInfo.getCid() + "|" + localNeighboringCellInfo.getRssi();
              }
            }
            else if (i < 8) {
              if (localNeighboringCellInfo.getLac() != this.jdField_for) {
                str = str + ";" + localNeighboringCellInfo.getLac() + "|" + localNeighboringCellInfo.getCid() + "|" + localNeighboringCellInfo.getRssi();
              } else {
                str = str + ";" + "|" + localNeighboringCellInfo.getCid() + "|" + localNeighboringCellInfo.getRssi();
              }
            }
          }
        }
        catch (Exception localException)
        {
          return null;
        }
        return localException;
        label287:
        return null;
        i += 1;
      }
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer(128);
      localStringBuffer.append("&nw=");
      localStringBuffer.append(t.jdMethod_for(t.this).jdField_new);
      localStringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", new Object[] { Integer.valueOf(this.jdField_do), Integer.valueOf(this.jdField_if), Integer.valueOf(this.jdField_for), Integer.valueOf(this.jdField_try), Integer.valueOf(this.jdField_int) }));
      localStringBuffer.append("&cl_t=");
      localStringBuffer.append(this.jdField_byte);
      if ((t.jdMethod_do(t.this) != null) && (t.jdMethod_do(t.this).size() > 0))
      {
        j = t.jdMethod_do(t.this).size();
        localStringBuffer.append("&clt=");
        i = 0;
        if (i < j)
        {
          a locala = (a)t.jdMethod_do(t.this).get(i);
          if (locala.jdField_do != this.jdField_do) {
            localStringBuffer.append(locala.jdField_do);
          }
          localStringBuffer.append("|");
          if (locala.jdField_if != this.jdField_if) {
            localStringBuffer.append(locala.jdField_if);
          }
          localStringBuffer.append("|");
          if (locala.jdField_for != this.jdField_for) {
            localStringBuffer.append(locala.jdField_for);
          }
          localStringBuffer.append("|");
          if (locala.jdField_try != this.jdField_try) {
            localStringBuffer.append(locala.jdField_try);
          }
          localStringBuffer.append("|");
          if (i != j - 1) {
            localStringBuffer.append(locala.jdField_byte / 1000L);
          }
          for (;;)
          {
            localStringBuffer.append(";");
            i += 1;
            break;
            localStringBuffer.append((System.currentTimeMillis() - locala.jdField_byte) / 1000L);
          }
        }
      }
      if (t.jdMethod_new(t.this) > 100) {
        t.jdMethod_if(t.this, 0);
      }
      int i = t.jdMethod_if(t.this);
      int j = t.jdMethod_new(t.this);
      localStringBuffer.append("&cs=" + ((i << 8) + j));
      return localStringBuffer.toString();
    }
  }
  
  private class b
    extends PhoneStateListener
  {
    public b() {}
    
    public void onCellLocationChanged(CellLocation paramCellLocation)
    {
      if (paramCellLocation == null) {
        return;
      }
      try
      {
        t.jdMethod_if(t.this, t.jdMethod_int(t.this).getCellLocation());
        return;
      }
      catch (Exception paramCellLocation) {}
    }
    
    public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      if (t.jdMethod_for(t.this) != null)
      {
        if (t.jdMethod_for(t.this).jdField_new != 'g') {
          break label40;
        }
        t.jdMethod_for(t.this).jdField_int = paramSignalStrength.getGsmSignalStrength();
      }
      label40:
      while (t.jdMethod_for(t.this).jdField_new != 'c') {
        return;
      }
      t.jdMethod_for(t.this).jdField_int = paramSignalStrength.getCdmaDbm();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */