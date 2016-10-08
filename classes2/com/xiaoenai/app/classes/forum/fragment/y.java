package com.xiaoenai.app.classes.forum.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.forum.ForumNotifyActivity;

class y
  implements View.OnClickListener
{
  y(NewForumTopicsFragment paramNewForumTopicsFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.getActivity(), ForumNotifyActivity.class);
    paramView.putExtra("key_is_new", true);
    paramView.putExtra("key_is_from_forum", true);
    this.a.getActivity().startActivity(paramView);
    this.a.getActivity().overridePendingTransition(2130968604, 2130968605);
    this.a.a = true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\fragment\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */