package com.xiaoenai.app.ui.a;

import android.content.Context;
import android.widget.TextView;

public class g
  extends k
{
  public g(Context paramContext)
  {
    super(paramContext);
    e(1);
    super.setTitle(-1);
    super.c("");
  }
  
  public void a(int paramInt)
  {
    c(paramInt);
  }
  
  public void a(int paramInt, k.a parama)
  {
    d(paramInt, parama);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || ("".equals(paramCharSequence)))
    {
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
    this.d.setText(paramCharSequence);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
  }
  
  public void a(String paramString, k.a parama)
  {
    b(paramString, parama);
  }
  
  public void b(int paramInt)
  {
    this.d.setGravity(paramInt);
  }
  
  public void b(int paramInt, k.a parama)
  {
    a(getContext().getString(paramInt), parama);
  }
  
  public void setTitle(int paramInt)
  {
    super.setTitle(paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\ui\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */