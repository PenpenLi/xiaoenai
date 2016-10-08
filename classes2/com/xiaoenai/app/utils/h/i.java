package com.xiaoenai.app.utils.h;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.messagelist.message.model.o;
import com.xiaoenai.app.e.a.a;
import com.xiaoenai.app.utils.a.d;
import com.xiaoenai.app.utils.f.a;
import java.io.File;

class i
  implements a.a
{
  i(g paramg, o paramo, c.a parama, boolean paramBoolean) {}
  
  public void a()
  {
    a.c("onVoiceDownLoadStart", new Object[0]);
    this.a.c(1);
    this.b.d(this.a);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a.c("load voice current = {} total = {}", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.a.c(1);
    this.b.a(this.a, paramInt1, paramInt2);
  }
  
  public void b()
  {
    String str = d.c(this.a.t()).getAbsolutePath();
    a.c("onDownloaded voice path = {}", new Object[] { str });
    this.a.c(str);
    this.a.c(2);
    Xiaoenai.j().a(new j(this));
  }
  
  public void c()
  {
    a.a(true, "load voice fail url = {}", new Object[] { this.a.v() });
    this.b.e(this.a);
    this.a.c(3);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\h\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */