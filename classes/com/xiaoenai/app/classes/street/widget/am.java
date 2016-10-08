package com.xiaoenai.app.classes.street.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.c.a.l;
import com.xiaoenai.app.classes.street.model.ImageInfo;
import com.xiaoenai.app.classes.street.model.ProductInfo;
import com.xiaoenai.app.classes.street.model.Sku;
import com.xiaoenai.app.classes.street.model.SkuProp;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.utils.f.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;

public class am
  extends Dialog
{
  private boolean A = false;
  private String B = "";
  private int C = 0;
  private boolean D = true;
  private Context a = null;
  private RelativeLayout b = null;
  private RelativeLayout c = null;
  private ImageView d = null;
  private ImageView e = null;
  private ImageView f = null;
  private TextView g = null;
  private Button h = null;
  private TextView i = null;
  private TextView j = null;
  private int k = 1;
  private ImageView l = null;
  private TextView m = null;
  private TextView n = null;
  private TextView o = null;
  private LinearLayout p = null;
  private List<StreetProductSkuView> q = new ArrayList();
  private TextView r = null;
  private long s = 0L;
  private Timer t = new Timer();
  private Handler u = new Handler();
  private Sku v = null;
  private ProductInfo w = null;
  private a x = null;
  private StreetProductSkuView.a y = null;
  private boolean z = true;
  
  public am(Context paramContext)
  {
    super(paramContext, 2131296448);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.C = ((int)(ab.a() * 0.6D));
    this.a = paramContext;
    this.b = ((RelativeLayout)getLayoutInflater().inflate(2130903359, null));
    this.c = ((RelativeLayout)this.b.findViewById(2131558670));
    this.d = ((ImageView)this.b.findViewById(2131560030));
    this.e = ((ImageView)this.b.findViewById(2131560037));
    this.f = ((ImageView)this.b.findViewById(2131560039));
    this.g = ((TextView)this.b.findViewById(2131559983));
    this.h = ((Button)this.b.findViewById(2131560044));
    this.h.setText(2131101440);
    this.i = ((TextView)this.b.findViewById(2131560042));
    this.j = ((TextView)this.b.findViewById(2131560043));
    this.l = ((ImageView)this.b.findViewById(2131560029));
    this.m = ((TextView)this.b.findViewById(2131559982));
    this.n = ((TextView)this.b.findViewById(2131560031));
    this.o = ((TextView)this.b.findViewById(2131560032));
    this.p = ((LinearLayout)this.b.findViewById(2131560033));
    this.r = ((TextView)this.b.findViewById(2131560036));
    this.b.findViewById(2131560041).setVisibility(0);
  }
  
  private void a(Boolean paramBoolean, String paramString1, String paramString2)
  {
    int i1 = 0;
    a.c("isPress = {} name = {} value = {}", new Object[] { paramBoolean, paramString1, paramString2 });
    Object localObject2 = (SkuProp)this.w.getSkuPropHashMap().get(paramString1);
    if (localObject2 != null)
    {
      if (paramBoolean.booleanValue())
      {
        paramString2 = ((SkuProp)localObject2).getContainsSkuKeyMap(paramString2);
        localObject1 = this.q.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (StreetProductSkuView)((Iterator)localObject1).next();
          if (!((StreetProductSkuView)localObject2).getSkuProp().getName().equals(paramString1)) {
            ((StreetProductSkuView)localObject2).a(paramBoolean.booleanValue(), paramString2);
          }
        }
      }
      Object localObject1 = new ArrayList();
      String[] arrayOfString = ((SkuProp)localObject2).getValues();
      int i2 = arrayOfString.length;
      for (;;)
      {
        paramString2 = (String)localObject1;
        if (i1 >= i2) {
          break;
        }
        ((List)localObject1).addAll(((SkuProp)localObject2).getContainsSkuKeyMap(arrayOfString[i1]));
        i1 += 1;
      }
    }
    a.a(true, "name = {} value = {}", new Object[] { paramString1, paramString2 });
  }
  
  private void d()
  {
    ((RelativeLayout.LayoutParams)this.c.getLayoutParams()).height = this.C;
    this.b.findViewById(2131558587).getLayoutParams().height = c();
  }
  
  private void e()
  {
    this.d.setOnClickListener(new an(this));
    this.e.setOnClickListener(new ao(this));
    this.f.setOnClickListener(new ap(this));
    this.h.setOnClickListener(new aq(this));
    this.y = new ar(this);
    findViewById(2131560027).setOnClickListener(new as(this));
  }
  
  private void f()
  {
    if (this.w != null) {
      if (!this.w.getIsRush().booleanValue()) {
        break label101;
      }
    }
    label101:
    for (String str = this.a.getString(2131100799) + String.format(Locale.getDefault(), "%.2f", new Object[] { Double.valueOf(this.w.getRushPrice() / 100.0D) });; str = this.a.getString(2131100799) + String.format(Locale.getDefault(), "%.2f", new Object[] { Double.valueOf(this.w.getPrice() / 100.0D) }))
    {
      this.m.setText(str);
      this.n.setText(this.w.getTotalStockDesc());
      return;
    }
  }
  
  private String g()
  {
    String str2 = "";
    String str1 = "";
    Iterator localIterator = this.q.iterator();
    if (localIterator.hasNext())
    {
      StreetProductSkuView localStreetProductSkuView = (StreetProductSkuView)localIterator.next();
      String str3 = localStreetProductSkuView.getSkuPropValue();
      if (str3.length() > 0) {
        if (str2.length() == 0) {
          str2 = this.c.getResources().getString(2131101463) + "\"" + str3 + "\" ";
        }
      }
      for (;;)
      {
        break;
        str2 = str2 + "\"" + str3 + "\" ";
        continue;
        if (str1.length() == 0) {
          str1 = this.c.getResources().getString(2131101462) + localStreetProductSkuView.getSkuProp().getName();
        } else {
          str1 = str1 + "," + localStreetProductSkuView.getSkuProp().getName();
        }
      }
    }
    a.c("text = {} {}", new Object[] { str1, str2 });
    if (str1.length() == 0) {
      return str2;
    }
    return str1;
  }
  
  private void h()
  {
    if ((this.w == null) || (!this.D)) {
      return;
    }
    this.D = false;
    a.c("getChildCount length = {}", new Object[] { Integer.valueOf(this.p.getChildCount()) });
    this.v = null;
    Object localObject;
    if (this.w.getSkuProps() != null)
    {
      a.c("getSkuProps length = {}", new Object[] { Integer.valueOf(this.w.getSkuProps().length) });
      this.b.findViewById(2131560041).setVisibility(0);
      this.p.removeAllViews();
      this.q.clear();
      int i1 = ab.a(54.0F);
      int i2 = 0;
      while (i2 < this.w.getSkuProps().length)
      {
        localObject = new StreetProductSkuView(this.a);
        this.q.add(localObject);
        ((StreetProductSkuView)localObject).setSkuProp(this.w.getSkuProps()[i2]);
        i1 += ((StreetProductSkuView)localObject).getViewHeigth();
        ((StreetProductSkuView)localObject).setOnSkuClickListener(this.y);
        this.p.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
        if (i2 + 1 < this.w.getSkuProps().length)
        {
          localObject = new View(this.a);
          ((View)localObject).setBackgroundResource(2131493011);
          this.p.addView((View)localObject, new LinearLayout.LayoutParams(-1, 2));
        }
        i2 += 1;
      }
      i2 = c();
      a.c(" h = {} maxHeigth = {}", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) });
      if (i1 >= i2) {
        this.b.findViewById(2131560041).setVisibility(8);
      }
      this.B = g();
      this.o.setText(this.B);
      if ((this.w.getSkuProps().length == 1) && (this.w.getSkuProps()[0].getValues() != null) && (this.w.getSkuProps()[0].getValues().length == 1) && (this.w.getSkus() != null) && (this.w.getSkus().length == 1)) {
        a(this.w.getSkus()[0]);
      }
    }
    this.g.setText(String.valueOf(this.k));
    if ((this.w.getImageUrl() != null) && (this.w.getImageUrl().length > 0))
    {
      localObject = this.w.getImageUrl()[0].getUrl() + "?imageView/1/w/" + this.w.getImageUrl()[0].getWidth() + "/h/" + this.w.getImageUrl()[0].getHeight();
      if (this.w.getImageUrl()[0].getUrl().length() > 0) {
        b.a(this.l, (String)localObject);
      }
    }
    if (this.w.getIsRush().booleanValue())
    {
      localObject = this.a.getString(2131100799) + String.format(Locale.getDefault(), "%.2f", new Object[] { Double.valueOf(this.w.getRushPrice() / 100.0D) });
      this.m.setText((CharSequence)localObject);
      this.n.setText(this.w.getTotalStockDesc());
      if (this.w.getOrderLimit() <= 0) {
        break label769;
      }
      this.r.setText(String.format(this.a.getString(2131101455), new Object[] { Integer.valueOf(this.w.getOrderLimit()) }));
    }
    for (;;)
    {
      i();
      this.B = g();
      ((RelativeLayout)findViewById(2131560034)).getLayoutParams().height = ab.a(54.0F);
      return;
      localObject = this.a.getString(2131100799) + String.format(Locale.getDefault(), "%.2f", new Object[] { Double.valueOf(this.w.getPrice() / 100.0D) });
      break;
      label769:
      this.r.setText("");
    }
  }
  
  private void i()
  {
    j();
    this.s = ((this.w.getCloseTime() - ak.b()) * 10L);
    if ((this.w == null) || ((!this.w.getIsRush().booleanValue()) && (this.s < 0L)))
    {
      this.i.setVisibility(8);
      this.j.setVisibility(8);
      return;
    }
    this.i.setVisibility(0);
    this.j.setVisibility(0);
    this.t = new Timer();
    this.t.schedule(new au(this), 0L, 100L);
  }
  
  private void j()
  {
    if (this.t != null)
    {
      this.t.cancel();
      this.t = null;
    }
  }
  
  private void k()
  {
    if ((this.x != null) && (!this.z)) {
      this.x.a(this.w, this.v, this.k, this.A);
    }
  }
  
  public String a()
  {
    Iterator localIterator = this.q.iterator();
    StreetProductSkuView localStreetProductSkuView;
    String str2;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + localStreetProductSkuView.getSkuProp().getName() + ":" + str2 + " ")
    {
      localStreetProductSkuView = (StreetProductSkuView)localIterator.next();
      str2 = localStreetProductSkuView.getSkuPropValue();
    }
    return str1;
  }
  
  public void a(ProductInfo paramProductInfo)
  {
    if (paramProductInfo != null)
    {
      this.w = paramProductInfo;
      this.D = true;
    }
  }
  
  public void a(Sku paramSku)
  {
    this.v = null;
    Iterator localIterator = this.q.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((StreetProductSkuView)localIterator.next()).a(paramSku)) {}
    if (bool)
    {
      this.v = paramSku;
      a.c("setSelectSku sku = {}", new Object[] { this.v.getKey() });
    }
    this.B = g();
    this.o.setText(this.B);
  }
  
  public void a(a parama)
  {
    this.x = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    this.A = paramBoolean;
    show();
  }
  
  public String b()
  {
    Iterator localIterator = this.q.iterator();
    String str2;
    for (String str1 = "";; str1 = str1 + ((StreetProductSkuView)localObject).getSkuProp().getName() + ":" + str2 + ";")
    {
      localObject = str1;
      if (!localIterator.hasNext()) {
        return localObject;
      }
      localObject = (StreetProductSkuView)localIterator.next();
      str2 = ((StreetProductSkuView)localObject).getSkuPropValue();
      if ((str2 == null) || (str2.length() <= 0)) {
        break;
      }
    }
    Object localObject = "";
    return (String)localObject;
  }
  
  public int c()
  {
    return this.C - ab.a(212.0F);
  }
  
  public void dismiss()
  {
    l locall = l.a(this.c, "translationY", new float[] { 0.0F, this.C });
    locall.b(300L);
    locall.a(new at(this));
    locall.a();
    j();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.b);
    e();
    h();
    d();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.c.measure(0, 0);
    a.c("mDialogHeigth = {}", new Object[] { Integer.valueOf(this.C) });
    l.a(this.c, "translationY", new float[] { this.C, 0.0F }).b(300L).a();
    this.c.setVisibility(0);
    i();
  }
  
  public void show()
  {
    super.show();
    if (this.w != null) {
      h();
    }
    this.z = true;
  }
  
  public static abstract interface a
  {
    public abstract void a(ProductInfo paramProductInfo, Sku paramSku, int paramInt, boolean paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */