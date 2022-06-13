# Invest Page Blog

## Open program in Intellij IDEA
Write docker-compose up -d in terminal
If some docker container was on before then write docker compose down and repeat command in line number 4 again
Connect your database to container by using default settings or change it in application.properties
Start program
Copy http://localhost:8080/ url to your browser(If you are using another port, please change 8080 to current)
If you have registered an account, you must verified manualy in your database

###Functions:
Users can create post, send messages to one another, search post, make a comment under post, upvote or downvote a post
Annonymous user only can read and make a comment
Post can be saved, shared
Password is scrypted
There are a rules which must be followed to be registered


###To be added:
-Stocks back end is ready, only display for that is needed.
      Stock prices provider is Yahoo finance API. Sock price will refresh every 6 seconds. In the code you can change what sould be dislpayed : Percentage, price, low/high price etc.
       There also is test for stock service
-Multilanguage
-A working  email sending function for autherification (there is already a base for that function in the code)
-Adming role for deleting post 
