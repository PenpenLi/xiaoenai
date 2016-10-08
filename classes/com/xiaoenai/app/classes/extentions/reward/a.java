package com.xiaoenai.app.classes.extentions.reward;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.d.f;
import com.xiaoenai.app.utils.l;
import java.util.List;
import org.json.JSONObject;

class a
  extends m
{
  a(RewardActivity paramRewardActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    RewardActivity.a(this.a).setVisibility(0);
    RewardActivity.a(this.a).a();
    super.a();
  }
  
  public void a(int paramInt)
  {
    RewardActivity.a(this.a).b();
    RewardActivity.a(this.a).setVisibility(8);
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    RewardActivity.a(this.a, l.a(paramJSONObject));
    f.b(paramJSONObject, f.a(Xiaoenai.j(), "task_serializable"));
    RewardActivity.c(this.a).a(RewardActivity.b(this.a).toArray());
    RewardActivity.a(this.a).b();
    RewardActivity.a(this.a).setVisibility(8);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\reward\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */