import edu.gwu.algtest.*;
import edu.gwu.debug.*;
import edu.gwu.util.*;
import edu.gwu.algtest.Algorithm;
import edu.gwu.geometry.Pointd;

import java.lang.Math;
import java.lang.Double;

import java.util.*;

class CellList{
  List<Pointd> cell=new LinkedList<Pointd>();
  private double mindist;
  int call=0;



  public CellList(){

  }
  public void setmindist(double distance){
    this.mindist=distance;
  }
  public double getmindist(){
    return this.mindist;
  }
  public void insert(Pointd point){
    call++;
    int i=0;
    int index=0;
    double mind=Double.MAX_VALUE;
  // System.out.println("Inside insert min is:");
    if(cell.size()==0){
    //  System.out.println("first insert w/point "+point);
      cell.add(point);

    //  System.out.println("first point in cell"+ point +" and this is the "+call+"x time insert was called");
    } else if(cell.size()==1){
    //  System.out.println("line 37 in celllist: distance is "+  distance(point,cell.get(0)));
  //  System.out.println("this is the distance"+ distance(point, cell.get(0)));
      setmindist(distance(point,cell.get(0)));
      cell.add(point);
    //  System.out.println("if there is another element in the cell, go here. "+ point +" "+ cell.get(0));
    } else{
    //  System.out.println("49");
    for(Pointd points:cell ){
      mind=distance(point, points);
      if(mind<getmindist())
      {
        setmindist(mind);
      }
      i++;
    }
    cell.add(point);
  }
}




  public double distance(edu.gwu.geometry.Pointd point1, edu.gwu.geometry.Pointd point2){

    double x1=point1.getx();
    double x2=point2.getx();
    double y1=point1.gety();
    double y2=point2.gety();
//    System.out.println("The two points are: "+ x1 + " ," +y1+ " and " +x2 + " ," +y2);


    double distance=Math.sqrt(Math.pow((x2-x1),2) +Math.pow( (y2-y1),2));
    //System.out.println("The distance is " +distance);
    return distance;
  }

}
