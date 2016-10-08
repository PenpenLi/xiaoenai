package com.alibaba.sdk.android.webview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.PaintDrawable;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.ResourceUtils;
import java.util.List;

public class WebViewMenu
  extends PopupWindow
{
  private Context context;
  private WebViewMenuAdapter menuAdapter;
  private List<MenuItem> menuItemList;
  private ListView menuListView;
  
  public WebViewMenu(Activity paramActivity)
  {
    super(paramActivity);
    this.context = paramActivity;
    this.menuListView = ((ListView)((LayoutInflater)paramActivity.getSystemService("layout_inflater")).inflate(ResourceUtils.getRLayout(paramActivity, "com_taobao_tae_sdk_web_view_menu"), null));
    this.menuListView.setOnItemClickListener(new WebViewMenu.1(this));
    setContentView(this.menuListView);
    setWidth(CommonUtils.dp2px(paramActivity, 200.0F));
    setHeight(-2);
    setFocusable(true);
    setTouchable(true);
    this.menuListView.setFocusable(true);
    this.menuListView.setFocusableInTouchMode(true);
    setBackgroundDrawable(new PaintDrawable());
    setOutsideTouchable(true);
    this.menuListView.setOnKeyListener(new WebViewMenu.2(this));
  }
  
  public void setAdapter(List<MenuItem> paramList)
  {
    this.menuItemList = paramList;
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.menuAdapter = new WebViewMenuAdapter(this.context, paramList);
      this.menuListView.setAdapter(this.menuAdapter);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\WebViewMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */