package com.xiaoenai.app.classes.street.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.chat.input.faces.d;
import com.xiaoenai.app.classes.street.StreetProductDetailActivity.b;
import com.xiaoenai.app.classes.street.model.Argument;
import com.xiaoenai.app.classes.street.model.Comment;
import com.xiaoenai.app.classes.street.model.ProductInfo;
import com.xiaoenai.app.classes.street.model.SoldDesc;
import com.xiaoenai.app.classes.street.widget.StreetPayBottomView;
import com.xiaoenai.app.classes.street.widget.ad;
import com.xiaoenai.app.classes.street.widget.ad.a;
import com.xiaoenai.app.classes.street.widget.am;
import com.xiaoenai.app.net.ae;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.e.b;

public class aq
  extends a
{
  private Context a = null;
  private ProductInfo b = null;
  private StreetProductDetailActivity.b c = null;
  private ad d = null;
  private ad e = null;
  private ViewPager f = null;
  private ad.a g = null;
  private TextView h = null;
  private TextView i = null;
  private TextView j = null;
  private TextView k = null;
  private TextView l = null;
  private RelativeLayout m = null;
  private LinearLayout n = null;
  private TextView o = null;
  private ImageView p = null;
  private TextView q = null;
  private TextView r = null;
  private TextView s = null;
  private LinearLayout t = null;
  private RelativeLayout u = null;
  private StreetPayBottomView v = null;
  
  public aq(Context paramContext, StreetProductDetailActivity.b paramb)
  {
    this.c = paramb;
    this.v = paramb.b;
    this.a = paramContext;
  }
  
  private void a(boolean paramBoolean)
  {
    ae localae = new ae(new ax(this, this.a));
    int i2 = this.b.getRushId();
    int i3 = this.b.getId();
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 1)
    {
      localae.b(i2, i3, i1);
      return;
    }
  }
  
  private void b()
  {
    this.u.setOnClickListener(new at(this));
    this.v.setOnClickListener(new au(this));
    this.c.c.a(new av(this));
  }
  
  private void b(int paramInt)
  {
    if ((paramInt == 0) && (this.u == null))
    {
      this.f = this.d.a();
      this.h = this.d.b();
      this.i = this.d.c();
      this.j = this.d.d();
      this.k = this.d.e();
      this.l = this.d.f();
      this.m = this.d.g();
      this.n = this.d.h();
      this.o = this.d.j();
      this.p = this.d.k();
      this.q = this.d.l();
      this.r = this.d.m();
      this.s = this.d.n();
      this.t = this.d.o();
      this.u = this.d.p();
      b();
    }
  }
  
  private void c()
  {
    new ae(new aw(this, this.a)).c(this.b.getId());
  }
  
  private void c(ProductInfo paramProductInfo)
  {
    this.d.a(paramProductInfo);
    int i2 = Color.parseColor("#" + paramProductInfo.getSoldDesc().getColor());
    int i1 = paramProductInfo.getPrice();
    if (paramProductInfo.getIsRush().booleanValue()) {
      i1 = paramProductInfo.getRushPrice();
    }
    Object localObject = new SpannableString(this.a.getString(2131100799) + String.format("%.2f", new Object[] { Double.valueOf(i1 / 100.0D) }));
    ((Spannable)localObject).setSpan(new AbsoluteSizeSpan((int)ab.a(this.a, 34.0F)), 0, 1, 33);
    this.h.setText((CharSequence)localObject);
    this.h.setTextColor(i2);
    this.i.setText(paramProductInfo.getSoldDesc().getDescSpan());
    this.j.setText(paramProductInfo.getTitle());
    this.k.setText(paramProductInfo.getDesc());
    if ((paramProductInfo.getGuarantees() != null) && (paramProductInfo.getGuarantees().length > 0))
    {
      localObject = "";
      ar localar = new ar(this);
      i1 = 0;
      if (i1 < paramProductInfo.getGuarantees().length)
      {
        if (i1 + 1 == paramProductInfo.getGuarantees().length) {}
        for (localObject = (String)localObject + "<img src='2130838712'/>" + paramProductInfo.getGuarantees()[i1];; localObject = (String)localObject + "<img src='2130838712'/>" + paramProductInfo.getGuarantees()[i1] + "&nbsp;&nbsp;")
        {
          i1 += 1;
          break;
        }
      }
      localObject = Html.fromHtml((String)localObject, localar, null);
      this.l.setText((CharSequence)localObject);
      this.l.setVisibility(0);
      this.m.setVisibility(0);
    }
    for (this.m.getLayoutParams().height = -2;; this.m.getLayoutParams().height = ab.a(10.0F))
    {
      if (this.g == null)
      {
        this.g = new ad.a(this.d.getFragmentManager());
        this.f.setAdapter(this.g);
      }
      this.g.a(paramProductInfo.getImageUrl(), paramProductInfo.getStatus(), paramProductInfo.getOnlineStatus());
      this.d.a(paramProductInfo.getImageUrl());
      return;
      this.l.setVisibility(8);
    }
  }
  
  private void d(ProductInfo paramProductInfo)
  {
    this.o.setText(String.format(this.a.getResources().getString(2131101461), new Object[] { String.valueOf(paramProductInfo.getCommentsCount()) }));
    if (paramProductInfo.getComment() != null)
    {
      this.d.i().setVisibility(0);
      if ((paramProductInfo.getComment().getCouplePhoto() != null) && (paramProductInfo.getComment().getCouplePhoto().length() > 0))
      {
        com.xiaoenai.app.utils.f.a.c("=========mCouplePhoto========={}", new Object[] { paramProductInfo.getComment().getCouplePhoto() });
        b.a(this.p, paramProductInfo.getComment().getCouplePhoto());
      }
      this.q.setText(paramProductInfo.getComment().getName());
      this.r.setText(paramProductInfo.getComment().getContent());
      d.a().c(this.r);
      this.s.setText(ak.a(paramProductInfo.getComment().getCreatedTime()));
    }
    for (;;)
    {
      this.n.setOnClickListener(new as(this, paramProductInfo));
      return;
      this.d.i().setVisibility(8);
    }
  }
  
  private void e(ProductInfo paramProductInfo)
  {
    if ((paramProductInfo.getArguments() != null) && (paramProductInfo.getArguments().length > 0))
    {
      this.t.removeAllViews();
      int i1 = 0;
      if (i1 < paramProductInfo.getArguments().length)
      {
        Object localObject = paramProductInfo.getArguments()[i1].getTitle() + " : " + paramProductInfo.getArguments()[i1].getValue();
        TextView localTextView = new TextView(this.a);
        localTextView.setId(i1);
        localTextView.setText((CharSequence)localObject);
        localTextView.setTextColor(this.a.getResources().getColor(2131493144));
        localTextView.setTextSize(ab.a(this.a, 12.0F));
        localTextView.setGravity(3);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        if (i1 == paramProductInfo.getArguments().length)
        {
          ((LinearLayout.LayoutParams)localObject).setMargins(0, ab.a(16.0F), 0, ab.a(16.0F));
          ((LinearLayout.LayoutParams)localObject).bottomMargin = ab.a(16.0F);
        }
        for (;;)
        {
          localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.t.addView(localTextView);
          i1 += 1;
          break;
          ((LinearLayout.LayoutParams)localObject).setMargins(0, ab.a(16.0F), 0, 0);
        }
      }
    }
  }
  
  private void f(ProductInfo paramProductInfo)
  {
    switch (paramProductInfo.getStatus())
    {
    default: 
      paramProductInfo.setStatus(3);
    }
    for (;;)
    {
      a(paramProductInfo);
      return;
      if (paramProductInfo.getSellingTime() - ak.b() <= 0L) {
        if (paramProductInfo.getCloseTime() - ak.b() > 0L)
        {
          paramProductInfo.setStatus(1);
        }
        else
        {
          paramProductInfo.setStatus(2);
          continue;
          if (paramProductInfo.getCloseTime() - ak.b() <= 0L) {
            paramProductInfo.setStatus(3);
          }
        }
      }
    }
  }
  
  public void a()
  {
    if (this.v != null) {
      this.v.a();
    }
    this.a = null;
  }
  
  public void a(int paramInt)
  {
    if (this.d != null) {
      this.d.a(paramInt);
    }
    if (paramInt == 0) {}
    do
    {
      do
      {
        return;
      } while ((this.e == null) || (this.b == null) || (this.b.getDetailPage() == null));
      com.xiaoenai.app.utils.f.a.c(" load = {}", new Object[] { this.b.getDetailPage() });
    } while (this.e.s());
    this.e.a(this.b.getDetailPage());
  }
  
  public void a(ProductInfo paramProductInfo)
  {
    b(0);
    this.b = paramProductInfo;
    c(paramProductInfo);
    d(paramProductInfo);
    e(paramProductInfo);
    this.v.setProductInfo(paramProductInfo);
    this.c.c.a(paramProductInfo);
  }
  
  public void a(ad paramad)
  {
    this.d = paramad;
  }
  
  public void b(ProductInfo paramProductInfo)
  {
    b(0);
  }
  
  public void b(ad paramad)
  {
    this.e = paramad;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\d\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */