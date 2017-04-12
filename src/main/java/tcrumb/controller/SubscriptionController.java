package tcrumb.controller;

import tcrumb.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping(value = "/subscribe/{email}", method = RequestMethod.GET)
    public void subscribe(@PathVariable String email) {
        subscriptionService.subscribe(email);
    }

    @RequestMapping(value = "/un-subscribe/{id}", method = RequestMethod.GET)
    public void unSubscribe(@PathVariable String id) {
        subscriptionService.unSubscribe(id);
    }
}
