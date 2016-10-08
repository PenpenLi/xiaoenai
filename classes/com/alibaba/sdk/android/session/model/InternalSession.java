package com.alibaba.sdk.android.session.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class InternalSession
{
  public Map<String, String[]> cookies;
  public Long createTime;
  public Integer expireIn;
  public Map<String, Object> otherInfo;
  public String sid;
  public User user;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InternalSession [sid=");
    localStringBuilder.append(this.sid);
    localStringBuilder.append(", expireIn=");
    localStringBuilder.append(this.expireIn);
    localStringBuilder.append(", createTime=");
    localStringBuilder.append(this.createTime);
    localStringBuilder.append(", user=");
    localStringBuilder.append(this.user);
    localStringBuilder.append(", otherInfo=");
    localStringBuilder.append(this.otherInfo);
    localStringBuilder.append(", cookies=");
    if (this.cookies != null)
    {
      Iterator localIterator = this.cookies.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append((String)localEntry.getKey() + ":" + Arrays.toString((Object[])localEntry.getValue()));
      }
    }
    localStringBuilder.append("null");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\session\model\InternalSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */