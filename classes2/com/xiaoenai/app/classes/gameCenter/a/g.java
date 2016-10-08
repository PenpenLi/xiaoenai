package com.xiaoenai.app.classes.gameCenter.a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class g
  extends BaseAdapter
{
  private Activity a;
  private List<String> b;
  
  public g(Activity paramActivity)
  {
    this.a = paramActivity;
    this.b = new ArrayList();
  }
  
  public void a(String paramString)
  {
    this.b.add(paramString);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if ((this.b != null) && (this.b.size() > 0)) {
      return this.b.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = null;
    if (this.a != null)
    {
      paramView = this.a.getLayoutInflater().inflate(2130903227, null);
      paramViewGroup = (TextView)paramView.findViewById(2131559347);
      View localView = paramView.findViewById(2131559345);
      paramViewGroup.setText((CharSequence)this.b.get(paramInt));
      if (paramInt == 0) {
        localView.setVisibility(4);
      }
    }
    return paramView;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */