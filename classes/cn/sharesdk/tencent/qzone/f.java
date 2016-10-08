package cn.sharesdk.tencent.qzone;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.a.a;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import com.mob.tools.a.l;
import com.mob.tools.b.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class f
  extends cn.sharesdk.framework.e
{
  private static final String[] b = { "get_user_info", "get_simple_userinfo", "get_user_profile", "get_app_friends", "add_share", "list_album", "upload_pic", "add_album", "set_user_face", "get_vip_info", "get_vip_rich_info", "get_intimate_friends_weibo", "match_nick_tips_weibo", "add_t", "add_pic_t" };
  private static f c;
  private String d;
  private String e;
  private String f;
  private a g = a.a();
  private String[] h;
  
  private f(Platform paramPlatform)
  {
    super(paramPlatform);
  }
  
  public static f a(Platform paramPlatform)
  {
    if (c == null) {
      c = new f(paramPlatform);
    }
    return c;
  }
  
  private String b()
  {
    int i = 0;
    if (this.h == null) {}
    StringBuilder localStringBuilder;
    for (String[] arrayOfString = b;; arrayOfString = this.h)
    {
      localStringBuilder = new StringBuilder();
      int k = arrayOfString.length;
      int j = 0;
      while (i < k)
      {
        String str = arrayOfString[i];
        if (j > 0) {
          localStringBuilder.append(',');
        }
        localStringBuilder.append(str);
        j += 1;
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public HashMap<String, Object> a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.mob.tools.a.i("access_token", this.f));
    localArrayList.add(new com.mob.tools.a.i("oauth_consumer_key", this.d));
    localArrayList.add(new com.mob.tools.a.i("openid", this.e));
    localArrayList.add(new com.mob.tools.a.i("format", "json"));
    if (!TextUtils.isEmpty(paramString2))
    {
      String str = paramString2;
      if (paramString2.length() > 200) {
        str = paramString2.substring(0, 199) + "…";
      }
      localArrayList.add(new com.mob.tools.a.i("photodesc", str));
    }
    localArrayList.add(new com.mob.tools.a.i("mobile", "1"));
    paramString1 = new com.mob.tools.a.i("picture", paramString1);
    paramString2 = new ArrayList();
    paramString2.add(new com.mob.tools.a.i("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
    paramString1 = this.g.a("https://graph.qq.com/photo/upload_pic", localArrayList, paramString1, paramString2, "/photo/upload_pic", c());
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      return new com.mob.tools.b.e().a(paramString1);
    }
    return null;
  }
  
  public HashMap<String, Object> a(String paramString1, String paramString2, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    if (paramString2 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        localArrayList.add(new com.mob.tools.a.i((String)localEntry.getKey(), String.valueOf(localEntry.getValue())));
      }
    }
    localArrayList.add(new com.mob.tools.a.i("access_token", this.f));
    localArrayList.add(new com.mob.tools.a.i("oauth_consumer_key", this.d));
    localArrayList.add(new com.mob.tools.a.i("openid", this.e));
    localArrayList.add(new com.mob.tools.a.i("format", "json"));
    if ((paramHashMap1 != null) && (paramHashMap1.size() > 0))
    {
      paramHashMap1 = paramHashMap1.entrySet().iterator();
      for (paramHashMap = null; paramHashMap1.hasNext(); paramHashMap = new com.mob.tools.a.i((String)paramHashMap.getKey(), paramHashMap.getValue())) {
        paramHashMap = (Map.Entry)paramHashMap1.next();
      }
    }
    for (;;)
    {
      paramHashMap1 = new ArrayList();
      paramHashMap1.add(new com.mob.tools.a.i("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
      try
      {
        if ("GET".equals(paramString2.toUpperCase())) {}
        for (paramString1 = new l().httpGet(paramString1, localArrayList, paramHashMap1, null); (paramString1 != null) && (paramString1.length() > 0); paramString1 = new l().httpPost(paramString1, localArrayList, paramHashMap, paramHashMap1, null))
        {
          return new com.mob.tools.b.e().a(paramString1);
          if (!"POST".equals(paramString2.toUpperCase())) {
            break label384;
          }
        }
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          cn.sharesdk.framework.utils.d.a().w(paramString1);
          label384:
          paramString1 = null;
        }
      }
      paramHashMap = null;
    }
  }
  
  public void a(AuthorizeListener paramAuthorizeListener, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(paramAuthorizeListener);
      return;
    }
    a(new g(this, paramAuthorizeListener));
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, PlatformActionListener paramPlatformActionListener)
  {
    String str2 = "1";
    label23:
    String str1;
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      str2 = "3";
      break label514;
      str1 = paramString4;
      if (!TextUtils.isEmpty(paramString4))
      {
        File localFile = new File(paramString4);
        str1 = paramString4;
        if (localFile.exists())
        {
          str1 = paramString4;
          if (paramString4.startsWith("/data/"))
          {
            str1 = new File(com.mob.tools.b.g.e(this.a.getContext(), "images"), System.currentTimeMillis() + localFile.getName()).getAbsolutePath();
            if (!com.mob.tools.b.g.a(paramString4, str1)) {
              break label548;
            }
          }
        }
      }
      label132:
      paramString4 = paramString3;
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString4 = paramString3;
        if (paramString3.length() > 600) {
          paramString4 = paramString3.substring(0, 600);
        }
      }
      paramString3 = new StringBuilder();
      if (str2 != "3") {
        break label554;
      }
      paramString3.append("mqqapi://qzone/publish?src_type=app&version=1&file_type=news");
      label189:
      if (!TextUtils.isEmpty(str1)) {
        paramString3.append("&image_url=").append(Base64.encodeToString(str1.getBytes("utf-8"), 2));
      }
      if (!TextUtils.isEmpty(paramString1)) {
        paramString3.append("&title=").append(Base64.encodeToString(paramString1.getBytes("utf-8"), 2));
      }
      if (!TextUtils.isEmpty(paramString4)) {
        paramString3.append("&description=").append(Base64.encodeToString(paramString4.getBytes("utf-8"), 2));
      }
      paramString3.append("&share_id=").append(this.d);
      if (!TextUtils.isEmpty(paramString2)) {
        paramString3.append("&url=").append(Base64.encodeToString(paramString2.getBytes("utf-8"), 2));
      }
      paramString3.append("&app_name=").append(Base64.encodeToString(paramString5.getBytes("utf-8"), 2));
      if (!TextUtils.isEmpty(paramString4)) {
        paramString3.append("&share_qq_ext_str=").append(Base64.encodeToString(paramString4.getBytes(), 2));
      }
      paramString3.append("&req_type=").append(Base64.encodeToString(str2.getBytes("utf-8"), 2));
      if (!a()) {
        break label565;
      }
    }
    label514:
    label548:
    label554:
    label565:
    for (paramString1 = "1";; paramString1 = "0")
    {
      paramString3.append("&cflag=").append(Base64.encodeToString(paramString1.getBytes("utf-8"), 2));
      paramString1 = new Intent("android.intent.action.VIEW");
      paramString1.setData(Uri.parse(paramString3.toString()));
      if (this.a.getContext().getPackageManager().resolveActivity(paramString1, 1) != null)
      {
        paramString1 = new i();
        paramString1.a(paramString3.toString(), true);
        paramString1.a(paramPlatformActionListener);
        paramString1.a(this.d);
        paramString1.show(this.a.getContext(), null);
      }
      return;
      if (!TextUtils.isEmpty(paramString2)) {
        break label23;
      }
      if (paramPlatformActionListener == null) {
        break;
      }
      paramPlatformActionListener.onError(null, 9, new Throwable("The param of title or titleUrl is null !"));
      return;
      str1 = null;
      break label132;
      paramString3.append("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
      break label189;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, PlatformActionListener paramPlatformActionListener)
  {
    String str = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      str = c.a(this.a.getContext()).y();
    }
    if (str.length() > 20) {}
    for (paramString5 = str.substring(0, 20) + "...";; paramString5 = str)
    {
      if ((!TextUtils.isEmpty(paramString1)) && (paramString1.length() > 200)) {
        paramString1 = paramString1.substring(0, 200);
      }
      for (;;)
      {
        if ((paramBoolean) && (a()))
        {
          a(paramString1, paramString2, paramString3, paramString4, paramString5, paramPlatformActionListener);
          return;
        }
        b(paramString1, paramString2, paramString3, paramString4, paramString5, paramPlatformActionListener);
        return;
      }
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.h = paramArrayOfString;
  }
  
  public boolean a()
  {
    try
    {
      String str = this.a.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
      if (TextUtils.isEmpty(str)) {
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.d.a().w(localThrowable);
        Object localObject = null;
      }
    }
    return true;
  }
  
  public HashMap<String, Object> b(String paramString1, String paramString2)
  {
    int i;
    String str1;
    label19:
    String str2;
    ArrayList localArrayList;
    if (!TextUtils.isEmpty(paramString1))
    {
      i = 1;
      if (i == 0) {
        break label230;
      }
      str1 = "/t/add_pic_t";
      str2 = "https://graph.qq.com" + str1;
      localArrayList = new ArrayList();
      localArrayList.add(new com.mob.tools.a.i("oauth_consumer_key", this.d));
      localArrayList.add(new com.mob.tools.a.i("access_token", this.f));
      localArrayList.add(new com.mob.tools.a.i("openid", this.e));
      localArrayList.add(new com.mob.tools.a.i("format", "json"));
      localArrayList.add(new com.mob.tools.a.i("content", paramString2));
      if (i == 0) {
        break label237;
      }
      paramString1 = new com.mob.tools.a.i("pic", paramString1);
      paramString1 = this.g.a(str2, localArrayList, paramString1, str1, c());
    }
    for (;;)
    {
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        paramString2 = new com.mob.tools.b.e().a(paramString1);
        if (((Integer)paramString2.get("ret")).intValue() != 0)
        {
          throw new Throwable(paramString1);
          i = 0;
          break;
          label230:
          str1 = "/t/add_t";
          break label19;
          label237:
          paramString1 = this.g.b(str2, localArrayList, str1, c());
          continue;
        }
        return paramString2;
      }
    }
    return null;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, PlatformActionListener paramPlatformActionListener)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      throw new Throwable("The param of titleUrl or title is null !");
    }
    if (TextUtils.isEmpty(paramString3)) {
      throw new Throwable("text is needed");
    }
    String str = paramString3;
    if (paramString3.length() > 600) {
      str = paramString3.substring(0, 600);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://openmobile.qq.com/api/check2?");
    localStringBuilder.append("page=qzshare.html&");
    localStringBuilder.append("loginpage=loginindex.html&");
    localStringBuilder.append("logintype=qzone&");
    localStringBuilder.append("action=shareToQQ&");
    localStringBuilder.append("sdkv=2.6&");
    localStringBuilder.append("sdkp=a&");
    paramString3 = c.a(this.a.getContext());
    localStringBuilder.append("status_os=").append(com.mob.tools.b.b.c(paramString3.m(), "utf-8")).append("&");
    localStringBuilder.append("status_machine=").append(com.mob.tools.b.b.c(paramString3.d(), "utf-8")).append("&");
    localStringBuilder.append("status_version=").append(com.mob.tools.b.b.c(String.valueOf(paramString3.l()), "utf-8")).append("&");
    localStringBuilder.append("appId=").append(this.d).append("&");
    paramString3 = paramString3.y();
    if (!TextUtils.isEmpty(paramString3)) {
      localStringBuilder.append("appName=").append(com.mob.tools.b.b.c(paramString3, "utf-8")).append("&");
    }
    for (;;)
    {
      paramString3 = paramString1;
      if (paramString1.length() > 40) {
        paramString3 = paramString1.substring(40) + "...";
      }
      localStringBuilder.append("title=").append(com.mob.tools.b.b.c(paramString3, "utf-8")).append("&");
      paramString1 = str;
      if (str.length() > 80) {
        paramString1 = str.substring(80) + "...";
      }
      localStringBuilder.append("summary=").append(com.mob.tools.b.b.c(paramString1, "utf-8")).append("&");
      localStringBuilder.append("targeturl=").append(com.mob.tools.b.b.c(paramString2, "utf-8")).append("&");
      if (!TextUtils.isEmpty(paramString4)) {
        localStringBuilder.append("imageUrl=").append(com.mob.tools.b.b.c(paramString4, "utf-8")).append("&");
      }
      localStringBuilder.append("site=").append(com.mob.tools.b.b.c(paramString5, "utf-8")).append("&");
      localStringBuilder.append("type=1");
      paramString1 = new i();
      paramString1.a(localStringBuilder.toString(), false);
      paramString1.a(paramPlatformActionListener);
      paramString1.a(this.d);
      paramString1.show(this.a.getContext(), null);
      return;
      localStringBuilder.append("appName=").append(com.mob.tools.b.b.c(paramString5, "utf-8")).append("&");
    }
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public HashMap<String, Object> d(String paramString)
  {
    Object localObject1 = null;
    paramString = new ArrayList();
    paramString.add(new com.mob.tools.a.i("access_token", this.f));
    paramString.add(new com.mob.tools.a.i("oauth_consumer_key", this.d));
    paramString.add(new com.mob.tools.a.i("openid", this.e));
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new com.mob.tools.a.i("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
    localObject2 = this.g.a("https://graph.qq.com/user/get_simple_userinfo", paramString, (ArrayList)localObject2, null, "/user/get_simple_userinfo", c());
    paramString = (String)localObject1;
    if (localObject2 != null)
    {
      paramString = (String)localObject1;
      if (((String)localObject2).length() > 0) {
        paramString = new com.mob.tools.b.e().a((String)localObject2);
      }
    }
    return paramString;
  }
  
  public HashMap<String, Object> e(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(new com.mob.tools.a.i("access_token", paramString));
    paramString = new ArrayList();
    paramString.add(new com.mob.tools.a.i("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
    paramString = this.g.a("https://graph.qq.com/oauth2.0/me", (ArrayList)localObject1, paramString, null, "/oauth2.0/me", c());
    localObject1 = paramString;
    if (paramString.startsWith("callback"))
    {
      for (localObject1 = paramString;; localObject1 = ((String)localObject1).substring(1))
      {
        paramString = (String)localObject1;
        if (((String)localObject1).startsWith("{")) {
          break;
        }
        paramString = (String)localObject1;
        if (((String)localObject1).length() <= 0) {
          break;
        }
      }
      for (;;)
      {
        localObject1 = paramString;
        if (paramString.endsWith("}")) {
          break;
        }
        localObject1 = paramString;
        if (paramString.length() <= 0) {
          break;
        }
        paramString = paramString.substring(0, paramString.length() - 1);
      }
    }
    paramString = (String)localObject2;
    if (localObject1 != null)
    {
      paramString = (String)localObject2;
      if (((String)localObject1).length() > 0) {
        paramString = new com.mob.tools.b.e().a((String)localObject1);
      }
    }
    return paramString;
  }
  
  public String getAuthorizeUrl()
  {
    ShareSDK.logApiEvent("/oauth2.0/authorize", c());
    String str3 = b();
    String str1 = getRedirectUri();
    try
    {
      str1 = com.mob.tools.b.b.c(str1, "utf-8");
      return "https://graph.qq.com/oauth2.0/m_authorize?response_type=token&client_id=" + this.d + "&" + "redirect_uri=" + str1 + "&" + "display=mobile&" + "scope=" + str3;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.d.a().w(localThrowable);
        String str2 = getRedirectUri();
      }
    }
  }
  
  public cn.sharesdk.framework.authorize.b getAuthorizeWebviewClient(cn.sharesdk.framework.authorize.g paramg)
  {
    return new d(paramg);
  }
  
  public String getRedirectUri()
  {
    return "auth://tauth.qq.com/";
  }
  
  public cn.sharesdk.framework.authorize.f getSSOProcessor(cn.sharesdk.framework.authorize.e parame)
  {
    parame = new h(parame);
    parame.a(5656);
    parame.a(this.d, b());
    return parame;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\tencent\qzone\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */