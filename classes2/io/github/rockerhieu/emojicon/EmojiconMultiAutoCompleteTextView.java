package io.github.rockerhieu.emojicon;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.util.AttributeSet;

public class EmojiconMultiAutoCompleteTextView
  extends AppCompatMultiAutoCompleteTextView
{
  private int a;
  private int b;
  private int c;
  private boolean d = false;
  
  public EmojiconMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public EmojiconMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a()
  {
    a.a(getContext(), getText(), this.a, this.b, this.c, this.d);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, c.b.Emojicon);
    this.a = ((int)paramAttributeSet.getDimension(c.b.Emojicon_emojiconSize, getTextSize()));
    this.b = paramAttributeSet.getInt(c.b.Emojicon_emojiconAlignment, 1);
    this.d = paramAttributeSet.getBoolean(c.b.Emojicon_emojiconUseSystemDefault, false);
    paramAttributeSet.recycle();
    this.c = ((int)getTextSize());
    setText(getText());
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    a();
  }
  
  public void setEmojiconSize(int paramInt)
  {
    this.a = paramInt;
    a();
  }
  
  public void setUseSystemDefault(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\io\github\rockerhieu\emojicon\EmojiconMultiAutoCompleteTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */