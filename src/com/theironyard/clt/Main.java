package com.theironyard.clt;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;

public class Main {
    static User user;
    public static void main(String[] args) {
        Spark.init();

        Spark.get(
                "/",
                ((request, response) -> {
                    HashMap m = new HashMap();
                    if (user == null) {
                        return new ModelAndView(m, "index.html");
                    } else if (user.password != "42") {
                        return new ModelAndView(m, "index2.html");
                    } else {
                        m.put("user", user);
                        return new ModelAndView(m, "messages.html");
                    }
                }),
                new MustacheTemplateEngine()
        );

        Spark.post(
                "/login",
                ((request, response) -> {
                    String name = request.queryParams("loginName");
                    String password = request.queryParams("loginPassword");
                    user = new User(name);
                    response.redirect("/");
                    return "";
                })
        );



        Spark.post(
                "/message",
                ((request, response) -> {
                    String message = request.queryParams("message");
                    user.posts.add(message);
                    response.redirect("/");
                    return "";
                })
        );
    }
}
