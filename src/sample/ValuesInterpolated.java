package sample;

import java.util.LinkedList;

public class ValuesInterpolated
{
    LinkedList<Double> XXi = new LinkedList<Double>();
    LinkedList<Double> YYi = new LinkedList<Double>();

    //Итого, после создания сразу получаем готовые узлы интерполяции
    ValuesInterpolated(Values data)
    {
        for(int i=0;i<data.size()-1;++i)
        {
            XXi.add((data.getXX(i)+data.getXX(i+1))/2);
        }

        LinkedList<Double> XX = data.getXX();
        LinkedList<Double> YY = data.getYY();
        //------OK---------------------------------------------------------------


        double g, l;
        for(int i=0;i<this.XXi.size();i++)
        {
            l=0;
            for(int j=0; j<this.XXi.size()+1; j++)
            {
                g=1;
                for(int k=0; k<this.XXi.size()+1; k++)
                {
                    if(j != k)
                        g = g*((XXi.get(i)-XX.get(k))/(XX.get(j)-XX.get(k)));
                }
                l=l+YY.get(j)*g;
            }
            YYi.add(l);
            System.out.println("X = "+XXi.get(i)+"\tY = " + YYi.get(i));
        }
    }

    public LinkedList<Double> getXXi() {
        return XXi;
    }

    public LinkedList<Double> getYYi() {
        return YYi;
    }

    public double getXXi(int ind)
    {
        return XXi.get(ind);
    }

    public double getYYi(int ind)
    {
        return YYi.get(ind);
    }

}
