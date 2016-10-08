package com.taobao.applink.service;

import com.taobao.applink.usertracker.TBMiniUserTrack;

public class TBAppLinkServiceProxy
{
  private static TBMiniUserTrack mTBMiniUserTrack;
  
  public static void destroy()
  {
    try
    {
      mTBMiniUserTrack = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static TBMiniUserTrack getTBMiniUserTrack()
  {
    try
    {
      TBMiniUserTrack localTBMiniUserTrack = mTBMiniUserTrack;
      return localTBMiniUserTrack;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void registerUserTrack(TBMiniUserTrack paramTBMiniUserTrack)
  {
    try
    {
      mTBMiniUserTrack = paramTBMiniUserTrack;
      return;
    }
    finally
    {
      paramTBMiniUserTrack = finally;
      throw paramTBMiniUserTrack;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\service\TBAppLinkServiceProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */