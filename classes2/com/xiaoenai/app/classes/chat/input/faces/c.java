package com.xiaoenai.app.classes.chat.input.faces;

import android.widget.GridView;
import android.widget.ListAdapter;
import com.xiaoenai.app.widget.CustomViewPager;

class c
  implements t.a
{
  c(a parama, GridView paramGridView) {}
  
  public String a(int paramInt)
  {
    return (String)this.a.getAdapter().getItem(paramInt);
  }
  
  public void a(String paramString)
  {
    this.b.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (a.c(this.b) != null) {
      a.c(this.b).setPagingEnabled(paramBoolean);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\faces\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */