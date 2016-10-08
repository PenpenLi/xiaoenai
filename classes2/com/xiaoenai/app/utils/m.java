package com.xiaoenai.app.utils;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;

public class m
{
  public static void a(ListView paramListView)
  {
    ListAdapter localListAdapter = paramListView.getAdapter();
    if (localListAdapter == null) {
      return;
    }
    int i = 0;
    int k;
    for (int j = 0; i < localListAdapter.getCount(); j = k)
    {
      localObject = localListAdapter.getView(i, null, paramListView);
      k = j;
      if (localObject != null)
      {
        ((View)localObject).measure(0, 0);
        k = j + ((View)localObject).getMeasuredHeight();
      }
      i += 1;
    }
    Object localObject = paramListView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + j + 120);
    paramListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */