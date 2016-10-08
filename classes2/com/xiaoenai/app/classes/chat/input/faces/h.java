package com.xiaoenai.app.classes.chat.input.faces;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class h
  implements View.OnClickListener
{
  h(f paramf) {}
  
  public void onClick(View paramView)
  {
    Editable localEditable = this.a.b().getEditableText();
    int i = this.a.b().getSelectionEnd();
    Object localObject = localEditable.subSequence(0, i).toString();
    if (paramView.getTag().equals(f.a(this.a)[(f.a(this.a).length - 1)]))
    {
      int j;
      if ((localObject != null) && (((String)localObject).length() != 0) && (!((String)localObject).equals("")))
      {
        if (((String)localObject).charAt(((String)localObject).length() - 1) != ']') {
          break label168;
        }
        i = ((String)localObject).lastIndexOf("[");
        j = ((String)localObject).lastIndexOf("]");
        if ((j != -1) && (i != -1) && (j > i)) {
          localEditable.delete(i, j + 1);
        }
      }
      else
      {
        return;
      }
      localEditable.delete(((String)localObject).length() - 1, ((String)localObject).length());
      return;
      label168:
      if (((String)localObject).charAt(((String)localObject).length() - 1) == '}')
      {
        i = ((String)localObject).lastIndexOf("{");
        j = ((String)localObject).lastIndexOf("}");
        if ((j != -1) && (i != -1) && (j > i))
        {
          localEditable.delete(i, j + 1);
          return;
        }
        localEditable.delete(((String)localObject).length() - 1, ((String)localObject).length());
        return;
      }
      localEditable.delete(((String)localObject).length() - 1, ((String)localObject).length());
      return;
    }
    if (d.a().b((String)paramView.getTag()) != null)
    {
      localObject = new j(this.a.getActivity(), d.a().b((String)paramView.getTag()).intValue(), (int)this.a.b().getTextSize() + f.b(this.a), (int)this.a.b().getTextSize() + f.b(this.a));
      if ((i >= 0) && (i < this.a.b().getEditableText().length())) {
        break label472;
      }
      if ((this.a.a() == 0) || (((String)paramView.getTag()).length() + i <= this.a.a()))
      {
        localEditable.append((String)paramView.getTag());
        localEditable.setSpan(localObject, i, ((String)paramView.getTag()).length() + i, 33);
        this.a.b().requestFocus();
      }
    }
    for (;;)
    {
      this.a.b().setCursorVisible(true);
      return;
      label472:
      localEditable.insert(i, (String)paramView.getTag());
      localEditable.setSpan(localObject, i, ((String)paramView.getTag()).length() + i, 33);
      this.a.b().requestFocus();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\faces\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */