package link_sharing

class LoginController {

    def index() {

        params.max = params.max ?: 5
        List<Resource> rList = Resource.list(params)

        render(view: 'index', model: [resources: rList, total: Resource.count()])

        /*
        List<Resource> rList = Resource.list(params)

        render(view: 'index', model: [resources: rList, total: Resource.count()])*/
//render(view: 'index')
    }

    def signin() {

        String un = params.userName;
        println un
        String pa = params.password;

        println pa
        User user1 = User.findByUserName(un)
        if (user1?.password == pa) {
            redirect(controller: 'Home', action: 'dashboard')
        } else
            render(view: 'invalidsignin')

    }

    def register() {

        User user2 = new User(params)
        if (user2.validate()) {
            user2.save(flush: true)
            //render("REGISTERED!!");
            redirect(controller: 'Home', action: 'register');

        } else {
            // 3.times { render( view: 'index'); }
            render("timeout!!");
        }

        if (!user2.save()) {
            user2.errors.each {
                println it
            }
        }
    }

    def forgot() {
        render(view: 'forgot');
    }

    def reset() {
        String e = params.email;
        User user = User.findByUserName(params.userName);
        println user.userName
        println user.password
        println params.password

        if (user?.email == e) {

            user.password = params.password;
            user.confirmPassword = params.password;
            println user.password
            user.save(flush: true, validate: false);
            render(" Password changed successfulyy!!!");

        }
    }

    def recent() {
        /*  println("start")
          Topic topic = new Topic()
          List<String> user = Resource.createCriteria().list(max:5, offset:0, sort :"lastUpdated",order :"desc")

                  {

                      projections {
                          property("userName")
                      }
                      topic{
                          equals("visibility","Visibility.PUBLIC")
                      }
                  }
          user.each { println "${it}" }

      render("hiee");
          println("finish");*/
    }

}