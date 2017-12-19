
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T4 {
    public static String day = "";
    public static String hour = "";
    public static String minute = "";

    public  String [] getDay(String []v){
        for (int i = 0; i < v[0].length(); i++) {
            if (v[0].charAt(i)>='A'&&v[0].charAt(i)<='Z'){
                for (int j = 0; j < v[1].length(); j++) {
                    if (v[1].charAt(j) == v[0].charAt(i)){
                        switch (v[0].charAt(i)){
                            case 'A':
                                day = "MON";
                                break;
                            case 'B':
                                day = "TUE";
                                break;
                            case 'C':
                                day = "WED";
                                break;
                            case 'D':
                                day = "THU";
                                break;
                            case 'E':
                                day = "FRI";
                                break;
                            case 'F':
                                day = "SAT";
                                break;
                            case 'G':
                                day = "SUN";
                                break;
                            default:
                                day = "Day";
                        }
                    }
                }
                if (day != "Day")
                    break;
            }
            if (day != "Day") {
                v[0].substring(i + 1);
                break;
            }
        }
        return v;
    }

    public void getHour(String []v){
        for (int i = 0; i < v[0].length(); i++) {
            for (int j = 0; j < v[1].length(); j++) {
                if (v[0].charAt(i) == v[1].charAt(j)){
                    switch (v[0].charAt(i)){
                        case '0':
                            hour = "00";
                            break;
                        case '1':
                            hour = "01";
                            break;
                        case '2':
                            hour = "02";
                            break;
                        case '3':
                            hour = "03";
                            break;
                        case '4':
                            hour = "04";
                            break;
                        case '5':
                            hour = "05";
                            break;
                        case '6':
                            hour = "06";
                            break;
                        case '7':
                            hour = "07";
                            break;
                        case '8':
                            hour = "08";
                            break;
                        case '9':
                            hour = "09";
                            break;
                        case 'A':
                            hour = "10";
                            break;
                        case 'B':
                            hour = "11";
                            break;
                        case 'C':
                            hour = "12";
                            break;
                        case 'D':
                            hour = "13";
                            break;
                        case 'E':
                            hour = "14";
                            break;
                        case 'F':
                            hour = "15";
                            break;
                        case 'G':
                            hour = "16";
                            break;
                        case 'H':
                            hour = "17";
                            break;
                        case 'I':
                            hour = "18";
                            break;
                        case 'J':
                            hour = "19";
                            break;
                        case 'K':
                            hour = "20";
                            break;
                        case 'L':
                            hour = "21";
                            break;
                        case 'M':
                            hour = "22";
                            break;
                        case 'N':
                            hour = "23";
                            break;
                        default:
                            hour = "hour";
                            break;
                    }
                }
            }
            if (hour != "hour")
                break;
        }
    }

    public  void getMinute(String []v){
        for (int i = 0; i < v[2].length(); i++) {
            for (int j = 0; j < v[3].length(); j++) {
                if (v[2].charAt(i) == v[3].charAt(j)&&((v[2].charAt(i) >= 'A' && v[2].charAt(i) <= 'Z')
                        || (v[2].charAt(i) >= 'a' && v[2].charAt(i) <= 'z')))
                {
                    if (i<10) {
                        minute = "0" + i;//有用
                        break;
                    }
                    else {
                        minute = "" + i;
                        break;
                    }
                }
            }
            if (minute != ""){
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        String []v = new String[4];
        String []w = new String[2];
        while (num<4){
            v[num] = br.readLine();
            num++;
        }

        T4 a = new T4();
        w = a.getDay(v);
        a.getHour(w);
        a.getMinute(v);
        System.out.println(day + " " + hour + ":" + minute);
    }

}
