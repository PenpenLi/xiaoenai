package com.xiaoenai.app.classes.street.d;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.street.StreetProductDetailActivity;
import com.xiaoenai.app.classes.street.StreetProductDetailActivity.b;
import com.xiaoenai.app.classes.street.b.f;
import com.xiaoenai.app.classes.street.model.ProductInfo;
import com.xiaoenai.app.classes.street.widget.StreetPayBottomView.a;
import com.xiaoenai.app.classes.street.widget.am;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.a.a;
import com.xiaoenai.app.utils.ak;

class au
  implements StreetPayBottomView.a
{
  au(aq paramaq) {}
  
  public void a(ProductInfo paramProductInfo)
  {
    com.xiaoenai.app.utils.f.a.c("onAddCartBtnClick", new Object[0]);
    aq.e(this.a).c.a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    com.xiaoenai.app.utils.f.a.c("productid = {} fav = {}", new Object[] { Integer.valueOf(aq.c(this.a).getId()), aq.c(this.a).getFavor() });
    aq.d(this.a);
    if (paramBoolean)
    {
      h.a(aq.a(this.a), 2131101375, 1500L);
      return;
    }
    h.a(aq.a(this.a), 2131101376, 1500L);
  }
  
  public void b(ProductInfo paramProductInfo)
  {
    com.xiaoenai.app.utils.f.a.c("onAddCartBtnClick", new Object[0]);
    aq.e(this.a).c.a(false);
  }
  
  public void c(ProductInfo paramProductInfo)
  {
    boolean bool;
    if (paramProductInfo.getStatus() == 0) {
      if (!f.a().b(paramProductInfo.getId(), paramProductInfo.getRushId()))
      {
        bool = true;
        aq.a(this.a, bool);
        f.a().a(paramProductInfo, bool);
        if (!bool) {
          break label221;
        }
        if ((paramProductInfo.getOrderNotiDesc() == null) || (paramProductInfo.getOrderNotiDesc().length() <= 0)) {
          break label202;
        }
        h.b(aq.a(this.a), paramProductInfo.getOrderNotiDesc(), 2000L);
        label85:
        a.a locala = new a.a();
        locala.a(paramProductInfo.getId());
        locala.b(paramProductInfo.getRushId());
        locala.a("from_street_detail");
        long l = paramProductInfo.getSellingTime() - paramProductInfo.getOrderNotiTs();
        com.xiaoenai.app.utils.f.a.c("setStreetAlarm getOrderNotiTs = {} id = {} noti_ts = {}", new Object[] { Long.valueOf(paramProductInfo.getOrderNotiTs()), Integer.valueOf(paramProductInfo.getId()), ak.j(l) });
        if (l > ak.b()) {
          com.xiaoenai.app.utils.a.a(Xiaoenai.j(), paramProductInfo.getId(), locala, l);
        }
      }
    }
    for (;;)
    {
      ((StreetProductDetailActivity)aq.a(this.a)).a(-1);
      return;
      bool = false;
      break;
      label202:
      h.b(aq.a(this.a), 2131101471, 2000L);
      break label85;
      label221:
      h.b(aq.a(this.a), 2131101445, 1500L);
      com.xiaoenai.app.utils.a.b(Xiaoenai.j(), paramProductInfo.getId());
      continue;
      if (1 == paramProductInfo.getStatus()) {
        ((StreetProductDetailActivity)aq.a(this.a)).a(true);
      }
    }
  }
  
  public void d(ProductInfo paramProductInfo)
  {
    aq.a(this.a, paramProductInfo);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */