package tcrumb.service;

import tcrumb.model.Subscriber;
import tcrumb.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public void subscribe(String email) {
        Subscriber subscriber = new Subscriber();
        subscriber.setEmail(email);
        subscriber.setSubscriptionDate(new Date());

        subscriptionRepository.save(subscriber);
    }

    public void unSubscribe(String id) {
        subscriptionRepository.delete(id);
    }
}
