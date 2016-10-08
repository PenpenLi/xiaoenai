package com.alipay.sdk.protocol;

public enum f
{
  private String e;
  
  private f(String paramString)
  {
    this.e = paramString;
  }
  
  public static f a(String paramString)
  {
    Object localObject = null;
    f[] arrayOff = values();
    int j = arrayOff.length;
    int i = 0;
    if (i < j)
    {
      f localf = arrayOff[i];
      if (!paramString.startsWith(localf.e)) {
        break label49;
      }
      localObject = localf;
    }
    label49:
    for (;;)
    {
      i += 1;
      break;
      return (f)localObject;
    }
  }
  
  private String a()
  {
    return this.e;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\protocol\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */