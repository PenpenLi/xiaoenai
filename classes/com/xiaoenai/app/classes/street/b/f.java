package com.xiaoenai.app.classes.street.b;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.street.model.ProductInfo;
import com.xiaoenai.app.classes.street.model.ProductSubscribe;
import com.xiaoenai.app.utils.a.a;
import com.xiaoenai.app.utils.ak;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class f
{
  private static f a = null;
  private a b = null;
  private HashMap<String, ProductSubscribe> c = null;
  
  private f()
  {
    this.b.a(ak.b());
  }
  
  public static f a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        a = new f();
        a.b();
      }
      return a;
    }
    finally {}
  }
  
  private void b()
  {
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (ProductSubscribe)((Map.Entry)localObject2).getValue();
      com.xiaoenai.app.utils.f.a.c("id = {} val = {}", new Object[] { localObject1, Boolean.valueOf(((ProductSubscribe)localObject2).isSubscribeStatus()) });
      if (((ProductSubscribe)localObject2).isSubscribeStatus())
      {
        long l = ((ProductSubscribe)localObject2).getSellingTime() - ((ProductSubscribe)localObject2).getOrderNotiTs();
        if ((!((ProductSubscribe)localObject2).isRemind()) && (l - ak.b() > 0L))
        {
          com.xiaoenai.app.utils.f.a.c("initAlarm noti_ts = {} id = {} data = {}", new Object[] { Long.valueOf(((ProductSubscribe)localObject2).getOrderNotiTs()), Integer.valueOf(((ProductSubscribe)localObject2).getId()), ak.j(l) });
          localObject1 = new a.a();
          ((a.a)localObject1).a(((ProductSubscribe)localObject2).getId());
          ((a.a)localObject1).b(((ProductSubscribe)localObject2).getRushId());
          ((a.a)localObject1).a("from_street_detail");
          com.xiaoenai.app.utils.a.a(Xiaoenai.j(), ((ProductSubscribe)localObject2).getId(), (a.a)localObject1, l);
        }
        else if (((ProductSubscribe)localObject2).getCloseTime() - ak.b() < 0L)
        {
          com.xiaoenai.app.utils.a.b(Xiaoenai.j(), ((ProductSubscribe)localObject2).getId());
          this.b.b(((ProductSubscribe)localObject2).getProductId(), ((ProductSubscribe)localObject2).getRushId());
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b.c(paramInt1, paramInt2);
  }
  
  public void a(ProductInfo paramProductInfo, boolean paramBoolean)
  {
    try
    {
      ProductSubscribe localProductSubscribe2 = (ProductSubscribe)this.c.get(String.valueOf(paramProductInfo.getId()) + String.valueOf(paramProductInfo.getRushId()));
      ProductSubscribe localProductSubscribe1 = localProductSubscribe2;
      if (localProductSubscribe2 == null)
      {
        localProductSubscribe1 = new ProductSubscribe();
        this.c.put(String.valueOf(paramProductInfo.getId()) + String.valueOf(paramProductInfo.getRushId()), localProductSubscribe1);
      }
      localProductSubscribe1.setProductId(paramProductInfo.getId());
      localProductSubscribe1.setRushId(paramProductInfo.getRushId());
      localProductSubscribe1.setSellingTime(paramProductInfo.getSellingTime());
      localProductSubscribe1.setCloseTime(paramProductInfo.getCloseTime());
      localProductSubscribe1.setOrderNotiTs(paramProductInfo.getOrderNotiTs());
      localProductSubscribe1.setOrderNotiDesc(paramProductInfo.getOrderNotiDesc());
      localProductSubscribe1.setSubscribeStatus(paramBoolean);
      this.b.a(localProductSubscribe1);
      return;
    }
    finally {}
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    ProductSubscribe localProductSubscribe = (ProductSubscribe)this.c.get(String.valueOf(paramInt1) + String.valueOf(paramInt2));
    if (localProductSubscribe != null) {
      return localProductSubscribe.isSubscribeStatus();
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */