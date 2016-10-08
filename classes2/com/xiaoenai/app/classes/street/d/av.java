package com.xiaoenai.app.classes.street.d;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.xiaoenai.app.classes.street.StreetProductDetailActivity.b;
import com.xiaoenai.app.classes.street.StreetProductOrderActivity;
import com.xiaoenai.app.classes.street.model.BuyProduct;
import com.xiaoenai.app.classes.street.model.BuyProducts;
import com.xiaoenai.app.classes.street.model.ProductInfo;
import com.xiaoenai.app.classes.street.model.Sku;
import com.xiaoenai.app.classes.street.widget.am;
import com.xiaoenai.app.classes.street.widget.am.a;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

class av
  implements am.a
{
  av(aq paramaq) {}
  
  public void a(ProductInfo paramProductInfo, Sku paramSku, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    if (paramSku.getQuantity() == 0)
    {
      h.c(aq.a(this.a), 2131101469, 1500L);
      return;
    }
    paramProductInfo = new BuyProduct();
    paramProductInfo.setSkuId(paramSku.getId());
    paramProductInfo.setCount(paramInt);
    paramProductInfo.setTitle(aq.c(this.a).getTitle());
    if ((aq.c(this.a).getImageUrl() != null) && (aq.c(this.a).getImageUrl().length > 0)) {
      paramProductInfo.setImage(aq.c(this.a).getImageUrl()[0]);
    }
    if (aq.c(this.a).getIsRush().booleanValue())
    {
      paramProductInfo.setPrice(paramSku.getRushPrice());
      paramProductInfo.setRushId(paramSku.getRushId());
    }
    for (;;)
    {
      paramProductInfo.setProductId(paramSku.getProductId());
      paramProductInfo.setSkuDesc(aq.e(this.a).c.a());
      paramSku = new BuyProducts();
      paramSku.setBuyProduct(paramProductInfo);
      a.c("buyProducts.toJson() = {}", new Object[] { paramSku.toJson() });
      paramProductInfo = new Intent();
      paramProductInfo.setClass(aq.a(this.a), StreetProductOrderActivity.class);
      paramProductInfo.putExtra("buy_info", paramSku.toJson().toString());
      aq.a(this.a).startActivity(paramProductInfo);
      ((FragmentActivity)aq.a(this.a)).overridePendingTransition(2130968604, 2130968605);
      return;
      paramProductInfo.setPrice(paramSku.getPrice());
      paramProductInfo.setRushId(0);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */