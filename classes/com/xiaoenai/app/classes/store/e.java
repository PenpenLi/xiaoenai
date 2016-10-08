package com.xiaoenai.app.classes.store;

import android.content.Context;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.component.view.ProgressView;
import java.util.List;
import org.json.JSONObject;

class e
  extends m
{
  e(StickerActivity paramStickerActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    StickerActivity.b(this.a).setVisibility(0);
    super.a();
  }
  
  public void a(int paramInt)
  {
    StickerActivity.b(this.a).setVisibility(8);
    StickerActivity.a(this.a).a(k.a().b().toArray(), 1);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    StickerActivity.b(this.a).setVisibility(8);
    new StickerActivity.b(this.a).a(paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */