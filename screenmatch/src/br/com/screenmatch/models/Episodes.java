package br.com.screenmatch.models;
import br.com.screenmatch.calculations.Classified;

public class Episodes implements Classified{
    private int num;
    private String epName;
    private Series series;
    private int totalViews;

    @Override
    public int getClassification() {
        if (totalViews > 100) {
            return 4;
        } else if (totalViews >= 50){
            return 2;
        } else {
            return 0;
        }
    }

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getEpName() {
        return epName;
    }

    public void setEpName(String epName) {
        this.epName = epName;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    
    
}
