package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.mob.tools.b.g;

class c
  implements View.OnClickListener
{
  c(RegisterView paramRegisterView) {}
  
  public void onClick(View paramView)
  {
    try
    {
      int i = g.b(paramView.getContext(), "ssdk_website");
      Object localObject = null;
      if (i > 0) {
        localObject = paramView.getResources().getString(i);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
        paramView.getContext().startActivity((Intent)localObject);
      }
      return;
    }
    catch (Throwable paramView)
    {
      cn.sharesdk.framework.utils.d.a().w(paramView);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\authorize\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */