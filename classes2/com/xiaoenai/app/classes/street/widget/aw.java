package com.xiaoenai.app.classes.street.widget;

import com.xiaoenai.app.utils.f.a;

class aw
  implements StreetProductSkuView.a
{
  aw(StreetProductSkuView paramStreetProductSkuView) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    a.c("isPress = {} name = {} value = {} ", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 });
    if (StreetProductSkuView.a(this.a, paramString2)) {
      if (StreetProductSkuView.a(this.a) != null) {
        StreetProductSkuView.a(this.a).a(paramBoolean, paramString1, paramString2);
      }
    }
    while (StreetProductSkuView.a(this.a) == null) {
      return;
    }
    StreetProductSkuView.a(this.a).a(paramBoolean, paramString1, paramString2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */