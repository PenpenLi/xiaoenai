package com.xiaoenai.app.data.entity;

import com.google.gson.annotations.SerializedName;

public class UserEntity
{
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
  @SerializedName(a="lover_device_jb")
  private String loverDeviceJb;
  @SerializedName(a="lover_device_os")
  private String loverDeviceOs;
  @SerializedName(a="lover_device_ver")
  private String loverDeviceVer;
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
  @SerializedName(a="wx_nickname")
  private String wxNickname;
  
  public String getAvatar()
  {
    return this.avatar;
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
    return this.loverAvatar;
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
  
  public String getLoverNickname()
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
  
  public String getLoverQQNickname()
  {
    return this.loverQQNickname;
  }
  
  public long getLoverRegistTs()
  {
    return this.loverRegistTs;
  }
  
  public String getLoverSinaNickname()
  {
    return this.loverSinaNickname;
  }
  
  public String getLoverUserName()
  {
    return this.loverUserName;
  }
  
  public String getLoverWXNickname()
  {
    return this.loverWXNickname;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public int getOnlineTime()
  {
    return this.onlineTime;
  }
  
  public String getPhoneNum()
  {
    return this.phoneNum;
  }
  
  public String getQQNickname()
  {
    return this.qqNickname;
  }
  
  public long getRegistTs()
  {
    return this.registTs;
  }
  
  public String getSinaNickname()
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
  
  public String getWXNickname()
  {
    return this.wxNickname;
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
  
  public void setLoverNickname(String paramString)
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
  
  public void setLoverQQNickname(String paramString)
  {
    this.loverQQNickname = paramString;
  }
  
  public void setLoverRegistTs(long paramLong)
  {
    this.loverRegistTs = paramLong;
  }
  
  public void setLoverSinaNickname(String paramString)
  {
    this.loverSinaNickname = paramString;
  }
  
  public void setLoverUserName(String paramString)
  {
    this.loverUserName = paramString;
  }
  
  public void setLoverWXNickname(String paramString)
  {
    this.loverWXNickname = paramString;
  }
  
  public void setNickname(String paramString)
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
  }
  
  public void setQQNickname(String paramString)
  {
    this.qqNickname = paramString;
  }
  
  public void setRegistTs(long paramLong)
  {
    this.registTs = paramLong;
  }
  
  public void setSinaNickname(String paramString)
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
  
  public void setWXNickname(String paramString)
  {
    this.wxNickname = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\entity\UserEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */