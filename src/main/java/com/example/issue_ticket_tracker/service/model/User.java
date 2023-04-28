package com.example.issue_ticket_tracker.service.model;

public class User {
    // 2 tábla:
    // 1.) Maga a USER tábla, userNév + password, randomString (salt)-okat tartalmazza.
    // FONTOS: Sohasem fejtjük visszafelé a hasht a passwordre.
    // A user megad egy passwordot, azt is hasheljük, salt, és ugyan azt a hash funkciót használjuk és azt csekkoljuk hogy jó-e az eltárolt hashelt jelszóval
    // Mi az igazi password-hoz nem férhetünk hozzá...

    // 2.) Másik tábla: Role tábla... admin, user, stb...

    // 3.) Ha van profilja, akkor az esetleg lehet a harmadik...
}
