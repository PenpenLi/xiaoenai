package com.alibaba.nb.android.trade.model;

import java.io.Serializable;

public class AliTradeTaokeParams
  implements Serializable
{
  public String pid;
  public String subPid;
  public String unionId;
  
  public AliTradeTaokeParams(String paramString1, String paramString2, String paramString3)
  {
    this.pid = paramString1;
    this.unionId = paramString2;
    this.subPid = paramString3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{\"pid\":\"");
    if (this.pid == null)
    {
      str = "";
      localStringBuilder = localStringBuilder.append(str).append("\",\"unionId\":\"");
      if (this.unionId != null) {
        break label84;
      }
      str = "";
      label41:
      localStringBuilder = localStringBuilder.append(str).append("\",\"subPid\":\"");
      if (this.subPid != null) {
        break label92;
      }
    }
    label84:
    label92:
    for (String str = "";; str = this.subPid)
    {
      return str + "\"}";
      str = this.pid;
      break;
      str = this.unionId;
      break label41;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\model\AliTradeTaokeParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */