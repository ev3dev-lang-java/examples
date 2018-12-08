package examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnector {

    public static Logger LOGGER = LoggerFactory.getLogger(HttpConnector.class);

    private final String anotherIp;

    //private final HttpClient httpClient;
    //private final HttpRequest leftRequest;
    //private final HttpRequest rightRequest;
    private HttpURLConnection leftcon;
    private HttpURLConnection rightcon;

    public HttpConnector(String anotherIp) {

        LOGGER.info("Creating Http Connector");

        this.anotherIp = anotherIp;


        //httpClient = HttpClient.newBuilder().build();
        //leftRequest = HttpRequest.newBuilder()
        //        .uri(URI.create("http://" + anotherIp + ":9000/left"))
        //        .build();
        //rightRequest = HttpRequest.newBuilder()
        //        .uri(URI.create("http://" + anotherIp + ":9000/right"))
        //        .build();

        try {
            URL leftURL = new URL("http://" + anotherIp + ":9000/left");
            URL rightURL = new URL("http://" + anotherIp + ":9000/right");
            leftcon = (HttpURLConnection) leftURL.openConnection();
            leftcon.setRequestMethod("GET");
            rightcon = (HttpURLConnection) rightURL.openConnection();
            rightcon.setRequestMethod("GET");
            leftcon.setConnectTimeout(5000);
            leftcon.setReadTimeout(5000);
            rightcon.setConnectTimeout(5000);
            rightcon.setReadTimeout(5000);
        } catch(IOException e) {
            LOGGER.error(e.getLocalizedMessage());
        }

    }

    private final String USER_AGENT = "Mozilla/5.0";

    // HTTP GET request
    public void pingLeft() {

        try {

            LOGGER.info("Left ping");

            //String url = "http://www.google.com/search?q=mkyong";
            URL obj = new URL("http://" + anotherIp + ":9000/left");

            //URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            LOGGER.info("Sending 'GET' request to URL : {}" ,obj.toString());
            LOGGER.info("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            LOGGER.info(response.toString());

        }catch(RuntimeException | IOException e) {
            LOGGER.error(e.getLocalizedMessage());
        }

    }



    // HTTP GET request
    public void pingRight() {

        try {

            LOGGER.info("Right ping");

            //String url = "http://www.google.com/search?q=mkyong";
            URL obj = new URL("http://" + anotherIp + ":9000/right");

            //URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            LOGGER.info("Sending 'GET' request to URL : {}", obj.toString());
            LOGGER.info("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            LOGGER.info(response.toString());

        }catch(StringIndexOutOfBoundsException | IOException e) {
            LOGGER.error(e.getLocalizedMessage());
        }
    }

}
