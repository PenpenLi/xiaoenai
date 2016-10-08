package d.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;

public class ci
  extends ContextWrapper
{
  private String a;
  
  public ci(Context paramContext, String paramString)
  {
    super(paramContext);
    this.a = paramString;
  }
  
  public File getDatabasePath(String paramString)
  {
    paramString = new File(this.a + paramString);
    if ((!paramString.getParentFile().exists()) && (!paramString.getParentFile().isDirectory())) {
      paramString.getParentFile().mkdirs();
    }
    return paramString;
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(paramString).getAbsolutePath(), paramCursorFactory);
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(paramString).getAbsolutePath(), paramCursorFactory, paramDatabaseErrorHandler);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */