package butterknife;

import android.support.annotation.IdRes;
import butterknife.internal.ListenerClass;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(method={@butterknife.internal.ListenerMethod(defaultReturn="false", name="onItemLongClick", parameters={"android.widget.AdapterView<?>", "android.view.View", "int", "long"}, returnType="boolean")}, setter="setOnItemLongClickListener", targetType="android.widget.AdapterView<?>", type="android.widget.AdapterView.OnItemLongClickListener")
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnItemLongClick
{
  @IdRes
  int[] value() default {-1};
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\butterknife\OnItemLongClick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */