package cn.sharesdk.framework.utils;

import android.content.Context;

public class d
  extends com.mob.tools.log.d
{
  private d(Context paramContext, int paramInt, String paramString)
  {
    setCollector("SHARESDK", new e(this, paramContext, paramInt, paramString));
  }
  
  public static com.mob.tools.log.d a()
  {
    return getInstanceForSDK("SHARESDK", true);
  }
  
  public static com.mob.tools.log.d a(Context paramContext, int paramInt, String paramString)
  {
    return new d(paramContext, paramInt, paramString);
  }
  
  protected String getSDKTag()
  {
    return "SHARESDK";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */