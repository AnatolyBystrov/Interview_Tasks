package telran.java_collection;

public class ShootingRating {

    int resultBelowNormal = 4;
    public static int rateShooting(int[] hittingResults) {
        int resultBelowNormal = 4;
        int res = 11;
        int missPercentage = 30;
        int  worstÊesults = (int) Math.ceil(hittingResults.length * missPercentage * 0.01);
        int corrent  = 0;
        for (int i = 0; i<hittingResults.length; i++)
        {
            if (hittingResults[i]<= resultBelowNormal)
            {
                corrent++;
            }

            if (corrent>worstÊesults && hittingResults[i] <= resultBelowNormal)
            {
                res = hittingResults[i];
                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int resultBelow = 4;
        int[] hittingResults = {4, 3, 1, 6, 5, 9, 9, 5, 10, 3};
        if (rateShooting(hittingResults) <= resultBelow) {
            System.out.println("Test failed");
            return;
        }
        System.out.println("Success");
    }
}