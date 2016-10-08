package com.xiaoenai.app.classes.street.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.street.StreetOrderDetailActivity;
import com.xiaoenai.app.classes.street.StreetOrderReviewsActivity;
import com.xiaoenai.app.classes.street.a;
import com.xiaoenai.app.classes.street.model.AfterSale;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.model.Order.OnOrderOpListener;
import com.xiaoenai.app.classes.street.widget.StreetCountdownView.a;
import com.xiaoenai.app.classes.street.widget.StreetOrderListItemLayout;
import com.xiaoenai.app.classes.street.widget.StreetOrderListItemLayout.a;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.widget.h;
import com.xiaoenai.app.widget.h.a;

public class t
  extends ad
  implements h.a
{
  private StreetOrderListItemLayout a;
  private Order b;
  private ba c;
  private StreetOrderListItemLayout.a d;
  private Order.OnOrderOpListener e;
  private Handler f;
  private StreetCountdownView.a g = null;
  private final long h = 1000L;
  
  public t(StreetOrderListItemLayout paramStreetOrderListItemLayout, Order paramOrder, Order.OnOrderOpListener paramOnOrderOpListener, int paramInt, Handler paramHandler)
  {
    super(paramOnOrderOpListener, paramInt);
    this.a = paramStreetOrderListItemLayout;
    this.d = paramStreetOrderListItemLayout.getViewHolder();
    this.c = new ba(this.d.e, paramOrder);
    this.b = paramOrder;
    this.e = paramOnOrderOpListener;
    this.f = paramHandler;
  }
  
  private View.OnClickListener a(Context paramContext)
  {
    return new y(this, paramContext);
  }
  
  private String a(int paramInt)
  {
    String str = null;
    Context localContext = this.d.c.getContext();
    this.d.c.setTextColor(localContext.getResources().getColor(2131493073));
    if (paramInt == 0) {
      str = localContext.getString(2131101435);
    }
    do
    {
      return str;
      if (paramInt == 4)
      {
        str = localContext.getString(2131101398);
        this.d.c.setTextColor(localContext.getResources().getColor(2131493032));
        return str;
      }
      if (paramInt == 1) {
        return localContext.getString(2131101414);
      }
      if (paramInt == 2) {
        return localContext.getString(2131101407);
      }
    } while (paramInt != 3);
    return localContext.getString(2131101399);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    String str = this.b.getAfterSale().getTypeDesc();
    Context localContext = this.d.c.getContext();
    this.d.c.setTextColor(localContext.getResources().getColor(2131493073));
    this.d.c.setText(str);
    b(paramInt1, paramInt2);
    d(paramInt1);
  }
  
  private void a(String paramString)
  {
    Context localContext = this.d.g.getContext();
    String str = localContext.getString(2131101413) + "\n";
    paramString = str + paramString;
    SpannableString localSpannableString = new SpannableString(paramString);
    int i = str.length();
    int j = paramString.length();
    localSpannableString.setSpan(new ForegroundColorSpan(localContext.getResources().getColor(2131493132)), i, j, 33);
    this.d.g.setText(localSpannableString);
  }
  
  private View.OnClickListener b(Context paramContext)
  {
    return new z(this, paramContext);
  }
  
  private void b(int paramInt)
  {
    Context localContext = this.d.i.getContext();
    this.d.i.setTextSize(14.0F);
    this.d.i.setBackgroundResource(2130838699);
    if (paramInt == 2)
    {
      this.d.i.setText(localContext.getString(2131100723));
      this.d.i.setOnClickListener(e());
      return;
    }
    if (paramInt == 3)
    {
      if (this.b.getServiceScore() > 0)
      {
        this.d.i.setVisibility(8);
        return;
      }
      this.d.i.setVisibility(0);
      this.d.i.setText(localContext.getString(2131100741));
      return;
    }
    if (paramInt == 0)
    {
      this.d.i.setVisibility(0);
      this.d.i.setBackgroundResource(2130838699);
      this.d.i.setText(2131100724);
      this.d.i.setTextColor(localContext.getResources().getColor(2131493028));
      return;
    }
    this.d.i.setVisibility(8);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    Context localContext = this.d.i.getContext();
    this.d.i.setTextSize(14.0F);
    this.d.i.setBackgroundResource(2130838699);
    if (paramInt1 == 2)
    {
      if (paramInt2 == 0)
      {
        this.d.i.setVisibility(8);
        return;
      }
      this.d.i.setText(localContext.getString(2131101336));
      this.d.i.setOnClickListener(e(localContext));
      return;
    }
    this.d.i.setVisibility(8);
  }
  
  private void c(int paramInt)
  {
    Context localContext = this.d.h.getContext();
    this.d.h.setGravity(17);
    this.d.h.setTextSize(14.0F);
    paramInt = a.a(paramInt, this.b.getExpireTime(), this.b.getCreatedTime());
    if (paramInt == 0)
    {
      this.d.h.setBackgroundResource(2130838700);
      this.d.h.setText(2131101415);
      this.d.h.setTextColor(localContext.getResources().getColor(2131493073));
    }
    do
    {
      return;
      if (paramInt == 4)
      {
        this.d.h.setBackgroundResource(2130838699);
        this.d.h.setText(2131100741);
        this.d.h.setTextColor(localContext.getResources().getColor(2131493028));
        return;
      }
      if (paramInt == 1)
      {
        this.d.h.setGravity(21);
        this.d.h.setText(2131100781);
        this.d.h.setTextSize(12.0F);
        this.d.h.setPadding(0, 0, 0, com.xiaoenai.app.utils.ab.a(1.0F));
        this.d.h.setTextColor(localContext.getResources().getColor(2131493032));
        this.d.h.setBackgroundResource(2131493177);
        return;
      }
      if (paramInt == 2)
      {
        this.d.h.setBackgroundResource(2130838700);
        this.d.h.setText(2131100727);
        this.d.h.setTextColor(localContext.getResources().getColor(2131493073));
        return;
      }
    } while (paramInt != 3);
    if (this.b.getServiceScore() > 0)
    {
      this.d.h.setTextSize(14.0F);
      this.d.h.setBackgroundResource(2130838699);
      this.d.h.setText(localContext.getString(2131100741));
      return;
    }
    this.d.h.setBackgroundResource(2130838700);
    this.d.h.setText(2131101397);
    this.d.h.setTextColor(localContext.getResources().getColor(2131493073));
  }
  
  private void c(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("street_order_key", this.b);
    localIntent.setClass(paramContext, StreetOrderDetailActivity.class);
    ((Activity)paramContext).startActivityForResult(localIntent, 152);
    ((Activity)paramContext).overridePendingTransition(2130968604, 2130968605);
  }
  
  private void d()
  {
    this.d.a.setOnClickListener(new x(this));
  }
  
  private void d(int paramInt)
  {
    Context localContext = this.d.h.getContext();
    this.d.h.setTextSize(14.0F);
    this.d.h.setBackgroundResource(2130838699);
    this.d.h.setTextColor(localContext.getResources().getColor(2131493028));
    if (paramInt == 0)
    {
      this.d.h.setText(2131100741);
      this.d.h.setOnClickListener(a(localContext));
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        this.d.h.setText(2131101336);
        this.d.h.setOnClickListener(e(localContext));
        return;
      }
      if (paramInt == 2)
      {
        this.d.h.setText(2131101337);
        this.d.h.setOnClickListener(b(localContext));
        return;
      }
    } while (paramInt != 3);
    this.d.h.setText(2131100741);
    this.d.h.setOnClickListener(a(localContext));
  }
  
  private void d(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("street_order_id_key", this.b.getId());
    localIntent.putExtra("street_order_detail_type", true);
    localIntent.setClass(paramContext, StreetOrderDetailActivity.class);
    ((Activity)paramContext).startActivityForResult(localIntent, 152);
    ((Activity)paramContext).overridePendingTransition(2130968604, 2130968605);
  }
  
  private View.OnClickListener e()
  {
    return new aa(this);
  }
  
  private View.OnClickListener e(Context paramContext)
  {
    return new ab(this, paramContext);
  }
  
  private void e(int paramInt)
  {
    this.d.h.setOnClickListener(new u(this, paramInt));
    this.d.i.setOnClickListener(new v(this, paramInt));
    this.d.a.setOnClickListener(new w(this));
  }
  
  private void f()
  {
    Context localContext = this.d.h.getContext();
    Intent localIntent = new Intent();
    localIntent.putExtra("street_order_key", this.b);
    localIntent.setClass(localContext, StreetOrderReviewsActivity.class);
    ((Activity)localContext).startActivityForResult(localIntent, 834);
    ((Activity)localContext).overridePendingTransition(2130968604, 2130968605);
  }
  
  private void f(int paramInt)
  {
    Object localObject = this.d.h.getContext();
    paramInt = a.a(paramInt, this.b.getExpireTime(), this.b.getCreatedTime());
    if (paramInt == 0)
    {
      localObject = new Message();
      ((Message)localObject).what = 153;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("street_order_key", this.b);
      ((Message)localObject).setData(localBundle);
      this.f.sendMessage((Message)localObject);
    }
    do
    {
      do
      {
        return;
        if (paramInt == 4)
        {
          c((Context)localObject, this.b);
          return;
        }
      } while (paramInt == 1);
      if (paramInt == 2)
      {
        a((Context)localObject, this.b);
        return;
      }
    } while (paramInt != 3);
    if (this.b.getServiceScore() > 0)
    {
      c((Context)localObject, this.b);
      return;
    }
    f();
  }
  
  private void g(int paramInt)
  {
    if (paramInt == 2) {
      b(this.d.i.getContext(), this.b);
    }
    do
    {
      return;
      if (paramInt == 3)
      {
        c(this.d.i.getContext(), this.b);
        return;
      }
    } while (paramInt != 0);
    d(this.d.i.getContext(), this.b);
  }
  
  private void h(int paramInt)
  {
    if (paramInt == 0)
    {
      this.g = new ac(this);
      h localh = this.a.getmTimer();
      localh.a(this);
      localh.a();
      this.d.g.setVisibility(0);
      b();
      return;
    }
    this.d.g.setVisibility(8);
  }
  
  public void a()
  {
    Context localContext = this.d.b.getContext();
    String str2 = String.format(localContext.getString(2131100754), new Object[] { Long.valueOf(this.b.getId()) });
    String str1 = str2;
    if (this.b.getIsPrivate()) {
      str1 = str2 + localContext.getString(2131100765);
    }
    this.d.b.setText(str1);
    this.c.a();
    if ((this.b.isAfterSale()) && (this.b.getAfterSale() != null))
    {
      a(this.b.getAfterSale().getType(), this.b.getAfterSale().getCanCancel());
      d();
      return;
    }
    b(this.b.getState());
    c(this.b.getState());
    h(this.b.getState());
    e(this.b.getState());
    this.d.c.setText(a(this.b.getState()));
  }
  
  public void b()
  {
    String str = ak.a(this.b.getCreatedTime(), this.b.getExpireTime());
    if (str != null) {
      a(str);
    }
    while (this.g == null) {
      return;
    }
    this.g.a();
  }
  
  public void c()
  {
    h localh = this.a.getmTimer();
    if (localh != null) {
      localh.b();
    }
  }
  
  public long getPeriod()
  {
    return 1000L;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */