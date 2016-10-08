package com.xiaoenai.app.classes.store;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import com.xiaoenai.app.classes.store.sticker.FaceSticker;
import com.xiaoenai.app.widget.remindButton.a;

class ah
  implements View.OnClickListener
{
  ah(ag paramag, BaseSticker paramBaseSticker, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.a.setNew(false);
    k.a().b(this.a);
    paramView = (FaceSticker)this.a;
    if (paramView != null)
    {
      a.a().b(paramView.getRedHintsInfo());
      this.c.notifyDataSetChanged();
    }
    paramView = new Intent();
    paramView.setAction("detailAction");
    paramView.putExtra("detailType", this.b);
    paramView.putExtra("data", this.a.getId());
    paramView.setClass(ag.a(this.c), StickerDetailActivity.class);
    ag.a(this.c).startActivity(paramView);
    ((Activity)ag.a(this.c)).overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\store\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */