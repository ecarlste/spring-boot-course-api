package com.erikcarlsten.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();

        topicRepository.findAll()
                       .forEach(topics::add);

        return topics;
    }

    Topic getTopic(String id) {
        return topicRepository.findOne(id);
    }

    void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    void updateTopic(Topic topic) {
        topicRepository.save(topic);
    }

    void deleteTopic(String id) {
        topicRepository.delete(id);
    }
}
