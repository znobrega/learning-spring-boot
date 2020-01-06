package br.com.devdojo.awesome.controller;

import br.com.devdojo.awesome.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AppController {
    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<String> list() {
        return Arrays.asList(new String("Carlos"), new String("Noriega"));
    }
}
