package sample;

import java.util.LinkedList;

public class ValuesRes
{
    LinkedList<Double> XXres = new LinkedList<Double>();;
    LinkedList<Double> YYres = new LinkedList<Double>();;

    ValuesRes(Values val, ValuesInterpolated valint)
    {
        XXres = val.getXX();
        YYres = val.getYY();
        LinkedList<Double> XXi = valint.getXXi();
        LinkedList<Double> YYi = valint.getYYi();

        for(int i=0;i<XXi.size();i++)
        {
            for(int j=0; j<XXres.size()-1;j++)
            {
                if (XXres.get(j) < XXi.get(i) && XXres.get(j + 1) > XXi.get(i)) {
                    XXres.add(j + 1, XXi.get(i));
                    YYres.add(j + 1, YYi.get(i));
                }
            }
        }




    }


    public LinkedList<Double> getXXres() {
        return XXres;
    }

    public LinkedList<Double> getYYres() {
        return YYres;
    }

}
