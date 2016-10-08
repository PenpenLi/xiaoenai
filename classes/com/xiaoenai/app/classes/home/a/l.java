package com.xiaoenai.app.classes.home.a;

import android.os.AsyncTask;
import com.xiaoenai.app.classes.common.p;
import java.util.Set;
import org.json.JSONObject;

public class l
  extends AsyncTask<JSONObject, Void, Set<Object>>
{
  public p a;
  
  public l(p paramp)
  {
    this.a = paramp;
  }
  
  protected Set<Object> a(JSONObject... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if ((paramVarArgs != null) && (paramVarArgs.optBoolean("success")) && (paramVarArgs.has("data")))
    {
      if (this.a != null) {
        this.a.a(paramVarArgs);
      }
      return k.a(paramVarArgs.optJSONObject("data"));
    }
    return null;
  }
  
  protected void a(Set<Object> paramSet)
  {
    super.onPostExecute(paramSet);
    k.a().a(paramSet);
    if (this.a != null) {
      this.a.a();
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */