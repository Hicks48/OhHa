
package Control_Panel;

/**
 * Checks that all given properties are
 * valid and sets properties.
 * @author Henri Korpela
 */
public class CheckAndSetProperties {
    private String errorMessage;
    /**
     * Return errors that happened when values were inserted
     * or null if no errors happened.
     * @param comR red RGB value of main color of the set.
     * @param comG green RGB value of main color of the set.
     * @param comB blue RGB value of main color of the set.
     * @param seR red RGB value of secondary
     * color of the set.
     * @param seB blue RGB value of secondary
     * color of the set.
     * @param seG green RGB value of secondary
     * color of the set.
     * @param bgR red RGB value of background
     * color of the window.
     * @param bgG green RGB value of background
     * color of the window.
     * @param bgB blue RGB value of background
     * color of the window.
     * @param zoom zoom value of the window.
     * @param heigth height of the window.
     * @param width width of the window.
     * @param center complex-number that
     * is at the center of the window.
     * @param insWinProp InsertedWindowProperties object that
     * window properties are inserted.
     * @param name name of the set.
     * @param definitionFunction definitionFunction of the set.
     * @param K K value of the set.
     * @param accurancy accuracy of the set.
     * @param coloringAlgorithm Integer that defines coloring algorithm that
     * is used.
     * @param insSetProp InsertedSetProperties object that
     * set properties are inserted.
     * @return String containing possible errors or null if no errors
     * were found.
     */
    public String chekProps(int comR,int comG,int comB,int seR,int seG,int seB,int bgR,int bgG,int bgB,
            double zoom,int heigth,int width,String center,InsertedWindowProperties insWinProp,
            String name,String definitionFunction,String K,
            int accurancy,int coloringAlgorithm,InsertedSetProperties insSetProp)
    {
        this.errorMessage = null;
        this.checkSetProps(name,definitionFunction,K,accurancy,insSetProp);
        this.checkWindowProps(zoom, heigth, width,
                comR, comG, comB, seR, seG, seB, bgR, bgG, bgB, coloringAlgorithm,center,insWinProp);
        if(this.errorMessage.equals(" function error\n") || this.errorMessage.equals(" K value error\n"))
        {
            return null;
        }
        else
        {
            if(!(this.errorMessage.contains(" function error\n") && this.errorMessage.contains(" K value error\n")))
            {
                this.errorMessage = this.errorMessage.replaceAll(" function error\n","");
                this.errorMessage = this.errorMessage.replaceAll(" K value error\n","");
            }
            return this.errorMessage;
        }
    }
    /**
     * Adds new error into error message.
     * @param errorMessage Error message.
     * @param newError new error that is being
     * added to the error message.
     */
    private void  erorroMessage(String newError)
    {
        if(this.errorMessage == null)
        {
            this.errorMessage = "";
        }
        this.errorMessage = this.errorMessage + " " + newError + " error\n";
    }
    /**
     * Inserts set related properties into given
     * InsertedProperties object.
     * Fills error message with errors that occur.
     * @param name name of the set.
     * @param definitionFunction definitionFunction of the set.
     * @param K K value of the set.
     * @param accurancy accuracy of the set.
     * @param insSetProp InsertedSetProperties object that
     * set properties are inserted.
     */
    private void checkSetProps(String name,String definitionFunction,
            String K,int accurancy,InsertedSetProperties insSetProp)
    {
        if(!insSetProp.setName(name))
        {
            this.erorroMessage("name");
        }
        if(!insSetProp.setFunction(definitionFunction))
        {
            this.erorroMessage("function");
        }
        if(!insSetProp.setAccurancy(accurancy))
        {
            this.erorroMessage("accurancy");
        }
        if(!insSetProp.setK(K))
        {
            this.erorroMessage("K value");
        }
    }
    /**
     * Inserts window related properties into
     * given InsertedWindowProperties object.
     * Fills error message with errors that occur.
     * @param zoom zoom value of the window.
     * @param heigth height of the window.
     * @param width width of the window.
     * @param comR red RGB value of main color of the set.
     * @param comG green RGB value of main color of the set.
     * @param comB blue RGB value of main color of the set.
     * @param seR red RGB value of secondary
     * color of the set.
     * @param seB blue RGB value of secondary
     * color of the set.
     * @param seG green RGB value of secondary
     * color of the set.
     * @param bgR red RGB value of background
     * color of the window.
     * @param bgG green RGB value of background
     * color of the window.
     * @param bgB blue RGB value of background
     * color of the window.
     * @param coloringAlgorithm Integer that defines coloring algorithm that
     * is used.
     * @param center complex-number that
     * is at the center of the window.
     * @param insWinProp InsertedWindowProperties object that
     * window properties are inserted.
     */
    private void checkWindowProps(double zoom,int heigth,int width,int comR,int comG,int comB,
            int seR,int seG,int seB,int bgR,int bgG,int bgB,int coloringAlgorithm,String center,InsertedWindowProperties insWinProp)
    {
        if(!insWinProp.setMainColor(comR,comG,comB))
        {
            this.erorroMessage("set color");
        }
        if(!insWinProp.secondaryColor(seR,seG,seB))
        {
            this.erorroMessage("secondary color");
        }
        if(!insWinProp.backroundColor(bgR,bgG,bgB))
        {
            this.erorroMessage("backround color");
        }
        if(!insWinProp.setWidth(width))
        {
            this.erorroMessage("width");
        }
        if(!insWinProp.setHeigth(heigth))
        {
            this.erorroMessage("heigth");
        }
        if(!insWinProp.setZoom(zoom))
        {
            this.erorroMessage("zoom");
        }
        if(!insWinProp.setCenter(center))
        {
            this.erorroMessage("center");
        }
        insWinProp.setColoringAlgorithm(coloringAlgorithm);
    }
}
