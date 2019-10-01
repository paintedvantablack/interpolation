package sample;

import java.util.LinkedList;

public class Values
{
    LinkedList<Double> XX = new LinkedList<Double>();;
    LinkedList<Double> YY = new LinkedList<Double>();;

    public void PutIn(double x, double y)
    {
        if(XX.size()>1) {
            for (int i = 0; i < XX.size()-1; i++) {
                if (x > XX.get(XX.size() - 1)) {
                    XX.add(x);
                    YY.add(y);
                } else if (x < XX.get(0)) {
                    XX.addFirst(x);
                    YY.addFirst(y);
                } else if (XX.get(i) < x && XX.get(i + 1) > x) {
                    XX.add(i + 1, x);
                    YY.add(i + 1, y);
                }else if (x == XX.get(i)) {
                    System.out.println("This x already has y"+x);
                    break;
                }
            }
        }
        else
        {
            if(XX.size()==0)
            {
                XX.add(x);
                YY.add(y);
            }else if(XX.size()==1)
            {
                if(x>XX.get(0))
                {
                    XX.add(x);
                    YY.add(y);
                }else if(x<XX.get(0))
                {
                    XX.addFirst(x);
                    YY.addFirst(y);
                }
                else
                {
                    System.out.println("This x already has y");
                }
            }

        }
    }

    public int size()
    {
        return XX.size();
    }

    public LinkedList<Double> getXX() {
        return XX;
    }

    public LinkedList<Double> getYY() {
        return YY;
    }

    public double getXX(int ind)
    {
        return XX.get(ind);
    }

    public double getYY(int ind)
    {
        return YY.get(ind);
    }

    @Override
    public String toString()
    {
        String str="";
        for(int i=0;i<XX.size();i++)
        {
            str = str + XX.get(i) + " | ";
        }
        str+="\n";
        for(int i=0;i<YY.size();i++)
        {
            str = str + YY.get(i) + " | ";
        }

        return str;
    }
}
