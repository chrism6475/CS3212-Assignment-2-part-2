import edu.gwu.algtest.*;
import edu.gwu.debug.*;
import edu.gwu.util.*;
import edu.gwu.algtest.Algorithm;


import java.lang.Math;

import java.util.*;

public class NaiveClosestPair implements ClosestPairAlgorithm{

  public double findClosestPairDistance(edu.gwu.geometry.Pointd[] points){
      double mindist;
      double dis=0;
      mindist=distance(points[0],points[1]);
      for(int i=0;i<points.length;i++){
        for(int j=i+1;j<points.length;j++){
        //System.out.println(dis +" " + mindist);
        dis=distance(points[i],points[j]);
          if(dis<mindist){
            mindist=dis;
          }
        }
    }
      return mindist;
  }

  public double distance(edu.gwu.geometry.Pointd point1, edu.gwu.geometry.Pointd point2){

    double x1=point1.getx();
    double x2=point2.getx();
    double y1=point1.gety();
    double y2=point2.gety();
    //System.out.println("The two points are: "+ x1 + " ," +y1+ " and " +x2 + " ," +y2);


    double distance=Math.sqrt(Math.pow((x2-x1),2) +Math.pow( (y2-y1),2));
    return distance;
  }

public void	setPropertyExtractor(int algID, edu.gwu.util.PropertyExtractor prop) {

       }
public java.lang.String	getName() {
         return "Christian's NaiveCLosestPair";
       }
}
