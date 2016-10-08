package d.a;

import android.os.Build;
import android.os.Build.VERSION;

public class dm
  extends de
{
  public dm()
  {
    super("serial");
  }
  
  public String a()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return Build.SERIAL;
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */