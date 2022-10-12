package _JDBC.Gun01;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBCParent {

    @Test
    private void test1() throws SQLException {
    // next(): bir sonraki row
    // previous(): bir önceki row
    // absolute(4): baştan itibaren 4. row a gider, direkt  verilen rowa gider
   // relative(4): bulunduğu noktadan 4 sonraki row a gider.

        ResultSet rs=statement.executeQuery("select * from film");
        rs.absolute(10);//10. satıra gitti
        String title=rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(15);//15. satıra gitti
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(-15);//(-) SONDAN 15. satıra gitti
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(5);//15. satırdan 5 satır gitti
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(-5);//bulunduğu satırdan 5 satır geri gitti
        title=rs.getString("title");
        System.out.println("title = " + title);

    }

}
