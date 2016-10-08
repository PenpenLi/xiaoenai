package com.xiaoenai.app.database.bean;

public class Todo
{
  private String content;
  private Long created_at;
  private Integer finished;
  private Integer is_sync;
  private Integer modifier_Id;
  private Integer todo_id;
  
  public Todo() {}
  
  public Todo(Integer paramInteger1, String paramString, Integer paramInteger2, Integer paramInteger3, Long paramLong, Integer paramInteger4)
  {
    this.todo_id = paramInteger1;
    this.content = paramString;
    this.modifier_Id = paramInteger2;
    this.is_sync = paramInteger3;
    this.created_at = paramLong;
    this.finished = paramInteger4;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public Long getCreated_at()
  {
    return this.created_at;
  }
  
  public Integer getFinished()
  {
    return this.finished;
  }
  
  public Integer getIs_sync()
  {
    return this.is_sync;
  }
  
  public Integer getModifier_Id()
  {
    return this.modifier_Id;
  }
  
  public Integer getTodo_id()
  {
    return this.todo_id;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setCreated_at(Long paramLong)
  {
    this.created_at = paramLong;
  }
  
  public void setFinished(Integer paramInteger)
  {
    this.finished = paramInteger;
  }
  
  public void setIs_sync(Integer paramInteger)
  {
    this.is_sync = paramInteger;
  }
  
  public void setModifier_Id(Integer paramInteger)
  {
    this.modifier_Id = paramInteger;
  }
  
  public void setTodo_id(Integer paramInteger)
  {
    this.todo_id = paramInteger;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\database\bean\Todo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */