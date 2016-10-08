package com.alibaba.sdk.android.ut;

import android.app.Activity;
import java.util.Map;

public abstract interface UserTrackerService
{
  public abstract String getDefaultUserTrackerId();
  
  public abstract void sendCustomHit(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3, Map<String, String> paramMap);
  
  public abstract void sendCustomHit(String paramString1, long paramLong, String paramString2, Map<String, String> paramMap);
  
  public abstract void sendCustomHit(String paramString, Activity paramActivity);
  
  public abstract void sendCustomHit(String paramString1, String paramString2, Map<String, String> paramMap);
  
  public abstract void updateUserTrackerProperties(Map<String, Object> paramMap);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ut\UserTrackerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */