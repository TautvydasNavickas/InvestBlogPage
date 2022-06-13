# Invest Page Blog

## Open program in Intellij IDEA
-Write docker-compose up -d in terminal<br/>
-If some docker container was on before then write docker compose down and repeat command in line number 4 again<br/>
-Connect your database to container by using default settings or change it in application.properties<br/>
-Start program<br/>
-Copy http://localhost:8080/ url to your browser (If you are using another port, please change 8080 to current)<br/>
-If you have registered an account, you must verified manualy in your database<br/>

Functions:<br/>
-Users can create post, send messages to one another, search post, make a comment under post, upvote or downvote a post<br/>
-Annonymous user only can read and make a comment<br/>
-Post can be saved, shared<br/>
-Password is scrypted<br/>
-There are a rules which must be followed to be registered<br/>


To be added:<br/>
-Stocks back end is ready, only display for that is needed.<br/>
      Stock prices provider is Yahoo finance API. Sock price will refresh every 6 seconds. In the code you can change what sould be dislpayed : Percentage, price, low/high price etc.
       There also is test for stock service<br/>
-Multilanguage<br/>
-A working  email sending function for autherification (there is already a base for that function in the code)<br/>
-Adming role for deleting post <br/>
