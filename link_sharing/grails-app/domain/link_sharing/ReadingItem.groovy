package link_sharing

class ReadingItem {

    Boolean isRead


    static belongsTo=[user:User,resource:Resource]

    static constraints = {
    }
}
