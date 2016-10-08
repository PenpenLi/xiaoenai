package com.sina.weibo.sdk.api.share.ui;

import android.content.Context;
import android.text.Editable;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EditBlogView
  extends EditText
{
  private boolean canSelectionChanged = true;
  private int count;
  private Context ctx;
  private List<OnSelectionListener> listeners;
  private OnEnterListener mOnEnterListener;
  
  public EditBlogView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public EditBlogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public EditBlogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.ctx = getContext();
    this.listeners = new ArrayList();
  }
  
  public int correctPosition(int paramInt)
  {
    if (paramInt == -1) {}
    Editable localEditable;
    Object[] arrayOfObject;
    do
    {
      do
      {
        return paramInt;
        localEditable = getText();
      } while (paramInt >= localEditable.length());
      arrayOfObject = localEditable.getSpans(paramInt, paramInt, ImageSpan.class);
    } while ((arrayOfObject == null) || (arrayOfObject.length == 0) || (paramInt == localEditable.getSpanStart(arrayOfObject[0])));
    return localEditable.getSpanEnd(arrayOfObject[0]);
  }
  
  public void enableSelectionChanged(boolean paramBoolean)
  {
    this.canSelectionChanged = paramBoolean;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return new EditBlogView.1(this, super.onCreateInputConnection(paramEditorInfo), false);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 66) && (this.mOnEnterListener != null)) {
      this.mOnEnterListener.onEnterKey();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    if ((!this.canSelectionChanged) || (this.listeners == null) || (this.listeners.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext()) {
        ((OnSelectionListener)localIterator.next()).onSelectionChanged(paramInt1, paramInt2);
      }
    }
  }
  
  public void setOnEnterListener(OnEnterListener paramOnEnterListener)
  {
    this.mOnEnterListener = paramOnEnterListener;
  }
  
  public void setOnSelectionListener(OnSelectionListener paramOnSelectionListener)
  {
    this.listeners.add(paramOnSelectionListener);
  }
  
  public static abstract interface OnEnterListener
  {
    public abstract void onEnterKey();
  }
  
  public static abstract interface OnSelectionListener
  {
    public abstract void onSelectionChanged(int paramInt1, int paramInt2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\api\share\ui\EditBlogView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */