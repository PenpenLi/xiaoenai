package com.xiaoenai.app.classes.street.model;

import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import org.json.JSONArray;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="Id", b="id"), @com.xiaoenai.app.annotation.json.JsonElement(a="Name", b="name"), @com.xiaoenai.app.annotation.json.JsonElement(a="IconUrl", b="icon_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="SubScenes", b="sub_scenes")})
public class Scene
  extends a
{
  private String icon_url;
  private int id;
  private String name = "";
  private Scene root_scenes = null;
  private Scene[] sub_scenes;
  
  public Scene() {}
  
  public Scene(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(Scene.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String getIconUrl()
  {
    return this.icon_url;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Scene getRootNode()
  {
    return this.root_scenes;
  }
  
  public Scene[] getSubScenes()
  {
    return this.sub_scenes;
  }
  
  public void setIconUrl(String paramString)
  {
    this.icon_url = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setRootNode(Scene paramScene)
  {
    this.root_scenes = paramScene;
  }
  
  public void setSubScenes(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      Scene[] arrayOfScene = new Scene[paramJSONArray.length()];
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        if (localObject != null)
        {
          localObject = new Scene((JSONObject)localObject);
          ((Scene)localObject).setRootNode(this);
          arrayOfScene[i] = localObject;
        }
        i += 1;
      }
      this.sub_scenes = arrayOfScene;
      return;
    }
    this.sub_scenes = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\Scene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */