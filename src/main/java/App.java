import models.AbundantAnimal;
import models.EndangeredAnimal;
import models.Sightings;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
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
            model.put("endangeredAnimal",EndangeredAnimal.all());
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
            model.put("abundantAnimal",AbundantAnimal.all());
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //view animals list
        get("/view_animals", (request, response) -> {
            String type = request.queryParams("type");
            Map  <Object,Object> model = new HashMap<>();
            if(type.equals("endangered")){
                List allEndangeredAnimals = EndangeredAnimal.all();
                model.put("type","Endangered");
                model.put("animals",allEndangeredAnimals);
                return new ModelAndView(model, "animals.hbs");
            }else if (type.equals("abundant")) {
                List allAbundantAnimals = AbundantAnimal.all();
                model.put("type","Abundant");
                model.put("animals",allAbundantAnimals);
                return new ModelAndView(model, "animals.hbs");
            }else{
                model.put("exception",new Exception("please select a valid type of animal"));
                return new ModelAndView(model, "animals.hbs");
            }

        }, new HandlebarsTemplateEngine());


        //sightings form
        get("/new_sighting", (request, response) -> {
            String id = request.queryParams("id");
            String name = request.queryParams("name");
            Map  <Object,Object> model = new HashMap<>();
            model.put("name",name);
            model.put("id",id);
            return new ModelAndView(model, "sightings_form.hbs");
        }, new HandlebarsTemplateEngine());

        //sightings form
        post("/new_sighting", (request, response) -> {
            String id = request.queryParams("id");
            String name = request.queryParams("name");
            String location = request.queryParams("location");
            Integer intId = Integer.parseInt(id);
            Map  <Object,Object> model = new HashMap<>();
            Sightings sighting = new Sightings(intId, "geoffrey",location);
            sighting.save();
            List sightingsById = Sightings.find(intId);
            model.put("sighting",sightingsById);
            model.put("name",name);
            model.put("id",id);
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        //view sightings by id
        get("/view_sightings", (request, response) ->{
            String id = request.queryParams("id");
            String name = request.queryParams("name");
            Integer intId = Integer.parseInt(id);
            Map  <Object,Object> model = new HashMap<>();
            List sightingsById = Sightings.find(intId);
            model.put("sighting",sightingsById);
            model.put("name",name);
            model.put("id",id);
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        //view all sightings
        get("/view_all_sightings", (request, response) ->{
            Map  <Object,Object> model = new HashMap<>();
            List allSightings = Sightings.all();
            model.put("sighting",allSightings);
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        //view about
        get("/about", (request, response) ->{
            return new ModelAndView(new HashMap(), "about.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
