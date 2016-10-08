package com.xiaoenai.app.classes.street.widget.AddressPicker;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class d
  extends DefaultHandler
{
  c a = new c();
  a b = new a();
  b c = new b();
  private List<c> d = new ArrayList();
  
  public List<c> a()
  {
    return this.d;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2) {}
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    if (paramString3.equals("district")) {
      this.b.b().add(this.c);
    }
    do
    {
      return;
      if (paramString3.equals("city"))
      {
        this.a.b().add(this.b);
        return;
      }
    } while (!paramString3.equals("province"));
    this.d.add(this.a);
  }
  
  public void startDocument() {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if (paramString3.equals("province"))
    {
      this.a = new c();
      this.a.a(paramAttributes.getValue(0));
      this.a.a(new ArrayList());
    }
    do
    {
      return;
      if (paramString3.equals("city"))
      {
        this.b = new a();
        this.b.a(paramAttributes.getValue(0));
        this.b.a(new ArrayList());
        return;
      }
    } while (!paramString3.equals("district"));
    this.c = new b();
    this.c.a(paramAttributes.getValue(0));
    this.c.b(paramAttributes.getValue(1));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\AddressPicker\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */