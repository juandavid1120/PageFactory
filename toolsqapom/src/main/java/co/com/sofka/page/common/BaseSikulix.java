package co.com.sofka.page.common;

import org.apache.log4j.Logger;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class BaseSikulix {

    private static final Logger LOGGER = Logger.getLogger(BaseSikulix.class);

    public BaseSikulix() {
        //Constructor by default.
    }

    public void clickOn(String path){
        Screen s = new Screen();

        try{
            s.wait(path);
            s.click(path);
        }
        catch(FindFailed e){
            LOGGER.warn(e.getMessage(), e);
        }
    }

    public void insertInto(String path, String text){
        Screen s = new Screen();
        try{
            s.wait(path);
            s.write(text);
        }
        catch(FindFailed e){
            LOGGER.warn(e.getMessage(), e);
        }
    }
}
