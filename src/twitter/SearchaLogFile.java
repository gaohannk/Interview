package twitter;

import java.time.LocalTime;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by gaohan on 10/15/16.
 */
public class SearchaLogFile {
    public Collection<String> search(Collection<String> logLines, LocalTime startDate, LocalTime endDate) {
        boolean flag = false;
        Collection<String> res = new LinkedList<String>();

        for (String line : logLines) {
            if (isNum(line.substring(11, 13))) {
                flag=false;
                int hour = Integer.parseInt(line.substring(11, 13));
                int minute = Integer.parseInt(line.substring(14, 16));
                int second = Integer.parseInt(line.substring(17, 19));
                int totalSec = hour*3600+minute*60+second;
                if(totalSec>=startDate.toSecondOfDay()&& totalSec<=endDate.toSecondOfDay()) {
                    res.add(line);
                    flag = true;
                }
            }else{
                if(flag)
                    res.add(line);
            }
        }
        return res;
    }

    private boolean isNum(String substring) {
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) < '0' || substring.charAt(i) > '9')
                return false;
        }
        return true;
    }
}
