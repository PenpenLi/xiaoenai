package com.xiaoenai.app.classes.street.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import com.xiaoenai.app.utils.ab;

class ar
  implements Html.ImageGetter
{
  ar(aq paramaq) {}
  
  public Drawable getDrawable(String paramString)
  {
    int i = Integer.parseInt(paramString);
    paramString = aq.a(this.a).getResources().getDrawable(i);
    paramString.setBounds(0, 2, ab.a(18.0F), ab.a(18.0F) + 2);
    return paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */