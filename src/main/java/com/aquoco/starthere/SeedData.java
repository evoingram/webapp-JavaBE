package com.aquoco.starthere;

import com.aquoco.starthere.services.RoleService;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.aquoco.starthere.models.Role;
import com.aquoco.starthere.models.User;
import com.aquoco.starthere.models.UserRoles;
import com.aquoco.starthere.models.Useremail;
import com.aquoco.starthere.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Locale;

@Transactional
@Component
public class SeedData
        implements CommandLineRunner {
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;


    @Override
    public void run(String[] args) throws
            Exception {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);

        // admin, data, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(),
                                 r1));
        admins.add(new UserRoles(new User(),
                                 r2));
        admins.add(new UserRoles(new User(),
                                 r3));
        User u1 = new User("admin",
                           "password",
                           "admin@lambdaschool.local",
                           false,
                           "A Quo Co.",
                           "Ms",
                           "Ingram",
                           "Erica",
                           "owner",
                           "(206) 478-5028",
                           "320 W Republican, Suite 207",
                           "",
                           "Seattle",
                           "WA",
                           "98119",
                           "",
                           admins);
        u1.getUseremails()
          .add(new Useremail(u1,
                             "admin@email.local"));
        u1.getUseremails()
          .add(new Useremail(u1,
                             "admin@mymail.local"));

        userService.save(u1);

        // data, user
        ArrayList<UserRoles> datas = new ArrayList<>();
        datas.add(new UserRoles(new User(),
                                r3));
        datas.add(new UserRoles(new User(),
                                r2));
        User u2 = new User("cinnamon",
                           "1234567",
                           "cinnamon@lambdaschool.local",
                           false,
                           "Lambda School",
                           "Ms",
                           "Bunn",
                           "Cinnamon",
                           "",
                           "(206) 478-5028",
                           "1525 2nd Avenue",
                           "",
                           "Seattle",
                           "WA",
                           "98101",
                           "",
                           datas);
        u2.getUseremails()
          .add(new Useremail(u2,
                             "cinnamon@mymail.local"));
        u2.getUseremails()
          .add(new Useremail(u2,
                             "hops@mymail.local"));
        u2.getUseremails()
          .add(new Useremail(u2,
                             "bunny@email.local"));
        userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(),
                                r2));
        User u3 = new User("barnbarn",
                           "ILuvM4th!",
                           "barnbarn@lambdaschool.local",
                           false,
                           "Lambda",
                           "Mr",
                           "Hops",
                           "Barnbarn",
                           "",
                           "(206) 478-5028",
                           "123 Anywhere",
                           "",
                           "Seattle",
                           "WA",
                           "98104",
                           "",
                           users);
        u3.getUseremails()
          .add(new Useremail(u3,
                             "barnbarn@email.local"));
        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(),
                                r2));
        User u4 = new User("puttat",
                           "password",
                           "puttat@school.lambda",
                           false,
                           "Looney Tunes",
                           "Mr",
                           "Sylvester",
                           "Tweety",
                           "",
                           "(206) 478-5028",
                           "123 Main Street",
                           "",
                           "Seattle",
                           "WA",
                           "98108",
                           "",
                           users);
        userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(),
                                r2));
        User u5 = new User("misskitty",
                           "password",
                           "misskitty@school.lambda",
                           false,
                           "Sleepy Inn",
                           "Ms",
                           "Keystone",
                           "Kitty",
                           "",
                           "(206) 478-5028",
                           "1230 Fourth Avenue",
                           "",
                           "Seattle",
                           "WA",
                           "98101",
                           "",
                           users);
        userService.save(u5);

        // using JavaFaker create a bunch of regular users
        // https://www.baeldung.com/java-faker
        // https://www.baeldung.com/regular-expressions-java

        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"),
                                                                    new RandomService());
        Faker nameFaker = new Faker(new Locale("en-US"));

        for (int i = 0; i < 100; i++) {
            new User();
            User fakeUser;

            users = new ArrayList<>();
            users.add(new UserRoles(new User(),
                                    r2));
            fakeUser = new User(nameFaker.name()
                                         .username(),
                                "password",
                                nameFaker.internet()
                                         .emailAddress(),
                                false,
                                nameFaker.company().name(),
                                "",
                                nameFaker.name().lastName(),
                                nameFaker.name().firstName(),
                                nameFaker.job().title(),
                                nameFaker.phoneNumber().phoneNumber(),
                                nameFaker.address().streetAddress(),
                                "",
                                nameFaker.address().cityName(),
                                nameFaker.address().stateAbbr(),
                                nameFaker.address().zipCode(),
                                "",
                                users);
            fakeUser.getUseremails()
                    .add(new Useremail(fakeUser,
                                       fakeValuesService.bothify("????##@gmail.com")));
            userService.save(fakeUser);
        }
    }
}