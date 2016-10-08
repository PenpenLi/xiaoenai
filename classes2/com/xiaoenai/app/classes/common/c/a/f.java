package com.xiaoenai.app.classes.common.c.a;

import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class f
  extends DefaultHandler
{
  private HashMap<String, b> a;
  private b b;
  private a c;
  
  public HashMap<String, b> a()
  {
    return this.a;
  }
  
  public void endDocument()
  {
    this.b = null;
    this.c = null;
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    if ("icon".equals(paramString2))
    {
      this.b.a(this.c);
      this.c = null;
    }
    while (!"module_id".equals(paramString2)) {
      return;
    }
    this.a.put(this.b.a(), this.b);
    this.b = null;
  }
  
  public void startDocument()
  {
    this.a = new HashMap();
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if ("module_id".equals(paramString2))
    {
      this.b = new b();
      this.b.a(paramAttributes.getValue(0));
    }
    do
    {
      return;
      if ("tips".equals(paramString2))
      {
        this.b.b(paramAttributes.getValue(0));
        return;
      }
      if ("activity".equals(paramString2))
      {
        this.b.c(paramAttributes.getValue(0));
        return;
      }
      if ("action".equals(paramString2))
      {
        this.b.d(paramAttributes.getValue(0));
        return;
      }
      if ("icon".equals(paramString2))
      {
        this.c = new a();
        return;
      }
      if ("type".equals(paramString2))
      {
        this.c.a(paramAttributes.getValue(0));
        return;
      }
    } while (!"uri".equals(paramString2));
    this.c.b(paramAttributes.getValue(0));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\c\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */