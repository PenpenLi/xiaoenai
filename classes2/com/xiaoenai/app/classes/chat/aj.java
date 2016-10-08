package com.xiaoenai.app.classes.chat;

import com.xiaoenai.app.domain.e.d;

public final class aj
  implements dagger.a<ChatActivity>
{
  private final javax.inject.a<com.xiaoenai.app.common.a> b;
  private final javax.inject.a<com.xiaoenai.app.common.view.b.a> c;
  private final javax.inject.a<com.xiaoenai.app.common.application.a.a> d;
  private final javax.inject.a<d> e;
  
  static
  {
    if (!aj.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public aj(javax.inject.a<com.xiaoenai.app.common.a> parama, javax.inject.a<com.xiaoenai.app.common.view.b.a> parama1, javax.inject.a<com.xiaoenai.app.common.application.a.a> parama2, javax.inject.a<d> parama3)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
    if ((!a) && (parama1 == null)) {
      throw new AssertionError();
    }
    this.c = parama1;
    if ((!a) && (parama2 == null)) {
      throw new AssertionError();
    }
    this.d = parama2;
    if ((!a) && (parama3 == null)) {
      throw new AssertionError();
    }
    this.e = parama3;
  }
  
  public static dagger.a<ChatActivity> a(javax.inject.a<com.xiaoenai.app.common.a> parama, javax.inject.a<com.xiaoenai.app.common.view.b.a> parama1, javax.inject.a<com.xiaoenai.app.common.application.a.a> parama2, javax.inject.a<d> parama3)
  {
    return new aj(parama, parama1, parama2, parama3);
  }
  
  public void a(ChatActivity paramChatActivity)
  {
    if (paramChatActivity == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.xiaoenai.app.common.view.activity.a.a(paramChatActivity, this.b);
    com.xiaoenai.app.common.view.activity.a.b(paramChatActivity, this.c);
    com.xiaoenai.app.common.view.activity.a.c(paramChatActivity, this.d);
    paramChatActivity.b = ((d)this.e.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */