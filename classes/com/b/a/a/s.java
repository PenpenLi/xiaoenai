package com.b.a.a;

import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public abstract interface s
{
  public abstract boolean getUsePoolThread();
  
  public abstract boolean getUseSynchronousMode();
  
  public abstract void onPostProcessResponse(s params, HttpResponse paramHttpResponse);
  
  public abstract void onPreProcessResponse(s params, HttpResponse paramHttpResponse);
  
  public abstract void sendCancelMessage();
  
  public abstract void sendFailureMessage(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable);
  
  public abstract void sendFinishMessage();
  
  public abstract void sendResponseMessage(HttpResponse paramHttpResponse);
  
  public abstract void sendRetryMessage(int paramInt);
  
  public abstract void sendStartMessage();
  
  public abstract void setRequestHeaders(Header[] paramArrayOfHeader);
  
  public abstract void setRequestURI(URI paramURI);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\b\a\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */