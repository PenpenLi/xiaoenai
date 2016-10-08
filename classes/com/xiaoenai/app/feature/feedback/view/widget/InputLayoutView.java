package com.xiaoenai.app.feature.feedback.view.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnTextChanged;
import butterknife.OnTextChanged.Callback;
import butterknife.OnTouch;
import com.xiaoenai.app.feature.feedback.a.c;
import com.xiaoenai.app.feature.feedback.a.d;
import com.xiaoenai.app.feature.feedback.a.e;
import com.xiaoenai.app.ui.component.view.keyboard.AutoHeightLayout;
import com.xiaoenai.app.ui.component.view.keyboard.FuncLayout;
import com.xiaoenai.app.ui.component.view.keyboard.FuncLayout.a;
import com.xiaoenai.app.ui.component.view.keyboard.FuncLayout.b;
import com.xiaoenai.app.utils.d.l;

public class InputLayoutView
  extends AutoHeightLayout
  implements View.OnClickListener, FuncLayout.a
{
  private a g;
  @BindView(2131230861)
  ImageView ivCamera;
  @BindView(2131230863)
  Button mBtnSend;
  @BindView(2131230862)
  EditText mEtChat;
  @BindView(2131230864)
  FuncLayout mLyKvml;
  
  public InputLayoutView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(a.e.view_input, this);
    ButterKnife.bind(this);
    this.mLyKvml.setOnFuncChangeListener(this);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString.trim())) {}
    while (this.g == null) {
      return;
    }
    this.g.b(paramString);
  }
  
  private void d()
  {
    if (this.g != null) {
      this.g.g();
    }
  }
  
  public void a()
  {
    l.a(this);
    this.mLyKvml.a();
  }
  
  public void a(int paramInt)
  {
    this.mLyKvml.a(paramInt);
  }
  
  public void a(FuncLayout.b paramb)
  {
    this.mLyKvml.a(paramb);
  }
  
  @OnTextChanged(callback=OnTextChanged.Callback.AFTER_TEXT_CHANGED, value={2131230862})
  void afterTextChanged(Editable paramEditable)
  {
    if (!TextUtils.isEmpty(paramEditable))
    {
      this.mBtnSend.setBackgroundResource(a.c.shape_btn_send_bg);
      this.mBtnSend.setEnabled(true);
      return;
    }
    this.mBtnSend.setBackgroundResource(a.c.shape_btn_send_bg_disable);
    this.mBtnSend.setEnabled(false);
  }
  
  public void b()
  {
    super.b();
    if (this.mLyKvml.b())
    {
      a();
      return;
    }
    b(this.mLyKvml.getCurrentFuncKey());
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    super.c(paramInt);
    this.mLyKvml.setVisibility(true);
    this.mLyKvml.getClass();
    b(Integer.MIN_VALUE);
  }
  
  public EditText getInputEditText()
  {
    return this.mEtChat;
  }
  
  @OnClick({2131230861, 2131230863})
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == a.d.iv_camera) {
      d();
    }
    while (i != a.d.btn_send) {
      return;
    }
    a(this.mEtChat.getText().toString());
  }
  
  @OnEditorAction({2131230862})
  boolean onEditorAction()
  {
    String str = this.mEtChat.getText().toString().trim();
    if (str.length() > 0) {
      a(str);
    }
    return true;
  }
  
  @OnTouch({2131230862})
  boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.mEtChat.isFocused())
    {
      this.mEtChat.setFocusable(true);
      this.mEtChat.setFocusableInTouchMode(true);
    }
    return false;
  }
  
  public void setListener(a parama)
  {
    this.g = parama;
  }
  
  public void setUnSendText(String paramString)
  {
    if (this.mEtChat != null)
    {
      this.mEtChat.setText(paramString);
      this.mEtChat.setSelection(this.mEtChat.getText().length());
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString);
    
    public abstract void g();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\widget\InputLayoutView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */