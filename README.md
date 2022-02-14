# Java Spring boot application-2

### Added embedded database. Watch for [Spring-boot-application-1](https://github.com/Khankee/Spring-boot-app)

Updated Java Spring application with embedded database. What are the improvements?
* TopicService class changed totally
* Another version of application
* Does all CRUD operations same as [SB first application](https://github.com/Khankee/Spring-boot-app)
* Added @SpringAnnotations

### Declared Arraylist vs DataBase

On my previous Spring boot application I have declared Arraylist with objects
and used TopicController class to get, update and delete the Object's attributes.

```java
    private List<Topic> topics=new ArrayList<>(Arrays.asList(
            new Topic("spring","Spring Framework","Spring Framework Description"),
            new Topic("java","Java Framework","Java Framework Description"),
            new Topic("react.js","React Framework","React Framework Description")
            ));
```
On Spring boot with database, declared arrayList of objects removed and TopicController class User-Defined methods improved. 
TopicRepository interface which extends CrudRepository simplifies the code. Take more attention for UPDATE method.
### Comparison
TopicService class SBA-1 (GET)(Spring Boot Application 1)
```java
    //GET method
    public Topic getTopic(String id){
        return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
    }
```
TopicService class SBA-2 (GET)(Spring Boot Application 2)
```java
    //@Autowired connects with TopicRepository.java (Check on Repository)
    @Autowired
    private TopicRepository topicRepository;
    //GET method
    public Optional<Topic> getTopic(String id){
        return topicRepository.findById(id);
    }
```
TopicService class SBA-1 (POST)
```java
    //POST method
    public void addTopic(Topic topic){
        topics.add(topic);
    }
```
TopicService class SBA-2 (POST)
```java
    //POST method
    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }
```
TopicService class SBA-1 (DELETE)
```java
    //DELETE method
    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }
```
TopicService class SBA-2 (DELETE)
```java
    //DELETE method
    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
```
TopicService class SBA-1 (PUT)
```java
    //PUT method
    public void updateTopic(String id, Topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            Topic t  = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i,topic);
                return;
            }
        }
    }
```
TopicService class SBA-2 (PUT)
```java
    //PUT method
    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
    }
```
Big difference, it is! Makes the code easier!

## Getting Involved
Send suggestions or ask me any questions by email: [Arukhan.kenes@gmail.com](mailto:Arukhan.kenes@gmail.com?subject=[GitHub]%20Source%20Han%20Sans)
 or reach me out by [LinkedIn](https://www.linkedin.com/in/khankee/)