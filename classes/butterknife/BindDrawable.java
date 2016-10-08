package butterknife;

import android.support.annotation.AttrRes;
import android.support.annotation.DrawableRes;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface BindDrawable
{
  @AttrRes
  int tint() default 0;
  
  @DrawableRes
  int value();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\butterknife\BindDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */