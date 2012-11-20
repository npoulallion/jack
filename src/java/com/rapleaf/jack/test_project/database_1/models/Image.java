
/**
 * Autogenerated by Jack
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.rapleaf.jack.test_project.database_1.models;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

import com.rapleaf.jack.test_project.database_1.IDatabase1;

import com.rapleaf.jack.ModelWithId;
import com.rapleaf.jack.BelongsToAssociation;
import com.rapleaf.jack.HasManyAssociation;
import com.rapleaf.jack.HasOneAssociation;

import com.rapleaf.jack.test_project.IDatabases;

public class Image extends ModelWithId<Image, IDatabases> {
  
  public static final long serialVersionUID = -3351451520429699622L;

  // Fields
  private Integer __user_id;

  // Associations
  private BelongsToAssociation<User> __assoc_user;

  public enum _Fields {
    user_id,
  }

  public Image(long id, final Integer user_id, IDatabases databases) {
    super(id, databases);
    this.__user_id = user_id;
    this.__assoc_user = new BelongsToAssociation<User>(databases.getDatabase1().users(), __user_id == null ? null : __user_id.longValue());
  }

  public Image(long id, final Integer user_id) {
    super(id, null);
    this.__user_id = user_id;
  }
  public Image(long id, IDatabases databases) {
    super(id, databases);
    this.__assoc_user = new BelongsToAssociation<User>(databases.getDatabase1().users(), __user_id == null ? null : __user_id.longValue());
  }

  public Image(long id) {
    super(id, null);
  }

  public static Image newDefaultInstance(long id) {
    return new Image(id);
  }

  public Image(long id, Map<Enum, Object> fieldsMap) {
    super(id, null);
    Integer user_id = (Integer) fieldsMap.get(Image._Fields.user_id);
    this.__user_id = user_id;
  }

  public Image (Image other) {
    this(other, (IDatabases)null);
  }

  public Image (Image other, IDatabases databases) {
    super(other.getId(), databases);
    this.__user_id = other.getUserId();

    if (databases != null) {
      this.__assoc_user = new BelongsToAssociation<User>(databases.getDatabase1().users(), __user_id == null ? null : __user_id.longValue());
    }
  }

  public Integer getUserId(){
    return __user_id;
  }

  public Image setUserId(Integer newval){
    this.__user_id = newval;
    if(__assoc_user != null){
      this.__assoc_user.setOwnerId(newval);
    }
    cachedHashCode = 0;
    return this;
  }

  public void setField(_Fields field, Object value) {
    switch (field) {
      case user_id:
        setUserId((Integer) value);
        break;
      default:
        throw new IllegalStateException("Invalid field: " + field);
    }
  }
  
  public void setField(String fieldName, Object value) {
    if (fieldName.equals("user_id")) {
      setUserId((Integer)  value);
      return;
    }
    throw new IllegalStateException("Invalid field: " + fieldName);
  }

  public static Class getFieldType(_Fields field) {
    switch (field) {
      case user_id:
        return Integer.class;
      default:
        throw new IllegalStateException("Invalid field: " + field);
    }    
  }

  public static Class getFieldType(String fieldName) {    
    if (fieldName.equals("user_id")) {
      return Integer.class;
    }
    throw new IllegalStateException("Invalid field name: " + fieldName);
  }

  public User getUser() throws IOException {
    return __assoc_user.get();
  }

  @Override
  public Object getField(String fieldName) {
    if (fieldName.equals("id")) {
      return getId();
    }
    if (fieldName.equals("user_id")) {
      return getUserId();
    }
    throw new IllegalStateException("Invalid field name: " + fieldName);
  }

  public Object getField(_Fields field) {
    switch (field) {
      case user_id:
        return getUserId();
    }
    throw new IllegalStateException("Invalid field: " + field);
  }
  
   public boolean hasField(String fieldName) {
    if (fieldName.equals("id")) {
      return true;
    }
    if (fieldName.equals("user_id")) {
      return true;
    }
    return false;
  }

  public static Object getDefaultValue(_Fields field) {
    switch (field) {
      case user_id:
        return null;
    }
    throw new IllegalStateException("Invalid field: " + field);
  }

  @Override
  public Set<Enum> getFieldSet() {
    Set set = EnumSet.allOf(_Fields.class);
    return set;
  }

  @Override
  public Image getCopy() {
    return getCopy(databases);
  }

  @Override
  public Image getCopy(IDatabases databases) {
    return new Image(this, databases);
  }

  @Override
  public boolean save() throws IOException {
    return databases.getDatabase1().images().save(this);
  }

  public User createUser(final String handle, final int num_posts) throws IOException {
 
    User newUser = databases.getDatabase1().users().create(handle, num_posts);
    setUserId(safeLongToInt(newUser.getId()));
    save();
    __assoc_user.clearCache();
    return newUser;
  }

  public User createUser(final String handle, final Long created_at_millis, final int num_posts, final Long some_date, final Long some_datetime, final String bio, final byte[] some_binary, final Double some_float, final Boolean some_boolean) throws IOException {
 
    User newUser = databases.getDatabase1().users().create(handle, created_at_millis, num_posts, some_date, some_datetime, bio, some_binary, some_float, some_boolean);
    setUserId(safeLongToInt(newUser.getId()));
    save();
    __assoc_user.clearCache();
    return newUser;
  }

  public User createUser() throws IOException {
 
    User newUser = databases.getDatabase1().users().create("", 0);
    setUserId(safeLongToInt(newUser.getId()));
    save();
    __assoc_user.clearCache();
    return newUser;
  }

  public String toString() {
    return "<Image"
      + " user_id: " + __user_id
      + ">";
  }
}
