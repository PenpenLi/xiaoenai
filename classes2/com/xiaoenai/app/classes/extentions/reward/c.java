package com.xiaoenai.app.classes.extentions.reward;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.extentions.reward.model.BaseTask;
import com.xiaoenai.app.ui.a.k;

public class c
{
  private static View.OnClickListener a(Context paramContext, int paramInt, RewardView paramRewardView, BaseTask paramBaseTask)
  {
    return new d(paramContext, paramRewardView, paramBaseTask, paramInt);
  }
  
  private static void a(RewardView paramRewardView, String paramString, Context paramContext, int paramInt, BaseTask paramBaseTask)
  {
    paramRewardView.setStateBtnText(paramString);
    paramRewardView.setStateBtnRes(2130839084);
    paramRewardView.setStateBtnColor(-764523);
    paramRewardView.setStateClickListener(a(paramContext, paramInt, paramRewardView, paramBaseTask));
    paramRewardView.a(12, 5, 12, 5);
  }
  
  public static void a(BaseTask paramBaseTask, RewardView paramRewardView, Context paramContext)
  {
    paramRewardView.setImageView(paramBaseTask.getIcon_url());
    paramRewardView.setTitleText(paramBaseTask.getTitle());
    paramRewardView.setTipsText(paramBaseTask.getDesc());
    b(paramBaseTask, paramRewardView, paramContext);
  }
  
  private static void b(Context paramContext, String paramString)
  {
    paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString3 = new k(paramContext);
    paramString3.d(k.i);
    paramString3.a(2131101303, new f(), 2131101308, new g(paramContext, paramString2), paramString1, new h(paramContext, paramString2, paramString3));
  }
  
  private static void b(RewardView paramRewardView, String paramString)
  {
    paramRewardView.setStateBtnText(paramString);
    paramRewardView.setStateBtnRes(2130839016);
    paramRewardView.setStateBtnColor(-10976970);
  }
  
  private static void b(BaseTask paramBaseTask, RewardView paramRewardView, Context paramContext)
  {
    if (paramBaseTask.getStatus() == 1) {
      b(paramRewardView, paramContext.getString(2131101054));
    }
    do
    {
      return;
      if (paramBaseTask.getStatus() == 0)
      {
        a(paramRewardView, paramContext.getString(2131101057), paramContext, paramBaseTask.getId(), paramBaseTask);
        return;
      }
    } while (paramBaseTask.getStatus() != 2);
    c(paramRewardView, paramContext.getString(2131101058));
  }
  
  private static void c(RewardView paramRewardView, String paramString)
  {
    paramRewardView.setStateBtnText(paramString);
    paramRewardView.setStateBtnColor(-4143668);
    paramRewardView.setStateBtnRes(2130838913);
    paramRewardView.a(12, 5, 12, 5);
    paramRewardView.setStateClickListener(null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\reward\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */