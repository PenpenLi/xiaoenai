package com.alimama.config;

import android.view.ViewGroup;
import com.alimama.listener.MMUAdInfoEventStateReporter;
import com.alimama.listener.MMUAdInfoStateReporter;
import com.alimama.listener.MMUAdInfoVideoStateReporter;
import com.alimama.mobile.sdk.config.system.MMLog;
import java.util.HashMap;
import java.util.Map;

public class MMUAdInfo
  extends MMUCretiveInfo
{
  private MMUAdInfoEventStateReporter adInfoEventStateReporter;
  private HashMap<String, Object> content;
  public int rtid = 0;
  private MMUAdInfoStateReporter stateReporter;
  private MMUAdInfoVideoStateReporter videoStateReporter;
  
  private void setCreativeInfoByMap()
  {
    if (this.content == null) {
      return;
    }
    this.title = getContentValue("title");
    this.sub_title = getContentValue("sub_title");
    this.img_url = getContentValue("img_url");
    this.price = getContentValue("price");
    this.promoprice = getContentValue("promoprice");
    this.sell = getContentValue("sell");
    this.img_size = getContentValue("img_size");
    if ((this.rtid == 2) && (!getContentValue("icon_url").equals(""))) {
      this.img_url = getContentValue("icon_url");
    }
    if ((this.content != null) && (this.content.containsKey("effects")))
    {
      localObject = (HashMap)this.content.get("effects");
      if (((Map)localObject).containsKey("play_type")) {
        if (((Map)localObject).get("play_type") != null) {
          break label207;
        }
      }
    }
    label207:
    for (Object localObject = "1";; localObject = ((Map)localObject).get("play_type").toString())
    {
      this.auto_play = ((String)localObject);
      this.content.put("auto_play", this.auto_play);
      this.video_time = getContentValue("video_time");
      this.video_url = getContentValue("video_url");
      return;
    }
  }
  
  public void attachAdView(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      MMLog.d("MMUNativeAdInfo attachAdView", new Object[0]);
      if (this.stateReporter != null) {
        this.stateReporter.onAttachAdView(paramViewGroup);
      }
      return;
    }
    MMLog.e("MMUNativeAdInfo attachAdView is null", new Object[0]);
  }
  
  public HashMap<String, Object> getContent()
  {
    return this.content;
  }
  
  public String getContentValue(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (this.content != null)
    {
      paramString = this.content.get(paramString);
      str1 = str2;
      if (paramString != null) {
        str1 = paramString.toString();
      }
    }
    return str1;
  }
  
  public MMUAdInfoStateReporter getStateReporter()
  {
    return this.stateReporter;
  }
  
  public void notifyVideoOnComplete()
  {
    if (this.videoStateReporter != null) {
      this.videoStateReporter.notifyVideoOnComplete();
    }
  }
  
  public void notifyVideoOnStart()
  {
    if (this.videoStateReporter != null) {
      this.videoStateReporter.notifyVideoOnStart();
    }
  }
  
  public void onClickAd()
  {
    if (this.stateReporter != null) {
      this.stateReporter.onClickAd();
    }
  }
  
  public void onDestroy()
  {
    if (this.stateReporter != null) {
      this.stateReporter.onDestroy();
    }
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (this.adInfoEventStateReporter != null) {
      this.adInfoEventStateReporter.onEvent(paramInt, paramString);
    }
  }
  
  public void setAdInfoEventStateReporter(MMUAdInfoEventStateReporter paramMMUAdInfoEventStateReporter)
  {
    this.adInfoEventStateReporter = paramMMUAdInfoEventStateReporter;
  }
  
  public void setContent(HashMap<String, Object> paramHashMap)
  {
    this.content = paramHashMap;
    setCreativeInfoByMap();
  }
  
  public void setStateReporter(MMUAdInfoStateReporter paramMMUAdInfoStateReporter)
  {
    this.stateReporter = paramMMUAdInfoStateReporter;
  }
  
  public void setVideoStateReporter(MMUAdInfoVideoStateReporter paramMMUAdInfoVideoStateReporter)
  {
    this.videoStateReporter = paramMMUAdInfoVideoStateReporter;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\config\MMUAdInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */