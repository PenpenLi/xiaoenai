package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.b;
import com.mob.tools.a.l;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class f
  extends cn.sharesdk.framework.e
{
  private static f b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String[] g = { "follow_app_official_microblog" };
  private cn.sharesdk.framework.a.a h = cn.sharesdk.framework.a.a.a();
  private Context i;
  
  private f(Platform paramPlatform)
  {
    super(paramPlatform);
    this.i = paramPlatform.getContext();
  }
  
  public static f a(Platform paramPlatform)
  {
    try
    {
      if (b == null) {
        b = new f(paramPlatform);
      }
      paramPlatform = b;
      return paramPlatform;
    }
    finally {}
  }
  
  private HashMap<String, Object> a(String paramString, float paramFloat1, float paramFloat2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.mob.tools.a.i("source", this.c));
    localArrayList.add(new com.mob.tools.a.i("access_token", this.f));
    localArrayList.add(new com.mob.tools.a.i("status", paramString));
    localArrayList.add(new com.mob.tools.a.i("long", String.valueOf(paramFloat1)));
    localArrayList.add(new com.mob.tools.a.i("lat", String.valueOf(paramFloat2)));
    paramString = this.h.b("https://api.weibo.com/2/statuses/update.json", localArrayList, "/2/statuses/update.json", c());
    if (paramString != null) {
      return new com.mob.tools.b.e().a(paramString);
    }
    return null;
  }
  
  private HashMap<String, Object> a(String paramString1, String paramString2, float paramFloat1, float paramFloat2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.mob.tools.a.i("source", this.c));
    localArrayList.add(new com.mob.tools.a.i("access_token", this.f));
    localArrayList.add(new com.mob.tools.a.i("status", paramString1));
    localArrayList.add(new com.mob.tools.a.i("long", String.valueOf(paramFloat1)));
    localArrayList.add(new com.mob.tools.a.i("lat", String.valueOf(paramFloat2)));
    localArrayList.add(new com.mob.tools.a.i("url", paramString2));
    paramString1 = this.h.b("https://api.weibo.com/2/statuses/upload_url_text.json", localArrayList, "/2/statuses/upload_url_text.json", c());
    if (paramString1 != null) {
      return new com.mob.tools.b.e().a(paramString1);
    }
    return null;
  }
  
  private HashMap<String, Object> b(String paramString1, String paramString2, float paramFloat1, float paramFloat2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.mob.tools.a.i("source", this.c));
    localArrayList.add(new com.mob.tools.a.i("access_token", this.f));
    localArrayList.add(new com.mob.tools.a.i("status", paramString2));
    localArrayList.add(new com.mob.tools.a.i("long", String.valueOf(paramFloat1)));
    localArrayList.add(new com.mob.tools.a.i("lat", String.valueOf(paramFloat2)));
    paramString1 = new com.mob.tools.a.i("pic", paramString1);
    paramString1 = this.h.a("https://api.weibo.com/2/statuses/upload.json", localArrayList, paramString1, "/2/statuses/upload.json", c());
    if (paramString1 != null) {
      return new com.mob.tools.b.e().a(paramString1);
    }
    return null;
  }
  
  public String a(Context paramContext, String paramString)
  {
    paramContext = new ArrayList();
    paramContext.add(new com.mob.tools.a.i("client_id", this.c));
    paramContext.add(new com.mob.tools.a.i("client_secret", this.d));
    paramContext.add(new com.mob.tools.a.i("redirect_uri", this.e));
    paramContext.add(new com.mob.tools.a.i("grant_type", "authorization_code"));
    paramContext.add(new com.mob.tools.a.i("code", paramString));
    paramContext = this.h.b("https://api.weibo.com/oauth2/access_token", paramContext, "/oauth2/access_token", c());
    ShareSDK.logApiEvent("/oauth2/access_token", c());
    return paramContext;
  }
  
  public HashMap<String, Object> a(int paramInt1, int paramInt2, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.mob.tools.a.i("source", this.c));
    int j = 1;
    try
    {
      com.mob.tools.b.g.e(paramString);
      if (j != 0)
      {
        localArrayList.add(new com.mob.tools.a.i("uid", paramString));
        localArrayList.add(new com.mob.tools.a.i("count", String.valueOf(paramInt1)));
        localArrayList.add(new com.mob.tools.a.i("page", String.valueOf(paramInt2)));
        paramString = this.h.a("https://api.weibo.com/2/statuses/user_timeline.json", localArrayList, "/2/statuses/user_timeline.json", c());
        if (paramString == null) {
          break label156;
        }
        return new com.mob.tools.b.e().a(paramString);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        j = 0;
        continue;
        localArrayList.add(new com.mob.tools.a.i("screen_name", paramString));
      }
    }
    label156:
    return null;
  }
  
  public HashMap<String, Object> a(String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {
      throw new Throwable("weibo content can not be null!");
    }
    if (!TextUtils.isEmpty(paramString3)) {
      return b(paramString3, paramString1, paramFloat1, paramFloat2);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      return a(paramString1, paramString2, paramFloat1, paramFloat2);
    }
    return a(paramString1, paramFloat1, paramFloat2);
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
    localArrayList.add(new com.mob.tools.a.i("source", this.c));
    if (this.f != null) {
      localArrayList.add(new com.mob.tools.a.i("access_token", this.f));
    }
    if ((paramHashMap1 != null) && (paramHashMap1.size() > 0))
    {
      paramHashMap1 = paramHashMap1.entrySet().iterator();
      for (paramHashMap = null; paramHashMap1.hasNext(); paramHashMap = new com.mob.tools.a.i((String)paramHashMap.getKey(), paramHashMap.getValue())) {
        paramHashMap = (Map.Entry)paramHashMap1.next();
      }
    }
    for (;;)
    {
      try
      {
        if ("GET".equals(paramString2.toUpperCase()))
        {
          paramString1 = new l().httpGet(paramString1, localArrayList, null, null);
          if ((paramString1 == null) || (paramString1.length() <= 0)) {
            break;
          }
          return new com.mob.tools.b.e().a(paramString1);
        }
        if ("POST".equals(paramString2.toUpperCase()))
        {
          paramString1 = new l().httpPost(paramString1, localArrayList, paramHashMap, null, null);
          continue;
        }
      }
      catch (Throwable paramString1)
      {
        cn.sharesdk.framework.utils.d.a().w(paramString1);
        paramString1 = null;
        continue;
      }
      paramHashMap = null;
    }
  }
  
  public void a(Platform.ShareParams paramShareParams, PlatformActionListener paramPlatformActionListener)
  {
    if ((paramShareParams.getImageData() == null) && (TextUtils.isEmpty(paramShareParams.getImagePath())) && (!TextUtils.isEmpty(paramShareParams.getImageUrl()))) {}
    try
    {
      Object localObject = new File(com.mob.tools.b.a.a(this.i, paramShareParams.getImageUrl()));
      if (((File)localObject).exists()) {
        paramShareParams.setImagePath(((File)localObject).getAbsolutePath());
      }
      localObject = paramShareParams.getText();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramShareParams.setText(getPlatform().getShortLintk((String)localObject, false));
      }
      paramPlatformActionListener = new h(this, paramPlatformActionListener, paramShareParams);
      localObject = new a();
      ((a)localObject).a(this.c);
      ((a)localObject).a(paramShareParams);
      ((a)localObject).a(paramPlatformActionListener);
      ((a)localObject).show(this.i, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.d.a().w(localThrowable);
      }
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
    this.e = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public void a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      this.g = paramArrayOfString;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setPackage("com.sina.weibo");
    localIntent.setType("image/*");
    if (this.a.getContext().getPackageManager().resolveActivity(localIntent, 0) != null) {
      bool = true;
    }
    return bool;
  }
  
  public HashMap<String, Object> b(int paramInt1, int paramInt2, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.mob.tools.a.i("source", this.c));
    if (this.f != null) {
      localArrayList.add(new com.mob.tools.a.i("access_token", this.f));
    }
    int j = 1;
    try
    {
      com.mob.tools.b.g.e(paramString);
      if (j != 0)
      {
        localArrayList.add(new com.mob.tools.a.i("uid", paramString));
        localArrayList.add(new com.mob.tools.a.i("count", String.valueOf(paramInt1)));
        localArrayList.add(new com.mob.tools.a.i("cursor", String.valueOf(paramInt2)));
        paramString = this.h.a("https://api.weibo.com/2/friendships/friends.json", localArrayList, "/2/friendships/friends.json", c());
        if (paramString == null) {
          break label185;
        }
        return new com.mob.tools.b.e().a(paramString);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        j = 0;
        continue;
        localArrayList.add(new com.mob.tools.a.i("screen_name", paramString));
      }
    }
    label185:
    return null;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public boolean b()
  {
    return i.a(this.i).b() >= 10350;
  }
  
  public HashMap<String, Object> c(int paramInt1, int paramInt2, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.mob.tools.a.i("source", this.c));
    if (this.f != null) {
      localArrayList.add(new com.mob.tools.a.i("access_token", this.f));
    }
    int j = 1;
    try
    {
      com.mob.tools.b.g.e(paramString);
      if (j != 0)
      {
        localArrayList.add(new com.mob.tools.a.i("uid", paramString));
        localArrayList.add(new com.mob.tools.a.i("count", String.valueOf(paramInt1)));
        localArrayList.add(new com.mob.tools.a.i("page", String.valueOf(paramInt2)));
        paramString = this.h.a("https://api.weibo.com/2/friendships/friends/bilateral.json", localArrayList, "/2/friendships/friends/bilateral.json", c());
        if (paramString == null) {
          break label184;
        }
        return new com.mob.tools.b.e().a(paramString);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        j = 0;
        continue;
        localArrayList.add(new com.mob.tools.a.i("screen_name", paramString));
      }
    }
    label184:
    return null;
  }
  
  public HashMap<String, Object> c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.mob.tools.a.i("source", this.c));
    if (this.f != null) {
      localArrayList.add(new com.mob.tools.a.i("access_token", this.f));
    }
    int j = 1;
    try
    {
      com.mob.tools.b.g.e(paramString);
      if (j != 0)
      {
        localArrayList.add(new com.mob.tools.a.i("uid", paramString));
        paramString = this.h.a("https://api.weibo.com/2/users/show.json", localArrayList, "/2/users/show.json", c());
        if (paramString == null) {
          break label139;
        }
        return new com.mob.tools.b.e().a(paramString);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        j = 0;
        continue;
        localArrayList.add(new com.mob.tools.a.i("screen_name", paramString));
      }
    }
    label139:
    return null;
  }
  
  public HashMap<String, Object> d(int paramInt1, int paramInt2, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.mob.tools.a.i("source", this.c));
    if (this.f != null) {
      localArrayList.add(new com.mob.tools.a.i("access_token", this.f));
    }
    int j = 1;
    try
    {
      com.mob.tools.b.g.e(paramString);
      if (j != 0)
      {
        localArrayList.add(new com.mob.tools.a.i("uid", paramString));
        localArrayList.add(new com.mob.tools.a.i("count", String.valueOf(paramInt1)));
        localArrayList.add(new com.mob.tools.a.i("cursor", String.valueOf(paramInt2)));
        paramString = this.h.a("https://api.weibo.com/2/friendships/followers.json", localArrayList, "/2/friendships/followers.json", c());
        if (paramString == null) {
          break label185;
        }
        return new com.mob.tools.b.e().a(paramString);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        j = 0;
        continue;
        localArrayList.add(new com.mob.tools.a.i("screen_name", paramString));
      }
    }
    label185:
    return null;
  }
  
  public HashMap<String, Object> d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.mob.tools.a.i("source", this.c));
    localArrayList.add(new com.mob.tools.a.i("access_token", this.f));
    int j = 1;
    try
    {
      com.mob.tools.b.g.e(paramString);
      if (j != 0)
      {
        localArrayList.add(new com.mob.tools.a.i("uid", paramString));
        paramString = this.h.b("https://api.weibo.com/2/friendships/create.json", localArrayList, "/2/friendships/create.json", c());
        if (paramString == null) {
          break label132;
        }
        return new com.mob.tools.b.e().a(paramString);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        j = 0;
        continue;
        localArrayList.add(new com.mob.tools.a.i("screen_name", paramString));
      }
    }
    label132:
    return null;
  }
  
  public String getAuthorizeUrl()
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new com.mob.tools.a.i("client_id", this.c));
    ((ArrayList)localObject).add(new com.mob.tools.a.i("response_type", "code"));
    ((ArrayList)localObject).add(new com.mob.tools.a.i("redirect_uri", this.e));
    if ((this.g != null) && (this.g.length > 0)) {
      ((ArrayList)localObject).add(new com.mob.tools.a.i("scope", TextUtils.join(",", this.g)));
    }
    ((ArrayList)localObject).add(new com.mob.tools.a.i("display", "mobile"));
    localObject = "https://open.weibo.cn/oauth2/authorize?" + com.mob.tools.b.g.a((ArrayList)localObject);
    ShareSDK.logApiEvent("/oauth2/authorize", c());
    return (String)localObject;
  }
  
  public b getAuthorizeWebviewClient(cn.sharesdk.framework.authorize.g paramg)
  {
    return new c(paramg);
  }
  
  public String getRedirectUri()
  {
    if (TextUtils.isEmpty(this.e)) {
      return "https://api.weibo.com/oauth2/default.html";
    }
    return this.e;
  }
  
  public cn.sharesdk.framework.authorize.f getSSOProcessor(cn.sharesdk.framework.authorize.e parame)
  {
    parame = new e(parame);
    parame.a(32973);
    parame.a(this.c, this.e, this.g);
    return parame;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\sina\weibo\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */