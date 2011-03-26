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

import com.rapleaf.java_active_record.test_project.database_1.models.Post;
import com.rapleaf.java_active_record.test_project.database_1.iface.IPostPersistence;

import com.rapleaf.java_active_record.test_project.IDatabases;

public class BasePostPersistenceImpl extends AbstractDatabaseModel<Post> implements IPostPersistence {
  private final IDatabases databases;

  public BasePostPersistenceImpl(DatabaseConnection conn, IDatabases databases) {
    super(conn, "posts", Arrays.asList("title", "posted_at_millis", "user_id"));
    this.databases = databases;
  }

  public Post create(final String title, final Long posted_at_millis, final Integer user_id) throws IOException {
    int __id = realCreate(new AttrSetter() {
      public void set(PreparedStatement stmt) throws SQLException {
        if (title == null) {
          stmt.setNull(1, java.sql.Types.CHAR);
        } else {
          stmt.setString(1, title);
        }
        if (posted_at_millis == null) {
          stmt.setNull(2, java.sql.Types.DATE);
        } else {
          stmt.setDate(2, new Date(posted_at_millis));
        }
        if (user_id == null) {
          stmt.setNull(3, java.sql.Types.INTEGER);
        } else {
          stmt.setInt(3, user_id);
        }
      }
    }, getInsertStatement(Arrays.asList("title", "posted_at_millis", "user_id")));
    return new Post(__id, title, posted_at_millis, user_id, databases);
  }

  @Override
  protected void setAttrs(Post model, PreparedStatement stmt) throws SQLException {
    if (model.getTitle() == null) {
      stmt.setNull(1, java.sql.Types.CHAR);
    } else {
      stmt.setString(1, model.getTitle());
    }
    if (model.getPostedAtMillis() == null) {
      stmt.setNull(2, java.sql.Types.DATE);
    } else {
      stmt.setDate(2, new Date(model.getPostedAtMillis()));
    }
    if (model.getUserId() == null) {
      stmt.setNull(3, java.sql.Types.INTEGER);
    } else {
      stmt.setInt(3, model.getUserId());
    }
    stmt.setLong(4, model.getId());
  }

  @Override
  protected Post instanceFromResultSet(ResultSet rs) throws SQLException {
    return new Post(rs.getInt("id"),
      rs.getString("title"),
      getDateAsLong(rs, "posted_at_millis"),
      getIntOrNull(rs, "user_id"),
      databases
    );
  }
}
