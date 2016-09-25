import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import org.sql2o.*;
import java.sql.Date;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/stylist-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistId", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int stylistId = Integer.parseInt(request.params(":stylistId"));
      Stylist stylist = Stylist.find(stylistId);
      model.put("stylist", stylist);
      model.put("clients", stylist.getClients());
      model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistId/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":stylistId")));
      model.put("stylist", stylist);
      model.put("clients", stylist.getClients());
      model.put("template", "templates/clients.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistId/clients/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":stylistId")));
      model.put("stylist", stylist);
      model.put("stylists", Stylist.all());
      model.put("template", "templates/client-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistId/clients/:clientId", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":stylistId")));
      Client client = Client.find(Integer.parseInt(request.params(":clientId")));
      model.put("stylist", stylist);
      model.put("client", client);
      model.put("template", "templates/client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int stylistId = Integer.parseInt(request.queryParams("stylistId"));
      String name = request.queryParams("name");
      String phone = request.queryParams("phone");
      String email = request.queryParams("email");
      String imgURL = request.queryParams("imgURL");
      String nextAppt = request.queryParams("nextAppt");
      Date nextAppt1 = Date.valueOf(nextAppt);
      Client client = new Client(name, phone, email, nextAppt1, imgURL, stylistId);
      client.save();
      response.redirect("/stylists/" + stylistId);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String specialty = request.queryParams("specialty");
      String phone = request.queryParams("phone");
      String email = request.queryParams("email");
      String instagram = request.queryParams("instagram");
      String days = request.queryParams("days");
      String imgURL = request.queryParams("imgUrl");
      String bio = request.queryParams("bio");
      Stylist stylist = new Stylist(name, phone, imgURL, email, specialty, bio, days, instagram);
      stylist.save();
      response.redirect("/stylists");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistId/edit", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":stylistId")));
      model.put("stylist", stylist);
      model.put("template", "templates/stylist-edit.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:stylistId/edit", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int stylistId = Integer.parseInt(request.queryParams("stylistId"));
      Stylist stylist = Stylist.find(stylistId);
      stylist.setName(request.queryParams("name"));
      stylist.setSpecialty(request.queryParams("specialty"));
      stylist.setPhone(request.queryParams("phone"));
      stylist.setEmail(request.queryParams("email"));
      stylist.setInstagram(request.queryParams("instagram"));
      stylist.setDays(request.queryParams("days"));
      stylist.setImgUrl(request.queryParams("imgUrl"));
      stylist.setBio(request.queryParams("bio"));
      stylist.update();
      response.redirect("/stylists/" + stylistId);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistId/delete", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":stylistId")));
      response.redirect("/stylists");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:stylistId/delete", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":stylistId")));
      stylist.delete();
      response.redirect("/stylists");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistId/clients/:clientId/edit", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":stylistId")));
      Client client = Client.find(Integer.parseInt(request.params(":clientId")));
      model.put("stylist", stylist);
      model.put("client", client);
      model.put("stylists", Stylist.all());
      model.put("template", "templates/client-edit.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:stylistId/clients/:clientId/edit", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int stylistId = Integer.parseInt(request.queryParams("stylistId"));
      int clientId = Integer.parseInt(request.queryParams("clientId"));
      Stylist stylist = Stylist.find(stylistId);
      Client client = Client.find(clientId);
      client.setName(request.queryParams("name"));
      client.setPhone(request.queryParams("phone"));
      client.setEmail(request.queryParams("email"));
      client.setImgUrl(request.queryParams("imgURL"));
      Date nextAppt = Date.valueOf(request.queryParams("nextAppt"));
      client.setNextAppt(nextAppt);
      client.update();
      response.redirect("/stylists/" + stylistId + "/clients/" + clientId);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistId/clients/:clientId/delete", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int stylistId = Integer.parseInt(request.params(":stylistId"));
      response.redirect("/stylists/" + stylistId);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:stylistId/clients/:clientId/delete", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int stylistId = Integer.parseInt(request.params(":stylistId"));
      int clientId = Integer.parseInt(request.params(":clientId"));
      Client client = Client.find(clientId);
      client.delete();
      response.redirect("/stylists/" + stylistId);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
