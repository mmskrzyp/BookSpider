package controllers;

import com.avaje.ebean.Ebean;
import models.Item;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.List;

public class Application extends Controller {

    public static Result index() {
        List<Item> allItems = Item.find.all();

        return ok(index.render("My items", Form.form(Item.class), allItems));
    }

    public static Result addItem() {
        Form<Item> form = Form.form(Item.class).bindFromRequest();

        if (!form.hasErrors()) {
            Ebean.save(form.get());
        }

        return redirect(
                routes.Application.index()
        );
    }

}
