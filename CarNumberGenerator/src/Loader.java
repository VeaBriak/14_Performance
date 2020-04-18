import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Loader
{
    public static void main(String[] args)
    {
        for (int i = 1; i <= 3; i++) {
            new CustomThread("numbers" + i).start();
        }

    }
}

class CustomThread extends Thread {

    Thread thread;
    String threadName;
    StringBuffer buffer;

    CustomThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();

        if (thread == null) {
            thread = new Thread(this);
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("res/" + threadName + ".txt");
            char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
            for (int regionCode = 1; regionCode < 100; regionCode++)
            {
                buffer = new StringBuffer();
                for (int number = 1; number < 1000; number++) {
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                buffer.append(firstLetter);
                                buffer.append(padNumber(number, 3));
                                buffer.append(secondLetter);
                                buffer.append(thirdLetter);
                                buffer.append(padNumber(regionCode, 2));
                                buffer.append("\n");
                            }
                        }
                    }
                }
                writer.write(buffer.toString());
            }

            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println((System.currentTimeMillis() - start) + " ms");

    }

    private static StringBuffer padNumber(int number, int numberLength)
    {
        StringBuffer buffer = new StringBuffer();
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();
        for(int i = 0; i < padSize; i++) {
            buffer.append('0' + numberStr);
        }
        return buffer;
    }
}
