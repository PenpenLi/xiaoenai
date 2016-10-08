package com.xiaoenai.app.classes.chat;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.model.status.Status;
import com.xiaoenai.app.model.status.StatusList;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddStatusActivity
  extends TitleBarActivity
{
  private EditText a;
  private TextView b;
  private boolean c = false;
  private h i;
  
  private int b(String paramString)
  {
    int k = 0;
    int j = 0;
    if (k < paramString.length())
    {
      if (paramString.charAt(k) > 'ÿ') {
        j += 2;
      }
      for (;;)
      {
        k += 1;
        break;
        j += 1;
      }
    }
    return j;
  }
  
  private void c()
  {
    this.g.setLeftButtonClickListener(new a(this));
    this.g.setRightButtonClickListener(new b(this));
  }
  
  private void d()
  {
    this.a = ((EditText)findViewById(2131558762));
    this.a.addTextChangedListener(new c(this));
    this.b = ((TextView)findViewById(2131558763));
  }
  
  private void f()
  {
    if (this.c)
    {
      localObject = new g(this);
      ((g)localObject).a(2131099994);
      ((g)localObject).a(2131100898, new d(this));
      ((g)localObject).show();
      return;
    }
    Object localObject = this.a.getText().toString().trim();
    Iterator localIterator = StatusList.getInstance().getList().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((Status)localIterator.next()).getContent().equals(localObject));
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        localObject = new g(this);
        ((g)localObject).a(2131099990);
        ((g)localObject).a(2131100898, new e(this));
        ((g)localObject).show();
        return;
      }
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
      StatusList.getInstance().addStatus((String)localObject);
      g();
      return;
    }
  }
  
  private void g()
  {
    l locall = new l(new f(this, this));
    JSONArray localJSONArray = new JSONArray();
    Object localObject = StatusList.getInstance().getList().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Status localStatus = (Status)((Iterator)localObject).next();
      if (localStatus.getType().equals("030")) {
        localJSONArray.put(localStatus.getContent());
      }
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("timestamp", System.currentTimeMillis() / 1000L);
      ((JSONObject)localObject).put("status", localJSONArray);
      locall.f(((JSONObject)localObject).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public int a()
  {
    return 2130903091;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c();
    d();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      setResult(0);
      finish();
      overridePendingTransition(2130968606, 2130968607);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\AddStatusActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */