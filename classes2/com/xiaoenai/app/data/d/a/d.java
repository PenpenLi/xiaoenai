package com.xiaoenai.app.data.d.a;

import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class d
  extends DefaultHandler
{
  private HashMap<String, a> a;
  private a b;
  
  public HashMap<String, a> a()
  {
    return this.a;
  }
  
  public void endDocument()
  {
    this.b = null;
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    if ("addressName".equals(paramString2))
    {
      this.a.put(this.b.a(), this.b);
      this.b = null;
    }
  }
  
  public void startDocument()
  {
    this.a = new HashMap();
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if ("addressName".equals(paramString2))
    {
      this.b = new a();
      this.b.a(paramAttributes.getValue(0));
    }
    do
    {
      return;
      if ("production".equals(paramString2))
      {
        this.b.b(paramAttributes.getValue(1));
        return;
      }
      if ("production_https".equals(paramString2))
      {
        this.b.g(paramAttributes.getValue(1));
        return;
      }
      if ("develop_test_qas".equals(paramString2))
      {
        this.b.c(paramAttributes.getValue(1));
        return;
      }
      if ("develop_test_qas_https".equals(paramString2))
      {
        this.b.f(paramAttributes.getValue(1));
        return;
      }
      if ("develop_test".equals(paramString2))
      {
        this.b.d(paramAttributes.getValue(1));
        return;
      }
    } while (!"develop".equals(paramString2));
    this.b.e(paramAttributes.getValue(1));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */