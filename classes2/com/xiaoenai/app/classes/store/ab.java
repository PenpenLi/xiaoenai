package com.xiaoenai.app.classes.store;

import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import com.xiaoenai.app.d.ar;
import java.util.Vector;

public class ab
{
  private static ab a;
  private ar b = new ar();
  
  public static ab a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ab();
      }
      return a;
    }
    finally {}
  }
  
  public static void b()
  {
    a = null;
  }
  
  public Vector<BaseSticker> a(int paramInt)
  {
    return this.b.b(paramInt);
  }
  
  public void a(BaseSticker paramBaseSticker)
  {
    this.b.a(paramBaseSticker);
  }
  
  public void c()
  {
    this.b.a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\store\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */