package com.xiaoenai.app.classes.chat.input.faces;

import android.os.Bundle;
import com.xiaoenai.app.d.ab;
import com.xiaoenai.app.model.RecentFace;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class v
  extends a
{
  private void a()
  {
    Object localObject = this.b.a(24);
    this.a = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      RecentFace localRecentFace = (RecentFace)((Iterator)localObject).next();
      this.a.add(localRecentFace.url);
    }
    a(getView());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = new ArrayList();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d.put(this.c, Integer.valueOf(0));
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\faces\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */