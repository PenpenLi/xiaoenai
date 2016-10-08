package com.xiaoenai.app.database.bean;

import a.a.a.g;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class AlbumDataDao
  extends a.a.a.a<AlbumData, Long>
{
  public static final String TABLENAME = "ALBUM_DATA";
  
  public AlbumDataDao(a.a.a.c.a parama)
  {
    super(parama);
  }
  
  public AlbumDataDao(a.a.a.c.a parama, DaoSession paramDaoSession)
  {
    super(parama, paramDaoSession);
  }
  
  public static void createTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "IF NOT EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "\"ALBUM_DATA\" (" + "\"WIDTH\" INTEGER," + "\"IS_ORIGIN\" INTEGER," + "\"ID\" INTEGER PRIMARY KEY ," + "\"HEIGHT\" INTEGER," + "\"SIZE\" INTEGER," + "\"GROUP_ID\" INTEGER," + "\"URL\" TEXT," + "\"FEELING\" TEXT," + "\"CREATED_TS\" INTEGER);");
      return;
    }
  }
  
  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("DROP TABLE ");
    if (paramBoolean) {}
    for (String str = "IF EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "\"ALBUM_DATA\"");
      return;
    }
  }
  
  protected void bindValues(SQLiteStatement paramSQLiteStatement, AlbumData paramAlbumData)
  {
    paramSQLiteStatement.clearBindings();
    Object localObject = paramAlbumData.getWidth();
    if (localObject != null) {
      paramSQLiteStatement.bindLong(1, ((Integer)localObject).intValue());
    }
    localObject = paramAlbumData.getIsOrigin();
    if (localObject != null) {
      if (!((Boolean)localObject).booleanValue()) {
        break label176;
      }
    }
    label176:
    for (long l = 1L;; l = 0L)
    {
      paramSQLiteStatement.bindLong(2, l);
      localObject = paramAlbumData.getId();
      if (localObject != null) {
        paramSQLiteStatement.bindLong(3, ((Long)localObject).longValue());
      }
      localObject = paramAlbumData.getHeight();
      if (localObject != null) {
        paramSQLiteStatement.bindLong(4, ((Integer)localObject).intValue());
      }
      localObject = paramAlbumData.getSize();
      if (localObject != null) {
        paramSQLiteStatement.bindLong(5, ((Integer)localObject).intValue());
      }
      localObject = paramAlbumData.getGroupId();
      if (localObject != null) {
        paramSQLiteStatement.bindLong(6, ((Long)localObject).longValue());
      }
      localObject = paramAlbumData.getUrl();
      if (localObject != null) {
        paramSQLiteStatement.bindString(7, (String)localObject);
      }
      localObject = paramAlbumData.getFeeling();
      if (localObject != null) {
        paramSQLiteStatement.bindString(8, (String)localObject);
      }
      paramAlbumData = paramAlbumData.getCreatedTs();
      if (paramAlbumData != null) {
        paramSQLiteStatement.bindLong(9, paramAlbumData.longValue());
      }
      return;
    }
  }
  
  public Long getKey(AlbumData paramAlbumData)
  {
    if (paramAlbumData != null) {
      return paramAlbumData.getId();
    }
    return null;
  }
  
  protected boolean isEntityUpdateable()
  {
    return true;
  }
  
  public AlbumData readEntity(Cursor paramCursor, int paramInt)
  {
    Object localObject = null;
    Integer localInteger1;
    Boolean localBoolean;
    Long localLong1;
    label47:
    Integer localInteger2;
    label62:
    Integer localInteger3;
    label77:
    Long localLong2;
    label92:
    String str1;
    label108:
    String str2;
    if (paramCursor.isNull(paramInt + 0))
    {
      localInteger1 = null;
      if (!paramCursor.isNull(paramInt + 1)) {
        break label180;
      }
      localBoolean = null;
      if (!paramCursor.isNull(paramInt + 2)) {
        break label211;
      }
      localLong1 = null;
      if (!paramCursor.isNull(paramInt + 3)) {
        break label228;
      }
      localInteger2 = null;
      if (!paramCursor.isNull(paramInt + 4)) {
        break label245;
      }
      localInteger3 = null;
      if (!paramCursor.isNull(paramInt + 5)) {
        break label262;
      }
      localLong2 = null;
      if (!paramCursor.isNull(paramInt + 6)) {
        break label279;
      }
      str1 = null;
      if (!paramCursor.isNull(paramInt + 7)) {
        break label294;
      }
      str2 = null;
      label124:
      if (!paramCursor.isNull(paramInt + 8)) {
        break label309;
      }
    }
    label180:
    label211:
    label228:
    label245:
    label262:
    label279:
    label294:
    label309:
    for (paramCursor = (Cursor)localObject;; paramCursor = Long.valueOf(paramCursor.getLong(paramInt + 8)))
    {
      return new AlbumData(localInteger1, localBoolean, localLong1, localInteger2, localInteger3, localLong2, str1, str2, paramCursor);
      localInteger1 = Integer.valueOf(paramCursor.getInt(paramInt + 0));
      break;
      if (paramCursor.getShort(paramInt + 1) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localBoolean = Boolean.valueOf(bool);
        break;
      }
      localLong1 = Long.valueOf(paramCursor.getLong(paramInt + 2));
      break label47;
      localInteger2 = Integer.valueOf(paramCursor.getInt(paramInt + 3));
      break label62;
      localInteger3 = Integer.valueOf(paramCursor.getInt(paramInt + 4));
      break label77;
      localLong2 = Long.valueOf(paramCursor.getLong(paramInt + 5));
      break label92;
      str1 = paramCursor.getString(paramInt + 6);
      break label108;
      str2 = paramCursor.getString(paramInt + 7);
      break label124;
    }
  }
  
  public void readEntity(Cursor paramCursor, AlbumData paramAlbumData, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramCursor.isNull(paramInt + 0))
    {
      localObject1 = null;
      paramAlbumData.setWidth((Integer)localObject1);
      if (!paramCursor.isNull(paramInt + 1)) {
        break label212;
      }
      localObject1 = null;
      paramAlbumData.setIsOrigin((Boolean)localObject1);
      if (!paramCursor.isNull(paramInt + 2)) {
        break label243;
      }
      localObject1 = null;
      label60:
      paramAlbumData.setId((Long)localObject1);
      if (!paramCursor.isNull(paramInt + 3)) {
        break label260;
      }
      localObject1 = null;
      label81:
      paramAlbumData.setHeight((Integer)localObject1);
      if (!paramCursor.isNull(paramInt + 4)) {
        break label277;
      }
      localObject1 = null;
      label102:
      paramAlbumData.setSize((Integer)localObject1);
      if (!paramCursor.isNull(paramInt + 5)) {
        break label294;
      }
      localObject1 = null;
      label123:
      paramAlbumData.setGroupId((Long)localObject1);
      if (!paramCursor.isNull(paramInt + 6)) {
        break label311;
      }
      localObject1 = null;
      label145:
      paramAlbumData.setUrl((String)localObject1);
      if (!paramCursor.isNull(paramInt + 7)) {
        break label326;
      }
      localObject1 = null;
      label167:
      paramAlbumData.setFeeling((String)localObject1);
      if (!paramCursor.isNull(paramInt + 8)) {
        break label341;
      }
    }
    label212:
    label243:
    label260:
    label277:
    label294:
    label311:
    label326:
    label341:
    for (paramCursor = (Cursor)localObject2;; paramCursor = Long.valueOf(paramCursor.getLong(paramInt + 8)))
    {
      paramAlbumData.setCreatedTs(paramCursor);
      return;
      localObject1 = Integer.valueOf(paramCursor.getInt(paramInt + 0));
      break;
      if (paramCursor.getShort(paramInt + 1) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = Boolean.valueOf(bool);
        break;
      }
      localObject1 = Long.valueOf(paramCursor.getLong(paramInt + 2));
      break label60;
      localObject1 = Integer.valueOf(paramCursor.getInt(paramInt + 3));
      break label81;
      localObject1 = Integer.valueOf(paramCursor.getInt(paramInt + 4));
      break label102;
      localObject1 = Long.valueOf(paramCursor.getLong(paramInt + 5));
      break label123;
      localObject1 = paramCursor.getString(paramInt + 6);
      break label145;
      localObject1 = paramCursor.getString(paramInt + 7);
      break label167;
    }
  }
  
  public Long readKey(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 2)) {
      return null;
    }
    return Long.valueOf(paramCursor.getLong(paramInt + 2));
  }
  
  protected Long updateKeyAfterInsert(AlbumData paramAlbumData, long paramLong)
  {
    paramAlbumData.setId(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }
  
  public static class Properties
  {
    public static final g CreatedTs = new g(8, Long.class, "createdTs", false, "CREATED_TS");
    public static final g Feeling;
    public static final g GroupId;
    public static final g Height;
    public static final g Id;
    public static final g IsOrigin;
    public static final g Size;
    public static final g Url;
    public static final g Width = new g(0, Integer.class, "width", false, "WIDTH");
    
    static
    {
      IsOrigin = new g(1, Boolean.class, "isOrigin", false, "IS_ORIGIN");
      Id = new g(2, Long.class, "id", true, "ID");
      Height = new g(3, Integer.class, "height", false, "HEIGHT");
      Size = new g(4, Integer.class, "size", false, "SIZE");
      GroupId = new g(5, Long.class, "groupId", false, "GROUP_ID");
      Url = new g(6, String.class, "url", false, "URL");
      Feeling = new g(7, String.class, "feeling", false, "FEELING");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\database\bean\AlbumDataDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */