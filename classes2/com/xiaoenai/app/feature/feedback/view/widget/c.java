package com.xiaoenai.app.feature.feedback.view.widget;

import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.feature.feedback.a.d;
import com.xiaoenai.app.ui.component.view.keyboard.FuncLayout;

public class c<T extends InputLayoutView>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private TextWatcher d;
  private View e;
  
  public c(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    View localView = paramFinder.findRequiredView(paramObject, a.d.iv_camera, "field 'ivCamera' and method 'onClick'");
    paramT.ivCamera = ((ImageView)paramFinder.castView(localView, a.d.iv_camera, "field 'ivCamera'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new d(this, paramT));
    localView = paramFinder.findRequiredView(paramObject, a.d.etv_input, "field 'mEtChat', method 'onEditorAction', method 'afterTextChanged', and method 'onTouch'");
    paramT.mEtChat = ((EditText)paramFinder.castView(localView, a.d.etv_input, "field 'mEtChat'", EditText.class));
    this.c = localView;
    ((TextView)localView).setOnEditorActionListener(new e(this, paramT));
    this.d = new f(this, paramT);
    ((TextView)localView).addTextChangedListener(this.d);
    localView.setOnTouchListener(new g(this, paramT));
    localView = paramFinder.findRequiredView(paramObject, a.d.btn_send, "field 'mBtnSend' and method 'onClick'");
    paramT.mBtnSend = ((Button)paramFinder.castView(localView, a.d.btn_send, "field 'mBtnSend'", Button.class));
    this.e = localView;
    localView.setOnClickListener(new h(this, paramT));
    paramT.mLyKvml = ((FuncLayout)paramFinder.findRequiredViewAsType(paramObject, a.d.fl_keyboard, "field 'mLyKvml'", FuncLayout.class));
  }
  
  public void unbind()
  {
    InputLayoutView localInputLayoutView = this.a;
    if (localInputLayoutView == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localInputLayoutView.ivCamera = null;
    localInputLayoutView.mEtChat = null;
    localInputLayoutView.mBtnSend = null;
    localInputLayoutView.mLyKvml = null;
    this.b.setOnClickListener(null);
    this.b = null;
    ((TextView)this.c).setOnEditorActionListener(null);
    ((TextView)this.c).removeTextChangedListener(this.d);
    this.d = null;
    this.c.setOnTouchListener(null);
    this.c = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\widget\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */