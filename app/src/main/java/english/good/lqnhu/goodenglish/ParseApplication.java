package english.good.lqnhu.goodenglish;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;
import android.app.Application;

/**
 * Created by lqnhu on 6/24/15.
 */
public class ParseApplication extends Application {

    @Override
    public void onCreate() {

        // Add your initialization code here
        Parse.initialize(this, "Sa7L2rN9lBk2tiW048ZSxcMXtuawg2bl2Ph3WNPC", "4yZntUu3l52KrgQmy7kPiNY7Vzaartm4rEaomw8m");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this
        // line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }
}
