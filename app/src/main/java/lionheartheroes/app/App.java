/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lionheartheroes.app;

import lionheartheroes.list.LinkedList;

import static lionheartheroes.utilities.StringUtils.join;
import static lionheartheroes.utilities.StringUtils.split;


import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("/herohub", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<MyHero> heroes = MyHero.getAllInstances();
            model.put("heroes",heroes);
            return new ModelAndView(new HashMap(), "herohub.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squadhub", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<SquadHeroes> posts = SquadHeroes.getInstances();
            model.put("posts", posts);
            return new ModelAndView(new HashMap(), "squadhub.hbs");
        }, new HandlebarsTemplateEngine());

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(new HashMap(), "heroForm.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squadForm", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(new HashMap(), "squadForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squadhub", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String squadName = request.queryParams("squadName");
            String mission = request.queryParams("mission");
            int size = Integer.parseInt(request.queryParams("size"));
            request.session().attribute("squadName", squadName);
            request.session().attribute("mission", mission);
            request.session().attribute("size", size);
            model.put("squadName", squadName);
            model.put("mission", mission);
            model.put("size", size);
            return new ModelAndView(model, "squadhub.hbs");
        }, new HandlebarsTemplateEngine());

        post("/herohub", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String heroName = request.queryParams("heroName");
            String power = request.queryParams("power");
            String flaw = request.queryParams("flaw");
            int age = Integer.parseInt(request.queryParams("age"));
            request.session().attribute("heroName", heroName);
            request.session().attribute("power", power);
            request.session().attribute("flaw", flaw);
            request.session().attribute("age", age);
            model.put("heroName", heroName);
            model.put("power", power);
            model.put("flaw", flaw);
            model.put("age", age);
            return new ModelAndView(model, "herohub.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
