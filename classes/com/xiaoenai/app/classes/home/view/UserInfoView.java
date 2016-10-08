package com.xiaoenai.app.classes.home.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.ui.component.view.AvatarView;
import com.xiaoenai.app.utils.d.w;
import com.xiaoenai.app.utils.f.a;
import java.math.BigDecimal;

public class UserInfoView
  extends LinearLayout
{
  private View a;
  private AvatarView b;
  private TextView c;
  private TextView d;
  private AvatarView e;
  private TextView f;
  private TextView g;
  private boolean h = true;
  private a i;
  
  public UserInfoView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public UserInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private void d()
  {
    a(LayoutInflater.from(getContext()).inflate(2130903257, this));
  }
  
  private void e()
  {
    User localUser = User.getInstance();
    this.e.a(localUser.getAvatar(), false);
    this.f.setText(localUser.getUserName());
    float f1 = new BigDecimal(localUser.getOnlineTime() / 3600.0F).setScale(1, 1).floatValue();
    this.g.setVisibility(0);
    this.g.setText(String.format("%.1f%s", new Object[] { Float.valueOf(f1), getResources().getString(2131100603) }));
  }
  
  private void f()
  {
    User localUser = User.getInstance();
    this.b.a(localUser.getLoverAvatar(), false);
    this.c.setText(localUser.getLoverUserName());
    float f1 = new BigDecimal(localUser.getLoverOnlineTime() / 3600.0F).setScale(1, 1).floatValue();
    this.d.setVisibility(0);
    this.d.setText(String.format("%.1f%s", new Object[] { Float.valueOf(f1), getResources().getString(2131100603) }));
  }
  
  public void a()
  {
    boolean bool = true;
    if (this.h)
    {
      this.a.clearAnimation();
      w.b(this.a);
      a.c("isExpanded={}", new Object[] { Boolean.valueOf(this.h) });
      if (this.h) {
        break label80;
      }
    }
    for (;;)
    {
      this.h = bool;
      return;
      this.a.clearAnimation();
      w.a(this.a);
      invalidate();
      requestLayout();
      break;
      label80:
      bool = false;
    }
  }
  
  public void a(View paramView)
  {
    this.a = paramView.findViewById(2131559551);
    this.b = ((AvatarView)paramView.findViewById(2131559434));
    this.c = ((TextView)paramView.findViewById(2131559554));
    this.d = ((TextView)paramView.findViewById(2131559555));
    this.e = ((AvatarView)paramView.findViewById(2131559558));
    this.f = ((TextView)paramView.findViewById(2131559559));
    this.g = ((TextView)paramView.findViewById(2131559560));
    e();
    f();
    this.a.setVisibility(8);
    this.h = false;
  }
  
  public void b()
  {
    e();
    f();
  }
  
  public void c() {}
  
  public void setUserModeChangeListener(a parama)
  {
    this.i = parama;
  }
  
  public static abstract interface a {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\view\UserInfoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */