import link_sharing.*;
class BootStrap {
    def init = { servletContext ->


createUser();
createTopic();
createResource();
createReadingItem();

//createResourceRating();
//createSubscription();


    }

void createUser() {

   User user = new User(fname: "ashima", email: "ashimayadav@gmail.com", userName: "ashima", password: "ashi@123",confirmPassword:"ashi@123", lname: "yadav", admin: false, active: false);

    saveObject(user);


     user = new User(fname: "jyoti", email: "jyotibhardwaj@gmail.com", userName: "jyoti", password: "jyo@123",confirmPassword:"jyo@123", lname: "bhardwaj", admin: false, active: false);

    saveObject(user);

    user = new User(fname: "deepti", email: "deepti.bhardwaj1992@gmail.com", userName: "deep123", password: "dee123",confirmPassword:"dee123", lname: "bhardwaj", admin: true, active: false);
    saveObject(user);

    user = new User(fname: "priya", email: "priyachopra@gmail.com", userName: "priya", password: "priya123",confirmPassword:"priya123", lname: "chopra", admin: false, active: false);

    saveObject(user);



}
void createTopic(){
    
        List users=User.list();
        users.each {user->
              5.times{
                Topic topic=new Topic(name:"grails-${it+1}" ,visibility:Visibility.PUBLIC )
                user.addToTopic(topic);
 user.addToSubscription(new Subscription(topic:topic,seriousness:Seriousness.SERIOUS))
                saveObject(user);
                
                        }

	}
 }



void createResource(){
    
       List topics=Topic.list();
       
	topics.eachWithIndex {  topic,index->
	
	    User user=User.first();

           topic.addToResource(new LinkResource(creator:user, title:"link res${index+1}",description:"link--${index+1}	descripion", url:"https://grails.github.io/grails-doc/link${index+1}"  ))

        topic.addToResource(new DocumentResource(creator:user, title:"document res ${index+1}",description:" document--${index+1}descripion", filePath:"//filepath/grails.github.io/grails-doc/link${index+1}"  ))

      saveObject(topic);
	   } 

    

	}



void createReadingItem() {

int size=Resource.list().size();	
User.list().each{ user->
	Random random=new Random()
    //println Resource.get(Math.abs(random.nextInt() % size))
	user.addToReadingItem(new ReadingItem(resource:Resource.get(Math.abs(random.nextInt() % size)),isRead:true   ))
	user.addToReadingItem(new ReadingItem(resource:Resource.get(Math.abs(random.nextInt() % size)),isRead:true   ))
	user.addToReadingItem(new ReadingItem(resource:Resource.get(Math.abs(random.nextInt() % size)),isRead:true   ))
   saveObject(user);
}
}
/*void createResourceRating() {
        ResourceRating resourceRating = new ResourceRating()
    }

    void createSubscription() {
        Subscription subscription = new Subscription()
    }

*/

void saveObject(Object object) {
        if (object.hasErrors() || !object.save(flush: true)) {
            object.errors.allErrors.each {
                println "Errror ${it}"
            }
        }
    }




    def destroy = {
    }
}
