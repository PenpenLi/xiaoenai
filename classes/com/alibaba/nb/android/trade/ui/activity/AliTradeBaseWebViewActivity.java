package com.alibaba.nb.android.trade.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.utils.g;
import com.alibaba.sdk.android.callback.CallbackContext;
import com.alibaba.sdk.android.web.impl.CookieManagerWrapper;
import java.io.Serializable;
import java.util.Map;

public class AliTradeBaseWebViewActivity
  extends Activity
{
  private static final String g = AliTradeBaseWebViewActivity.class.getSimpleName();
  protected WebView a;
  protected com.alibaba.nb.android.trade.web.a.c b;
  public TextView c;
  public boolean d;
  private View e;
  private View f;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    CallbackContext.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (this.b.b())
    {
      this.b.g();
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    super.onCreate(paramBundle);
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(g.a(this, "layout", "com_taobao_nb_sdk_web_view_activity"), null);
    Object localObject1;
    if (getIntent() != null) {
      localObject1 = getIntent().getSerializableExtra("ui_contextParams");
    }
    for (;;)
    {
      this.a = new WebView(this);
      WebView localWebView = this.a;
      if ((localObject1 instanceof Map))
      {
        localObject1 = (Map)localObject1;
        label75:
        this.b = new com.alibaba.nb.android.trade.web.a.c(localWebView, (Map)localObject1);
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        localLinearLayout.addView(this.a, (ViewGroup.LayoutParams)localObject1);
        setContentView(localLinearLayout);
        this.c = ((TextView)findViewById(g.a(this, "id", "com_taobao_nb_sdk_web_view_title_bar_title")));
        this.f = findViewById(g.a(this, "id", "com_taobao_nb_sdk_web_view_title_bar_close_button"));
        if (this.f != null) {
          this.f.setOnClickListener(new a(this));
        }
        localObject1 = findViewById(g.a(this, "id", "com_taobao_nb_sdk_web_view_title_bar_back_button"));
        if (localObject1 != null) {
          ((View)localObject1).setOnClickListener(new b(this));
        }
        localObject1 = findViewById(g.a(this, "id", "com_taobao_tae_sdk_web_view_title_bar_more_button"));
        if (localObject1 != null) {
          ((View)localObject1).setOnClickListener(new c(this));
        }
        this.e = findViewById(g.a(this, "id", "com_taobao_tae_sdk_web_view_title_bar"));
        if (paramBundle == null) {
          break label381;
        }
        localObject1 = paramBundle.getString("title");
      }
      for (paramBundle = paramBundle.getString("title");; paramBundle = (Bundle)localObject2)
      {
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = AliTradeContext.title;
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          this.d = true;
        }
        for (;;)
        {
          localObject1 = paramBundle;
          if (TextUtils.isEmpty(paramBundle)) {
            localObject1 = getIntent().getStringExtra("url");
          }
          com.alibaba.nb.android.trade.utils.d.a.b(g, "AliTrade SDK WebView首次加载的url=" + (String)localObject1);
          CookieManagerWrapper.INSTANCE.refreshCookie((String)localObject1);
          this.a.loadUrl((String)localObject1);
          return;
          if (paramBundle == null) {
            break label388;
          }
          localObject1 = paramBundle.getSerializable("ui_contextParams");
          break;
          localObject1 = null;
          break label75;
          this.d = false;
          this.c.setText((CharSequence)localObject2);
        }
        label381:
        localObject1 = null;
      }
      label388:
      localObject1 = null;
    }
  }
  
  protected void onDestroy()
  {
    if (this.a != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.a.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.a);
      }
      this.a.removeAllViews();
      this.a.destroy();
    }
    super.onDestroy();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("url", this.a.getUrl());
    paramBundle.putString("title", this.c.getText().toString());
    paramBundle.putSerializable("ui_contextParams", (Serializable)this.b.c());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\ui\activity\AliTradeBaseWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */