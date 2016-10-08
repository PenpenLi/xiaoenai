package com.xiaoenai.app.classes.chat.messagelist.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.xiaoenai.app.classes.chat.input.faces.d;
import com.xiaoenai.app.utils.ab;
import io.github.rockerhieu.emojicon.EmojiconTextView;

public class o
  extends BaseItemView
{
  protected EmojiconTextView b;
  
  public o(Context paramContext)
  {
    super(paramContext);
  }
  
  public TextView getContentTextView()
  {
    return this.b;
  }
  
  public View getMsgContentView()
  {
    View localView = inflate(getContext(), 2130903116, null);
    this.b = ((EmojiconTextView)localView.findViewById(2131558856));
    this.b.setMaxWidth((int)(ab.b() * 0.53D));
    this.b.setUseSystemDefault(true);
    return localView;
  }
  
  public void setContentText(String paramString)
  {
    this.b.setText(paramString);
    this.b.requestLayout();
    d.a().b(this.b);
  }
  
  public void setImageResource(int paramInt) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\view\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */