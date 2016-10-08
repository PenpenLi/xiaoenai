package d.a;

import android.content.Context;
import android.telephony.TelephonyManager;

public class dj
  extends de
{
  private Context a;
  
  public dj(Context paramContext)
  {
    super("imei");
    this.a = paramContext;
  }
  
  public String a()
  {
    Object localObject = (TelephonyManager)this.a.getSystemService("phone");
    if (localObject == null) {}
    try
    {
      if (av.a(this.a, "android.permission.READ_PHONE_STATE"))
      {
        localObject = ((TelephonyManager)localObject).getDeviceId();
        return (String)localObject;
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */