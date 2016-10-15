import edu.gwu.algtest.*;
import edu.gwu.debug.*;
import edu.gwu.util.*;
import edu.gwu.algtest.Algorithm;
import edu.gwu.geometry.Pointd;

import java.lang.Math;

import java.util.*;

public class Grid implements ClosestPairAlgorithm{

  public double findClosestPairDistance(edu.gwu.geometry.Pointd[] points){

//create grid
System.out.println("Creating a new grid");
      CellList []grid=creategrid(points);
      double mindist=grid[0].getmindist();
      for(CellList eachcell:grid){

        if(eachcell.getmindist()<mindist && eachcell.getmindist()!=0){
          mindist=eachcell.getmindist();

        }
      //  System.out.println("line 23: "+ eachcell.getmindist());
      }

      System.out.println("The distance is "+ mindist);
      //compare each cell's points to it's adjacent cell's points
      for(CellList points:grid){
        for(int i=0;i<points.length;i++){
         for(int j=0;j<points.length)
          points.cell.get(i);

        }
      }


      return mindist;
  }

//input: outer bounds of the grid
  public CellList[] creategrid(edu.gwu.geometry.Pointd[] points){
    double rangex;
    double rangey;
    double range;
    double minx;
    double miny;
    double maxx;
    double maxy;
    minx=points[0].getx();
    maxx=points[0].getx();
    miny=points[0].gety();
    maxy=points[0].gety();

    for(Pointd cell:points){
      //loop through to find minx and y and max x and y, which will be the outer boudns of grid
      if(cell.getx()<minx){
        minx=cell.getx();
      }
      if(cell.getx()>maxx){
        maxx=cell.getx();
      }
      if(cell.gety()<miny){
        miny=cell.gety();
      }
      if(cell.gety()>maxy){
        maxy=cell.gety();
      }
    }
  //  System.out.println("min and max x and y's are "+ minx + " "+ maxx +" "+miny+" "+maxy);
    rangex=maxx-minx;
    rangey=maxy-miny;

    range=Math.max(rangex,rangey);
    //suppose # of cells =4
    //c is number of cells
    int c=(int)Math.ceil(Math.sqrt(points.length)/2);
    double s=range/c;
    //number of cells
    //create LinkedListcells, i.e. 10 linkedlists
    CellList [] grid = new CellList[(int)Math.pow(c,2)];
    //initialize grid
    for(int i=0;i<grid.length;i++){
      grid[i]=new CellList();
      grid[i].sets(s);
      grid[i].setc(c);
    }
  //  System.out.println("The number of cells is: "+ c+ " with offset" + s);
  System.out.println(s+minx+","+s+miny);
  System.out.println(minx+","+miny);
    //insert points into their cells
    for(Pointd cell:points){
      //find x within grid
    //  System.out.println("in for loop with points "+cell+"the number of cells is "+c+" offset, s, is "+s);
      if(cell.getx()<=(s+minx) && cell.gety()<=(s+miny)){
      //  System.out.println("line 83");
        grid[0].insert(cell);
        System.out.println("inserting into cell 0");
      } else{
        inserttocell(s,c,minx,miny,cell, grid);
      }
    }
    return grid;
  }

public void inserttocell(double s, int c, double minx, double miny, Pointd cell, CellList[] grid){
  int k=0;
  if(cell.getx()<=(s+minx) && cell.gety()<=(s+miny)){
  //  System.out.println("line 83");
  int newdiag=(int)(Math.sqrt(c)+1);
    grid[newdiag].insert(cell);
  //  System.out.println("inserting into cell 0");
  }  else if (cell.getx() <= s + minx && cell.gety() >= s + miny) {
    double a=miny;
    int iter=0;
    while(a<(c*s)){
      if (cell.gety() <= s + a) {
        grid[iter*c].insert(cell);
      }
      iter++;
      a=s+a;
    }
    } else if (cell.getx() >= s + minx && cell.gety() <= s + miny) {
        k = (int)minx;
        while ((double)k < Math.sqrt(c) - 1.0) {
          System.out.println("in while loop with k:" +k +", the point is" +cell+" c is "+ c+" s is"+ s);
            if (cell.getx() <= s + minx) {
                //System.out.println(k);
                grid[k].insert(cell);
                System.out.println("in if"+ cell);
            }
            k++;
        }
    } else if (cell.getx() >=  s + minx && cell.gety() >= s + miny) {
        minx = s + minx;
        miny = s + miny;
        this.inserttocell(s, c, minx, miny, cell, grid);
    }



}


public void	setPropertyExtractor(int algID, edu.gwu.util.PropertyExtractor prop) {

       }
public java.lang.String	getName() {
         return "Christian's Grid";
       }
}
