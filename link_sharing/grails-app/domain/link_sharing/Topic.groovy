package link_sharing
import link_sharing.*


class Topic {


        String name
        Date dateCreated
        Date lastUpdated
        Visibility visibility

        static hasMany = [resource: Resource, subscription: Subscription]
        static constraints = {

            visibility(blank: false, nullable: false)
            name(unique: 'user')


        }

        static belongsTo = [user: User]




}