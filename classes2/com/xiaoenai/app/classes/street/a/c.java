package com.xiaoenai.app.classes.street.a;

import com.xiaoenai.app.classes.street.widget.StreetCommentLayout;
import com.xiaoenai.app.classes.street.widget.StreetCommentLayout.a;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.swipeLayout.SwipeLayout;
import com.xiaoenai.app.widget.swipeLayout.SwipeLayout.i;

class c
  implements SwipeLayout.i
{
  c(b paramb, StreetCommentLayout paramStreetCommentLayout) {}
  
  public void a(SwipeLayout paramSwipeLayout) {}
  
  public void a(SwipeLayout paramSwipeLayout, float paramFloat1, float paramFloat2) {}
  
  public void a(SwipeLayout paramSwipeLayout, int paramInt1, int paramInt2) {}
  
  public void b(SwipeLayout paramSwipeLayout)
  {
    if (b.a(this.b) != null)
    {
      bool = true;
      a.c("null != preRevealLayout {}", new Object[] { Boolean.valueOf(bool) });
      if (b.a(this.b) == this.a) {
        break label119;
      }
    }
    label119:
    for (boolean bool = true;; bool = false)
    {
      a.c("preRevealLayout != mallCommentLayout {}", new Object[] { Boolean.valueOf(bool) });
      if ((b.a(this.b) != null) && (b.a(this.b) != this.a)) {
        b.a(this.b).getViewHolder().a.b(true);
      }
      b.a(this.b, this.a);
      return;
      bool = false;
      break;
    }
  }
  
  public void c(SwipeLayout paramSwipeLayout) {}
  
  public void d(SwipeLayout paramSwipeLayout) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */