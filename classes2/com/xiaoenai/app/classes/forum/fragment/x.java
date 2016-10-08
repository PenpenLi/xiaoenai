package com.xiaoenai.app.classes.forum.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.marshalchen.ultimaterecyclerview.RefreshCustomUltimateRecyclerview;

class x
  implements View.OnClickListener
{
  x(NewForumTopicsFragment paramNewForumTopicsFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.mRecyclerview.e.scrollToPosition(0);
    this.a.mFloatingButton.setVisibility(8);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\fragment\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */