package com.xiaoenai.app.classes.gameCenter;

import android.content.Context;
import android.widget.AbsListView.LayoutParams;
import com.xiaoenai.app.classes.gameCenter.a.f;
import com.xiaoenai.app.classes.gameCenter.model.BaseGameEntry;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.l;
import com.xiaoenai.app.widget.AutoViewPager;
import org.json.JSONArray;
import org.json.JSONObject;

class a
  extends m
{
  a(GameCenterActivity paramGameCenterActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    GameCenterActivity.a(this.a).setVisibility(0);
    super.a();
  }
  
  public void a(int paramInt)
  {
    GameCenterActivity.a(this.a).setVisibility(8);
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    GameCenterActivity.a(this.a).setVisibility(8);
    GameCenterActivity.a(this.a, l.f(paramJSONObject.toString()));
    GameCenterActivity.b(this.a);
    GameCenterActivity.d(this.a).a(GameCenterActivity.c(this.a));
    JSONArray localJSONArray = paramJSONObject.optJSONArray("banner");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      paramJSONObject = new BaseGameEntry[localJSONArray.length()];
      int i = 0;
      while (i < localJSONArray.length())
      {
        BaseGameEntry localBaseGameEntry = new BaseGameEntry();
        Object localObject = localJSONArray.optJSONObject(i);
        localBaseGameEntry.setAppKey(((JSONObject)localObject).optString("appkey"));
        localBaseGameEntry.setDesUrl(((JSONObject)localObject).optString("desc_url"));
        localObject = ((JSONObject)localObject).optString("ext_info");
        if (localObject != null)
        {
          localObject = new JSONObject((String)localObject);
          localBaseGameEntry.setUrl(((JSONObject)localObject).optString("url"));
          localBaseGameEntry.setWidth(((JSONObject)localObject).optInt("width"));
          localBaseGameEntry.setHeight(((JSONObject)localObject).optInt("height"));
          paramJSONObject[i] = localBaseGameEntry;
        }
        i += 1;
      }
      localJSONArray = paramJSONObject[0];
      if (localJSONArray != null)
      {
        i = localJSONArray.getWidth();
        i = localJSONArray.getHeight() * ab.b() / i;
        GameCenterActivity.e(this.a).setLayoutParams(new AbsListView.LayoutParams(-1, i));
        GameCenterActivity.e(this.a).a(paramJSONObject, GameCenterActivity.c(this.a));
        GameCenterActivity.d(this.a).notifyDataSetChanged();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */