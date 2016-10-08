package com.xiaoenai.app.classes.common.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.share.ShareInfo;
import com.xiaoenai.app.classes.common.share.ap;
import com.xiaoenai.app.classes.common.share.at;
import com.xiaoenai.app.classes.forum.ForumReplyActivity;
import com.xiaoenai.app.classes.forum.dm;
import com.xiaoenai.app.classes.forum.presenter.x;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.classes.settings.account.SettingPhoneInputActivity;
import com.xiaoenai.app.classes.street.pay.StreetPayBaseActivity;
import com.xiaoenai.app.classes.street.pay.a.a.a;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.Forum.d;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.stat.StatEntry;
import com.xiaoenai.app.ui.component.view.webview.XeaWebView;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.al;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.d.ac;
import com.xiaoenai.app.widget.TitleBarView;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
public class WebViewActivity
  extends StreetPayBaseActivity
  implements com.xiaoenai.app.classes.common.o
{
  private String A;
  private String B;
  com.xiaoenai.app.ui.component.view.webview.a a = null;
  Handler b = new c(this);
  private XeaWebView i;
  private TextView j;
  private TextView k;
  private String l = null;
  private String m = null;
  @BindView(2131559071)
  Button mDebugBtn;
  @BindView(2131559070)
  EditText mDebugEdit;
  @BindView(2131558622)
  View mDebugLayout;
  @BindView(2131559066)
  RelativeLayout mNonVideoLayout;
  @BindView(2131558669)
  View mProgressView;
  @BindView(2131559072)
  RelativeLayout mVideoLayout;
  private Boolean n = Boolean.valueOf(false);
  private Boolean o = Boolean.valueOf(true);
  private WebViewClient s = null;
  private String t;
  private String u = "";
  private com.xiaoenai.app.classes.street.widget.o v = null;
  private long[] w = null;
  private int x = 0;
  private String y;
  private String z;
  
  private void a(int paramInt1, int paramInt2)
  {
    if (dm.a(this, paramInt2))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("forum_topic_id", paramInt1);
      localIntent.putExtra("forum_Reply_type", paramInt2);
      localIntent.setClass(this, ForumReplyActivity.class);
      startActivityForResult(localIntent, 1);
      overridePendingTransition(2130968608, 2130968609);
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        String str = new URL(paramString).getHost();
        Object localObject = this.i.getTag(2131558426);
        if (str.contains("xiaoenai"))
        {
          new Thread(new b(this, str, paramString)).start();
          return;
        }
        if ((localObject != null) && (localObject.toString().equals(str)))
        {
          com.xiaoenai.app.h.a.a.a().a(this, "mzd_http_dns_error_4xx_v2");
          this.i.setTag(2131558426, null);
          return;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void a(Uri paramUri)
  {
    if (paramUri != null)
    {
      paramUri = com.xiaoenai.app.utils.g.a().a(paramUri.toString());
      com.xiaoenai.app.net.n localn = new com.xiaoenai.app.net.n(new n(this, this));
      com.xiaoenai.app.utils.f.a.c("upload img:{}", new Object[] { paramUri });
      com.xiaoenai.app.utils.f.a.c("uploadtoken:{}", new Object[] { this.z });
      com.xiaoenai.app.utils.f.a.c("uploadurl:{}", new Object[] { this.y });
      if ((this.y != null) && (paramUri != null) && (this.z != null)) {
        localn.a(paramUri, this.y, this.z, true);
      }
    }
  }
  
  private void a(ShareInfo paramShareInfo, String paramString)
  {
    com.xiaoenai.app.classes.common.share.p localp = new com.xiaoenai.app.classes.common.share.p();
    if ((paramShareInfo != null) && (paramShareInfo.h() != null))
    {
      if (paramShareInfo.h().length == 1) {
        localp.a(paramShareInfo, Xiaoenai.j().getString(2131099955), this.i.getContext(), new at(this.i, paramString), this.i, paramString, new ap(this.i, paramString));
      }
    }
    else {
      return;
    }
    localp.a(paramShareInfo, Xiaoenai.j().getString(2131099955), this.i.getContext(), new s(this, this.i, paramString), this.i, paramString);
  }
  
  private void a(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = com.xiaoenai.app.net.a.b.b(paramString1);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (String)((List)localObject).get(0);
        Message localMessage = new Message();
        Bundle localBundle = new Bundle();
        localBundle.putString("ip_url", paramString2.replace(paramString1, (CharSequence)localObject));
        localBundle.putString("host", paramString1);
        localBundle.putString("ip", (String)localObject);
        localMessage.setData(localBundle);
        this.b.handleMessage(localMessage);
      }
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!UserConfig.getBoolean("THIRD_PARTY_CLAIM_" + paramString1, Boolean.valueOf(false)).booleanValue()))
    {
      com.xiaoenai.app.ui.a.k localk = new com.xiaoenai.app.ui.a.k(this);
      localk.e(1);
      localk.c(null);
      localk.d(com.xiaoenai.app.ui.a.k.i);
      localk.a();
      localk.a(paramString2);
      localk.b(paramString3);
      localk.d(2131100618, new r(this, paramString1));
      localk.show();
    }
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    Object localObject;
    if (localIntent != null)
    {
      localObject = localIntent.getStringExtra("param");
      if (ae.a((String)localObject)) {
        break label218;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (!((JSONObject)localObject).has("url")) {
          continue;
        }
        this.l = ((JSONObject)localObject).optString("url");
        if (((JSONObject)localObject).has("title")) {
          this.m = ((JSONObject)localObject).optString("title");
        }
        if (((JSONObject)localObject).has("id")) {
          a(((JSONObject)localObject).optString("id"), ((JSONObject)localObject).optString("alert_title"), ((JSONObject)localObject).optString("alert_content"));
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      if (!ae.a(this.l)) {
        this.l = n(this.l);
      }
      this.n = Boolean.valueOf(localIntent.getBooleanExtra("need_confirm", false));
      this.o = Boolean.valueOf(localIntent.getBooleanExtra("has_refresh_button", true));
      this.f = localIntent.getIntExtra("back_anim", 2);
      this.t = localIntent.getStringExtra("from");
      return;
      if (((JSONObject)localObject).has("click_url"))
      {
        this.l = ((JSONObject)localObject).optString("click_url");
        continue;
        label218:
        this.l = localIntent.getStringExtra("url");
        this.m = localIntent.getStringExtra("title");
      }
    }
  }
  
  private void d()
  {
    this.g.b(null, getString(2131101025));
    this.g.setRightButtonEnable(true);
  }
  
  private void d(String paramString)
  {
    int i1 = 0;
    paramString = al.a(paramString.substring(paramString.indexOf("?", 0) + 1, paramString.length()));
    this.y = paramString.getString("url");
    this.z = paramString.getString("token");
    try
    {
      int i2 = Integer.parseInt(paramString.getString("type"));
      i1 = i2;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    a(i1);
  }
  
  private void f()
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(this);
    localg.a(String.format(getString(2131100341), new Object[] { this.m }));
    localg.a(2131100898, new e(this));
    localg.b(2131099973, new f(this));
  }
  
  private void f(String paramString)
  {
    paramString = al.b(paramString).getString("params");
    if (!ae.a(paramString)) {}
    try
    {
      g(new JSONObject(paramString).optString("title"));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void g()
  {
    this.v = new com.xiaoenai.app.classes.street.widget.o(this);
    this.v.a(new g(this));
  }
  
  private void g(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramString.trim()))) {
      this.k.setText(paramString);
    }
  }
  
  private a.a h()
  {
    return new i(this);
  }
  
  private void h(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    try
    {
      localIntent.setData(Uri.parse(paramString));
      startActivity(localIntent);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void i(String paramString)
  {
    ShareInfo localShareInfo = null;
    Object localObject1 = al.b(paramString);
    paramString = ((Bundle)localObject1).getString("params");
    if (!ae.a(paramString)) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramString);
        str7 = ((JSONObject)localObject1).optString("title");
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          str6 = ((JSONObject)localObject1).optString("content");
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            String str7;
            Object localObject2;
            paramString = null;
            str1 = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            String str6 = null;
          }
        }
        try
        {
          str5 = ((JSONObject)localObject1).optString("image_url");
        }
        catch (JSONException localJSONException3)
        {
          paramString = null;
          str1 = null;
          str2 = null;
          str3 = null;
          str4 = null;
          str5 = null;
          break label244;
        }
        try
        {
          str4 = ((JSONObject)localObject1).optString("short_content");
        }
        catch (JSONException localJSONException4)
        {
          paramString = null;
          str1 = null;
          str2 = null;
          str3 = null;
          str4 = null;
          break label244;
        }
        try
        {
          str3 = ((JSONObject)localObject1).optString("thumb_image_url");
        }
        catch (JSONException localJSONException5)
        {
          paramString = null;
          str1 = null;
          str2 = null;
          str3 = null;
          break label244;
        }
        try
        {
          str2 = ((JSONObject)localObject1).optString("share_url");
        }
        catch (JSONException localJSONException6)
        {
          paramString = null;
          str1 = null;
          str2 = null;
          break label244;
        }
        try
        {
          str1 = ((JSONObject)localObject1).optString("redirect_url");
        }
        catch (JSONException localJSONException7)
        {
          paramString = null;
          str1 = null;
          break label244;
        }
        try
        {
          paramString = ((JSONObject)localObject1).optString("show");
        }
        catch (JSONException localJSONException8)
        {
          paramString = null;
          break label244;
        }
        try
        {
          localObject1 = ((JSONObject)localObject1).optString("share_id");
          if ((str7 != null) && (str6 != null) && (str5 != null))
          {
            localShareInfo = new ShareInfo();
            localShareInfo.a(str7);
            localShareInfo.b(str6);
            localShareInfo.c(str5);
            localShareInfo.d(str4);
            localShareInfo.e(str3);
            localShareInfo.f(str2);
            localShareInfo.g(str1);
            localShareInfo.b(4);
            if ((paramString != null) && (!paramString.equals(""))) {
              localShareInfo.a(paramString.split(","));
            }
            a(localShareInfo, (String)localObject1);
          }
          return;
        }
        catch (JSONException localJSONException9)
        {
          break label244;
        }
        localJSONException1 = localJSONException1;
        paramString = null;
        str1 = null;
        str2 = null;
        str3 = null;
        str4 = null;
        str5 = null;
        str6 = null;
        str7 = null;
      }
      label244:
      localObject2 = localShareInfo;
      continue;
      str7 = ((Bundle)localObject2).getString("title");
      str6 = ((Bundle)localObject2).getString("content");
      str5 = ((Bundle)localObject2).getString("image_url");
      str4 = ((Bundle)localObject2).getString("short_content");
      str3 = ((Bundle)localObject2).getString("thumb_image_url");
      str2 = ((Bundle)localObject2).getString("share_url");
      str1 = ((Bundle)localObject2).getString("redirect_url");
      paramString = ((Bundle)localObject2).getString("show");
      localObject2 = ((Bundle)localObject2).getString("share_id");
    }
  }
  
  private void j(String paramString)
  {
    paramString = al.b(paramString).getString("params");
    if (!ae.a(paramString)) {}
    try
    {
      paramString = ac.a(com.xiaoenai.app.net.c.a.l.e(new JSONObject(paramString)).toString());
      this.i.loadUrl("javascript:signCallback('" + com.xiaoenai.app.utils.d.c.a(paramString) + "')");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void k(String paramString)
  {
    paramString = al.b(paramString).getString("params");
    if (!ae.a(paramString)) {
      try
      {
        Object localObject = new JSONObject(paramString);
        this.x = ((JSONObject)localObject).optInt("price");
        paramString = ((JSONObject)localObject).optString("pay_channel");
        localObject = ((JSONObject)localObject).optJSONArray("order_ids");
        this.w = ((long[])new com.google.gson.j().a(((JSONArray)localObject).toString(), new h(this).getType()));
        if (ae.a(paramString))
        {
          this.v.show();
          return;
        }
        this.c.a(new com.xiaoenai.app.classes.street.pay.a.g(this, this.w, paramString, this.x));
        this.c.a();
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void l(String paramString)
  {
    paramString = al.b(paramString).getString("params");
    if (!ae.a(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      int i2 = paramString.optInt("id");
      if (paramString.optInt("type") == 0) {}
      for (int i1 = 1;; i1 = 2)
      {
        a(i2, i1);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void m(String paramString)
  {
    paramString = al.b(paramString).getString("params");
    if (!ae.a(paramString)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int i2 = paramString.optInt("id");
        int i3 = paramString.optInt("post_id");
        int i4 = paramString.optInt("post_number");
        if (paramString.optInt("type") != 0) {
          break label131;
        }
        i1 = 3;
        Object localObject = null;
        paramString = (String)localObject;
        if (i3 > 0)
        {
          paramString = (String)localObject;
          if (i4 > 0)
          {
            paramString = new d();
            paramString.b = i3;
            paramString.e = i4;
          }
        }
        if (i1 == 3)
        {
          x.a(this, paramString, i2, 4);
          return;
        }
        x.a(this, paramString, i2, 3);
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label131:
      int i1 = 4;
    }
  }
  
  private String n(String paramString)
  {
    Object localObject2 = paramString;
    if (paramString.startsWith("http://"))
    {
      localObject2 = paramString;
      localObject1 = paramString;
    }
    try
    {
      String str;
      long l1;
      if (new URL(paramString).getHost().contains("xiaoenai"))
      {
        localObject1 = paramString;
        str = Xiaoenai.j().D;
        localObject1 = paramString;
        l1 = System.currentTimeMillis() / 1000L + AppSettings.getInt("client_server_adjust", Integer.valueOf(0)).intValue();
        localObject1 = paramString;
        if (!paramString.contains("?")) {
          break label315;
        }
        localObject1 = paramString;
      }
      for (paramString = paramString + "&ts=" + l1;; paramString = paramString + "?ts=" + l1)
      {
        localObject1 = paramString;
        localObject2 = paramString + "&access_token=" + AppModel.getInstance().getToken() + "&lang=" + as.i() + "_" + as.j() + "&xea_os=android" + "&irv=" + com.xiaoenai.app.stat.h.a().b() + "&xea_app_ver=" + Xiaoenai.j().B + "&xea_net=" + com.xiaoenai.app.utils.d.o.f(Xiaoenai.j());
        paramString = (String)localObject2;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = localObject2;
          paramString = (String)localObject2 + "&xea_channel=" + str;
        }
        localObject1 = paramString;
        localObject2 = al.c(paramString.substring(paramString.indexOf("?") + 1));
        localObject1 = paramString;
        try
        {
          localObject2 = paramString + "&sig=" + com.xiaoenai.app.utils.d.h.a((JSONObject)localObject2, AppModel.getInstance().getSigKey());
          return (String)localObject2;
        }
        catch (JSONException localJSONException)
        {
          label315:
          localObject1 = paramString;
          localJSONException.printStackTrace();
          return paramString;
        }
        localObject1 = paramString;
      }
      return (String)localObject1;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void o(String paramString)
  {
    paramString = al.b(paramString).getString("params");
    if (!ae.a(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      this.A = paramString.optString("successed_url");
      this.B = paramString.optString("failed_url");
      paramString = new Intent();
      paramString.setClass(this, SettingPhoneInputActivity.class);
      startActivityForResult(paramString, 4099);
      overridePendingTransition(2130968604, 2130968605);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int a()
  {
    return 2130903170;
  }
  
  protected final void a(int paramInt)
  {
    if (!com.xiaoenai.app.download.c.b.a()) {
      com.xiaoenai.app.ui.a.h.c(this, 2131101069, 1500L);
    }
    while ((this.z == null) || (this.y == null)) {
      return;
    }
    com.xiaoenai.app.classes.common.dialog.e locale = new com.xiaoenai.app.classes.common.dialog.e(this);
    if ((paramInt == 0) || (2 == paramInt)) {
      locale.a(2131100091, 1, new j(this, locale));
    }
    if ((paramInt == 0) || (1 == paramInt)) {
      locale.a(2131100088, 1, new k(this, locale));
    }
    locale.show();
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    d();
    g(this.m);
    com.xiaoenai.app.utils.f.a.a(true, "WebView onReceivedError errorCode = {} descripetion = {} failingUrl = {}", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    if (com.xiaoenai.app.h.a.a.a().a(this, "mzd_http_dns_enable", false))
    {
      a(paramInt, paramString2);
      return;
    }
    com.xiaoenai.app.h.a.a.a().a(this, "mzd_http_dns_error_4xx_v2");
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    d();
    g(paramWebView.getTitle());
  }
  
  public void a(StatEntry paramStatEntry)
  {
    paramStatEntry.setExpand(this.l);
  }
  
  protected void b()
  {
    super.b();
    this.g.setLeftButtonClickListener(new t(this));
    this.g.setRightButtonClickListener(new u(this));
    if (this.o.booleanValue())
    {
      this.g.setRightButtonVisible(0);
      return;
    }
    this.g.setRightButtonVisible(8);
  }
  
  public void b(String paramString)
  {
    this.mDebugEdit.setText(paramString);
  }
  
  public void c(String paramString)
  {
    g(paramString);
  }
  
  public void finish()
  {
    if ((this.m != null) && (this.m.length() > 0) && ((this.m.equals(UserConfig.getString("street_topic_page_title", ""))) || (this.m.equals(getResources().getString(2131101502)))))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("data", this.u);
      setResult(-1, localIntent);
    }
    super.finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 259)
    {
      if (paramInt2 == -1) {
        com.xiaoenai.app.ui.a.h.a(this, 2131100491, 1500L);
      }
      return;
    }
    Object localObject;
    if (paramInt1 == 257)
    {
      localObject = new JSONObject();
      if ((paramInt2 != -1) || (paramIntent == null)) {
        break label356;
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = paramIntent.getStringExtra("forum_reply_name");
        if (paramIntent == null) {
          break label356;
        }
        paramIntent = new JSONObject(paramIntent);
        if (paramInt2 == -1) {
          bool = true;
        }
      }
      catch (JSONException localJSONException2)
      {
        boolean bool;
        paramIntent = (Intent)localObject;
        localObject = localJSONException2;
      }
      try
      {
        paramIntent.put("result", bool);
        this.i.loadUrl("javascript:replyCallback('" + ac.a(paramIntent.toString()) + "')");
        return;
      }
      catch (JSONException localJSONException1)
      {
        for (;;) {}
      }
      bool = false;
      continue;
      ((JSONException)localObject).printStackTrace();
      continue;
      if (paramInt1 == 4099)
      {
        if (paramInt2 == 9)
        {
          com.xiaoenai.app.ui.a.h.a(this, 2131101172, 1500L);
          this.i.loadUrl(n(this.A));
        }
        for (;;)
        {
          this.i.postDelayed(new l(this), 500L);
          return;
          this.i.loadUrl(this.B);
        }
      }
      if ((21 != paramInt1) && (5 != paramInt1)) {
        break;
      }
      localObject = null;
      if ((paramInt2 != -1) || (paramIntent == null)) {
        break;
      }
      switch (paramInt1)
      {
      default: 
        paramIntent = (Intent)localObject;
      }
      for (;;)
      {
        a(paramIntent);
        return;
        String[] arrayOfString = paramIntent.getStringArrayExtra("image_url_array");
        paramIntent = (Intent)localObject;
        if (arrayOfString != null)
        {
          paramIntent = (Intent)localObject;
          if (arrayOfString.length > 0)
          {
            com.xiaoenai.app.utils.f.a.c("path = {}", new Object[] { arrayOfString[0] });
            paramIntent = Uri.parse(arrayOfString[0]);
            continue;
            paramIntent = paramIntent.getData();
          }
        }
      }
      label356:
      paramIntent = localJSONException1;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ButterKnife.bind(this);
    c();
    this.s = new a(this);
    this.a = new m(this, this.mNonVideoLayout, this.mVideoLayout, this.mProgressView, this.i);
    this.a.a(new o(this));
    this.i = ((XeaWebView)findViewById(2131558741));
    this.i.setWebChromeClient(this.a);
    this.i.setWebViewClient(this.s);
    this.i.setScrollBarStyle(0);
    int i1 = UserConfig.getInt("chat_title_color_index", Integer.valueOf(0)).intValue();
    paramBundle = getResources().getStringArray(2131427338);
    try
    {
      if (paramBundle.length > i1)
      {
        i1 = com.xiaoenai.app.utils.d.s.a(this, paramBundle[i1]);
        this.i.setProgressbarColor(getResources().getColor(i1));
      }
      this.i.setProgressbarSize(com.xiaoenai.app.utils.d.t.a(this, 4.0F));
      this.k = ((TextView)findViewById(2131559069));
      this.j = ((TextView)findViewById(2131559068));
      g(this.m);
      this.j.setOnClickListener(new p(this));
      paramBundle = this.i.getSettings();
      paramBundle.setJavaScriptEnabled(true);
      paramBundle.setDomStorageEnabled(true);
      paramBundle.setAppCacheMaxSize(8388608L);
      paramBundle.setAppCachePath(getApplicationContext().getDir("cache", 0).getPath());
      paramBundle.setAllowFileAccess(true);
      paramBundle.setAppCacheEnabled(true);
      paramBundle.setDatabaseEnabled(true);
      paramBundle.setDatabasePath("/data/data/" + this.i.getContext().getPackageName() + "/databases/");
      paramBundle.setCacheMode(-1);
      paramBundle.setSupportZoom(true);
      paramBundle.setBuiltInZoomControls(true);
      paramBundle.setUseWideViewPort(true);
      paramBundle.setUserAgentString(paramBundle.getUserAgentString() + " MZDW/1.0");
      com.xiaoenai.app.utils.f.a.c("userAgentString = {}", new Object[] { paramBundle.getUserAgentString() });
      if (Build.VERSION.SDK_INT >= 11) {
        paramBundle.setDisplayZoomControls(false);
      }
      paramBundle.setLoadWithOverviewMode(true);
      com.xiaoenai.app.utils.f.a.c("url = {}", new Object[] { this.l });
      if (this.l == null)
      {
        paramBundle = getIntent().getData();
        if ((paramBundle != null) && (Uri.parse("xiaoenai://profile").getScheme().equals(paramBundle.getScheme()))) {
          this.l = paramBundle.getQueryParameter("url");
        }
      }
      this.i.loadUrl(this.l);
      if (Build.VERSION.SDK_INT >= 19) {}
      this.mDebugBtn.setOnClickListener(new q(this));
      paramBundle = this.mDebugLayout;
      if (AppSettings.getBoolean(AppSettings.getString("setting_environment", getResources().getStringArray(2131427329)[0]), Boolean.valueOf(false)).booleanValue())
      {
        i1 = 0;
        paramBundle.setVisibility(i1);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        continue;
        i1 = 8;
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.i != null)
    {
      this.i.destroyDrawingCache();
      this.i.stopLoading();
      this.i.freeMemory();
      this.i.destroy();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.n.booleanValue()) {
        f();
      }
      for (;;)
      {
        return true;
        if (!this.a.a()) {
          r();
        }
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void r()
  {
    if (this.i.canGoBack())
    {
      this.j.setVisibility(0);
      this.i.goBack();
      return;
    }
    if ((this.t != null) && (this.t.length() > 0))
    {
      if (!this.t.equalsIgnoreCase("ads")) {
        break label83;
      }
      Intent localIntent = new Intent();
      localIntent.setClass(this, HomeActivity.class);
      startActivity(localIntent);
    }
    for (;;)
    {
      super.r();
      return;
      label83:
      if (HomeActivity.class.getName().equals(this.t)) {
        this.f = 1;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\webview\WebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */