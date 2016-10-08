package com.xiaoenai.app.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import com.alibaba.nb.android.trade.AliTradeSDK;
import com.alibaba.nb.android.trade.model.AliTradeShowParams;
import com.alibaba.nb.android.trade.model.AliTradeTaokeParams;
import com.alibaba.nb.android.trade.uibridge.AliTradeBasePage;
import com.alibaba.nb.android.trade.uibridge.AliTradeDetailPage;
import com.alibaba.nb.android.trade.uibridge.AliTradeMyCartsPage;
import com.alibaba.nb.android.trade.uibridge.AliTradeMyOrdersPage;
import com.alibaba.nb.android.trade.uibridge.AliTradePage;
import com.alibaba.nb.android.trade.uibridge.IAliTradeService;
import com.alibaba.sdk.android.AlibabaHelper;
import com.xiaoenai.app.classes.common.c.a.b;
import com.xiaoenai.app.classes.common.c.a.c;
import com.xiaoenai.app.classes.common.c.a.d;
import com.xiaoenai.app.classes.common.c.g;
import com.xiaoenai.app.classes.settings.bj;
import com.xiaoenai.app.classes.street.guide.StreetTaeAuthorizationActivity;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.ui.a.k;
import org.json.JSONException;
import org.json.JSONObject;

public class p
{
  private static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("street_author_type", paramInt);
    localIntent.setClass(paramContext, StreetTaeAuthorizationActivity.class);
    a(paramContext, localIntent);
  }
  
  private static void a(Context paramContext, Intent paramIntent)
  {
    paramContext.startActivity(paramIntent);
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).overridePendingTransition(2130968604, 2130968605);
    }
  }
  
  public static void a(Context paramContext, d paramd, g paramg)
  {
    if ((paramd == null) || (paramg.a() == null)) {}
    do
    {
      return;
      if (("xiaoenai.taobao.productdetail".equalsIgnoreCase(paramg.a())) || ("xiaoenai.tmall.productdetail".equalsIgnoreCase(paramg.a())))
      {
        a(paramContext, paramg.e());
        return;
      }
      if ("xiaoenai.taobao.orders".equalsIgnoreCase(paramg.a()))
      {
        c(paramContext);
        return;
      }
      if ("xiaoenai.taobao.cart".equalsIgnoreCase(paramg.a()))
      {
        b(paramContext);
        return;
      }
      paramd = b(paramContext, paramd, paramg);
    } while ((paramd == null) || (((paramd.getAction() == null) || (paramd.getAction().length() <= 0)) && ((paramd.getComponent() == null) || (paramd.getComponent().getClassName() == null) || (paramd.getComponent().getClassName().length() <= 0))));
    a(paramContext, paramd);
    c(paramContext, paramg.c());
  }
  
  private static void a(Context paramContext, String paramString)
  {
    if ((!(paramContext instanceof Activity)) || (!ae.a(paramString))) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramString);
        if (((JSONObject)localObject1).has("outer_id"))
        {
          paramString = ((JSONObject)localObject1).optString("outer_id");
          if (!ae.a(paramString))
          {
            l = Long.parseLong(paramString);
            paramString = "";
          }
        }
      }
      catch (JSONException paramString)
      {
        try
        {
          if (((JSONObject)localObject1).has("pid"))
          {
            localObject1 = ((JSONObject)localObject1).optString("pid");
            Object localObject2 = paramString;
            paramString = (String)localObject1;
            localObject1 = localObject2;
            com.xiaoenai.app.utils.f.a.c(true, "ProductItem outer_id = {} page_url = {} pid = {}", new Object[] { Long.valueOf(l), localObject1, paramString });
            AliTradeShowParams localAliTradeShowParams;
            if (!ae.a((String)localObject1))
            {
              localObject1 = new AliTradePage((String)localObject1);
              if (localObject1 != null)
              {
                localObject2 = (IAliTradeService)AliTradeSDK.getService(IAliTradeService.class);
                if (ae.a(paramString)) {
                  continue;
                }
                paramString = new AliTradeTaokeParams(paramString, null, null);
                localAliTradeShowParams = AlibabaHelper.creatAliTradeShowParams();
                localAliTradeShowParams.setTitle(paramContext.getString(2131101449));
                if (localObject2 != null) {}
              }
              else
              {
                return;
                l = ((JSONObject)localObject1).optInt("outer_id");
                continue;
                if (!((JSONObject)localObject1).has("page_url")) {
                  continue;
                }
                paramString = ((JSONObject)localObject1).optString("page_url");
                l = 0L;
                continue;
                paramString = paramString;
                l = 0L;
                localObject1 = "";
                paramString.printStackTrace();
                paramString = "";
                continue;
              }
            }
            else
            {
              if (l <= 0L) {
                continue;
              }
              localObject1 = new AliTradeDetailPage(String.valueOf(l));
              continue;
            }
            ((IAliTradeService)localObject2).show((Activity)paramContext, (AliTradeBasePage)localObject1, localAliTradeShowParams, paramString, null, new q(paramContext));
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          localObject1 = paramString;
          paramString = localJSONException;
          continue;
          paramString = null;
          continue;
          localObject1 = null;
          continue;
          localObject1 = "";
          continue;
          paramString = "";
          l = 0L;
        }
        continue;
      }
      Object localObject1 = "";
      paramString = "";
      long l = 0L;
    }
  }
  
  public static void a(d paramd, g paramg)
  {
    if ((paramg == null) || (paramg.a() == null)) {}
    do
    {
      do
      {
        return;
        paramg = c.a().a(paramg.a());
      } while (paramg == null);
      paramg = paramg.d();
    } while (paramg == null);
    if (paramg.a().equals("drawable"))
    {
      paramd.d = aa.a(paramg.b());
      return;
    }
    paramd.e = User.getInstance().getLoverAvatar();
  }
  
  public static Intent b(Context paramContext, d paramd, g paramg)
  {
    if (paramg == null) {
      return null;
    }
    com.xiaoenai.app.utils.f.a.c("module:{} {} {}", new Object[] { paramg.a(), paramd.c, paramd.b });
    Intent localIntent = new Intent();
    Object localObject = c.a().a(paramg.a());
    if (localObject != null)
    {
      paramd = ((b)localObject).b();
      localObject = ((b)localObject).c();
    }
    for (;;)
    {
      try
      {
        paramd = Class.forName(paramd);
        paramContext.printStackTrace();
      }
      catch (ClassNotFoundException paramContext)
      {
        try
        {
          localIntent.setClass(paramContext, paramd);
          if (paramd == null) {
            break label133;
          }
          localIntent.putExtra("from", paramg.b());
          localIntent.putExtra("param", paramg.e());
          localIntent.setAction((String)localObject);
          return localIntent;
        }
        catch (ClassNotFoundException paramContext)
        {
          for (;;) {}
        }
        paramContext = paramContext;
        paramd = null;
      }
      continue;
      try
      {
        label133:
        paramContext = new JSONObject(paramg.e()).optString("url");
        if (paramContext != null) {
          localIntent.setData(Uri.parse(paramContext));
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private static void b(Context paramContext)
  {
    if (bj.a().b())
    {
      e(paramContext);
      return;
    }
    a(paramContext, 0);
  }
  
  private static void b(Context paramContext, boolean paramBoolean)
  {
    k localk = new k(paramContext);
    Object localObject = paramContext.getResources();
    int i;
    label46:
    r localr;
    if (paramBoolean)
    {
      i = 2131101491;
      localObject = ((Resources)localObject).getString(i);
      localk.d(k.i);
      if (!paramBoolean) {
        break label95;
      }
      i = 2131101492;
      localr = new r();
      if (!paramBoolean) {
        break label103;
      }
    }
    label95:
    label103:
    for (int j = 2131101486;; j = 2131101488)
    {
      localk.a(i, (String)localObject, 2131101487, localr, j, new s(paramContext));
      return;
      i = 2131101489;
      break;
      i = 2131101490;
      break label46;
    }
  }
  
  private static void c(Context paramContext)
  {
    if (bj.a().b())
    {
      d(paramContext);
      return;
    }
    a(paramContext, 1);
  }
  
  private static void c(Context paramContext, boolean paramBoolean)
  {
    if ((paramBoolean) && ((paramContext instanceof Activity)))
    {
      ((Activity)paramContext).finish();
      ((Activity)paramContext).overridePendingTransition(2130968595, 2130968596);
    }
  }
  
  private static void d(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      IAliTradeService localIAliTradeService = (IAliTradeService)AliTradeSDK.getService(IAliTradeService.class);
      AliTradeMyOrdersPage localAliTradeMyOrdersPage = new AliTradeMyOrdersPage(0, true);
      localIAliTradeService.show((Activity)paramContext, localAliTradeMyOrdersPage, AlibabaHelper.creatAliTradeShowParams(), null, null, new t());
    }
  }
  
  private static void e(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      IAliTradeService localIAliTradeService = (IAliTradeService)AliTradeSDK.getService(IAliTradeService.class);
      AliTradeMyCartsPage localAliTradeMyCartsPage = new AliTradeMyCartsPage();
      localIAliTradeService.show((Activity)paramContext, localAliTradeMyCartsPage, AlibabaHelper.creatAliTradeShowParams(), null, null, new u());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */