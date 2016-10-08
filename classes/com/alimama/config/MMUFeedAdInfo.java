package com.alimama.config;

import android.view.View;
import android.view.ViewGroup;
import com.alimama.listener.MMUNativeAdapterListener;
import com.alimama.mobile.sdk.config.system.MMLog;
import java.util.HashMap;

public class MMUFeedAdInfo
{
  private MMUNativeAdapterListener adsMogoNativeAdapterListener;
  private HashMap<String, Object> content;
  private GetViewListener getViewListener;
  private View view;
  
  public void attachAdView(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      MMLog.d("MMUNativeAdInfo attachAdView", new Object[0]);
      this.adsMogoNativeAdapterListener.onAttachAdView(paramViewGroup);
      return;
    }
    MMLog.e("MMUNativeAdInfo attachAdView is null", new Object[0]);
  }
  
  public void clickAd()
  {
    this.adsMogoNativeAdapterListener.onClickAd();
  }
  
  public HashMap<String, Object> getContent()
  {
    return this.content;
  }
  
  public MMUNativeAdapterListener getMMUNativeAdapterListener()
  {
    return this.adsMogoNativeAdapterListener;
  }
  
  public View getView()
  {
    if ((this.getViewListener != null) && (this.view == null))
    {
      this.view = this.getViewListener.getView();
      return this.view;
    }
    return this.view;
  }
  
  public void onBackPressed()
  {
    this.adsMogoNativeAdapterListener.onBackPressed();
  }
  
  public void setContent(HashMap<String, Object> paramHashMap)
  {
    this.content = paramHashMap;
  }
  
  public void setGetViewListener(GetViewListener paramGetViewListener)
  {
    this.getViewListener = paramGetViewListener;
  }
  
  public void setMMUNativeAdapterListener(MMUNativeAdapterListener paramMMUNativeAdapterListener)
  {
    this.adsMogoNativeAdapterListener = paramMMUNativeAdapterListener;
  }
  
  public void setView(View paramView)
  {
    this.view = paramView;
  }
  
  public static abstract interface GetViewListener
  {
    public abstract View getView();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\config\MMUFeedAdInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */