package org.alex;




import org.alex.data.Advertisement;
import org.alex.service.BotService;
import org.alex.service.DataService;
import org.alex.util.HtmlParser;

public class Application {
    private static Advertisement advertisement;

    public static void main(String[] args) throws InterruptedException {
        BotService botService=new BotService();
        botService.initBot();
        DataService dataService=new DataService();
        while (true) {
            String content = dataService.getContent();
            Advertisement advertisement = HtmlParser.createAdvertisement(content);
            System.out.println(advertisement.getURL());
            if(Application.advertisement==null){
                Application.advertisement=advertisement;
                botService.carFinderBot.writeMessage(advertisement);
            }else {
                if(Application.advertisement.equals(advertisement)){
                    Application.advertisement=advertisement;
                    botService.carFinderBot.writeMessage(advertisement);
                }
            }
            Thread.sleep(60000);
        }
    }
}
