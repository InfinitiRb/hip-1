package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.*;
import views.html.iframe.*;
import views.html.signalDetection.*;
import views.html.changeBlindness.*;
import models.*;

public class Application extends Controller {

	public static Result index() {
        return ok(index.render(Form.form(UserForm.class)));
    }

    @Security.Authenticated(Secured.class)
	public static Result perceptionSignalDetection(){
        return ok(signal_detection_info.render());
    }
    
	@Security.Authenticated(Secured.class)
	public static Result perceptionChangeBlindnessIframe(){
        return ok(change_blindness_iframe.render());
    }

    @Security.Authenticated(Secured.class)
	public static Result perceptionChangeBlindnessProcIframe(){
        return ok(change_blindness_proc_iframe.render());
    }
    
	@Security.Authenticated(Secured.class)
	public static Result perceptionChangeBlindness(){
        return ok(change_blindness_info.render());
    }

    @Security.Authenticated(Secured.class)
	public static Result perceptionChangeBlindnessProc(){
        return ok(change_blindness_proc.render());
    }

    @Security.Authenticated(Secured.class)
	public static Result home(){
        return ok(home.render());
    }

    public static Result logout() {
<<<<<<< HEAD
        return TODO;
    }
	
	public static Result authenticate() {
    	Form<UserForm> userForm = Form.form(UserForm.class).bindFromRequest();
    	if(userForm.hasErrors()) {
    		return badRequest(index.render(userForm));
    	}
    	else {
    		session().clear();
    		session("username", userForm.get().username);
    		return redirect(routes.Application.home());
    	}
=======
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
            routes.Application.index()
        );
    }

	public static Result authenticate() {
        Form<UserForm> userForm = Form.form(UserForm.class).bindFromRequest();
        if(userForm.hasErrors()) {
            return badRequest(index.render(userForm));
        }
        else {
            session().clear();
            session("username", userForm.get().username);
            return redirect(routes.Application.home());
        }
    }

    public static Result about() {
        return ok(about.render());
>>>>>>> 09b91abf33f0d4e781fdadb2311fa8a67df887fe
    }

}
