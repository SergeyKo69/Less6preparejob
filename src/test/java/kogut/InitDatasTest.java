package kogut;

import org.junit.Assert;
import org.junit.Test;
import ru.kogut.model.RoleEntity;
import ru.kogut.model.UserEntity;
import ru.kogut.model.UserRoleEntity;
import ru.kogut.service.RoleService;
import ru.kogut.service.UserRoleService;
import ru.kogut.service.UserService;

/**
 * @author S.Kogut on 2019-04-05
 */
public class InitDatasTest {

    @Test
    public void test(){
        final UserService userService = new UserService();

        final UserEntity user = userService.findOne("1");

        Assert.assertEquals(user.getLogin(),"Admin");
        Assert.assertEquals(user.getName(), "Administrator");
        Assert.assertEquals(user.getId(), "1");
        Assert.assertEquals(user.getPassword(), "123");

        final RoleService roleService = new RoleService();

        RoleEntity role = roleService.findOne("1");

        Assert.assertEquals(role.getName(), "Administrator");

        role = roleService.findOne("2");

        Assert.assertEquals(role.getName(), "User");

        final UserRoleService userRoleService = new UserRoleService();

        final UserRoleEntity userRoleEntity = userRoleService.findOne("1");

        Assert.assertEquals(userRoleEntity.getRoleId(), "1");
        Assert.assertEquals(userRoleEntity.getUserId(), "1");

    }
}
