package com.alimama.mobile.sdk.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class AdBaseInfo
  implements IAdBaseInfo
{
  private HashMap<String, String> baseInfo = new HashMap(10);
  
  private AdBaseInfo(String paramString)
  {
    this.baseInfo.put("pid", paramString);
  }
  
  public static AdBaseInfo getInsVideoInstance(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = new AdBaseInfo(paramString1);
    paramString1.baseInfo.put("tt", paramString2);
    paramString1.baseInfo.put("dur", paramString3);
    paramString1.baseInfo.put("ca", paramString4);
    paramString1.baseInfo.put("vt", "107");
    return paramString1;
  }
  
  public static AdBaseInfo getVideoInstance(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = new AdBaseInfo(paramString1);
    paramString1.baseInfo.put("size", String.valueOf(paramInt1) + "*" + String.valueOf(paramInt2));
    paramString1.baseInfo.put("tt", paramString2);
    paramString1.baseInfo.put("dur", paramString3);
    paramString1.baseInfo.put("ca", paramString4);
    paramString1.baseInfo.put("sd", paramString5);
    paramString1.baseInfo.put("vt", "106");
    return paramString1;
  }
  
  public String encodeModel()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.baseInfo.keySet().iterator();
    if (localIterator != null)
    {
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)this.baseInfo.get(str1);
        localStringBuilder.append(str1);
        localStringBuilder.append("=");
        localStringBuilder.append(str2);
        localStringBuilder.append("&");
      }
      return localStringBuilder.substring(0, localStringBuilder.length() - 1);
    }
    return "";
  }
  
  public String getId()
  {
    return (String)this.baseInfo.get("pid");
  }
  
  public int getType()
  {
    return 0;
  }
  
  public String getV_cat()
  {
    return (String)this.baseInfo.get("ca");
  }
  
  public String getV_dur()
  {
    return (String)this.baseInfo.get("dur");
  }
  
  public String getV_ssd()
  {
    return (String)this.baseInfo.get("sd");
  }
  
  public String getV_title()
  {
    return (String)this.baseInfo.get("tt");
  }
  
  public int[] getViewSize()
  {
    Object localObject = (String)this.baseInfo.get("size");
    if (localObject != null)
    {
      localObject = ((String)localObject).split("*");
      if ((localObject != null) && (localObject.length == 2)) {
        return new int[] { Integer.valueOf(localObject[0]).intValue(), Integer.valueOf(localObject[1]).intValue() };
      }
    }
    return null;
  }
  
  public void setId(String paramString)
  {
    HashMap localHashMap = this.baseInfo;
    if (paramString != null) {}
    for (;;)
    {
      localHashMap.put("pid", paramString);
      return;
      paramString = "";
    }
  }
  
  public void setV_cat(String paramString)
  {
    HashMap localHashMap = this.baseInfo;
    if (paramString != null) {}
    for (;;)
    {
      localHashMap.put("ca", paramString);
      return;
      paramString = "";
    }
  }
  
  public void setV_dur(String paramString)
  {
    HashMap localHashMap = this.baseInfo;
    if (paramString != null) {}
    for (;;)
    {
      localHashMap.put("dur", paramString);
      return;
      paramString = "";
    }
  }
  
  public void setV_ssd(String paramString)
  {
    HashMap localHashMap = this.baseInfo;
    if (paramString != null) {}
    for (;;)
    {
      localHashMap.put("sd", paramString);
      return;
      paramString = "";
    }
  }
  
  public void setV_title(String paramString)
  {
    HashMap localHashMap = this.baseInfo;
    if (paramString != null) {}
    for (;;)
    {
      localHashMap.put("tt", paramString);
      return;
      paramString = "";
    }
  }
  
  public void setViewSize(int paramInt1, int paramInt2)
  {
    this.baseInfo.put("size", String.valueOf(paramInt1) + "*" + String.valueOf(paramInt2));
  }
  
  private static class Protocol
  {
    static final String KEY_ID = "pid";
    static final String KEY_SIZE = "size";
    static final String KEY_VIDEO_CAT = "ca";
    static final String KEY_VIDEO_DUR = "dur";
    static final String KEY_VIDEO_SSD = "sd";
    static final String KEY_VIDEO_TITLE = "tt";
    static final String KEY_VIEW_TYPE = "vt";
    static final String PARAM_AND = "&";
    static final String PARAM_EQUAL = "=";
    static final String PARAM_STAR = "*";
    static final String PARAM_VT_INTERSTITIAL = "107";
    static final String PARAM_VT_PATCH = "106";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\AdBaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */