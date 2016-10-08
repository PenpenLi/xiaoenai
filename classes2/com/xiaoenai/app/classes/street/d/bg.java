package com.xiaoenai.app.classes.street.d;

import android.content.Context;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.classes.street.model.Comment;
import com.xiaoenai.app.net.ae;
import com.xiaoenai.app.utils.as;

public class bg
  extends a
{
  public static String a(Comment paramComment, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramComment == null) {
      localStringBuilder.append(as.a(2131100485));
    }
    for (;;)
    {
      localStringBuilder.append("，");
      localStringBuilder.append(as.a(2131100456));
      localStringBuilder.append("：");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
      localStringBuilder.append(as.a(2131100484));
      localStringBuilder.append(paramComment.getName());
    }
  }
  
  public static void a(Context paramContext, Comment paramComment)
  {
    e locale = new e(paramContext);
    locale.a(paramContext.getString(2131100484) + paramContext.getString(2131100456));
    locale.a(2131100486, 1, new bh(locale, paramContext, paramComment));
    locale.a(2131100487, 1, new bi(locale, paramContext, paramComment));
    locale.a(2131100488, 1, new bj(locale, paramContext, paramComment));
    locale.a(2131100489, 1, new bk(locale, paramComment, paramContext));
    locale.show();
  }
  
  public static void a(Context paramContext, Comment paramComment, String paramString)
  {
    b(paramContext, paramComment, paramString);
  }
  
  public static void b(Context paramContext, Comment paramComment, String paramString)
  {
    new ae(new bl(paramContext, paramContext, (BaseActivity)paramContext)).b(paramComment.getId(), a(paramComment, paramString));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */