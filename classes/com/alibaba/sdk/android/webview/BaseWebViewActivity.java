package com.alibaba.sdk.android.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.callback.CallbackContext;
import com.alibaba.sdk.android.callback.FailureCallback;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.UIContext;
import com.alibaba.sdk.android.ui.support.ActivityResultHandler;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.ResourceUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseWebViewActivity
  extends Activity
{
  public static final String IMAGEPATH = "imagePath";
  public boolean canReceiveTitle;
  private Handler handler = new Handler();
  protected TaeWebView taeWebView;
  private View titleBar;
  private TextView titleText;
  
  private void onBackHistory()
  {
    if (UIContext.historyHelper != null) {
      try
      {
        if (!UIContext.historyHelper.goBack(this.taeWebView))
        {
          Intent localIntent1 = new Intent();
          setResult(ResultCode.USER_CANCEL.code, localIntent1);
          finish();
        }
        return;
      }
      catch (Exception localException)
      {
        AliSDKLogger.e("ui", "fail to go back", localException);
      }
    }
    if (this.taeWebView.canGoBack())
    {
      this.taeWebView.goBack();
      return;
    }
    Intent localIntent2 = new Intent();
    setResult(ResultCode.USER_CANCEL.code, localIntent2);
    finish();
  }
  
  private void openMenu()
  {
    if (TextUtils.isEmpty(this.taeWebView.getUrl())) {
      return;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new MenuItem();
    ((MenuItem)localObject2).title = "复制链接";
    ((MenuItem)localObject2).onClickListener = new BaseWebViewActivity.4(this);
    ((List)localObject1).add(localObject2);
    localObject2 = new MenuItem();
    ((MenuItem)localObject2).title = "在浏览器中打开";
    ((MenuItem)localObject2).onClickListener = new BaseWebViewActivity.5(this);
    ((List)localObject1).add(localObject2);
    localObject2 = new MenuItem();
    ((MenuItem)localObject2).title = "清除 WebView 缓存";
    ((MenuItem)localObject2).onClickListener = new BaseWebViewActivity.6(this);
    ((List)localObject1).add(localObject2);
    localObject2 = new MenuItem();
    ((MenuItem)localObject2).title = "报告问题";
    ((MenuItem)localObject2).onClickListener = new BaseWebViewActivity.7(this);
    ((List)localObject1).add(localObject2);
    localObject2 = new WebViewMenu(this);
    ((WebViewMenu)localObject2).setAdapter((List)localObject1);
    localObject1 = new int[2];
    this.titleBar.getLocationOnScreen((int[])localObject1);
    ((WebViewMenu)localObject2).showAtLocation(this.taeWebView, 53, 0, localObject1[1] + this.titleBar.getHeight());
  }
  
  private void showFeedbackActivity()
  {
    BaseWebViewActivity.8 local8 = new BaseWebViewActivity.8(this);
    CommonUtils.startInitWaitTask(this, new BaseWebViewActivity.9(this), local8, null);
  }
  
  protected TaeWebView createTaeWebView()
  {
    return new TaeWebView(this);
  }
  
  protected WebChromeClient createWebChromeClient()
  {
    return new BaseWebViewActivity.10(this);
  }
  
  protected WebViewClient createWebViewClient()
  {
    return new BaseWebViewClient();
  }
  
  protected boolean isBackPressedAsHistoryBack()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (UIContext.pluginConfigurations != null)
    {
      bool1 = bool2;
      if (UIContext.pluginConfigurations.getBooleanValue("backPressedAsHistoryBack", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ActivityResultHandler localActivityResultHandler = (ActivityResultHandler)UIContext.appContext.getService(ActivityResultHandler.class, Collections.singletonMap("requestCodeKey", String.valueOf(paramInt1)));
    if (localActivityResultHandler != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(WebView.class, this.taeWebView);
      localActivityResultHandler.onActivityResult(2, paramInt1, paramInt2, paramIntent, this, localHashMap);
    }
  }
  
  public void onBackPressed()
  {
    if (isBackPressedAsHistoryBack())
    {
      onBackHistory();
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    super.onCreate(paramBundle);
    Object localObject1 = (LinearLayout)getLayoutInflater().inflate(ResourceUtils.getRLayout(this, "com_taobao_tae_sdk_web_view_activity"), null);
    this.taeWebView = createTaeWebView();
    this.taeWebView.setWebViewClient(createWebViewClient());
    this.taeWebView.setWebChromeClient(createWebChromeClient());
    Object localObject3 = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout)localObject1).addView(this.taeWebView, (ViewGroup.LayoutParams)localObject3);
    setContentView((View)localObject1);
    this.titleText = ((TextView)findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_tae_sdk_web_view_title_bar_title")));
    localObject1 = findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_tae_sdk_web_view_title_bar_close_button"));
    if (localObject1 != null)
    {
      ((View)localObject1).setVisibility(4);
      ((View)localObject1).setOnClickListener(new BaseWebViewActivity.1(this));
    }
    localObject3 = findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_tae_sdk_web_view_title_bar_back_button"));
    if (localObject3 != null) {
      ((View)localObject3).setOnClickListener(new BaseWebViewActivity.2(this, (View)localObject1));
    }
    localObject1 = findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_tae_sdk_web_view_title_bar_more_button"));
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener(new BaseWebViewActivity.3(this));
    }
    this.titleBar = findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_tae_sdk_web_view_title_bar"));
    if (getIntent() != null) {
      localObject1 = getIntent().getSerializableExtra("ui_contextParams");
    }
    for (;;)
    {
      if ((localObject1 instanceof Map)) {
        this.taeWebView.getContextParameters().putAll((Map)localObject1);
      }
      if (paramBundle != null) {
        localObject1 = paramBundle.getString("title");
      }
      for (paramBundle = paramBundle.getString("url");; paramBundle = (Bundle)localObject2)
      {
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = getIntent().getStringExtra("title");
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          this.canReceiveTitle = true;
        }
        for (;;)
        {
          localObject1 = paramBundle;
          if (TextUtils.isEmpty(paramBundle)) {
            localObject1 = getIntent().getStringExtra("url");
          }
          this.taeWebView.loadUrl((String)localObject1);
          return;
          if (paramBundle == null) {
            break label381;
          }
          localObject1 = paramBundle.getSerializable("ui_contextParams");
          break;
          this.canReceiveTitle = false;
          this.titleText.setText((CharSequence)localObject2);
        }
        localObject1 = null;
      }
      label381:
      localObject1 = null;
    }
  }
  
  protected void onDestroy()
  {
    if (this.taeWebView != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.taeWebView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.taeWebView);
      }
      this.taeWebView.removeAllViews();
      this.taeWebView.destroy();
    }
    super.onDestroy();
  }
  
  protected void onFailure(ResultCode paramResultCode)
  {
    CommonUtils.onFailure((FailureCallback)CallbackContext.tradeProcessCallback, paramResultCode);
    finish();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("url", this.taeWebView.getUrl());
    paramBundle.putString("title", this.titleText.getText().toString());
    paramBundle.putSerializable("ui_contextParams", this.taeWebView.getContextParameters());
  }
  
  public void setResult(ResultCode paramResultCode)
  {
    onFailure(paramResultCode);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\BaseWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */