package com.alibaba.mtl.log.model;

public enum LogField
{
  static
  {
    BRAND = new LogField("BRAND", 2);
    DEVICE_MODEL = new LogField("DEVICE_MODEL", 3);
    RESOLUTION = new LogField("RESOLUTION", 4);
    CARRIER = new LogField("CARRIER", 5);
    ACCESS = new LogField("ACCESS", 6);
    ACCESS_SUBTYPE = new LogField("ACCESS_SUBTYPE", 7);
    CHANNEL = new LogField("CHANNEL", 8);
    APPKEY = new LogField("APPKEY", 9);
    APPVERSION = new LogField("APPVERSION", 10);
    LL_USERNICK = new LogField("LL_USERNICK", 11);
    USERNICK = new LogField("USERNICK", 12);
    LL_USERID = new LogField("LL_USERID", 13);
    USERID = new LogField("USERID", 14);
    LANGUAGE = new LogField("LANGUAGE", 15);
    OS = new LogField("OS", 16);
    OSVERSION = new LogField("OSVERSION", 17);
    SDKVERSION = new LogField("SDKVERSION", 18);
    START_SESSION_TIMESTAMP = new LogField("START_SESSION_TIMESTAMP", 19);
    UTDID = new LogField("UTDID", 20);
    SDKTYPE = new LogField("SDKTYPE", 21);
    RESERVE2 = new LogField("RESERVE2", 22);
    RESERVE3 = new LogField("RESERVE3", 23);
    RESERVE4 = new LogField("RESERVE4", 24);
    RESERVE5 = new LogField("RESERVE5", 25);
    RESERVES = new LogField("RESERVES", 26);
    RECORD_TIMESTAMP = new LogField("RECORD_TIMESTAMP", 27);
    PAGE = new LogField("PAGE", 28);
    EVENTID = new LogField("EVENTID", 29);
  }
  
  private LogField() {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\model\LogField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */