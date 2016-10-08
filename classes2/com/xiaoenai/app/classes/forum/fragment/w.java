package com.xiaoenai.app.classes.forum.fragment;

import android.widget.ImageButton;
import com.marshalchen.ultimaterecyclerview.a;
import com.marshalchen.ultimaterecyclerview.b;

class w
  implements b
{
  w(NewForumTopicsFragment paramNewForumTopicsFragment, int paramInt) {}
  
  public void a() {}
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((paramInt <= this.a * 2) || (NewForumTopicsFragment.a(this.b) <= paramInt)) {
        break label46;
      }
      this.b.mFloatingButton.setVisibility(0);
    }
    for (;;)
    {
      NewForumTopicsFragment.a(this.b, paramInt);
      return;
      label46:
      this.b.mFloatingButton.setVisibility(8);
    }
  }
  
  public void a(a parama) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\fragment\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */