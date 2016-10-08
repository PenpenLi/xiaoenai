package com.xiaoenai.app.classes.street.d;

import android.content.Context;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.street.ea;
import com.xiaoenai.app.classes.street.model.ImageInfo;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.model.Product;
import com.xiaoenai.app.classes.street.model.Sku;
import com.xiaoenai.app.classes.street.widget.StreetProductInfoLayout;
import com.xiaoenai.app.classes.street.widget.StreetProductInfoLayout.a;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.utils.f.a;

public class ay
{
  private StreetProductInfoLayout a;
  private StreetProductInfoLayout.a b;
  private Order c;
  
  public ay(StreetProductInfoLayout paramStreetProductInfoLayout, Order paramOrder)
  {
    this.a = paramStreetProductInfoLayout;
    this.b = paramStreetProductInfoLayout.getViewHolder();
    this.c = paramOrder;
  }
  
  private void b()
  {
    az localaz = new az(this);
    this.b.h.setOnClickListener(localaz);
    this.b.i.setOnClickListener(localaz);
  }
  
  public void a()
  {
    Object localObject;
    if (this.c != null)
    {
      localObject = this.c.getProduct();
      if (localObject != null)
      {
        localObject = ((Product)localObject).getImageUrl();
        a.c("imageinfo {} {}", new Object[] { localObject, ((ImageInfo)localObject).getUrl() });
        if ((this.c.getProduct().getImageUrl() != null) && (localObject != null)) {
          b.a(this.b.a, ((ImageInfo)localObject).getUrl());
        }
      }
      localObject = this.b.b.getContext();
      if ((this.c.getProduct() != null) && (this.c.getProduct().getTitle() != null))
      {
        if (!this.c.getProduct().getIsRush().booleanValue()) {
          break label428;
        }
        this.b.b.setText(ea.a((Context)localObject, this.c.getProduct().getTitle()));
      }
      if (this.c.getSku() != null) {
        if ((!this.c.getProduct().getIsRush().booleanValue()) && (this.c.getSku().getRushId() <= 0)) {
          break label455;
        }
      }
    }
    label428:
    label455:
    for (int i = this.c.getSku().getRushPrice();; i = this.c.getSku().getPrice())
    {
      localObject = "￥ " + String.format("%.2f", new Object[] { Double.valueOf(i / 100.0D) });
      this.b.c.setText((CharSequence)localObject);
      localObject = this.c.getSku().getKey().replace(';', ' ');
      this.b.e.setText((CharSequence)localObject);
      if ((this.c.getMemo() != null) && (!this.c.getMemo().equals(""))) {
        this.b.f.setText(this.b.f.getContext().getString(2131100806) + "：" + this.c.getMemo());
      }
      this.b.d.setText("x" + String.valueOf(this.c.getCount()));
      a(this.c.isShowCheckBtn());
      this.b.i.setSelected(this.c.isChecked());
      b();
      return;
      this.b.b.setText(ea.c((Context)localObject, this.c.getProduct().getTitle()));
      break;
    }
  }
  
  public void a(Order paramOrder)
  {
    this.c = paramOrder;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      i = ab.a(40.0F);
      this.b.h.getLayoutParams().width = i;
      this.b.i.setVisibility(0);
      return;
    }
    int i = ab.a(11.0F);
    this.b.h.getLayoutParams().width = i;
    this.b.i.setVisibility(8);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\d\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */