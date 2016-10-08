package com.xiaoenai.app.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.ui.component.view.AvatarView;
import com.xiaoenai.app.utils.d.t;
import com.xiaoenai.app.utils.e.d.b;

public class k
  extends a
{
  public static int i = Color.parseColor("#4AD557");
  public static int j = -65536;
  protected LinearLayout a;
  protected AvatarView b;
  protected TextView c;
  protected TextView d;
  protected View e;
  protected Button f;
  protected Button g;
  protected View h;
  protected a k;
  protected a l;
  private boolean m = false;
  
  public k(Context paramContext)
  {
    super(paramContext, j.d.CommonDialog);
    this.h = LayoutInflater.from(paramContext).inflate(j.c.dialog_tip, null);
    a(this.h);
  }
  
  private void a(View paramView)
  {
    this.a = ((LinearLayout)paramView.findViewById(j.b.tip_dialog_layout));
    this.b = ((AvatarView)paramView.findViewById(j.b.dialogAvatar));
    this.c = ((TextView)paramView.findViewById(j.b.message_name));
    this.d = ((TextView)paramView.findViewById(j.b.messageText));
    this.e = paramView.findViewById(j.b.divider_vertival);
    this.f = ((Button)paramView.findViewById(j.b.buttonLeft));
    this.g = ((Button)paramView.findViewById(j.b.buttonRight));
    this.f.setOnClickListener(new l(this));
    this.g.setOnClickListener(new m(this));
  }
  
  public void a()
  {
    this.d.setGravity(0);
  }
  
  public void a(int paramInt1, int paramInt2, a parama1, int paramInt3, a parama2)
  {
    e(1);
    setTitle(-1);
    c("");
    c(paramInt1);
    c(paramInt2, parama1);
    d(paramInt3, parama2);
    show();
  }
  
  public void a(int paramInt1, a parama1, int paramInt2, a parama2, String paramString, b paramb)
  {
    e(3);
    setTitle(-1);
    c(-1);
    a(paramString, paramb);
    c(paramInt1, parama1);
    d(paramInt2, parama2);
    show();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, a parama1, int paramInt3, a parama2)
  {
    e(1);
    b(paramString);
    c("");
    setTitle(paramInt1);
    c(paramInt2, parama1);
    d(paramInt3, parama2);
    show();
  }
  
  public void a(Spanned paramSpanned)
  {
    if (paramSpanned == null)
    {
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
    this.d.setText(paramSpanned);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.c.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
    this.c.setText(paramString);
  }
  
  public void a(String paramString, int paramInt1, a parama1, int paramInt2, a parama2)
  {
    e(1);
    setTitle(-1);
    c("");
    b(paramString);
    c(paramInt1, parama1);
    d(paramInt2, parama2);
    show();
  }
  
  public void a(String paramString, b paramb)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.b.setVisibility(8);
      return;
    }
    this.b.setVisibility(0);
    this.b.a(paramString, paramb);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, a parama1, int paramInt3, a parama2)
  {
    e(2);
    a(paramString2);
    c(paramInt1);
    d(i);
    c(paramString1);
    c(paramInt2, parama1);
    d(paramInt3, parama2);
    show();
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
    this.d.setText(paramString);
  }
  
  public void b(String paramString, a parama)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.f.setText(paramString);
      this.g.setBackgroundResource(j.a.tipdialog_right_btn_bg);
      this.l = parama;
      this.f.setVisibility(0);
      this.e.setVisibility(0);
      return;
    }
    this.f.setVisibility(8);
  }
  
  public void c(int paramInt)
  {
    if (-1 == paramInt)
    {
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
    String str = getContext().getResources().getString(paramInt);
    this.d.setText(str);
  }
  
  public void c(int paramInt, a parama)
  {
    String str = getContext().getResources().getString(paramInt);
    if (!TextUtils.isEmpty(str))
    {
      this.f.setText(str);
      this.g.setBackgroundResource(j.a.tipdialog_right_btn_bg);
      this.l = parama;
      this.f.setVisibility(0);
      this.e.setVisibility(0);
      return;
    }
    this.f.setVisibility(8);
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.b.setVisibility(8);
      return;
    }
    this.b.setVisibility(0);
    this.b.setRoundedImage(paramString);
  }
  
  public void d(int paramInt)
  {
    this.g.setTextColor(paramInt);
  }
  
  public void d(int paramInt, a parama)
  {
    String str = getContext().getResources().getString(paramInt);
    this.g.setText(str);
    this.k = parama;
  }
  
  public void e(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.c.getLayoutParams();
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.m = true;
      return;
      paramInt = t.a(getContext(), 18.0F);
      this.a.setPadding(paramInt, paramInt, paramInt, paramInt);
      this.c.setTextSize(18.0F);
      localLayoutParams1.setMargins(0, 0, 0, 0);
      this.c.setLayoutParams(localLayoutParams1);
      continue;
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(t.a(getContext(), 68.0F), t.a(getContext(), 68.0F));
      this.b.setLayoutParams(localLayoutParams2);
      this.a.setPadding(0, t.a(getContext(), 40.0F), 0, t.a(getContext(), 40.0F));
      this.c.setTextSize(16.0F);
      localLayoutParams1.setMargins(0, t.a(getContext(), 18.0F), 0, 0);
      this.c.setLayoutParams(localLayoutParams1);
      continue;
      localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams2 = new LinearLayout.LayoutParams(t.a(getContext(), 260.0F), t.a(getContext(), 174.0F));
      localLayoutParams2.gravity = 17;
      this.b.setLayoutParams(localLayoutParams2);
      paramInt = t.a(getContext(), 18.0F);
      this.a.setPadding(paramInt, paramInt, paramInt, paramInt);
      this.a.setLayoutParams(localLayoutParams1);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.h);
  }
  
  public void setTitle(int paramInt)
  {
    if (-1 == paramInt)
    {
      this.c.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
    String str = getContext().getResources().getString(paramInt);
    this.c.setText(str);
  }
  
  public void show()
  {
    if (this.m)
    {
      super.show();
      return;
    }
    com.xiaoenai.app.utils.f.a.a("tipDialog 的 setType()方法没有调用 ", new Object[0]);
  }
  
  public static abstract interface a
  {
    public abstract void a(k paramk, View paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\ui\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */