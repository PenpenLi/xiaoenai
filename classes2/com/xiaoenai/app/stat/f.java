package com.xiaoenai.app.stat;

import android.view.View;
import android.view.View.OnClickListener;

public abstract class f
  implements View.OnClickListener
{
  private String a;
  private String b;
  
  public f(String paramString)
  {
    this.b = paramString;
  }
  
  public f(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public void onClick(View paramView)
  {
    StatEntry localStatEntry = new StatEntry();
    j.a().a(localStatEntry, paramView.getContext(), this.a, this.b);
    h.a().a(localStatEntry);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\stat\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */