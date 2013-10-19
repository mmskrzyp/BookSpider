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
public class Item extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    public String description;

    public static Finder<Long, Item> find = new Finder<Long, Item>(Long.class, Item.class);
}
