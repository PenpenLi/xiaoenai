package com.baidu.location;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class LocationClient
  implements ax, n
{
  private static final int j1 = 11;
  private static final int j4 = 4;
  private static final int jB = 3;
  private static final int jC = 8;
  private static final int jF = 9;
  private static final int jH = 7;
  private static final int jO = 5;
  private static final int jP = 12;
  private static final int jR = 6;
  private static final int jS = 2;
  private static final int jo = 10;
  private static final String jq = "baidu_location_Client";
  private static final int jt = 1;
  private static final int jx = 1000;
  private BDLocation j0 = null;
  private String j2 = null;
  private String j3 = null;
  private ArrayList j5 = null;
  private boolean jA = false;
  private BDLocationListener jD = null;
  private boolean jE = false;
  private boolean jG = false;
  private boolean jI;
  private final Messenger jJ = new Messenger(this.jp);
  private Context jK = null;
  private Messenger jL = null;
  private long jM = 0L;
  private LocationClientOption jN = new LocationClientOption();
  private Boolean jQ = Boolean.valueOf(true);
  private boolean jT = false;
  private long jU = 0L;
  private long jV = 0L;
  private ServiceConnection jW = new LocationClient.1(this);
  private String jX;
  private boolean jY = false;
  private boolean jZ = false;
  private boolean jn = false;
  private a jp = new a(null);
  private final Object jr = new Object();
  private BDErrorReport js = null;
  private b ju = null;
  private Boolean jv = Boolean.valueOf(false);
  private z jw = null;
  private long jy = 0L;
  private Boolean jz = Boolean.valueOf(false);
  
  public LocationClient(Context paramContext)
  {
    this.jK = paramContext;
    this.jN = new LocationClientOption();
    this.jw = new z(this.jK, this);
  }
  
  public LocationClient(Context paramContext, LocationClientOption paramLocationClientOption)
  {
    this.jK = paramContext;
    this.jN = paramLocationClientOption;
    this.jw = new z(this.jK, this);
  }
  
  private void cA()
  {
    if (this.jL == null) {
      return;
    }
    Message localMessage = Message.obtain(null, 22);
    try
    {
      localMessage.replyTo = this.jJ;
      this.jL.send(localMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void cB()
  {
    Message localMessage = Message.obtain(null, 28);
    try
    {
      localMessage.replyTo = this.jJ;
      this.jL.send(localMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void jdMethod_char(int paramInt)
  {
    if ((this.jE == true) || ((this.jN.jdField_goto == true) && (this.j0.getLocType() == 61)) || (this.j0.getLocType() == 66) || (this.j0.getLocType() == 67) || (this.jA))
    {
      Iterator localIterator = this.j5.iterator();
      while (localIterator.hasNext()) {
        ((BDLocationListener)localIterator.next()).onReceiveLocation(this.j0);
      }
      if ((this.j0.getLocType() != 66) && (this.j0.getLocType() != 67)) {}
    }
    else
    {
      return;
    }
    this.jE = false;
    this.jV = System.currentTimeMillis();
  }
  
  private Bundle cw()
  {
    if (this.jN == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("num", this.jN.jdField_long);
    localBundle.putFloat("distance", this.jN.c);
    localBundle.putBoolean("extraInfo", this.jN.e);
    return localBundle;
  }
  
  private Bundle cx()
  {
    if (this.jN == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("packName", this.j3);
    localBundle.putString("prodName", this.jN.jdField_if);
    localBundle.putString("coorType", this.jN.jdField_do);
    localBundle.putString("addrType", this.jN.jdField_else);
    localBundle.putBoolean("openGPS", this.jN.jdField_for);
    localBundle.putBoolean("location_change_notify", this.jN.jdField_goto);
    localBundle.putInt("scanSpan", this.jN.jdField_int);
    localBundle.putInt("timeOut", this.jN.d);
    localBundle.putInt("priority", this.jN.h);
    localBundle.putBoolean("map", this.jz.booleanValue());
    localBundle.putBoolean("import", this.jv.booleanValue());
    localBundle.putBoolean("needDirect", this.jN.g);
    return localBundle;
  }
  
  private void cy()
  {
    if (this.jT == true) {
      return;
    }
    c.jdMethod_char();
    this.j3 = this.jK.getPackageName();
    this.j2 = (this.j3 + "_bdls_v2.9");
    getAccessKey();
    Intent localIntent = new Intent(this.jK, f.class);
    try
    {
      localIntent.putExtra("debug_dev", this.jI);
      if (this.jN == null) {
        this.jN = new LocationClientOption();
      }
      if (this.jN.getLocationMode() == LocationClientOption.LocationMode.Device_Sensors) {
        this.jN.setIsNeedAddress(false);
      }
      localIntent.putExtra("cache_exception", this.jN.b);
      localIntent.putExtra("kill_process", this.jN.jdField_char);
      try
      {
        this.jK.bindService(localIntent, this.jW, 1);
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        this.jT = false;
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  private void cz()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 107	com/baidu/location/LocationClient:jT	Z
    //   4: ifeq +10 -> 14
    //   7: aload_0
    //   8: getfield 111	com/baidu/location/LocationClient:jL	Landroid/os/Messenger;
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aconst_null
    //   16: bipush 12
    //   18: invokestatic 199	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   21: astore_1
    //   22: aload_1
    //   23: aload_0
    //   24: getfield 123	com/baidu/location/LocationClient:jJ	Landroid/os/Messenger;
    //   27: putfield 202	android/os/Message:replyTo	Landroid/os/Messenger;
    //   30: aload_0
    //   31: getfield 111	com/baidu/location/LocationClient:jL	Landroid/os/Messenger;
    //   34: aload_1
    //   35: invokevirtual 205	android/os/Messenger:send	(Landroid/os/Message;)V
    //   38: aload_0
    //   39: getfield 109	com/baidu/location/LocationClient:jK	Landroid/content/Context;
    //   42: aload_0
    //   43: getfield 172	com/baidu/location/LocationClient:jW	Landroid/content/ServiceConnection;
    //   46: invokevirtual 416	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   49: aload_0
    //   50: getfield 139	com/baidu/location/LocationClient:jr	Ljava/lang/Object;
    //   53: astore_1
    //   54: aload_1
    //   55: monitorenter
    //   56: aload_0
    //   57: getfield 133	com/baidu/location/LocationClient:jG	Z
    //   60: iconst_1
    //   61: if_icmpne +19 -> 80
    //   64: aload_0
    //   65: getfield 116	com/baidu/location/LocationClient:jp	Lcom/baidu/location/LocationClient$a;
    //   68: aload_0
    //   69: getfield 135	com/baidu/location/LocationClient:ju	Lcom/baidu/location/LocationClient$b;
    //   72: invokevirtual 420	com/baidu/location/LocationClient$a:removeCallbacks	(Ljava/lang/Runnable;)V
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 133	com/baidu/location/LocationClient:jG	Z
    //   80: aload_1
    //   81: monitorexit
    //   82: aload_0
    //   83: getfield 145	com/baidu/location/LocationClient:jw	Lcom/baidu/location/z;
    //   86: invokevirtual 423	com/baidu/location/z:be	()V
    //   89: aload_0
    //   90: aconst_null
    //   91: putfield 111	com/baidu/location/LocationClient:jL	Landroid/os/Messenger;
    //   94: invokestatic 425	com/baidu/location/c:case	()V
    //   97: aload_0
    //   98: iconst_0
    //   99: putfield 153	com/baidu/location/LocationClient:jA	Z
    //   102: aload_0
    //   103: iconst_0
    //   104: putfield 107	com/baidu/location/LocationClient:jT	Z
    //   107: return
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 208	java/lang/Exception:printStackTrace	()V
    //   113: goto -75 -> 38
    //   116: astore_2
    //   117: aload_1
    //   118: monitorexit
    //   119: aload_2
    //   120: athrow
    //   121: astore_2
    //   122: goto -42 -> 80
    //   125: astore_1
    //   126: goto -77 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	LocationClient
    //   108	10	1	localException1	Exception
    //   125	1	1	localException2	Exception
    //   116	4	2	localObject2	Object
    //   121	1	2	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   30	38	108	java/lang/Exception
    //   56	80	116	finally
    //   80	82	116	finally
    //   117	119	116	finally
    //   56	80	121	java/lang/Exception
    //   38	49	125	java/lang/Exception
  }
  
  private boolean jdMethod_else(int paramInt)
  {
    if ((this.jL == null) || (!this.jT)) {
      return false;
    }
    try
    {
      Message localMessage = Message.obtain(null, paramInt);
      this.jL.send(localMessage);
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private void jdMethod_goto(boolean paramBoolean)
  {
    if (this.js != null) {
      this.js.onReportResult(paramBoolean);
    }
    this.js = null;
    this.jy = 0L;
  }
  
  private void jdMethod_if(Message paramMessage, int paramInt)
  {
    paramMessage = paramMessage.getData();
    paramMessage.setClassLoader(BDLocation.class.getClassLoader());
    this.j0 = ((BDLocation)paramMessage.getParcelable("locStr"));
    if (this.j0.getLocType() == 61) {
      this.jM = System.currentTimeMillis();
    }
    jdMethod_char(paramInt);
  }
  
  private void l(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null)) {
      return;
    }
    paramMessage = (BDNotifyListener)paramMessage.obj;
    this.jw.jdMethod_do(paramMessage);
  }
  
  private void m(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null)) {}
    do
    {
      return;
      paramMessage = (BDLocationListener)paramMessage.obj;
    } while ((this.j5 == null) || (!this.j5.contains(paramMessage)));
    this.j5.remove(paramMessage);
  }
  
  /* Error */
  private void n(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 485	android/os/Message:obj	Ljava/lang/Object;
    //   8: ifnonnull +4 -> 12
    //   11: return
    //   12: aload_1
    //   13: getfield 485	android/os/Message:obj	Ljava/lang/Object;
    //   16: checkcast 102	com/baidu/location/LocationClientOption
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 105	com/baidu/location/LocationClient:jN	Lcom/baidu/location/LocationClientOption;
    //   24: aload_1
    //   25: invokevirtual 504	com/baidu/location/LocationClientOption:equals	(Lcom/baidu/location/LocationClientOption;)Z
    //   28: ifne -17 -> 11
    //   31: aload_0
    //   32: getfield 105	com/baidu/location/LocationClient:jN	Lcom/baidu/location/LocationClientOption;
    //   35: getfield 322	com/baidu/location/LocationClientOption:int	I
    //   38: aload_1
    //   39: getfield 322	com/baidu/location/LocationClientOption:int	I
    //   42: if_icmpeq +95 -> 137
    //   45: aload_0
    //   46: getfield 139	com/baidu/location/LocationClient:jr	Ljava/lang/Object;
    //   49: astore_2
    //   50: aload_2
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 133	com/baidu/location/LocationClient:jG	Z
    //   56: iconst_1
    //   57: if_icmpne +19 -> 76
    //   60: aload_0
    //   61: getfield 116	com/baidu/location/LocationClient:jp	Lcom/baidu/location/LocationClient$a;
    //   64: aload_0
    //   65: getfield 135	com/baidu/location/LocationClient:ju	Lcom/baidu/location/LocationClient$b;
    //   68: invokevirtual 420	com/baidu/location/LocationClient$a:removeCallbacks	(Ljava/lang/Runnable;)V
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 133	com/baidu/location/LocationClient:jG	Z
    //   76: aload_1
    //   77: getfield 322	com/baidu/location/LocationClientOption:int	I
    //   80: sipush 1000
    //   83: if_icmplt +52 -> 135
    //   86: aload_0
    //   87: getfield 133	com/baidu/location/LocationClient:jG	Z
    //   90: ifne +45 -> 135
    //   93: aload_0
    //   94: getfield 135	com/baidu/location/LocationClient:ju	Lcom/baidu/location/LocationClient$b;
    //   97: ifnonnull +16 -> 113
    //   100: aload_0
    //   101: new 13	com/baidu/location/LocationClient$b
    //   104: dup
    //   105: aload_0
    //   106: aconst_null
    //   107: invokespecial 505	com/baidu/location/LocationClient$b:<init>	(Lcom/baidu/location/LocationClient;Lcom/baidu/location/LocationClient$1;)V
    //   110: putfield 135	com/baidu/location/LocationClient:ju	Lcom/baidu/location/LocationClient$b;
    //   113: aload_0
    //   114: getfield 116	com/baidu/location/LocationClient:jp	Lcom/baidu/location/LocationClient$a;
    //   117: aload_0
    //   118: getfield 135	com/baidu/location/LocationClient:ju	Lcom/baidu/location/LocationClient$b;
    //   121: aload_1
    //   122: getfield 322	com/baidu/location/LocationClientOption:int	I
    //   125: i2l
    //   126: invokevirtual 509	com/baidu/location/LocationClient$a:postDelayed	(Ljava/lang/Runnable;J)Z
    //   129: pop
    //   130: aload_0
    //   131: iconst_1
    //   132: putfield 133	com/baidu/location/LocationClient:jG	Z
    //   135: aload_2
    //   136: monitorexit
    //   137: aload_0
    //   138: new 102	com/baidu/location/LocationClientOption
    //   141: dup
    //   142: aload_1
    //   143: invokespecial 512	com/baidu/location/LocationClientOption:<init>	(Lcom/baidu/location/LocationClientOption;)V
    //   146: putfield 105	com/baidu/location/LocationClient:jN	Lcom/baidu/location/LocationClientOption;
    //   149: aload_0
    //   150: getfield 111	com/baidu/location/LocationClient:jL	Landroid/os/Messenger;
    //   153: ifnull -142 -> 11
    //   156: aconst_null
    //   157: bipush 15
    //   159: invokestatic 199	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   162: astore_1
    //   163: aload_1
    //   164: aload_0
    //   165: getfield 123	com/baidu/location/LocationClient:jJ	Landroid/os/Messenger;
    //   168: putfield 202	android/os/Message:replyTo	Landroid/os/Messenger;
    //   171: aload_1
    //   172: aload_0
    //   173: invokespecial 493	com/baidu/location/LocationClient:cx	()Landroid/os/Bundle;
    //   176: invokevirtual 516	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   179: aload_0
    //   180: getfield 111	com/baidu/location/LocationClient:jL	Landroid/os/Messenger;
    //   183: aload_1
    //   184: invokevirtual 205	android/os/Messenger:send	(Landroid/os/Message;)V
    //   187: return
    //   188: astore_1
    //   189: aload_1
    //   190: invokevirtual 208	java/lang/Exception:printStackTrace	()V
    //   193: return
    //   194: astore_3
    //   195: aload_2
    //   196: monitorexit
    //   197: aload_3
    //   198: athrow
    //   199: astore_2
    //   200: goto -63 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	LocationClient
    //   0	203	1	paramMessage	Message
    //   199	1	2	localException	Exception
    //   194	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   156	187	188	java/lang/Exception
    //   52	76	194	finally
    //   76	113	194	finally
    //   113	135	194	finally
    //   135	137	194	finally
    //   195	197	194	finally
    //   45	52	199	java/lang/Exception
    //   197	199	199	java/lang/Exception
  }
  
  private void o(Message arg1)
  {
    if (this.jL == null) {
      return;
    }
    Message localMessage;
    if (((System.currentTimeMillis() - this.jM > 3000L) || (!this.jN.jdField_goto)) && ((!this.jA) || (System.currentTimeMillis() - this.jV > 20000L))) {
      localMessage = Message.obtain(null, 22);
    }
    try
    {
      localMessage.replyTo = this.jJ;
      localMessage.arg1 = ???.arg1;
      this.jL.send(localMessage);
      this.jU = System.currentTimeMillis();
      this.jE = true;
      synchronized (this.jr)
      {
        if ((this.jN != null) && (this.jN.jdField_int >= 1000) && (!this.jG))
        {
          if (this.ju == null) {
            this.ju = new b(null);
          }
          this.jp.postDelayed(this.ju, this.jN.jdField_int);
          this.jG = true;
        }
        return;
      }
    }
    catch (Exception ???)
    {
      for (;;)
      {
        ???.printStackTrace();
      }
    }
  }
  
  private void p(Message paramMessage)
  {
    paramMessage = paramMessage.getData();
    paramMessage.setClassLoader(BDLocation.class.getClassLoader());
    paramMessage = (BDLocation)paramMessage.getParcelable("locStr");
    if ((this.jD == null) || ((this.jN != null) && (this.jN.a()) && (paramMessage.getLocType() == 65))) {
      return;
    }
    this.jD.onReceiveLocation(paramMessage);
  }
  
  private void q(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null)) {
      return;
    }
    paramMessage = (BDNotifyListener)paramMessage.obj;
    this.jw.jdMethod_for(paramMessage);
  }
  
  private void r(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null)) {
      return;
    }
    paramMessage = (BDLocationListener)paramMessage.obj;
    if (this.j5 == null) {
      this.j5 = new ArrayList();
    }
    this.j5.add(paramMessage);
  }
  
  private void s(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null)) {
      return;
    }
    this.jD = ((BDLocationListener)paramMessage.obj);
  }
  
  public void cancleError()
  {
    jdMethod_else(202);
  }
  
  public String getAccessKey()
  {
    this.jX = v.a(this.jK);
    if (TextUtils.isEmpty(this.jX)) {
      throw new IllegalStateException("please setting key from Manifest.xml");
    }
    return String.format("KEY=%s;SHA1=%s", new Object[] { this.jX, v.jdMethod_if(this.jK) });
  }
  
  public BDLocation getLastKnownLocation()
  {
    return this.j0;
  }
  
  public LocationClientOption getLocOption()
  {
    return this.jN;
  }
  
  public String getVersion()
  {
    return "4.2";
  }
  
  public boolean isStarted()
  {
    return this.jT;
  }
  
  public boolean notifyError()
  {
    return jdMethod_else(201);
  }
  
  public void registerLocationListener(BDLocationListener paramBDLocationListener)
  {
    if (paramBDLocationListener == null) {
      throw new IllegalStateException("please set a non-null listener");
    }
    Message localMessage = this.jp.obtainMessage(5);
    localMessage.obj = paramBDLocationListener;
    localMessage.sendToTarget();
  }
  
  public void registerNotify(BDNotifyListener paramBDNotifyListener)
  {
    Message localMessage = this.jp.obtainMessage(9);
    localMessage.obj = paramBDNotifyListener;
    localMessage.sendToTarget();
  }
  
  public void registerNotifyLocationListener(BDLocationListener paramBDLocationListener)
  {
    Message localMessage = this.jp.obtainMessage(8);
    localMessage.obj = paramBDLocationListener;
    localMessage.sendToTarget();
  }
  
  public void removeNotifyEvent(BDNotifyListener paramBDNotifyListener)
  {
    Message localMessage = this.jp.obtainMessage(10);
    localMessage.obj = paramBDNotifyListener;
    localMessage.sendToTarget();
  }
  
  public int reportErrorWithInfo(BDErrorReport paramBDErrorReport)
  {
    if ((this.jL == null) || (!this.jT)) {
      return 1;
    }
    if (paramBDErrorReport == null) {
      return 2;
    }
    if ((System.currentTimeMillis() - this.jy < 50000L) && (this.js != null)) {
      return 4;
    }
    Bundle localBundle = paramBDErrorReport.getErrorInfo();
    if (localBundle == null) {
      return 3;
    }
    try
    {
      Message localMessage = Message.obtain(null, 203);
      localMessage.replyTo = this.jJ;
      localMessage.setData(localBundle);
      this.jL.send(localMessage);
      this.js = paramBDErrorReport;
      this.jy = System.currentTimeMillis();
      return 0;
    }
    catch (Exception paramBDErrorReport) {}
    return 1;
  }
  
  public int requestLocation()
  {
    if ((this.jL == null) || (this.jJ == null)) {
      return 1;
    }
    if ((this.j5 == null) || (this.j5.size() < 1)) {
      return 2;
    }
    if (System.currentTimeMillis() - this.jU < 1000L) {
      return 6;
    }
    Message localMessage = this.jp.obtainMessage(4);
    localMessage.arg1 = 1;
    localMessage.sendToTarget();
    return 0;
  }
  
  public void requestNotifyLocation()
  {
    this.jp.obtainMessage(11).sendToTarget();
  }
  
  public int requestOfflineLocation()
  {
    if ((this.jL == null) || (this.jJ == null)) {
      return 1;
    }
    if ((this.j5 == null) || (this.j5.size() < 1)) {
      return 2;
    }
    this.jp.obtainMessage(12).sendToTarget();
    return 0;
  }
  
  public void setDebug(boolean paramBoolean)
  {
    this.jI = paramBoolean;
  }
  
  public void setForBaiduMap(boolean paramBoolean)
  {
    this.jz = Boolean.valueOf(paramBoolean);
  }
  
  public void setLocOption(LocationClientOption paramLocationClientOption)
  {
    LocationClientOption localLocationClientOption;
    if (paramLocationClientOption == null) {
      localLocationClientOption = new LocationClientOption();
    }
    for (;;)
    {
      paramLocationClientOption = this.jp.obtainMessage(3);
      paramLocationClientOption.obj = localLocationClientOption;
      paramLocationClientOption.sendToTarget();
      return;
      switch (paramLocationClientOption.h)
      {
      default: 
        localLocationClientOption = paramLocationClientOption;
        break;
      case 1: 
        localLocationClientOption = paramLocationClientOption;
        if (paramLocationClientOption.jdField_int != 0)
        {
          localLocationClientOption = paramLocationClientOption;
          if (paramLocationClientOption.jdField_int < 1000)
          {
            Log.w("baidu_location_service", String.format("scanSpan time %d less than 1 second, location services may not star", new Object[] { Integer.valueOf(paramLocationClientOption.jdField_int) }));
            localLocationClientOption = paramLocationClientOption;
          }
        }
        break;
      case 3: 
        if ((paramLocationClientOption.jdField_int != 0) && (paramLocationClientOption.jdField_int < 1000))
        {
          Log.w("baidu_location_service", String.format("scanSpan time %d less than 1 second, location services may not star", new Object[] { Integer.valueOf(paramLocationClientOption.jdField_int) }));
          localLocationClientOption = paramLocationClientOption;
        }
        else
        {
          localLocationClientOption = paramLocationClientOption;
          if (paramLocationClientOption.jdField_int == 0)
          {
            paramLocationClientOption.jdField_int = 1000;
            localLocationClientOption = paramLocationClientOption;
          }
        }
        break;
      case 2: 
        localLocationClientOption = paramLocationClientOption;
        if (paramLocationClientOption.jdField_int > 1000)
        {
          localLocationClientOption = paramLocationClientOption;
          if (paramLocationClientOption.jdField_int < 3000)
          {
            paramLocationClientOption.jdField_int = 3000;
            Log.w("baidu_location_service", String.format("scanSpan time %d less than 3 second, location services may not star", new Object[] { Integer.valueOf(paramLocationClientOption.jdField_int) }));
            localLocationClientOption = paramLocationClientOption;
          }
        }
        break;
      }
    }
  }
  
  public void start()
  {
    this.jp.obtainMessage(1).sendToTarget();
  }
  
  public void stop()
  {
    cz();
  }
  
  public void unRegisterLocationListener(BDLocationListener paramBDLocationListener)
  {
    if (paramBDLocationListener == null) {
      throw new IllegalStateException("please set a non-null listener");
    }
    Message localMessage = this.jp.obtainMessage(6);
    localMessage.obj = paramBDLocationListener;
    localMessage.sendToTarget();
  }
  
  public boolean updateLocation(Location paramLocation)
  {
    if ((this.jL == null) || (this.jJ == null) || (paramLocation == null)) {
      return false;
    }
    try
    {
      Message localMessage = Message.obtain(null, 57);
      localMessage.obj = paramLocation;
      this.jL.send(localMessage);
      return true;
    }
    catch (Exception paramLocation)
    {
      for (;;)
      {
        paramLocation.printStackTrace();
      }
    }
  }
  
  private class a
    extends Handler
  {
    private a() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        super.handleMessage(paramMessage);
      case 7: 
      case 3: 
      case 8: 
      case 5: 
      case 6: 
      case 9: 
      case 10: 
      case 1: 
      case 2: 
      case 11: 
      case 4: 
      case 12: 
      case 54: 
      case 55: 
        do
        {
          do
          {
            return;
            LocationClient.jdMethod_for(LocationClient.this, paramMessage);
            return;
            LocationClient.jdMethod_do(LocationClient.this, paramMessage);
            return;
            LocationClient.jdMethod_if(LocationClient.this, paramMessage);
            return;
            LocationClient.jdMethod_case(LocationClient.this, paramMessage);
            return;
            LocationClient.jdMethod_byte(LocationClient.this, paramMessage);
            return;
            LocationClient.jdMethod_new(LocationClient.this, paramMessage);
            return;
            LocationClient.jdMethod_do(LocationClient.this);
            return;
            LocationClient.jdMethod_try(LocationClient.this);
            return;
            LocationClient.jdMethod_case(LocationClient.this);
            return;
            LocationClient.jdMethod_int(LocationClient.this, paramMessage);
            return;
            LocationClient.jdMethod_int(LocationClient.this);
            return;
          } while (!LocationClient.jdMethod_else(LocationClient.this).jdField_goto);
          LocationClient.jdMethod_for(LocationClient.this, true);
          return;
        } while (!LocationClient.jdMethod_else(LocationClient.this).jdField_goto);
        LocationClient.jdMethod_for(LocationClient.this, false);
        return;
      case 21: 
        LocationClient.jdMethod_if(LocationClient.this, paramMessage, 21);
        return;
      case 26: 
        LocationClient.jdMethod_if(LocationClient.this, paramMessage, 26);
        return;
      case 27: 
        LocationClient.jdMethod_try(LocationClient.this, paramMessage);
        return;
      case 205: 
        LocationClient.jdMethod_do(LocationClient.this, true);
        return;
      }
      LocationClient.jdMethod_do(LocationClient.this, false);
    }
  }
  
  private class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      synchronized (LocationClient.jdMethod_for(LocationClient.this))
      {
        LocationClient.jdMethod_int(LocationClient.this, false);
        if ((LocationClient.jdMethod_char(LocationClient.this) == null) || (LocationClient.jdMethod_new(LocationClient.this) == null)) {
          return;
        }
        if ((LocationClient.jdMethod_goto(LocationClient.this) == null) || (LocationClient.jdMethod_goto(LocationClient.this).size() < 1)) {
          return;
        }
      }
      LocationClient.jdMethod_byte(LocationClient.this).obtainMessage(4).sendToTarget();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\LocationClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */