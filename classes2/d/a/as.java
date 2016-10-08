package d.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

public class as
{
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = b(paramContext);
      if (paramContext == null) {
        return null;
      }
      paramContext = a.a(paramContext);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  private static a b(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      b localb = new b(null);
      Object localObject1 = new Intent("com.google.android.gms.ads.identifier.service.START");
      ((Intent)localObject1).setPackage("com.google.android.gms");
      if (paramContext.bindService((Intent)localObject1, localb, 1)) {}
      throw new IOException("Google Play connection failed");
    }
    catch (Exception paramContext)
    {
      try
      {
        localObject1 = new c(localb.a());
        localObject1 = new a(((c)localObject1).a(), ((c)localObject1).a(true));
        return (a)localObject1;
      }
      catch (Exception localException)
      {
        throw localException;
      }
      finally
      {
        paramContext.unbindService(localb);
      }
      paramContext = paramContext;
      throw paramContext;
    }
  }
  
  private static final class a
  {
    private final String a;
    private final boolean b;
    
    a(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }
    
    private String a()
    {
      return this.a;
    }
  }
  
  private static final class b
    implements ServiceConnection
  {
    boolean a = false;
    private final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue(1);
    
    public IBinder a()
    {
      if (this.a) {
        throw new IllegalStateException();
      }
      this.a = true;
      return (IBinder)this.b.take();
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      try
      {
        this.b.put(paramIBinder);
        return;
      }
      catch (InterruptedException paramComponentName) {}
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName) {}
  }
  
  private static final class c
    implements IInterface
  {
    private IBinder a;
    
    public c(IBinder paramIBinder)
    {
      this.a = paramIBinder;
    }
    
    public String a()
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        String str = localParcel2.readString();
        return str;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
    
    /* Error */
    public boolean a(boolean paramBoolean)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 6
      //   3: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   6: astore_2
      //   7: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   10: astore_3
      //   11: aload_2
      //   12: ldc 28
      //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   17: iload_1
      //   18: ifeq +54 -> 72
      //   21: iconst_1
      //   22: istore 5
      //   24: aload_2
      //   25: iload 5
      //   27: invokevirtual 52	android/os/Parcel:writeInt	(I)V
      //   30: aload_0
      //   31: getfield 18	d/a/as$c:a	Landroid/os/IBinder;
      //   34: iconst_2
      //   35: aload_2
      //   36: aload_3
      //   37: iconst_0
      //   38: invokeinterface 38 5 0
      //   43: pop
      //   44: aload_3
      //   45: invokevirtual 41	android/os/Parcel:readException	()V
      //   48: aload_3
      //   49: invokevirtual 56	android/os/Parcel:readInt	()I
      //   52: istore 5
      //   54: iload 5
      //   56: ifeq +22 -> 78
      //   59: iload 6
      //   61: istore_1
      //   62: aload_3
      //   63: invokevirtual 47	android/os/Parcel:recycle	()V
      //   66: aload_2
      //   67: invokevirtual 47	android/os/Parcel:recycle	()V
      //   70: iload_1
      //   71: ireturn
      //   72: iconst_0
      //   73: istore 5
      //   75: goto -51 -> 24
      //   78: iconst_0
      //   79: istore_1
      //   80: goto -18 -> 62
      //   83: astore 4
      //   85: aload_3
      //   86: invokevirtual 47	android/os/Parcel:recycle	()V
      //   89: aload_2
      //   90: invokevirtual 47	android/os/Parcel:recycle	()V
      //   93: aload 4
      //   95: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	96	0	this	c
      //   0	96	1	paramBoolean	boolean
      //   6	84	2	localParcel1	Parcel
      //   10	76	3	localParcel2	Parcel
      //   83	11	4	localObject	Object
      //   22	52	5	i	int
      //   1	59	6	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   11	17	83	finally
      //   24	54	83	finally
    }
    
    public IBinder asBinder()
    {
      return this.a;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */