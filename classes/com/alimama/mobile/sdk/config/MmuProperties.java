package com.alimama.mobile.sdk.config;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class MmuProperties
{
  private ACCT acct = ACCT.VIEW;
  private WeakReference<Activity> activityRef;
  private String adSize = "0x0";
  public Object adsMogoConfigDataList = null;
  private Map<String, Object> extra;
  private int layoutType;
  protected MmuController<?> mmuController;
  private String slot_id;
  public Object tag;
  
  public MmuProperties(Activity paramActivity, String paramString, int paramInt)
  {
    this.slot_id = paramString;
    this.layoutType = paramInt;
    this.activityRef = new WeakReference(paramActivity);
  }
  
  public boolean containsExtraKey(String paramString)
  {
    return (this.extra != null) && (this.extra.containsKey(paramString));
  }
  
  public ACCT getAcct()
  {
    return this.acct;
  }
  
  public Activity getActivity()
  {
    if (this.activityRef != null) {
      return (Activity)this.activityRef.get();
    }
    return null;
  }
  
  public String getAdSize()
  {
    return this.adSize;
  }
  
  public Object getExtra(String paramString)
  {
    if (this.extra != null) {
      return this.extra.get(paramString);
    }
    return null;
  }
  
  public int getLayoutType()
  {
    return this.layoutType;
  }
  
  public String[] getPluginNames()
  {
    return null;
  }
  
  public String getSlot_id()
  {
    return this.slot_id;
  }
  
  public Object getTag()
  {
    return this.tag;
  }
  
  public void putExtra(String paramString, Object paramObject)
  {
    if (this.extra == null) {
      this.extra = new HashMap();
    }
    this.extra.put(paramString, paramObject);
  }
  
  public void setAcct(ACCT paramACCT)
  {
    this.acct = paramACCT;
  }
  
  public void setAdSize(int paramInt1, int paramInt2)
  {
    this.adSize = (paramInt1 + "x" + paramInt2);
  }
  
  public void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
  
  public static enum ACCT
  {
    DATA(2),  VIEW(1);
    
    private int value;
    
    private ACCT(int paramInt)
    {
      this.value = paramInt;
    }
    
    public int getValue()
    {
      return this.value;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\MmuProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */