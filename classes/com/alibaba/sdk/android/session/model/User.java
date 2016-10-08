package com.alibaba.sdk.android.session.model;

public class User
{
  public String avatarUrl;
  public String id;
  public String nick;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("User [id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", nick=");
    localStringBuilder.append(this.nick);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\session\model\User.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */