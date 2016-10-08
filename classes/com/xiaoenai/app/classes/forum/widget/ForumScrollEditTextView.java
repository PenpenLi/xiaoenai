package com.xiaoenai.app.classes.forum.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.xiaoenai.app.utils.ab;

public class ForumScrollEditTextView
  extends ScrollView
{
  private LinearLayout a = null;
  private a b;
  
  public ForumScrollEditTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ForumScrollEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
    b();
  }
  
  public ForumScrollEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private void a()
  {
    this.a = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2130903214, null));
    addView(this.a);
    this.b = new a();
    this.b.a = ((EditText)this.a.findViewById(2131559298));
    this.b.b = ((GridView)this.a.findViewById(2131559299));
    this.b.c = ((LinearLayout)this.a.findViewById(2131559300));
    this.b.d = ((ImageView)this.a.findViewById(2131559301));
  }
  
  private void b()
  {
    int i = ab.a();
    float f = 0.15F;
    if ((i >= 1280) && (i < 1800)) {
      f = 0.2F;
    }
    for (;;)
    {
      this.b.a.setMinHeight((int)(f * i));
      return;
      if (i >= 1800) {
        f = 0.25F;
      }
    }
  }
  
  public a getViewHolder()
  {
    return this.b;
  }
  
  public class a
  {
    public EditText a;
    public GridView b;
    public LinearLayout c;
    public ImageView d;
    
    public a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\widget\ForumScrollEditTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */