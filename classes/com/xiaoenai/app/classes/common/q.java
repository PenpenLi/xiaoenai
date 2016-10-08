package com.xiaoenai.app.classes.common;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.ak;
import com.xiaoenai.app.classes.extentions.anniversary.ai;
import com.xiaoenai.app.classes.extentions.menses.ac;
import com.xiaoenai.app.classes.extentions.todo.ao;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.model.album.PhotoImageList;
import com.xiaoenai.app.model.status.StatusList;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.d.f;
import java.io.File;
import org.mzd.socket.SocketJNI;

public class q
{
  private Context a;
  private h b;
  
  public q(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.a = a.a().c();
    if (this.a != null) {
      new k(this.a).a(paramString2, paramString1, 2131101014, 2131101027, new s(this), 2131099701, new t(this));
    }
  }
  
  private void b(String paramString)
  {
    new l(new u(this, this.a)).d(paramString);
  }
  
  private void c(int paramInt)
  {
    SocketJNI.setLoverId(paramInt);
    as.p();
  }
  
  private void c(String paramString)
  {
    new l(new x(this, this.a)).e(paramString);
  }
  
  private void d()
  {
    if ((this.b != null) && (this.b.isShowing())) {
      this.b.dismiss();
    }
    this.b = null;
  }
  
  private void d(String paramString)
  {
    this.b = h.a(this.a);
    if (!this.b.isShowing()) {
      this.b.show();
    }
    if ((paramString != null) && (paramString.length() > 1)) {
      this.b.a(paramString);
    }
  }
  
  private void e()
  {
    NotificationManager localNotificationManager = (NotificationManager)this.a.getSystemService("notification");
    localNotificationManager.cancel(1004);
    localNotificationManager.cancel(1000);
  }
  
  public void a()
  {
    if (UserConfig.getBoolean("is_getting_invite", Boolean.valueOf(false)).booleanValue()) {
      return;
    }
    new l(new r(this, this.a)).a();
  }
  
  public void a(int paramInt)
  {
    if ((this.a instanceof HomeActivity)) {
      ((HomeActivity)this.a).c(paramInt);
    }
    Object localObject;
    do
    {
      return;
      if (paramInt == 1)
      {
        localObject = new Intent(this.a, HomeActivity.class);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtra("refreshHome", true);
        ((Intent)localObject).putExtra("type", paramInt);
        this.a.startActivity((Intent)localObject);
        return;
      }
      localObject = a.a();
    } while (!((a)localObject).c(HomeActivity.class));
    ((HomeActivity)((a)localObject).b(HomeActivity.class)).c(paramInt);
  }
  
  public void a(String paramString)
  {
    this.a = a.a().c();
    if (this.a != null)
    {
      g localg = new g(this.a);
      localg.setTitle(2131101015);
      localg.d(k.j);
      localg.a(2131101016);
      localg.a(2131101049, new v(this, paramString));
      localg.b(2131099973, new w(this));
      localg.show();
    }
  }
  
  public void b()
  {
    File localFile = f.a(Xiaoenai.j(), AppModel.getInstance().getUserId());
    if ((localFile != null) && (localFile.isDirectory())) {}
    com.xiaoenai.app.service.MessageService.a = 0;
    UserConfig.setInt("receive_new_msg_count", 0);
    com.xiaoenai.app.classes.chat.messagelist.a.a().i();
    PhotoImageList.getInstance().clearPhotos();
    ai.a().d();
    ao.a().e();
    new com.xiaoenai.app.d.v().a();
    ak.a("chat_bg_photo_path");
    ak.a("chat_bg_type", 0);
    StatusList.getInstance().clear();
    ac.j();
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0) {
      h.a(this.a, 2131100532, 2000L);
    }
    if ((this.a instanceof HomeActivity)) {
      ((HomeActivity)this.a).c(paramInt);
    }
    a locala;
    do
    {
      return;
      locala = a.a();
    } while (!locala.c(HomeActivity.class));
    ((HomeActivity)locala.b(HomeActivity.class)).f(paramInt);
  }
  
  public void c()
  {
    int i = User.getInstance().getLoverId();
    new l(new y(this, this.a, i)).c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */