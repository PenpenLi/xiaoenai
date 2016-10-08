package com.alibaba.sdk.android;

import android.content.Context;
import com.alibaba.nb.android.trade.AliTradeSDK;
import com.alibaba.nb.android.trade.model.AliOpenType;
import com.alibaba.nb.android.trade.model.AliTradeShowParams;

public class AlibabaHelper
{
  public static boolean isInited = false;
  
  public static AliTradeShowParams creatAliTradeShowParams()
  {
    return new AliTradeShowParams(AliOpenType.H5, false);
  }
  
  public static void initSDK(Context paramContext, String paramString)
  {
    if (!isInited) {
      try
      {
        if (!isInited) {
          AliTradeSDK.asyncInit(paramContext, "23294540", new AlibabaHelper.1());
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\AlibabaHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */