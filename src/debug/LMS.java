package debug;

import services.MailerService;

public class LMS {
    public static void testMailer() {
        MailerService.sendMessage("kimmiejoe75@gmail.com", "Test subject", "Test message");
    }
    public static void main(String[] args) {
        testMailer();
    }
}
