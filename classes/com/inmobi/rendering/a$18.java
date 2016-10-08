package com.inmobi.rendering;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.rendering.mraid.MraidMediaProcessor;
import com.inmobi.rendering.mraid.MraidMediaProcessor.MediaContentType;
import com.inmobi.rendering.mraid.b;
import com.inmobi.rendering.mraid.f;

class a$18
  implements Runnable
{
  a$18(a parama, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4, String paramString5, boolean paramBoolean3) {}
  
  public void run()
  {
    if (((this.a == null) || (this.a.trim().length() == 0)) && ((this.b == null) || (this.b.trim().length() == 0) || (!this.b.startsWith("http"))))
    {
      a.a(this.i).a(this.c, "Null or empty or invalid media playback URL supplied", "playVideo");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a.a(), "Media player properties");
    Logger.a(Logger.InternalLogLevel.INTERNAL, a.a(), "shouldAutoPlay: " + this.d + "; shouldLoopPlayback: " + this.e + "; startStyle: " + this.f + "; stopStyle: " + this.g);
    b localb = new b();
    localb.a = 0;
    localb.b = 0;
    localb.c = 24;
    localb.d = 24;
    f localf = new f();
    if ((this.a == null) || (this.a.length() != 0)) {
      localf.a = this.a;
    }
    if (!a.a(this.i).getMediaProcessor().a())
    {
      localf.d = this.d;
      localf.f = this.e;
      localf.b = this.f;
      localf.c = this.g;
      localf.e = this.h;
    }
    a.a(this.i).getMediaProcessor().a(localb);
    a.a(this.i).getMediaProcessor().a(localf);
    a.a(this.i).a(this.c, this.b, MraidMediaProcessor.MediaContentType.MEDIA_CONTENT_TYPE_AUDIO);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\a$18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */