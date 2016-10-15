import edu.gwu.algtest.*;
import edu.gwu.debug.*;
import edu.gwu.util.*;
import edu.gwu.algtest.Algorithm;
import edu.gwu.geometry.Pointd;


class main{

  public static void main(String[] args) {
    Pointd[] setofp=new Pointd [5];
    double v=0;
    double distance=0;
    for(int i=0;i<2; i++){
      setofp[i]=new Pointd();
      setofp[i].setx(i+2);
      setofp[i].sety(i-2);
    }

    for(int i=2;i<5; i++){
      setofp[i]=new Pointd();
      setofp[i].setx(i*2);
      setofp[i].sety(i/2);
    }

    Grid g=new Grid();
    for(Pointd set:setofp){
      v++;
      System.out.println("Point " + v+" is "+ "("+set.getx()+","+ set.gety()+")");

    }

      distance=g.findClosestPairDistance(setofp);
      System.out.println(distance);




  }
}
