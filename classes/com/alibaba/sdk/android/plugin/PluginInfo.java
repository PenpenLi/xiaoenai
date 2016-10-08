package com.alibaba.sdk.android.plugin;

import com.alibaba.sdk.android.util.SortUtils.SortInfo;
import java.io.Serializable;
import java.util.Map;

public class PluginInfo
  extends SortUtils.SortInfo
  implements Serializable
{
  private static final long serialVersionUID = 9167423926625476763L;
  public String lifecycleAdapterClassName;
  public Map<String, String> properties;
  public String version;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (PluginInfo)paramObject;
        if (this.name != null) {
          break;
        }
      } while (((PluginInfo)paramObject).name == null);
      return false;
    } while (this.name.equals(((PluginInfo)paramObject).name));
    return false;
  }
  
  public int hashCode()
  {
    if (this.name == null) {}
    for (int i = 0;; i = this.name.hashCode()) {
      return i + 31;
    }
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\plugin\PluginInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */