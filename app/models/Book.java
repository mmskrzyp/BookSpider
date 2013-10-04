package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User: Maria
 * Date: 04.10.13
 * Time: 22:20
 */
@Entity
public class Book extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String title;

    public static Finder<Long, Book> find = new Finder<Long, Book>(Long.class, Book.class);
}
