package com.inmobi.rendering;

import android.content.Intent;
import android.graphics.Bitmap;
import com.inmobi.ads.b.e;
import com.inmobi.rendering.mraid.e;

class a$6
  implements InMobiAdActivity.a
{
  a$6(a parama, String paramString) {}
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      paramIntent = e.a(e.a(paramIntent.getData(), a.c(this.b)), a.c(this.b), a.a(this.b).getRenderingConfig().a(), a.a(this.b).getRenderingConfig().b());
      paramInt = paramIntent.getWidth();
      int i = paramIntent.getHeight();
      paramIntent = e.a(paramIntent, a.c(this.b), a.a(this.b).getRenderingConfig().c());
      paramIntent = "fireGalleryImageSelectedEvent('" + paramIntent + "'" + "," + "'" + paramInt + "','" + i + "')";
      a.a(this.b).a(this.a, paramIntent);
      return;
    }
    a.a(this.b).a(this.a, "User did not select an image from gallery", "getGalleryImage");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\a$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */