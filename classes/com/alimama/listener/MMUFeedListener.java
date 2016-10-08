package com.alimama.listener;

import com.alimama.config.MMUAdInfo;
import java.util.List;

public abstract interface MMUFeedListener
{
  public abstract void onClicked(String paramString);
  
  public abstract void onRequestFeedAdFail(String paramString, int paramInt);
  
  public abstract void onRequestFeedAdSuccess(String paramString, List<MMUAdInfo> paramList);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\listener\MMUFeedListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */