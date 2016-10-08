package com.xiaoenai.app.classes.gameCenter;

import com.xiaoenai.app.classes.gameCenter.model.GameEntry;
import com.xiaoenai.app.d.k;
import java.util.List;

public class b
{
  private static b a;
  private k b = new k();
  
  public static b a()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  public void a(GameEntry paramGameEntry)
  {
    this.b.a(paramGameEntry);
  }
  
  public List<GameEntry> b()
  {
    return this.b.a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */