package com.xiaoenai.app.classes.chat.messagelist.message.model;

import android.content.Context;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class h
  extends m
{
  h(PhotoMessage paramPhotoMessage, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    this.a.b(Integer.valueOf(-1));
    this.a.k();
    com.xiaoenai.app.classes.chat.messagelist.a.a().a(this.a);
    com.xiaoenai.app.classes.chat.messagelist.a.l();
  }
  
  public void a(int paramInt)
  {
    com.xiaoenai.app.utils.f.a.a(true, "PhotoMessage uploadImageAndSend onError {}", new Object[] { Integer.valueOf(paramInt) });
    this.a.b(Integer.valueOf(-2));
    this.a.k();
    com.xiaoenai.app.classes.chat.messagelist.a.l();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    PhotoMessage.a(this.a, paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\model\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */