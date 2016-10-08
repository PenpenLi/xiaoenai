package com.xiaoenai.app.classes.chat.messagelist.message.b;

import android.widget.RelativeLayout;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.messagelist.message.model.PhotoMessage;
import com.xiaoenai.app.classes.chat.messagelist.view.j;
import java.io.File;

public class m
{
  public static void a(PhotoMessage paramPhotoMessage, j paramj, int paramInt)
  {
    paramj.a(paramPhotoMessage.u(), paramPhotoMessage.v());
    paramj.setStatus(paramPhotoMessage.f().intValue());
    if ((paramPhotoMessage.w() != null) && (new File(paramPhotoMessage.w()).exists())) {
      paramj.setImage("file://" + paramPhotoMessage.w());
    }
    for (;;)
    {
      paramj.getMessageBody().setTag(2131558412, paramPhotoMessage);
      paramj.setFrom(paramInt);
      return;
      paramj.setImage(Xiaoenai.b(paramPhotoMessage.t()));
    }
  }
  
  public static void a(PhotoMessage paramPhotoMessage, j paramj, long paramLong)
  {
    paramj.a(paramPhotoMessage.u(), paramPhotoMessage.v());
    paramj.setStatus(paramPhotoMessage.f().intValue());
    if ((paramPhotoMessage.w() != null) && (new File(paramPhotoMessage.w()).exists()))
    {
      paramj.setImage("file://" + paramPhotoMessage.w());
      paramj.getMessageBody().setOnClickListener(new n(paramLong, paramPhotoMessage));
      return;
    }
    String str = Xiaoenai.b(paramPhotoMessage.t());
    if (paramPhotoMessage.v() > paramPhotoMessage.u()) {}
    for (str = str + "?imageView/1/w/" + paramj.getImageViewMaxWidth() + "/h/" + paramj.getImageViewMaxWidth();; str = str + "?imageView/2/w/" + paramj.getImageViewMaxWidth())
    {
      paramj.setImage(str);
      break;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */