package uk.arukhan.brunel.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    //GET DEFAULT METHOD
    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTheTopics();
    }

    //GET DEFAULT METHOD OF SPECIFIC ONE
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    //POST METHOD (Create value)
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    //DELETE METHOD (Remove the value)
    @RequestMapping(method = RequestMethod.DELETE, value = "topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }

    //PUT METHOD (Update the value)
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id ){
        topicService.updateTopic(id, topic);
    }
}
