package cn.sharesdk.framework;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

class k
  implements DialogInterface.OnClickListener
{
  k(i parami, SslErrorHandler paramSslErrorHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.cancel();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */