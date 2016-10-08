package com.xiaoenai.app.classes.common.dialog.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.xiaoenai.app.classes.common.dialog.e;

public class j
{
  private Context a;
  private e b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  private View j;
  private View k;
  
  public j(Context paramContext)
  {
    this.a = paramContext;
    this.b = new e(paramContext);
    this.c = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903143, null);
    a(this.c);
    this.b.a(this.c);
  }
  
  private void a(View paramView)
  {
    this.d = paramView.findViewById(2131558963);
    this.d.setOnClickListener(new k(this));
    this.e = paramView.findViewById(2131558964);
    this.e.setOnClickListener(new l(this));
    this.f = paramView.findViewById(2131558965);
    this.f.setOnClickListener(new m(this));
    this.g = paramView.findViewById(2131558966);
    this.g.setOnClickListener(new n(this));
    this.h = paramView.findViewById(2131558967);
    this.h.setOnClickListener(new o(this));
    this.i = paramView.findViewById(2131558968);
    this.i.setOnClickListener(new p(this));
    this.j = paramView.findViewById(2131558969);
    this.j.setOnClickListener(new q(this));
    this.k = paramView.findViewById(2131558970);
    this.k.setOnClickListener(new r(this));
  }
  
  public void a()
  {
    this.b.dismiss();
  }
  
  public void a(int paramInt)
  {
    this.b.setTitle(paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\dialog\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */