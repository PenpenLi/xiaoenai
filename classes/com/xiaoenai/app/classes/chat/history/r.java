package com.xiaoenai.app.classes.chat.history;

import android.content.Context;
import android.os.AsyncTask;
import com.xiaoenai.app.net.d.a;
import com.xiaoenai.app.ui.a.h;

public class r
  extends AsyncTask
{
  private Context a;
  private h b;
  private int c;
  private String d;
  private t e;
  private boolean f = false;
  
  public r(Context paramContext, int paramInt, String paramString, h paramh, t paramt, boolean paramBoolean)
  {
    this.a = paramContext;
    this.c = paramInt;
    this.d = paramString;
    this.b = paramh;
    this.e = paramt;
    this.f = paramBoolean;
  }
  
  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    new a(new s(this, this.a)).a(this.c, this.d);
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */