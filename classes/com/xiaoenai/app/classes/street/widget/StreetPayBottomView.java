package com.xiaoenai.app.classes.street.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.street.b.f;
import com.xiaoenai.app.classes.street.model.ProductInfo;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.f.a;
import java.util.Timer;

public class StreetPayBottomView
  extends RelativeLayout
{
  private Context a = null;
  private RelativeLayout b = null;
  private TextView c = null;
  private TextView d = null;
  private Button e = null;
  private Button f = null;
  private Button g = null;
  private ImageView h = null;
  private TextView i = null;
  private RelativeLayout j = null;
  private RelativeLayout k = null;
  private TextView l = null;
  private boolean m = false;
  private a n = null;
  private ProductInfo o = null;
  private Timer p = null;
  private long q = 0L;
  private Handler r = new Handler();
  
  public StreetPayBottomView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public StreetPayBottomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public StreetPayBottomView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.p != null)
    {
      if (paramInt == 0)
      {
        this.d.setText(ak.n(paramLong));
        if (this.o.getSellingTime() - ak.b() >= 600L)
        {
          this.g.setEnabled(true);
          if (f.a().b(this.o.getId(), this.o.getRushId()))
          {
            this.g.setText(getResources().getString(2131101444));
            setButtonCenterColor(2131493137);
          }
        }
        while (!this.g.isEnabled())
        {
          return;
          this.g.setText(getResources().getString(2131101438));
          setButtonCenterColor(2131493139);
          return;
        }
        this.g.setEnabled(false);
        this.g.setText(getResources().getString(2131101458));
        setButtonCenterColor(2131493137);
        return;
      }
      if (1 == paramInt)
      {
        this.d.setText(ak.n(paramLong));
        if (this.o.getSubState() == 0)
        {
          a(false, null);
          return;
        }
        a(true, this.o.getSubStatusDesc());
        return;
      }
      a();
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      return;
    }
    a();
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    this.b = ((RelativeLayout)LayoutInflater.from(paramContext).inflate(2130903353, this));
    this.c = ((TextView)findViewById(2131559961));
    this.d = ((TextView)findViewById(2131559962));
    this.f = ((Button)findViewById(2131559964));
    this.e = ((Button)findViewById(2131559963));
    this.g = ((Button)findViewById(2131559965));
    this.h = ((ImageView)findViewById(2131559967));
    this.i = ((TextView)findViewById(2131559968));
    this.j = ((RelativeLayout)findViewById(2131559966));
    this.k = ((RelativeLayout)findViewById(2131559957));
    this.l = ((TextView)findViewById(2131559959));
    paramContext = this.k.getBackground();
    if (paramContext != null) {
      paramContext.setAlpha(229);
    }
    this.k.setVisibility(8);
    b();
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.g.setVisibility(0);
      this.g.setBackgroundResource(2130838682);
      this.g.setText(2131101025);
      this.k.setVisibility(0);
      this.k.setBackgroundResource(2131493134);
      if ((paramString != null) && (paramString.length() > 0))
      {
        findViewById(2131559958).setVisibility(0);
        findViewById(2131559960).setVisibility(8);
        this.l.setVisibility(0);
        this.l.setText(paramString);
        return;
      }
      findViewById(2131559958).setVisibility(8);
      this.l.setVisibility(8);
      findViewById(2131559960).setVisibility(0);
      ((TextView)findViewById(2131559960)).setText(2131101452);
      return;
    }
    this.e.setVisibility(0);
    this.f.setVisibility(8);
    this.g.setVisibility(8);
    this.k.setVisibility(8);
    setButtonCartColor(2131493143);
    setButtonBuyColor(2131493132);
    this.f.setText(2131101436);
    this.e.setText(2131101443);
  }
  
  private void b()
  {
    this.k.setOnClickListener(new u(this));
    this.b.setOnClickListener(new v(this));
    this.j.setOnClickListener(new w(this));
    this.f.setOnClickListener(new x(this));
    this.e.setOnClickListener(new y(this));
    this.g.setOnClickListener(new z(this));
  }
  
  private void c()
  {
    this.k.setBackgroundResource(2131493141);
    Drawable localDrawable = this.k.getBackground();
    if (localDrawable != null) {
      localDrawable.setAlpha(229);
    }
    this.k.setVisibility(0);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(0);
    this.f.setVisibility(8);
    this.g.setVisibility(8);
    int i1 = getResources().getColor(2131493135);
    this.e.setBackgroundResource(2130838923);
    this.e.setTextColor(getResources().getColor(2131493142));
    this.e.setEnabled(false);
    ((GradientDrawable)this.e.getBackground()).setColor(i1);
    i1 = getResources().getColor(2131493136);
    this.f.setBackgroundResource(2130838923);
    ((GradientDrawable)this.f.getBackground()).setColor(i1);
    this.f.setEnabled(false);
    findViewById(2131559958).setVisibility(8);
    findViewById(2131559960).setVisibility(0);
    ((TextView)findViewById(2131559960)).setText(2131101456);
  }
  
  private void d()
  {
    this.c.setVisibility(0);
    this.d.setVisibility(0);
    if (1 == this.o.getStatus())
    {
      this.q = ((this.o.getCloseTime() - ak.b()) * 10L);
      this.c.setText(2131101446);
    }
    for (;;)
    {
      a();
      this.p = new Timer();
      a(this.o.getStatus(), this.q);
      this.p.schedule(new aa(this), 0L, 100);
      do
      {
        return;
      } while (this.o.getStatus() != 0);
      this.q = ((this.o.getSellingTime() - ak.b()) * 10L);
      this.c.setText(2131101464);
    }
  }
  
  private void setButtonBuyColor(int paramInt)
  {
    if (this.e != null)
    {
      paramInt = getResources().getColor(paramInt);
      this.e.setBackgroundResource(2130838923);
      GradientDrawable localGradientDrawable = (GradientDrawable)this.e.getBackground();
      if (localGradientDrawable != null) {
        localGradientDrawable.setColor(paramInt);
      }
    }
  }
  
  private void setButtonCartColor(int paramInt)
  {
    if (this.f != null)
    {
      paramInt = getResources().getColor(paramInt);
      this.f.setBackgroundResource(2130838923);
      GradientDrawable localGradientDrawable = (GradientDrawable)this.f.getBackground();
      if (localGradientDrawable != null) {
        localGradientDrawable.setColor(paramInt);
      }
    }
  }
  
  private void setButtonCenterColor(int paramInt)
  {
    if (this.g != null)
    {
      paramInt = getResources().getColor(paramInt);
      this.g.setBackgroundResource(2130838923);
      GradientDrawable localGradientDrawable = (GradientDrawable)this.g.getBackground();
      if (localGradientDrawable != null) {
        localGradientDrawable.setColor(paramInt);
      }
    }
  }
  
  private void setFavState(boolean paramBoolean)
  {
    this.m = paramBoolean;
    if (this.m)
    {
      this.h.setImageResource(2130838958);
      this.i.setTextColor(getResources().getColor(2131493143));
      return;
    }
    this.h.setImageResource(2130838957);
    this.i.setTextColor(getResources().getColor(2131493138));
  }
  
  private void setStatusForSale(ProductInfo paramProductInfo)
  {
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    this.g.setVisibility(0);
    if (this.o.getSellingTime() - ak.b() >= 600L)
    {
      this.g.setEnabled(true);
      if (f.a().b(this.o.getId(), this.o.getRushId()))
      {
        this.g.setText(getResources().getString(2131101444));
        setButtonCenterColor(2131493137);
      }
    }
    while (paramProductInfo.getIsRush().booleanValue())
    {
      d();
      return;
      this.g.setText(getResources().getString(2131101438));
      setButtonCenterColor(2131493139);
      continue;
      if (this.g.isEnabled())
      {
        this.g.setEnabled(false);
        this.g.setText(getResources().getString(2131101458));
        setButtonCenterColor(2131493137);
      }
    }
    this.c.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  private void setStatusSellOut(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.g.setVisibility(0);
      this.g.setText(getResources().getString(2131101467));
      setButtonCenterColor(2131493137);
      this.g.setEnabled(false);
    }
    for (;;)
    {
      a();
      return;
      this.k.setBackgroundResource(2131493141);
      Drawable localDrawable = this.k.getBackground();
      if (localDrawable != null) {
        localDrawable.setAlpha(229);
      }
      this.k.setVisibility(0);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      this.e.setVisibility(0);
      this.f.setVisibility(8);
      this.g.setVisibility(8);
      int i1 = getResources().getColor(2131493135);
      this.e.setBackgroundResource(2130838923);
      this.e.setTextColor(getResources().getColor(2131493142));
      this.e.setEnabled(false);
      ((GradientDrawable)this.e.getBackground()).setColor(i1);
      i1 = getResources().getColor(2131493136);
      this.f.setBackgroundResource(2130838923);
      ((GradientDrawable)this.f.getBackground()).setColor(i1);
      this.f.setEnabled(false);
      findViewById(2131559958).setVisibility(8);
      findViewById(2131559960).setVisibility(0);
      ((TextView)findViewById(2131559960)).setText(2131101467);
    }
  }
  
  private void setStatusSelling(ProductInfo paramProductInfo)
  {
    if (paramProductInfo.getIsRush().booleanValue())
    {
      this.c.setVisibility(0);
      this.d.setVisibility(0);
      d();
      return;
    }
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(0);
    this.f.setVisibility(8);
    this.g.setVisibility(8);
    setButtonCartColor(2131493143);
    setButtonBuyColor(2131493132);
    this.e.setEnabled(true);
    this.f.setEnabled(true);
    a();
  }
  
  public void a()
  {
    if (this.p != null)
    {
      this.p.cancel();
      this.p = null;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
  }
  
  public void setOnClickListener(a parama)
  {
    this.n = parama;
  }
  
  public void setProductInfo(ProductInfo paramProductInfo)
  {
    this.o = paramProductInfo;
    if (paramProductInfo.getIsRush().booleanValue())
    {
      this.f.setText(getResources().getString(2131101436));
      this.e.setText(getResources().getString(2131101443));
    }
    for (;;)
    {
      a.c("product status = {}", new Object[] { Integer.valueOf(paramProductInfo.getStatus()) });
      if (!paramProductInfo.getOnlineStatus()) {
        break label209;
      }
      if (!paramProductInfo.getIsRush().booleanValue()) {
        break;
      }
      this.k.setVisibility(8);
      switch (paramProductInfo.getStatus())
      {
      default: 
        return;
        this.f.setText(getResources().getString(2131101436));
        this.e.setText(getResources().getString(2131101442));
        setFavState(paramProductInfo.getFavor().booleanValue());
      }
    }
    setStatusForSale(paramProductInfo);
    return;
    setStatusSelling(paramProductInfo);
    return;
    setStatusSellOut(true);
    return;
    if (paramProductInfo.getTotalStock() > 0)
    {
      setStatusSelling(paramProductInfo);
      return;
    }
    setStatusSellOut(false);
    return;
    label209:
    if (paramProductInfo.getIsRush().booleanValue())
    {
      c();
      return;
    }
    c();
  }
  
  public static abstract interface a
  {
    public abstract void a(ProductInfo paramProductInfo);
    
    public abstract void a(boolean paramBoolean);
    
    public abstract void b(ProductInfo paramProductInfo);
    
    public abstract void c(ProductInfo paramProductInfo);
    
    public abstract void d(ProductInfo paramProductInfo);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\StreetPayBottomView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */