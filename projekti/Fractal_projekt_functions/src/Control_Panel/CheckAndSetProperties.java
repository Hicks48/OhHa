/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Panel;

/**
 *
 * @author henrikorpela
 */
public class CheckAndSetProperties {
    private String errorMessage;
    /**
     * 
     * @param comR
     * @param comG
     * @param comB
     * @param seR
     * @param seG
     * @param seB
     * @param bgR
     * @param bgG
     * @param bgB
     * @param zoom
     * @param heigth
     * @param width
     * @param center
     * @param insWinProp
     * @param name
     * @param definitionFunction
     * @param K
     * @param accurancy
     * @param coloringAlgorithm
     * @param insSetProp
     * @return 
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
        if(this.errorMessage.equals(" function error\n") || this.errorMessage.equals("K value error\n"))
        {
            return null;
        }
        else
        {
            return this.errorMessage;
        }
    }
    /**
     * 
     * @param errorMessage
     * @param newError 
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
     * 
     * @param name
     * @param definitionFunction
     * @param K
     * @param accurancy
     * @param insSetProp
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
     * 
     * @param zoom
     * @param heigth
     * @param width
     * @param comR
     * @param comG
     * @param comB
     * @param seR
     * @param seG
     * @param seB
     * @param bgR
     * @param bgG
     * @param bgB
     * @param coloringAlgorithm
     * @param center
     * @param insWinProp
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
