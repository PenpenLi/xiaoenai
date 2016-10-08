package butterknife;

import android.support.annotation.IdRes;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface BindView
{
  @IdRes
  int value();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\butterknife\BindView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */