package com.unionpay.mobile.android.pboctransaction.samsung;

import android.content.Context;
import android.content.Intent;
import com.unionpay.client3.tsm.ITsmConnection;
import com.unionpay.mobile.android.pboctransaction.c;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.h;

public final class a
  implements c
{
  private Context a;
  private com.unionpay.mobile.android.pboctransaction.b b;
  private ITsmConnection c;
  private int d = 0;
  
  private void a(boolean paramBoolean)
  {
    if (this.b != null)
    {
      if (paramBoolean) {
        this.b.a();
      }
    }
    else {
      return;
    }
    this.b.b();
  }
  
  /* Error */
  public final java.util.ArrayList<com.unionpay.mobile.android.model.c> a(com.unionpay.mobile.android.pboctransaction.d paramd)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_3
    //   7: aload_2
    //   8: astore_1
    //   9: aload_0
    //   10: getfield 24	com/unionpay/mobile/android/pboctransaction/samsung/a:c	Lcom/unionpay/client3/tsm/ITsmConnection;
    //   13: ifnull +146 -> 159
    //   16: aload_0
    //   17: getfield 24	com/unionpay/mobile/android/pboctransaction/samsung/a:c	Lcom/unionpay/client3/tsm/ITsmConnection;
    //   20: aload_0
    //   21: getfield 20	com/unionpay/mobile/android/pboctransaction/samsung/a:d	I
    //   24: invokeinterface 47 2 0
    //   29: astore 5
    //   31: aload_2
    //   32: astore_1
    //   33: aload 5
    //   35: ifnull +124 -> 159
    //   38: aload_2
    //   39: astore_1
    //   40: aload 5
    //   42: arraylength
    //   43: ifle +116 -> 159
    //   46: new 49	java/util/ArrayList
    //   49: dup
    //   50: invokespecial 50	java/util/ArrayList:<init>	()V
    //   53: astore_1
    //   54: iconst_0
    //   55: istore 6
    //   57: iload 6
    //   59: aload 5
    //   61: arraylength
    //   62: if_icmpge +123 -> 185
    //   65: aload 5
    //   67: iload 6
    //   69: aaload
    //   70: invokevirtual 56	com/unionpay/client3/tsm/SeAppInfo:getAppAid	()Ljava/lang/String;
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +104 -> 179
    //   78: aload_2
    //   79: invokevirtual 62	java/lang/String:length	()I
    //   82: bipush 16
    //   84: if_icmple +95 -> 179
    //   87: ldc 64
    //   89: aload_2
    //   90: bipush 14
    //   92: bipush 16
    //   94: invokevirtual 68	java/lang/String:substring	(II)Ljava/lang/String;
    //   97: invokevirtual 72	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   100: ifne +79 -> 179
    //   103: iconst_0
    //   104: istore 7
    //   106: iload 7
    //   108: ifne +35 -> 143
    //   111: aload_1
    //   112: new 74	com/unionpay/mobile/android/model/a
    //   115: dup
    //   116: iconst_1
    //   117: aload 5
    //   119: iload 6
    //   121: aaload
    //   122: invokevirtual 56	com/unionpay/client3/tsm/SeAppInfo:getAppAid	()Ljava/lang/String;
    //   125: ldc 76
    //   127: aload 5
    //   129: iload 6
    //   131: aaload
    //   132: invokevirtual 79	com/unionpay/client3/tsm/SeAppInfo:getPan	()Ljava/lang/String;
    //   135: iconst_1
    //   136: invokespecial 82	com/unionpay/mobile/android/model/a:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   139: invokevirtual 86	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   142: pop
    //   143: iload 6
    //   145: iconst_1
    //   146: iadd
    //   147: istore 6
    //   149: goto -92 -> 57
    //   152: astore_2
    //   153: aload_3
    //   154: astore_1
    //   155: aload_2
    //   156: invokevirtual 89	android/os/RemoteException:printStackTrace	()V
    //   159: aload_1
    //   160: areturn
    //   161: astore_2
    //   162: aload 4
    //   164: astore_1
    //   165: aload_2
    //   166: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   169: aload_1
    //   170: areturn
    //   171: astore_2
    //   172: goto -7 -> 165
    //   175: astore_2
    //   176: goto -21 -> 155
    //   179: iconst_1
    //   180: istore 7
    //   182: goto -76 -> 106
    //   185: aload_1
    //   186: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	a
    //   0	187	1	paramd	com.unionpay.mobile.android.pboctransaction.d
    //   1	89	2	str	String
    //   152	4	2	localRemoteException1	android.os.RemoteException
    //   161	5	2	localException1	Exception
    //   171	1	2	localException2	Exception
    //   175	1	2	localRemoteException2	android.os.RemoteException
    //   6	148	3	localObject1	Object
    //   3	160	4	localObject2	Object
    //   29	99	5	arrayOfSeAppInfo	com.unionpay.client3.tsm.SeAppInfo[]
    //   55	93	6	i	int
    //   104	77	7	j	int
    // Exception table:
    //   from	to	target	type
    //   16	31	152	android/os/RemoteException
    //   40	54	152	android/os/RemoteException
    //   16	31	161	java/lang/Exception
    //   40	54	161	java/lang/Exception
    //   57	74	171	java/lang/Exception
    //   78	103	171	java/lang/Exception
    //   111	143	171	java/lang/Exception
    //   57	74	175	android/os/RemoteException
    //   78	103	175	android/os/RemoteException
    //   111	143	175	android/os/RemoteException
  }
  
  public final void a() {}
  
  public final void a(com.unionpay.mobile.android.pboctransaction.b paramb, Context paramContext)
  {
    this.b = paramb;
    this.a = paramContext;
    paramb = new Intent();
    paramb.setAction("com.unionpay.client3.action.TSM_MODEL");
    paramb.setPackage("com.unionpay");
    paramContext.startService(paramb);
    if (!paramContext.bindService(paramb, new b(this), 1))
    {
      h.a("plugin-clientV3", "startSamsungService() failed!!!");
      a(false);
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = null;
    if (this.c != null) {}
    try
    {
      h.a("plugin-clientV3", "--->" + e.a(paramArrayOfByte));
      paramArrayOfByte = this.c.sendApdu(this.d, e.a(paramArrayOfByte), paramInt);
      h.a("plugin-clientV3", "<---" + paramArrayOfByte);
      arrayOfByte = e.a(paramArrayOfByte);
      return arrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public final void b() {}
  
  public final void c() {}
  
  public final void d() {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\pboctransaction\samsung\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */