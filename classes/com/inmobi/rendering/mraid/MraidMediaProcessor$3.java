package com.inmobi.rendering.mraid;

import android.view.ViewGroup;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.rendering.RenderView;
import java.util.Hashtable;

class MraidMediaProcessor$3
  implements g.c
{
  MraidMediaProcessor$3(MraidMediaProcessor paramMraidMediaProcessor) {}
  
  public void a(g paramg)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, MraidMediaProcessor.i(), ">>> onPlayerCompleted");
    MraidMediaProcessor.b(this.a).setAdActiveFlag(false);
    ViewGroup localViewGroup = paramg.f();
    if (localViewGroup != null) {
      ((ViewGroup)localViewGroup.getParent()).removeView(localViewGroup);
    }
    paramg.a(null);
    try
    {
      if ((MraidMediaProcessor.a(this.a) != null) && (paramg.f.equalsIgnoreCase(MraidMediaProcessor.a(this.a).f)))
      {
        MraidMediaProcessor.c(this.a).remove(MraidMediaProcessor.a(this.a).f);
        MraidMediaProcessor.a(this.a, null);
      }
      return;
    }
    finally {}
  }
  
  public void b(g paramg)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, MraidMediaProcessor.i(), ">>> onPlayerPrepared");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\MraidMediaProcessor$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */