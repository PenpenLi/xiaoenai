package com.alibaba.sdk.android.message;

public class Message
  implements Cloneable
{
  public String action;
  public int code;
  public String message;
  public String type;
  
  public static Message create(int paramInt, Object... paramVarArgs)
  {
    return MessageUtils.createMessage(paramInt, paramVarArgs);
  }
  
  public Object clone()
  {
    return super.clone();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\message\Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */