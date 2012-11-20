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
        String setPropCheck = this.checkSetProps(name,definitionFunction,K,accurancy,insSetProp);
        String windowPropCheck = this.checkWindowProps(zoom, heigth, width,
                comR, comG, comB, seR, seG, seB, bgR, bgG, bgB, coloringAlgorithm,center,insWinProp);
        if(setPropCheck == null && windowPropCheck == null)
        {
            return null;
        }
        else if(setPropCheck == null)
        {
            return windowPropCheck;
        }
        else if(windowPropCheck == null)
        {
            return setPropCheck;
        }
        else
        {
            return windowPropCheck + setPropCheck;
        }
    }
    /**
     * 
     * @param errorMessage
     * @param newError 
     */
    private void erorroMessage(String errorMessage,String newError)
    {
        if(errorMessage == null)
        {
            errorMessage = "";
        }
        errorMessage = errorMessage + " " + newError + " error";
    }
    /**
     * 
     * @param name
     * @param definitionFunction
     * @param K
     * @param accurancy
     * @param insSetProp
     * @return 
     */
    private String checkSetProps(String name,String definitionFunction,
            String K,int accurancy,InsertedSetProperties insSetProp)
    {
        String errorMessage = null;
        if(!insSetProp.setName(name))
        {
            this.erorroMessage(errorMessage,"name");
        }
        if(!insSetProp.setFunction(definitionFunction))
        {
            this.erorroMessage(errorMessage,"function");
        }
        if(!insSetProp.setAccurancy(accurancy))
        {
            this.erorroMessage(errorMessage,"accurancy");
        }
        if(!insSetProp.setK(K))
        {
            this.erorroMessage(errorMessage,"K value");
        }
        return errorMessage;
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
     * @return 
     */
    private String checkWindowProps(double zoom,int heigth,int width,int comR,int comG,int comB,
            int seR,int seG,int seB,int bgR,int bgG,int bgB,int coloringAlgorithm,String center,InsertedWindowProperties insWinProp)
    {
        String errorMessage = null;
        if(!insWinProp.setMainColor(comR,comG,comB))
        {
            this.erorroMessage(errorMessage,"set color");
        }
        if(!insWinProp.secondaryColor(seR,seG,seB))
        {
            this.erorroMessage(errorMessage,"secondary color");
        }
        if(!insWinProp.backroundColor(bgR,bgG,bgB))
        {
            this.erorroMessage(errorMessage,"backround color");
        }
        if(!insWinProp.setWidth(width))
        {
            this.erorroMessage(errorMessage,"width");
        }
        if(!insWinProp.setHeigth(heigth))
        {
            this.erorroMessage(errorMessage,"heigth");
        }
        if(!insWinProp.setZoom(zoom))
        {
            this.erorroMessage(errorMessage,"zoom");
        }
        if(!insWinProp.setCenter(center))
        {
            this.erorroMessage(errorMessage,"center");
        }
        insWinProp.setColoringAlgorithm(coloringAlgorithm);
        return errorMessage;
    }
}
