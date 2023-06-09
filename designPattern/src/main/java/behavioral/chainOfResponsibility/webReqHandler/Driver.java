package behavioral.chainOfResponsibility.webReqHandler;

public class Driver {
    public static void main(String[] args) {
        // Authentication -> Log -> compression -> Encryption

        Encryptor encryptor = new Encryptor(null);
        Compressor compressor = new Compressor(encryptor);
        Logger logger = new Logger(compressor);
        Authenticator authenticator = new Authenticator(logger);
        WebServer webServer = new WebServer(authenticator);
        webServer.handle(new HttpRequest("admin", "1234"));
    }
}
