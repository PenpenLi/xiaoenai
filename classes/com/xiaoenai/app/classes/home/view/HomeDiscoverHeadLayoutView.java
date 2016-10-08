package com.xiaoenai.app.classes.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.xiaoenai.app.classes.home.a.b;
import com.xiaoenai.app.classes.home.a.c;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.BannerView;

public class HomeDiscoverHeadLayoutView
  extends LinearLayout
{
  private LoverSearchView a;
  private BannerView b;
  private RelativeLayout c;
  private ImageButton d;
  private View.OnClickListener e = new w(this);
  private View.OnClickListener f = new x(this);
  
  public HomeDiscoverHeadLayoutView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public HomeDiscoverHeadLayoutView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2130903242, this);
    this.a = ((LoverSearchView)localView.findViewById(2131559454));
    this.b = ((BannerView)localView.findViewById(2131559456));
    this.c = ((RelativeLayout)localView.findViewById(2131559455));
    this.d = ((ImageButton)localView.findViewById(2131559457));
    this.d.setOnTouchListener(com.xiaoenai.app.utils.d.w.c);
    b();
  }
  
  private void b()
  {
    User.getInstance();
    if (!User.isSingle()) {
      this.a.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      if (this.a != null) {
        this.a.setVisibility(8);
      }
    }
    while (1 != paramInt) {
      return;
    }
    this.a.setVisibility(0);
  }
  
  public void a(a.b paramb)
  {
    if (paramb != null)
    {
      if (paramb.a())
      {
        this.c.setVisibility(0);
        ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
        localLayoutParams.height = paramb.a(paramb.f[0].b, paramb.f[0].a);
        a.c("layoutParams.height: h={} w={}", new Object[] { Integer.valueOf(localLayoutParams.height), Integer.valueOf(ab.b()) });
        this.b.setLayoutParams(localLayoutParams);
        b.a(this.b, paramb.f[0].c);
        this.c.setOnClickListener(this.e);
        this.d.setOnClickListener(this.f);
      }
    }
    else {
      return;
    }
    this.c.setVisibility(8);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\view\HomeDiscoverHeadLayoutView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */