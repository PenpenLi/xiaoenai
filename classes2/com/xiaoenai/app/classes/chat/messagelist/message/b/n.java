package com.xiaoenai.app.classes.chat.messagelist.message.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.chat.messagelist.message.a.a;
import com.xiaoenai.app.classes.chat.messagelist.message.model.PhotoMessage;
import com.xiaoenai.app.classes.common.image.imagePreview.ImageViewPager;
import com.xiaoenai.app.classes.settings.feedback.FeedbackPhoto;
import com.xiaoenai.app.d.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

final class n
  implements View.OnClickListener
{
  n(long paramLong, PhotoMessage paramPhotoMessage) {}
  
  public void onClick(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new f().a(this.a).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.b().equals("image")) {
        localArrayList.add((PhotoMessage)locala);
      }
    }
    int i;
    if (localArrayList.size() > 0)
    {
      localObject = new Intent(paramView.getContext(), ImageViewPager.class);
      ((Intent)localObject).putExtra("photo_data", localArrayList);
      if (!(this.b instanceof FeedbackPhoto)) {
        break label186;
      }
      ((Intent)localObject).putExtra("from", 2);
      i = 0;
    }
    for (;;)
    {
      if (i < localArrayList.size())
      {
        if (this.b.a() == ((PhotoMessage)localArrayList.get(i)).a()) {
          ((Intent)localObject).putExtra("position", i);
        }
      }
      else
      {
        paramView.getContext().startActivity((Intent)localObject);
        ((Activity)paramView.getContext()).overridePendingTransition(2130968588, 2130968589);
        return;
        label186:
        ((Intent)localObject).putExtra("from", 1);
        break;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\b\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */