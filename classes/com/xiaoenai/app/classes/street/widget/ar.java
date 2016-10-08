package com.xiaoenai.app.classes.street.widget;

import android.content.Context;
import android.widget.TextView;
import com.xiaoenai.app.classes.street.model.ProductInfo;
import com.xiaoenai.app.classes.street.model.Sku;
import com.xiaoenai.app.utils.f.a;
import java.util.HashMap;
import java.util.Locale;

class ar
  implements StreetProductSkuView.a
{
  ar(am paramam) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    a.c("isPress = {} name = {} value = {}", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 });
    am.a(this.a, am.i(this.a));
    am.j(this.a).setText(am.f(this.a));
    if (paramBoolean)
    {
      String str1 = this.a.b();
      a.c("key = {}", new Object[] { str1 });
      if (str1.length() > 0)
      {
        am.a(this.a, (Sku)am.g(this.a).getSkuHashMap().get(str1));
        a.c("mSelectSku = {}", new Object[] { am.d(this.a) });
        if (am.d(this.a) != null)
        {
          a.c("mSelectSku key = {}", new Object[] { am.d(this.a).getKey() });
          a.c("mSelectSku rushprice = {}", new Object[] { Integer.valueOf(am.d(this.a).getRushPrice()) });
          a.c("mSelectSku price = {}", new Object[] { Integer.valueOf(am.d(this.a).getPrice()) });
          a.c("mSelectSku quantity = {}", new Object[] { Integer.valueOf(am.d(this.a).getQuantity()) });
          a.c("mSelectSku desc = {}", new Object[] { am.d(this.a).getQuantityDesc() });
          if (am.d(this.a).getRushId() <= 0) {
            break label449;
          }
        }
        label449:
        for (str1 = am.e(this.a).getString(2131101450) + String.format(Locale.getDefault(), "%.2f", new Object[] { Double.valueOf(am.d(this.a).getRushPrice() / 100.0D) });; str1 = am.e(this.a).getString(2131101450) + String.format(Locale.getDefault(), "%.2f", new Object[] { Double.valueOf(am.d(this.a).getPrice() / 100.0D) }))
        {
          String str2 = am.d(this.a).getQuantityDesc();
          am.k(this.a).setText(str1);
          am.l(this.a).setText(str2);
          if (am.a(this.a) > am.d(this.a).getQuantity())
          {
            am.a(this.a, am.d(this.a).getQuantity());
            am.c(this.a).setText(String.valueOf(am.a(this.a)));
          }
          am.a(this.a, Boolean.valueOf(paramBoolean), paramString1, paramString2);
          return;
        }
      }
      am.a(this.a, null);
      am.a(this.a, Boolean.valueOf(paramBoolean), paramString1, paramString2);
      am.m(this.a);
      return;
    }
    am.a(this.a, null);
    am.a(this.a, Boolean.valueOf(paramBoolean), paramString1, paramString2);
    am.m(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */