package com.xiaoenai.app.classes.extentions.forum;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.dialog.a.j;
import com.xiaoenai.app.classes.common.share.ShareInfo;
import com.xiaoenai.app.classes.common.share.p;
import com.xiaoenai.app.model.Forum.Post;
import com.xiaoenai.app.model.Forum.Post.a;
import java.util.List;

public class a
{
  public static void a(Post paramPost, Context paramContext)
  {
    new j(paramContext).a(2131100497);
    ShareInfo localShareInfo = new ShareInfo();
    localShareInfo.a(paramPost.c);
    com.xiaoenai.app.utils.f.a.c("=================post.id: {}", new Object[] { Integer.valueOf(paramPost.b) });
    localShareInfo.f(Xiaoenai.o + "t/" + paramPost.b);
    localShareInfo.b(4);
    localShareInfo.b(paramPost.p);
    if ((paramPost.o != null) && (paramPost.o.size() > 0))
    {
      localShareInfo.e(((Post.a)paramPost.o.get(0)).c());
      localShareInfo.c(((Post.a)paramPost.o.get(0)).c());
    }
    for (;;)
    {
      localShareInfo.d(localShareInfo.b());
      localShareInfo.a(1);
      localShareInfo.c(9);
      localShareInfo.e(1);
      new p().b(localShareInfo, paramContext.getString(2131100497), paramContext, new com.xiaoenai.app.classes.common.share.e(9, -1, paramContext));
      return;
      localShareInfo.e(com.xiaoenai.app.utils.e.a("weChatIcon.png", com.xiaoenai.app.utils.e.a, "weChatIcon1.png"));
      localShareInfo.c(com.xiaoenai.app.utils.e.a("weChatIcon.png", com.xiaoenai.app.utils.e.a, "weChatIcon1.png"));
    }
  }
  
  public static void b(Post paramPost, Context paramContext)
  {
    ShareInfo localShareInfo = new ShareInfo();
    localShareInfo.a(paramPost.c);
    localShareInfo.f(Xiaoenai.o + "e/" + paramPost.b);
    localShareInfo.b(4);
    localShareInfo.b(paramPost.p);
    localShareInfo.e(com.xiaoenai.app.utils.e.a("weChatIcon.png", com.xiaoenai.app.utils.e.a, "weChatIcon1.png"));
    localShareInfo.c(com.xiaoenai.app.utils.e.a("weChatIcon.png", com.xiaoenai.app.utils.e.a, "weChatIcon1.png"));
    localShareInfo.d(localShareInfo.b());
    localShareInfo.a(1);
    localShareInfo.c(9);
    localShareInfo.a(new String[] { "wxt", "sinawb", "qzone" });
    new p().c(localShareInfo, paramContext.getString(2131100497), paramContext, new com.xiaoenai.app.classes.common.share.e(9, -1, paramContext));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\forum\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */