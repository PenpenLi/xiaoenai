package com.xiaoenai.app.classes.store;

import android.widget.GridView;
import android.widget.ListAdapter;
import com.xiaoenai.app.classes.chat.input.faces.t.a;
import com.xiaoenai.app.classes.store.sticker.Sticker;

class m
  implements t.a
{
  m(StickerDetailActivity paramStickerDetailActivity) {}
  
  public String a(int paramInt)
  {
    return ((Sticker)StickerDetailActivity.a(this.a).getAdapter().getItem(paramInt)).getUrl();
  }
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */