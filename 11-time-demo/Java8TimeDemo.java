import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Java8时间API，替代Date SimpleDateFormat
 */
public class Java8TimeDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("date:"+date+" time:"+time+" dateTime:"+dateTime);

        //格式化
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy‑MM‑dd HH:mm:ss");
        String str = dateTime.format(fmt);
        System.out.println("格式化:"+str);

        LocalDateTime parse = LocalDateTime.parse(str,fmt);
        System.out.println("解析:"+parse);

        //时间加减
        LocalDateTime after3Day = dateTime.plus(3, ChronoUnit.DAYS);
        System.out.println("3天后:"+after3Day);

        //时区
        ZonedDateTime zoned = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("带时区时间:"+zoned);
    }
}