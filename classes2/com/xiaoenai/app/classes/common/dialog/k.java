package com.xiaoenai.app.classes.common.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.ui.component.view.AvatarView;

public class k
  extends a
{
  private View a;
  private View b;
  private TextView c;
  private View d;
  private AvatarView e;
  private TextView f;
  private TextView g;
  private GestureDetector h;
  private Animation i;
  private Animation j;
  
  public k(Context paramContext)
  {
    this(paramContext, 2131296448);
  }
  
  public k(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.a = LayoutInflater.from(paramContext).inflate(2130903136, null);
    a(this.a);
  }
  
  private void a(View paramView)
  {
    this.b = paramView.findViewById(2131558824);
    this.c = ((TextView)paramView.findViewById(2131558923));
    this.d = paramView.findViewById(2131558690);
    this.e = ((AvatarView)paramView.findViewById(2131558924));
    this.f = ((TextView)paramView.findViewById(2131558925));
    this.g = ((TextView)paramView.findViewById(2131558926));
    ((Button)paramView.findViewById(2131558927)).setOnClickListener(new l(this));
    this.h = new GestureDetector(getContext(), new a(null));
    this.a.setOnTouchListener(new m(this));
    this.i = AnimationUtils.loadAnimation(getContext(), 2130968593);
    this.j = AnimationUtils.loadAnimation(getContext(), 2130968594);
    this.j.setAnimationListener(new n(this));
  }
  
  public TextView a()
  {
    return this.f;
  }
  
  public void a(int paramInt)
  {
    this.e.setImageResource(paramInt);
    this.d.setVisibility(0);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.f.setOnClickListener(paramOnClickListener);
  }
  
  public void a(CharSequence paramCharSequence, int paramInt)
  {
    this.f.setVisibility(0);
    this.f.setText(paramCharSequence);
    this.f.setGravity(paramInt);
  }
  
  public TextView b()
  {
    return this.g;
  }
  
  public void b(int paramInt)
  {
    this.c.setVisibility(0);
    this.c.setText(paramInt);
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.g.setOnClickListener(paramOnClickListener);
  }
  
  public void b(CharSequence paramCharSequence, int paramInt)
  {
    this.g.setVisibility(0);
    this.g.setText(paramCharSequence);
    this.g.setGravity(paramInt);
    paramCharSequence = (LinearLayout.LayoutParams)this.f.getLayoutParams();
    paramCharSequence.bottomMargin = 0;
    this.f.setLayoutParams(paramCharSequence);
  }
  
  public void dismiss()
  {
    this.b.clearAnimation();
    this.b.startAnimation(this.j);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.a);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.b.clearAnimation();
    this.b.startAnimation(this.i);
    this.b.setVisibility(0);
  }
  
  private class a
    implements GestureDetector.OnGestureListener
  {
    private a() {}
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if ((paramMotionEvent1.getY() - paramMotionEvent2.getY() > 50.0F) && (Math.abs(paramFloat2) > 20.0F))
      {
        k.this.dismiss();
        return true;
      }
      return false;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent) {}
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return true;
    }
    
    public void onShowPress(MotionEvent paramMotionEvent) {}
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\dialog\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */