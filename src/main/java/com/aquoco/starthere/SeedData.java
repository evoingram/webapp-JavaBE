package com.aquoco.starthere;

import com.aquoco.starthere.models.*;
import com.aquoco.starthere.services.RateService;
import com.aquoco.starthere.services.RoleService;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
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

    @Autowired
    RateService rateService;

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
        users.add(new UserRoles(new User(), r2));
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

        ArrayList<Rate> rates;
        // rates data
        rates = new ArrayList<>();
        rates.add(new Rate());
        Rate rate1 = new Rate("CNB45",
                              "CNB45",
                              "45 calendar-day turnaround",
                              "45 calendar-day turnaround",
                              2.5);
        rateService.save(rate1, true);

        rates = new ArrayList<>();
        rates.add(new Rate());
        Rate rate2 = new Rate("CNB30",
                              "CNB30",
                              "30 calendar-day turnaround",
                              "30 calendar-day turnaround",
                              2.65);
        rateService.save(rate2, true);

        rates = new ArrayList<>();
        rates.add(new Rate());
        Rate rate3 = new Rate("CNB14",
                              "CNB14",
                              "14 calendar-day turnaround",
                              "14 calendar-day turnaround",
                              3.25);
        rateService.save(rate3, true);

        // rates data
        rates = new ArrayList<>();
        rates.add(new Rate());
        Rate rate4 = new Rate("CNB07",
                              "CNB07",
                              "07 calendar-day turnaround",
                              "07 calendar-day turnaround",
                              3.75);
        rateService.save(rate4, true);

        // rates data
        rates = new ArrayList<>();
        rates.add(new Rate());
        Rate rate5 = new Rate("CNB03",
                              "CNB03",
                              "03 calendar-day turnaround",
                              "03 calendar-day turnaround",
                              4.25);
        rateService.save(rate5, true);

        // rates data
        rates = new ArrayList<>();
        rates.add(new Rate());
        Rate rate6 = new Rate("CNB01",
                              "CNB01",
                              "01 calendar-day turnaround",
                              "01 calendar-day turnaround",
                              5.25);
        rateService.save(rate6, true);

        // rates data
        rates = new ArrayList<>();
        rates.add(new Rate());
        Rate rate7 = new Rate("MC",
                              "MC",
                              "minimum charge",
                              "minimum charge",
                              50.0);
        rateService.save(rate7, true);

        // rates data
        rates = new ArrayList<>();
        rates.add(new Rate());
        Rate rate8 = new Rate("KCI",
                              "KCI",
                              "king county rate",
                              "king county rate",
                              3.65);
        rateService.save(rate8, true);

        // rates data
        rates = new ArrayList<>();
        rates.add(new Rate());
        Rate rate9 = new Rate("NC10",
                              "NC10",
                              "noncourt regular",
                              "noncourt regular",
                              2.0);
        rateService.save(rate9, true);

        // rates data
        /*
        rates = new ArrayList<>();
        rates.add(new Rate());
        Rate rate10 = new Rate("NC1",
                               "NC1",
                               "noncourt overnight",
                               "noncourt overnight",
                               5.25);
        rateService.save(rate10, true);
         */
        
        // rates data
        rates = new ArrayList<>();
        rates.add(new Rate());
        Rate rate11 = new Rate("AMOR",
                               "AMOR",
                               "janet evans rate",
                               "janet evans rate",
                               2.2);
        rateService.save(rate11, true);

        // rates data
        rates = new ArrayList<>();
        rates.add(new Rate());
        Rate rate12 = new Rate("COPY",
                               "COPY",
                               "copy rate",
                               "copy rate",
                               0.4);
        rateService.save(rate12, true);

        // rates data
        rates = new ArrayList<>();
        rates.add(new Rate());
        Rate rate13 = new Rate("JJ",
                               "JJ",
                               "generic subcontractor rate",
                               "generic subcontractor rate",
                               1.75);
        rateService.save(rate13, true);

        // using JavaFaker create a bunch of regular users
        // https://www.baeldung.com/java-faker
        // https://www.baeldung.com/regular-expressions-java

        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"),
                                                                    new RandomService());
        Faker nameFaker = new Faker(new Locale("en-US"));

        for (int i = 10; i < 100; i++) {
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
                                nameFaker.equals(false),
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