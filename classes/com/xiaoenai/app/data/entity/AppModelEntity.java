package com.xiaoenai.app.data.entity;

import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

public class AppModelEntity
{
  @SerializedName(a="account")
  private String account = "";
  @SerializedName(a="aud_key")
  private String audioKey = "";
  @SerializedName(a="img_key")
  private String imageKey = "";
  @SerializedName(a="register_phone")
  private String registerPhone = "";
  @SerializedName(a="sig_secret")
  private String sigKey = "";
  @SerializedName(a="access_token")
  private String token = null;
  @SerializedName(a="uid")
  private int userId = -1;
  @SerializedName(a="user_info")
  JSONObject userInfo = null;
  
  public String getAccount()
  {
    return this.account;
  }
  
  public String getAudioKey()
  {
    return this.audioKey;
  }
  
  public String getImageKey()
  {
    return this.imageKey;
  }
  
  public String getRegisterPhone()
  {
    return this.registerPhone;
  }
  
  public String getSigKey()
  {
    return this.sigKey;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public int getUserId()
  {
    if ((-1 == this.userId) && (this.userInfo != null)) {
      this.userId = this.userInfo.optInt("uid", -1);
    }
    return this.userId;
  }
  
  public JSONObject getUserInfo()
  {
    return this.userInfo;
  }
  
  public void setAccount(String paramString)
  {
    this.account = paramString;
  }
  
  public void setAudioKey(String paramString)
  {
    this.audioKey = paramString;
  }
  
  public void setImageKey(String paramString)
  {
    this.imageKey = paramString;
  }
  
  public void setRegisterPhone(String paramString)
  {
    this.registerPhone = paramString;
  }
  
  public void setSigKey(String paramString)
  {
    this.sigKey = paramString;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
  
  public void setUserId(int paramInt)
  {
    this.userId = paramInt;
  }
  
  public void setUserInfo(JSONObject paramJSONObject)
  {
    this.userInfo = paramJSONObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\entity\AppModelEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */