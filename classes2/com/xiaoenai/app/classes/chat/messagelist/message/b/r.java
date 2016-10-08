package com.xiaoenai.app.classes.chat.messagelist.message.b;

import android.text.util.Linkify.MatchFilter;

final class r
  implements Linkify.MatchFilter
{
  public final boolean acceptMatch(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {}
    while (paramCharSequence.charAt(paramInt1 - 1) != '@') {
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\b\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */