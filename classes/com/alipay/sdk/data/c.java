package com.alipay.sdk.data;

import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public final class c
{
  public static final String a = "application/octet-stream;binary/octet-stream";
  public Header[] b = null;
  public String c = null;
  public String d = null;
  
  private void a(String paramString)
  {
    this.c = paramString;
  }
  
  private void a(Header[] paramArrayOfHeader)
  {
    this.b = paramArrayOfHeader;
  }
  
  private void b(String paramString)
  {
    this.d = paramString;
  }
  
  private Header[] b()
  {
    return this.b;
  }
  
  private String c()
  {
    return this.c;
  }
  
  private String d()
  {
    return this.d;
  }
  
  private void e()
  {
    this.d = null;
    this.c = null;
  }
  
  public final ArrayList<BasicHeader> a()
  {
    Object localObject;
    if ((this.b == null) || (this.b.length == 0))
    {
      localObject = null;
      return (ArrayList<BasicHeader>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    Header[] arrayOfHeader = this.b;
    int j = arrayOfHeader.length;
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= j) {
        break;
      }
      localObject = arrayOfHeader[i];
      localArrayList.add(new BasicHeader(((Header)localObject).getName(), ((Header)localObject).getValue()));
      i += 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\data\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */