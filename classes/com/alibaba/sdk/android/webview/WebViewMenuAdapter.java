package com.alibaba.sdk.android.webview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.alibaba.sdk.android.util.ResourceUtils;
import java.util.List;

public class WebViewMenuAdapter
  extends BaseAdapter
{
  private Context context;
  private List<MenuItem> titleList;
  
  public WebViewMenuAdapter(Context paramContext, List<MenuItem> paramList)
  {
    this.context = paramContext;
    this.titleList = paramList;
  }
  
  public int getCount()
  {
    if (this.titleList == null) {
      return 0;
    }
    return this.titleList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.titleList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = ((Activity)this.context).getLayoutInflater().inflate(ResourceUtils.getRLayout(this.context, "com_taobao_tae_sdk_web_view_menu_item"), paramViewGroup, false);
      paramViewGroup = new ViewHolder();
      paramViewGroup.titleTV = ((TextView)paramView.findViewById(ResourceUtils.getIdentifier(this.context, "id", "com_taobao_tae_sdk_web_view_menu_item_title")));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      MenuItem localMenuItem = (MenuItem)this.titleList.get(paramInt);
      paramViewGroup.titleTV.setText(localMenuItem.title);
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
    }
  }
  
  static class ViewHolder
  {
    TextView titleTV;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\WebViewMenuAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */