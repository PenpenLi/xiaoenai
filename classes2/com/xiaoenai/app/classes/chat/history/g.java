package com.xiaoenai.app.classes.chat.history;

import android.content.Context;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import java.util.Vector;
import org.json.JSONObject;

class g
  extends m
{
  h a;
  
  g(f paramf, Context paramContext, Vector paramVector)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    this.a = h.a(this.c.a);
  }
  
  public void a(int paramInt)
  {
    if (this.a != null) {
      this.a.dismiss();
    }
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (this.a != null) {
      this.a.dismiss();
    }
    super.a(paramJSONObject);
    int i = 0;
    if (i < this.b.size())
    {
      paramJSONObject = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)this.b.get(i);
      com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = com.xiaoenai.app.classes.chat.messagelist.a.a().a(paramJSONObject.h());
      if (locala == null) {
        paramJSONObject.n();
      }
      for (;;)
      {
        int j = ChatHisEditActivity.l(this.c.a).indexOf(paramJSONObject);
        ChatHisEditActivity.l(this.c.a).removeElement(paramJSONObject);
        ChatHisEditActivity.e(this.c.a).a(j);
        i += 1;
        break;
        locala.m();
      }
    }
    this.c.a.a(true);
    ChatHisEditActivity.e(this.c.a).f();
    paramJSONObject = new h(this.c.a);
    paramJSONObject.a(2131099713);
    paramJSONObject.a(1500L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */