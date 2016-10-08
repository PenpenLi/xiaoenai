package io.github.rockerhieu.emojicon;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;

public class EmojiconTextView
  extends AppCompatTextView
{
  private int a;
  private int b;
  private int c;
  private int d = 0;
  private int e = -1;
  private boolean f = false;
  
  public EmojiconTextView(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public EmojiconTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public EmojiconTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    this.c = ((int)getTextSize());
    if (paramAttributeSet == null) {
      this.a = ((int)getTextSize());
    }
    for (;;)
    {
      setText(getText());
      return;
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, c.b.Emojicon);
      this.a = ((int)paramAttributeSet.getDimension(c.b.Emojicon_emojiconSize, getTextSize()));
      this.b = paramAttributeSet.getInt(c.b.Emojicon_emojiconAlignment, 1);
      this.d = paramAttributeSet.getInteger(c.b.Emojicon_emojiconTextStart, 0);
      this.e = paramAttributeSet.getInteger(c.b.Emojicon_emojiconTextLength, -1);
      this.f = paramAttributeSet.getBoolean(c.b.Emojicon_emojiconUseSystemDefault, false);
      paramAttributeSet.recycle();
    }
  }
  
  public void setEmojiconSize(int paramInt)
  {
    this.a = paramInt;
    super.setText(getText());
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      paramCharSequence = new SpannableStringBuilder(paramCharSequence);
      a.a(getContext(), paramCharSequence, this.a, this.b, this.c, this.d, this.e, this.f);
    }
    for (;;)
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
    }
  }
  
  public void setUseSystemDefault(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\io\github\rockerhieu\emojicon\EmojiconTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */