package com.baidu.location;

import android.app.AlarmManager;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.text.TextUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

class l
  implements ax, n
{
  private static final int b5 = 200;
  private static File b7 = null;
  private static File bD;
  private static final int bK = 800;
  public static final String bM = "com.baidu.locTest.LocationServer4.2";
  private static final int bW = 24;
  private static String bZ = I + "/glb.dat";
  private long b0 = 0L;
  private final int b1 = 200;
  private int b2 = 0;
  private int b3 = 1;
  private boolean b4 = false;
  long b6 = 0L;
  private a b8 = null;
  private Handler bA = null;
  private boolean bB = false;
  private long[] bC = new long[20];
  private boolean bE = false;
  private boolean bF = false;
  private String bG = I + "/vm.dat";
  private int bH = 0;
  private AlarmManager bI = null;
  private PendingIntent bJ = null;
  private Context bL = null;
  private String bN = null;
  private long bO = 0L;
  private boolean bP = false;
  private long bQ = 0L;
  private t.a bR = null;
  private long bS = c.ad;
  private final int bT = 1;
  String bU = "dlcu.dat";
  ArrayList bV = null;
  private long bX = 0L;
  ArrayList bY = null;
  c bx = null;
  private final long by = 86100000L;
  private String bz = "";
  
  static
  {
    bD = null;
  }
  
  public l(Context paramContext)
  {
    this.bL = paramContext;
    this.b6 = 0L;
    try
    {
      this.bx = new c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          this.bA = new l.1(this);
          this.bX = System.currentTimeMillis();
          this.bI = ((AlarmManager)paramContext.getSystemService("alarm"));
          this.b8 = new a();
          paramContext.registerReceiver(this.b8, new IntentFilter("com.baidu.locTest.LocationServer4.2"));
          this.bJ = PendingIntent.getBroadcast(paramContext, 0, new Intent("com.baidu.locTest.LocationServer4.2"), 134217728);
          this.bI.set(0, System.currentTimeMillis() + 1000L, this.bJ);
          this.bS = c.ad;
          this.bY = new ArrayList();
          this.bV = new ArrayList();
          t();
          this.bE = true;
          return;
        }
        finally {}
        localException = localException;
        this.bx = null;
      }
    }
  }
  
  private void jdMethod_if(boolean paramBoolean)
  {
    Object localObject = c.jdMethod_byte();
    if (localObject == null) {
      return;
    }
    localObject = (String)localObject + File.separator + "baidu/tempdata/" + this.bU;
    try
    {
      localObject = new RandomAccessFile((String)localObject, "rw");
      if (paramBoolean)
      {
        ((RandomAccessFile)localObject).seek(0L);
        ((RandomAccessFile)localObject).writeLong(System.currentTimeMillis());
        ((RandomAccessFile)localObject).writeInt(2125);
        this.b2 = 0;
        this.bQ = System.currentTimeMillis();
      }
      for (;;)
      {
        ((RandomAccessFile)localObject).writeInt(this.b2);
        ((RandomAccessFile)localObject).writeInt(2125);
        ((RandomAccessFile)localObject).close();
        return;
        ((RandomAccessFile)localObject).seek(12L);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void q()
  {
    try
    {
      if (bZ != null)
      {
        b7 = new File(bZ);
        if (!b7.exists())
        {
          Object localObject = new File(I);
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdirs();
          }
          b7.createNewFile();
          localObject = new RandomAccessFile(b7, "rw");
          ((RandomAccessFile)localObject).seek(0L);
          ((RandomAccessFile)localObject).writeInt(-1);
          ((RandomAccessFile)localObject).writeInt(-1);
          ((RandomAccessFile)localObject).writeInt(0);
          ((RandomAccessFile)localObject).writeLong(0L);
          ((RandomAccessFile)localObject).writeInt(0);
          ((RandomAccessFile)localObject).writeInt(0);
          ((RandomAccessFile)localObject).close();
        }
      }
      else
      {
        b7 = null;
        return;
      }
    }
    catch (Exception localException)
    {
      b7 = null;
    }
  }
  
  public static String s()
  {
    return null;
  }
  
  /* Error */
  private void t()
  {
    // Byte code:
    //   0: invokestatic 239	com/baidu/location/c:byte	()Ljava/lang/String;
    //   3: astore_1
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: new 78	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   16: aload_1
    //   17: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: getstatic 244	java/io/File:separator	Ljava/lang/String;
    //   23: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc -10
    //   28: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_0
    //   32: getfield 179	com/baidu/location/l:bU	Ljava/lang/String;
    //   35: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore_1
    //   42: new 248	java/io/RandomAccessFile
    //   45: dup
    //   46: aload_1
    //   47: ldc_w 287
    //   50: invokespecial 253	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: astore_1
    //   54: aload_1
    //   55: lconst_0
    //   56: invokevirtual 257	java/io/RandomAccessFile:seek	(J)V
    //   59: aload_1
    //   60: invokevirtual 290	java/io/RandomAccessFile:readLong	()J
    //   63: lstore 4
    //   65: aload_1
    //   66: invokevirtual 294	java/io/RandomAccessFile:readInt	()I
    //   69: sipush 2125
    //   72: if_icmpne +87 -> 159
    //   75: aload_1
    //   76: invokevirtual 294	java/io/RandomAccessFile:readInt	()I
    //   79: istore_2
    //   80: aload_1
    //   81: invokevirtual 294	java/io/RandomAccessFile:readInt	()I
    //   84: istore_3
    //   85: iload_3
    //   86: sipush 2125
    //   89: if_icmpne +65 -> 154
    //   92: iconst_1
    //   93: istore_3
    //   94: aload_1
    //   95: invokevirtual 267	java/io/RandomAccessFile:close	()V
    //   98: iload_3
    //   99: ifeq +15 -> 114
    //   102: aload_0
    //   103: iload_2
    //   104: putfield 155	com/baidu/location/l:b2	I
    //   107: aload_0
    //   108: lload 4
    //   110: putfield 157	com/baidu/location/l:bQ	J
    //   113: return
    //   114: aload_0
    //   115: iconst_0
    //   116: putfield 155	com/baidu/location/l:b2	I
    //   119: aload_0
    //   120: lconst_0
    //   121: putfield 157	com/baidu/location/l:bQ	J
    //   124: return
    //   125: astore_1
    //   126: lconst_0
    //   127: lstore 4
    //   129: iconst_0
    //   130: istore_2
    //   131: iconst_0
    //   132: istore_3
    //   133: goto -35 -> 98
    //   136: astore_1
    //   137: iconst_0
    //   138: istore_2
    //   139: iconst_0
    //   140: istore_3
    //   141: goto -43 -> 98
    //   144: astore_1
    //   145: iconst_0
    //   146: istore_3
    //   147: goto -49 -> 98
    //   150: astore_1
    //   151: goto -53 -> 98
    //   154: iconst_0
    //   155: istore_3
    //   156: goto -62 -> 94
    //   159: iconst_0
    //   160: istore_2
    //   161: iconst_0
    //   162: istore_3
    //   163: goto -69 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	l
    //   3	92	1	localObject	Object
    //   125	1	1	localException1	Exception
    //   136	1	1	localException2	Exception
    //   144	1	1	localException3	Exception
    //   150	1	1	localException4	Exception
    //   79	82	2	i	int
    //   84	79	3	j	int
    //   63	65	4	l	long
    // Exception table:
    //   from	to	target	type
    //   42	65	125	java/lang/Exception
    //   65	80	136	java/lang/Exception
    //   80	85	144	java/lang/Exception
    //   94	98	150	java/lang/Exception
  }
  
  boolean jdMethod_if(double paramDouble1, double paramDouble2)
  {
    return -2.1971522D * paramDouble1 + -0.70587059D * paramDouble2 + 0.8428018D > 0.0D;
  }
  
  public boolean r()
  {
    return ((KeyguardManager)this.bL.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public void u()
  {
    try
    {
      this.bE = false;
      if (this.b8 != null) {
        this.bL.unregisterReceiver(this.b8);
      }
      this.b8 = null;
      if ((this.bI != null) && (this.bJ != null)) {
        this.bI.cancel(this.bJ);
      }
      this.bI = null;
      this.bJ = null;
      bD = null;
      this.bY.clear();
      this.bV.clear();
      this.bY = null;
      this.bV = null;
      this.b6 = 0L;
      this.b0 = 0L;
      this.bz = "";
      this.bB = false;
      return;
    }
    finally {}
  }
  
  void v()
  {
    if (!this.bE) {
      return;
    }
    if (this.b0 != 0L) {}
    for (long l = System.currentTimeMillis() - this.b0 + 30000L;; l = 0L)
    {
      this.b0 = System.currentTimeMillis();
      String str2 = c.jdMethod_byte();
      if (str2 == null)
      {
        this.bI.set(0, System.currentTimeMillis() + c.aQ, this.bJ);
        return;
      }
      t.a locala = t.an().ak();
      if (locala == null)
      {
        this.bI.set(0, System.currentTimeMillis() + c.aQ, this.bJ);
        return;
      }
      ar.b localb = ar.bW().b1();
      int i = 0;
      if (this.b6 == 0L)
      {
        i = 1;
        this.bY.clear();
        this.bV.clear();
      }
      int k = 0;
      int j = k;
      int m;
      Object localObject1;
      if (i == 0)
      {
        m = this.bV.size();
        j = k;
        if (m > 0)
        {
          j = k;
          if (locala.a((t.a)this.bV.get(m - 1)))
          {
            j = k;
            if (this.bY.size() >= m)
            {
              localObject1 = (ar.b)this.bY.get(m - 1);
              j = k;
              if (!jdMethod_if(ar.jdMethod_if(localb, (ar.b)localObject1), new b((ar.b)localObject1).a(new b(localb)))) {
                j = -1;
              }
            }
          }
        }
      }
      k = 0;
      if (j < 0) {
        k = 1;
      }
      if (k == 0)
      {
        if ((System.currentTimeMillis() - this.bQ <= 86400000L) && (System.currentTimeMillis() - this.bQ >= 0L)) {
          break label409;
        }
        this.b2 = 0;
        jdMethod_if(true);
        if (this.b2 > c.a5) {
          this.bO = (this.bQ + 86400000L - System.currentTimeMillis());
        }
      }
      if (this.bO > 900000L)
      {
        this.bS = this.bO;
        this.bI.set(0, System.currentTimeMillis() + this.bS, this.bJ);
        this.bO = 0L;
      }
      for (;;)
      {
        this.b6 = System.currentTimeMillis();
        if (k == 0) {
          break label596;
        }
        q.x().z();
        return;
        label409:
        this.b2 += 1;
        jdMethod_if(false);
        break;
        if (j < 0)
        {
          this.bS += c.ao;
          if ((localb == null) || (localb.jdField_for == null) || (localb.jdField_for.size() == 0)) {
            if (this.bS > c.aK) {
              this.bS = c.aK;
            }
          }
          for (;;)
          {
            this.bI.set(0, System.currentTimeMillis() + this.bS, this.bJ);
            this.bB = true;
            break;
            if (this.bS > c.aQ) {
              this.bS = c.aQ;
            }
          }
        }
        this.bS = c.ad;
        this.bI.set(0, System.currentTimeMillis() + this.bS, this.bJ);
        if (System.currentTimeMillis() - this.b6 > 840000L)
        {
          this.bY.clear();
          this.bV.clear();
        }
      }
      label596:
      StringBuffer localStringBuffer = new StringBuffer(200);
      if (i != 0) {
        localStringBuffer.append("s");
      }
      localStringBuffer.append("v");
      localStringBuffer.append(4);
      int i1 = (int)(System.currentTimeMillis() >> 15);
      localStringBuffer.append("t");
      localStringBuffer.append(i1);
      if (locala.jdMethod_for())
      {
        if (locala.jdField_do != 460) {
          break label947;
        }
        localStringBuffer.append("x,");
      }
      Object localObject2;
      String str3;
      int n;
      for (;;)
      {
        localStringBuffer.append(locala.jdField_if);
        localStringBuffer.append(",");
        localStringBuffer.append(locala.jdField_for);
        localStringBuffer.append(",");
        localStringBuffer.append(locala.jdField_try);
        localObject2 = ar.bW().b4();
        i = 0;
        j = 0;
        localObject1 = null;
        if ((localb == null) || (localb.jdField_for == null)) {
          break label1154;
        }
        m = 0;
        for (;;)
        {
          if (m >= localb.jdField_for.size()) {
            break label1456;
          }
          str3 = ((ScanResult)localb.jdField_for.get(m)).BSSID.replace(":", "");
          n = ((ScanResult)localb.jdField_for.get(m)).level;
          if (n >= 0) {
            break label1453;
          }
          n = -n;
          if (i >= 3) {
            break label1438;
          }
          if ((m < 2) || (j != 0) || (localObject2 == null) || (((String)localObject2).equals(str3))) {
            break;
          }
          if (localObject1 != null) {
            break label1423;
          }
          localObject1 = "," + str3 + ";" + n;
          k = j;
          j = i;
          i = k;
          label926:
          m += 1;
          k = j;
          j = i;
          i = k;
        }
        label947:
        localStringBuffer.append("x");
        localStringBuffer.append(locala.jdField_do);
        localStringBuffer.append(",");
      }
      if (m == 0)
      {
        localStringBuffer.append("w");
        localStringBuffer.append(str3);
        k = j;
        if (localObject2 != null)
        {
          k = j;
          if (((String)localObject2).equals(str3))
          {
            str3 = ((ScanResult)localb.jdField_for.get(m)).capabilities;
            if (TextUtils.isEmpty(str3)) {
              break label1345;
            }
            str3 = str3.toUpperCase(Locale.CHINA);
            if ((!str3.contains("WEP")) && (!str3.contains("WPA"))) {
              break label1333;
            }
            localStringBuffer.append("l");
            label1091:
            k = 1;
          }
        }
        localStringBuffer.append(";" + n);
        j = i + 1;
        i = k;
        label1131:
        if (j <= 2) {
          break label1420;
        }
      }
      for (;;)
      {
        if ((j < 3) && (localObject1 != null)) {
          localStringBuffer.append((String)localObject1);
        }
        for (;;)
        {
          try
          {
            label1154:
            if (!r()) {
              continue;
            }
            localObject1 = "y2";
          }
          catch (Exception localException)
          {
            label1333:
            label1345:
            String str1 = "y";
            continue;
            this.bV.add(locala);
            if (this.bV.size() <= 3) {
              continue;
            }
            this.bV.remove(0);
            continue;
            q.x().z();
            return;
          }
          localObject2 = localObject1;
          if (aw.jdMethod_do().a() != null) {
            localObject2 = (String)localObject1 + aw.jdMethod_do().a();
          }
          localStringBuffer.append((String)localObject2);
          if (this.bB)
          {
            if (l > 0L)
            {
              l /= 60000L;
              this.bz = ("r" + l);
              localStringBuffer.append(this.bz);
              this.bz = "";
            }
            this.bB = false;
          }
          System.currentTimeMillis();
          Jni.jdMethod_int(str2, localStringBuffer.toString());
          this.bY.add(localb);
          if (this.bY.size() <= 3) {
            continue;
          }
          this.bY.remove(0);
          continue;
          localStringBuffer.append(",");
          break;
          localStringBuffer.append("j");
          break label1091;
          localStringBuffer.append("j");
          break label1091;
          localObject1 = "y1";
          ad.cM().jdMethod_goto(i1);
        }
        label1420:
        break label926;
        label1423:
        k = i;
        i = j;
        j = k;
        break label926;
        label1438:
        k = i;
        i = j;
        j = k;
        break label1131;
        label1453:
        break;
        label1456:
        j = i;
      }
    }
  }
  
  public class a
    extends BroadcastReceiver
  {
    public a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("com.baidu.locTest.LocationServer4.2")) {
        l.jdMethod_if(l.this).sendEmptyMessage(1);
      }
    }
  }
  
  class b
  {
    public static final double jdField_do = 0.8D;
    public static final double jdField_if = 0.7D;
    private double jdField_for = 1.0D;
    private HashMap jdField_int = new HashMap();
    
    public b(ar.b paramb)
    {
      int i;
      if (paramb.jdField_for != null)
      {
        this$1 = paramb.jdField_for.iterator();
        i = 0;
      }
      for (;;)
      {
        if (l.this.hasNext())
        {
          paramb = (ScanResult)l.this.next();
          int j = Math.abs(paramb.level);
          this.jdField_int.put(paramb.BSSID, Integer.valueOf(j));
          this.jdField_for += (100 - j) * (100 - j);
          i += 1;
          if (i <= 16) {}
        }
        else
        {
          this.jdField_for = Math.sqrt(this.jdField_for);
          return;
        }
      }
    }
    
    public double a()
    {
      return this.jdField_for;
    }
    
    double a(b paramb)
    {
      Iterator localIterator = this.jdField_int.keySet().iterator();
      double d = 0.0D;
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        int i = ((Integer)this.jdField_int.get(localObject)).intValue();
        localObject = (Integer)paramb.jdMethod_if().get(localObject);
        if (localObject != null) {
          d = (100 - ((Integer)localObject).intValue()) * (100 - i) + d;
        }
      }
      return d / (this.jdField_for * paramb.a());
    }
    
    public HashMap jdMethod_if()
    {
      return this.jdField_int;
    }
  }
  
  class c
    extends BroadcastReceiver
  {
    boolean jdField_if = false;
    
    public c()
    {
      a(f.getServiceContext());
    }
    
    public void a(Context paramContext)
    {
      if (!this.jdField_if)
      {
        this.jdField_if = true;
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        localIntentFilter.addAction("android.intent.action.SCREEN_ON");
        paramContext.registerReceiver(this, localIntentFilter);
      }
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (paramContext.equals("android.intent.action.SCREEN_ON")) {}
      while (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
        return;
      }
      ad.cM().cK();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */