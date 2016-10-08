package com.xiaoenai.app.classes.forum.fragment;

import android.widget.EditText;
import com.xiaoenai.app.classes.chat.input.faces.f;
import com.xiaoenai.app.classes.forum.ForumPostActivity;
import com.xiaoenai.app.classes.forum.ForumReplyActivity;

public class a
  extends f
{
  private int f = 30;
  
  protected int a()
  {
    return this.f;
  }
  
  public EditText b()
  {
    return ((ForumPostActivity)getActivity()).c();
  }
  
  public void c(int paramInt)
  {
    this.f = paramInt;
  }
  
  public static class a
    extends f
  {
    protected int a()
    {
      return 0;
    }
    
    public EditText b()
    {
      return ((ForumReplyActivity)getActivity()).c();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\fragment\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */