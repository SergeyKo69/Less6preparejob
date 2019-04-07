package kogut;

import org.junit.Assert;
import org.junit.Test;
import ru.kogut.model.RoleEntity;
import ru.kogut.model.UserEntity;
import ru.kogut.model.UserRoleEntity;
import ru.kogut.service.RoleService;
import ru.kogut.service.UserRoleService;
import ru.kogut.service.UserService;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author S.Kogut on 2019-03-25
 */
public class CRUDTest {

    @Test
    public void CRUDUserTest() throws IOException {

        final UserService userService = new UserService();
        final UserEntity user = new UserEntity();
        user.setId(UUID.randomUUID().toString());
        user.setName("Test name");
        user.setLogin("Test login");
        user.setPassword("Test password");
        user.seteMail("Test eMail");
        userService.create(user);

        Assert.assertNotNull(user.getId());

        UserEntity userTemp1 = userService.findOne(user.getId());

        Assert.assertNotNull(userTemp1);
        Assert.assertNotNull(userTemp1.getId());
        Assert.assertEquals(user.getId(), userTemp1.getId());

        final List<UserEntity> userList = userService.findAll();

        Assert.assertNotNull(userList);
        Assert.assertTrue(userList.size() > 0);

        user.setLogin("Test login update");
        userService.update(user);

        Assert.assertEquals(user.getLogin(), "Test login update");

        userService.deleteById(user.getId());
        userTemp1 = userService.findOne(user.getId());

        Assert.assertNull(userTemp1);

        userService.create(user);
        userTemp1 = userService.findOne(user.getId());

        Assert.assertNotNull(userTemp1);

        userService.delete(userTemp1);
        userTemp1 = userService.findOne(user.getId());

        Assert.assertNull(userTemp1);

    }

    @Test
    public void CRUDRoleTest() throws IOException {
        final RoleService roleService = new RoleService();
        final RoleEntity role = new RoleEntity();
        role.setId(UUID.randomUUID().toString());
        role.setName("Test name");

        Assert.assertNotNull(role.getId());

        roleService.create(role);

        Assert.assertNotNull(role.getId());

        RoleEntity roleTemp = roleService.findOne(role.getId());

        Assert.assertNotNull(roleTemp);
        Assert.assertEquals(roleTemp.getId(), role.getId());
        Assert.assertEquals(roleTemp.getName(), role.getName());

        final List<RoleEntity> roleList = roleService.findAll();

        Assert.assertTrue(roleList.size() > 0);

        role.setName("Test name update");

        roleService.update(role);

        roleTemp = roleService.findOne(role.getId());

        Assert.assertNotNull(roleTemp);
        Assert.assertEquals(roleTemp.getName(), "Test name update");

        roleService.deleteById(role.getId());
        roleTemp = roleService.findOne(role.getId());

        Assert.assertNull(roleTemp);

        roleService.create(role);
        roleTemp = roleService.findOne(role.getId());

        Assert.assertNotNull(roleTemp);

        roleService.delete(role);
        roleTemp = roleService.findOne(role.getId());

        Assert.assertNull(roleTemp);

    }

    @Test
    public void CRUDUserRoleTest() throws IOException {
        final UserRoleService userRoleService = new UserRoleService();
        final UserRoleEntity userRole = new UserRoleEntity();
        userRole.setId(UUID.randomUUID().toString());
        userRole.setRoleId("1");
        userRole.setUserId("1");

        Assert.assertNotNull(userRole.getId());

        userRoleService.create(userRole);
        UserRoleEntity userRoleTemp = userRoleService.findOne(userRole.getId());

        Assert.assertNotNull(userRoleTemp);

        List<UserRoleEntity> userRoleList  = userRoleService.findByRoleId("1");

        Assert.assertNotNull(userRoleList);
        Assert.assertTrue(userRoleList.size() > 0);

        userRoleList = userRoleService.findByUserId("1");

        Assert.assertNotNull(userRoleList);
        Assert.assertTrue(userRoleList.size() > 0);

        userRoleList = userRoleService.findAll();

        Assert.assertNotNull(userRoleList);
        Assert.assertTrue(userRoleList.size() > 0);

        userRole.setRoleId("2");
        userRoleService.update(userRole);
        userRoleList = userRoleService.findByRoleId("2");

        Assert.assertNotNull(userRoleList);
        Assert.assertTrue(userRoleList.size() > 0);

        userRoleService.deleteById(userRole.getId());
        userRoleTemp = userRoleService.findOne(userRole.getId());

        Assert.assertNull(userRoleTemp);

        userRoleService.create(userRole);
        userRoleTemp = userRoleService.findOne(userRole.getId());

        Assert.assertNotNull(userRoleTemp);

        userRoleService.delete(userRoleTemp);
        userRoleTemp = userRoleService.findOne(userRole.getId());

        Assert.assertNull(userRoleTemp);

    }
}
