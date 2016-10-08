package com.xiaoenai.app.classes.common.dialog.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class a
{
  private Context a;
  private com.xiaoenai.app.classes.common.dialog.e b;
  private View c = null;
  private ImageButton d = null;
  private ImageButton e = null;
  private ImageButton f = null;
  private ImageButton g = null;
  private ImageButton h = null;
  private ImageButton i = null;
  private ImageButton j = null;
  private ImageButton k = null;
  
  public a(Context paramContext, String[] paramArrayOfString)
  {
    this.a = paramContext;
    this.b = new com.xiaoenai.app.classes.common.dialog.e(paramContext);
    this.c = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903142, null);
    a(this.c, paramArrayOfString);
    this.b.a(this.c);
  }
  
  private void a(View paramView, String[] paramArrayOfString)
  {
    int i1 = paramArrayOfString.length;
    int m = 0;
    int n = 0;
    if (m < i1)
    {
      String str = paramArrayOfString[m];
      n += 1;
      paramView.findViewById(c(n)).setVisibility(0);
      if (str.equals("wxs"))
      {
        this.d = ((ImageButton)paramView.findViewById(b(n)));
        this.d.setOnClickListener(new b(this));
        this.d.setImageResource(2130837773);
        ((TextView)paramView.findViewById(d(n))).setText(2131101267);
      }
      for (;;)
      {
        m += 1;
        break;
        if (str.equals("wxt"))
        {
          this.e = ((ImageButton)paramView.findViewById(b(n)));
          this.e.setOnClickListener(new c(this));
          ((TextView)paramView.findViewById(d(n))).setText(2131101268);
          this.e.setImageResource(2130837774);
        }
        else if (str.equals("sinawb"))
        {
          this.f = ((ImageButton)paramView.findViewById(b(n)));
          this.f.setOnClickListener(new d(this));
          ((TextView)paramView.findViewById(d(n))).setText(2131101263);
          this.f.setImageResource(2130837770);
        }
        else if (str.equals("tencentwb"))
        {
          this.g = ((ImageButton)paramView.findViewById(b(n)));
          this.g.setOnClickListener(new e(this));
          ((TextView)paramView.findViewById(d(n))).setText(2131101266);
          this.g.setImageResource(2130837772);
        }
        else if (str.equals("qq"))
        {
          this.h = ((ImageButton)paramView.findViewById(b(n)));
          this.h.setOnClickListener(new f(this));
          ((TextView)paramView.findViewById(d(n))).setText(2131101259);
          this.h.setImageResource(2130837767);
        }
        else if (str.equals("qzone"))
        {
          this.i = ((ImageButton)paramView.findViewById(b(n)));
          this.i.setOnClickListener(new g(this));
          ((TextView)paramView.findViewById(d(n))).setText(2131101261);
          this.i.setImageResource(2130837768);
        }
        else if (str.equals("renren"))
        {
          this.j = ((ImageButton)paramView.findViewById(b(n)));
          this.j.setOnClickListener(new h(this));
          ((TextView)paramView.findViewById(d(n))).setText(2131101262);
          this.j.setImageResource(2130837769);
        }
        else if (str.equals("sms"))
        {
          this.k = ((ImageButton)paramView.findViewById(b(n)));
          this.k.setOnClickListener(new i(this));
          ((TextView)paramView.findViewById(d(n))).setText(2131101264);
          this.k.setImageResource(2130837771);
        }
      }
    }
    if (n < 5)
    {
      paramView.findViewById(2131558949).setVisibility(8);
      paramView.findViewById(2131558962).setVisibility(0);
    }
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return 2131558960;
    case 1: 
      return 2131558938;
    case 2: 
      return 2131558941;
    case 3: 
      return 2131558944;
    case 4: 
      return 2131558947;
    case 5: 
      return 2131558951;
    case 6: 
      return 2131558954;
    }
    return 2131558957;
  }
  
  private int c(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return 2131558959;
    case 1: 
      return 2131558937;
    case 2: 
      return 2131558940;
    case 3: 
      return 2131558943;
    case 4: 
      return 2131558946;
    case 5: 
      return 2131558950;
    case 6: 
      return 2131558953;
    }
    return 2131558956;
  }
  
  private int d(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return 2131558961;
    case 1: 
      return 2131558939;
    case 2: 
      return 2131558942;
    case 3: 
      return 2131558945;
    case 4: 
      return 2131558948;
    case 5: 
      return 2131558952;
    case 6: 
      return 2131558955;
    }
    return 2131558958;
  }
  
  public void a()
  {
    this.b.show();
  }
  
  public void a(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (this.d != null) {
      this.d.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(String paramString)
  {
    this.b.a(paramString);
  }
  
  public void b()
  {
    this.b.dismiss();
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    if (this.e != null) {
      this.e.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void c(View.OnClickListener paramOnClickListener)
  {
    if (this.f != null) {
      this.f.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void d(View.OnClickListener paramOnClickListener)
  {
    if (this.h != null) {
      this.h.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void e(View.OnClickListener paramOnClickListener)
  {
    if (this.i != null) {
      this.i.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\dialog\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */