package com.xiaoenai.app.classes.street.d;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.street.StreetOrderDetailActivity.a;
import com.xiaoenai.app.classes.street.a;
import com.xiaoenai.app.classes.street.model.AfterSale;
import com.xiaoenai.app.classes.street.model.Contact;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.model.Order.OnOrderOpListener;
import com.xiaoenai.app.classes.street.widget.StreetProductInfoLayout;
import com.xiaoenai.app.classes.street.widget.StreetProductInfoLayout.a;
import com.xiaoenai.app.classes.street.widget.StreetProductInfoWithPriceLayout;
import com.xiaoenai.app.utils.ak;

public class i
  extends ad
{
  private StreetOrderDetailActivity.a a;
  private ba b;
  private Order c;
  private a d;
  
  public i(Order paramOrder, StreetOrderDetailActivity.a parama, Order.OnOrderOpListener paramOnOrderOpListener)
  {
    super(paramOnOrderOpListener, 0);
    this.a = parama;
    this.c = paramOrder;
    this.b = new ba(this.a.c, paramOrder);
    this.d = new a();
  }
  
  private void a(int paramInt)
  {
    Context localContext = this.a.i.getContext();
    this.a.n.setVisibility(8);
    this.a.m.setVisibility(8);
    paramInt = a.a(paramInt, this.c.getExpireTime(), this.c.getCreatedTime());
    if (paramInt == 0)
    {
      this.a.h.setImageResource(2130838694);
      this.a.i.setText(localContext.getString(2131100748));
      this.a.n.setVisibility(0);
      this.a.m.setVisibility(0);
    }
    for (;;)
    {
      this.a.c.setOnClickListener(new q(this, localContext));
      return;
      if (paramInt == 4)
      {
        this.a.h.setImageResource(2130838690);
        this.a.i.setText(localContext.getString(2131100743));
        this.a.o.setVisibility(8);
        this.a.p.setVisibility(0);
        this.a.p.setBackgroundResource(2130838699);
        this.a.p.setTextColor(localContext.getResources().getColor(2131493028));
        this.a.p.setText(localContext.getResources().getString(2131100741));
        this.a.p.setOnClickListener(new l(this, localContext));
      }
      else if (paramInt == 1)
      {
        this.a.h.setImageResource(2130838693);
        this.a.i.setText(localContext.getString(2131100749));
        this.a.b.setVisibility(8);
      }
      else if (paramInt == 2)
      {
        this.a.h.setImageResource(2130838692);
        this.a.i.setText(localContext.getString(2131100746));
        this.a.p.setVisibility(0);
        this.a.p.setBackgroundResource(2130838700);
        this.a.p.setTextColor(localContext.getResources().getColor(2131493073));
        this.a.p.setText(localContext.getResources().getString(2131100727));
        this.a.p.setOnClickListener(new m(this, localContext));
        this.a.o.setVisibility(0);
        this.a.o.setBackgroundResource(2130838699);
        this.a.o.setTextColor(localContext.getResources().getColor(2131493028));
        this.a.o.setText(localContext.getResources().getString(2131100723));
        this.a.o.setOnClickListener(new n(this, localContext));
      }
      else if (paramInt == 3)
      {
        this.a.h.setImageResource(2130838691);
        this.a.i.setText(localContext.getString(2131100744));
        if (this.c.getServiceScore() > 0)
        {
          this.a.p.setVisibility(0);
          this.a.p.setBackgroundResource(2130838699);
          this.a.p.setTextColor(localContext.getResources().getColor(2131493028));
          this.a.p.setText(localContext.getResources().getString(2131100741));
          this.a.p.setOnClickListener(new o(this, localContext));
        }
        else
        {
          this.a.o.setVisibility(0);
          this.a.o.setBackgroundResource(2130838699);
          this.a.o.setTextColor(localContext.getResources().getColor(2131493028));
          this.a.o.setText(localContext.getResources().getString(2131100741));
          this.a.o.setOnClickListener(new p(this, localContext));
          this.a.p.setVisibility(0);
          this.a.p.setBackgroundResource(2130838700);
          this.a.p.setTextColor(localContext.getResources().getColor(2131493073));
          this.a.p.setText(localContext.getResources().getString(2131101397));
          this.a.p.setOnClickListener(c());
        }
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.a.b.setVisibility(8);
    this.a.c.getMallProductInfoLayout().getViewHolder().g.setVisibility(8);
    if (this.c.getAfterSale().getType() == 0) {}
    for (;;)
    {
      if (this.c.getAfterSale().getNeedDelivery() == 1)
      {
        this.a.q.setVisibility(0);
        this.a.s.setText(this.c.getAfterSale().getProgressTitle());
        this.a.t.setText(this.c.getAfterSale().getProgressContent());
        this.a.v.setVisibility(0);
        this.a.v.setOnClickListener(b(paramContext));
      }
      this.a.h.setImageResource(2130838921);
      this.a.i.setText(this.c.getAfterSale().getTypeDesc());
      return;
      if (this.c.getAfterSale().getType() != 1) {
        if (this.c.getAfterSale().getType() == 2)
        {
          this.a.q.setVisibility(0);
          this.a.w.setVisibility(0);
          if (this.c.getAfterSale() != null)
          {
            String str = this.c.getAfterSale().getProgressTitle();
            if (str != null) {
              this.a.s.setText(str);
            }
            str = this.c.getAfterSale().getProgressContent();
            if (str != null) {
              this.a.t.setText(str);
            }
          }
          this.a.v.setVisibility(8);
        }
        else if (this.c.getAfterSale().getType() != 3) {}
      }
    }
  }
  
  private View.OnClickListener b(Context paramContext)
  {
    return new s(this, paramContext);
  }
  
  private View.OnClickListener c()
  {
    return new r(this);
  }
  
  public void a()
  {
    Context localContext = this.a.k.getContext();
    this.a.g.setText(this.c.getContact().getProvinceCityZone() + this.c.getContact().getAddress());
    this.a.l.setText(String.format(localContext.getString(2131100740), new Object[] { ak.j(this.c.getCreatedTime()) }));
    if (this.c.getState() == 0) {
      this.d.a(localContext, this.a.m, this.c.getCreatedTime(), this.c.getExpireTime(), new j(this));
    }
    Object localObject2 = String.format(localContext.getString(2131100754), new Object[] { Long.valueOf(this.c.getId()) });
    Object localObject1 = localObject2;
    if (this.c.getIsPrivate()) {
      localObject1 = (String)localObject2 + localContext.getString(2131100765);
    }
    this.a.k.setText((CharSequence)localObject1);
    this.a.f.setText(this.c.getContact().getPhone());
    this.a.e.setText(this.c.getContact().getReceiver());
    localObject2 = this.a.j;
    if (this.c.getStateDesc() == null) {}
    for (localObject1 = "";; localObject1 = this.c.getStateDesc())
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      if ((this.c.getState() == 1) || (this.c.getState() == 2) || (this.c.getState() == 3)) {
        this.c.setShowSellOpBtn(true);
      }
      this.b.a();
      if ((!this.c.isAfterSale()) || (this.c.getAfterSale() == null)) {
        break;
      }
      a(localContext);
      return;
    }
    a(this.c.getState());
  }
  
  public void a(Order paramOrder)
  {
    this.c = paramOrder;
    this.b.a(paramOrder);
  }
  
  public void b()
  {
    if (this.d != null) {
      this.d.a();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */