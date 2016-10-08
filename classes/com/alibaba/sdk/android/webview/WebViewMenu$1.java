package com.alibaba.sdk.android.webview;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.List;

class WebViewMenu$1
  implements AdapterView.OnItemClickListener
{
  WebViewMenu$1(WebViewMenu paramWebViewMenu) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((MenuItem)WebViewMenu.access$000(this.this$0).get(paramInt)).onClickListener.onClick(paramView);
    this.this$0.dismiss();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\WebViewMenu$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */