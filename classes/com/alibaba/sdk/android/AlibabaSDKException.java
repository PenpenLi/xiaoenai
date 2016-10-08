package com.alibaba.sdk.android;

import com.alibaba.sdk.android.message.Message;

public class AlibabaSDKException
  extends RuntimeException
{
  private static final long serialVersionUID = 1357689949294215654L;
  private Message message;
  
  public AlibabaSDKException(Message paramMessage) {}
  
  public AlibabaSDKException(Message paramMessage, Throwable paramThrowable) {}
  
  public Message getSDKMessage()
  {
    return this.message;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\AlibabaSDKException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */