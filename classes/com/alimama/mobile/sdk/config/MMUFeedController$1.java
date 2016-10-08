package com.alimama.mobile.sdk.config;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.alimama.config.MMUAdInfo;
import com.alimama.config.MMUCretiveInfo;
import com.alimama.listener.MMUAdInfoStateReporter;
import java.util.HashSet;
import java.util.Set;

class MMUFeedController$1
  extends MMUFeedController.FeedViewActionListener
{
  Set<Integer> reported = new HashSet();
  
  MMUFeedController$1(MMUFeedController paramMMUFeedController) {}
  
  public void onClick(Activity paramActivity, MMUCretiveInfo paramMMUCretiveInfo)
  {
    if ((paramMMUCretiveInfo instanceof MMUAdInfo)) {
      ((MMUAdInfo)paramMMUCretiveInfo).getStateReporter().onClickAd();
    }
  }
  
  public void onEvent(MMUCretiveInfo paramMMUCretiveInfo, int paramInt, String paramString)
  {
    if ((paramMMUCretiveInfo != null) && ((paramMMUCretiveInfo instanceof MMUAdInfo))) {
      ((MMUAdInfo)paramMMUCretiveInfo).onEvent(paramInt, paramString);
    }
  }
  
  public void onImpression(MMUCretiveInfo paramMMUCretiveInfo, View paramView, int paramInt)
  {
    if (((paramMMUCretiveInfo instanceof MMUAdInfo)) && (!this.reported.contains(Integer.valueOf(paramInt))))
    {
      ((MMUAdInfo)paramMMUCretiveInfo).getStateReporter().onAttachAdView((ViewGroup)paramView);
      this.reported.add(Integer.valueOf(paramInt));
    }
  }
  
  public void onVideoComplete(MMUCretiveInfo paramMMUCretiveInfo)
  {
    if ((paramMMUCretiveInfo != null) && ((paramMMUCretiveInfo instanceof MMUAdInfo))) {
      ((MMUAdInfo)paramMMUCretiveInfo).notifyVideoOnComplete();
    }
  }
  
  public void onVideoStart(MMUCretiveInfo paramMMUCretiveInfo)
  {
    if ((paramMMUCretiveInfo != null) && ((paramMMUCretiveInfo instanceof MMUAdInfo))) {
      ((MMUAdInfo)paramMMUCretiveInfo).notifyVideoOnStart();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\MMUFeedController$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */