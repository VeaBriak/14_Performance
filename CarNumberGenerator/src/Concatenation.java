
public class Concatenation
{
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 20000; i++)
        {
            stringBuilder.append("some text some text some text");
        }

        System.out.println(stringBuilder.toString().length());
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
}
