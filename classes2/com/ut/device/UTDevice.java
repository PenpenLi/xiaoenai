package com.ut.device;

import android.content.Context;

public class UTDevice
{
  public static String getAid(String paramString1, String paramString2, Context paramContext)
  {
    return com.ta.utdid2.a.a.a(paramContext).a(paramString1, paramString2, getUtdid(paramContext));
  }
  
  public static void getAidAsync(String paramString1, String paramString2, Context paramContext, a parama)
  {
    com.ta.utdid2.a.a.a(paramContext).a(paramString1, paramString2, getUtdid(paramContext), parama);
  }
  
  public static String getUtdid(Context paramContext)
  {
    return com.ta.utdid2.device.UTDevice.getUtdid(paramContext);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\device\UTDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */