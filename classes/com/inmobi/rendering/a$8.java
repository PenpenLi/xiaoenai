package com.inmobi.rendering;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.commons.core.utilities.info.c;
import com.inmobi.rendering.mraid.MraidMediaProcessor;
import com.inmobi.rendering.mraid.MraidMediaProcessor.MediaContentType;
import com.inmobi.rendering.mraid.b;
import com.inmobi.rendering.mraid.f;

class a$8
  implements Runnable
{
  a$8(a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean3, boolean paramBoolean4) {}
  
  public void run()
  {
    int i2 = 0;
    Logger.a(Logger.InternalLogLevel.INTERNAL, a.a(), "JavaScript called: playVideo (" + this.a + ", " + this.b + ")");
    if (((this.b == null) || (this.b.trim().length() == 0)) && ((this.a == null) || (this.a.trim().length() == 0) || (!this.a.startsWith("http"))))
    {
      a.a(this.n).a(this.c, "Null or empty or invalid media playback URL supplied", "playVideo");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a.a(), "Video dimensions: (" + this.d + ", " + this.e + ")");
    Logger.a(Logger.InternalLogLevel.INTERNAL, a.a(), "Media player properties");
    Logger.a(Logger.InternalLogLevel.INTERNAL, a.a(), "shouldAutoPlay: " + this.f + "; shouldLoopPlayback: " + this.g + "; startStyle: " + this.h + "; stopStyle: " + this.i);
    b localb = new b();
    f localf = new f();
    if ((this.b == null) || (this.b.length() != 0)) {
      localf.a = this.b;
    }
    int i5 = a.a(this.d);
    int i6 = a.a(this.e);
    int i4 = a.a(this.j);
    int i3 = a.a(this.k);
    if (((-99999 == i5) && (-99999 == i6)) || (i5 <= 0) || (i6 <= 0))
    {
      localf.b = "fullscreen";
      if (!a.a(this.n).getMediaProcessor().a())
      {
        localf.g = this.l;
        localf.d = this.f;
        localf.f = this.g;
        localf.c = this.i;
        localf.e = this.m;
      }
      a.a(this.n).getMediaProcessor().a(localb);
      a.a(this.n).getMediaProcessor().a(localf);
      a.a(this.n).a(this.c, this.a, MraidMediaProcessor.MediaContentType.MEDIA_CONTENT_TYPE_AUDIO_VIDEO);
      return;
    }
    float f1 = DisplayInfo.a().c();
    int i1 = i4;
    if (i4 == -99999) {
      i1 = 0;
    }
    if (i3 == -99999) {}
    for (;;)
    {
      localb.a = ((int)(i1 * f1 + 0.5F));
      localb.b = ((int)(i2 * f1 + 0.5F));
      localb.c = ((int)(i5 * f1 + 0.5F));
      localb.d = ((int)(i6 * f1 + 0.5F));
      localf.b = this.h;
      break;
      i2 = i3;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\a$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */