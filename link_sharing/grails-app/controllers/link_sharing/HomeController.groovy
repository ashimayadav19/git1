package link_sharing
import link_sharing.*;
class HomeController {

    def index() {}

    def dashboard ()
    {
        render("home page!!! good to go!! :)");
    }

   /* def dashboard() {
        User u1 = session["u1"]
        flash.message = "welcome${u1}"
        List<Subscription> userSub = Subscription.findAllByUser(u1)
        List<Topic> userTopic = Topic.findAllByUser(u1)
        List<Subscription> userTop5 = Subscription.findAllByUser(u1, [sort: "topic.lastUpdated", order: "desc", offset: 0, max: 5])

        def a = Resource.createCriteria().list(max: 3, offset: 0){
            projections {
                groupProperty('topic')
                rowCount("a")

            }

            'topic' {
                equals("visibility", "Visibility.PUBLIC")

            }

            order("a", "desc")
        }



        List<Topic> trendingTopic = a.collect { it.first() }
        return trendingTopic;

        //inbox
       // params.max = params.max ?: 5
        params.max= 5
        List<Resource> inboxL = ReadingItem.createCriteria().list(params) {
            projections {
                property 'resource'
            }
            eq('user', u1)
           // eq('Isread', false)

            order('lastUpdated','desc')

        }

        render view: "dashboard", model: [u1: u1, userSub: userSub, userTopic: userTopic, userTop5: userTop5, trendingTopic: trendingTopic, inboxL: inboxL]

    }
*/

    def register() {
        render("registration successful");
    }
}


