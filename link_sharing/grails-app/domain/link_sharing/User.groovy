package link_sharing

class User {

    String email
    String userName
    String password
    String confirmPassword
    String fname
    String lname
    byte[] photo
    Boolean admin
    Boolean active
    Date dateCreated
    Date lastUpdated

    static transients = ['confirmPassword'];
    static hasMany = [topic: Topic, subscription: Subscription, readingItem: ReadingItem, resourcerating: ResourceRating]


    static constraints = {
        active(nullable: true, blank: true);
        admin(nullable: true, blank: true);
        email(unique: true, blank: false, nullable: false, email: true)
        password(blank: false, validator: { val, obj ->
            println "${val} -- ${obj.confirmPassword}"
            if (val != obj.confirmPassword) {
                return ["Passwords doesnot match"]

            }
        })
        confirmPassword bindable : true
        photo(nullable: true, blank: true)
    }

    static  mapping={
//          photo type: 'longblob'
    }
}

