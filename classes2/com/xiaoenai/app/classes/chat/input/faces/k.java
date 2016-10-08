package com.xiaoenai.app.classes.chat.input.faces;

import android.view.View;
import android.view.View.OnClickListener;

class k
  implements View.OnClickListener
{
  k(FaceFragmentBottomBar paramFaceFragmentBottomBar) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(FaceFragmentBottomBar.a(this.a))).intValue();
    this.a.a(i);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\faces\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */