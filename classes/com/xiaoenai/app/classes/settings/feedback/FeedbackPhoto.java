package com.xiaoenai.app.classes.settings.feedback;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.messagelist.message.model.PhotoMessage;
import com.xiaoenai.app.net.ae;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.net.n;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedbackPhoto
  extends PhotoMessage
{
  private long i;
  private m j;
  
  private void A()
  {
    new ae(new l(this, Xiaoenai.j())).a(this.i, B(), "image");
  }
  
  private String B()
  {
    if ((this.b == null) || (this.c == 0) || (this.d == 0)) {
      return null;
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("url", this.b);
      ((JSONObject)localObject).put("height", this.c);
      ((JSONObject)localObject).put("width", this.d);
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  private void y()
  {
    new n(new j(this, Xiaoenai.j())).c(w());
  }
  
  private void z()
  {
    new com.xiaoenai.app.net.l(new k(this, Xiaoenai.j())).f(B(), "image");
  }
  
  public void a(m paramm)
  {
    this.j = paramm;
    b(Integer.valueOf(-1));
    if (B() != null)
    {
      if (this.i > 0L)
      {
        A();
        return;
      }
      z();
      return;
    }
    y();
  }
  
  public void e(long paramLong)
  {
    this.i = paramLong;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\feedback\FeedbackPhoto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */