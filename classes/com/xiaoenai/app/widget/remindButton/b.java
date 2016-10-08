package com.xiaoenai.app.widget.remindButton;

import android.os.AsyncTask;
import com.xiaoenai.app.classes.common.p;
import com.xiaoenai.app.classes.home.a.k;
import com.xiaoenai.app.model.RedHintsInfo;
import java.util.HashMap;
import org.json.JSONObject;

public class b
  extends AsyncTask<JSONObject, Void, HashMap<String, RedHintsInfo>>
{
  public p a;
  
  public b(p paramp)
  {
    this.a = paramp;
  }
  
  protected HashMap<String, RedHintsInfo> a(JSONObject... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if ((paramVarArgs != null) && (paramVarArgs.optBoolean("success")) && (paramVarArgs.has("data")))
    {
      a.a().a(paramVarArgs);
      paramVarArgs = paramVarArgs.optJSONArray("data");
      a.a();
      return a.a(paramVarArgs);
    }
    return null;
  }
  
  protected void a(HashMap<String, RedHintsInfo> paramHashMap)
  {
    super.onPostExecute(paramHashMap);
    a.a().a(paramHashMap);
    k.a().d();
    if (this.a != null) {
      this.a.a();
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\remindButton\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */