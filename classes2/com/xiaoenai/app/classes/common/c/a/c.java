package com.xiaoenai.app.classes.common.c.a;

import android.content.res.Resources;
import com.xiaoenai.app.Xiaoenai;
import java.io.InputStream;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class c
{
  private static HashMap<String, b> a;
  private static c b;
  
  public static c a()
  {
    if (b == null) {}
    try
    {
      if (b == null)
      {
        b = new c();
        b.b();
      }
      return b;
    }
    finally {}
  }
  
  private void b()
  {
    try
    {
      InputStream localInputStream = Xiaoenai.j().getResources().openRawResource(2131034116);
      SAXParser localSAXParser = SAXParserFactory.newInstance().newSAXParser();
      f localf = new f();
      localSAXParser.parse(localInputStream, localf);
      localInputStream.close();
      a = localf.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public b a(String paramString)
  {
    b localb = null;
    if (a != null) {
      localb = (b)a.get(paramString);
    }
    return localb;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\c\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */