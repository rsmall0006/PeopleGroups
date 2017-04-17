package com.theironyard.novauc.controllers;

import com.theironyard.novauc.entities.Person;
import com.theironyard.novauc.services.PersonRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Merlin on 3/17/17.
 */
@RestController
@Api(value="PeopleGroups", description = "PeopleGroups for consuming data from Restful API")
public class PeopleGroupsController {

    @Autowired
    PersonRepository people;





    @RequestMapping(value="/")
    public String jspIndex() {
        return "This is my home page";
    }
/*    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
*/

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        request.setAttribute("logout", "logout");
        return "login";

    }





    @RequestMapping(path = "/person", method = RequestMethod.GET)
    public List<Person> getUsers() {
        return (List<Person>) people.findAll();
    }

    @RequestMapping(path = "/person", method = RequestMethod.POST)
    public void addUser(@RequestBody Person user) {
        people.save(user);
    }

    @RequestMapping(path = "/person", method = RequestMethod.PUT)
    public void updateUser(@RequestBody Person user) {
        people.save(user);
    }

    @RequestMapping(path = "/person/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") int id) {
        people.delete(id);
    }

    @RequestMapping(path = "/person/{id}", method = RequestMethod.GET)
    public Person getUser(@PathVariable("id") int id) {
        return people.findOne(id);
    }

    @PostConstruct
    void init() {
        if (people.count() == 0) {
            Person p = new Person("Mike","123 something", "some@something.com", "yes", "lots" );
            people.save(p);
        }
    }
}
