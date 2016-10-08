package com.xiaoenai.app.classes.forum.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.ads.a;
import com.xiaoenai.app.model.Forum.Post;
import java.util.List;

public class h
  extends BaseAdapter
{
  private List<a> a;
  
  public void a(List<a> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(paramViewGroup.getContext(), 2130903218, null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131559312));
      paramViewGroup.b = paramView.findViewById(2131559196);
      paramView.setTag(paramViewGroup);
      String str = ((Post)this.a.get(paramInt)).c;
      paramViewGroup.a.setText(str);
      paramViewGroup = paramViewGroup.b;
      if (paramInt != 0) {
        break label108;
      }
    }
    label108:
    for (paramInt = 0;; paramInt = 8)
    {
      paramViewGroup.setVisibility(paramInt);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
  }
  
  private static class a
  {
    TextView a;
    View b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */