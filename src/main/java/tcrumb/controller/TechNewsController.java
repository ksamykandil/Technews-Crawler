package tcrumb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tcrumb.model.NewsObject;
import tcrumb.service.TechNewsService;

import java.util.List;

@RestController
@RequestMapping("/tech-news")
public class TechNewsController {

    @Autowired
    private TechNewsService techNewsService;

    @RequestMapping(method = RequestMethod.GET)
    public List<NewsObject> getAllTechNews() {
        return techNewsService.getAllTechNews();
    }
}
