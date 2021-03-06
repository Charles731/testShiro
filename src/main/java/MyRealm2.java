import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by User on 2018/3/9.
 */
public class MyRealm2 implements Realm {
    public String getName() {
        return "myrealm2";
    }

    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[])token.getCredentials());
        if (!"wang".equals(username)) {
            throw new UnknownAccountException();//如果用户错误
        }
        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException();//如果密码错误
        }
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
