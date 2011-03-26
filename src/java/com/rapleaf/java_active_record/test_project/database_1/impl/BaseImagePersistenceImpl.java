/**
 * Autogenerated
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.rapleaf.java_active_record.test_project.database_1.impl;

import java.util.Arrays;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;

import com.rapleaf.java_active_record.AbstractDatabaseModel;
import com.rapleaf.java_active_record.DatabaseConnection;

import com.rapleaf.java_active_record.test_project.database_1.models.Image;
import com.rapleaf.java_active_record.test_project.database_1.iface.IImagePersistence;

import com.rapleaf.java_active_record.test_project.IDatabases;

public class BaseImagePersistenceImpl extends AbstractDatabaseModel<Image> implements IImagePersistence {
  private final IDatabases databases;

  public BaseImagePersistenceImpl(DatabaseConnection conn, IDatabases databases) {
    super(conn, "images", Arrays.asList("user_id"));
    this.databases = databases;
  }

  public Image create(final Integer user_id) throws IOException {
    int __id = realCreate(new AttrSetter() {
      public void set(PreparedStatement stmt) throws SQLException {
        if (user_id == null) {
          stmt.setNull(1, java.sql.Types.INTEGER);
        } else {
          stmt.setInt(1, user_id);
        }
      }
    }, getInsertStatement(Arrays.asList("user_id")));
    return new Image(__id, user_id, databases);
  }

  @Override
  protected void setAttrs(Image model, PreparedStatement stmt) throws SQLException {
    if (model.getUserId() == null) {
      stmt.setNull(1, java.sql.Types.INTEGER);
    } else {
      stmt.setInt(1, model.getUserId());
    }
    stmt.setLong(2, model.getId());
  }

  @Override
  protected Image instanceFromResultSet(ResultSet rs) throws SQLException {
    return new Image(rs.getInt("id"),
      getIntOrNull(rs, "user_id"),
      databases
    );
  }
}
