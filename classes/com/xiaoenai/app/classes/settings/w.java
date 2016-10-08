package com.xiaoenai.app.classes.settings;

import com.xiaoenai.app.classes.chat.messagelist.message.a.a;
import com.xiaoenai.app.classes.settings.feedback.p;
import java.util.Vector;

class w
  implements p
{
  w(SettingFeedbackActivity paramSettingFeedbackActivity) {}
  
  public void a(a parama)
  {
    if (SettingFeedbackActivity.a(this.a) != null)
    {
      SettingFeedbackActivity.a(this.a).remove(parama);
      SettingFeedbackActivity.a(this.a, SettingFeedbackActivity.a(this.a).toArray());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */