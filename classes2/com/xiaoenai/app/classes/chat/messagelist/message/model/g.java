package com.xiaoenai.app.classes.chat.messagelist.message.model;

import android.content.Context;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class g
  extends m
{
  g(PhotoMessage paramPhotoMessage, Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    this.b.b(Integer.valueOf(-1));
    this.b.k();
    com.xiaoenai.app.classes.chat.messagelist.a.a().a(this.b);
    com.xiaoenai.app.classes.chat.messagelist.a.l();
  }
  
  public void a(int paramInt)
  {
    com.xiaoenai.app.utils.f.a.a(true, "PhotoMessage uploadImageAndSend onError {}", new Object[] { Integer.valueOf(paramInt) });
    this.b.b(Integer.valueOf(-2));
    this.b.k();
    com.xiaoenai.app.classes.chat.messagelist.a.l();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.b.c(this.a);
    PhotoMessage.a(this.b, paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\model\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */