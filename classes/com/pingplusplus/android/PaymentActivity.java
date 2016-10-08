package com.pingplusplus.android;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.paysdk.api.BaiduPay;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.unionpay.UPPayAssistEx;
import com.unionpay.uppay.PayActivity;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentActivity
  extends Activity
  implements IWXAPIEventHandler
{
  public static final String EXTRA_CHARGE = "com.pingplusplus.android.PaymentActivity.CHARGE";
  public static final String EXTRA_CREDENTIAL = "com.pingplusplus.android.PaymentActivity.CREDENTIAL";
  private static String e = "https://m.jdpay.com/wepay/web/pay";
  WebViewClient a = new c(this);
  WebViewClient b = new d(this);
  WebViewClient c = new e(this);
  private IWXAPI d = null;
  private int f = 0;
  private int g = 0;
  private ProgressDialog h = null;
  private String i = "cancel";
  private JSONObject j;
  private Handler k = new f(this);
  
  private void a(int paramInt, String paramString)
  {
    if (paramString == null)
    {
      a("cancel", "user_cancelled");
      return;
    }
    paramInt = paramString.indexOf("statecode=");
    paramString = paramString.substring("statecode={".length() + paramInt, paramString.indexOf("};order_no="));
    if (paramString.equals("0"))
    {
      a("success");
      return;
    }
    if (paramString.equals("1"))
    {
      a("in_process");
      return;
    }
    if ((paramString.equals("2")) || (paramString.equals("7")))
    {
      a("cancel", "user_cancelled");
      return;
    }
    if (paramString.equals("3"))
    {
      a("fail", "bfb_not_supported_method");
      return;
    }
    if (paramString.equals("4"))
    {
      a("fail", "bfb_token_expired");
      return;
    }
    a("fail", "unknown_error");
  }
  
  private void a(String paramString)
  {
    a(paramString, "");
  }
  
  private void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, "");
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    i.a().b(null);
    Intent localIntent = new Intent();
    localIntent.putExtra("pay_result", paramString1);
    localIntent.putExtra("error_msg", paramString2);
    localIntent.putExtra("extra_msg", paramString3);
    setResult(-1, localIntent);
    finish();
  }
  
  private void a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("alipay");
    PingppLog.d("PaymentActivity start alipay credential : " + paramJSONObject);
    new a(this, localJSONObject.getString("orderInfo")).start();
  }
  
  private boolean a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    return ((paramString2 == null) || (paramString2.equals(paramString1))) && (paramJSONObject.has(paramString1)) && (!paramJSONObject.getString(paramString1).equals("[]")) && (!paramJSONObject.getString(paramString1).equals("{}"));
  }
  
  private void b(String paramString1, String paramString2)
  {
    PingppLog.d("模拟支付页面: 支付渠道" + paramString2);
    WebView localWebView = new WebView(this);
    localWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setContentView(localWebView);
    WebSettings localWebSettings = localWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setUserAgentString(String.format("%s; %s/%s", new Object[] { localWebSettings.getUserAgentString(), "PingppAndroidSDK", "2.0.5" }));
    localWebView.addJavascriptInterface(new g(this, this), "PingppAndroidSDK");
    localWebView.setWebViewClient(this.a);
    localWebView.loadUrl(String.format("http://sissi.pingxx.com/mock.php?ch_id=%s&channel=%s", new Object[] { paramString1, paramString2 }));
    this.h = ProgressDialog.show(this, "", "Loading", true);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("wx");
    PingppLog.d("PaymentActivity start wx credential : " + paramJSONObject);
    paramJSONObject = localJSONObject.getString("appId");
    i.a().a(paramJSONObject);
    this.d = WXAPIFactory.createWXAPI(this, paramJSONObject);
    if (!this.d.isWXAppInstalled())
    {
      a("invalid", "wx_app_not_installed");
      return;
    }
    int m;
    PayReq localPayReq;
    if (this.d.getWXAppSupportAPI() >= 570425345)
    {
      m = 1;
      if (m == 0) {
        break label274;
      }
      this.f = 1;
      this.d.registerApp(paramJSONObject);
      this.d.handleIntent(getIntent(), this);
      localPayReq = new PayReq();
      localPayReq.appId = paramJSONObject;
      localPayReq.partnerId = localJSONObject.getString("partnerId");
      localPayReq.prepayId = localJSONObject.getString("prepayId");
      localPayReq.nonceStr = localJSONObject.getString("nonceStr");
      if (!(localJSONObject.get("timeStamp") instanceof String)) {
        break label242;
      }
    }
    label242:
    for (localPayReq.timeStamp = localJSONObject.getString("timeStamp");; localPayReq.timeStamp = (localJSONObject.getInt("timeStamp") + ""))
    {
      localPayReq.packageValue = localJSONObject.getString("packageValue");
      localPayReq.sign = localJSONObject.getString("sign");
      this.d.sendReq(localPayReq);
      return;
      m = 0;
      break;
    }
    label274:
    a("fail", "wx_app_not_support");
  }
  
  private void c(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject;
    if (paramJSONObject.has("upacp"))
    {
      localJSONObject = paramJSONObject.getJSONObject("upacp");
      PingppLog.d("PaymentActivity start upacp credential : " + paramJSONObject);
    }
    for (paramJSONObject = localJSONObject;; paramJSONObject = localJSONObject)
    {
      UPPayAssistEx.startPayByJAR(this, PayActivity.class, null, null, paramJSONObject.getString("tn"), paramJSONObject.getString("mode"));
      return;
      localJSONObject = paramJSONObject.getJSONObject("upmp");
      PingppLog.d("PaymentActivity start upmp credential : " + paramJSONObject);
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.getJSONObject("bfb");
    PingppLog.d("PaymentActivity start bfb credential : " + paramJSONObject);
    paramJSONObject = new HashMap();
    paramJSONObject.put("cashier_type", "0");
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = ((JSONObject)localObject).keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(str);
      localArrayList2.add(((JSONObject)localObject).getString(str));
      localArrayList1.add(TextUtils.join("=", localArrayList2));
    }
    if (localArrayList1.size() == 0)
    {
      a("fail", "invalid_credential");
      return;
    }
    localObject = TextUtils.join("&", localArrayList1);
    this.g = 1;
    BaiduPay.getInstance().doPay(this, (String)localObject, new b(this), paramJSONObject);
  }
  
  private void e(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.getJSONObject("yeepay_wap");
    PingppLog.d("PaymentActivity start yeepay_wap credential : " + paramJSONObject);
    String str1 = ((JSONObject)localObject).getString("merchantaccount");
    String str2 = URLEncoder.encode(((JSONObject)localObject).getString("encryptkey"));
    String str3 = URLEncoder.encode(((JSONObject)localObject).getString("data"));
    paramJSONObject = ((JSONObject)localObject).getString("mode");
    localObject = new WebView(this);
    ((WebView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setContentView((View)localObject);
    WebSettings localWebSettings = ((WebView)localObject).getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setUserAgentString(String.format("%s; %s/%s", new Object[] { localWebSettings.getUserAgentString(), "PingppAndroidSDK", "2.0.5" }));
    ((WebView)localObject).addJavascriptInterface(new h(this), "PingppAndroidSDK");
    ((WebView)localObject).setWebViewClient(this.b);
    if ("live".equals(paramJSONObject)) {}
    for (paramJSONObject = "https://ok.yeepay.com/paymobile/api/pay/request?merchantaccount=%s&encryptkey=%s&data=%s";; paramJSONObject = "http://mobiletest.yeepay.com/paymobile/api/pay/request?merchantaccount=%s&encryptkey=%s&data=%s")
    {
      ((WebView)localObject).loadUrl(String.format(paramJSONObject, new Object[] { str1, str2, str3 }));
      this.h = ProgressDialog.show(this, "", "Loading", true);
      return;
    }
  }
  
  private void f(JSONObject paramJSONObject)
  {
    Object localObject1 = paramJSONObject.getJSONObject("jdpay_wap");
    PingppLog.d("PaymentActivity start jdpay_wap credential : " + paramJSONObject);
    paramJSONObject = new WebView(this);
    paramJSONObject.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setContentView(paramJSONObject);
    Object localObject2 = paramJSONObject.getSettings();
    ((WebSettings)localObject2).setJavaScriptEnabled(true);
    ((WebSettings)localObject2).setUserAgentString(String.format("%s; %s/%s", new Object[] { ((WebSettings)localObject2).getUserAgentString(), "PingppAndroidSDK", "2.0.5" }));
    paramJSONObject.addJavascriptInterface(new h(this), "PingppAndroidSDK");
    paramJSONObject.setWebViewClient(this.c);
    localObject2 = new ArrayList();
    Iterator localIterator = ((JSONObject)localObject1).keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str);
      localArrayList.add(URLEncoder.encode(((JSONObject)localObject1).getString(str)));
      ((List)localObject2).add(TextUtils.join("=", localArrayList));
    }
    if (((List)localObject2).size() == 0)
    {
      a("fail", "invalid_credential");
      return;
    }
    localObject1 = TextUtils.join("&", (Iterable)localObject2);
    PingppLog.d("jdPay orderInfo: " + (String)localObject1);
    paramJSONObject.postUrl(e, ((String)localObject1).getBytes());
    this.h = ProgressDialog.show(this, "", "Loading", true);
  }
  
  public static String getVersion()
  {
    return "2.0.5";
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((i.a().c() != null) && (!i.a().c().equalsIgnoreCase("upmp")) && (!i.a().c().equalsIgnoreCase("upacp"))) {
      return;
    }
    if (paramIntent == null)
    {
      a("fail", "");
      return;
    }
    paramIntent = paramIntent.getExtras().getString("pay_result");
    if (paramIntent == null)
    {
      a("fail");
      return;
    }
    if (paramIntent.equalsIgnoreCase("success"))
    {
      a("success");
      return;
    }
    if (paramIntent.equalsIgnoreCase("fail"))
    {
      a("fail", "channel_returns_fail");
      return;
    }
    if (paramIntent.equalsIgnoreCase("cancel"))
    {
      a("cancel", "user_cancelled");
      return;
    }
    a("fail", "unknown_error");
  }
  
  public void onBackPressed()
  {
    i.a().b(null);
    Intent localIntent = new Intent();
    localIntent.putExtra("pay_result", this.i);
    setResult(-1, localIntent);
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {}
    label226:
    label240:
    label298:
    do
    {
      return;
      this.j = null;
      paramBundle = getIntent();
      str = paramBundle.getStringExtra("com.pingplusplus.android.PaymentActivity.CHARGE");
      PingppLog.d("PaymentActivity receive charge: " + str);
      if (str != null) {}
      try
      {
        this.j = new JSONObject(str);
        if (!this.j.has("credential")) {
          break label240;
        }
        str = this.j.getString("channel");
        try
        {
          if ((!this.j.has("livemode")) || (this.j.getBoolean("livemode"))) {
            break label226;
          }
          b(this.j.getString("id"), str);
          return;
        }
        catch (JSONException paramBundle) {}
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          str = null;
        }
      }
      a("fail", "invalid_charge_json_decode_fail");
      paramBundle = null;
      while (paramBundle != null)
      {
        i.a().b(str);
        PingppLog.d("PaymentActivity receive channel: " + str);
        try
        {
          if ((!a(paramBundle, "upmp", str)) && (!a(paramBundle, "upacp", str))) {
            break label298;
          }
          c(paramBundle);
          return;
        }
        catch (JSONException paramBundle)
        {
          i.a().b(null);
          a("fail", "invalid_credential");
          return;
        }
        paramBundle = this.j.getJSONObject("credential");
        continue;
        a("fail", "invalid_charge_no_credential");
        paramBundle = null;
        str = null;
        continue;
        paramBundle = paramBundle.getStringExtra("com.pingplusplus.android.PaymentActivity.CREDENTIAL");
        if (paramBundle != null)
        {
          try
          {
            paramBundle = new JSONObject(paramBundle);
            str = null;
          }
          catch (JSONException paramBundle)
          {
            a("fail", "invalid_credential_json_decode_fail");
          }
        }
        else
        {
          paramBundle = null;
          str = null;
          continue;
          if (a(paramBundle, "wx", str))
          {
            b(paramBundle);
            return;
          }
          if (a(paramBundle, "alipay", str))
          {
            a(paramBundle);
            return;
          }
          if (a(paramBundle, "bfb", str))
          {
            d(paramBundle);
            return;
          }
          if (a(paramBundle, "yeepay_wap", str))
          {
            e(paramBundle);
            return;
          }
          if (a(paramBundle, "jdpay_wap", str))
          {
            f(paramBundle);
            return;
          }
          i.a().b(null);
          a("fail", "invalid_charge_no_such_channel");
          return;
        }
      }
      paramBundle = i.a().b();
    } while (paramBundle == null);
    this.d = WXAPIFactory.createWXAPI(this, paramBundle);
    this.d.handleIntent(getIntent(), this);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (this.d != null)
    {
      setIntent(paramIntent);
      this.d.handleIntent(paramIntent, this);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.f == 1) {
      this.f = 2;
    }
    while ((this.g != 1) || (i.a().c() == null) || (!i.a().c().equalsIgnoreCase("bfb"))) {
      return;
    }
    this.g = 2;
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp)
  {
    if (paramBaseResp.getType() == 5)
    {
      PingppLog.d("PaymentActivity wx result errCode : " + paramBaseResp.errCode + " , errStr:" + paramBaseResp.errStr);
      this.f = 0;
      if (paramBaseResp.errCode == 0) {
        a("success");
      }
    }
    else
    {
      return;
    }
    if (paramBaseResp.errCode == -2)
    {
      a("cancel", "user_cancelled");
      return;
    }
    a("fail", "channel_returns_fail", "wx_err_code:" + paramBaseResp.errCode);
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((this.f == 2) || (this.g == 2)) {
      a("cancel", "user_cancelled");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\pingplusplus\android\PaymentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */