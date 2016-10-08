package d.a;

import android.content.Context;
import android.provider.Settings.Secure;

public class df
  extends de
{
  private Context a;
  
  public df(Context paramContext)
  {
    super("android_id");
    this.a = paramContext;
  }
  
  public String a()
  {
    try
    {
      String str = Settings.Secure.getString(this.a.getContentResolver(), "android_id");
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */