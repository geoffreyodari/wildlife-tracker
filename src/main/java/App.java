import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {

        //home page
        get("/", (request, response) -> "welcome page");

        //ranger registration form
        get("/ranger_register", (request, response) -> "register page");

        //ranger registration action
        post("/ranger_register", (request, response) -> "successful-registration");

        //add endangered species form
        get("/new_endangered_animal", (request, response) -> "Hello Friend!");

        //add endangered species
        post("/new_endangered_animal", (request, response) -> "Hello Friend!");


        //abundant species form
        get("/new_abundant_animal", (request, response) -> "Hello Friend!");

        //add abundant species
        post("/new_abundant_animal", (request, response) -> "Hello Friend!");


        //view animals list
        get("/view_animals", (request, response) -> "Hello Friend!");


        //sightings form
        get("/new_sighting", (request, response) -> "Hello Friend!");

        //sightings form
        post("/new_sighting", (request, response) -> "Hello Friend!");

        //view sightings
        get("/view_sightings", (request, response) -> "Hello Friend!");

    }
}
