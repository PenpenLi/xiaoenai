package com.xiaoenai.app.model;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.utils.d.f;
import com.xiaoenai.app.utils.f.a;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class AppModel
{
  private static final String FILENAME = "app.dat";
  private static AppModel appModel = null;
  private String audioKey = "";
  private String imageKey = "";
  private String lastLoginAccount = "";
  private String lastRegisterPhoneNumber = "";
  private String sigKey = "";
  private String token = null;
  private int userId = -1;
  
  private AppModel()
  {
    try
    {
      File localFile = f.a(Xiaoenai.j(), "app.dat");
      if (localFile.exists()) {
        loadFromJson(f.b(localFile));
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private JSONObject createJson()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("access_token", this.token);
    localJSONObject.put("uid", this.userId);
    localJSONObject.put("sig_secret", this.sigKey);
    localJSONObject.put("img_key", this.imageKey);
    localJSONObject.put("aud_key", this.audioKey);
    localJSONObject.put("account", this.lastLoginAccount);
    localJSONObject.put("register_phone", this.lastRegisterPhoneNumber);
    return localJSONObject;
  }
  
  public static AppModel getInstance()
  {
    if (appModel == null) {}
    try
    {
      if (appModel == null) {
        appModel = new AppModel();
      }
      return appModel;
    }
    finally {}
  }
  
  public static void logout()
  {
    if (appModel != null)
    {
      appModel.setToken("");
      appModel.setImageKey("");
      appModel.setSigKey("");
      appModel.save();
    }
    release();
  }
  
  public static void release()
  {
    appModel = null;
  }
  
  public String getAudioKey()
  {
    return this.audioKey;
  }
  
  public String getImageKey()
  {
    return this.imageKey;
  }
  
  public String getLastLoginAccount()
  {
    return this.lastLoginAccount;
  }
  
  public String getLastRegisterPhoneNumber()
  {
    return this.lastRegisterPhoneNumber;
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
    return this.userId;
  }
  
  public boolean isLogined()
  {
    return (this.token != null) && (this.token.length() > 0);
  }
  
  public void loadFromJson(JSONObject paramJSONObject)
  {
    try
    {
      if ((paramJSONObject.has("access_token")) && (!paramJSONObject.isNull("access_token"))) {
        this.token = paramJSONObject.getString("access_token");
      }
      if ((paramJSONObject.has("sig_secret")) && (!paramJSONObject.isNull("sig_secret"))) {
        this.sigKey = paramJSONObject.getString("sig_secret");
      }
      if (paramJSONObject.has("user_info"))
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject("user_info");
        if (localJSONObject.has("uid")) {
          this.userId = localJSONObject.getInt("uid");
        }
      }
      for (;;)
      {
        if ((paramJSONObject.has("img_key")) && (!paramJSONObject.isNull("img_key"))) {
          this.imageKey = paramJSONObject.getString("img_key");
        }
        if ((paramJSONObject.has("aud_key")) && (!paramJSONObject.isNull("aud_key"))) {
          this.audioKey = paramJSONObject.getString("aud_key");
        }
        if (paramJSONObject.has("account")) {
          this.lastLoginAccount = paramJSONObject.getString("account");
        }
        if (!paramJSONObject.has("register_phone")) {
          break;
        }
        this.lastRegisterPhoneNumber = paramJSONObject.getString("register_phone");
        return;
        if (paramJSONObject.has("uid")) {
          this.userId = paramJSONObject.getInt("uid");
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void save()
  {
    try
    {
      f.b(createJson(), f.a(Xiaoenai.j(), "app.dat"));
      return;
    }
    catch (Exception localException)
    {
      a.a("save app model info failed!", new Object[0]);
      localException.printStackTrace();
    }
  }
  
  public void setAudioKey(String paramString)
  {
    this.audioKey = paramString;
  }
  
  public void setImageKey(String paramString)
  {
    this.imageKey = paramString;
  }
  
  public void setLastLoginAccount(String paramString)
  {
    this.lastLoginAccount = paramString;
  }
  
  public void setLastRegisterPhoneNumber(String paramString)
  {
    this.lastRegisterPhoneNumber = paramString;
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
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\AppModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */