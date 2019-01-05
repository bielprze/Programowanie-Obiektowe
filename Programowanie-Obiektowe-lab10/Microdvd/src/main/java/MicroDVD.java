
import java.io.*;
import java.lang.Object;

/**
 * Klasa pozwalająca opóźnić/przyspieszyć napisy do filmu zapisane w formacie MicroDVD
 * @author Przemysław Bielecki
 */

public class MicroDVD {
    private String path_to_file;
    private String output;
    private int ms;
    private int framerate;
    private String line;

    /**
     *
     * @param _path ścieżka do pliku z napisami
     * @param _output ścieżka do opóźnionego/przyspieszonego pliku
     * @param _ms ilość milisekund o które zostaną opóźnione napisy
     * @param _framerate framerate filmu
     */
    public MicroDVD(String _path, String _output, int _ms, int _framerate)
    {
        this.path_to_file = _path;
        this.output = _output;
        this.ms=_ms;
        this.framerate=_framerate;
    }

    public void setLine(String _line)
    {
        line=_line;
    }

    public String getLine()
    {
        return line;
    }

    public int ms_to_frames(int frmrt, int milisecs)
    {
        double fpms = frmrt * 0.001;
        fpms = fpms * milisecs;
        return (int)fpms;
    }
    public void delay_beginning(int wartosc, int frames)
    {
        String tmp1, tmp2;
        tmp1 = Integer.toString(wartosc);
        tmp2 = Integer.toString(wartosc+frames);

        line=line.replace(tmp1, tmp2);
    }

    public void delay_ending(int wartosc, int frames) {
        String tmp1, tmp2;
        tmp1 = Integer.toString(wartosc);
        tmp2 = Integer.toString(wartosc+frames);
        line=line.replace(tmp1, tmp2);
    }


    public void delay() {


        int frames = ms_to_frames(framerate, ms);


        BufferedReader reader;
        // String path = "C:\\Users\\Admin\\Downloads\\gravity.txt";
        String path = path_to_file;
        path = path.replace("\\", "/");
// or
        path = path.replaceAll("\\\\", "/");
        String line2;


        try {
            reader = new BufferedReader(new FileReader(path));
            line = reader.readLine();

            File fout = new File(output);
            FileOutputStream fos = new FileOutputStream(fout);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            int i=1;
            int flag=0;
            int war1=0;
            int war2=0;

            StringBuilder stringBuilder = new StringBuilder();
            String finalString;
           // String tmp1, tmp2, tmp3, tmp4;

            while( line !=null)
            {
                //System.out.println(line);

                while(flag !=2)
                {
                    if(line.charAt(i)<58 && line.charAt(i)>47)
                    {
                        stringBuilder.append(line.charAt(i));
                    }
                    if(line.charAt(i)=='}')
                    {
                        finalString = stringBuilder.toString();
                        stringBuilder = new StringBuilder();
                        flag++;
                        if(flag==1)
                        {
                            war1=Integer.parseInt(finalString);
                        }
                        else if(flag==2)
                        {
                            war2=Integer.parseInt(finalString);
                        }
                    }
                    i++;
                }
                delay_beginning(war1, frames);
                delay_ending(war2, frames);
/*
                tmp1 = Integer.toString(war1);
                tmp2 = Integer.toString(war1+frames);
                tmp3 = Integer.toString(war2);
                tmp4 = Integer.toString(war2+frames);

                line=line.replace(tmp1, tmp2);
                line=line.replace(tmp3, tmp4);*/

                bw.write(line);
                bw.newLine();
                line=reader.readLine();
            }
            reader.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

