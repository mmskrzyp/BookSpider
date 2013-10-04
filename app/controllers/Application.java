package controllers;

import com.avaje.ebean.Ebean;
import models.Book;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.List;

public class Application extends Controller {

    public static Result index() {
        List<Book> allBooks = Book.find.all();

        return ok(index.render("My books", Form.form(Book.class), allBooks));
    }

    public static Result addBook() {
        Form<Book> form = Form.form(Book.class).bindFromRequest();

        if (!form.hasErrors()) {
            Ebean.save(form.get());
        }

        return redirect(
                routes.Application.index()
        );
    }

}
