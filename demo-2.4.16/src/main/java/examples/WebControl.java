package examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class WebControl {

  public static Logger LOGGER = LoggerFactory.getLogger(WebControl.class);

  public static final int PORT = 9000;
  private ServerSocket ss;
  private Socket sock;

  private final DisplayAnimations displayAnimations;

  public WebControl(DisplayAnimations displayAnimations) throws IOException {
    LOGGER.info("Creating a simple API");

    ss = new ServerSocket(PORT);

    this.displayAnimations = displayAnimations;
  }

  public void run() throws IOException {
    for (;;) {
      sock = ss.accept();
      InputStream is = sock.getInputStream();
      OutputStream os = sock.getOutputStream();

      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      PrintStream ps = new PrintStream(os);

      for (;;) {
        String cmd = br.readLine();
        if (cmd == null)
          break;
        String reply = execute(cmd);
        if (reply != null)
          ps.println(reply);
        else {
          br.close();
          ps.close();
          break;
        }
      }

    }
  }

  public String execute(String cmd) {
    String[] tokens = cmd.split(" ");

    if (tokens.length > 1 && tokens[0].equals("GET")) {

      if (tokens[1].equals("/stop")) {
        LOGGER.info("{}", tokens[1]);
        System.exit(0);
      } else if (tokens[1].equals("/left")) {

        LOGGER.info("{}", tokens[1]);
        displayAnimations.sin();
        displayAnimations.clear();
        displayAnimations.showJavaLogo();

      } else if (tokens[1].equals("/right")) {

        LOGGER.info("{}", tokens[1]);
        displayAnimations.sin2();
        displayAnimations.clear();
        displayAnimations.showJavaLogo();
      }

      return "HTTP/1.1 200 OK\r\n\r\n" + readFile() + "\r\n";
    }
    return null;
  }

  private String readFile() {

    StringBuffer document = new StringBuffer();

    try {

      InputStream in = this.getClass().getClassLoader().getResourceAsStream("index.html");

      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in), 1);
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        document.append(line);
      }
      in.close();

    }catch (IOException io) {
      LOGGER.error(io.getLocalizedMessage());
    }

    return document.toString();

  }

}