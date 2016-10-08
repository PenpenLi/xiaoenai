package org.mzd.game;

public class GameJni
{
  public static final native void adjustTs(long paramLong);
  
  public static final native void exitGame();
  
  public static final native void launchGame(String paramString);
  
  public static final native void onNotification(String paramString);
  
  public static final native void payFinish(String paramString1, String paramString2);
  
  public static final native void setServerAddress(String paramString);
  
  public static final native void setUserData(String paramString1, String paramString2, long paramLong, GameCallback paramGameCallback);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\mzd\game\GameJni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */