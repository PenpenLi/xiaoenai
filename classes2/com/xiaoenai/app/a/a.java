package com.xiaoenai.app.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;

public class a
  extends ContextWrapper
{
  private String a;
  
  public a(Context paramContext, String paramString)
  {
    super(paramContext);
    this.a = paramString;
  }
  
  public File getDatabasePath(String paramString)
  {
    paramString = new File(this.a + File.separator + paramString);
    if (!paramString.getParentFile().exists()) {
      paramString.getParentFile().mkdirs();
    }
    return paramString;
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return super.openOrCreateDatabase(getDatabasePath(paramString).getAbsolutePath(), paramInt, paramCursorFactory);
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return super.openOrCreateDatabase(getDatabasePath(paramString).getAbsolutePath(), paramInt, paramCursorFactory, paramDatabaseErrorHandler);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */