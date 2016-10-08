package com.xiaoenai.app.classes.gameCenter.b;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import com.xiaoenai.app.classes.gameCenter.a.a.a;
import com.xiaoenai.app.classes.gameCenter.model.GameEntry;
import com.xiaoenai.app.model.RedHintsInfo;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.widget.remindButton.RemindButton;

public class a
{
  private static void a(a.a parama, RedHintsInfo paramRedHintsInfo)
  {
    if ((paramRedHintsInfo != null) && (paramRedHintsInfo.isShow()))
    {
      if (2 == paramRedHintsInfo.getStyle())
      {
        com.xiaoenai.app.widget.remindButton.a.a().a(parama.g, paramRedHintsInfo);
        return;
      }
      com.xiaoenai.app.widget.remindButton.a.a().a(parama.f, paramRedHintsInfo);
      return;
    }
    parama.f.b();
    parama.g.b();
  }
  
  public static void a(GameEntry paramGameEntry, a.a parama)
  {
    if (paramGameEntry.getIcon_url() != null)
    {
      int i = ab.a(50.0F);
      b.b(parama.a, paramGameEntry.getIcon_url() + "?imageView/1/w/" + i + "/h/" + i, 24);
    }
    parama.b.setText(paramGameEntry.getName());
    parama.c.setText(paramGameEntry.getIntro());
    parama.d.setVisibility(0);
    if (paramGameEntry.getStartType() == 1)
    {
      parama.d.setBackgroundResource(2130838489);
      parama.d.setText(2131100521);
      parama.d.setTextColor(parama.d.getContext().getResources().getColor(2131493206));
    }
    for (;;)
    {
      a(parama, paramGameEntry.getRedHintsInfo());
      return;
      if (paramGameEntry.getDownload_state() == -1)
      {
        parama.d.setBackgroundResource(2130839084);
        parama.d.setText(2131101308);
        parama.d.setTextColor(parama.d.getContext().getResources().getColor(2131493073));
      }
      else
      {
        parama.d.setBackgroundResource(2130838489);
        parama.d.setText(2131100521);
        parama.d.setTextColor(parama.d.getContext().getResources().getColor(2131493206));
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */