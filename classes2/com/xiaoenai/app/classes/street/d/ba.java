package com.xiaoenai.app.classes.street.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.xiaoenai.app.classes.street.StreetCustomerServiceActivity;
import com.xiaoenai.app.classes.street.StreetServiceChooseActivity;
import com.xiaoenai.app.classes.street.model.AfterSale;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.model.Product;
import com.xiaoenai.app.classes.street.model.Sku;
import com.xiaoenai.app.classes.street.widget.StreetProductInfoWithPriceLayout;

public class ba
{
  private StreetProductInfoWithPriceLayout a;
  private ay b;
  private TextView c;
  private Order d;
  
  public ba(StreetProductInfoWithPriceLayout paramStreetProductInfoWithPriceLayout, Order paramOrder)
  {
    this.a = paramStreetProductInfoWithPriceLayout;
    this.b = new ay(this.a.getMallProductInfoLayout(), paramOrder);
    this.c = paramStreetProductInfoWithPriceLayout.getPriceTxt();
    this.d = paramOrder;
  }
  
  private View.OnClickListener a(Context paramContext)
  {
    return new bb(this, paramContext);
  }
  
  private void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("street_service_type_key", com.xiaoenai.app.c.a.d);
    localIntent.putExtra("street_service_msg_key", paramString);
    localIntent.setClass(paramContext, StreetCustomerServiceActivity.class);
    paramContext.startActivity(localIntent);
    ((Activity)paramContext).overridePendingTransition(2130968604, 2130968605);
  }
  
  private View.OnClickListener b(Context paramContext)
  {
    return new bc(this, paramContext);
  }
  
  private void b()
  {
    this.a.getPriceOpDivider().setVisibility(0);
    this.a.getLeftOpBtn().setVisibility(0);
    this.a.getOpBtn().setVisibility(0);
  }
  
  private View.OnClickListener c(Context paramContext)
  {
    return new be(this, paramContext);
  }
  
  private void c()
  {
    this.a.getPriceOpDivider().setVisibility(8);
    this.a.getLeftOpBtn().setVisibility(8);
    this.a.getOpBtn().setVisibility(8);
  }
  
  private void d(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("street_order_id_key", this.d.getId());
    localIntent.putExtra("street_service_type_key", com.xiaoenai.app.c.a.a);
    localIntent.setClass(paramContext, StreetCustomerServiceActivity.class);
    ((Activity)paramContext).startActivityForResult(localIntent, 836);
    ((Activity)paramContext).overridePendingTransition(2130968604, 2130968605);
  }
  
  private void e(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("street_order_id_key", this.d.getId());
    localIntent.setClass(paramContext, StreetServiceChooseActivity.class);
    ((Activity)paramContext).startActivityForResult(localIntent, 836);
    ((Activity)paramContext).overridePendingTransition(2130968604, 2130968605);
  }
  
  public void a()
  {
    this.b.a();
    Context localContext = this.a.getContext();
    Object localObject1;
    int i;
    String str;
    Object localObject2;
    if (this.d.getSku() != null)
    {
      localObject1 = localContext.getString(2131101433);
      if ((this.d.getProduct().getIsRush().booleanValue()) || (this.d.getSku().getRushId() > 0))
      {
        i = this.d.getSku().getRushPrice();
        str = "￥ " + String.format("%.2f", new Object[] { Double.valueOf(i * this.d.getCount() / 100.0D) });
        str = (String)localObject1 + str;
        localObject2 = new SpannableString(str);
        ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(localContext.getResources().getColor(2131493073)), ((String)localObject1).length(), str.length(), 33);
        this.c.setText((CharSequence)localObject2);
      }
    }
    else
    {
      if ((this.d.isAfterSale()) && (this.d.getAfterSale() != null))
      {
        if ((this.d.getAfterSale().getType() != 0) && (this.d.getAfterSale().getType() != 3)) {
          break label716;
        }
        if ((!this.d.getProduct().getIsRush().booleanValue()) && (this.d.getSku().getRushId() <= 0)) {
          break label701;
        }
        i = this.d.getSku().getRushPrice();
        label280:
        localObject1 = localContext.getString(2131101341) + localContext.getString(2131101450) + String.format("%.2f", new Object[] { Double.valueOf(i * this.d.getCount() / 100.0D) }) + "    ";
        str = localContext.getString(2131101450) + String.format("%.2f", new Object[] { Double.valueOf(this.d.getAfterSale().getRefundPrice() / 100.0D) });
        localObject2 = localContext.getString(2131101348) + str;
        i = ((String)localObject1).length();
        int j = ((String)localObject2).length();
        int k = str.length();
        int m = ((String)localObject1).length();
        int n = ((String)localObject2).length();
        localObject1 = new SpannableString((String)localObject1 + (String)localObject2);
        ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(localContext.getResources().getColor(2131493073)), i + j - k, m + n, 33);
        this.c.setText((CharSequence)localObject1);
        this.a.setPriceVisibility(0);
      }
      label541:
      com.xiaoenai.app.utils.f.a.c("==================order.getAfterSale(): {}", new Object[] { this.d.getAfterSale() });
      if (this.d.isShowAfterSale())
      {
        if ((!this.d.isAfterSale()) || (this.d.getAfterSale() == null)) {
          break label733;
        }
        if ((this.d.getAfterSale().getType() != 1) && (this.d.getAfterSale().getType() != 2)) {
          break label728;
        }
        this.a.getPriceOpDivider().setVisibility(0);
        this.a.getLeftOpBtn().setVisibility(8);
        this.a.getOpBtn().setVisibility(0);
        this.a.getOpBtn().setText(localContext.getString(2131101338));
        this.a.getOpBtn().setOnClickListener(a(localContext));
      }
    }
    label701:
    label716:
    label728:
    label733:
    do
    {
      return;
      i = this.d.getSku().getPrice();
      break;
      i = this.d.getSku().getPrice();
      break label280;
      this.a.setPriceVisibility(8);
      break label541;
      c();
      return;
      if (this.d.getState() == 0)
      {
        c();
        return;
      }
      if (this.d.getState() == 1)
      {
        b();
        this.a.getLeftOpBtn().setText(localContext.getString(2131101338));
        this.a.getOpBtn().setText(localContext.getString(2131100766));
        this.a.getLeftOpBtn().setOnClickListener(a(localContext));
        this.a.getOpBtn().setOnClickListener(c(localContext));
        return;
      }
      if (this.d.getState() == 2)
      {
        b();
        this.a.getLeftOpBtn().setText(localContext.getString(2131101338));
        this.a.getOpBtn().setText(localContext.getString(2131100722));
        this.a.getLeftOpBtn().setOnClickListener(a(localContext));
        this.a.getOpBtn().setOnClickListener(b(localContext));
        return;
      }
    } while (this.d.getState() != 3);
    b();
    this.a.getLeftOpBtn().setText(localContext.getString(2131101338));
    this.a.getOpBtn().setText(localContext.getString(2131100722));
    this.a.getLeftOpBtn().setOnClickListener(a(localContext));
    this.a.getOpBtn().setOnClickListener(b(localContext));
  }
  
  public void a(Order paramOrder)
  {
    this.d = paramOrder;
    this.b.a(paramOrder);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */