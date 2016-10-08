package com.xiaoenai.app.model;

public class RecentFace
{
  public String faceType = "big_face";
  public long lastUsedTime;
  public String url;
  public int usedCount = 1;
  
  public RecentFace() {}
  
  public RecentFace(long paramLong, String paramString)
  {
    this.lastUsedTime = paramLong;
    this.url = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\RecentFace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */