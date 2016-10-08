package com.xiaoenai.app.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.j;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.common.internal.di.a.b;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.d.f;
import org.json.JSONException;
import org.json.JSONObject;

public class User
{
  private static final String FILENAME = "user.dat";
  private static User user = null;
  @SerializedName(a="avatar")
  private String avatar;
  @SerializedName(a="coin")
  private int coin = 0;
  @SerializedName(a="couple_photo")
  private String couplePhotoUrl;
  @SerializedName(a="diamond")
  private int diamonds = 0;
  @SerializedName(a="em_lover_username")
  private String emLoverUsername;
  @SerializedName(a="em_password")
  private String emPassword;
  @SerializedName(a="em_username")
  private String emUsername;
  @SerializedName(a="email")
  private String email;
  @SerializedName(a="first_together_ts")
  private long firstTogetherTs;
  @SerializedName(a="ip")
  private String ip;
  @SerializedName(a="love_time")
  private long lovedTime = -1L;
  @SerializedName(a="lover_app_channel")
  private String loverAppChannel;
  @SerializedName(a="lover_app_ver")
  private String loverAppVer;
  @SerializedName(a="lover_avatar")
  private String loverAvatar;
  @SerializedName(a="lover_coin")
  private int loverCoins = 0;
  @SerializedName(a="lover_device_jb")
  private String loverDeviceJb;
  @SerializedName(a="lover_device_os")
  private String loverDeviceOs;
  @SerializedName(a="lover_device_ver")
  private String loverDeviceVer;
  @SerializedName(a="lover_diamond")
  private int loverDiamonds = 0;
  @SerializedName(a="lover_email")
  private String loverEmail;
  @SerializedName(a="lover_uid")
  private int loverId = -1;
  @SerializedName(a="lover_ip")
  private String loverIp;
  @SerializedName(a="lover_nickname")
  String loverNickname;
  @SerializedName(a="lover_online_time")
  private int loverOnlineTime;
  @SerializedName(a="lover_phone")
  private String loverPhoneNum;
  @SerializedName(a="lover_qq_nickname")
  private String loverQQNickname;
  @SerializedName(a="lover_regist_ts")
  private long loverRegistTs;
  @SerializedName(a="lover_sina_nickname")
  private String loverSinaNickname;
  @SerializedName(a="lover_username")
  private String loverUserName;
  @SerializedName(a="lover_wx_nickname")
  private String loverWXNickname;
  @SerializedName(a="nickname")
  private String nickname;
  @SerializedName(a="online_time")
  private int onlineTime;
  @SerializedName(a="phone")
  private String phoneNum;
  @SerializedName(a="qq_nickname")
  private String qqNickname;
  @SerializedName(a="regist_ts")
  private long registTs;
  @SerializedName(a="sina_nickname")
  private String sinaNickname;
  @SerializedName(a="uid")
  private int userId = -1;
  @SerializedName(a="username")
  private String userName;
  @SerializedName(a="vip_expire")
  private long vipExpireTime = 0L;
  @SerializedName(a="wx_nickname")
  private String wxNickname;
  
  private User() {}
  
  public User(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("uid")) {
        this.userId = paramJSONObject.getInt("uid");
      }
      if (paramJSONObject.has("username")) {
        this.userName = paramJSONObject.getString("username");
      }
      if ((paramJSONObject.has("phone")) && (!paramJSONObject.isNull("phone"))) {
        this.phoneNum = paramJSONObject.getString("phone");
      }
      if (paramJSONObject.has("online_time")) {
        this.onlineTime = paramJSONObject.getInt("online_time");
      }
      if ((paramJSONObject.has("nickname")) && (!paramJSONObject.isNull("nickname"))) {
        this.nickname = paramJSONObject.getString("nickname");
      }
      if ((paramJSONObject.has("email")) && (!paramJSONObject.isNull("email"))) {
        this.email = paramJSONObject.getString("email");
      }
      if (paramJSONObject.has("avatar")) {
        this.avatar = paramJSONObject.getString("avatar");
      }
      if (paramJSONObject.has("diamond")) {
        this.diamonds = paramJSONObject.getInt("diamond");
      }
      if (paramJSONObject.has("coin")) {
        this.coin = paramJSONObject.optInt("coin");
      }
      if (paramJSONObject.has("lover_uid")) {
        if (paramJSONObject.isNull("lover_uid")) {
          break label1104;
        }
      }
      label1104:
      for (this.loverId = paramJSONObject.getInt("lover_uid");; this.loverId = -1)
      {
        if ((paramJSONObject.has("lover_username")) && (!paramJSONObject.isNull("lover_username"))) {
          this.loverUserName = paramJSONObject.getString("lover_username");
        }
        if ((paramJSONObject.has("lover_phone")) && (!paramJSONObject.isNull("lover_phone"))) {
          this.loverPhoneNum = paramJSONObject.getString("lover_phone");
        }
        if ((paramJSONObject.has("lover_nickname")) && (!paramJSONObject.isNull("lover_nickname"))) {
          this.loverNickname = paramJSONObject.getString("lover_nickname");
        }
        if ((paramJSONObject.has("lover_email")) && (!paramJSONObject.isNull("lover_email"))) {
          this.loverEmail = paramJSONObject.getString("lover_email");
        }
        if ((paramJSONObject.has("lover_avatar")) && (!paramJSONObject.isNull("lover_avatar"))) {
          this.loverAvatar = paramJSONObject.getString("lover_avatar");
        }
        if (paramJSONObject.has("lover_online_time")) {
          this.loverOnlineTime = paramJSONObject.getInt("lover_online_time");
        }
        if (paramJSONObject.has("diamond")) {
          this.loverDiamonds = paramJSONObject.getInt("diamond");
        }
        if (paramJSONObject.has("coin")) {
          this.loverCoins = paramJSONObject.getInt("coin");
        }
        if (paramJSONObject.has("love_time")) {
          this.lovedTime = paramJSONObject.getLong("love_time");
        }
        if (paramJSONObject.has("vip_expire")) {
          this.vipExpireTime = paramJSONObject.getLong("vip_expire");
        }
        if ((paramJSONObject.has("couple_photo")) && (!paramJSONObject.isNull("couple_photo"))) {
          setCouplePhotoUrl(paramJSONObject.getString("couple_photo"));
        }
        com.xiaoenai.app.utils.f.a.c("============ wx_nickname:{}", new Object[] { paramJSONObject.getString("wx_nickname") });
        if ((paramJSONObject.has("wx_nickname")) && (!paramJSONObject.isNull("wx_nickname"))) {
          setWx_nickname(paramJSONObject.getString("wx_nickname"));
        }
        if ((paramJSONObject.has("sina_nickname")) && (!paramJSONObject.isNull("sina_nickname"))) {
          setSina_nickname(paramJSONObject.getString("sina_nickname"));
        }
        if ((paramJSONObject.has("qq_nickname")) && (!paramJSONObject.isNull("qq_nickname"))) {
          setQq_nickname(paramJSONObject.getString("qq_nickname"));
        }
        if ((paramJSONObject.has("lover_qq_nickname")) && (!paramJSONObject.isNull("lover_qq_nickname"))) {
          setLover_qq_nickname(paramJSONObject.getString("lover_qq_nickname"));
        }
        if ((paramJSONObject.has("lover_sina_nickname")) && (!paramJSONObject.isNull("lover_sina_nickname"))) {
          setLover_sina_nickname(paramJSONObject.getString("lover_sina_nickname"));
        }
        if ((paramJSONObject.has("lover_wx_nickname")) && (!paramJSONObject.isNull("lover_wx_nickname"))) {
          setLover_wx_nickname(paramJSONObject.getString("lover_wx_nickname"));
        }
        if ((paramJSONObject.has("em_username")) && (!paramJSONObject.isNull("em_username"))) {
          setEmUsername(paramJSONObject.getString("em_username"));
        }
        if ((paramJSONObject.has("em_password")) && (!paramJSONObject.isNull("em_password"))) {
          setEmPassword(paramJSONObject.getString("em_password"));
        }
        if ((paramJSONObject.has("em_lover_username")) && (!paramJSONObject.isNull("em_lover_username"))) {
          setEmLoverUsername(paramJSONObject.getString("em_lover_username"));
        }
        if ((paramJSONObject.has("first_together_ts")) && (!paramJSONObject.isNull("first_together_ts"))) {
          setFirstTogetherTs(paramJSONObject.optLong("first_together_ts"));
        }
        if ((paramJSONObject.has("ip")) && (!paramJSONObject.isNull("ip"))) {
          setIp(paramJSONObject.optString("ip"));
        }
        if ((paramJSONObject.has("lover_ip")) && (!paramJSONObject.isNull("lover_ip"))) {
          setLoverIp(paramJSONObject.optString("lover_ip"));
        }
        if ((paramJSONObject.has("lover_app_channel")) && (!paramJSONObject.isNull("lover_app_channel"))) {
          setLoverAppChannel(paramJSONObject.optString("lover_app_channel"));
        }
        if ((paramJSONObject.has("lover_app_ver")) && (!paramJSONObject.isNull("lover_app_ver"))) {
          setLoverAppVer(paramJSONObject.optString("lover_app_ver"));
        }
        if ((paramJSONObject.has("lover_device_jb")) && (!paramJSONObject.isNull("lover_device_jb"))) {
          setLoverDeviceJb(paramJSONObject.optString("lover_device_jb"));
        }
        if ((paramJSONObject.has("lover_device_os")) && (!paramJSONObject.isNull("lover_device_os"))) {
          setLoverDeviceOs(paramJSONObject.optString("lover_device_os"));
        }
        if ((paramJSONObject.has("lover_device_ver")) && (!paramJSONObject.isNull("lover_device_ver"))) {
          setLoverDeviceVer(paramJSONObject.optString("lover_device_ver"));
        }
        if ((paramJSONObject.has("lover_regist_ts")) && (!paramJSONObject.isNull("lover_regist_ts"))) {
          setLoverRegistTs(paramJSONObject.optLong("lover_regist_ts"));
        }
        if ((!paramJSONObject.has("regist_ts")) || (paramJSONObject.isNull("regist_ts"))) {
          break;
        }
        setRegistTs(paramJSONObject.optLong("regist_ts"));
        return;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private JSONObject createJson()
  {
    return new JSONObject(new j().a(this, User.class));
  }
  
  /* Error */
  public static User getInstance()
  {
    // Byte code:
    //   0: getstatic 93	com/xiaoenai/app/model/User:user	Lcom/xiaoenai/app/model/User;
    //   3: ifnonnull +53 -> 56
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 93	com/xiaoenai/app/model/User:user	Lcom/xiaoenai/app/model/User;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +39 -> 53
    //   17: invokestatic 303	com/xiaoenai/app/Xiaoenai:j	()Lcom/xiaoenai/app/Xiaoenai;
    //   20: invokestatic 308	com/xiaoenai/app/model/AppModel:getInstance	()Lcom/xiaoenai/app/model/AppModel;
    //   23: invokevirtual 312	com/xiaoenai/app/model/AppModel:getUserId	()I
    //   26: ldc 8
    //   28: invokestatic 317	com/xiaoenai/app/utils/d/f:a	(Landroid/content/Context;ILjava/lang/String;)Ljava/io/File;
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual 323	java/io/File:exists	()Z
    //   36: ifeq +24 -> 60
    //   39: new 2	com/xiaoenai/app/model/User
    //   42: dup
    //   43: aload_0
    //   44: invokestatic 327	com/xiaoenai/app/utils/d/f:b	(Ljava/io/File;)Lorg/json/JSONObject;
    //   47: invokespecial 329	com/xiaoenai/app/model/User:<init>	(Lorg/json/JSONObject;)V
    //   50: putstatic 93	com/xiaoenai/app/model/User:user	Lcom/xiaoenai/app/model/User;
    //   53: ldc 2
    //   55: monitorexit
    //   56: getstatic 93	com/xiaoenai/app/model/User:user	Lcom/xiaoenai/app/model/User;
    //   59: areturn
    //   60: new 2	com/xiaoenai/app/model/User
    //   63: dup
    //   64: invokespecial 330	com/xiaoenai/app/model/User:<init>	()V
    //   67: putstatic 93	com/xiaoenai/app/model/User:user	Lcom/xiaoenai/app/model/User;
    //   70: goto -17 -> 53
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 331	java/lang/Exception:printStackTrace	()V
    //   78: new 2	com/xiaoenai/app/model/User
    //   81: dup
    //   82: invokespecial 330	com/xiaoenai/app/model/User:<init>	()V
    //   85: putstatic 93	com/xiaoenai/app/model/User:user	Lcom/xiaoenai/app/model/User;
    //   88: goto -35 -> 53
    //   91: astore_0
    //   92: ldc 2
    //   94: monitorexit
    //   95: aload_0
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	32	0	localObject1	Object
    //   73	2	0	localException	Exception
    //   91	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   17	53	73	java/lang/Exception
    //   60	70	73	java/lang/Exception
    //   9	13	91	finally
    //   17	53	91	finally
    //   53	56	91	finally
    //   60	70	91	finally
    //   74	88	91	finally
    //   92	95	91	finally
  }
  
  public static boolean isSingle()
  {
    return getInstance().getLoverId() <= 0;
  }
  
  public static boolean isWxEqNull()
  {
    boolean bool = false;
    if ((getInstance().getWx_nickname() == null) || (getInstance().getWx_nickname().equals(""))) {
      bool = true;
    }
    return bool;
  }
  
  public static void release()
  {
    user = null;
  }
  
  public String getAvatar()
  {
    return this.avatar + "?imageView/1/w/" + 640 + "/h/" + 640;
  }
  
  public int getCoin()
  {
    return this.coin;
  }
  
  public String getCouplePhotoUrl()
  {
    return this.couplePhotoUrl;
  }
  
  public int getDiamonds()
  {
    return this.diamonds;
  }
  
  public String getEmLoverUsername()
  {
    return this.emLoverUsername;
  }
  
  public String getEmPassword()
  {
    return this.emPassword;
  }
  
  public String getEmUsername()
  {
    return this.emUsername;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public long getFirstTogetherTs()
  {
    return this.firstTogetherTs;
  }
  
  public String getIp()
  {
    return this.ip;
  }
  
  public long getLovedTime()
  {
    return this.lovedTime;
  }
  
  public String getLoverAppChannel()
  {
    return this.loverAppChannel;
  }
  
  public String getLoverAppVer()
  {
    return this.loverAppVer;
  }
  
  public String getLoverAvatar()
  {
    return this.loverAvatar + "?imageView/1/w/" + ab.a(150.0F) + "/h/" + ab.a(150.0F);
  }
  
  public int getLoverCoins()
  {
    return this.loverCoins;
  }
  
  public String getLoverDeviceJb()
  {
    return this.loverDeviceJb;
  }
  
  public String getLoverDeviceOs()
  {
    return this.loverDeviceOs;
  }
  
  public String getLoverDeviceVer()
  {
    return this.loverDeviceVer;
  }
  
  public int getLoverDiamonds()
  {
    return this.loverDiamonds;
  }
  
  public String getLoverEmail()
  {
    return this.loverEmail;
  }
  
  public int getLoverId()
  {
    return this.loverId;
  }
  
  public String getLoverIp()
  {
    return this.loverIp;
  }
  
  public String getLoverNickName()
  {
    return this.loverNickname;
  }
  
  public int getLoverOnlineTime()
  {
    return this.loverOnlineTime;
  }
  
  public String getLoverPhoneNum()
  {
    return this.loverPhoneNum;
  }
  
  public long getLoverRegistTs()
  {
    return this.loverRegistTs;
  }
  
  public String getLoverUserName()
  {
    return this.loverUserName;
  }
  
  public String getLover_qq_nickname()
  {
    return this.loverQQNickname;
  }
  
  public String getLover_sina_nickname()
  {
    return this.loverSinaNickname;
  }
  
  public String getLover_wx_nickname()
  {
    return this.loverWXNickname;
  }
  
  public String getNickName()
  {
    return this.nickname;
  }
  
  public int getOnlineTime()
  {
    return this.onlineTime;
  }
  
  public String getOriginAvatar()
  {
    return this.avatar;
  }
  
  public String getOriginLoverAvatar()
  {
    return this.loverAvatar;
  }
  
  public String getPhoneNum()
  {
    return this.phoneNum;
  }
  
  public String getQq_nickname()
  {
    return this.qqNickname;
  }
  
  public long getRegistTs()
  {
    return this.registTs;
  }
  
  public String getSina_nickname()
  {
    return this.sinaNickname;
  }
  
  public int getUserId()
  {
    return this.userId;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public long getVipExpireTime()
  {
    return this.vipExpireTime;
  }
  
  public String getWx_nickname()
  {
    return this.wxNickname;
  }
  
  public boolean isCoupleVip()
  {
    return getVipExpireTime() > ak.b();
  }
  
  public void save()
  {
    try
    {
      f.b(createJson(), f.a(Xiaoenai.j(), AppModel.getInstance().getUserId(), "user.dat"));
      Xiaoenai.j().z().g().f();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.xiaoenai.app.utils.f.a.c("save user info failed!", new Object[0]);
        localException.printStackTrace();
      }
    }
  }
  
  public void setAvatar(String paramString)
  {
    this.avatar = paramString;
  }
  
  public void setCoin(int paramInt)
  {
    this.coin = paramInt;
  }
  
  public void setCouplePhotoUrl(String paramString)
  {
    this.couplePhotoUrl = paramString;
  }
  
  public void setDiamonds(int paramInt)
  {
    this.diamonds = paramInt;
  }
  
  public void setEmLoverUsername(String paramString)
  {
    this.emLoverUsername = paramString;
  }
  
  public void setEmPassword(String paramString)
  {
    this.emPassword = paramString;
  }
  
  public void setEmUsername(String paramString)
  {
    this.emUsername = paramString;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setFirstTogetherTs(long paramLong)
  {
    this.firstTogetherTs = paramLong;
  }
  
  public void setIp(String paramString)
  {
    this.ip = paramString;
  }
  
  public void setLovedTime(long paramLong)
  {
    this.lovedTime = paramLong;
  }
  
  public void setLoverAppChannel(String paramString)
  {
    this.loverAppChannel = paramString;
  }
  
  public void setLoverAppVer(String paramString)
  {
    this.loverAppVer = paramString;
  }
  
  public void setLoverAvatar(String paramString)
  {
    this.loverAvatar = paramString;
  }
  
  public void setLoverCoins(int paramInt)
  {
    this.loverCoins = paramInt;
  }
  
  public void setLoverDeviceJb(String paramString)
  {
    this.loverDeviceJb = paramString;
  }
  
  public void setLoverDeviceOs(String paramString)
  {
    this.loverDeviceOs = paramString;
  }
  
  public void setLoverDeviceVer(String paramString)
  {
    this.loverDeviceVer = paramString;
  }
  
  public void setLoverDiamonds(int paramInt)
  {
    this.loverDiamonds = paramInt;
  }
  
  public void setLoverEmail(String paramString)
  {
    this.loverEmail = paramString;
  }
  
  public void setLoverId(int paramInt)
  {
    this.loverId = paramInt;
  }
  
  public void setLoverIp(String paramString)
  {
    this.loverIp = paramString;
  }
  
  public void setLoverNickName(String paramString)
  {
    this.loverNickname = paramString;
  }
  
  public void setLoverOnlineTime(int paramInt)
  {
    this.loverOnlineTime = paramInt;
  }
  
  public void setLoverPhoneNum(String paramString)
  {
    this.loverPhoneNum = paramString;
  }
  
  public void setLoverRegistTs(long paramLong)
  {
    this.loverRegistTs = paramLong;
  }
  
  public void setLoverUserName(String paramString)
  {
    this.loverUserName = paramString;
  }
  
  public void setLover_qq_nickname(String paramString)
  {
    this.loverQQNickname = paramString;
  }
  
  public void setLover_sina_nickname(String paramString)
  {
    this.loverSinaNickname = paramString;
  }
  
  public void setLover_wx_nickname(String paramString)
  {
    this.loverWXNickname = paramString;
  }
  
  public void setNickName(String paramString)
  {
    this.nickname = paramString;
  }
  
  public void setOnlineTime(int paramInt)
  {
    this.onlineTime = paramInt;
  }
  
  public void setPhoneNum(String paramString)
  {
    this.phoneNum = paramString;
    if ((paramString != null) && (paramString.equalsIgnoreCase("null"))) {
      this.phoneNum = null;
    }
  }
  
  public void setQq_nickname(String paramString)
  {
    this.qqNickname = paramString;
  }
  
  public void setRegistTs(long paramLong)
  {
    this.registTs = paramLong;
  }
  
  public void setSina_nickname(String paramString)
  {
    this.sinaNickname = paramString;
  }
  
  public void setUserId(int paramInt)
  {
    this.userId = paramInt;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public void setVipExpireTime(long paramLong)
  {
    this.vipExpireTime = paramLong;
  }
  
  public void setWx_nickname(String paramString)
  {
    this.wxNickname = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\User.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */