package com.ttnd.linksharing


class LoginController {

    def index() {
        if(session.user)
        {
            forward(controller: 'User' ,action: 'index')
        }
        else
        render "user is not logged in"
    }


    def login( String username,String password)
    {   render "logged in"
        User user=User.findByUserNameAndPassword(username,password)

              if(user?.active)
              {
                  session.user=user
                  redirect(action: 'index')

              }
              else
            render "${user?'user is not active':'User not exist'}"



    }

    def logout()

    {
        session.invalidate()
        redirect(action: 'index')
    }
}
