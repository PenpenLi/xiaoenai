package com.xiaoenai.app.widget.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.R.styleable;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.an;

@SuppressLint({"NewApi"})
public class ShareListItem
  extends RelativeLayout
{
  private int a = 1;
  private int b = 2;
  private int c = 3;
  private ImageView d;
  private TextView e;
  private Button f;
  
  public ShareListItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ShareListItem);
    for (;;)
    {
      try
      {
        this.d = new ImageView(getContext());
        this.d.setId(this.a);
        paramAttributeSet = new RelativeLayout.LayoutParams(-2, -2);
        if (isInEditMode())
        {
          paramAttributeSet.leftMargin = 24;
          paramAttributeSet.addRule(15);
          paramAttributeSet.addRule(9);
          addView(this.d, paramAttributeSet);
          if (paramContext.hasValue(1)) {
            setIcon(paramContext.getDrawable(1));
          }
          this.f = new Button(getContext());
          this.f.setId(this.c);
          paramAttributeSet = new RelativeLayout.LayoutParams(-2, -2);
          if (isInEditMode())
          {
            paramAttributeSet.rightMargin = 12;
            paramAttributeSet.height = 45;
            paramAttributeSet.width = 96;
            paramAttributeSet.addRule(11);
            paramAttributeSet.addRule(15);
            this.f.setTextSize(2, 12.0F);
            addView(this.f, paramAttributeSet);
            if (paramContext.hasValue(3)) {
              setIsBind(Boolean.valueOf(paramContext.getBoolean(3, false)));
            }
            this.e = new TextView(getContext());
            this.e.setId(this.b);
            paramAttributeSet = new RelativeLayout.LayoutParams(-2, -2);
            paramAttributeSet.addRule(1, this.d.getId());
            paramAttributeSet.addRule(15);
            if (!isInEditMode()) {
              break label456;
            }
            paramAttributeSet.leftMargin = 12;
            this.e.setTextColor(-14540254);
            this.e.setTextSize(2, 14.0F);
            this.e.setLines(1);
            addView(this.e, paramAttributeSet);
            if (paramContext.hasValue(2)) {
              setTitle(paramContext.getString(2));
            }
            if (paramContext.hasValue(0)) {
              setBackgroundWithPosition(paramContext.getInt(0, 0));
            }
            paramContext.recycle();
            setClickable(false);
            if (getLayoutParams() != null)
            {
              if (!isInEditMode()) {
                break;
              }
              getLayoutParams().height = 78;
            }
          }
        }
        else
        {
          paramAttributeSet.leftMargin = ab.a(16.0F);
          continue;
        }
        paramAttributeSet.rightMargin = ab.a(8.0F);
      }
      finally
      {
        paramContext.recycle();
      }
      paramAttributeSet.height = ab.a(30.0F);
      paramAttributeSet.width = ab.a(64.0F);
      continue;
      label456:
      paramAttributeSet.leftMargin = ab.a(8.0F);
    }
    getLayoutParams().height = ab.a(52.0F);
  }
  
  private void setBackgroundWithPosition(int paramInt)
  {
    setBackgroundResource(2130839054);
    ImageView localImageView;
    RelativeLayout.LayoutParams localLayoutParams;
    if ((paramInt == 0) || (paramInt == 1))
    {
      localImageView = new ImageView(getContext());
      localImageView.setBackgroundColor(getResources().getColor(2131493097));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
      localLayoutParams.addRule(12);
      if (!isInEditMode()) {
        break label76;
      }
    }
    label76:
    for (localLayoutParams.leftMargin = 24;; localLayoutParams.leftMargin = ab.a(16.0F))
    {
      addView(localImageView, localLayoutParams);
      return;
    }
  }
  
  public void setButtonEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setEnabled(true);
      return;
    }
    this.f.setBackgroundResource(2130839085);
    this.f.setEnabled(false);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    if (an.a() >= 16)
    {
      this.d.setBackground(paramDrawable);
      return;
    }
    this.d.setBackgroundDrawable(paramDrawable);
  }
  
  public void setIsBind(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      this.f.setText(2131101231);
      this.f.setBackgroundResource(2130839085);
      this.f.setTextColor(-5066062);
      return;
    }
    this.f.setText(2131101224);
    this.f.setBackgroundResource(2130839084);
    this.f.setTextColor(-764523);
  }
  
  public void setOnButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.f.setOnClickListener(paramOnClickListener);
  }
  
  public void setTitle(String paramString)
  {
    this.e.setText(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\settings\ShareListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */