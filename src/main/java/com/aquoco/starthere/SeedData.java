package com.aquoco.starthere;

import com.aquoco.starthere.models.*;
import com.aquoco.starthere.services.*;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
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

    @Autowired
    BrandingThemeService btService;

    @Autowired
    TurnaroundTimeService ttService;

    @Autowired
    MailClassService mcService;

    @Autowired
    PackageTypeService ptService;

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

        ArrayList<BrandingTheme> brandingthemes;

        // brandingthemes data
        brandingthemes = new ArrayList<>();
        brandingthemes.add(new BrandingTheme());
        BrandingTheme bt1 = new BrandingTheme("WRTS NC Factoring");
        btService.save(bt1, true);

        brandingthemes = new ArrayList<>();
        brandingthemes.add(new BrandingTheme());
        BrandingTheme bt2 = new BrandingTheme("WRTS NC 100 Deposit");
        btService.save(bt2, true);

        brandingthemes = new ArrayList<>();
        brandingthemes.add(new BrandingTheme());
        BrandingTheme bt3 = new BrandingTheme("WRTS C 50 Deposit Filed NONBK");
        btService.save(bt3, true);

        brandingthemes = new ArrayList<>();
        brandingthemes.add(new BrandingTheme());
        BrandingTheme bt4 = new BrandingTheme("WRTS C 50 Deposit Filed BK");
        btService.save(bt4, true);

        brandingthemes = new ArrayList<>();
        brandingthemes.add(new BrandingTheme());
        BrandingTheme bt5 = new BrandingTheme("WRTS C 50 Deposit Not Filed");
        btService.save(bt5, true);

        brandingthemes = new ArrayList<>();
        brandingthemes.add(new BrandingTheme());
        BrandingTheme bt6 = new BrandingTheme("WRTS C Factoring Filed");
        btService.save(bt6, true);

        brandingthemes = new ArrayList<>();
        brandingthemes.add(new BrandingTheme());
        BrandingTheme bt7 = new BrandingTheme("WRTS C Factoring Not Filed");
        btService.save(bt7, true);

        brandingthemes = new ArrayList<>();
        brandingthemes.add(new BrandingTheme());
        BrandingTheme bt8 = new BrandingTheme("WRTS C 100 Deposit Filed");
        btService.save(bt8, true);

        brandingthemes = new ArrayList<>();
        brandingthemes.add(new BrandingTheme());
        BrandingTheme bt9 = new BrandingTheme("WRTS C 100 Deposit Not Filed");
        btService.save(bt9, true);

        brandingthemes = new ArrayList<>();
        brandingthemes.add(new BrandingTheme());
        BrandingTheme bt10 = new BrandingTheme("WRTS JJ Factoring");
        btService.save(bt10, true);

        brandingthemes = new ArrayList<>();
        brandingthemes.add(new BrandingTheme());
        BrandingTheme bt11 = new BrandingTheme("WRTS Tabula Not Factored/Filed");
        btService.save(bt11, true);

        brandingthemes = new ArrayList<>();
        brandingthemes.add(new BrandingTheme());
        BrandingTheme bt12 = new BrandingTheme("WRTS AMOR Factoring");
        btService.save(bt12, true);

        ArrayList<TurnaroundTime> turnaroundtimes;

        // turnaroundtimes data
        turnaroundtimes = new ArrayList<>();
        turnaroundtimes.add(new TurnaroundTime());
        TurnaroundTime tt1 = new TurnaroundTime(45);
        ttService.save(tt1, true);

        turnaroundtimes = new ArrayList<>();
        turnaroundtimes.add(new TurnaroundTime());
        TurnaroundTime tt2 = new TurnaroundTime(30);
        ttService.save(tt2, true);

        turnaroundtimes = new ArrayList<>();
        turnaroundtimes.add(new TurnaroundTime());
        TurnaroundTime tt3 = new TurnaroundTime(14);
        ttService.save(tt3, true);

        turnaroundtimes = new ArrayList<>();
        turnaroundtimes.add(new TurnaroundTime());
        TurnaroundTime tt4 = new TurnaroundTime(10);
        ttService.save(tt4, true);

        turnaroundtimes = new ArrayList<>();
        turnaroundtimes.add(new TurnaroundTime());
        TurnaroundTime tt5 = new TurnaroundTime(7);
        ttService.save(tt5, true);

        turnaroundtimes = new ArrayList<>();
        turnaroundtimes.add(new TurnaroundTime());
        TurnaroundTime tt6 = new TurnaroundTime(3);
        ttService.save(tt6, true);

        turnaroundtimes = new ArrayList<>();
        turnaroundtimes.add(new TurnaroundTime());
        TurnaroundTime tt7 = new TurnaroundTime(1);
        ttService.save(tt7, true);


        ArrayList<MailClass> mailclasses;

        // mailclasses data
        mailclasses = new ArrayList<>();
        mailclasses.add(new MailClass());
        MailClass mc1 = new MailClass("FIRST", "First");
        mcService.save(mc1, true);

        mailclasses = new ArrayList<>();
        mailclasses.add(new MailClass());
        MailClass mc2 = new MailClass("EXPRESS", "Express Mail");
        mcService.save(mc2, true);

        mailclasses = new ArrayList<>();
        mailclasses.add(new MailClass());
        MailClass mc3 = new MailClass("PRIORITY", "Priority Mail");
        mcService.save(mc3, true);

        mailclasses = new ArrayList<>();
        mailclasses.add(new MailClass());
        MailClass mc4 = new MailClass("NONE", "Do not print postage");
        mcService.save(mc4, true);

        mailclasses = new ArrayList<>();
        mailclasses.add(new MailClass());
        MailClass mc5 = new MailClass("PARCELPOST", "Parcel Post");
        mcService.save(mc5, true);

        mailclasses = new ArrayList<>();
        mailclasses.add(new MailClass());
        MailClass mc6 = new MailClass("INTLFIRST", "International First-Class");
        mcService.save(mc6, true);

        mailclasses = new ArrayList<>();
        mailclasses.add(new MailClass());
        MailClass mc7 = new MailClass("INTLEXPRESS", "International Express Mail");
        mcService.save(mc7, true);

        mailclasses = new ArrayList<>();
        mailclasses.add(new MailClass());
        MailClass mc8 = new MailClass("INTLPRIORITY", "International Priority Mail");
        mcService.save(mc8, true);

        mailclasses = new ArrayList<>();
        mailclasses.add(new MailClass());
        MailClass mc9 = new MailClass("MEDIAMAIL", "Media Mail");
        mcService.save(mc9, true);

        mailclasses = new ArrayList<>();
        mailclasses.add(new MailClass());
        MailClass mc10 = new MailClass("LIBRARYMAIL", "Library Mail");
        mcService.save(mc10, true);

        mailclasses = new ArrayList<>();
        mailclasses.add(new MailClass());
        MailClass mc11 = new MailClass("BOUNDPRINTEDMATTER", "Bound Printed Matter");
        mcService.save(mc11, true);

        mailclasses = new ArrayList<>();
        mailclasses.add(new MailClass());
        MailClass mc12 = new MailClass("PRESORTEDFIRST", "Presorted, First-Class");
        mcService.save(mc12, true);

        mailclasses = new ArrayList<>();
        mailclasses.add(new MailClass());
        MailClass mc13 = new MailClass("PRESORTEDSTANDARD", "Presorted, Standard Class");
        mcService.save(mc13, true);

        mailclasses = new ArrayList<>();
        mailclasses.add(new MailClass());
        MailClass mc14 = new MailClass("INTLGXG", "Global Express Guaranteed");
        mcService.save(mc14, true);

        mailclasses = new ArrayList<>();
        mailclasses.add(new MailClass());
        MailClass mc15 = new MailClass("INTLGXGNODOC", "Global Express Guaranteed Non-Docs");
        mcService.save(mc15, true);

        ArrayList<PackageType> packagetypes;

        // packagetypes data
        packagetypes = new ArrayList<>();
        packagetypes.add(new PackageType());
        PackageType pt1 = new PackageType("ENVELOPE", "Standard letter rate");
        ptService.save(pt1, true);

        packagetypes = new ArrayList<>();
        packagetypes.add(new PackageType());
        PackageType pt2 = new PackageType("RECTPARCEL", "Rectangular parcel, the standard parcel");
        ptService.save(pt2, true);

        packagetypes = new ArrayList<>();
        packagetypes.add(new PackageType());
        PackageType pt3 = new PackageType("NONRECTPARCEL", "Non-rectangular parcel – impacts rate for PM");
        ptService.save(pt3, true);

        packagetypes = new ArrayList<>();
        packagetypes.add(new PackageType());
        PackageType pt4 = new PackageType("FLATRATEENVELOPE", "Flat Rate Envelope – PM and EM");
        ptService.save(pt4, true);

        packagetypes = new ArrayList<>();
        packagetypes.add(new PackageType());
        PackageType pt5 = new PackageType("FLATRATEBOX", "Flat Rate Box PM");
        ptService.save(pt5, true);

        packagetypes = new ArrayList<>();
        packagetypes.add(new PackageType());
        PackageType pt6 = new PackageType("FLATRATELARGEBOX", "Flat Rate Large Box PM");
        ptService.save(pt6, true);

        packagetypes = new ArrayList<>();
        packagetypes.add(new PackageType());
        PackageType pt7 = new PackageType("POSTCARD", "Postcard rate (FC and International FC)");
        ptService.save(pt7, true);

        packagetypes = new ArrayList<>();
        packagetypes.add(new PackageType());
        PackageType pt8 = new PackageType("FLAT", "Flat rate (only affects rate for FC mail)");
        ptService.save(pt8, true);

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