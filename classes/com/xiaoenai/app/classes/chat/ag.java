package com.xiaoenai.app.classes.chat;

import com.xiaoenai.app.domain.PhotoAlbum;
import com.xiaoenai.app.domain.e.d;
import java.util.List;
import org.json.JSONArray;
import rx.a;
import rx.a.a;
import rx.k;

class ag
  implements a.a<List<PhotoAlbum>>
{
  ag(ChatActivity paramChatActivity, JSONArray paramJSONArray) {}
  
  public void a(k<? super List<PhotoAlbum>> paramk)
  {
    paramk = new ah(this, paramk);
    this.b.b.b("", this.a.toString()).b(paramk);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */