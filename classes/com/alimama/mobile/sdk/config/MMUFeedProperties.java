package com.alimama.mobile.sdk.config;

import android.app.Activity;
import com.alimama.config.custom.MMUFeedCustomAdapter;
import com.alimama.listener.MMUFeedListener;

public class MMUFeedProperties
  extends MmuProperties
{
  public static final int TYPE = 12;
  private final MMUFeedController mController = new MMUFeedController();
  private MMUFeedListener mMUFeedListener;
  private int reqCount = 1;
  
  public MMUFeedProperties(Activity paramActivity, String paramString)
  {
    super(paramActivity, paramString, 12);
  }
  
  public void addCustomAdapter(int paramInt, MMUFeedCustomAdapter paramMMUFeedCustomAdapter)
  {
    putExtra("" + paramInt, paramMMUFeedCustomAdapter);
  }
  
  public MMUFeedController getController()
  {
    return this.mController;
  }
  
  public MMUFeedListener getMMUFeedListener()
  {
    return this.mMUFeedListener;
  }
  
  public String[] getPluginNames()
  {
    return new String[] { "FeedPlugin" };
  }
  
  public int getReqCount()
  {
    return this.reqCount;
  }
  
  public void setMMUFeedListener(MMUFeedListener paramMMUFeedListener)
  {
    this.mMUFeedListener = paramMMUFeedListener;
  }
  
  public void setReqCount(int paramInt)
  {
    this.reqCount = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\MMUFeedProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */