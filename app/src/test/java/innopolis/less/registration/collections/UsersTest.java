package innopolis.less.registration.collections;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pavel on 20.06.17.
 */
public class UsersTest {
    @Test
    public void singIn() throws Exception {

    }

    @Test
    public void register() throws Exception {
        Users.register("test", "user");
        assertTrue(Users.auth("test", "user"));
    }

    @Test
    public void check() throws Exception {

    }

}