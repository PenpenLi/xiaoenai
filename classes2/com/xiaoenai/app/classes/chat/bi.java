package com.xiaoenai.app.classes.chat;

import android.app.Activity;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.utils.f.b;

class bi
  implements f.a
{
  bi(be parambe) {}
  
  public void a(Message paramMessage)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    int i;
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      i = paramMessage.what;
      be.a(this.a, i);
      if (i >= 50) {
        break label73;
      }
      if (be.d(this.a) != null) {
        be.d(this.a).sendEmptyMessageDelayed(be.e(this.a) + 1, 1000L);
      }
    }
    label73:
    do
    {
      do
      {
        return;
        if ((i < 50) || (paramMessage.what >= 60)) {
          break;
        }
        be.a(this.a, String.format(this.a.getString(2131100044), new Object[] { Integer.valueOf(60 - i) }));
        if (i == 50) {
          be.f(this.a);
        }
      } while (be.d(this.a) == null);
      be.d(this.a).sendEmptyMessageDelayed(be.e(this.a) + 1, 1000L);
      return;
    } while (i < 60);
    if (be.g(this.a) != null)
    {
      be.g(this.a).a();
      return;
    }
    this.a.b();
    be.h(this.a);
    this.a.e();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */