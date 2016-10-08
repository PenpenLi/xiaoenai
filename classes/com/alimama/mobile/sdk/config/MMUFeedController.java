package com.alimama.mobile.sdk.config;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.alimama.config.MMUAdInfo;
import com.alimama.config.MMUCretiveInfo;
import com.alimama.mobile.sdk.config.system.MMLog;
import com.alimama.mobile.sdk.config.system.bridge.FeedPluginBridge2;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class MMUFeedController
{
  public View getFeedView(Activity paramActivity, MMUAdInfo paramMMUAdInfo, FrameLayout.LayoutParams paramLayoutParams)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMMUAdInfo);
    return getFeedView(paramActivity, localArrayList, paramLayoutParams);
  }
  
  public View getFeedView(Activity paramActivity, List<MMUAdInfo> paramList, FrameLayout.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams == null)
    {
      MMLog.w("请传入布局参数FrameLayout.LayoutParams", new Object[0]);
      return null;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = ((MMUAdInfo)paramList.get(0)).rtid;
      try
      {
        MMUFeedController.1 local1 = new MMUFeedController.1(this);
        paramActivity = (View)FeedPluginBridge2.getInstance().FeedViewFactory_getFeedView.invoke(null, new Object[] { paramActivity, paramList, Integer.valueOf(i), paramLayoutParams, local1 });
        return paramActivity;
      }
      catch (InvocationTargetException paramActivity)
      {
        paramActivity.printStackTrace();
      }
    }
    return null;
  }
  
  public static class FeedViewActionListener
  {
    public void onClick(Activity paramActivity, MMUCretiveInfo paramMMUCretiveInfo) {}
    
    public void onEvent(MMUCretiveInfo paramMMUCretiveInfo, int paramInt, String paramString) {}
    
    public void onImpression(MMUCretiveInfo paramMMUCretiveInfo, View paramView, int paramInt) {}
    
    public void onVideoComplete(MMUCretiveInfo paramMMUCretiveInfo) {}
    
    public void onVideoStart(MMUCretiveInfo paramMMUCretiveInfo) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\MMUFeedController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */