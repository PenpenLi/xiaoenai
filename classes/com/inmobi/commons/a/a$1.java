package com.inmobi.commons.a;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;

final class a$1
  implements Runnable
{
  a$1(Context paramContext) {}
  
  public void run()
  {
    a.c(new WebView(this.a).getSettings().getUserAgentString());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\a\a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */