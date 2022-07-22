import models.AbundantAnimal;
import models.EndangeredAnimal;
import models.Sightings;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        //home page
        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "menu.hbs");
        }, new HandlebarsTemplateEngine());

        //ranger registration form
        get("/ranger_register", (request, response) -> {
            return new ModelAndView(new HashMap(), "register.hbs");
        }, new HandlebarsTemplateEngine());

        //ranger registration action
        post("/ranger_register", (request, response) -> {
            return new ModelAndView(new HashMap(), "register.hbs");
        }, new HandlebarsTemplateEngine());

        //add endangered species form
        get("/new_endangered_animal", (request, response) -> {
            return new ModelAndView(new HashMap(), "endangered_animal_form.hbs");
        }, new HandlebarsTemplateEngine());

        //add endangered species
        post("/new_endangered_animal", (request, response) -> {
            String name =  request.queryParams("name");
            String age = request.queryParams("age");
            String health = request.queryParams("health");
            String location = request.queryParams("location");
            EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal(name,"geoffrey",health,age);
            newEndangeredAnimal.save();
            Sightings sighting = new Sightings(newEndangeredAnimal.getId(), "geoffrey",location);
            sighting.save();
            Map  <Object,Object> model = new HashMap<>();
            model.put("endangeredAnimal",newEndangeredAnimal);
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());


        //abundant species form
        get("/new_abundant_animal", (request, response) -> {
            return new ModelAndView(new HashMap(), "abundant_animal_form.hbs");
        }, new HandlebarsTemplateEngine());

        //add abundant species
        post("/new_abundant_animal", (request, response) -> {
            String name =  request.queryParams("name");
            String location = request.queryParams("location");
            AbundantAnimal newAbundantAnimal = new AbundantAnimal(name,"geoffrey");
            newAbundantAnimal.save();
            Sightings sighting = new Sightings(newAbundantAnimal.getId(), "geoffrey",location);
            sighting.save();
            Map  <Object,Object> model = new HashMap<>();
            model.put("abundantAnimal",newAbundantAnimal);
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());


        //view animals list
        get("/view_animals", (request, response) -> "Hello Friend!");


        //sightings form
        get("/new_sighting", (request, response) -> {
            return new ModelAndView(new HashMap(), "sightings_form.hbs");
        }, new HandlebarsTemplateEngine());

        //sightings form
        post("/new_sighting", (request, response) -> {
            return new ModelAndView(new HashMap(), "sightings_form.hbs");
        }, new HandlebarsTemplateEngine());

        //view sightings
        get("/view_sightings", (request, response) ->{
            return new ModelAndView(new HashMap(), "sightings.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
