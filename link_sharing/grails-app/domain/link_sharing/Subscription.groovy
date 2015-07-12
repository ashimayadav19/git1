package link_sharing
import link_sharing.*;

class Subscription {

    Date dateCreated
    Seriousness seriousness
    static belongsTo=[user:User, topic:Topic]


    static constraints = {

        seriousness(blank:false, nullable:false)

    }
}