package com.xiaoenai.app.classes.extentions.todo;

import android.content.Context;
import com.xiaoenai.app.classes.extentions.todo.a.b;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.component.view.ProgressView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class t
  extends m
{
  t(TodoActivity paramTodoActivity, Context paramContext, int paramInt)
  {
    super(paramContext);
  }
  
  public void a()
  {
    TodoActivity.a(this.b, true);
    if (ao.a().c() == 0) {
      TodoActivity.a(this.b).setVisibility(0);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    TodoActivity.a(this.b).setVisibility(8);
    TodoActivity.a(this.b, false);
    this.b.a = false;
    ao.a().a(false);
    TodoActivity.c(this.b).a(TodoActivity.a(this.b, ao.a().b()));
    TodoActivity.b(this.b);
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    TodoActivity.a(this.b).setVisibility(8);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int i = 0;
    TodoActivity.a(this.b).setVisibility(8);
    if (UserConfig.getBoolean("first_time_in_todo", Boolean.valueOf(true)).booleanValue()) {
      UserConfig.setBoolean("first_time_in_todo", Boolean.valueOf(false));
    }
    TodoActivity.a(this.b, false);
    if (this.a == 0)
    {
      ao.a().d();
      ao.a().a(true);
    }
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray("notes");
        int j = paramJSONObject.length();
        if (i < j)
        {
          b localb = b.a(paramJSONObject.getJSONObject(i));
          ao.a().a(localb);
          i += 1;
          continue;
        }
        TodoActivity.b(this.b);
        if (j >= 20) {
          continue;
        }
        ao.a().a(false);
        this.b.a = false;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        continue;
      }
      TodoActivity.c(this.b).a(TodoActivity.a(this.b, ao.a().b()));
      TodoActivity.a(this.b, ao.a().c());
      return;
      this.b.a = true;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */