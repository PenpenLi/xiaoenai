package com.b.a.a;

import android.os.Looper;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

public abstract class g
  extends f
{
  private static final String LOG_TAG = "BinaryHttpRH";
  private String[] mAllowedContentTypes = { "application/octet-stream", "image/jpeg", "image/png", "image/gif" };
  
  public g() {}
  
  public g(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      this.mAllowedContentTypes = paramArrayOfString;
      return;
    }
    a.a.d("BinaryHttpRH", "Constructor passed allowedContentTypes was null !");
  }
  
  public g(String[] paramArrayOfString, Looper paramLooper)
  {
    super(paramLooper);
    if (paramArrayOfString != null)
    {
      this.mAllowedContentTypes = paramArrayOfString;
      return;
    }
    a.a.d("BinaryHttpRH", "Constructor passed allowedContentTypes was null !");
  }
  
  public String[] getAllowedContentTypes()
  {
    return this.mAllowedContentTypes;
  }
  
  public abstract void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable);
  
  public abstract void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte);
  
  public final void sendResponseMessage(HttpResponse paramHttpResponse)
  {
    int j = 0;
    StatusLine localStatusLine = paramHttpResponse.getStatusLine();
    Object localObject = paramHttpResponse.getHeaders("Content-Type");
    if (localObject.length != 1)
    {
      sendFailureMessage(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), null, new HttpResponseException(localStatusLine.getStatusCode(), "None, or more than one, Content-Type Header found!"));
      return;
    }
    localObject = localObject[0];
    String[] arrayOfString = getAllowedContentTypes();
    int k = arrayOfString.length;
    int i = 0;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      try
      {
        boolean bool = Pattern.matches(str, ((Header)localObject).getValue());
        if (bool) {
          j = 1;
        }
      }
      catch (PatternSyntaxException localPatternSyntaxException)
      {
        for (;;)
        {
          a.a.b("BinaryHttpRH", "Given pattern is not valid: " + str, localPatternSyntaxException);
        }
      }
      i += 1;
    }
    if (j == 0)
    {
      sendFailureMessage(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), null, new HttpResponseException(localStatusLine.getStatusCode(), "Content-Type (" + ((Header)localObject).getValue() + ") not allowed!"));
      return;
    }
    super.sendResponseMessage(paramHttpResponse);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\b\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */