package com.xiaoenai.app.classes.store.a;

import android.content.Context;
import com.xiaoenai.app.classes.store.sticker.FaceSticker;
import com.xiaoenai.app.classes.store.view.FaceStickerView;

public class a
{
  public static void a(Context paramContext, FaceSticker paramFaceSticker, FaceStickerView paramFaceStickerView, int paramInt)
  {
    if (paramFaceSticker.getThumb_url() != null) {
      paramFaceStickerView.setImageByPath(paramFaceSticker.getThumb_url());
    }
    if (paramFaceSticker.getName() != null) {
      paramFaceStickerView.setStickerName(paramFaceSticker.getName());
    }
    if ((paramInt == 1) || (!paramFaceSticker.isMine())) {
      paramFaceStickerView.setRemindButton(paramFaceSticker.getRedHintsInfo());
    }
    if (!paramFaceSticker.isNew())
    {
      paramFaceStickerView.setStickerStateVisiablity(0);
      paramFaceStickerView.setStickerNewStateVisiablity(8);
      if (!paramFaceSticker.isDownload())
      {
        paramFaceStickerView.setStickerStateImage(2130838918);
        return;
      }
      paramFaceStickerView.setStickerState(paramContext.getString(2131101295));
      return;
    }
    paramFaceStickerView.setStickerStateVisiablity(8);
    paramFaceStickerView.setStickerNewStateVisiablity(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\store\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */