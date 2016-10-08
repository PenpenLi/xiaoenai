package com.xiaoenai.app.model.mall;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CommentInfo
{
  public static final String MALL_COMMENT_ID_KEY = "mall_comment_id_key";
  public static final int MALL_COMMENT_REPORT_REQ_CODE = 100;
  public static final int MALL_DEFAULT_MAX_COMMENTINFO_SIZE = 20;
  public String content;
  public String couplePhoto;
  public long createdAt;
  public int id;
  public String name;
  public int productId;
  public int uid = 0;
  
  public CommentInfo(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("id")) {
        this.id = paramJSONObject.getInt("id");
      }
      if (paramJSONObject.has("uid")) {
        this.uid = paramJSONObject.getInt("uid");
      }
      if (paramJSONObject.has("product_id")) {
        this.productId = paramJSONObject.getInt("product_id");
      }
      if (paramJSONObject.has("name")) {
        this.name = paramJSONObject.getString("name");
      }
      if (paramJSONObject.has("content")) {
        this.content = paramJSONObject.getString("content");
      }
      if (paramJSONObject.has("couple_photo")) {
        this.couplePhoto = paramJSONObject.getString("couple_photo");
      }
      if (paramJSONObject.has("created_at")) {
        this.createdAt = paramJSONObject.getLong("created_at");
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static ArrayList<CommentInfo> getCommentsFromJson(JSONArray paramJSONArray)
  {
    localArrayList = new ArrayList();
    int i = 0;
    try
    {
      while (i < paramJSONArray.length())
      {
        localArrayList.add(new CommentInfo(paramJSONArray.getJSONObject(i)));
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  public static List<CommentInfo> getCommentsFromJson(JSONObject paramJSONObject)
  {
    localArrayList = new ArrayList();
    if (paramJSONObject.has("list")) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("list");
        int i = 0;
        while (i < paramJSONObject.length())
        {
          localArrayList.add(new CommentInfo(paramJSONObject.getJSONObject(i)));
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\mall\CommentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */